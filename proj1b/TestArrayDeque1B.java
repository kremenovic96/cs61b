import org.junit.Test;
import static org.junit.Assert.*;
// trying
public class TestArrayDeque1B {
 @Test
  public void testSize() {
   StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
   int actual = sad1.size();
   assertEquals(0,actual);
   sad1.addFirst(5);
   sad1.addLast(4);
    actual = sad1.size();
      assertEquals(2,actual);
} @Test
  public void testEmpty() {
    StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
    boolean is = sad1.isEmpty();
    assertEquals(is,true);
    sad1.addFirst(3);
     is=sad1.isEmpty();
      assertEquals(is,false);
}

 @Test
  public void testAddFirstandAddLast() {
    StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
    sad1.addFirst(4);
   int actual = sad1.get(0);
   assertEquals(actual,4);
     sad1.addLast(5);
    actual = sad1.get(1);
   assertEquals(actual,5);


}
 @Test
  public void testPrint() {
   StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
    sad1.addFirst(4);
    sad1.addFirst(5);
    sad1.addLast(6);
 int actual = sad1.get(0);
 assertEquals(5,actual);
  actual = sad1.get(1);
 assertEquals(4,actual);
  actual = sad1.get(2);
 assertEquals(6,actual);
 
 // sad1.printDeque();
}
 @Test
  public void testGet() {
     StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
   /*sad1.addFirst(1);
   sad1.addFirst(2);
sad1.addFirst(3);
sad1.addFirst(4);
sad1.addFirst(5);
sad1.addFirst(6);
   int actual = sad1.get(0);
  assertEquals(6,actual);*/
sad1.addFirst(1);
sad1.addLast(4);
int actual = sad1.get(0);
 assertEquals(actual,1);
 actual = sad1.get(1);
 assertEquals(actual,4);
 //čudno iznad
}
// @Test
   public void testRemove() {
    StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
     sad1.addFirst(4);
    sad1.addFirst(5);
    sad1.addLast(6);
    sad1.addLast(7);
  int actual = sad1.removeFirst();
  assertEquals(actual,5);
  
 actual = sad1.removeLast();
 assertEquals(actual,7);
 actual = sad1.size();
 assertEquals(actual,2);
 actual = sad1.get(0);
 assertEquals(null,actual);
 actual = sad1.get(3);
 assertEquals(actual,null);
}
 public static void main(String[] args) {
 jh61b.junit.TestRunner.runTests("failed",TestArrayDeque1B.class);
}
}