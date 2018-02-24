import java.util.Comparator;

public class ComparatorList implements Comparator<ShortList> {
    @Override
    public int compare(ShortList o1, ShortList o2) {
        return o2.DistanceToFinish - o1.DistanceToFinish;
    }
}
