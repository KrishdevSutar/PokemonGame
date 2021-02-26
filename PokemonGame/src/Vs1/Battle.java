package Vs1;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;
import java.util.Scanner;

import javax.swing.*;

public class Battle {
	Pokemon play;
	OpponentPokemon opp;
	double damage = 0;
	String name, nm;
	Image charizard, blastoise, venasaur, charizard1, blastoise1, venasaur1,
			background;
	static double[][] pokeTypeChart = new double[17][17];
	TypeChart t = new TypeChart();

	public Battle(Pokemon p, OpponentPokemon c) {
		this.play = p;
		this.opp = c;
		Toolkit kit = Toolkit.getDefaultToolkit();
		charizard = kit.getImage("charizard3.png");
		blastoise = kit.getImage("blastoise1.png");
		venasaur = kit.getImage("vensaur1.png");
		charizard1 = kit.getImage("charizard2.png");
		blastoise1 = kit.getImage("blastoise2.png");
		venasaur1 = kit.getImage("vensaur2.png");
		background = kit.getImage("background5.png").getScaledInstance(1000, 600, java.awt.Image.SCALE_SMOOTH);
		pokeTypeChart = t.populate();
	}

	

	public void paintLevel(Graphics2D comp2D, JPanel p) {
		BufferedImage image = new BufferedImage(1000, 600,
				BufferedImage.TYPE_BYTE_BINARY);
		// Graphics g = image.createGraphics();
		comp2D.drawImage(image, 0, 0, p);
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
		comp2D.fillRect(50, 45, opp.curhealth, 30);
		comp2D.fillRect(700, 365, play.curhealth, 30);
	}

	public void damageCalculator(int move) {
		double typeMod = 20;
		double stab = 1;
		if (move == 1) {
			if ((play.type1.equalsIgnoreCase(play.moves[0].typ))) {
				stab = 1.5;
			}
			typeMod = advant(1);
			damage = (((((((((2 * 50 / 5 + 2) * play.attack * play.moves[0].basePower) / opp.defense) / 50) + 2) * stab)* typeMod) * 236) / 255);
			opp.curhealth = (int) (opp.curhealth - damage);
		}
		if (move == 2) {
			if ((play.type1.equalsIgnoreCase(play.moves[1].typ))) {
				stab = 1.5;
			}
			typeMod = advant(2);
			damage = (((((((((2 * 50 / 5 + 2) * play.attack * play.moves[0].basePower) / opp.defense) / 50) + 2) * stab)* typeMod) * 236) / 255);
			opp.curhealth = (int) (opp.curhealth - damage);
		}
		if (move == 3) {
			if ((play.type1.equalsIgnoreCase(play.moves[2].typ))) {
				stab = 1.5;
			}
			typeMod = advant(3);
			damage = (((((((((2 * 50 / 5 + 2) * play.attack * play.moves[0].basePower) / opp.defense) / 50) + 2) * stab)* typeMod) * 236) / 255);
			opp.curhealth = (int) (opp.curhealth - damage);
		}
		if (move == 4) {
			play.curhealth = (int) (play.curhealth + (play.tothealth * 0.5));
		}
		
	}

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
		//System.out.println(pokeTypeChart[attacker][defender]);
		return pokeTypeChart[attacker][defender];
	}
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
