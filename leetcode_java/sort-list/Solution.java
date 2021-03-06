/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode merge(ListNode p, ListNode q){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(p != null && q != null){
            if(p.val <= q.val){
                cur.next = p;
                p = p.next;
            }
            else{
                cur.next = q;
                q = q.next;
            }
            cur = cur.next;
        }
        while(p != null){
            cur.next = p;
            p = p.next;
            cur = cur.next;
        }
        while(q != null){
            cur.next = q;
            q = q.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode fast = head.next, slow = head;
        while(fast.next != null){
            fast = fast.next;
            if(fast.next != null) fast = fast.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode p = sortList(tmp);
        ListNode q = sortList(head);
        return merge(p, q);
    }
}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode rt = new ListNode(0);
        ListNode h = rt;
        
        while( l1 != null && l2 != null){
            if(l1.val < l2.val){
                rt.next = l1;
                l1 = l1.next;
            }else{ 
                rt.next = l2;
                l2 = l2.next;
            }
            
            rt = rt.next;
        }

        if(l1 != null) rt.next = l1;
        else rt.next = l2;
        
        
        return h.next;

        
    }    
    
    
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode h2 = slow.next;
        slow.next = null;
        
        return mergeTwoLists(sortList(head), sortList(h2));
        
        
    }
}