/**
 * Name: Sayd Mateen
 * Class: CSC133
 * Assignment#1 
 * Date: 10/02/15
 *  
 *
 * Top level of the game instance. Creates the major properties that will determine every game object.
 * Gives such properties as the size, color, and locaiton which every object has.
 * Creates the seters and getter which will make the class safe.
 * 
 * 
 */

package a1.gameObject;

import java.awt.Color;
import a1.Point;

public class GameObject {
	private Color objColor;
	private Point objPoint;
	private int objSize;
	
	// Creates the point upon creation of the instance.
	public GameObject(){
		objPoint = new Point();
	}
	
	// Sets the color to the user specifications.
	public void setColor(int x, int y, int z){
		objColor = new Color(x, y, z);
	}
	
	// Send back the Color object for the caller to detrmine its properties.
	public Color getColor(){
		return objColor;
	}
	
	// Sets the object size.
	public void setSize(int size){
		objSize = size;
	}
	
	// Sends back the size to the caller.
	public int getSize(){
		return objSize;
	}
	
	// Changes the loction of the object.
	public void setLocation(float x, float y){
		objPoint.setPostion(x, y);
	}
	
	// Changes only the x position object. Leaves y postion the same.
	public void setLocationX(float xx){
		objPoint.setX(xx);
	}
	
	// Changes only the y position object. Leaves the x position the same.
	public void setLocationY(float yy){
		objPoint.setY(yy);
	}
	
	// Sends back the Point object to the caller to be able to determine its properties.
	public Point getLocation(){
		return objPoint;
	}
	
	// Converts to string all the revealent information in this class.
	public String toString(){
		return "loc=" + getLocation().getX() + ", " + getLocation().getY() + " color=[" + getColor().getRed() + "," + getColor().getGreen() + "," + getColor().getBlue() + "] size=" + getSize();
	}
		
}
