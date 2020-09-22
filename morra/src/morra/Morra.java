/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package morra;

/**
 *
 * @author Seamus Conway
 */
/*
 *Morra.java - Instantiable class for Morra project
 *@authors GROUP D - sconway
 *completed - 13/04/2020
 */

//import object of type Scanner
import java.util.Scanner;

	//declare instatiable class named Morra
	public class Morra{

		//declare variables
		private int sumTotalFingers, bonusPoints, humanPick, computerPick, total;
		private String numType, pick, winner, name;
		boolean isEven;
		private boolean choiceTest;

		//declare objects of type Scanner
		Scanner input = new Scanner(System.in);
		Scanner in = new Scanner(System.in);



		//create constructor

		public Morra(){

			//initialise variables to 0
			int sumTotalFingers = 0;
			int bonusPoints=0;
			int humanPick =0;
			int computerPick = 0;
			String pick = "";
			String numType = "";
			String winner = "";




	}//end of constructor


	//create setter to the player choice of odd or even
	public void setPick(String pick){
		this.pick = pick;
	}

	//create setter to set the players name
	public void setName(String name){
		this.name = name;
	}

	//process method to check that the player has only entered either odd or even
	public void checkPick(){

	do {
		boolean choiceTest;
		choiceTest = false;

		if (pick.equalsIgnoreCase("even")){

		System.out.println("Great, you will be Evens, and the Computer will be Odds");
		choiceTest = true;

	}
		else if (pick.equalsIgnoreCase("odd")){

		System.out.println("Great,you will be Odds, and the Computer will be Evens");
		choiceTest = true;
	}
		else {

		do {

			System.out.println(name + " You have entered the wrong choice. Please enter either Even or Odd");
			pick = input.nextLine();

			if(pick.equalsIgnoreCase("even") || pick.equalsIgnoreCase("odd"));
			break;


		} while (!(pick.equals("even")));

	}



	} while(choiceTest = false);


	System.out.println("--------------------------------------------------");
	System.out.println();

	}


	//create setter to set the players choice of number between 1 and 10
	//including statament so as to only accept a number between 1 and 10
	public void sethumanPick(int humanPick){
		this.humanPick = humanPick;


	}

	//setter to set the computer's choice between 1 and 10
	public void setcomputerPick(int computerPick){
		this.computerPick = computerPick;
	}


	//process - calculate total of player humanPick and computer Pick
	public void computeSumTotalFingers(){
		sumTotalFingers =humanPick+computerPick;
	}
		//create output

		//getter to return the total
	public int getTotalFingers(){
		return sumTotalFingers;
	}


	//process - calulcate if the total is odd or even
	public void calcNumType(){

	if(sumTotalFingers % 2 == 1){
		numType = "odd";
	}

	else if(sumTotalFingers % 2 == 0){
		numType = "Even";
	}
	}


	//getter to return whether the total is odd or even
	public String getNumType(){
			return numType;
	}


	//process - to calculate who the winner of each round is
	public void calcWinner(){

	if(sumTotalFingers%2 == 0 && pick.equalsIgnoreCase("even")){

	winner = "Player";
	System.out.println(winner + " Wins!...Good Job!");
	System.out.println("======================================");

	}

	else if(sumTotalFingers%2 == 1 && pick.equalsIgnoreCase("odd")){
		winner = "Player";
		System.out.println(winner + " Wins!....Good Job!");
		System.out.println("======================================");
	}

	else if(sumTotalFingers%2 == 0 && pick.equalsIgnoreCase("odd")){
		winner = "Computer";
		System.out.println(winner + " Wins!....Booooooooo!");
		System.out.println("======================================");
	}

	else if(sumTotalFingers%2 == 1 && pick.equalsIgnoreCase("even")){
		winner = "Computer";
		System.out.println(winner + " Wins!.....Booooooooo!");
		System.out.println("======================================");
	}

	else {
	}

	}

		//getter to return the winner of each round
	public String getWinner(){
			return winner;
	}






}
