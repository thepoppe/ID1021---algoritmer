import java.util.ArrayList;

public class City {

    private final String name;
    private ArrayList<Connection> neighbours;
    private Integer id;


    public ArrayList<Connection> getNeighbours() {
        return neighbours;
    }
    public String getName() {
        return name;
    }
    public String toString(){
        return this.name;
    }
    public Integer getId() {
        return id;
    }

    public City(String name, int id){
        this.name = name;
        this.id = id;
        neighbours = new ArrayList<>();
    }

    public void connect(Connection connection) {
        neighbours.add(connection);
    }






    public void printNeighbors(){
        for (Connection c: neighbours) {
            System.out.println(this.name + ": "+c.getCity()+", "+ c.getDistance());

        }
    }
}

