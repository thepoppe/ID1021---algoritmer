import java.util.PriorityQueue;

public class Dijkstra {

    Path[] done;
    PriorityQueue<Path> queue;
    Map map;

    public Dijkstra(Map map){
        int n = map.getIdCounter()+1;
        done = new Path[n];
        //använd id som index i done
        queue = new PriorityQueue<>();
    }
    //en förbättring är att spara all information so far till så gott som instant
    //Dijkstras är n log n complexitet


    public int dist(City city){
        if(city!=null && done[city.getId()])
            //do somethin

    }


    public void search(City from, City dest){
        Path ex = new Path(from,);
        queue.add(ex);
        shortest(dest);
    }

    private void shortest(City dest) {
        while (!queue.isEmpty()){

            Path entry = queue.remove();

            City city = entry.getCity();

            if(done[city.getId()] == null)
                done[city.getId()] = entry;


            //mer kod?


            if( city == dest)
                break;

            Integer soFar = entry.getDist();


            for (Connection c : city.getNeighbours()){
                City to = c.getCity();
                if(done[to.getId()] == null){
                    Path ex = new Path(to,city,soFar + c.getDistance());
                    queue.add(ex);

                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 1){


        }


        for (City prev = dest; prev !=null; prev = ){
            System.out.print(prev.getName()+ "");
        }
    }


}
