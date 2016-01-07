/**
 * Name: Sayd Mateen
 * Class: CSC133
 * Assignment#1 
 * Date: 10/02/15
 *  
 *
 * 
 * Cat object will be represented as a Triangle.
 * Will be able to move and be captured by the net.
 * Can produde more cats.
 * 
 * 
 */

package a1.gameObject;

import java.util.Random;
import a1.Point; 


public class Cats extends Animals {
	//Represented as a equilateral Triangle 
	
	//Creates the Cats in random loation within the bounds. Also sets all its attributes.
	public Cats(){
		Random r = new Random();
		float x, y;
		int size;
		size = r.nextInt(50);
		do{
			x = r.nextInt(1024) + r.nextFloat();
			y = r.nextInt(1024) + r.nextFloat();
		}while(x+size > 1024 || y+size > 1024 || x-size < 0 || y-size < 0);
		super.setSize(size);
		setLocation(x,y);
		super.setColor(0, 128, 15);
		setSpeed(5);
		setDirection(r.nextInt(359));
	}
	
	// Checks if the cat which is represented as a triangle if is inside the net. Then returns booleans so it can be removed according to answer.
	public boolean inNetCheck(Point p, int netSize){
		double radius = (.5 * Math.sqrt(3.0) * getSize())/2;
		if((p.getX()+netSize > getLocation().getX()+radius) && (p.getX()-netSize < getLocation().getX()-radius) && (p.getY()+netSize > getLocation().getY()+radius) && (p.getY()-netSize < getLocation().getY()-radius)){
			return true;
		}else{
			return false;
		}
	}
	
	// Overrides the size so it cant be changed.
	public void setSize(){
		//cats size cant be changed 
	}
	
	// Overrrides the color because it cant be changed. 
	public void setColor(int x, int y, int z){
		//cats can't change their color
	}
	
	// Moves the cat but checks its location first so it can makes sure it doesnt go out of bound. 
	public void move(){
		double deltaX = Math.cos(90- getDirection())*getSpeed();
		double deltaY = Math.sin(90- getDirection())*getSpeed();
		float x = (float)(getLocation().getX()+deltaX);
		float y = (float)(getLocation().getY()+deltaY);
		setLocation(x, y);
		if(x < 0) {
			setLocationX(0);
			setDirection((getDirection()+ 180) %360);
		}else if(x > 1024){
			setLocationX(1024);
			setDirection((getDirection()+ 180) %360);
		}else if(y < 0){
			setLocationY(0);
			setDirection((getDirection()+ 180) %360);
		}else if(y > 1024){
			setLocationY(1024);
			setDirection((getDirection()+ 180) %360);
		}
	}
	
	// Return the parent information with the addition of the cats informion. 
	public String toString(){
		String parentString = super.toString();
		return "Cat: " + parentString; 
	}
}
