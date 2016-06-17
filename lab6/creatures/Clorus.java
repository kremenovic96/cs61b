package creatures;

import huglife.Creature;
import java.awt.Color;
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
        return Color(r,g,b);
    }

    public void move() {
        energy -= 0.03;

    }
    public void stay() {
        energy -= 0.01;
    }
    public void attack(Creature c) {



    }





 }