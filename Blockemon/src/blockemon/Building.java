package blockemon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Building extends Block{
	
	Building(int xCoordinate, int yCoordinate, int dimX, int dimY, int R, int G, int B, Graphics2D g, ArrayList<Block> location){
		
		Color color = new Color(R,G,B);
        g.setColor(color);
        g.fillRect(xCoordinate,yCoordinate, dimX, dimY);
        
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        
        this.dimX = dimX;
        this.dimY = dimY;
        
        this.colorR = R;
        this.colorG = G;
        this.colorB = B;
        // call 2D array fill method
        location.add((Block)this);

	}
	
	

	public int getDimX() {
		return dimX;
	}
	public void setDimX(int dimX) {
		this.dimX = dimX;
	}
	public int getDimY() {
		return dimY;
	}
	public void setDimY(int dimY) {
		this.dimY = dimY;
	}


	public int getxCoordinate() {
		return xCoordinate;
	}


	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}


	public int getyCoordinate() {
		return yCoordinate;
	}


	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	
}