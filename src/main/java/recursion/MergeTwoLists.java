package recursion;

import listnode.ListNode;

public class MergeTwoLists {
    static ListNode answer = new ListNode();
    static ListNode answerWalk = answer;
    public static void main(String[] args) {
        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(1);
        ListNode merged = mergeTwoLists(list1, list2);
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        helper(list1, list2);
        return answer.next;
    }

    private static void helper(ListNode list1, ListNode list2) {
        if(list1 == null){
            answerWalk.next = list2;
            return;
        }

        if(list2 == null){
            answerWalk.next = list1;
            return;
        }

        if(list1.val <= list2.val){
            answerWalk.next = list1;
            list1 = list1.next;
        }else {
            answerWalk.next = list2;
            list2 = list2.next;
        }
        answerWalk = answerWalk.next;
        helper(list1, list2);
    }
}
