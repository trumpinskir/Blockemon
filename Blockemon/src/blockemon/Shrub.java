package blockemon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Shrub extends Block{
	int colorR;
	int colorG;
	int colorB;
	
	
	int dimX;
	int dimY;
	
	int xCoordinate;
	int yCoordinate;
	
	int defaultSize = 10;
	
	Shrub(int xCoordinate, int yCoordinate, int dimX, int dimY, int R, int G, int B, Graphics2D g){
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
	}
	
	Shrub(int xCoordinate, int yCoordinate, Graphics2D g){
		
		int R, G, B;
		R = 34;
		G = 139;
		B = 34;  
		Color color = new Color(R, G , B);
        g.setColor(color);
        g.fillRect(xCoordinate,yCoordinate, defaultSize, defaultSize);
        
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        
        this.dimX = defaultSize;
        this.dimY = defaultSize;
        
        this.colorR = R;
        this.colorG = G;
        this.colorB = B;
        // call 2D array fill method
	}

	
	
	
	
	
}