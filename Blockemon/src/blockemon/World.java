package blockemon;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;


public class World extends Block implements Runnable {
	String color = "5C872D";
	int dimX = 1000;
	int dimY = 1000;
	int [][] limits =new int [1000][1000];
	ArrayList<Block> location = new ArrayList<Block>(20);
	PlayableCharacter Blocky = new PlayableCharacter(0,0,30,30,400,400,"Block");
	AICharacter AI = new AICharacter(0,0,30,30,300,300,"AI",location);
	AICharacter AI2 = new AICharacter(0,0,30,30,100,100,"AI",location);
	
	private int velX;
	private int velY;
	private int speed=5;
	
	JFrame frame;
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
	    	@Override
	    	public void keyReleased(KeyEvent evt){
	    		if((evt.getKeyCode() != KeyEvent.VK_UP || evt.getKeyCode() != KeyEvent.VK_DOWN) &&
	    					!(evt.getKeyCode() == KeyEvent.VK_LEFT || evt.getKeyCode() == KeyEvent.VK_RIGHT)){
		    		velY = 0;
	    		}
	    		if((evt.getKeyCode() != KeyEvent.VK_LEFT || evt.getKeyCode() != KeyEvent.VK_RIGHT) &&
	    					!(evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN)){
		    		velX = 0;
	    		}
	    		
	    	}
	    });
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setResizable(false);
	    frame.setVisible(true);
	    canvas.createBufferStrategy(2);
	    bufferStrategy = canvas.getBufferStrategy();
	    canvas.requestFocus();	        
	}
	public void run() {
	    while (running = true) {
	    	Paint();
	        try {
	        	Thread.sleep(25);
	        } 
	        catch (InterruptedException e) {
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
		Blocky.setxCoordinate(Blocky.getxCoordinate()+velX);
		Blocky.setyCoordinate(Blocky.getyCoordinate()+velY);
	    g.fillRect(Blocky.getxCoordinate(),Blocky.getyCoordinate(), 30, 30);
	    g.fillRect(AI.getxCoordinate(), AI.getyCoordinate(), 30, 30);
	    g.fillRect(AI2.getxCoordinate(), AI2.getyCoordinate(), 30, 30);
	    
	    AI.moveUpDown();
	    AI2.moveLeftRight();
	    Building building = new Building(700,400,50,100,0,191,255,g,location); 
	    Building building2 = new Building(100,600,150,200,0,191,255,g,location);
	    Building building3 = new Building(500,200,250,100,0,191,255,g,location);
	    
	    setBoundries();
	    manageBoundaries();
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
	 
	 public void manageBoundaries(){
		 if ( Blocky.getyCoordinate()> 970) {
	 			Blocky.yCoordinate = 970;
	 			velX =0;
	 			velY =0;
	 		}
		 if (Blocky.getyCoordinate() < 0) {
	 			Blocky.yCoordinate = 0;
	 			velX =0;
	 			velY =0;
	 		}
		 if (Blocky.getxCoordinate() < 0) {
	 			Blocky.xCoordinate = 0;
	 			velX =0;
	 			velY =0;
	 			speed =0;
	 		}
		 if (Blocky.getxCoordinate() > 970) {
	 			Blocky.xCoordinate = 970;
	 			velX =0;
	 			velY =0;
	 		}
		 if (limits[Blocky.getxCoordinate()][Blocky.getyCoordinate()+5]==1){
				Blocky.yCoordinate=Blocky.getyCoordinate();
				velX =0;
	 			velY =0;
			}
		 if (limits[Blocky.getxCoordinate()][Blocky.getyCoordinate()-5]==1){
				Blocky.yCoordinate=Blocky.getyCoordinate();
				velX =0;
	 			velY =0;
			}
		 if (limits[Blocky.getxCoordinate()-5][Blocky.getyCoordinate()]==1){
				Blocky.yCoordinate=Blocky.getyCoordinate();
				velX =0;
	 			velY =0;
			}
		 if (limits[Blocky.getxCoordinate()+5][Blocky.getyCoordinate()]==1){
				Blocky.yCoordinate=Blocky.getyCoordinate();
				velX =0;
	 			velY =0;
			}
	 }
	 
	 
	 public void moveIt(KeyEvent evt) {
		 
		 switch (evt.getKeyCode()) {
		 	case KeyEvent.VK_DOWN:
		 		
		 		if ( Blocky.getyCoordinate()> 970) {
		 			Blocky.yCoordinate = 970;
		 			velX =0;
		 			velY =0;
		 		}
		 		else {
		 			if (limits[Blocky.getxCoordinate()][Blocky.getyCoordinate()+5]==1){
		 				Blocky.yCoordinate=Blocky.getyCoordinate();
		 				velX =0;
			 			velY =0;
		 			}
		 			else{
		 				velX = 0;
		 				velY = speed;
		 			}
		 		}
		 		break;
		 	case KeyEvent.VK_UP:
		 		if (Blocky.getyCoordinate() < 0) {
		 			Blocky.yCoordinate = 0;
		 			velX =0;
		 			velY =0;
		 		}
		 		else {
		 			if (limits[Blocky.getxCoordinate()][Blocky.getyCoordinate()-5]==1){
		 				Blocky.yCoordinate=Blocky.getyCoordinate();
		 				velX =0;
			 			velY =0;
		 			}
		 			else{
		 				velX = 0;
		 				velY = -speed;
		 			}
		 		}
		 		break;
		 	case KeyEvent.VK_LEFT:
		 		if (Blocky.getxCoordinate() < 0) {
		 			Blocky.xCoordinate = 0;
		 			velX =0;
		 			velY =0;
		 		}
		 		else {
		 			if (limits[Blocky.getxCoordinate()-5][Blocky.getyCoordinate()]==1){
		 				Blocky.yCoordinate=Blocky.getyCoordinate();
		 				velX =0;
			 			velY =0;
		 			}
		 			else{
		 				velX = -speed;
		 				velY = 0;
		 			}
		 		}
		 		break;
		 	case KeyEvent.VK_RIGHT:
		 		if (Blocky.getxCoordinate() > 970) {
		 			Blocky.xCoordinate = 970;
		 			velX =0;
		 			velY =0;
		 		}
		 		else {
		 			if (limits[Blocky.getxCoordinate()+5][Blocky.getyCoordinate()]==1){
		 				Blocky.yCoordinate=Blocky.getyCoordinate();
		 				velX =0;
			 			velY =0;
		 			}
		 			else{
		 				velX = speed;
		 				velY = 0;
		 			}
		 		}
		 		break;
		 	case KeyEvent.VK_A:
		 		if(limits[Blocky.getxCoordinate()+5][Blocky.getyCoordinate()]==1){	
		 			JOptionPane.showMessageDialog(frame, "Battle!");
		 		}
		 		if(limits[Blocky.getxCoordinate()-5][Blocky.getyCoordinate()]==1){	
		 			JOptionPane.showMessageDialog(frame, "Battle!");
		 		}
		 		if(limits[Blocky.getxCoordinate()][Blocky.getyCoordinate()+5]==1){	
		 			JOptionPane.showMessageDialog(frame, "Battle!");
		 		}
		 		if(limits[Blocky.getxCoordinate()][Blocky.getyCoordinate()-5]==1){	
		 			JOptionPane.showMessageDialog(frame, "Battle!");
		 		}
		 		break;
		 	
		 	
		 }
	}
	public PlayableCharacter getBlocky() {
		return Blocky;
	}
	public void setBlocky(PlayableCharacter blocky) {
		Blocky = blocky;
	}
	public int getVelX() {
		return velX;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public int getVelY() {
		return velY;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}	    
}
	
	