import java.util.ArrayList;
import java.util.List;

public class Main {

    public void warmUp(Dijkstra dijkstra, City startCity, List<City> targetCities, int numberOfRuns) {
        for (City targetCity : targetCities) {
            for (int i = 0; i < numberOfRuns; i++) {
                dijkstra.findShortest(startCity, targetCity);
            }
        }
    }



    public void testShortestPathsToCities(Dijkstra dijkstra, City startCity, List<City> targetCities) {
        for (City targetCity : targetCities) {
            long minT = Long.MAX_VALUE;

            Integer distance = -1;
            double doneSize = -1;
            double logArraySize = -1;
            double timeComplexity = -1;
            double timePerArraySize = -1;
            for (int i = 0; i < 100; i++) {
                long t0 = System.nanoTime();
                distance = dijkstra.findShortest(startCity, targetCity);
                long endt1Time = System.nanoTime();
                long elapsedTimeMicroseconds = (endTime - t0);

                minT = Math.min(minT, elapsedTimeMicroseconds);

                doneSize = dijkstra.getDoneArraySize();

                // Calculate the time complexity
                timeComplexity = minT / (doneSize * Math.log(doneSize));

                // Calculate the execution time divided by the size of the "done" array
                timePerArraySize = (double) minT / doneSize;
            }

            System.out.printf("%12s", targetCity.getName());
            System.out.printf("\tdist: %5d min", distance);
            System.out.printf("\tMin Time: %5d us", minT);
            System.out.printf("\tSize: %5.0f", doneSize);
            System.out.printf("\t\tMin T/sizeLogSize: %.0f", timeComplexity);
            System.out.printf("\tMin Time/Size: %.0f\n", timePerArraySize);

        }
    }


    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        Map map = new Map("Dijkstra/europe.csv");

        City startCity = map.lookup("Köpenhamn");

        List<City> targetCities = new ArrayList<>();
        targetCities.add(map.lookup("Rom"));
        targetCities.add(map.lookup("Seinäjoki"));
        targetCities.add(map.lookup("Barcelona"));
        targetCities.add(map.lookup("Helsingfors"));
        targetCities.add(map.lookup("Umeå"));
        targetCities.add(map.lookup("London"));
        targetCities.add(map.lookup("Paris"));
        targetCities.add(map.lookup("Amsterdam"));
        targetCities.add(map.lookup("Leipzig"));
        targetCities.add(map.lookup("Oslo"));
        targetCities.add(map.lookup("Berlin"));
        targetCities.add(map.lookup("Hamburg"));

        Main testClass = new Main();

        int numberOfWarmUpRuns = 10000;

        System.gc();
        // Warm-up phase
        testClass.warmUp(dijkstra, startCity,targetCities, numberOfWarmUpRuns);

        // Main test phase
        testClass.testShortestPathsToCities(dijkstra, startCity, targetCities);
    }



}
