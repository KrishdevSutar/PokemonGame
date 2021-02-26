package Vs2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/* Krishdev Sutar
 * To create losing end game screen
 * June 14, 2018
 */
public class EndScreen implements ActionListener {
	JFrame frame1 = new JFrame();//JFrame used to GUI
	JLabel label = new JLabel("Your Pokemon has fainted. Do you want to play again?");//Says the current situation of player
	JButton btn1 = new JButton("Play Again");//Pay Again button
	JButton btn2 = new JButton("Done");//End game button
	Backgrounds background = new Backgrounds(1);//Object of background
	
	/** constructor
	  * pre: none
	  * post: Creates Losing Ending screen
	  */
	public EndScreen() {
		frame1.setSize(700, 520);
		frame1.setLayout(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		frame1.setResizable(false);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn1.setVisible(true);
		btn2.setVisible(true);
		label.setVisible(true);
		btn1.setBounds(200, 330, 125, 35);
		btn2.setBounds(350, 330, 125, 35);
		Font font = new Font("Segoe Script", Font.BOLD, 20);
		label.setFont(font);
		label.setForeground(Color.WHITE);
		label.setBounds(50, 275, 650, 20);
		background.setBounds(0, 0, 700, 520);
		background.setLayout(null);
		background.add(label);
		background.add(btn1);
		background.add(btn2);
		frame1.add(background);
	}
	/* To either end game or start new game based on which button is pressed
	 * pre: ActionEvent event
	 * post: none
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btn1) {//Play Again
			frame1.dispose();
			StartMenu frame = new StartMenu();
		}
		if (event.getSource() == btn2) {//End Game
			System.exit(0);
		}
	}
}
