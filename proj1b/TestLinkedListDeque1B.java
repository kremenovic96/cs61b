import org.junit.Test;
import static org.junit.Assert.*;
 // its seems that removeLast() is messing things up(see testPrint);
 public class TestLinkedListDeque1B {
 //size and add is working
 //@Test
 public void testSize() {
  StudentLinkedListDeque<Integer> a1 = new StudentLinkedListDeque<Integer>();
 int actual = a1.size();
 assertEquals(actual,0);
 a1.addFirst(2);
 actual = a1.size();
 assertEquals(actual,1);
 a1.addLast(4);
 a1.addFirst(5);
 a1.addLast(6);
 actual = a1.size();
 assertEquals(4,actual);
  a1.removeFirst();
  actual = a1.size();
 assertEquals(3,actual);
  a1.removeLast();
  actual = a1.size();
 assertEquals(2,actual);
  StudentLinkedListDeque<Integer> a2 = new StudentLinkedListDeque<Integer>();
 actual = a2.size();
 assertEquals(0,actual);
 a2.addFirst(1);
 a2.addFirst(2);
 a2.addFirst(3);
 a2.addLast(4);
 a2.addLast(5);
 actual = a2.removeFirst();
 assertEquals(3,actual); 
 actual = a2.removeLast();
 assertEquals(5,actual);
 actual = a2.removeFirst();
 assertEquals(2,actual);
 actual = a2.size();
 assertEquals(2 ,actual);
}
 //get is working 
 //@Test
  public void testGet() {
 StudentLinkedListDeque<Integer> a2 = new StudentLinkedListDeque<Integer>();
   a2.addFirst(1);
 a2.addFirst(2);
 a2.addFirst(3);
 a2.addLast(4);
 a2.addLast(5);
  int actual = a2.get(0);
 assertEquals(3,actual);
  actual = a2.get(1);
 assertEquals(2,actual);
  actual = a2.get(4);
 assertEquals(5,actual);
 actual = a2.get(3);
 assertEquals(4,actual);
 actual = a2.get(2);
 assertEquals(1,actual);
 actual = a2.get(4);
 assertEquals(5,actual);

}
// testEmpty is working
// @Test
 public void testEmpty() {
 StudentLinkedListDeque<Integer> a2 = new StudentLinkedListDeque<Integer>();
 boolean actual = a2.isEmpty();
 assertEquals(true,actual);
 a2.addFirst(2);
 actual = a2.isEmpty();
 assertEquals(false,actual);
}
 //testRecursive is working
//@Test
 public void testRecursive() {
 StudentLinkedListDeque<Integer> a2 = new StudentLinkedListDeque<Integer>();
  a2.addFirst(1);
 a2.addFirst(2);
 a2.addFirst(3);
 a2.addLast(4);
 a2.addLast(5);
 int actual = a2.getRecursive(4);
 assertEquals(5,actual);
 actual = a2.getRecursive(0);
 assertEquals(3,actual);
 actual = a2.getRecursive(1);
 assertEquals(2,actual);
} 
 @Test
 public void testPrint() {
 StudentLinkedListDeque<Integer> a2 = new StudentLinkedListDeque<Integer>();
/*a2.addFirst(1);
 a2.addFirst(2);
 a2.addFirst(3);
 a2.addLast(4);
 a2.addLast(5);
 a2.addLast(6);
 a2.printDeque();
 a2.removeLast(); //cant print after removeLast();
// a2.removeFirst();
 int actual = a2.get(5);
 assertEquals(5,actual);

 a2.addLast(7);
 
 a2.printDeque();*/

a2.addFirst(1);
 a2.addFirst(2);
 a2.addFirst(3);
 a2.addLast(4);
 a2.addLast(5);
 a2.addLast(6);
 a2.printDeque();
 a2.removeFirst();
 a2.printDeque();
int actual = a2.get(4);
 assertEquals(6,actual);
 a2.printDeque();
}
 public static void main(String[] args) {
 jh61b.junit.TestRunner.runTests("all",TestLinkedListDeque1B.class);

}
}