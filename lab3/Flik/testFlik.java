import static org.junit.Assert.*;

import org.junit.Test;
public class testFlik{

@Test
public void testequal(){
int expected = 4;
boolean actual=Flik.isSameNumber(127,127);
//assertEquals(actual,expected);
assertTrue(actual);


}




public static void main(String[] args){
jh61b.junit.TestRunner.runTests("failed",testFlik.class);
}
}
