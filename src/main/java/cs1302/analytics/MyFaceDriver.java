package cs1302.analytics;
import cs1302.sorting.*;
import cs1302.myface.*;
import java.util.*;
public class MyFaceDriver
{
    public static void main(String[] args)
        {
            // generate myface users
            MyFace socialNetwork = new MyFace(10000);
            MyFaceUser[] users = socialNetwork.getUsers().stream().toArray(MyFaceUser[]::new);
            System.out.printf("MyFace user count: %d\n", users.length);
            
// setup sorting algorithm
            Comparator<MyFaceUser> c = (e, f) -> {
                if(MyFaceDriver.getSocial(e) < MyFaceDriver.getSocial(f)) {
                    return 1;
                } else if (MyFaceDriver.getSocial(e) == MyFaceDriver.getSocial(f)) {
                    return 0;
                } else {
                    return -1;
                }
            };
            Swapper<MyFaceUser> s = Swapper.getNetworkSwapper(1);
            Integer[] a = new Integer[] { 3, 6, 1, 32, 9, 2 };
            //   Sort<MyFaceUser> sort = new BubbleSort<>(users, 0, users.length - 1, c, s);
            
            Sort<MyFaceUser> sort = new QuickSort<>(users, 0, users.length - 1, c, s);  
            System.out.println("Quicksort:");
            MyFaceDriver.printEstimate(sort.getStats());

            //Sort<MyFaceUser> sort1 = new BubbleSort<>(users, 0, users.length - 1, c, s);
            //System.out.println("BubbleSort:");
            
            Sort<MyFaceUser> sort2 = new InsertionSort<>(users, 0, users.length - 1, c, s);
            System.out.println("Insertion:");
            MyFaceDriver.printEstimate(sort2.getStats());
            
            Sort<MyFaceUser> sort3 = new SelectionSort<>(users, 0, users.length - 1, c, s);
            System.out.println("Selection:");
            MyFaceDriver.printEstimate(sort3.getStats());
            
            
        }

    public static int getSocial(MyFaceUser u) {
        int friends = u.getFriends().size();
        int name = u.getName().length();
        int score = friends * name / u.getAge();
        return score;
    }

    /**
     * Given a reference to a {@code Stats} object returned from the {@code getStats()}
     * method of a sorting algorithm, print the sum of the values returned by the 
     * {@code getSum()) method of each statistic (converted to seconds) and also print the 
     * values returned by the {@code getAverage()} method of each statistic (converted to
     * microseconds).
     * 
     * @param stats an object containing the statistics for a sorting algorithm execution
     */
    public static void printEstimate(Sort.Stats stats) {
        System.out.println("Total Runtime Estimate\t= " +
                           ((stats.getCompStats().getSum() + (stats.getSwapStats().getSum())) /
                            Math.pow(10, 9)) + " s");
        System.out.println("Average Comparison Time\t= " + (stats.getCompStats().getAverage() /1000)
                           + " us");
        System.out.println("Average Swap Time\t= " + (stats.getSwapStats().getAverage() /1000)
                           + " us");

    }
    
}
