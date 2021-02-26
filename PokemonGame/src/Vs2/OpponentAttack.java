package Vs2;
/* Krishdev Sutar
 * To handle the opponent's attack pattern
 * June 14, 2018
 */
public class OpponentAttack {
	Pokemon player;//Object of Player pokemon name
	OpponentPokemon opponent;//Object of Opponent pokemon name
	double damage = 0;//Amount of damage produced
	double temp1 = 0;//Converts current to more appropiate value for health bar
	boolean starts = false;
	static double[][] tc = new double[17][17];//2D array for all possible outcomes
	TypeChart tip = new TypeChart();//Object of 2D array with type modifier values
	
	/** constructor
	  * pre: A Pokemon object, Opponent Pokemon object, and BattleThread object
	  * post: initializes variables, imports all images, and calls opponent attacking class
	  */
	public OpponentAttack(Pokemon p, OpponentPokemon c) {
		this.player = p;
		this.opponent = c;
		tc = tip.populate();
	}
	/* To calculate amount of damage dealt and lost
	 * pre: Integer variable
	 * post: none
	 */
	public void damageCalculator(int move) {
		double typeMod = 20;
		double stab = 1;
		if (move == 1) {
			starts = false;
			//Variable in calculating damage based on whether attack used and pokemon type are the same or not
			if ((opponent.type1.equalsIgnoreCase(opponent.moves[0].typ))) {
				stab = 1.5;
			}
			typeMod = advant(1);//Calls method to determine value of variable for damage calculation based on type advantage/disadvantage
			damage = (((((((((2 * 50 / 5 + 2) * opponent.attack * opponent.moves[0].basePower) / player.defense) / 50) + 2) * stab)* typeMod) * 236) / 255);
			player.curhealth = (int) (player.curhealth - damage);
			//Converts health into a more appropriate size for the health bar drawn
			temp1 = (double) player.curhealth/player.tothealth;
			temp1 = temp1*200;
		}
		if (move == 2) {
			starts = false;
			if ((opponent.type1.equalsIgnoreCase(opponent.moves[1].typ))) {
				stab = 1.5;
			}
			typeMod = advant(2);
			damage = (((((((((2 * 50 / 5 + 2) * opponent.attack * opponent.moves[1].basePower) / player.defense) / 50) + 2) * stab)* typeMod) * 236) / 255);
			player.curhealth = (int) (player.curhealth - damage);
			temp1 = (double) player.curhealth/player.tothealth;
			temp1 = temp1*200;
		}
		if (move == 3) {
			starts = false;
			if ((opponent.type1.equalsIgnoreCase(opponent.moves[2].typ))) {
				stab = 1.5;
			}
			typeMod = advant(3);
			damage = (((((((((2 * 50 / 5 + 2) * opponent.attack * opponent.moves[2].basePower) / player.defense) / 50) + 2) * stab)* typeMod) * 236) / 255);
			player.curhealth = (int) (player.curhealth - damage);
			temp1 = (double) player.curhealth/player.tothealth;
			temp1 = temp1*200;
		}
		if (move == 4) {
			starts = false;
			if ((opponent.type1.equalsIgnoreCase(opponent.moves[3].typ))) {
				stab = 1.5;
			}
			typeMod = advant(3);
			damage = (((((((((2 * 50 / 5 + 2) * opponent.attack * opponent.moves[3].basePower) / player.defense) / 50) + 2) * stab)* typeMod) * 236) / 255);
			player.curhealth = (int) (player.curhealth - damage);
			temp1 = (double) player.curhealth/player.tothealth;
			temp1 = temp1*200;
		}
	}
	/* To give opponent Pokemon's health value 
	 * pre: none
	 * post: Returns integer value
	 */
	public int playerHealth(){
		return (int) temp1;
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
		return tc[attacker][defender];
	}
	/* To determine attacker move type
	 * pre: An integer variable
	 * post: Returns an integer value
	 */
	public int atk(int move){
		int a = 0;
		if (player.moves[move].typ.equalsIgnoreCase("Normal")) {
			a = 0;
		}else if (player.moves[move].typ.equalsIgnoreCase("Fire")) {
			a = 1;
		}else if(player.moves[move].typ.equalsIgnoreCase("Water")){
			a = 2;
		}else if(player.moves[move].typ.equalsIgnoreCase("Grass")){
			a = 3;
		}else if(player.moves[move].typ.equalsIgnoreCase("Electric")){
			a = 4;
		}else if(player.moves[move].typ.equalsIgnoreCase("Ice")){
			a = 5;
		}else if(player.moves[move].typ.equalsIgnoreCase("Fighting")){
			a = 6;
		}else if(player.moves[move].typ.equalsIgnoreCase("Poison")){
			a = 7;
		}else if(player.moves[move].typ.equalsIgnoreCase("Ground")){
			a = 8;
		}else if(player.moves[move].typ.equalsIgnoreCase("Flying")){
			a = 9;
		}else if(player.moves[move].typ.equalsIgnoreCase("Psychic")){
			a = 10;
		}else if(player.moves[move].typ.equalsIgnoreCase("Bug")){
			a = 11;
		}else if(player.moves[move].typ.equalsIgnoreCase("Rock")){
			a = 12;
		}else if(player.moves[move].typ.equalsIgnoreCase("Ghost")){
			a = 13;
		}else if(player.moves[move].typ.equalsIgnoreCase("Dragon")){
			a = 14;
		}else if(player.moves[move].typ.equalsIgnoreCase("Dark")){
			a = 15;
		} else if(player.moves[move].typ.equalsIgnoreCase("Steel")){
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
		if (opponent.type1.equalsIgnoreCase("Normal")) {
			d = 0;
		}else if (opponent.type1.equalsIgnoreCase("Fire")) {
			d = 1;
		}else if(opponent.type1.equalsIgnoreCase("Water")){
			d = 2;
		}else if(opponent.type1.equalsIgnoreCase("Grass")){
			d = 3;
		}else if(opponent.type1.equalsIgnoreCase("Electric")){
			d = 4;
		}else if(opponent.type1.equalsIgnoreCase("Ice")){
			d = 5;
		}else if(opponent.type1.equalsIgnoreCase("Fighting")){
			d = 6;
		}else if(opponent.type1.equalsIgnoreCase("Poison")){
			d = 7;
		}else if(opponent.type1.equalsIgnoreCase("Ground")){
			d = 8;
		}else if(opponent.type1.equalsIgnoreCase("Flying")){
			d = 9;
		}else if(opponent.type1.equalsIgnoreCase("Psychic")){
			d = 10;
		}else if(opponent.type1.equalsIgnoreCase("Bug")){
			d = 11;
		}else if(opponent.type1.equalsIgnoreCase("Rock")){
			d = 12;
		}else if(opponent.type1.equalsIgnoreCase("Ghost")){
			d = 13;
		}else if(opponent.type1.equalsIgnoreCase("Dragon")){
			d = 14;
		}else if(opponent.type1.equalsIgnoreCase("Dark")){
			d = 15;
		} else if(opponent.type1.equalsIgnoreCase("Steel")){
			d = 16;
		}
		return d;
	}

}

	
	
	
	
	
	
	