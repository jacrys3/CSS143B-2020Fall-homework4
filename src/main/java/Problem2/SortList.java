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
        if(head != null){
            for (int i = 0; i < helperBreak(head, 0); i++) {
                if(head.next != null) head = head.next;
                else break;
            }
            return head;
        }
        return null;
    }
    private static int helperBreak(ListNode head, int cnt){
        if(head.next != null) {
            helperBreak(head.next, cnt + 1);
        }
        return cnt / 2;
    }

    public static ListNode mergeLists(ListNode list1, ListNode list2) {
        // homework
        return null;
    }
}
