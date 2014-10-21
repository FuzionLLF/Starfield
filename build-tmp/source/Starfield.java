import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Starfield extends PApplet {

Particle [] group;//your code here
public void setup()
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
public void draw()
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
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Starfield" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
