package Example;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;
/* Krishdev Sutar
 * To create a health bar that decreases as deall damage by pressing a button
 */
public class Healthbar extends JPanel implements Runnable,ActionListener {
	Thread runner1;//Helps create constant loop
	JButton btn1 = new JButton("Damage");//Damage button
	JFrame frame = new JFrame();///JFrame that is used for GUI
	boolean running = true;//Condition that allows loop to continue
	int buffer1 = 300, health1 = 300;//Variables that store health values
	/**
	 * constructor
	 * pre: none
	 * post: Creates a screen and implements action listener
	 */
	public Healthbar() {
		frame.setSize(500, 300);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		runner1 = new Thread(this);
		runner1.start();

		this.setFocusable(true);
		this.setLayout(null);
		this.setBounds(0, 0, 500, 500);

		btn1.addActionListener(this);
		btn1.setBounds(200, 200, 100, 50);
		this.add(btn1);
		frame.add(this);
		
	}
	/* To draw the health event when it decreases
	 * pre: Graphics component
	 * post: none
	 */
	public void paintComponent(Graphics comp) {
		Graphics2D comp2D = (Graphics2D) comp;
		BufferedImage image = new BufferedImage(500, 300,//Allows the constant changes as the image is drawn multiple times
				BufferedImage.TYPE_BYTE_BINARY);
		comp2D.drawImage(image, 0, 0, this);
		comp2D.setPaint(Color.GREEN);
		if (buffer1 > health1) {//Draws health bar as it decreases
			comp2D.fillRect(50, 100, buffer1, 30);//draws as it decreases
			buffer1--;
		}
		comp2D.fillRect(50, 100, buffer1, 30);//Final draw of health bar
	}
	/* To run a constant loop as well as constantly repaint the images using a thread
	 * pre: none
	 * post: none
	 */
	public void run() {
		while (running) {
			repaint();
		}
		requestFocus();
	}
	/* To decreases health every time button is clicked
	 * pre: ActionEvent event
	 * post: none
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btn1) {//Decreases health as button is clicked
		health1=health1-50;
		}
	}
	public static void main(String[] args) {
		Healthbar game= new Healthbar();

	}

	

}
