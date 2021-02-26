package Vs1;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class StartMenu implements ActionListener, ItemListener {

	String n;

	JFrame frame1 = new JFrame();
	JPanel pnl = new JPanel();
	JLabel label = new JLabel("Enter which Pokemon you want.");
	JButton btn1 = new JButton("Play");
	JButton btn2 = new JButton("Done");
	JTextField text = new JTextField();
	String[] pokemon = { "Charizard", "Blastoise", "Venasaur" };
	JComboBox box = new JComboBox(pokemon);
	Backgrounds background = new Backgrounds(2);

	public StartMenu() {
		frame1.setSize(700, 520);
		frame1.setLayout(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		frame1.setResizable(false);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		box.addItemListener( this ) ;
		btn1.setVisible(true);
		btn2.setVisible(false);
		label.setVisible(false);
		btn1.setBounds(300, 330, 125, 35);
		btn2.setBounds(300, 380, 125, 35);
		box.setBounds(260, 350, 200, 20);
		label.setBounds(250, 330, 400, 20);
		background.setBounds(0, 0, 700, 520);
		background.setLayout(null);
		background.add(btn1);
		background.add(btn2);
		frame1.add(background);
	}

	public void itemStateChanged(ItemEvent event) {
		if( ( event.getItemSelectable() == box ) && ( event.getStateChange() == ItemEvent.SELECTED ) ){
			n=event.getItem().toString();
			btn2.setVisible(true);
		}

	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btn1) {
			btn1.setVisible(false);
			label.setVisible(true);
			background.add(box);
			background.add(label);
		}
		if (event.getSource() == btn2) {
			Start window = new Start(n);
			frame1.dispose();
		}

	}

	public static void main(String[] arguments) {
		StartMenu frame = new StartMenu();
	}
}
