package linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.SingleLinkedListUtil.findIntersectedVal;
import static utils.SingleLinkedListUtil.findIntersectedVal2;

public class SingleLinkedListUtilTest {
    SingleLinkedList singleLinkedList1 = new SingleLinkedList();
    SingleLinkedList singleLinkedList2 = new SingleLinkedList();
    SingleLinkedList singleLinkedList3 = new SingleLinkedList();

    @BeforeEach
    void setUp() {
        singleLinkedList1.insert(new Node(3));
        singleLinkedList1.insert(new Node(6));
        singleLinkedList1.insert(new Node(9));
        singleLinkedList2.insert(new Node(10));
        singleLinkedList3.insert(new Node(15));
        singleLinkedList3.insert(new Node(30));

        singleLinkedList1.insert(singleLinkedList3);
        singleLinkedList2.insert(singleLinkedList3);
    }

    @Test
    @DisplayName("Test find intersected value function between two single linked lists")
    void testFindIntersectedVal() {
        assertEquals(15, findIntersectedVal(singleLinkedList1, singleLinkedList2), "Find intersected value went wrong");
    }

    @Test
    @DisplayName("Test find intersected value function 2 between two single linked lists")
    void testFindIntersectedVal2() {
        assertEquals(15, findIntersectedVal2(singleLinkedList1, singleLinkedList2), "Find intersected value went wrong");
    }

}
