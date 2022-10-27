package linkedlist;

public class MergeTwoLists {
    public static void main(String[] args) {
        LinkedListt linkedListt1 = new LinkedListt();
        linkedListt1.addAtHead(1);
        linkedListt1.addAtTail(2);
        linkedListt1.addAtTail(4);
        ListNode list1 = linkedListt1.getHead();
        LinkedListt linkedListt2 = new LinkedListt();
        linkedListt2.addAtHead(2);
        linkedListt2.addAtTail(3);
        linkedListt2.addAtTail(4);
        ListNode list2 = linkedListt2.getHead();
        ListNode merged = mergeTwoListsRecursive(list1, list2);
        System.out.println();
    }

    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode head;

        if(list1.val < list2.val){
            head = list1;
            list1 = list1.next;
        }else{
            head = list2;
            list2 = list2.next;
        }

        head.next = mergeTwoListsRecursive(list1, list2);
        return head;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode answer = null;
        ListNode list1Walk = list1;
        ListNode list2Walk = list2;
        ListNode answerWalk = null;

        while (list1Walk != null || list2Walk != null){
            if(list1Walk != null && list2Walk != null){
                if(list2Walk.val <= list1Walk.val){
                    if(answer == null){
                        answer = new ListNode(list2Walk.val);
                        answerWalk = answer;
                    }else{
                        answerWalk.next = new ListNode(list2Walk.val);
                        answerWalk = answerWalk.next;
                    }
                    list2Walk = list2Walk.next;
                }else{
                    if(answer == null){
                        answer = new ListNode(list1Walk.val);
                        answerWalk = answer;
                    }else{
                        answerWalk.next = new ListNode(list1Walk.val);
                        answerWalk = answerWalk.next;
                    }
                    list1Walk = list1Walk.next;
                }
            }else if(list1Walk != null){
                if(answer == null){
                    answer = new ListNode(list1Walk.val);
                    answerWalk = answer;
                }else{
                    answerWalk.next = new ListNode(list1Walk.val);
                    answerWalk = answerWalk.next;
                }
                list1Walk = list1Walk.next;
            } else {
                if(answer == null){
                    answer = new ListNode(list2Walk.val);
                    answerWalk = answer;
                }else{
                    answerWalk.next = new ListNode(list2Walk.val);
                    answerWalk = answerWalk.next;
                }
                list2Walk = list2Walk.next;
            }
        }
        return answer;
    }
}
