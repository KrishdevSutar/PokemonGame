package Vs1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class OpponentPokemon {
	int tothealth;
	int curhealth;
	int attack;
	int defense;
	int speed;
	String name;
	String type1, type2;
	Moves[] moveList1 = { new AttackMoves("Thunder Fang", "Electric", 65),
			new AttackMoves("Flamethrower", "Fire", 90),
			new AttackMoves("Wing Attack", "Flying", 60),
			new HeallingMoves("Recover", 20) };
	Moves[] moveList2 = { new AttackMoves("Dark Pulse", "Dark", 80),
			new AttackMoves("Hydro Pump", "Water",100),
			new AttackMoves("Ice Beam", "Ice", 90),
			new HeallingMoves("Recover", 20) };
	Moves[] moveList3 = { new AttackMoves("Petal Blizzard", "Grass", 90),
			new AttackMoves("Sludge Bomb", "Poison", 90),
			new AttackMoves("Bulldoze", "Ground", 60),
			new HeallingMoves("Recover", 20) };
	Moves[] moves = new Moves[4];
	public OpponentPokemon(String name) {
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
