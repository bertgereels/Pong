import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	private int radius, x, y;
	private int initX, initY, initXSpeed, initYSpeed;
	private int xSpeed, ySpeed;
	private Color color;
	
	public Ball(int x, int y, int radius, Color color) {
		this.x = x;
		this.y = y;
		initX = x;
		initY = y;
		this.radius = radius;
		this.color = color;
		this.xSpeed = 20;
		initXSpeed = xSpeed;
		this.ySpeed = 20;
		initYSpeed = ySpeed;
	}
	
	public void drawBall(Graphics g) {
		//if(PongPanel.getTickCount() % 4 == 0) {
			g.setColor(color);
			g.fillOval(x, y, radius,radius);
		//}
	}
	
	public void initBall() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		x = initX;
		y = initY;
		xSpeed = initXSpeed;
		ySpeed = initYSpeed;
	}

	public void moveBall() {
		x += xSpeed;
		y += ySpeed;	
	}
	
	public void detectPongCollision(Pong pongLeft, Pong pongRight) {
		if(x - pongLeft.getWidth() <= pongLeft.getX() + pongLeft.getWidth() && y >= pongLeft.getY() && y <= pongLeft.getY() + pongLeft.getHeight()) {
			x = pongLeft.getX() + pongLeft.getWidth() + radius;
			xSpeed = - xSpeed;
		}
		if(x + radius >= pongRight.getX() - pongRight.getWidth() && y >= pongRight.getY() && y <= pongRight.getY() + pongRight.getHeight()) {
			x = pongRight.getX() - pongRight.getWidth() - radius;
			xSpeed = - xSpeed;
		}
	}
	
	public void detectWallCollision(Wall wall) {
		int ballMinX = wall.getMinX() + wall.getWallThickness();
	    int ballMinY = wall.getMinY() + wall.getWallThickness();
	    int ballMaxX = wall.getMaxX() - radius - wall.getWallThickness();
	    int ballMaxY = wall.getMaxY() - radius - wall.getWallThickness();
	    
	    x += xSpeed;
		y += ySpeed;
		
	    if (x < ballMinX) {
	    	PongPanel.updatePongLeftScore();
	    	initBall();
	    } else if (x > ballMaxX) {
	    	PongPanel.updatePongRightScore();
	    	initBall();
	    }
	    if (y < ballMinY) {
	    	ySpeed = -ySpeed;
	        y = ballMinY;
	    } else if (y > ballMaxY) {
	    	ySpeed = -ySpeed;
	        y = ballMaxY;
	    }
	}
	
	
	public void setXSpeed(int value) {
		xSpeed = value;
	}
	
	public void setYSpeed(int value) {
		ySpeed = value;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
}
