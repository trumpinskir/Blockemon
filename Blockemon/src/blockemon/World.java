package blockemon;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.event.*;
import javax.swing.*;


public class World extends Block implements Runnable {
	String color = "5C872D";
	int dimX = 1000;
	int dimY = 1000;
	PlayableCharacter Blocky = new PlayableCharacter(0,0,400,400,"Block");
	
	public int [][] bob =new int [1000][1000];
	    JFrame frame;
	   // int Blocky.getxCoordinate() = 400;
	  //  int Blocky.getyCoordinate() = 400;
	    Canvas canvas;
	    BufferStrategy bufferStrategy;
	    boolean running = true;
	    boolean moving = true;
	    
	    
	    
	    public World() {
	        frame = new JFrame("Blockemon");
	        JPanel panel = (JPanel) frame.getContentPane();
	        panel.setPreferredSize(new Dimension(dimX, dimY));
	        panel.setLayout(null);
	        canvas = new Canvas();
	        canvas.setBounds(0, 0, dimX, dimY);
	        canvas.setIgnoreRepaint(true);
	        panel.add(canvas);
	        canvas.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent evt) {
	                moveIt(evt);
	            }
	        });
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.pack();
	        frame.setResizable(false);
	        frame.setVisible(true);
	        canvas.createBufferStrategy(2);
	        bufferStrategy = canvas.getBufferStrategy();
	        canvas.requestFocus();
	        
	        
	        for (int x=670; x<730;x++){
	        	for(int y=370;y<430;y++){
	        		bob[x][y]=1;
	        	}
	        }
	        
	    }
	    public void run() {
	        while (running = true) {
	            Paint();
	            try {
	                Thread.sleep(5);
	            } catch (InterruptedException e) {
	            }
	        }
	    }
	    public static void main(String[] args) {
	    	
	      
	        World ex = new World();
	        new Thread(ex).start();	    
	    }
	    
	    public void Paint() {
	        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
	        g.clearRect(0, 0, 1000, 1000);
	        Paint(g);
	        bufferStrategy.show();
	    }

	     public void Paint(Graphics2D g) {
	        g.fillRect(Blocky.getxCoordinate(),Blocky.getyCoordinate(), 30, 30);
	        g.fillRect(700, 400, 30, 30);
	        
	    }
	    public void moveIt(KeyEvent evt) {
		switch (evt.getKeyCode()) {
		case KeyEvent.VK_DOWN:
			if ( Blocky.getyCoordinate()> 970) {
				Blocky.yCoordinate = 970;
			} else {
				if (bob[Blocky.getxCoordinate()][Blocky.getyCoordinate()+5]==1){
					Blocky.yCoordinate=Blocky.getyCoordinate();
				}
				else{
					Blocky.yCoordinate += 5;
				}
			}
			break;
		case KeyEvent.VK_UP:
			if (Blocky.getyCoordinate() < 0) {
				Blocky.yCoordinate = 0;
			} else {
				if (bob[Blocky.getxCoordinate()][Blocky.getyCoordinate()-5]==1){
					Blocky.yCoordinate=Blocky.getyCoordinate();
				}
				else{
					Blocky.yCoordinate -= 5;
				}
			}
			break;
		case KeyEvent.VK_LEFT:
			if (Blocky.getxCoordinate() < 0) {
				Blocky.xCoordinate = 0;
			} else {
				if (bob[Blocky.getxCoordinate()-5][Blocky.getyCoordinate()]==1){
					Blocky.yCoordinate=Blocky.getyCoordinate();
				}
				else{
					Blocky.xCoordinate -= 5;
				}
			}
			break;
		case KeyEvent.VK_RIGHT:
			if (Blocky.getxCoordinate() > 970) {
				Blocky.xCoordinate = 970;
			} else {
				if (bob[Blocky.getxCoordinate()+5][Blocky.getyCoordinate()]==1){
					Blocky.yCoordinate=Blocky.getyCoordinate();
				}
				else{
					Blocky.xCoordinate += 5;
				}
			}
			break;
		}
	}
	    
}
	
	