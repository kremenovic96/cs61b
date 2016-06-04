package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    //@Test
    public void someTest() {
        //ArrayRingBuffer arb = new ArrayRingBuffer(10);
    }
 //
    @Test
 public void mytest(){
     ArrayRingBuffer<Double> aa = new ArrayRingBuffer<Double>(4);
 boolean testt = true;
assertEquals(testt,aa.isEmpty());
 testt = false;

 aa.enqueue(33.1);
  assertEquals(testt,aa.isEmpty());
 aa.enqueue(44.8);
 aa.enqueue(62.3);
  aa.enqueue(-3.4);
 double tt = aa.dequeue(); 
 assertEquals(tt,33,1);
 tt = aa.peek();
 assertEquals(tt,44,8);
}

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
