package creatures;
import huglife.*;

import java.awt.Color;
import java.util.List;
import java.util.Map;

public class Clorus extends Creature {
    private int r;
    private int g;
    private int b;
  double moveProb = 0.5;
    public Clorus(double en){
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = en;
    }
    public Clorus(){
        this(1);
    }
    public Color color() {
        r = 34;
        g = 0;
        b = 231;
        return color(r,g,b);
    }

    public void move() {
        energy -= 0.03;

    }
    public void stay() {
        energy -= 0.01;
    }
    public void attack(Creature c) {




        this.energy += c.energy();


    }
    public Clorus replicate() {
        return new Clorus(this.energy *= 0.5);
    }

    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> emptyes = getNeighborsOfType(neighbors,"empty");
        List<Direction> plips = getNeighborsOfType(neighbors,"plip");
        if (emptyes.isEmpty()) {
            this.stay();
            return new Action(Action.ActionType.STAY);
        }
        if (!plips.isEmpty()) {
            Direction attackDir = HugLifeUtils.randomEntry(plips);
            return new Action(Action.ActionType.ATTACK,attackDir);
        }
        if (this.energy >= 1) {
            Direction repDir = HugLifeUtils.randomEntry(emptyes);
            return new Action(Action.ActionType.REPLICATE,repDir);
        }
        return new Action(Action.ActionType.MOVE,HugLifeUtils.randomEntry(emptyes));






    }



 }