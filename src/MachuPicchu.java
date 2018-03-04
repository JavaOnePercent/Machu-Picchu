import java.util.*;
import static java.lang.Math.*;

public class MachuPicchu implements Navigator{
    private int m1, n1, m2, n2, m3, n3;
    private Queue<ShortList> queue = new PriorityQueue<ShortList>();
    private List<ShortList> list = new ArrayList<ShortList>();
    @Override
    public char[][] searchRoute(char[][] map) {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == '@') {
                    m1 = i;
                    n1 = j;
                } else if (map[i][j] == 'X') {
                    m2 = i;
                    n2 = j;
                }
            }
        queue.add(new ShortList(new Coordinates(m1, n1), new Coordinates(-1, -1), (abs(m1 - m2) + abs(n1 - n2) + abs(m1 - m1) + abs(n1 - n1))));
        list.add(new ShortList(new Coordinates(m1, n1), new Coordinates(-1, -1), (abs(m1 - m2) + abs(n1 - n2) + abs(m1 - m1) + abs(n1 - n1))));
        while (!queue.isEmpty() && !((list.get(list.size() - 1).now.x == m2 && list.get(list.size() - 1).now.y == n2))) {
            Assay(map);
        }
        if (m2 != m3 && n2 != n3)
            return null;
        else {
            int p = 1;
            for (int i = list.size() - 1; i >= 1; --i) {
                if (list.get(i).now.x == m3 && list.get(i).now.y == n3) {
                    if (!(m3 == m2 && n3 == n2) && (abs(m2 - m3) + abs(n2 - n3)) == p) {
                        map[list.get(i).now.x][list.get(i).now.y] = '+';
                        p++;
                    }
                    m3 = list.get(i).prev.x;
                    n3 = list.get(i).prev.y;
                }
            }
            return map;
        }
    }
    void Assay(char map[][]) {
        ShortList sl = queue.poll();
        if (sl.now.x > 0)
            AddQueue(sl.now.x - 1, sl.now.y, sl.now.x, sl.now.y, map);
        if (sl.now.y > 0)
            AddQueue(sl.now.x, sl.now.y - 1, sl.now.x, sl.now.y, map);
        if (sl.now.x < map.length - 1)
            AddQueue(sl.now.x + 1, sl.now.y, sl.now.x, sl.now.y, map);
        if (sl.now.y < map.length - 1)
            AddQueue(sl.now.x, sl.now.y + 1, sl.now.x, sl.now.y, map);
        boolean j = true;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).now.x == sl.now.x && list.get(i).now.y == sl.now.y && list.get(i).cost == sl.cost) {
                j = false;
                break;
            }
        }
        if (j) {
            list.add(new ShortList(new Coordinates(sl.now.x, sl.now.y), new Coordinates(sl.prev.x, sl.prev.y), sl.cost));
            m3 = sl.now.x;
            n3 = sl.now.y;
        }
    }
    void AddQueue(int x1, int y1, int x2, int y2, char map[][]){
        if (map[x1][y1] == '.' || map[x1][y1] == 'X') {
            boolean j = true;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).now.x == x1 && list.get(i).now.y == y1 && list.get(i).cost == (abs(x1 - m2) + abs(y1 - n2) + abs(x1 - m1) + abs(y1 - n1))) {
                    j = false;
                    break;
                }
            }
            if (j)
                queue.add(new ShortList(new Coordinates(x1, y1), new Coordinates(x2, y2), abs(x1 - m2) + abs(y1 - n2) + abs(x1 - m1) + abs(y1 - n1)));
        }
    }
}