package utils;


import linkedlist.Node;
import linkedlist.SingleLinkedList;

public class SingleLinkedListUtil {
    /**
     * This method is used to find intersected value between 2 single linked lists.
     * @param list1 This is the 1st input single linked list parameter
     * @param list2 This is the 2nd input single linked list parameter
     * @return int This returns the intersected value.
     */
    public static int findIntersectedVal(SingleLinkedList list1, SingleLinkedList list2){
        int intersectedVal = -1;
        int count;
        Node head1 = list1.getHead();
        Node head2;
        while (head1 != null){
            head2 = list2.getHead();
            while (head2 != null){
                intersectedVal = head2.getData();
                count = 0;
                while (head1 != null && head2 != null && head1.equals(head2)){
                    head1 = head1.getNext();
                    head2 = head2.getNext();
                    count++;
                }
                if (count == 1){
                    intersectedVal = -1;
                }
                if (head2 != null){
                    head2 = head2.getNext();
                }
            }
            if (head1 != null){
                head1 = head1.getNext();
            }
        }
        return intersectedVal;
    }
    /**
     * This method is used to find intersected value between 2 single linked lists.
     * @param list1 This is the 1st input single linked list parameter
     * @param list2 This is the 2nd input single linked list parameter
     * @return int This returns the intersected value.
     */
    public static int findIntersectedVal2(SingleLinkedList list1, SingleLinkedList list2){
        int intersectedVal = -1;
        Node head1 = list1.getHead();
        Node head2;
        while (head1 != null){
            head2 = list2.getHead();
            while (head2 != null){
                if (head1.equals(head2)){
                    return head1.getData();
                }
                head2 = head2.getNext();
            }
            head1 = head1.getNext();
        }
        return intersectedVal;
    }
}

