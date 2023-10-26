public class Main {

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        Map map = new Map("Dijkstra/europe.csv");


        TestPath[] tests = {
                new TestPath(map.lookup("Malmö"), map.lookup("Göteborg")),
                new TestPath(map.lookup("Göteborg"), map.lookup("Stockholm")),
                new TestPath(map.lookup("Malmö"), map.lookup("Stockholm")),
                new TestPath(map.lookup("Stockholm"), map.lookup("Sundsvall")),
                new TestPath(map.lookup("Stockholm"), map.lookup("Umeå")),
                new TestPath(map.lookup("Göteborg"), map.lookup("Sundsvall")),
                new TestPath(map.lookup("Sundsvall"), map.lookup("Umeå")),
                new TestPath(map.lookup("Umeå"), map.lookup("Göteborg")),
                new TestPath(map.lookup("Göteborg"), map.lookup("Umeå")),
                new TestPath(map.lookup("Umeå"), map.lookup("Barcelona")),
                new TestPath(map.lookup("Glasgow"), map.lookup("Rom"))
        };


        for (TestPath test : tests) {
            City from = test.from();
            City to = test.to();
            long t0 = System.nanoTime();
            Integer dist = dijkstra.findShortest(from, to);
            long time = (System.nanoTime() - t0) / 1_000;
            System.out.println(test.from() + "->" + test.to() + "\tshortest: " + dist + " min (" + time + " us)");
        }





        System.out.println(dijkstra.findShortest(map.lookup("Göteborg"),map.lookup("Sundsvall")));

    }
}
