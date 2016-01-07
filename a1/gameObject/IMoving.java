/**
 * Name: Sayd Mateen
 * Class: CSC133
 * Assignment#1 
 * Date: 10/02/15
 *  
 * This interface will determine the move method of each Animal object.
 * The concrete animal classes will implement this methdo becused it uses the object speed and direction to determine its move.
 * 
 * 
 * 
 */

package a1.gameObject;

public interface IMoving {
	
	// The move will be as if one tick went by and by the animals speed and direction it will move it.
	void move();
}
