package Vs2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
/* Krishdev Sutar
 * To create the battle screen
 * June 14, 2018
 */
public class BattleScreen extends JFrame {

	private BattleThread gui;//Object of thread used for battle screen
	/** constructor
	  * pre: String variable and integer variable
	  * post: Creates battle screen and creates Pokemon and Opponent Pokemon objects
	  */
	public BattleScreen(String n, int p) {
		setSize(1000, 600);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String opname = null;
		int random = (int)(Math.random()*(3-1+1))+1;
		if(random == 1){
			opname = "Charizard";
		}else if(random == 2){
			opname = "Blastoise";
		}else if(random == 3){
			opname = "Venasaur";
		}
		Pokemon player = new Pokemon(n);
		OpponentPokemon cpu = new OpponentPokemon(opname);
		
		gui = new BattleThread(player,cpu,p,this);
		gui.setFocusable(true);
		gui.setLayout(null);
		gui.setBounds(0, 0, 1000, 600);

		add(gui);
		setVisible(true);
	}
}


