Particle [] group;//your code here
void setup()
{
  size(720,480);
  background(0);
  group = new Particle[50];
  group[49] = new OddballParticle();
    for(int i = 0; i < 49;i++)
    {
      group[i] = new NormalParticle();
    }
}
void draw()
{
  background(0);
  for(int i = 0;i < group.length;i++)
  {
    group[i].show();
    group[i].move();

  }
  //your code here
}
  interface Particle{
    public void show();
    public void move();
  }
class NormalParticle implements Particle
{
  int myColor;
  double x,y,mySpeed,myAngle;
  NormalParticle() //constructor
  {
    x = 360;
    y = 240;
    mySpeed = Math.random()*5+2;
    myAngle = Math.PI*2*Math.random();
    myColor = 255;
  }
  public void move()
  {
    x = Math.cos(myAngle)*mySpeed + x;
    y = Math.sin(myAngle)*mySpeed + y;
  }
  public void show()
  {
    fill(myColor);
    noStroke();
    ellipse((float)x,(float)y,10,10);
  }
} 
class OddballParticle implements Particle
{
  int myColor;
  double x,y,mySpeed,myAngle;
  OddballParticle()
  {
    x = 360;
    y = 240;
    mySpeed = Math.random()*5+2;
    myAngle = Math.PI*2*Math.random();
    myColor = 255;
  }
  public void move()
  {
    x = 1 + x;
    y = 1 + y;
  }
  public void show()
  {
    fill(myColor);
    noStroke();
    ellipse((float)x,(float)y,20,20);
  }
}