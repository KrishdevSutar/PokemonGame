package Vs2;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.util.Scanner;

import javax.swing.*;
/* Krishdev Sutar
 * To handle the battle mechanics of the game
 * June 14, 2018
 */
public class Battle{
	Pokemon play;//Object of player's pokemon
	String name, nm;//Nmaes of player and opponent pokemon
	BattleThread gam;//Object of Thread used for battle screen
	double damage = 0;//Amount of Damage produced
	OpponentPokemon opp;//Object of oppponent's pokemon
	OpponentAttack fight;//Object of opponent's battle pattern
	boolean start = false;//Determines which health bar decreases first
	TypeChart t = new TypeChart();//Object of 2D array with type modifier values
	int health1 = 200, health2 = 200;//Amount of health left in health bar
	int buffer1 = 200, buffer2 = 200;//Variable to help transition between the before and after taking damage
	static double[][] pokeTypeChart = new double[17][17];//2D array for all possible outcomes
	Image charizard, blastoise, venasaur, charizard1, blastoise1, venasaur1,background;//Stores the images corresponding to its name
	
	/** constructor
	  * pre: A Pokemon object, Opponent Pokemon object, and BattleThread object
	  * post: initializes variables, imports all images, and calls opponent attacking class
	  */
	public Battle(Pokemon p, OpponentPokemon c, BattleThread ga) {
		this.play = p;
		this.opp = c;
		this.gam = (BattleThread)ga;
		Toolkit kit = Toolkit.getDefaultToolkit();
		charizard = kit.getImage("charizard3.png");
		blastoise = kit.getImage("blastoise1.png");
		venasaur = kit.getImage("vensaur1.png");
		charizard1 = kit.getImage("charizard2.png");
		blastoise1 = kit.getImage("blastoise2.png");
		venasaur1 = kit.getImage("vensaur2.png");
		background = kit.getImage("background5.png").getScaledInstance(1000, 600, java.awt.Image.SCALE_SMOOTH);
		pokeTypeChart = t.populate();
		fight = new OpponentAttack(play,opp);
	}
	/* To draw the images, and draw health bar corresponding to amount of health left
	 * pre: Graphics2D component and a JPanel
	 * post: none
	 */
	public void paintLevel(Graphics2D comp2D, JPanel p) {
		BufferedImage image = new BufferedImage(1000, 600,
				BufferedImage.TYPE_BYTE_BINARY);
		Graphics g = image.getGraphics();
		
		g.drawImage(image, 0, 0, p);
		comp2D.drawImage(background, 0, 0, 1000, 600, p);
		if (play.name.equalsIgnoreCase("Charizard")) {
			comp2D.drawImage(charizard, 50, 150, 450, 450, p);
		} else if (play.name.equalsIgnoreCase("Blastoise")) {
			comp2D.drawImage(blastoise, 0, 0, 700, 700, p);
		} else if (play.name.equalsIgnoreCase("Venasaur")) {
			comp2D.drawImage(venasaur, 50, 150, 500, 500, p);
		}
		if (opp.name.equalsIgnoreCase("Charizard")) {
			comp2D.drawImage(charizard1, 600, 15, 275, 275, p);
		} else if (opp.name.equalsIgnoreCase("Blastoise")) {
			comp2D.drawImage(blastoise1, 600, 25, 300, 300, p);
		} else if (opp.name.equalsIgnoreCase("Venasaur")) {
			comp2D.drawImage(venasaur1, 600, 15, 325, 325, p);
		}
		comp2D.setPaint(Color.GREEN);
		if(start == false){
			if(buffer1>health1){
				comp2D.fillRect(50, 45, buffer1, 30);
				buffer1--;
			}else{
				start = true;
			}
		}
		
		if(start == true){
			if(buffer2>health2){
				comp2D.fillRect(700, 365, buffer2, 30);
				buffer2--;
			}else{
				start = false;
			}
		}
		comp2D.fillRect(50, 45, buffer1, 30);//opponent
		comp2D.fillRect(700, 365, buffer2, 30);//player
		if((buffer1==0)||(buffer2==0)){
			gam.win();
		}
	}
	/* To calculate amount of damage dealt and lost
	 * pre: Integer variable
	 * post: none
	 */
	public void damageCalculator(int move) {
		int random = 0;
		double typeMod = 1.0;
		double stab = 1;
		double temp = 0;
		if (move == 1) {
			start = false;
			//Variable in calculating damage based on whether attack used and pokemon type are the same or not
			if ((play.type1.equalsIgnoreCase(play.moves[0].typ))) {
				stab = 1.5;
			}
			typeMod = advant(1);//Calls method to determine value of variable for damage calculation based on type advantage/disadvantage
			damage = (((((((((2 * 50 / 5 + 2) * play.attack * play.moves[0].basePower) / opp.defense) / 50) + 2) * stab)* typeMod) * 236) / 255);
			opp.curhealth = (int) (opp.curhealth - damage);
			//Converts health into a more appropriate size for the health bar drawn
			temp = (double) opp.curhealth/opp.tothealth;
			temp = temp*200;
			health1 = (int) temp;
			//Calls opponent attack class to determine damage taken by opponent
			random = (int)(Math.random()*(3-1+1))+1;
			fight.damageCalculator(random);
			health2 = fight.playerHealth();
		}
		if (move == 2) {
			start = false;
			if ((play.type1.equalsIgnoreCase(play.moves[1].typ))) {
				stab = 1.5;
			}
			typeMod = advant(2);
			damage = (((((((((2 * 50 / 5 + 2) * play.attack * play.moves[1].basePower) / opp.defense) / 50) + 2) * stab)* typeMod) * 236) / 255);
			opp.curhealth = (int) (opp.curhealth - damage);
			temp = (double) opp.curhealth/opp.tothealth;
			temp = temp*200;
			health1 = (int) temp;
			random = (int)(Math.random()*(3-1+1))+1;
			fight.damageCalculator(random);
			health2 = fight.playerHealth();
		}
		if (move == 3) {
			start = false;
			if ((play.type1.equalsIgnoreCase(play.moves[2].typ))) {
				stab = 1.5;
			}
			typeMod = advant(3);
			damage = (((((((((2 * 50 / 5 + 2) * play.attack * play.moves[2].basePower) / opp.defense) / 50) + 2) * stab)* typeMod) * 236) / 255);
			opp.curhealth = (int) (opp.curhealth - damage);
			temp = (double) opp.curhealth/opp.tothealth;
			temp = temp*200;
			health1 = (int) temp;
			random = (int)(Math.random()*(3-1+1))+1;
			fight.damageCalculator(random);
			health2 = fight.playerHealth();
		}
		if (move == 4) {
			start = false;
			if ((play.type1.equalsIgnoreCase(play.moves[3].typ))) {
				stab = 1.5;
			}
			typeMod = advant(4);
			damage = (((((((((2 * 50 / 5 + 2) * play.attack * play.moves[3].basePower) / opp.defense) / 50) + 2) * stab)* typeMod) * 236) / 255);
			opp.curhealth = (int) (opp.curhealth - damage);
			temp = (double) opp.curhealth/opp.tothealth;
			temp = temp*200;
			health1 = (int) temp;
			random = (int)(Math.random()*(3-1+1))+1;
			fight.damageCalculator(random);
			health2 = fight.playerHealth();
		}
		
	}
	/* To determine the type modifier value
	 * pre: Integer variable
	 * post: Returns a double value
	 */
	public double advant(int move) {
		int attacker=0,defender=0;
		if (move == 1) {
			attacker = atk(0);
			defender = def();
		}
		if (move == 2) {
			attacker = atk(1);
			defender = def();
		}
		if (move == 3) {
			attacker = atk(2);
			defender = def();
		}
		return pokeTypeChart[attacker][defender];
	}
	/* To determine attacker move type
	 * pre: An integer variable
	 * post: Returns an integer value
	 */
	public int atk(int move){
		int a = 0;
		if (play.moves[move].typ.equalsIgnoreCase("Normal")) {
			a = 0;
		}else if (play.moves[move].typ.equalsIgnoreCase("Fire")) {
			a = 1;
		}else if(play.moves[move].typ.equalsIgnoreCase("Water")){
			a = 2;
		}else if(play.moves[move].typ.equalsIgnoreCase("Grass")){
			a = 3;
		}else if(play.moves[move].typ.equalsIgnoreCase("Electric")){
			a = 4;
		}else if(play.moves[move].typ.equalsIgnoreCase("Ice")){
			a = 5;
		}else if(play.moves[move].typ.equalsIgnoreCase("Fighting")){
			a = 6;
		}else if(play.moves[move].typ.equalsIgnoreCase("Poison")){
			a = 7;
		}else if(play.moves[move].typ.equalsIgnoreCase("Ground")){
			a = 8;
		}else if(play.moves[move].typ.equalsIgnoreCase("Flying")){
			a = 9;
		}else if(play.moves[move].typ.equalsIgnoreCase("Psychic")){
			a = 10;
		}else if(play.moves[move].typ.equalsIgnoreCase("Bug")){
			a = 11;
		}else if(play.moves[move].typ.equalsIgnoreCase("Rock")){
			a = 12;
		}else if(play.moves[move].typ.equalsIgnoreCase("Ghost")){
			a = 13;
		}else if(play.moves[move].typ.equalsIgnoreCase("Dragon")){
			a = 14;
		}else if(play.moves[move].typ.equalsIgnoreCase("Dark")){
			a = 15;
		} else if(play.moves[move].typ.equalsIgnoreCase("Steel")){
			a = 16;
		}
		return a;
	}
	/* To determine defender type
	 * pre: An integer variable
	 * post: Returns an integer value
	 */
	public int def(){
		int d = 0;
		if (opp.type1.equalsIgnoreCase("Normal")) {
			d = 0;
		}else if (opp.type1.equalsIgnoreCase("Fire")) {
			d = 1;
		}else if(opp.type1.equalsIgnoreCase("Water")){
			d = 2;
		}else if(opp.type1.equalsIgnoreCase("Grass")){
			d = 3;
		}else if(opp.type1.equalsIgnoreCase("Electric")){
			d = 4;
		}else if(opp.type1.equalsIgnoreCase("Ice")){
			d = 5;
		}else if(opp.type1.equalsIgnoreCase("Fighting")){
			d = 6;
		}else if(opp.type1.equalsIgnoreCase("Poison")){
			d = 7;
		}else if(opp.type1.equalsIgnoreCase("Ground")){
			d = 8;
		}else if(opp.type1.equalsIgnoreCase("Flying")){
			d = 9;
		}else if(opp.type1.equalsIgnoreCase("Psychic")){
			d = 10;
		}else if(opp.type1.equalsIgnoreCase("Bug")){
			d = 11;
		}else if(opp.type1.equalsIgnoreCase("Rock")){
			d = 12;
		}else if(opp.type1.equalsIgnoreCase("Ghost")){
			d = 13;
		}else if(opp.type1.equalsIgnoreCase("Dragon")){
			d = 14;
		}else if(opp.type1.equalsIgnoreCase("Dark")){
			d = 15;
		} else if(opp.type1.equalsIgnoreCase("Steel")){
			d = 16;
		}
		return d;
	}
	
	
	
	
	
}
