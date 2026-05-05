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
    public ListNode rotateRight(ListNode head, int k) {

        //finiding length
        int sz = 0;
        ListNode cur = head;
        while(cur != null){
            ++sz; cur = cur.next;
        }

        //returing if no changes req
        if(sz < 2 || k == 0) return head;

        //finding tail
        int move = k%sz;
        int pos = 1;
        int lastPos = sz - move;
        cur = head;

        //returing if no changes req
        if(move == 0) return head;

        //moving to tail
        while(pos != lastPos){
            cur = cur.next; ++pos;
        }

        //marking it as tail
        ListNode start = cur.next;
        cur.next = null;
        

        //marking reaminging part (after tail)
        cur = start;
        while(cur.next != null){
            cur = cur.next;
        }

        //marking new head
        cur.next = head;
        head = start;

        return head;
    
    }
}