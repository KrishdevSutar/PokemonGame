package Vs1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
/*DIVIDE REDBOX INTO TWO PARTS
 *FIGURE HOW TO PROCESS SITUATION WHEN BOX TOUCHES BOTH GRASS AND TRAINER
 *INCLUDING HOW TO SPAWN POKES AFTER TRAINER BATTLE
 * 
 */
public class SpriteMovement {
	Image background, redright, redleft, redup, reddown, Sprite, op1, op2, op3, op4;
	int xCoordinate=90, yCoordinate=90, oldx,oldy;
	int width = 460;
	int height = 480;
	String nm;
	boolean touched1 = false, touched2 = false, touched3 = false, 
			touched4 = false, touched5 = false, touched6 = false,
					touched7 = false;
	
	public Rectangle2D.Double redbox,wallBox1,wallBox2,wallBox3,wallBox4,wallBox5,wallBox6,
	wallBox7,wallBox8,wallBox9,wallBox10,wallBox11,wallBox12,wallBox13,wallBox14,wallBox15,
	wallBox16,wallBox17,wallBox18,wallBox19,wallBox20,wallBox21,wallBox22,wallBox23,wallBox24,
	wallBox25,wallBox26,wallBox27,wallBox28,wallBox29;

	public SpriteMovement(String n) { // super();
		this.nm=n;
		Toolkit kit = Toolkit.getDefaultToolkit();
		redup = kit.getImage("redup.png");
		redleft = kit.getImage("redleft.png");
		reddown = kit.getImage("reddown.png");
		redright = kit.getImage("redright.png");
		background = kit.getImage("background3.png").getScaledInstance(460, 480, java.awt.Image.SCALE_SMOOTH);

		Sprite = reddown;
		
		op1 = kit.getImage("opup.png");
		op2 = kit.getImage("opleft.png");
		op3 = kit.getImage("opdown.png");
		op4 = kit.getImage("opright.png");;
		
		redbox = new Rectangle2D.Double(xCoordinate+5, yCoordinate+3, 15, 20);
		wallBox1 = new Rectangle2D.Double(0, 0, 30, 480);//left vertical border//left
		wallBox2 = new Rectangle2D.Double(0, 0, 440, 35);//top horizontal border//up
		wallBox3 = new Rectangle2D.Double(0, 435, 440, 45);//bottom horizontal border//down
		wallBox4 = new Rectangle2D.Double(430, 0, 30, 480);//right vertical border//right
		wallBox5 = new Rectangle2D.Double(120, 132, 185, 15);//middle tree//down
		wallBox6 = new Rectangle2D.Double(120, 135, 15, 185);//middle tree//right
		wallBox7 = new Rectangle2D.Double(285, 132, 25, 93);//middle tree//left
		wallBox8 = new Rectangle2D.Double(120, 305, 90, 15);//middle tree//up
		wallBox9 = new Rectangle2D.Double(197, 200, 15, 120);//middle tree//left
		wallBox10 = new Rectangle2D.Double(205, 200, 90, 25);//middle tree//up
		wallBox11 = new Rectangle2D.Double(220, 30, 15, 38);//right corner tree//right
		wallBox12 = new Rectangle2D.Double(235, 53, 205, 15);//right corner tree//up
		wallBox13 = new Rectangle2D.Double(117, 35, 10, 57);//two tree//right
		wallBox14 = new Rectangle2D.Double(135, 35, 10, 57);//two tree//left
		wallBox15 = new Rectangle2D.Double(117, 85, 27, 10);//two tree//up
		wallBox16 = new Rectangle2D.Double(190, 330, 10, 30);//long line tree//right
		wallBox17 = new Rectangle2D.Double(200, 330, 142, 10);//long line tree//down
		wallBox18 = new Rectangle2D.Double(197, 350, 142, 10);//long line tree//up
		wallBox19 = new Rectangle2D.Double(333, 332, 10, 27);//long line tree//left
		wallBox20 = new Rectangle2D.Double(365, 148, 10, 115);//right
		wallBox21 = new Rectangle2D.Double(365, 148, 60, 10);//down
		wallBox22 = new Rectangle2D.Double(365, 263, 60, 10);//up
		//Trainers
		wallBox23 = new Rectangle2D.Double(30, 150, 90, 10);
		wallBox24 = new Rectangle2D.Double(30, 240, 90, 10);
		wallBox25 = new Rectangle2D.Double(30, 330, 90, 10);
		wallBox26 = new Rectangle2D.Double(220, 370, 10, 80);
		wallBox27 = new Rectangle2D.Double(290, 370, 10, 80);
		wallBox28 = new Rectangle2D.Double(310, 170, 60, 10);
		wallBox29 = new Rectangle2D.Double(180, 45, 10, 90);
	}

	public void paintLevel(Graphics2D comp2D, JPanel p) {
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_BINARY);
		//Graphics g = image.createGraphics();
		
