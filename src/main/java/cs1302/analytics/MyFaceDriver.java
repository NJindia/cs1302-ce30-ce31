package cs1302.analytics;
import cs1302.sorting.*;
import cs1302.myface.*;
import java.util.*;
public class MyFaceDriver
{
    public static void main(String[] args)
        {
            // generate myface users
            MyFace socialNetwork = new MyFace(25);
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
            Sort<MyFaceUser> sort = new BubbleSort<>(users, 0, users.length - 1, c, s);
            sort.printStats();
            for(MyFaceUser face : sort.getSorted()) {
                System.out.println(face.getAge());
            }
        }
}
