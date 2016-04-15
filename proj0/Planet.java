class Planet
{
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
 public double calcForceExertedBy(Planet b)
 {


 }





}
