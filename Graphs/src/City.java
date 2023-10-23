import java.util.ArrayList;

public class City {

    private final String name;
    private Node first;
    private int numberOfConnections;

    public String getName() {
        return name;
    }

    public int getNumberOfConnections() {
        return numberOfConnections;
    }

    public boolean hasConnection(){
        return (first!= null);
    }

    public Node getFirst() {
        return first;
    }

    class Node{
        private Node next;

        public Node getNext() {
            return next;
        }

        public Connection getConnection() {
            return connection;
        }

        private final Connection connection;

        private Node(Connection connection){
            this.connection = connection;
            this.next = null;
        }
    }

    public String toString(){
        return this.name;
    }

    public City(String name){
        this.name = name;
        this.numberOfConnections =0;
    }

    public void connect(Connection connection) {
        numberOfConnections++;

        if (first == null)
            first = new Node(connection);
        else{
            Node node = first;
            while ( node.next != null )
                node = node.next;
            node.next = new Node(connection);
        }
    }

    public void printConnections(){

            String connections ="";
            Node node = first;
            while(node.next != null){
                connections += node.connection.getCity().name;
                connections +=", ";
                node = node.next;
            }
            connections += node.connection.getCity().name;

            System.out.println(connections);


    }




}

