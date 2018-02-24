public class ShortList implements Comparable<ShortList>{
    public Coordinates how;
    public Coordinates prev;
    public int DistanceToFinish;

    public ShortList(Coordinates how, Coordinates prev, int DistanceToFinish){
        this.how = how;
        this.prev = prev;
        this.DistanceToFinish = DistanceToFinish;
    }

    @Override
    public int compareTo(ShortList o) {
        return this.DistanceToFinish - o.DistanceToFinish;
    }
}


