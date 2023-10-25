public class Connection {


    public int getDistance() {
        return distance;
    }

    public City getCity() {
        return city;
    }

    private final City city;
    private final int distance;

    public Connection(City city, int distance){
        this.city = city;
        this.distance = distance;
    }

    public String toString(){
        return city.getName();
    }

}
