package Vs2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
/* Krishdev Sutar
 * To create player's pokemon
 * June 14, 2018
 */
public class Pokemon {
	int tothealth;//Total health
	int curhealth;//Current health
	int attack;//Pokemon Attack stat
	int defense;//Pokemon Defense stat
	int speed;//Pokemon Speed stat
	String name;//Pokemon name
	String type1, type2;//Pokemon Types
	Moves[] moveList1 = { new AttackMoves("Thunder Fang", "Electric", 65),//Moveset #1
			new AttackMoves("Flamethrower", "Fire", 90),
			new AttackMoves("Wing Attack", "Flying", 60),
			new AttackMoves("Dragon Claw", "Dragon", 80) };
	Moves[] moveList2 = { new AttackMoves("Dark Pulse", "Dark", 80),//Moveset #2
			new AttackMoves("Hydro Pump", "Water",100),
			new AttackMoves("Ice Beam", "Ice", 90),
			new AttackMoves("Aura Sphere", "Fighting", 80)};
	Moves[] moveList3 = { new AttackMoves("Petal Blizzard", "Grass", 90),//Moveset #3
			new AttackMoves("Sludge Bomb", "Poison", 90),
			new AttackMoves("Bulldoze", "Ground", 60),
			new AttackMoves("Knock Off", "Dark", 65)};
	Moves[] moves = new Moves[4];//Placeholder for movesets
	/**
	 * constructor
	 * pre: String variable
	 * post: Initializes variable based on which Pokemon was choosen
	 */
	public Pokemon(String name) {
		if (name.equalsIgnoreCase("Charizard")) {
			this.name = name;
			this.type1 = "Fire";
			this.type1 = "Flying";
			this.tothealth = 140;
			this.curhealth = 140;
			this.attack = 140;
			this.defense = 100;
			this.speed = 115;
			this.moves = moveList1;
		} else if (name.equalsIgnoreCase("Blastoise")) {
			this.name = name;
			this.type1 = "Water";
			this.type2 = " ";
			this.tothealth = 164;
			this.curhealth = 164;
			this.attack = 129;
			this.defense = 125;
			this.speed = 120;
			this.moves = moveList2;
		} else if (name.equalsIgnoreCase("Venasaur")) {
			this.name = name;
			this.type1 = "Grass";
			this.type2 = "Poison";
			this.tothealth = 186;
			this.curhealth = 186;
			this.attack = 112;
			this.defense = 150;
			this.speed = 110;
			this.moves = moveList3;
		}
	}
}
