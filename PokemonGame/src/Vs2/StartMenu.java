package Vs2;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
/* Krishdev Sutar
 * To create a starting screen where the player can choose their Pokemon and play the game. Also there is an instruction button
 * June 14, 2018
 */
public class StartMenu implements ActionListener, ItemListener {

	String n;//Player Pokemon name
	JFrame frame1 = new JFrame();//JFrame used to GUI
	JLabel label = new JLabel("Enter which Pokemon you want.");//Label for the combo box
	JButton btn1 = new JButton("Play");//Transition Button
	JButton btn2 = new JButton("Done");//Play Button
	JButton btn3 = new JButton("Instructions");//Instructions Button
	String[] pokemon = { "Charizard", "Blastoise", "Venasaur" };//Array of Pokemon names
	JComboBox box = new JComboBox(pokemon);//Combo box for possible choices for starting pokemon
	Backgrounds background = new Backgrounds(2);//Object of background
	
	/** constructor
	  * pre: none
	  * post: Creates Starting screen and sends name of starting Pokemon
	  */
	public StartMenu() {
		frame1.setSize(700, 520);
		frame1.setLayout(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		frame1.setResizable(false);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		box.addItemListener(this);
		btn1.setVisible(true);
		btn2.setVisible(false);
		btn3.setVisible(true);
		label.setVisible(false);
		btn1.setBounds(210, 330, 125, 35);
		btn2.setBounds(300, 390, 125, 35);
		btn3.setBounds(350, 330, 125, 35);
		box.setBounds(260, 360, 200, 20);
		label.setBounds(270, 330, 1000, 30);
		background.setBounds(0, 0, 700, 520);
		background.setLayout(null);
		background.add(btn1);
		background.add(btn2);
		background.add(btn3);
		frame1.add(background);
	}
	
	/* To select the Pokemon the player wants
	 * pre: ItemEvent event
	 * post: none
	 */
	public void itemStateChanged(ItemEvent event) {
		if( ( event.getItemSelectable() == box ) && ( event.getStateChange() == ItemEvent.SELECTED ) ){
			n=event.getItem().toString();
			btn2.setVisible(true);
		}

	}
	/* To execute actions based on what button is pressed 
	 * pre: ActionEvent event
	 * post: none
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btn1) {//Play button
			btn1.setVisible(false);
			btn3.setVisible(false);
			label.setVisible(true);
			background.add(box);
			background.add(label);
		}
		if (event.getSource() == btn2) {//Starts the game
			MapScreen window = new MapScreen(n);
			frame1.dispose();
		}
		if (event.getSource() == btn3) {//instructions button
			JOptionPane.showMessageDialog(null,"Rules:\n"
					+ "You play as a Pokemon Trainer and your goal is to beat all 7 trainers in this route\n"
					+ "You will get a choice between three Pokemon: Charizard the Fire type, Blastoise the Water type, and Venasaur the Grass type\n"
					+ "Each Pokemon has 4 attacks, choose wisely on hwo you wish to fight to because type advantage matters\n"
					+ "Whoever health drop to zero first wins the battle\n"
					+ "If your health drops to zero before your opponent, then you lose and you will have to start from the very beginning\n"
					+ "Once you have won a battle, your health will reset to its orignal value\n"
					+ "Be careful because the grass contains wild Pokemon\n"
					+ "Good Luck Pokemon Trainers");
		}

	}

	public static void main(String[] arguments) {
		StartMenu frame = new StartMenu();
	}
}
