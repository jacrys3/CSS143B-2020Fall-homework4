package Problem3;

import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
        // got help from geeks for geeks.com
    public static void printListInReverse(ListNode list, PrintStream print) {
        if(list != null) {
            if(list.next != null)
                printListInReverse(list.next, print);
            print.println(list.val);
        }
    }

}
