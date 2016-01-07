/**
 * Name: Sayd Mateen
 * Assignment#1 
 * Date: 10/02/15
 * 
 * Primary class in the heirarchy of the Dog Catcher Game.
 * Will be the conroller of the input and direct it to the right method.  
 * After the game finishes the Game class will close program. 
 *  
 * 
 */

package a1;

public class Game {
	private GameWorld gw;
	
	// Creates the layout of the game and starts it by calling the play method.
	public Game(){
		gw = new GameWorld();
		gw.initalLayout();
		play();
	}
	
	// Repeatedly prompts the user for an input then directs the input to the right method corresponding to the request.
	// Ignores bad input and closes the Game upon request. 
	public void play(){
		char command;
		while(gw.getDogsRemaining() != 0){
			command = gw.getCommand();
			switch(command){
				case 'e': 
						gw.inputE();
						break;
				case 'c': 
						gw.inputC();
						break;
				case 's': 
						gw.inputS();
						break;
				case 'r': 
						gw.inputR();
						break;
				case 'l':
						gw.inputL();
						break;
				case 'u': 
						gw.inputU();
						break;
				case 'd': 
						gw.inputD();
						break;
				case 'k': 
						gw.inputK();
						break;
				case 'f': 
						gw.inputF();
						break;
				case 't': 
						gw.inputT();
						break;
				case 'p':
						gw.inputP();
						break;
				case 'm':
						gw.inputM();
						break;
				case 'q':						
						if(gw.youSure()){
							System.out.println("Game Over, your score is " + gw.getTotalPoints());
							System.exit(0);							}
						break;
				default: System.out.println("Error incorrect input try again.");
			}
		}
		
		// Outputs score and ends the game.
		System.out.println("Game Over, your score is " + gw.getTotalPoints());
		System.exit(0);	
	} 
}
