public class ShortList implements Comparable<ShortList>{
    public Coordinates now;
    public Coordinates prev;
    public int cost;

    public ShortList(Coordinates now, Coordinates prev, int cost){
        this.now = now;
        this.prev = prev;
        this.cost = cost;
    }

    @Override
    public int compareTo(ShortList o) {
        return this.cost - o.cost;
    }
}


