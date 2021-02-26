package Vs1;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

//This whole class is a runnable object
public class Game extends JPanel implements Runnable, KeyListener {
	Thread runner;
	int speed = 20;
	SpriteMovement L;
	boolean running = true;

	public Game(String n) {
		super();
		addKeyListener(this);
		L = new SpriteMovement(n);
		runner = new Thread(this);
		runner.start();
	}

	public void paintComponent(Graphics comp) {
		L.paintLevel((Graphics2D) comp, this);
	}

	public void run() {
		Thread thisThread = Thread.currentThread();
		while (runner == thisThread) {
			while (running) {
				repaint();
				/*
				 * try { Thread.sleep(speed); } catch (InterruptedException e) {
				 * } // do nothing
				 */
			}
			requestFocus();
		}
	}

	public void keyPressed(KeyEvent event) {
		// L.keyPressed(event);
	}

	public void keyReleased(KeyEvent event) {
		L.keyReleased(event);
	}

	public void keyTyped(KeyEvent event) {
	}

}
