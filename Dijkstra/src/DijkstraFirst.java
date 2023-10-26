import java.util.ArrayList;

public class DijkstraFirst {

    private PriorityQueue queue;
    private ArrayList<Path> done; // hashmap is probably better


    public DijkstraFirst(){
        queue = new PriorityQueue();
        done = new ArrayList<>();
    }


    public Integer findShortest(City sourceCity, City targetCity) {
        queue.clear();
        done.clear();

        queue.add(new Path(sourceCity, null, 0));
        Integer targetIndex = null;

        while (!queue.isEmpty()){

            //remove first entry
            Path current = queue.poll();
            City currentCity = current.getCity();

            Integer currentDist = current.getDist();

            //otherwise add it to processed set
            done.add(current);


            //if it's the destination break. Doesn't work. PROBAbly works now with ok prio queue
            if (currentCity == targetCity){
                //return currentDist;
                targetIndex = done.size()-1;
                break;
            }

            //done previously here



            //for each connection
            for (Connection connection : currentCity.getNeighbours()){
                City connectedCity = connection.getCity();
                Integer connectedDist = connection.getDistance();

                Integer newDist = currentDist + connectedDist;

                //måste kolla i done först. Borde kanske returnera path
                Path visitedPath =alreadyVisited(connectedCity);
                if(visitedPath != null){
                    if( visitedPath.getDist() > newDist)
                        visitedPath.updatePath(newDist, currentCity);
                    continue;
                }

                //bättre sätt??? kan finnas dubbletter annars se onenote
                Path path = queue.contains(connectedCity);

                //If a path city is found in the queue (if its index is not null), update
                // if possible the shortest path to that city and update the queue.
                if(path!= null){


                    if(newDist < path.getDist()) {
                        queue.updatePath(path, newDist, currentCity);

                        //rearrange queue, this is done automatically for Priority Queue if the datatype uses "Comparable"

                    }
                }
                //If the city is not found in the queue, add a new path to the queue.
                else queue.add(new Path(connectedCity, currentCity, newDist));


            }
        }

        return ( targetIndex != null) ? done.get(targetIndex).getDist() : targetIndex;
    }

    private Path alreadyVisited(City connectedCity) {
        for ( Path path : done)
            if(path.getCity().equals(connectedCity))
                return path;
        return null;
    }




}
