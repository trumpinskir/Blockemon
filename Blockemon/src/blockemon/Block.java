package blockemon;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Block {
	
	int dimX;
	int dimY;
	int xCoordinate;
	int yCoordinate;
	int colorR, colorG, colorB;
	int defaultSize = 30;
	//Color color = new Color(colorR, colorG , colorB);
	
	public void show(Graphics2D g,int r,int gg, int b){
		Color color = new Color(r, gg, b);
		g.setColor(color);
        g.fillRect(xCoordinate,yCoordinate, defaultSize, defaultSize);
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
	public int getDimX() {
		return dimX;
	}
	public void setDimX(int dimX) {
		this.dimX = dimX;
	}
	public int getColorR() {
		return colorR;
	}

	public void setColorR(int colorR) {
		this.colorR = colorR;
	}

	public int getColorG() {
		return colorG;
	}

	public void setColorG(int colorG) {
		this.colorG = colorG;
	}

	public int getColorB() {
		return colorB;
	}

	public void setColorB(int colorB) {
		this.colorB = colorB;
	}

	public int getDimY() {
		return dimY;
	}
	public void setDimY(int dimY) {
		this.dimY = dimY;
	}
}
