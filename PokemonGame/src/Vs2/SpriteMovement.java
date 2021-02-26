package Vs2;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
/* Krishdev Sutar
 * To handle main functions such as sprite movement, collision detection, and starting battle based on conditions
 * June 14, 2018
 */
public class SpriteMovement {
	Image background, redright, redleft, redup, reddown, Sprite, opup, opleft, opdown, opright;//Stores the images corresponding to its name
	int xCoordinate=90, yCoordinate=90, oldx,oldy;//x and y coordinates of the player
	int width = 460;//Width of screen
	int height = 480;//height of screen
	String nm;//Name of Player's Pokemon
	long startTime, endTime;// start and end time to determine a spawn rate
	public static boolean temp1 = false, temp2 = false, temp3 = false,//Stops code from creating multiple battle screen
			temp4 = false, temp5 = false, temp6 = false, temp7 = false;
	boolean touched1 = false, touched2 = false, touched3 = false, //Stops code from creating multiple battle screen
			touched4 = false, touched5 = false, touched6 = false,
			touched7 = false;
	//Rectangles used for collision detection
	private Rectangle2D.Double redbox,wallBox1,wallBox2,wallBox3,wallBox4,wallBox5,wallBox6,
	wallBox7,wallBox8,wallBox9,wallBox10,wallBox11,wallBox12,wallBox13,wallBox14,wallBox15,
	wallBox16,wallBox17,wallBox18,wallBox19,wallBox20,wallBox21,wallBox22,wallBox23,wallBox24,
	wallBox25,wallBox26,wallBox27,wallBox28,wallBox29,wallBox30,wallBox31,wallBox32,wallBox33,
	wallBox34,wallBox35,wallBox36,wallBox37,wallBox38,wallBox39,wallBox40,wallBox41,wallBox42,
	wallBox43,wallBox44;
	/** constructor
	  * pre: A String variable
	  * post: Intializes the variables, imports images, and creates rectangle
	  */
	public SpriteMovement(String n){
		this.nm = n;
		startTime = System.currentTimeMillis();
		Toolkit kit = Toolkit.getDefaultToolkit();
		redup = kit.getImage("redup.png");
		redleft = kit.getImage("redleft.png");
		reddown = kit.getImage("reddown.png");
		redright = kit.getImage("redright.png");
		background = kit.getImage("background3.png").getScaledInstance(460, 480, java.awt.Image.SCALE_SMOOTH);
		Sprite = reddown;
		
		opup = kit.getImage("opup.png");
		opleft = kit.getImage("opleft.png");
		opdown = kit.getImage("opdown.png");
		opright = kit.getImage("opright.png");;
		
		redbox = new Rectangle2D.Double(xCoordinate+5, yCoordinate+13, 15, 10);//Player hit box
		//Trees
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
		wallBox20 = new Rectangle2D.Double(365, 148, 10, 115);//middle side tree//right
		wallBox21 = new Rectangle2D.Double(365, 148, 60, 10);//middle side tree//down
		wallBox22 = new Rectangle2D.Double(365, 263, 60, 10);//middle side tree//up
		wallBox37 = new Rectangle2D.Double(117, 92, 27, 57);//Space Blocker
		//Trainers Sight Range
		wallBox23 = new Rectangle2D.Double(30, 150, 90, 10);
		wallBox24 = new Rectangle2D.Double(30, 230, 90, 10);
		wallBox25 = new Rectangle2D.Double(30, 330, 90, 10);
		wallBox26 = new Rectangle2D.Double(220, 370, 10, 80);
		wallBox27 = new Rectangle2D.Double(290, 370, 10, 80);
		wallBox28 = new Rectangle2D.Double(310, 170, 60, 10);
		wallBox29 = new Rectangle2D.Double(180, 45, 10, 90);
		//Trainers
		wallBox38 = new Rectangle2D.Double(100, 140, 20, 30);
		wallBox39 = new Rectangle2D.Double(100, 210, 20, 30);
		wallBox40 = new Rectangle2D.Double(100, 320, 20, 30);
		wallBox41 = new Rectangle2D.Double(215, 370, 20, 30);
		wallBox42 = new Rectangle2D.Double(285, 370, 20, 30);
		wallBox43 = new Rectangle2D.Double(315, 160, 20, 30);
		wallBox44 = new Rectangle2D.Double(175, 45, 20, 30);
		//Grass
		wallBox30 = new Rectangle2D.Double(30, 40, 50, 170);
		wallBox31 = new Rectangle2D.Double(65, 240, 50, 90);
		wallBox32 = new Rectangle2D.Double(365, 285, 65, 75);
		wallBox33 = new Rectangle2D.Double(248, 260, 100, 50);
		wallBox34 = new Rectangle2D.Double(313, 120, 50, 119);
		wallBox35 = new Rectangle2D.Double(210, 80, 220, 40);
		wallBox36 = new Rectangle2D.Double(150, 50, 65, 55);
	}
	/* To draw the images, perform collision detection with trees, and call trainer/wild battle checker method 
	 * pre: Graphics2D component and a JPanel
	 * post: none
	 */
	public void paintLevel(Graphics2D comp2D, JPanel p) {
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_BYTE_BINARY);
		Graphics g = image.getGraphics();
		
		g.drawImage(image, 0, 0, p);
		comp2D.drawImage(background, 0, 0,460,480, p);//Background
		comp2D.drawImage(Sprite, xCoordinate, yCoordinate,25,25, p);//Player image
		//Trainer Images
		comp2D.drawImage(opleft, 95, 135,30,30, p);
		comp2D.drawImage(opleft, 95, 210,30,30, p);
		comp2D.drawImage(opleft, 95, 315,30,30, p);
		comp2D.drawImage(reddown, 210, 370,30,30, p);
		comp2D.drawImage(reddown, 280, 370,30,30, p);
		comp2D.drawImage(opright, 310, 155,30,30, p);
		comp2D.drawImage(reddown, 170, 45,30,30, p);
		
