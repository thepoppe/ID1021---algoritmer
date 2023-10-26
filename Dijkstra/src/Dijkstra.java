import java.util.*;
import java.util.Map;

public class Dijkstra {
    private PriorityQueue queue;
    private ArrayList<Path> done; // hashmap is probably better

    private HashMap<Integer, Path> newDone;



    public Dijkstra(){
        queue = new PriorityQueue();
        done = new ArrayList<>();
        newDone = new HashMap<>();
    }


    public Integer findShortest(City sourceCity, City targetCity) {
        queue.clear();
        done.clear();
        newDone.clear();

        var processed = new HashMap<Integer, Path>();
        queue.add(new Path(sourceCity, null, 0));



        while (!queue.isEmpty()){

            //remove first entry
            Path current = queue.poll();
            City currentCity = current.getCity();
            Integer currentDist = current.getDist();

            //otherwise add it to processed set
            newDone.put(currentCity.getId(),current);


            //if it's the destination break. Doesn't work. PROBAbly works now with ok prio queue
            if (currentCity == targetCity){
                return newDone.get(targetCity.getId()).getDist();
            }

            //done previously here




            //for each connection
            for (Connection connection : currentCity.getNeighbours()){

                City connectedCity = connection.getCity();
                Integer connectedDist = connection.getDistance();

                Integer newDist = currentDist + connectedDist;

                //måste kolla i done först. Borde kanske returnera path
                Path visitedPath = alreadyVisited(connectedCity);
                if(visitedPath != null){
                    if(visitedPath.getDist() > newDist)
                        visitedPath.updatePath(newDist, currentCity);
                    continue;
                }

               //bättre sätt??? kan finnas dubbletter annars se onenote
                Path path = null;
                if(processed.containsKey(connectedCity.getId()))
                    path = processed.get(connectedCity.getId());

                //If a path city is found in the queue (if its index is not null), update
                // if possible the shortest path to that city and update the queue.
                if(path != null && path.getIndex()!= null){

                    if(newDist < path.getDist()) {
                        queue.updatePath(path, newDist, currentCity);

                        //rearrange queue, this is done automatically for Priority Queue if the datatype uses "Comparable"

                    }
                }
                    //If the city is not found in the queue, add a new path to the queue.
                else {
                    Path processedPath = new Path(connectedCity, currentCity, newDist);
                    queue.add(processedPath);
                    processed.put(connectedCity.getId(), processedPath);
                }


            }
        }

        return null;
    }

    private Path alreadyVisited(City connectedCity) {
        if (newDone.containsKey(connectedCity.getId())){
             return newDone.get(connectedCity.getId());
        }
        return null;
    }





}
