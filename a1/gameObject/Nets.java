/**
 * Name: Sayd Mateen
 * Class: CSC133
 * Assignment#1 
 * Date: 10/02/15
 *  
 *
 * The net will be in the game field. Only one will be created.
 * The Controller will be able to move the net and change its properties. 
 * 
 * 
 * 
 */

package a1.gameObject;

import java.util.Random;

public class Nets extends Catcher{
	// Represented as a box
	
	//Creates the net in random loation within the bounds. Also sets all its attributes.
	public Nets(){
		Random r = new Random();
		float x, y;
		int size;
		size = r.nextInt(450)+50;
		setSize(size);
		do{
			x = r.nextInt(1024) + r.nextFloat();
			y = r.nextInt(1024) + r.nextFloat();
			setLocation(x, y);
		}while(x+size > 1024 || y+size > 1024 || x-size < 0 || y-size < 0);
		super.setColor(1,1,1);
	}
	
	// Can't change color so it overrides it.
	public void setColor(int x, int y, int z){
		//nets can't change their colorf
	}
	
	// Expands the net
	public void expand(){
		setSize(getSize()+10);
	}
	
	// Shrinks the net 
	public void contract(){
		setSize(getSize()-10);
	}
	
	// Moves the net to the right
	public void moveRight(){
		if(getLocation().getX()+getSize() + 10 < 1024){
			setLocationX((getLocation().getX())+10);
		}
	}
	
	// Moves the net to the left.
	public void moveLeft(){
		if(getLocation().getX()-getSize() - 10 > 0){
			setLocationX((getLocation().getX())-10);
		}
	}
	
	// Moves the net up.
	public void moveUp(){
		if(getLocation().getY()+getSize() + 10 < 1024){
			setLocationY((getLocation().getY())+10);
		}
	}
	
	// Moves the net down.
	public void moveDown(){	
		if(getLocation().getY()-getSize() - 10 > 0){
			setLocationY((getLocation().getY())-10);
		}
	}
	
	// Return the parent information with the addition of the net informion 
	public String toString(){
		String parentString = super.toString();
		return "Net: " + parentString; 
	}
}
