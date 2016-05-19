/**
 * Created by ranko on 19-05-16.
 */

  //import org.junit.Test;
 //import static org.junit.Assert.*;
public class OffByN implements CharacterComparator {
    int n;
   public OffByN(int n) {
    n = n;

    }

    @Override
    public boolean equalChars(char x, char y) {
        if ((x-y == n) || (y-x == n)) {
            return true;
        }
        return false;
    }
    //tests below
    /*@Test
            public void aaa() {
        OffByN offBy5 = new OffByN(5);
        boolean is = offBy5.equalChars('a', 'f');
        assertEquals("true",is);
    }
    public static void main (String[] args) {
        jh61b.junit.TestRunner.runTests("all", OffByN.class);

    }*/
}