		redbox.setFrame(xCoordinate+5, yCoordinate+13, 15, 10);
		//Collision detection with border and trees
		if (redbox.intersects(wallBox1)||redbox.intersects(wallBox2)||
				redbox.intersects(wallBox3)||redbox.intersects(wallBox4)||redbox.intersects(wallBox5)||
				redbox.intersects(wallBox6)||redbox.intersects(wallBox7)||redbox.intersects(wallBox8)||
				redbox.intersects(wallBox9)||redbox.intersects(wallBox10)||redbox.intersects(wallBox11)||
				redbox.intersects(wallBox12)||redbox.intersects(wallBox13)||redbox.intersects(wallBox14)||
				redbox.intersects(wallBox15)||redbox.intersects(wallBox16)||redbox.intersects(wallBox17)||
				redbox.intersects(wallBox18)||redbox.intersects(wallBox19)||redbox.intersects(wallBox20)||
				redbox.intersects(wallBox21)||redbox.intersects(wallBox22)||redbox.intersects(wallBox37)||
				redbox.intersects(wallBox38)||redbox.intersects(wallBox39)||redbox.intersects(wallBox40)||
				redbox.intersects(wallBox41)||redbox.intersects(wallBox42)||redbox.intersects(wallBox43)||
				redbox.intersects(wallBox44)) {
			xCoordinate = oldx;
			yCoordinate = oldy;
			redbox.setFrame(xCoordinate+5, yCoordinate+13, 15, 10);
		}
		trainerBattle();
		wildBattle();
	}
	/* To move the sprite and change the direction the sprite looks based off which key released
	 * pre: KeyEvent event
	 * post: none
	 */
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
	/* To initiate a wild Pokemon battle based on a timer and whether the player is inside the grass or not
	 * pre: none
	 * post: none
	 */
	public void wildBattle(){
		if(redbox.intersects(wallBox30)){//Grass spot #1
			endTime = System.currentTimeMillis();
			if((endTime-startTime)%250==0){
				if(temp1==false){
					BattleScreen wild2 = new BattleScreen(nm,0);
					temp1=true;
				}
			}
		}
		if(redbox.intersects(wallBox31)){//Grass spot #2
			endTime = System.currentTimeMillis();
			if((endTime-startTime)%250==0){
				if(temp2==false){
					BattleScreen wild2 = new BattleScreen(nm,0);
					temp2=true;
				}
			}
		}
		if(redbox.intersects(wallBox32)){//Grass spot #3
			endTime = System.currentTimeMillis();
			if((endTime-startTime)%250==0){
				if(temp3==false){
					BattleScreen wild3 = new BattleScreen(nm,0);
					temp3=true;
				}
			}
		}
		if(redbox.intersects(wallBox33)){//Grass spot #4
			endTime = System.currentTimeMillis();
			if((endTime-startTime)%250==0){
				if(temp4==false){
					BattleScreen wild4 = new BattleScreen(nm,0);
					temp4=true;
				}
			}
		}
		if(redbox.intersects(wallBox34)){//Grass spot #5
			endTime = System.currentTimeMillis();
			if((endTime-startTime)%250==0){
				if(temp5==false){
					BattleScreen wild5 = new BattleScreen(nm,0);
					temp5=true;
					temp6=true;
					temp7=true;
				}
			}
		}
		if(redbox.intersects(wallBox35)){//Grass spot #6
			endTime = System.currentTimeMillis();
			if((endTime-startTime)%250==0){
				if(temp6==false){
					BattleScreen wild6 = new BattleScreen(nm,0);
					temp5=true;
					temp6=true;
					temp7=true;
				}
			}
		}
		if(redbox.intersects(wallBox36)){//Grass spot #7
			endTime = System.currentTimeMillis();
			if((endTime-startTime)%250==0){
				if(temp7==false){
					BattleScreen wild7 = new BattleScreen(nm,0);
					temp5=true;
					temp6=true;
					temp7=true;
				}
			}
		}
	}
	/* To initiate a Trainer battle based on whether the Player is within the trainer's sight range 
	 * pre: none
	 * post: none
	 */
	public void trainerBattle(){
		if(redbox.intersects(wallBox23)&& touched1==false){//Trainer #1
			BattleScreen one = new BattleScreen(nm,1);
			touched1=true;
			temp1=true;
		}
		if(redbox.intersects(wallBox24)&& touched2==false){//Trainer #2
			BattleScreen two = new BattleScreen(nm,1);
			touched2=true;
			temp2=true;
		}
		if(redbox.intersects(wallBox25)&& touched3==false){//Trainer #3
			BattleScreen three = new BattleScreen(nm,1);
			touched3=true;
			temp2=true;
		}
		if(redbox.intersects(wallBox26)&& touched4==false){//Trainer #4
			BattleScreen four = new BattleScreen(nm,1);
			touched4=true;
		}
		if(redbox.intersects(wallBox27)&& touched5==false){//Trainer #5
			BattleScreen five = new BattleScreen(nm,1);
			touched5=true;
		}
		if(redbox.intersects(wallBox28)&& touched6==false){//Trainer #6
			BattleScreen six = new BattleScreen(nm,1);
			touched6=true;
			temp5=true;
		}
		if(redbox.intersects(wallBox29)&& touched7==false){//Trainer #7
			BattleScreen seven = new BattleScreen(nm,1);
			touched7=true;
			temp7=true;
		}
	}
}


