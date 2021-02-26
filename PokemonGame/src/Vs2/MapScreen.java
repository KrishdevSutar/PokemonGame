package Vs2;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
/* Krishdev Sutar
 * To create the map screen
 * June 14, 2018
 */
public class MapScreen extends JFrame {
	Game gui;//Object of thread used for map screen
	
	/** constructor
	  * pre: String variable
	  * post: Creates map screen
	  */
	public MapScreen(String n) {
		setSize(460,510);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gui = new Game(n, this);
		gui.setFocusable(true);
		gui.setLayout(null);
		gui.setBounds(0, 0, 460, 480);
		
		add(gui);
		setVisible(true);
	}
}
