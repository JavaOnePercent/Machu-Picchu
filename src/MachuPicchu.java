import java.util.*;
import static java.lang.Math.*;

public class MachuPicchu {
    private int m1, n1, m2, n2, m3, n3;
    private int p = 1;
    //ComparatorList comparatorList = new ComparatorList();
    private Queue<ShortList> queue = new PriorityQueue<ShortList>(/*comparatorList*/);
    //private Set<ShortList> queue = new HashSet<ShortList>();
    //private HashMap<Integer, ShortList> list = new HashMap<Integer, ShortList>();
    //private Set<ShortList> list = new HashSet<ShortList>();
    private List<ShortList> list = new ArrayList<ShortList>();
    /*private char A[][] = {{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '@', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '.', '.', 'X', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}};*/
    private char A[][] = {{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', 'X', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'@', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}};
    /*private char A[][] = {{'.', '.', '.', '.', '@'},
                          {'#', '.', '#', '#', '#'},
                          {'.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', 'X'},
                          {'.', '.', '.', '.', '.'}};*/
    private int B[][] = {{ -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
                          {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};
    /*private char C[][] = {{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '#', '#', '#', '#', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '@', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '#', '.', '.', 'X', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}};*/
    private char C[][] = {{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', 'X', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '.'},
                          {'@', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                          {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}};
    public void Path() {
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A.length; j++) {
                if (A[i][j] == '@') {
                    m1 = i;
                    n1 = j;
                }
                else if (A[i][j] == 'X') {
                    m2 = i;
                    n2 = j;
                }
            }
        queue.add(new ShortList(new Coordinates(m1, n1), new Coordinates(-1, -1), (abs(m1 - m2) + abs(n1 - n2) + abs(m1 - m1) + abs(n1 - n1))));
        list.add(new ShortList(new Coordinates(m1, n1), new Coordinates(-1, -1), (abs(m1 - m2) + abs(n1 - n2) + abs(m1 - m1) + abs(n1 - n1))));
        B[m1][n1] = abs(m1 - m2) + abs(n1 - n2) + abs(m1 - m1) + abs(n1 - n1);
        while(!queue.isEmpty() && !((list.get(list.size() - 1).how.x == m2 && list.get(list.size() - 1).how.y == n2))) {
            Search();
            /*for (int i = 0; i < list.size(); i++)
                System.out.println(list.get(i).x + " " + list.get(i).y + " " + list.get(i).DistanceToFinish);*/
            /*for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < C.length; j++) {
                    System.out.print(C[i][j]);
                }
                System.out.println();
            }
            System.out.println();*/

        }
        /*for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println();
        }*/
        //System.out.println();
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B.length; j++) {
                System.out.print(B[i][j]);
            }
            System.out.println();
        }
        for (int i = list.size() - 1; i >= 1; --i) {
                if(list.get(i).how.x == m3 && list.get(i).how.y == n3){
                    if(!(m3 == m2 && n3 == n2))
                        A[list.get(i).how.x][list.get(i).how.y] = '+';
                    m3 = list.get(i).prev.x;
                    n3 = list.get(i).prev.y;
                }
            }
        /*while(A[m1][n1] != '+') {
            for (int i = list.size() - 1; i >= 1; --i) {
                if (list.get(i).how.x == m3 && list.get(i).how.y == n3) {
                    A[list.get(i).how.x][list.get(i).how.y] = '+';
                    m3 = list.get(i).prev.x;
                    n3 = list.get(i).prev.y;
                }
            }
        }*/


        /*ListIterator<ShortList> iterator = list.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().c + " " + iterator.next().d + " " + iterator.next().e);
        }
        while(iterator.hasPrevious()){
            System.out.println(iterator.previous().c + " " + iterator.previous().d + " " + iterator.previous().e);
        }*/
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                System.out.print(A[i][j]);
            }
            System.out.println();
        }
        /*for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                System.out.print(C[i][j]);
            }
            System.out.println();
        }*/
        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).how.x + " " + list.get(i).how.y + " " + list.get(i).prev.x + " " + list.get(i).prev.y + " " + list.get(i).DistanceToFinish);
        //System.out.println(queue.peekLast().c + " " + queue.peekLast().d + " " + queue.peekLast().e);
        /*for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i).c + " " + list.get(i).d + " " + list.get(i).e);*/

