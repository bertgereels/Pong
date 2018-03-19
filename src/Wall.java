import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Wall extends JPanel{
	
	private int minX, minY, maxX, maxY; 
	private int wallThickness;
	private Color color;
	
	public Wall(int minX, int minY, int maxX, int maxY, int wallThickness, Color color) {
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;	
		this.wallThickness = wallThickness;
		this.color = color;
	}
	
	public void drawWalls(Graphics g) {
		g.setColor(color);
		g.fillRect(minX, minY, maxX, wallThickness);
		g.fillRect(minX, minY, wallThickness, maxY);
		g.fillRect(maxX - wallThickness, minY, wallThickness, maxY);
		g.fillRect(minX, maxY - wallThickness, maxX, wallThickness);
	}
	
	public int getWallThickness() {
		return this.wallThickness;
	}
	
	public int getMinY() {
		return this.minY;
	}
	
	public int getMaxY() {
		return this.maxY;
	}
	
	public int getMinX() {
		return this.minX;
	}
	
	public int getMaxX() {
		return this.maxX;
	}
	
}
