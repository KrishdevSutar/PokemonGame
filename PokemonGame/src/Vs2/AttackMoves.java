package Vs2;
/* Krishdev Sutar
 * To create class that stores the values given as attack's parameters
 * June 14, 2018
 */
public class AttackMoves extends Moves {
	/**
	 * constructor
	 * pre: Two String variables and an integer variable 
	 * post: Initializes the variables
	 */
	public AttackMoves(String name, String type, int basePower) {
		this.name = name;//Name of Attack
		this.typ = type;//Attack Type
		this.basePower = basePower;//Attack Power
	}

}
