class NBody
{
  public static void main (String[] args)
  {
    double T= Double.parseDouble(args[0]);
    double dt=Double.parseDouble(args[1]);
  String filename = args[2];
double rad= readRadius(filename);
 Planet[] planet=readPlanets(filename);

 StdDraw.setXscale(-rad,rad);
 StdDraw.setYscale(-rad,rad);
 StdDraw.picture(0,0,"./images/starfield.jpg");
 // draw planets in array
 for (int i=0;i<planet.length;i++)
  {
    planet[i].draw();
 
  } 
    // slijedi problem
 double time=0;
  while (time != T)
   {
      double[] xForces = new double[planet.length];
      double[] yForces = new double[planet.length]; 
for (int i=0;i<planet.length;i++)
 {
    xForces[i]=planet[i].calcNetForceExertedByX(planet);
    yForces[i]=planet[i].calcNetForceExertedByY(planet);
 }
for (int z=0;z<planet.length;z++)
    {
    planet[z].update(dt,xForces[z],yForces[z]);
    }
     StdDraw.picture(0,0,"./images/starfield.jpg");
       for (int y=0;y<planet.length;y++)
        {
           planet[y].draw(); 

        }
      

     StdDraw.show(10);
      time+=dt; }
  }
  

 public static double readRadius(String location)
  {
 In in = new In(location);
   double radius=in.readDouble();
  radius=in.readDouble();
   return radius;
   
  }
public static Planet[] readPlanets(String location)
   {
     In in = new In(location);
 int numOfPlanets= in.readInt();
  Planet[] planets= new Planet[numOfPlanets];
  double wastedVar=in.readDouble(); // this is radius of universe
 for (int i=0;i<numOfPlanets;i++)
     {
       planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());

     }
 return planets;
   }

}

