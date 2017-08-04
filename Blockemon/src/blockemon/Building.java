package blockemon;

import java.awt.Color;
import java.awt.Graphics2D;

public class Building extends Block{
	int colorR;
	int colorG;
	int colorB;
	
	int dimX;
	int dimY;
	
	Building(int xCoordinate, int yCoordinate, int dimX, int dimY, int R, int G, int B, Graphics2D g){
		Color color = new Color(R,G,B);
        g.setColor(color);
        g.fillRect(xCoordinate,yCoordinate, dimX, dimY);
        // call 2D array fill method
	}
	
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	
	
}