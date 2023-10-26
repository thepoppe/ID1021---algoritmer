public class PathsWithMax {
    City[] path;
    int sp;
    public PathsWithMax() {
        path = new City[54];
        sp = 0;
    }

    private Integer shortest(City from, City to, Integer max) {

        Integer shrt = null;

        if (from.equals(to))
            return 0;

        if( (max!=null)&&(max < 0)) //Change added from lecture
            return null;            //Change added from lecture

        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        path[sp++] = from;

        City.Node cityNode= from.getFirst();
        while(cityNode!=null){
            Connection connection = cityNode.getConnection();
            City nextCity = connection.getCity();
            Integer time = connection.getDistance();

            Integer nextMax = null;
            if (max!=null)          //Change added from lecture
                nextMax = max-time; //Change added from lecture

            Integer recursionTime = shortest(nextCity, to, nextMax);

            if(recursionTime!=null) {
                if (shrt == null || (recursionTime + time) < shrt){
                    shrt = recursionTime + time;
                    max = shrt; // dynamiskt tillagd på lektionen
                }

            }

            cityNode = cityNode.getNext();

        }
        path[sp--] = null;

        return shrt;
    }

    public static void main(String[] args) {
        Map map = new Map("Graphs/trains.csv");
        PathsWithMax path = new PathsWithMax();
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
        for (Pair pair : pairs) {
            String from = pair.from();
            String to = pair.to();
            long t0 = System.nanoTime();
            Integer dist = path.shortest(map.lookup(from), map.lookup(to), null);
            long time = (System.nanoTime() - t0) / 1_000;
            System.out.println(pair.from() + "->" + pair.to() + "\tshortest: " + dist + " min (" + time + " ms)");




        }

        System.out.println(path.shortest(map.lookup("Gävle"),map.lookup("Sundsvall"),null));
        }




}
