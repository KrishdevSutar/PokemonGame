package Vs2;

import java.awt.*;

import javax.swing.*;
/* Krishdev Sutar
 * To create backgrounds for JFrame that do not have any involvement with threads
 * June 14, 2018
 */
public class Backgrounds extends JPanel {
	Image background;//Stores the image
	/** constructor
	  * pre: A integer variable
	  * post: Imports all background images
	  */
	public Backgrounds(int num) {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		if(num==1){
			this.background = kit.getImage("background2.png").getScaledInstance(700,520, java.awt.Image.SCALE_SMOOTH);	
		}else if(num==2){
			this.background = kit.getImage("background4.png").getScaledInstance(700, 520, java.awt.Image.SCALE_SMOOTH);
		}
	}
	/* To draw the images
	 * pre: Graphics component
	 * post: none
	 */
	public void paintComponent(Graphics comp) {
		Graphics2D comp2D = (Graphics2D) comp;
		comp.drawImage(background, 0, 0, this);
	}

}
