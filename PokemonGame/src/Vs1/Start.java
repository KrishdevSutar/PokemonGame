package Vs1;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

//First thread here
public class Start extends JFrame {
	Game gui;

	// Example of implementing a thread
	// Look to tickThread
	public Start(String n) {
		setSize(460,510);//476, 519);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gui = new Game(n);
		gui.setFocusable(true);
		gui.setLayout(null);
		gui.setBounds(0, 0, 460, 480);
		
		add(gui);
		setVisible(true);
	}

	/*public static void main(String[] arguments) {
		Start frame = new Start();
	}*/

}