        /*while (queue.size() > 0) {
            System.out.println("[ " + queue.poll().c + " " + queue.poll().d + " " + queue.poll().e + " ]");
        }*/
        /*Iterator<ShortList> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().c + " " + iterator.next().d + " " + iterator.next().e);
        }*/
        //list.add(new ShortList(12, n, p));
        //System.out.print(list.get(0).c);
    }
    void Search() {
        ShortList sl = queue.poll();
        if (sl.how.x > 0) {
            if (A[sl.how.x - 1][sl.how.y] == '.' || A[sl.how.x - 1][sl.how.y] == 'X') {
                boolean j = true;
                for (int i = 0; i < list.size(); i++)
                    if (list.get(i).how.x == sl.how.x - 1 && list.get(i).how.y == sl.how.y && list.get(i).DistanceToFinish == (abs(sl.how.x - 1 - m2) + abs(sl.how.y - n2) + abs(sl.how.x - 1 - m1) + abs(sl.how.y - n1)))
                        j = false;
                /*Iterator<ShortList> iterator = queue.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().x == sl.x - 1 && iterator.next().y == sl.y && iterator.next().DistanceToFinish == (abs(sl.x - 1 - m2) + abs(sl.y - n2) + abs(sl.x - 1 - m1) + abs(sl.y - n1)))
                        j = false;
                }*/
                if (j) {
                    queue.add(new ShortList(new Coordinates(sl.how.x - 1, sl.how.y), new Coordinates(sl.how.x, sl.how.y), abs(sl.how.x - 1 - m2) + abs(sl.how.y - n2) + abs(sl.how.x - 1 - m1) + abs(sl.how.y - n1)));
                    //System.out.println((sl.x - 1) + " " + sl.y + " " + (abs(sl.x - 1 - m2) + abs(sl.y - n2) + abs(sl.x - 1 - m1) + abs(sl.y - n1)));
                    B[sl.how.x - 1][sl.how.y] = abs(sl.how.x - 1 - m2) + abs(sl.how.y - n2) + abs(sl.how.x - 1 - m1) + abs(sl.how.y - n1);
                    C[sl.how.x - 1][sl.how.y] = '+';
                }
            }
        }
        if (sl.how.y > 0) {
            if (A[sl.how.x][sl.how.y - 1] == '.' || A[sl.how.x][sl.how.y - 1] == 'X') {
                boolean j = true;
                for (int i = 0; i < list.size(); i++)
                    if (list.get(i).how.x == sl.how.x && list.get(i).how.y == sl.how.y - 1 && list.get(i).DistanceToFinish == (abs(sl.how.x - m2) + abs(sl.how.y - 1 - n2) + abs(sl.how.x - m1) + abs(sl.how.y - 1 - n1)))
                        j = false;
                /*Iterator<ShortList> iterator = queue.iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().x == sl.x && iterator.next().y == sl.y - 1 && iterator.next().DistanceToFinish == (abs(sl.x - m2) + abs(sl.y - 1 - n2) + abs(sl.x - m1) + abs(sl.y - 1 - n1)))
                        j = false;
                }*/
                    if (j) {
                        queue.add(new ShortList(new Coordinates(sl.how.x, sl.how.y - 1), new Coordinates(sl.how.x, sl.how.y), abs(sl.how.x - m2) + abs(sl.how.y - 1 - n2) + abs(sl.how.x - m1) + abs(sl.how.y - 1 - n1)));
                        //System.out.println(sl.x + " " + (sl.y - 1) + " " + (abs(sl.x - m2) + abs(sl.y - 1 - n2) + abs(sl.x - m1) + abs(sl.y - 1 - n1)));
                        B[sl.how.x][sl.how.y - 1] = abs(sl.how.x - m2) + abs(sl.how.y - 1 - n2) + abs(sl.how.x - m1) + abs(sl.how.y - 1 - n1);
                        C[sl.how.x][sl.how.y - 1] = '+';
                    }
                }
            }
            if (sl.how.x < A.length - 1) {
                if (A[sl.how.x + 1][sl.how.y] == '.' || A[sl.how.x + 1][sl.how.y] == 'X') {
                    boolean j = true;
                    for (int i = 0; i < list.size(); i++)
                        if (list.get(i).how.x == sl.how.x + 1 && list.get(i).how.y == sl.how.y && list.get(i).DistanceToFinish == (abs(sl.how.x + 1 - m2) + abs(sl.how.y - n2) + abs(sl.how.x + 1 - m1) + abs(sl.how.y - n1)))
                            j = false;
                    /*Iterator<ShortList> iterator = queue.iterator();
                    while (iterator.hasNext()) {
                        if (iterator.next().x == sl.x + 1 && iterator.next().y == sl.y && iterator.next().DistanceToFinish == (abs(sl.x + 1 - m2) + abs(sl.y - n2) + abs(sl.x + 1 - m1) + abs(sl.y - n1)))
                            j = false;
                    }*/
                    if (j) {
                        queue.add(new ShortList(new Coordinates(sl.how.x + 1, sl.how.y), new Coordinates(sl.how.x, sl.how.y), abs(sl.how.x + 1 - m2) + abs(sl.how.y - n2) + abs(sl.how.x + 1 - m1) + abs(sl.how.y - n1)));
                        //System.out.println((sl.x + 1) + " " + sl.y + " " + (abs(sl.x + 1 - m2) + abs(sl.y - n2) + abs(sl.x + 1 - m1) + abs(sl.y - n1)));
                        B[sl.how.x + 1][sl.how.y] = abs(sl.how.x + 1 - m2) + abs(sl.how.y - n2) + abs(sl.how.x + 1 - m1) + abs(sl.how.y - n1);
                        C[sl.how.x + 1][sl.how.y] = '+';
                    }
                }
            }
            if (sl.how.y < A.length - 1) {
                if (A[sl.how.x][sl.how.y + 1] == '.' || A[sl.how.x][sl.how.y + 1] == 'X') {
                    boolean j = true;
                    for (int i = 0; i < list.size(); i++)
                        if (list.get(i).how.x == sl.how.x && list.get(i).how.y == sl.how.y + 1 && list.get(i).DistanceToFinish == (abs(sl.how.x - m2) + abs(sl.how.y + 1 - n2) + abs(sl.how.x - m1) + abs(sl.how.y + 1 - n1)))
                            j = false;
                    /*Iterator<ShortList> iterator = queue.iterator();
                    while (iterator.hasNext()) {
                        if (iterator.next().x == sl.x && iterator.next().y == sl.y + 1 && iterator.next().DistanceToFinish == (abs(sl.x - m2) + abs(sl.y + 1 - n2) + abs(sl.x - m1) + abs(sl.y + 1 - n1)))
                            j = false;
                    }*/
                    if (j) {
                        queue.add(new ShortList(new Coordinates(sl.how.x, sl.how.y + 1), new Coordinates(sl.how.x, sl.how.y), abs(sl.how.x - m2) + abs(sl.how.y + 1 - n2) + abs(sl.how.x - m1) + abs(sl.how.y + 1 - n1)));
                        //System.out.println(sl.x + " " + (sl.y + 1) + " " + (abs(sl.x - m2) + abs(sl.y + 1 - n2) + abs(sl.x - m1) + abs(sl.y + 1 - n1)));
                        B[sl.how.x][sl.how.y + 1] = abs(sl.how.x - m2) + abs(sl.how.y + 1 - n2) + abs(sl.how.x - m1) + abs(sl.how.y + 1 - n1);
                        C[sl.how.x][sl.how.y + 1] = '+';
                    }
                }
            }
            boolean j = true;
            for (int i = 0; i < list.size(); i++)
                if (list.get(i).how.x == sl.how.x && list.get(i).how.y == sl.how.y && list.get(i).DistanceToFinish == sl.DistanceToFinish) {
        /*while(iterator.hasNext()) {
            if (iterator.next().c == sl.c && iterator.next().d == sl.d && iterator.next().e == sl.e) j = false;
        }*/
                    j = false;
            }
            if (j) {
                list.add(new ShortList(new Coordinates(sl.how.x, sl.how.y), new Coordinates(sl.prev.x, sl.prev.y), sl.DistanceToFinish));
                m3 = sl.how.x;
                n3 = sl.how.y;

            /*A[sl.x][sl.y] = '+';
            for (int i = 0; i < A.length; i++) {
                for (int k = 0; k < A.length; k++) {
                    System.out.print(A[i][k]);
                }
                System.out.println();
            }
            System.out.println();*/}
    }
}
