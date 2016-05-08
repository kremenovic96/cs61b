import org.junit.Test;
import static org.junit.Assert.*;
//  found a bug in size method, now i am stopping there 
public class TestArrayDeque1B {
 @Test
public void testSize() {
   StudentArrayDeque<Integer> aa = new StudentArrayDeque<Integer>();
 int actual = aa.size();
 assertEquals(0,actual);
 aa.removeFirst();
 actual = aa.size();
 assertEquals(0,actual);
 aa.removeLast();
 actual = aa.size();
 assertEquals(0,actual);
 aa.addFirst(1);
 actual = aa.size();
 assertEquals(1,actual);
 aa.removeLast();
 actual = aa.size();
 assertEquals(0,actual);
}


 public static void main(String[] args) {
 jh61b.junit.TestRunner.runTests("failed",TestArrayDeque1B.class);
}
}