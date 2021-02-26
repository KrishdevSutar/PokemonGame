package Vs1;

import java.awt.*;

import javax.swing.*;

public class Backgrounds extends JPanel {
	Image background;

	public Backgrounds(int num) {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit();
		if(num==1){
			this.background = kit.getImage("background5.png").getScaledInstance(1000,600, java.awt.Image.SCALE_SMOOTH);	
		}else if(num==2){
			this.background = kit.getImage("background4.png").getScaledInstance(700, 520, java.awt.Image.SCALE_SMOOTH);
		}
	}

	public void paintComponent(Graphics comp) {
		Graphics2D comp2D = (Graphics2D) comp;
		comp.drawImage(background, 0, 0, this);
	}

}
