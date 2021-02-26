package Vs1;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

import javax.swing.*;

public class BattleScreen extends JFrame {

	private BattleThread gui;

	public BattleScreen(String n) {
		setSize(1000, 600);// 476, 519);
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
		//System.out.println(opname);
		Pokemon player = new Pokemon(n);
		OpponentPokemon cpu = new OpponentPokemon(opname);//"Blastoise");
		
		gui = new BattleThread(player,cpu,this);
		gui.setFocusable(true);
		gui.setLayout(null);
		gui.setBounds(0, 0, 1000, 600);

		add(gui);
		setVisible(true);
		//setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//		addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				// Ask for confirmation before terminating the program.
//				int option = JOptionPane.showConfirmDialog(null,"Are you sure you want to run?");
//
//				if (option == JOptionPane.YES_OPTION) {
//					dispose();
//				}
//			}
//		});
	}
	public static void main(String[] arguments) {
		BattleScreen frame = new BattleScreen("Charizard");
	}
}


