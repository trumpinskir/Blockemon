package blockemon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Shrub extends Block{
	
	
	Shrub(int xCoordinate, int yCoordinate, int dimX, int dimY, int R, int G, int B){
        
        this.setxCoordinate(xCoordinate);
        this.setyCoordinate(yCoordinate);
        
        this.setDimX(dimX);
        this.setDimY(dimY);
        
        this.colorR = R;
        this.colorG = G;
        this.colorB = B;
	}
	

	
	Shrub(int xCoordinate, int yCoordinate){
		
		int R, G, B;
		R = 34;
		G = 139;
		B = 34;  
		
        
        
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