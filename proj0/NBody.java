class NBody
{
  public static void main (String[] args)
  {
    double T= args[0];
    double dt=args[1];
  String filename = args[2];



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
  double wastedVar=in.readDouble();
 for (int i=0;i<numOfPlanets;i++)
     {
       planets[i] = new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());

     }
 return planets;
   }

}
