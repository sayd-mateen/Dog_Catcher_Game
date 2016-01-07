/**
 * Name: Sayd Mateen
 * Class: CSC133
 * Assignment#1 
 * Date: 10/02/15
 *  
 * Adds the propeties speed and direction and are required for any Animal.
 * The speed is an int value with no representaion and the direcition will be an int value but it will represent the degree of rotaion of the object. 
 * The degree will determine which way the Animal is moving.
 * These added properties will distingues the Animal objects in the game. 
 * Implements the interface IMoving because all animals need to be able to move.
 * 
 * 
 */

package a1.gameObject;

import a1.Point;

public abstract class Animals extends GameObject implements IMoving{
	private int objSpeed, objDirection;
	
	// Set the speed of the Animal.
	public void setSpeed(int speed){
		objSpeed = speed;
	}
	
	// Sends the speed of the object.
	public int getSpeed(){
		return objSpeed;
	}
	
	// Allows the game to change the speed of the Animal object.
	public void adjustSpeed(int i){
		objSpeed = objSpeed + i;
	}
	
	// Sets the direction of the object 
	public void setDirection(int direction){
		objDirection = direction;
	}
	
	// Sends the int value direction to the caller.
	public int getDirection(){
		return objDirection;
	} 
	
	// Creates an abstract method which is required for all Animals but differnet animals have differnt shapes so they will need to create this themselves.
	public abstract boolean inNetCheck(Point p, int netSize);
	
	// To string which will output the parents properties with the addition of the new ones creates in this class.
	public String toString(){
		String parentString = super.toString();
		return parentString + " speed=" + objSpeed + " dir=" + objDirection;
	}
}
