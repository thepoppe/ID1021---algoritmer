
public class Naive {

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;

        Integer shrt = null;
        City.Node cityNode= from.getFirst();

        while(cityNode!=null){
            Connection connection = cityNode.getConnection();
            cityNode = cityNode.getNext();
            City nextCity = connection.getCity();
            Integer time = connection.getDistance();

            Integer recursionTime = shortest(nextCity, to, max-time);


            if(recursionTime!=null) {
                if (shrt == null || (recursionTime + time) < shrt){
                    shrt = recursionTime + time;
                    //max =shrt; // dynamiskt tillagd påå lektionen
                }
            }
        }

        return shrt;
    }

    public static void main(String[] args) {
        Map map = new Map("Graphs/europe.csv");
        Pair[] pairs = {
                new Pair("Malmö", "Göteborg", 200),
                new Pair("Göteborg", "Stockholm", 250),
                new Pair("Malmö", "Stockholm", 300),
                new Pair("Stockholm", "Sundsvall", 350),
                new Pair("Stockholm", "Umeå", 520),
                new Pair("Göteborg", "Sundsvall", 520),
                new Pair("Sundsvall", "Umeå", 200),
                new Pair("Umeå", "Göteborg", 720),
                new Pair("Göteborg", "Umeå", 720)
        };


        for (Pair pair : pairs){
             String from = pair.from();
             String to = pair.to();
             Integer max = pair.maxTime();
             long t0 = System.nanoTime();
             Integer dist = shortest(map.lookup(from), map.lookup(to), max);
             long time = (System.nanoTime() - t0)/1_000;
            System.out.println(pair.from() +"->"+ pair.to()+"\tshortest: " + dist + " min (" + time + " us)");
        }




    }




}
