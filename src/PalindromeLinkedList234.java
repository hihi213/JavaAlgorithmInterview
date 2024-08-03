import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PalindromeLinkedList234 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public boolean isPalindrome(ListNode head) {
      //넘겨받은 head를 역순으로 저장한다.

      /*방식 1
      Stack<Integer> stack =new Stack<Integer>();
      ListNode list =head;
      while (true){
        if (list == null) {
          break;
        }
        stack.push(list.val);
        list=list.next;
      }
      while (head !=null)
      {
        if (head.val !=stack.pop() ) {
          return false;
        }
        head=head.next;
      }
    return true;
    }
}
*/
      Deque<Integer> deque= new LinkedList<>();
      ListNode list= head;
      while (list!=null){
        deque.push(list.val);
        list=list.next;
      }
      while (!deque.isEmpty()&&deque.size()>1){
        if (deque.pollFirst() != deque.pollLast()) {
          return false;
        }
      }
 return true;
    }
}