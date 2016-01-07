/**
 * Name: Sayd Mateen
 * Class: CSC133
 * Assignment#1 
 * Date: 10/02/15
 *  
 * Will hold the information of the point of each object.
 * Holds the position on the game world with its x y coordinte.  
 * 
 */

package a1;

public class Point {
	private float locationX, locationY;
	
	// Creates the object with the default loction.
	public Point(){
		locationX = 0;
		locationY = 0;
	}
	
	// Returns the x position.
	public float getX(){
		return locationX;
	}
	
	// Return the y position.
	public float getY(){
		return locationY;
	}
	
	// Sets the x and y loction of the object.
	public void setPostion(float x, float y){
		locationX = x;
		locationY = y;
	}
	
	// Can set the position of the x individually.
	public void setX(float x){
		locationX = x;
	}
	
	// Can set the position of the y individually. 
	public void setY(float y){
		locationY = y;
	}

}
