package Vs2;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

/* Krishdev Sutar
 * To add a thread to the battle screen
 * June 14, 2018
 */
public class BattleThread extends JPanel implements Runnable, ActionListener {
	Battle L;// Object of Battle Mechanics
	JButton btn1;// Attack 1 button
	JButton btn2;// Attack 2 button
	JButton btn3;// Attack 3 button
	JButton btn4;// Attack 4 button
	JFrame frame;// JFrame used to GUI
	JLabel opName;// Labels Opponent pokemon name
	JLabel plyName;// Labels Player pokemon name
	Pokemon plyer;// Object of Player pokemon name
	Thread runner1;// Thread for battle screen drawing
	OpponentPokemon op;// Object of Opponent pokemon name
	boolean running = true;// Allows thread to run
	public boolean clicked = false;
	public static int point = 0;// Number of trainers defeated

	/**
	 * constructor pre: Pokemon object, Opponent Pokemon object, integer
	 * variable, and a JFrame post: Creates battle screen and creates Pokemon
	 * and Opponent Pokemon objects
	 */
	public BattleThread(Pokemon p, OpponentPokemon c, int pl, JFrame f) {
		this.frame = f;
		this.plyer = p;
		this.op = c;
		point = point + pl;
		L = new Battle(p, c, this);
		runner1 = new Thread(this);
		runner1.start();

		btn1 = new JButton(plyer.moves[0].name);// Attack 1
		btn2 = new JButton(plyer.moves[1].name);// Attack 2
		btn3 = new JButton(plyer.moves[2].name);// Attack 3
		btn4 = new JButton(plyer.moves[3].name);// Attack 4

		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		opName = new JLabel(c.name);
		plyName = new JLabel(p.name);
		Font font = new Font("Segoe Script", Font.BOLD, 25);
		opName.setFont(font);
		opName.setForeground(Color.WHITE);
		opName.setBounds(50, -25, 190, 100);

		plyName.setFont(font);
		plyName.setForeground(Color.WHITE);
		plyName.setBounds(700, 300, 190, 100);

		btn1.setBounds(650, 400, 150, 50);
		btn2.setBounds(650, 470, 150, 50);
		btn3.setBounds(805, 400, 150, 50);
		btn4.setBounds(805, 470, 150, 50);

		add(opName);
		add(plyName);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
	}

	/*
	 * To send Graphics component to other paintComponents to draw images pre:
	 * Graphics component post: none
	 */
	public void paintComponent(Graphics comp) {
		L.paintLevel((Graphics2D) comp, this);
	}

	/*
	 * To run a constant loop as well as constantly repaint the images using a
	 * thread pre: none post: none
	 */
	public void run() {
		Thread thisThread = Thread.currentThread();
		while (runner1 == thisThread) {
			while (running) {
				repaint();
			}
			requestFocus();
		}
	}

	/*
	 * To determine amount of damage dealt and received based on which attack
	 * was used 
	 * pre: ActionEvent event 
	 * post: none
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btn1) {//Attack #1
			btn1.setVisible(false);
			btn2.setVisible(false);
			btn3.setVisible(false);
			btn4.setVisible(false);
			L.damageCalculator(1);
		}
		if (event.getSource() == btn2) {//Attack #2
			L.damageCalculator(2);
		}
		if (event.getSource() == btn3) {//Attack #3
			L.damageCalculator(3);
		}
		if (event.getSource() == btn4) {//Attack #4
			L.damageCalculator(4);
		}
		
	}

	/*
	 * To determine the otucome based on whose health dropped to zero first pre:
	 * none post: none
	 */
	public void win() {
		if (op.curhealth <= 0) {// Winning Option
			SpriteMovement.temp1 = false;
			SpriteMovement.temp2 = false;
			SpriteMovement.temp3 = false;
			SpriteMovement.temp4 = false;
			SpriteMovement.temp5 = false;
			SpriteMovement.temp6 = false;
			SpriteMovement.temp7 = false;
			frame.dispose();
			if (point >= 7) {// Win condition if all trainers are defeated
				int option = JOptionPane
						.showConfirmDialog(
								null,
								"Congrats, You have beat all of the trainers in this route. Do you want ot play again?");
				if (option == JOptionPane.YES_OPTION) {
					frame.dispose();
					StartMenu again = new StartMenu();
				}
				if (option == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
			}
		} else if (plyer.curhealth <= 0) {// Losing Option
			frame.dispose();
			EndScreen game = new EndScreen();
			//
		}
	}
	
}
