public class Connection {


    private final City city;
    private final int distance;

    public Connection(City city, int distance){
        this.city = city;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public City getCity() {
        return city;
    }




    public String toString(){
        return city.getName();
    }

}
