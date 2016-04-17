class Planet
{
 public static final double G = 6.67E-11;
 double xxPos;
 double yyPos;
 double xxVel;
 double yyVel;
 double mass;
 String imgFileName;

 public Planet(double xP, double yP, double xV, double yV, double m, String img)
 {
   xxPos=xP;
   yyPos=yP;
   xxVel=xV;
   yyVel=yV;
   mass=m;
 imgFileName=img;

 }
 public Planet(Planet p)
 {
   xxPos=p.xxPos;
   yyPos=p.yyPos;
   xxVel=p.xxVel;
   yyVel=p.yyVel;
   mass=p.mass;
 imgFileName=p.imgFileName;
 }
 public double calcDistance(Planet a)
 {
   return (Math.sqrt(Math.pow((xxPos-a.xxPos),2) + (Math.pow((yyPos-a.yyPos),2))));
 }
 public double calcForceExertedBy(Planet a)
 {
   return (G * this.mass * a.mass) / Math.pow(calcDistance(a),2);
 }
 public double calcForceExertedByX(Planet a)
 {
   double dx=a.xxPos-this.xxPos;
   return calcForceExertedBy(a) * dx / calcDistance(a);
 }
 public double calcForceExertedByY(Planet a)
 {
   double dy=a.yyPos - this.yyPos;
   return calcForceExertedBy(a) * dy / calcDistance(a);
 }
 public double calcNetForceExertedByX (Planet[] a)
 {
 xxVel=0;
  //double xNetForce;
 for (int i=0;i<a.length;i++)
  {
    if (this.equals(a[i]))
     {continue;}
    else{
   xxVel+=this.calcForceExertedByX(a[i]);
        }
  }
   return xxVel;


 }
 public double calcNetForceExertedByY(Planet[] a)
 {
  yyVel=0;
  for (int i=0;i<a.length;i++)
  {
    if (this.equals(a[i]))
     {continue;}
    else {
   yyVel+=this.calcForceExertedByY(a[i]);
         }
   }
 return yyVel;
 }
 public void update(dt,fX,fY)
  {


  }


}
