package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

/** Tests the plip class   
 *  @authr FIXME
 */

public class TestPlip {

    /* Replace with the magic word given in lab.
     * If you are submitting early, just put in "early" */
    public static final String MAGIC_WORD = "";

    @Test
    public void testBasics() {
        Plip p = new Plip(2);
        assertEquals(2, p.energy(), 0.01);
        assertEquals(new Color(99, 255, 76), p.color());
        p.move();
        assertEquals(1.85, p.energy(), 0.01);
        p.move();
        assertEquals(1.70, p.energy(), 0.01);
        p.stay();
        assertEquals(1.90, p.energy(), 0.01);
        p.stay();
        assertEquals(2.00, p.energy(), 0.01);
    }
    @Test
    public void mytest(){
    Plip a = new Plip();
    assertEquals(1,a.energy(),0.01);
    assertEquals(new Color(99,127,76),a.color());
    a.move();
    assertEquals(0.85,a.energy(),0.01);
    a.stay();
    assertEquals(1.05,a.energy(),0.01);
    assertEquals("plip",a.name());
        a.stay();
        a.stay();
        a.stay();
        a.stay();
        a.stay();
        a.stay();
    assertEquals(2,a.energy(),0.01);
    }
    @Test
    public void testReplicate() {
    Plip aa = new Plip(2);
        Plip b = aa.replicate();
        assertNotSame(aa,b);
        double actual = b.energy();
        double expected = 1;
        assertEquals(1,actual,0.01);
    }

    @Test
    public void testChoose() {
        Plip p = new Plip(1.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Impassible());
        surrounded.put(Direction.BOTTOM, new Impassible());
        surrounded.put(Direction.LEFT, new Impassible());
        surrounded.put(Direction.RIGHT, new Impassible());

        //You can create new empties with new Empty();
        //Despite what the spec says, you cannot test for Cloruses nearby yet.
        //Sorry!  

        Action actual = p.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);


        Plip bb = new Plip(1);
        HashMap<Direction,Occupant> bbb = new HashMap<Direction, Occupant>();
        bbb.put(Direction.TOP,new Impassible());
        bbb.put(Direction.BOTTOM,new Empty());
        bbb.put(Direction.LEFT, new Impassible());
        bbb.put(Direction.RIGHT, new Impassible());
        actual = bb.chooseAction(bbb);
        expected = new Action(Action.ActionType.REPLICATE,Direction.BOTTOM);
        assertEquals(expected,actual);



        Plip aa = new Plip(5);
        HashMap<Direction,Occupant> okolo = new HashMap<Direction, Occupant>();
        okolo.put(Direction.TOP,new Empty());
        okolo.put(Direction.BOTTOM,new Impassible());
        okolo.put(Direction.LEFT, new Impassible());
        okolo.put(Direction.RIGHT, new Impassible());
        actual = aa.chooseAction(okolo);
        expected = new Action(Action.ActionType.REPLICATE,Direction.TOP);
        assertEquals(expected,actual);
// pass 1/2 times(as it should)
       /* Plip cc = new Plip(2);
        HashMap<Direction,Occupant> ooo = new HashMap<Direction, Occupant>();
        ooo.put(Direction.TOP,new Impassible());
        ooo.put(Direction.BOTTOM,new Empty());
        ooo.put(Direction.LEFT, new Impassible());
        ooo.put(Direction.RIGHT, new Empty());
        actual = cc.chooseAction(ooo);
        expected = new Action(Action.ActionType.REPLICATE,Direction.BOTTOM);
        assertEquals(expected,actual);
        expected = new Action(Action.ActionType.REPLICATE,Direction.RIGHT);
        assertEquals(expected,actual);*/

    }

    public static void main(String[] args) {
        System.exit(jh61b.junit.textui.runClasses(TestPlip.class));
    }
} 
