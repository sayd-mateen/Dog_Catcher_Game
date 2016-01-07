/**
 * Name: Sayd Mateen
 * Assignment#1 
 * Date: 10/02/15
 *  
 * Creates the Game world by giving the layout. And will output different information about the games progress.
 * Holds all the GameObjects and is able to create more. 
 * Keeps trake of the score and will determine the Points earned.
 * 
 * 
 * 
 */

package a1;

import java.util.Scanner;
import java.util.Vector;

import a1.gameObject.*;

public class GameWorld {
	private int dogsCaptured, catsCaptured, dogsRemaining, catsRemaining, totalPoints;
	private Vector<Object> catsDogs;
	private Nets net;
	private Scanner in;
	
	// Creates the 1024, 1024 layout world for the game. Creates the net and animal objects that the user specifies in random locations.
	public void initalLayout(){
		int catsAmount, dogsAmount;
		in = new Scanner(System.in);
		System.out.println("Enter the number of cats and dogs");
		catsAmount = in.nextInt();
		dogsAmount = in.nextInt();
		catsDogs = new Vector<Object>();
		dogsRemaining = dogsAmount;
		catsRemaining = catsAmount;
		for(int i = 0; i < catsAmount; i++){
			Cats c = new Cats();
			catsDogs.addElement(c);
		}
		
		for(int i = 0; i < dogsAmount; i++){
			Dogs d = new Dogs();
			catsDogs.addElement(d);
		}
		
		net = new Nets();
	}
	
	// Upon Requesting to quit this will make sure that is the uers intention be a verification question.
	public boolean youSure(){
		System.out.print("You sure you want to quit? (y/n): ");
		String get = in.next();
		if(get.charAt(0) == 'y'){
			return true;
		}else{
			return false;
		}
	}
	
	// Prompts the user for a command and sends back the results to be used.
	public char getCommand(){
		String token;
		System.out.print("Enter command: ");
		token = in.next();
		return token.charAt(0);
	}
	
	// Returns the totals points earned.
	public int getTotalPoints(){
		return totalPoints;
	}
	
	// Return the number of dogs remaining in the game.
	public int getDogsRemaining(){
		return dogsRemaining;
	}
	
	// Specifies the action for and 'e' input command. Which is to expand the net.
	public void inputE(){
		net.expand();
	}
	
	// Specifies the action for and 'c' input command. Which will shrink the net.
	public void inputC(){
		net.contract();
	}
	
	// Specifies the action for and 's' input command. Will check if any animals are in the net bountry and will scoop them up.
	public void inputS(){
		for(int i=0;i < catsDogs.size(); i++){
			Animals a = (Animals)catsDogs.elementAt(i);
			if(a.inNetCheck(net.getLocation(), net.getSize())){
				if(a instanceof Dogs){
					totalPoints = totalPoints + 10 - ((Dogs)a).getScratches();
					catsDogs.remove(i);
					dogsCaptured++;
					dogsRemaining--;
				}else{
					totalPoints = totalPoints - 10;
					catsDogs.remove(i);
					catsCaptured++;
					catsRemaining--;
				}
			}
		}
	}
	
	// Specifies the action for and 'r' input command. Moves the net right.
	public void inputR(){
		net.moveRight();
	}
	
	// Specifies the action for and 'l' input command. Moves the net left.
	public void inputL(){
		net.moveLeft();
	}
	
	// Specifies the action for and 'u' input command. Moves the net up.
	public void inputU(){
		net.moveUp();
	}
	
	// Specifies the action for and 'd' input command. Moves the net down.
	public void inputD(){
		net.moveDown();
	}
	
	// Specifies the action for and 'k' input command. 
	public void inputK(){
		if(checkCats()){
			Cats c = new Cats();
			catsDogs.addElement(c);
			catsRemaining++;
		}else{
			System.out.println("Error no cats.");
		}
	}
	
	// Specifies the action for and 'f' input command. Will cause a dog to get attacked by a cat but first needs to determine if there is any cats on the feild.
	public void inputF(){
		if(checkCats()){
			for(int i=0;i < catsDogs.size(); i++){
				if(catsDogs.elementAt(i) instanceof Dogs){
					Dogs d = (Dogs)catsDogs.elementAt(i);
					if(d.gotScratched()){
						break;
					}else{
						continue;
					}
				}
			}
		}else{
			System.out.println("Error no cats.");
		}
	}
	
	// Specifies the action for and 't' input command. Causes a game tik which is like a sec went by causing the animals to move. 
	public void inputT(){
		for(int i=0; i<catsDogs.size(); i++){
			if(catsDogs.elementAt(i) instanceof IMoving){
				IMoving mObj = (IMoving) catsDogs.elementAt(i);
				mObj.move();
			}
		}
		
	}
	
	// Specifies the action for and 'p' input command. Prints the current information about the games progress. 
	public void inputP(){
		System.out.println("Current Score= " + totalPoints + "\nDogs: Captured= " + dogsCaptured + " Remaining= "+ dogsRemaining+ "\nCats: Captured= "+ catsCaptured + " Remaining= " + catsRemaining);
		
	}
	
	// Specifies the action for and 'm' input command. Maps the objects on the field with their properties. 
	public void inputM(){
		System.out.println(net.toString());
		for(int i=0;i < catsDogs.size(); i++){
			Animals a = (Animals)catsDogs.get(i);
			System.out.println(a.toString());
		}
	}
	
	// Check to see if there are any cats in the feild because a new cat cant be created without cats on the field already. Returns answer to be used by caller.
	private boolean checkCats(){
		int numberCats = 0;
		for(int i=0;i < catsDogs.size(); i++){
			if(catsDogs.elementAt(i) instanceof Cats){
				numberCats++;
			}
		}
		if(numberCats >= 1){
			return true;
		}else{
			return false;
		}
	}
	
}
