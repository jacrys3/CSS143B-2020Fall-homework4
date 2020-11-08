package Problem2;

public class SortList {
    private static final int SENTRY = Integer.MAX_VALUE;
    // DO NOT ADD ANY NEW MEMBER VARIABLE AND MEMBER FUNCTION

    // DO NOT CHANGE ANYTHING IN THIS FUNCTION
    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode mid = findMidAndBreak(head);
        return mergeLists(sortList(head), sortList(mid));
    }

    public static ListNode findMidAndBreak(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode fast = head.next, slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode sec = slow.next;
        slow.next = null;
        return sec;
    }


    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        //help from geeksforgeeks.com
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val < list2.val) {
            list1.next = mergeLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeLists(list1, list2.next);
            return list2;
        }
    }
}