		comp2D.drawImage(image, 0, 0, p);
		comp2D.drawImage(background, 0, 0,460,480, p);
		comp2D.drawImage(Sprite, xCoordinate, yCoordinate,25,25, p);
		
		comp2D.drawImage(op2, 95, 135,30,30, p);
		comp2D.drawImage(op2, 95, 225,30,30, p);
		comp2D.drawImage(op2, 95, 315,30,30, p);
		comp2D.drawImage(op3, 210, 370,30,30, p);
		comp2D.drawImage(op3, 280, 370,30,30, p);
		comp2D.drawImage(op4, 310, 155,30,30, p);
		comp2D.drawImage(op3, 170, 45,30,30, p);
		
		redbox.setFrame(xCoordinate+5, yCoordinate+3, 15, 20);
		comp2D.setPaint(Color.BLACK);
		if (redbox.intersects(wallBox1)||redbox.intersects(wallBox2)||
				redbox.intersects(wallBox3)||redbox.intersects(wallBox4)||redbox.intersects(wallBox5)||
				redbox.intersects(wallBox6)||redbox.intersects(wallBox7)||redbox.intersects(wallBox8)||
				redbox.intersects(wallBox9)||redbox.intersects(wallBox10)||redbox.intersects(wallBox11)||
				redbox.intersects(wallBox12)||redbox.intersects(wallBox13)||redbox.intersects(wallBox14)||
				redbox.intersects(wallBox15)||redbox.intersects(wallBox16)||redbox.intersects(wallBox17)||
				redbox.intersects(wallBox18)||redbox.intersects(wallBox19)||redbox.intersects(wallBox20)||
				redbox.intersects(wallBox21)||redbox.intersects(wallBox22)) {
			xCoordinate = oldx;
			yCoordinate = oldy;
			redbox.setFrame(xCoordinate+5, yCoordinate+3, 15, 20);
		}
		if(redbox.intersects(wallBox23)&& touched1==false){
			BattleScreen one = new BattleScreen(nm);
			touched1=true;
		}
		if(redbox.intersects(wallBox24)&& touched2==false){
			BattleScreen two = new BattleScreen(nm);
			touched2=true;
		}
		if(redbox.intersects(wallBox25)&& touched3==false){
			BattleScreen three = new BattleScreen(nm);
			touched3=true;
		}
		if(redbox.intersects(wallBox26)&& touched4==false){
			BattleScreen four = new BattleScreen(nm);
			touched4=true;
		}
		if(redbox.intersects(wallBox27)&& touched5==false){
			BattleScreen five = new BattleScreen(nm);
			touched5=true;
		}
		if(redbox.intersects(wallBox28)&& touched6==false){
			BattleScreen six = new BattleScreen(nm);
			touched6=true;
		}
		if(redbox.intersects(wallBox29)&& touched7==false){
			BattleScreen seven = new BattleScreen(nm);
			touched7=true;
		}
		
		/*comp2D.fill(redbox);
		comp2D.fill(wallBox1);
		comp2D.fill(wallBox2);
		comp2D.fill(wallBox3);
		comp2D.fill(wallBox4);
		comp2D.fill(wallBox5);
		comp2D.fill(wallBox6);
		comp2D.fill(wallBox7);
		comp2D.fill(wallBox8);
		comp2D.fill(wallBox9);
		comp2D.fill(wallBox10);
		comp2D.fill(wallBox11);
		comp2D.fill(wallBox12);
		comp2D.fill(wallBox13);
		comp2D.fill(wallBox14);
		comp2D.fill(wallBox15);
		comp2D.fill(wallBox16);
		comp2D.fill(wallBox17);
		comp2D.fill(wallBox18);
		comp2D.fill(wallBox19);
		comp2D.fill(wallBox20);
		comp2D.fill(wallBox21);
		comp2D.fill(wallBox22);
		comp2D.fill(wallBox23);
		comp2D.fill(wallBox24);
		comp2D.fill(wallBox25);
		comp2D.fill(wallBox26);
		comp2D.fill(wallBox27);
		comp2D.fill(wallBox28);
		comp2D.fill(wallBox29);*/
	}

	public void keyReleased(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
			oldx=xCoordinate;
			oldy=yCoordinate;
			xCoordinate = xCoordinate + 15;
			Sprite = redright;
		
		} else if (event.getKeyCode() == KeyEvent.VK_LEFT) {
			oldx=xCoordinate;
			oldy=yCoordinate;
			xCoordinate = xCoordinate - 15;
			Sprite = redleft;
			
		} else if (event.getKeyCode() == KeyEvent.VK_UP) {
			oldx=xCoordinate;
			oldy=yCoordinate;
			yCoordinate = yCoordinate - 15;
			Sprite = redup;
			
		} else if (event.getKeyCode() == KeyEvent.VK_DOWN) {
			oldx=xCoordinate;
			oldy=yCoordinate;
			yCoordinate = yCoordinate + 15;
			Sprite = reddown;
			
		}
	}
}


