import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Pong extends JPanel{
	
	private int height, width, x, y;
	private Color color;
	public enum Direction {UP, DOWN, STILL};
	private Direction dir;
	
	public Pong(int x, int y, int width, int height, Color color) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		dir = Direction.STILL;
	}
	
	public void drawPong(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public void detectWallCollision(Wall wall) {
		switch(dir) {
			case UP:{
				if(y > (wall.getMinY() + wall.getWallThickness())) {
					y -= 20;
				}
				setDirection(Direction.STILL);
				break;
			}
			case DOWN:{
				if((y + height) < (wall.getMaxY() - wall.getWallThickness())) {
					y += 20;
				}
			    setDirection(Direction.STILL);
				break;
			}
			case STILL:{
				y = y;
				break;
			}
		}	
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Direction getDirection() {
		return dir;
	}
	
	public void setDirection(Direction dir) {
		this.dir = dir;
	}

}
