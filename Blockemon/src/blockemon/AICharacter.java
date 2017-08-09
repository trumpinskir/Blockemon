package blockemon;

import java.util.ArrayList;

public class AICharacter extends People{
	long lastTurn;
	int counter;

	AICharacter(int numBalls, int numBlockemon,int dimX, int dimY, int xCoordinate, int yCoordinate,String name, ArrayList<Block> location){
		super(numBalls,numBlockemon,dimX,dimY,xCoordinate,yCoordinate,name);
		this.lastTurn = System.currentTimeMillis();
		location.add((Block)this);
		
		counter=0;
	}
	
	public void moveUpDown(){
		if (System.currentTimeMillis() - lastTurn >= 500) {
			if (counter<10){
				this.setyCoordinate(this.getyCoordinate()+5);
				this.lastTurn = System.currentTimeMillis();
				counter++;
			}
			else if(counter<20){
				this.setyCoordinate(this.getyCoordinate()-5);
				this.lastTurn = System.currentTimeMillis();
				counter++;
			}
			else if(counter==25){
				counter=0;
			}
			else{counter++;}	
		}
	}
	
	public void moveLeftRight(){
		if (System.currentTimeMillis() - lastTurn >= 500) {
			if (counter<10){
				this.setxCoordinate(this.getxCoordinate()+5);
				this.lastTurn = System.currentTimeMillis();
				counter++;
			}
			else if(counter<20){
				this.setxCoordinate(this.getxCoordinate()-5);
				this.lastTurn = System.currentTimeMillis();
				counter++;
			}
			else if(counter==30){
				counter=0;
			}
			else{counter++;}	
		}
	}
	
}
