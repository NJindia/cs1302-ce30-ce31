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
                if(e.getAge() < f.getAge()) {
                    return -1;
                } else if (e.getAge() == f.getAge()) {
                    return 0;
                } else {
                    return 1;
                }
            };
            Swapper<MyFaceUser> s = Swapper.getStandardSwapper();
            Integer[] a = new Integer[] { 3, 6, 1, 32, 9, 2 };
            //   Sort<MyFaceUser> sort = new BubbleSort<>(users, 0, users.length - 1, c, s);
            Sort<MyFaceUser> sort = new QuickSort<>(users, 0, users.length - 1, c, s);  
            System.out.println("Quicksort:");
            sort.printStats();
            Sort<MyFaceUser> sort1 = new BubbleSort<>(users, 0, users.length - 1, c, s);
            System.out.println("BubbleSort:");
            sort1.printStats();

            Sort<MyFaceUser> sort2 = new InsertionSort<>(users, 0, users.length - 1, c, s);
            System.out.println("Insertion:");
            sort2.printStats();

             Sort<MyFaceUser> sort3 = new SelectionSort<>(users, 0, users.length - 1, c, s);
             System.out.println("Selection:");
             sort3.printStats();
            
            




            for(MyFaceUser face : sort.getSorted()) {
//                System.out.println(face.getAge());
            }


            
        }
}
