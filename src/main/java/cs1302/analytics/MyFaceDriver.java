package cs1302.analytics;
import cs1302.sorting.*;
import cs1302.myface.*;
import java.util.*;
public class MyFaceDriver
{
    public static void main(String[] args)
        {
            // generate myface users
            MyFace socialNetwork = new MyFace(1000);
            MyFaceUser[] users = socialNetwork.getUsers().stream().toArray(MyFaceUser[]::new);
            System.out.printf("MyFace user count: %d\n", users.length);
            
// setup sorting algorithm
            Comparator<Integer> c = Integer::compareTo;
            Swapper<Integer> s = Swapper.getStandardSwapper();
            Integer[] a = new Integer[] { 3, 6, 1, 32, 9, 2 };
            Sort<Integer> sort = new BubbleSort<>(a, 0, a.length - 1, c, s);
            sort.printStats();
            sort.printSorted();
        }
}
