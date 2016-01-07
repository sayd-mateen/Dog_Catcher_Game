/**
 * Name: Sayd Mateen
 * Class: CSC133
 * Assignment#1 
 * Date: 10/02/15
 *  
 *
 * This interface will determine the movement of the Net which can move in four directions.
 * Each direction that the Net can move has the templent of the movement created.
 * The net class will fill and implement these methods.
 * 
 */

package a1;

public interface IGuided {
	// Moves the net to the left.
	void moveLeft();
	
	// Moves the net up.
	void moveUp();
	
	// Moves the net down.
	void moveDown();
	
	// Moves the net to the right.
	void moveRight();
}
