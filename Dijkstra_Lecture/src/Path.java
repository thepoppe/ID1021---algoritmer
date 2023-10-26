

public class Path implements Comparable<Path>{

    private City city;
    private City prev;
    private Integer dist;

    public void setIndex(Integer index) {
        this.index = index;
    }

    private Integer index;

    public Path(City current, City prev, Integer dist){
        this.city = current;
        this.prev = prev;
        this.dist = dist;
        this.index = null;
    }




    public City getCity() {
        return city;
    }

    public City getPrev() {
        return prev;
    }

    public Integer getDist() {
        return dist;
    }

    public Integer getIndex() {
        return index;
    }

    public void updatePath(Integer dist, City prev) {
        this.dist =dist;
        this.prev = prev;
    }

    @Override
    public int compareTo(Path o) {
        return Integer.compare(this.dist, o.dist);
    }
}
