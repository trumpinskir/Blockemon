package blockemon;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;


public class World extends Block implements Runnable {
	int dimX = 1000;
	int dimY = 1000;
	int [][] limits =new int [1000][1000];
	ArrayList<Block> location = new ArrayList<Block>(20);
	PlayableCharacter Blocky = new PlayableCharacter(0,0,30,30,400,400,"Block");
	
	JFrame frame;
	Canvas canvas;
	BufferStrategy bufferStrategy;
	boolean running = true;
	boolean moving = true;
	    
	
	public World() {
	    initializeCanvas();
	}
	
	
	public void run() {
	    while (running = true) {
	    	Paint();
	        try {
	        	Thread.sleep(20);
	        } 
	        catch (InterruptedException e) {
	        }
	    }
	}
	
	
	public void initializeCanvas(){
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
	    //bufferStrategy = canvas.getBufferStrategy();
	    canvas.requestFocus();
	}
	    
	
	public void Paint() {
		Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
	   g.clearRect(0,0,1000,1000);
	    Paint(g);
	    bufferStrategy.show();
	    
	}

	
	 public void Paint(Graphics2D g) {
		 
		Color color = new Color(0,0,0);
		Shrub shrubooya = new Shrub(300,700, g);
		
		g.setColor(color);
	    g.fillRect(Blocky.getxCoordinate(),Blocky.getyCoordinate(), 30, 30);
	    setBoundries();
	 }
	 
	 
	 public void setBoundries(){
		 for (int index=0;index<location.size();index++){
			 Block b = location.get(index);			 
			 
			 int lowx=b.getxCoordinate()-Blocky.getDimX();
			 int highx=b.getxCoordinate()+b.getDimX()+1;
			 int lowy=b.getyCoordinate()-Blocky.getDimY();
			 int highy=b.getyCoordinate()+b.getDimY()+1;
			 
			 for (int x=lowx; x<highx;x++){
				 for(int y=lowy;y<highy;y++){
					 limits[x][y]=1;
				 }
			 }
		 }
	 }
	 
	 
	 
	 public void moveIt(KeyEvent evt) {
		 switch (evt.getKeyCode()) {
		 case KeyEvent.VK_DOWN:
			 if ( Blocky.getyCoordinate()> 970) {
				Blocky.yCoordinate = 970;
			} else {
				if (limits[Blocky.getxCoordinate()][Blocky.getyCoordinate()+5]==1){
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
				if (limits[Blocky.getxCoordinate()][Blocky.getyCoordinate()-5]==1){
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
				if (limits[Blocky.getxCoordinate()-5][Blocky.getyCoordinate()]==1){
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
				if (limits[Blocky.getxCoordinate()+5][Blocky.getyCoordinate()]==1){
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
	
	

	
	