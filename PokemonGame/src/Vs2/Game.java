package Vs2;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
/* Krishdev Sutar
 * To add a thread to the map screen
 * June 14, 2018
 */
public class Game extends JPanel implements Runnable, KeyListener {
	JFrame fr;//JFrame used to GUI
	Thread runner;//Thread for map screen drawing
	SpriteMovement L;//Object of sprite movement
	boolean running = true;//Allows thread to run
	/** constructor
	  * pre: A String variable and a JFrame
	  * post: Start the thread that constantly refreshes the drawing of the map and other images
	  */
	public Game(String n, JFrame f) {
		super();
		addKeyListener(this);
		this.fr = f;
		L = new SpriteMovement(n);
		runner = new Thread(this);
		runner.start();
	}
	/* To send Graphics component to other paintComponents to draw images
	 * pre: Graphics component
	 * post: none
	 */
	public void paintComponent(Graphics comp) {
		L.paintLevel((Graphics2D) comp, this);
	}
	/* To run a constant loop as well as constantly repaint the images using a thread
	 * pre: none
	 * post: none
	 */
	public void run() {
		Thread thisThread = Thread.currentThread();
		while (runner == thisThread) {
			while (running) {
				repaint();
				if(BattleThread.point>=7){
					fr.dispose();
					running = false;
				}
			}
			requestFocus();
		}
	}
	//Event Handler for key pressed
	public void keyPressed(KeyEvent event) {
	}
	/* To send KeyEvent event to other KeyEvent to execute program accordingly based off the key released
	 * pre: KeyEvent event
	 * post: none
	 */
	public void keyReleased(KeyEvent event) {
		L.keyReleased(event);
	}
	//Event Handler for key typed
	public void keyTyped(KeyEvent event) {
	}
}
