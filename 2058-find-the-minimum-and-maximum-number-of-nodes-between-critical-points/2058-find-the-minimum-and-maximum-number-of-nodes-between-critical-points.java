/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int pc = -1;
        int md = Integer.MAX_VALUE;
        int mxd = -1;
        int index = 1;
        ListNode prev = head;
        ListNode curr = head.next;
        while(curr != null && curr.next != null)
        {
            boolean isMax = curr.val > prev.val && curr.val > curr.next.val;
            boolean isMin = curr.val < prev.val && curr.val < curr.next.val;
            if (isMax || isMin)
            {
                if (first == -1)
                {
                    first = index;
                }
                if (pc != -1)
                {
                    md = Math.min(md,index-pc);
                }
                pc = index;
                mxd = index - first;
            }
            prev = curr;
            curr = curr.next;
            index++;
        }
        if(first == -1 || first == pc)
        {
            return new int[] {-1,-1};
        }
        return new int[] {md,mxd};
    }
}