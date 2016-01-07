/**
 * Name: Sayd Mateen
 * Class: CSC133
 * Assignment#1 
 * Date: 10/02/15 
 *  
 *
 * 
 * Dog will be represented as a circle.
 * Will be able to move and change colors.
 * Can get scrated and be captured by the catcher.
 * 
 */

package a1.gameObject;

import java.util.Random;
import a1.Point;

public class Dogs extends Animals {
	//Represented As a Circle 
	private int scratches = 0;
	
	//Creates the Dogs in random loation within the bounds. Also sets all its attributes.
	public Dogs(){
		Random r = new Random();
		float x, y; 
		int size;
		size = r.nextInt(50);
		do{
			x = r.nextInt(1024) + r.nextFloat();
			y = r.nextInt(1024) + r.nextFloat();
		}while(x+size > 1024 || y+size > 1024 || x-size < 0 || y-size < 0);
		setSize(size);
		setLocation(x,y);
		setColor(0, 20, 128);
		setSpeed(5);
		setDirection(r.nextInt(359));
	}
	
	// Moves the dogs but checks its location first so it can makes sure it doesnt go out of bound. 
	public void move(){
		if(scratches < 5){
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
	}
	
	// Checks if the dog which is represented as a circle if is inside the net.Then returns booleans so it can be removed according to answer. 
	public boolean inNetCheck(Point p, int netSize){
		if((p.getX()+netSize > getLocation().getX()+getSize()) && (p.getX()-netSize < getLocation().getX()-getSize()) && (p.getY()+netSize > getLocation().getY()+getSize()) && (p.getY()-netSize < getLocation().getY()-getSize())){
			return true;
		}else{
			return false;
		}
	}
	
	// if the scratches if less than 5 then it will change the dogs attributes becuase it got stratched by a cat.
	public boolean gotScratched(){
		if(scratches < 5){
			scratches++;
			adjustSpeed(-1);
			setColor(getColor().getRed(), getColor().getGreen()+20, getColor().getBlue());
			return true;
		}else{
			return false;
		}
	}
	
	// Returns the number of scratches that the dog has.
	public int getScratches(){
		return scratches;
	}
	
	// Return the parent information with the addition of the dogs informion. 
	public String toString(){
		String parentString = super.toString();
		return "Dog: " + parentString + " scratches=" + scratches; 
	}
}
