package linkedlist;

import listnode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();

        while(headA != null && setA.add(headA)){
            headA = headA.next;
        }

        Set<ListNode> setB = new HashSet<>();
        while (headB != null && setB.add(headB)){
            if(setA.contains(headB))
                return headB;
            headB = headB.next;
        }

        return null;
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode aNext = headA;
        int aCount = 0;
        while (aNext != null && aNext.next != null){
            aCount++;
            aNext = aNext.next;
        }

        ListNode bNext = headB;
        int bCount = 0;
        while (bNext != null && bNext.next != null){
            bCount++;
            bNext = bNext.next;
        }

        if(aNext != bNext)
            return null;

        if(aCount > bCount ){
            for(int i = 0; i < (aCount - bCount) &&(headA != null); i++){
                headA = headA.next;
            }
        }

        if(bCount > aCount){
            for(int i = 0; i < (bCount - aCount) &&(headB != null); i++){
                headB = headB.next;
            }
        }

        while (headA != null && headB != null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
