public class Paths {

    City[] path;
    int sp;
    public Paths() {
        path = new City[54];
        sp = 0;
    }

    private Integer shortest(City from, City to) {

        Integer shrt = null;

        City.Node cityNode= from.getFirst();

        if (from.equals(to))
                return 0;
        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
            }

        path[sp++] = from;
        while(cityNode!=null){
            Connection connection = cityNode.getConnection();
            cityNode = cityNode.getNext();
            City nextCity = connection.getCity();
            Integer time = connection.getDistance();
            Integer recursionTime = shortest(nextCity, to);
            if(recursionTime!=null) {
                if (shrt == null || (recursionTime + time) < shrt)
                    shrt = recursionTime + time;
                }

        }
        path[sp--] = null;

        return shrt;
    }


    public static void main(String[] args) {
        Map map = new Map("Graphs/trains.csv");
        Paths path = new Paths();

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
            Integer dist = path.shortest(map.lookup(from), map.lookup(to));
            long time = (System.nanoTime() - t0) / 1_000;
            System.out.println(pair.from() + "->" + pair.to() + "\tshortest: " + dist + " min (" + time + " ms)");
        }
    }


}
