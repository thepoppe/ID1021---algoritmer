import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Map {

    private City[] cities;
    private final int mod = 541;
    static int collisions = 0;


    public Map(String file) {
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
             return cities[index] = new City(name);
        }

        City city = cities[index];
        if (city.getName().equals(name))
            return city;

        Integer probe = linearSearch(name,index);
        if (probe!=null)
            return cities[probe];

        collisions++;
        probe = findFirstSlot(index);
        return cities[probe] = new City(name);


    }

    private Integer findFirstSlot(int index){
        Integer firstNull = index;
        while (cities[firstNull] != null)
            firstNull++;
        return firstNull;
    }

    private Integer linearSearch(String name, int index) {
        Integer linearProbe = index+1;

        while(cities[linearProbe] !=null){
            if(cities[linearProbe].getName().equalsIgnoreCase(name))
                return linearProbe;
            linearProbe++;
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


    public static void main(String[] args) {
        Map map = new Map("C:\\GIT\\ID1021---algoritmer\\Graphs\\src\\trains.csv");
        System.out.println(collisions);
        System.out.println(map.hash("Strömstad"));
        System.out.println(map.hash("Herrljunga"));

        String[] cities = {
                "Mora",
                "Sveg",
                "Falköping",
                "Boden",
                "Gällivare",
                "Sundsvall",
                "Uppsala",
                "Sala",
                "Storvik",
                "Östersund",
                "Emmaboda",
                "Uddevalla",
                "Helsingborg",
                "Hallsberg",
                "Skövde",
                "Norrköping",
                "Alvesta",
                "Lund",
                "Hässleholm",
                "Fagersta",
                "Katrineholm",
                "Södertälje",
                "Värnamo",
                "Strömstad",
                "Herrljunga",
                "Umeå",
                "Arboga",
                "Jönköping",
                "Ånge",
                "Eskilstuna",
                "Gävle",
                "Luleå",
                "Örebro",
                "Västerås",
                "Åstorp",
                "Göteborg",
                "Mjölby",
                "Nässjö",
                "Borlänge",
                "Kalmar",
                "Stockholm",
                "Kristianstad",
                "Varberg",
                "Malmö",
                "Linköping",
                "Trollhättan",
                "Avesta",
                "Frövi",
                "Karlskrona",
                "Ludvika",
                "Halmstad"};
        ArrayList<Integer> hash = new ArrayList<>();
        for (String s:cities) {
            hash.add(map.hash(s));
        }
        for ( int i=  1; i <= cities.length; i++)
            System.out.print(i+": "+cities[i-1]+", ");


        System.out.println();
        System.out.println(hash);
        for ( int i=  1; i <= cities.length; i++)
            System.out.print(i+",  ");
        System.out.println();
        System.out.println(hash.size());


        System.out.println("Connections to lund");

        map.lookup("Stockholm").printConnections();

        System.out.println("See all");
        for (City city : map.cities)
            if(city!=null){
                System.out.println(city);
            }
    }
}
