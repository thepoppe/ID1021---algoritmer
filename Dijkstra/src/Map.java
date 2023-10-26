import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Map {

    private City[] cities;
    private final int mod = 541;
    private int idCounter;


    public Map(String file) {
        idCounter = 0;
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                String from = row[0];
                String to =  row[1];
                int distance = Integer.valueOf(row[2]);

                City first = lookup(from);
                City second = lookup(to);
                first.connect(new Connection(second, distance));
                second.connect(new Connection(first, distance));

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(" file " + file + " not found or corrupt");
        } catch (IOException e) {
            throw new RuntimeException("IO exception");
        }
    }



    City lookup(String name){
        int index = hash(name);
        if(cities[index]== null) {
             return cities[index] = new City(name, idCounter++);
        }

        City city = cities[index];
        if (city.getName().equals(name))
            return city;

        Integer probe = linearSearch(name,index);
        if (probe!=null)
            return cities[probe];

        probe = findFirstSlot(index);
        return cities[probe] = new City(name, idCounter++);

    }
    private Integer findFirstSlot(int index){
        Integer firstNull = index;
        while (cities[firstNull] != null)
            firstNull = (firstNull+1) %mod;
        return firstNull;
    }
    private Integer linearSearch(String name, int index) {
        Integer linearProbe = index+1;

        while(cities[linearProbe] !=null){
            if(cities[linearProbe].getName().equalsIgnoreCase(name))
                return linearProbe;
            linearProbe = (linearProbe+1)%mod;
        }
        return null;
    }
    private Integer hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

}
