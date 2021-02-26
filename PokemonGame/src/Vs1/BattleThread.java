package Vs1;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

//This whole class is a runnable object
public class BattleThread extends JPanel implements Runnable, ActionListener {
	Thread runner;
	int speed = 20;
	Battle L;
	Pokemon plyer;
	OpponentPokemon op;
	OpponentAttack fight;
	boolean running = true;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JLabel opName;
	JLabel plyName;
	JFrame frame;

	public BattleThread(Pokemon p, OpponentPokemon c, JFrame f) {
		super();
		this.frame = f;
		this.plyer = p;
		this.op = c;
		L = new Battle(p, c);
		runner = new Thread(this);
		runner.start();
		
		fight = new OpponentAttack(plyer,op);
		
		btn1 = new JButton(plyer.moves[0].name);
		btn2 = new JButton(plyer.moves[1].name);
		btn3 = new JButton(plyer.moves[2].name);
		btn4 = new JButton(plyer.moves[3].name);
		
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		opName = new JLabel(c.name);
		plyName = new JLabel(p.name);
		Font font = new Font("Segoe Script", Font.BOLD, 25);
		opName.setFont(font);
		opName.setForeground(Color.WHITE);
		opName.setBounds(50, -25, 190, 100);
		
		plyName.setFont(font);
		plyName.setForeground(Color.WHITE);
		plyName.setBounds(700, 300, 190, 100);
		
		btn1.setBounds(700, 400, 100, 50);
		btn2.setBounds(700, 470, 100, 50);
		btn3.setBounds(805, 400, 100, 50);
		btn4.setBounds(805, 470, 100, 50);
		add(opName);
		add(plyName);
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
	}

	public void paintComponent(Graphics comp) {
		L.paintLevel((Graphics2D) comp, this);
	}

	public void run() {
		Thread thisThread = Thread.currentThread();
		while (runner == thisThread) {
			while (running) {
				repaint();
			}
			requestFocus();
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		int random;
		if (event.getSource() == btn1) {
			L.damageCalculator(1);
			random = (int)(Math.random()*(3-1+1))+1;
			fight.damageCalculator(random);
			if (op.curhealth <= 0) {
				frame.dispose();
			}
			if (plyer.curhealth <= 0) {
				frame.dispose();
			}

		}
		if (event.getSource() == btn2) {
			L.damageCalculator(2);
			random = (int)(Math.random()*(3-1+1))+1;
			fight.damageCalculator(random);
			if (op.curhealth <= 0) {
				frame.dispose();
			}
			if (plyer.curhealth <= 0) {
				frame.dispose();
			}
		}
		if (event.getSource() == btn3) {
			L.damageCalculator(3);
			random = (int)(Math.random()*(3-1+1))+1;
			fight.damageCalculator(random);
			if (op.curhealth <= 0) {
				frame.dispose();
			}
			if (plyer.curhealth <= 0) {
				frame.dispose();
			}
		}
		if (event.getSource() == btn4) {
			L.damageCalculator(4);
			random = (int)(Math.random()*(3-1+1))+1;
			fight.damageCalculator(random);
			if (op.curhealth <= 0) {
				frame.dispose();
			}
			if (plyer.curhealth <= 0) {
				frame.dispose();
			}
		}

	}
}
