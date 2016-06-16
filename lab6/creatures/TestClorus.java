package creatures;

import static org.junit.Assert.*;

import huglife.Direction;
import huglife.Empty;
import huglife.Occupant;
import org.junit.Test;
import huglife.Action;
import java.util.HashMap;

public class TestClorus {

    @Test
    public void testEnergy() {
        Clorus aa = new Clorus(5);
        double actual = aa.energy();
        double expected = 5;
        assertEquals(expected, actual, 0.1);

        assertEquals("clorus", aa.name());
        aa.stay();
        aa.stay();
        aa.stay();
        aa.stay();
        actual = aa.energy();
        expected = 4.96;
        assertEquals(expected, actual, 0.01);
        aa.move();
        aa.move();
        actual = aa.energy();
        expected = 4.90;
        assertEquals(expected, actual, 0.01);
    }
    @Test
            public void testReplicate() {
        Clorus bb = new Clorus(2);
        Clorus c = bb.replicate();
        assertNotSame(bb, c);
        double actual = bb.energy();
        assertEquals(1, actual, 0.01);
        actual = c.energy();
        assertEquals(1,actual,0.01);
    }
    @Test
    public void testAttack() {
        Clorus a = new Clorus(2);
        Plip c = new Plip(1);
        a.attack(c);
        assertEquals(a.energy(),3, 0.01);
    }
    @Test
    public void testNeighboor(){
    Clorus a = new Clorus(2);
        HashMap<Direction,Occupant> loc = new HashMap<Direction,Occupant>();
        loc.put(Direction.BOTTOM,new Plip());
        loc.put(Direction.TOP,new Plip());
        loc.put(Direction.LEFT,new Plip());
        loc.put(Direction.RIGHT,new Plip());
    Action actual = a.chooseAction(loc);
        Action expected = new Action(Action.ActionType.STAY);
        assertEquals(expected,actual);

        Clorus b = new Clorus(0.8);
        HashMap<Direction,Occupant> loc1 = new HashMap<Direction,Occupant>();
        loc1.put(Direction.BOTTOM,new Empty());
        loc1.put(Direction.LEFT,new Empty());
        loc1.put(Direction.RIGHT,new Plip());
        loc1.put(Direction.TOP,new Empty());
        expected = new Action(Action.ActionType.ATTACK,Direction.RIGHT);
        actual = b.chooseAction(loc1);
        assertEquals(expected,actual);

        Clorus qq = new Clorus(1);
        HashMap<Direction,Occupant> loc2 = new HashMap<Direction,Occupant>();
        loc2.put(Direction.BOTTOM,new Plip());
        loc2.put(Direction.LEFT,new Plip());
        loc2.put(Direction.RIGHT,new Plip());
        loc2.put(Direction.TOP,new Empty());
        expected = new Action(Action.ActionType.REPLICATE,Direction.TOP);
        actual = qq.chooseAction(loc1);
        assertEquals(expected,actual);




    }


 }