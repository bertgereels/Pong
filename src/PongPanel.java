import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class PongPanel extends JPanel implements KeyListener{
	
	private Pong pongLeft;
	private Pong pongRight;
	private Ball ball;
	private Wall wall;
	private Timer tickTimer;
	private static int playerLeftScore = 0;
	private static int playerRightScore = 0;
	
	public void initAll() {
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				tick();
			}
		};
		this.pongLeft = new Pong(40, 225, 10, 160, Color.blue);
		this.pongRight = new Pong(760, 225, 10, 160, Color.blue);
		this.ball = new Ball(100,50 ,20, Color.red); 
		this.wall = new Wall(0, 0, 800, 600, 20, Color.black);
		
		tickTimer = new Timer();
		tickTimer.scheduleAtFixedRate(task, 0, 200);
		
	}
	
	public static void main(String[] args) {
		JFrame frm = new JFrame("Snake Pong v1.0");
		PongPanel pnl = new PongPanel();
		pnl.setPreferredSize(new Dimension(800, 600));
	    frm.add(pnl, BorderLayout.CENTER);
	    frm.setLocation(150, 100);
	    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frm.setResizable(false);
	    frm.pack();
	    frm.addKeyListener(pnl);
	    pnl.initAll();
	    frm.setVisible(true);
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight()); //Clear screen before draw operations
		pongLeft.drawPong(g);
		pongRight.drawPong(g);
		ball.drawBall(g);
		wall.drawWalls(g);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 16)); 
		g.drawString("Score: " + playerLeftScore, 580,35);
		g.drawString("Score: " + playerRightScore, 130,35);

	}
	
	public void tick() {
		repaint();
		ball.detectPongCollision(pongLeft);
		ball.detectPongCollision(pongRight);
		ball.detectWallCollision(wall);
		pongLeft.detectWallCollision(wall);
		pongRight.detectWallCollision(wall);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
			case KeyEvent.VK_Z:
			{
				pongLeft.setDirection(Pong.Direction.UP);
				break;
			}
			case KeyEvent.VK_S:
			{
				pongLeft.setDirection(Pong.Direction.DOWN);
				break;
			}
			case KeyEvent.VK_O:
			{
				pongRight.setDirection(Pong.Direction.UP);
				break;
			}
			case KeyEvent.VK_L:
			{
				pongRight.setDirection(Pong.Direction.DOWN);
				break;
			}
		}
	}
	
	public void gameOver() {
		ball.setXSpeed(0);
		ball.setYSpeed(0);
		pongLeft.setDirection(Pong.Direction.STILL);
		pongRight.setDirection(Pong.Direction.STILL);
	}
	
	
	public static void updatePongLeftScore() {
		playerLeftScore++;
	}
	
	public static void updatePongRightScore() {
		playerRightScore++;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
}
