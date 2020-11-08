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
        if(head.next == null) return null;
        ListNode fast = head, slow = head;
        ListNode sec;
        while(fast.next != null){
            fast = fast.next;

            if(fast.next == null){
                sec = slow;
                slow = null;
                return sec;
            }
            slow = slow.next;
            fast = fast.next;
        }

        sec = slow.next;
        slow.next = null;
        return sec;
    }


    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        // homework
        return null;
    }
}
