import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra3 {

        private PriorityQueue queue;
        private ArrayList<Path> done; // hashmap is probably better

        private HashMap<Integer, Path> newDone;



        public Dijkstra3(){
            queue = new PriorityQueue();
            done = new ArrayList<>();
            newDone = new HashMap<>();
        }


        public Integer findShortest(City sourceCity, City targetCity) {
            queue.clear();
            done.clear();
            newDone.clear();

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
                    if(visitedPath != null) {
                        if (visitedPath.getIndex() == null && visitedPath.getDist() > newDist) {
                            visitedPath.updatePath(newDist, currentCity);
                            continue;
                        }
                        if(visitedPath.getIndex()!=null && visitedPath.getDist()> newDist){
                            queue.updatePath(visitedPath, newDist, currentCity);
                        }

                    }
                    else{
                        Path processedPath = new Path(connectedCity, currentCity, newDist);
                        queue.add(processedPath);
                        newDone.put(connectedCity.getId(), processedPath);
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


