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
 *MorraApp.java - App class for Morra projetc
 *@authors - sconway
 *completed - 13/04/2020
 */

//import all classes
import java.util.*;

//declare class named MorraApp
public class MorraApp{

	//declare the main method
	public static void main(String args[]){

		// declare all variables.
		int playerGameWon,numberofrounds, compOdd, compEven, playerOdd, playerEven,bonusCompPoints, bonusPlayerPoints, computerPick,humanPick, total, playerScore, compScore, bonusPlayer, bonusComp, playerRoundWon, compRoundWon,CompRounds, numberofgamesplayed;
		String pick,numType,winner, answer, name;
		final int  WINNING_POINTS , BONUS_POINTS;

		// initialise all the varibles to either null or 0 values
		winner = "";
		humanPick = 0;
		answer = "";
		playerScore = 0;
		compScore = 0;
		bonusPlayer = 0;
		bonusComp = 0;
		pick = "";
		int playerTotal;
		int compTotal;
		playerTotal = 0;
		playerRoundWon = 0;
		compRoundWon = 0;
		CompRounds = 0;
		numberofgamesplayed = 0;
		bonusComp = 0;
		bonusCompPoints = 0;
		bonusPlayerPoints = 0;
		bonusPlayer = 0;
		playerOdd = 0;
		playerEven = 0;
		compOdd = 0;
		compEven = 0;
		computerPick =0;
		numberofrounds =0;
		playerGameWon =0;

		// constant - these points won't change
		WINNING_POINTS = 3;
		BONUS_POINTS = 2;

		// declare our objects
		Scanner input = new Scanner(System.in); // to take input form the user
		Scanner in = new Scanner(System.in); // also taking input from user but second Scanner declared to overcome issue with playing again
		Morra MyMorra = new Morra(); // object declared for our instantiable class

				// Input - intro to game request users name
		System.out.println("Welcome to the Morra Game! Please enter your name to continue..");
		name = input.nextLine();
		MyMorra.setName(name);
		System.out.println("---------------------------------------");
		System.out.println("Hi "+ name);

	do{

			// all these reset the score at the start of each game of after a users selects yes to play again so that we don't any score from previous games
			playerScore = 0;
			compTotal = 0;
			playerTotal = 0;
			bonusPlayer = 0;;
			compScore = 0;
			bonusComp = 0;
			playerOdd = 0;
			playerEven =0;
			compEven=0;
			bonusCompPoints = 0;
			bonusPlayerPoints = 0;

			// Tally up total history of all games starts here

			numberofgamesplayed = numberofgamesplayed + 1; // This adds to the total number of games played

			// this if adds to the total number of rounds a user won
			if(winner.equalsIgnoreCase("Player")){
			playerGameWon = playerGameWon+1;
			} else{}

			// determines the number of bonus points given to each player
			if(bonusPlayer == BONUS_POINTS){
			bonusPlayerPoints = bonusPlayerPoints+1;
					} else{
			 bonusCompPoints = bonusCompPoints+1;
				}

			// process - used to determine how many odd or even choices were made
			if(pick.equalsIgnoreCase("odd")){
			playerOdd = playerOdd + 1;
			compEven = compEven+1;
			} else if(pick.equalsIgnoreCase("even")){
			compOdd = compOdd+1;
			} else{}

			// tally of totals ends here

		do{ // start of each round

				pick = ""; // ensure that pick is null so the user can pick

				numberofrounds = numberofrounds + 1; // adds to the number of rounds played for the history part of the game

				System.out.println("________________________________________");

				// Input -  request input from user for choice
				System.out.println("Would you like to be Odd or Even?"); // get uses to input odd even
				pick = in.next();
				MyMorra.setPick(pick);
				MyMorra.checkPick(); // checks to see what the users odds or evens pick and sends it back to morra

				// Input - request users for input
				System.out.println("You know the rules so please stick out your fingers");
				humanPick = in.nextInt();
				MyMorra.sethumanPick(humanPick); // person picks what number they are going with and is sent to Morra class

				//random number generator by computer
				Random myRand = new Random();
				computerPick = myRand.nextInt(10); // this is where I get the computer pick
				computerPick = computerPick + 1; // as index starts at 0 we need to ensure we get at least one from the computer

				//outputs both the players pick and the computer pick
				System.out.println("======================================");
				System.out.println("You picked " + humanPick + " and your opponent picked " + computerPick); // shows both picks
				MyMorra.setcomputerPick(computerPick); // returns computerPick back to the morra class
				System.out.println("---------------------------------------");

				//process - both pick are sent back to instatiable class
				MyMorra.computeSumTotalFingers(); // calcualtes the sum of both picks
				total = MyMorra.getTotalFingers(); // gets total from myMorra class

				//output - total combined picks
				System.out.println("The total is: " +total); // prints total
				System.out.println("---------------------------------------");

				//process
				MyMorra.calcNumType();// calcualtes if number is odd or even
				numType = MyMorra.getNumType(); // gets number type from myMorra class

				//output
				System.out.println("The number is " +numType+"!"); // prints number type
				System.out.println("---------------------------------------");
				MyMorra.calcWinner(); // calcluates winner based on number type
				winner = MyMorra.getWinner(); // gets winner from myMorra class

				//output
				System.out.println("The winner is: "+winner); // gets winner based off if statment in morra class

				// if statements finding out who won starts here
				if(winner.equalsIgnoreCase("Player") && humanPick > computerPick){
				playerScore = playerScore + WINNING_POINTS;
				bonusPlayer = bonusPlayer + BONUS_POINTS;
				}
				// finds if winner is the player and awards points
				else if (winner.equalsIgnoreCase("Computer") && computerPick > humanPick)
				{
				compScore = compScore + WINNING_POINTS;
				bonusComp = bonusComp + BONUS_POINTS;

				}

				// gets the score for the computer
				else if (winner.equalsIgnoreCase("Player") && computerPick > humanPick){
				playerScore = playerScore + WINNING_POINTS;
				bonusComp = bonusComp + BONUS_POINTS;
				} else if (winner.equalsIgnoreCase("Computer") && humanPick > computerPick){
				compScore = compScore + WINNING_POINTS;
				bonusPlayer = bonusPlayer + BONUS_POINTS;
				}
				else {}

				//output
				playerTotal = playerScore + bonusPlayer; // get the total of the players score from aboove
				compTotal = compScore + bonusComp; // total comp score
				System.out.println("===============================");
				System.out.println("===========SCORES==============");
				System.out.println("===============================");
				System.out.println(name + " Score = " + playerScore); // prints out player score
				System.out.println(name + " Bonus = " + bonusPlayer); // prints out bonous score
				System.out.println("Total = " + playerTotal); // prints out total
				System.out.println("================================");
				System.out.println("Computer Score = " + compScore);//prints out comp score
				System.out.println("Computer Bonus = " + bonusComp);// prints out comp bonous
				System.out.println("Total = " + compTotal); // prints out comp total
				System.out.println("================================");

				// if statments used to tally up scores for histroy start below these are apart of the arrays later

				//numberofgamesplayed = numberofgamesplayed + 1; // used to odd up new games that are added each time
				if(winner.equalsIgnoreCase("Player")){
				playerRoundWon = playerRoundWon+1;
				} else{}

				// bonus points given out
				if(bonusPlayer == BONUS_POINTS){ //bonus for each player
					bonusPlayerPoints = bonusPlayerPoints+1;
					} else{
				bonusCompPoints = bonusCompPoints+1;
				} // this works

				// number of times odd/even was picked
				if(pick.equalsIgnoreCase("odd")){
					playerOdd = playerOdd + 1;
					compEven = compEven+1;
				} else if(pick.equalsIgnoreCase("even")){
					playerEven = playerEven + 1;
					compOdd = compOdd+1;
				} else{}

	}
		while (!(playerTotal >= 12 || compTotal >= 12)); // while completes when someone scores more than 12.


		if(playerTotal >= 12){ // this if statement determines who wins

		winner = "Player";
		System.out.println("***************************");
		System.out.println("**********Game Over********");
		System.out.println("***************************");
		}
		else if(compTotal >= 12){
		System.out.println("Computer wins!");
		System.out.println("***************************");
		System.out.println("**********Game Over********");
		System.out.println("***************************");
		}
		else if(playerTotal > compTotal){ // this condition added in the event that either player achieves over 12 so that the highest number wins
		winner = "Player";
		System.out.println("***************************");
		System.out.println("**********Game Over********");
		System.out.println("***************************");
		}
		else if(compTotal > playerTotal){ // this condition added in the event that either player achieves over 12 so that the highest number wins
		System.out.println("Computer wins!");
		System.out.println("***************************");
		System.out.println("**********Game Over********");
		System.out.println("***************************");
		}
		else{}

			System.out.println("======= Round history =========");
			// round history starts below

		// finding the number of games played and how many the user won
		int roundsPlayer[][] = {{numberofrounds},{playerRoundWon}};
		int len;
		len = roundsPlayer.length; // this is to ensure we don't go over the number of rounds played. Used in all Arrays

		for(int i = 0; i < roundsPlayer.length; i++){
			for(int j = 0; j < roundsPlayer[i].length; j++){
			}
		}


		System.out.println("Rounds Player"+(Arrays.deepToString(roundsPlayer) + "Rounds Won")); // this prints the Array in a string value so we can read it easily



		//output statement for the bonus points history section
		System.out.println("============================");
		System.out.println("======= Bonus points for round=========");

		// array for bonus points
		int bonousPoints[][] = {{bonusPlayer},{bonusComp}};
		for(int k = 0; k < roundsPlayer.length; k++){ // used the same length as above as that's the total number of rounds available
			for(int l = 0; l < roundsPlayer[k].length; l++){

		}
		} System.out.println("Player"+(Arrays.deepToString(bonousPoints) + "Comp")); // this prints the Array in a string value so we can read it easily


		//output statement for odds/evens history section
		System.out.println("============================");
		System.out.println("======= Number of Odds/Evens picked for round =========");
		System.out.println("======= Player:- Number of Odds/Evens picked for round =========");

		// array to find the number of odds/evens picked by player
		int playerOddsEvens[][] = {{playerOdd},{playerEven}};

		// extra points per round
		for(int m = 0; m < roundsPlayer.length; m++){
			for(int n = 0; n < roundsPlayer[m].length; n++){

		}
		}  System.out.println("Player Odds"+(Arrays.deepToString(playerOddsEvens) + "Player Even"));


		System.out.println("======= Computer:- Number of Odds/Evens picked for round =========");
		// array to find the number of odds/evens picked by Computer. Computer should always have opposite of what user has
		int compOddsEvens[][] = {{compOdd},{compEven}};
		for(int m = 0; m < roundsPlayer.length; m++){
			for(int n = 0; n < roundsPlayer[m].length; n++){
				System.out.println(playerOddsEvens[m][n]);
		}
		} System.out.println("Comp Odds"+(Arrays.deepToString(compOddsEvens) + "Comp even")); // printed so a user can read it easily

		  System.out.println("======= New Game =========");
		  System.out.println("Would you like to play again?"); // option give to the player to play again
		  answer = in.next(); // take answer from user
	} while(answer.equalsIgnoreCase("yes")); // when yes back to line 52

		//type "no" to print the below history

		//output of total game history
		System.out.println("============================");
		System.out.println("======= Total Game history ========="); // total history of all games starts here
		int roundsPlayer[][] = {{numberofgamesplayed},{playerGameWon}}; // this array is for total games played
		int len;
		len = roundsPlayer.length; // use this length to make sure we stay within the limits of games played

		for(int i = 0; i < roundsPlayer.length; i++){
			for(int j = 0; j < roundsPlayer[i].length; j++){

		}
		}System.out.println("Games played"+(Arrays.deepToString(roundsPlayer) + "Games Won")); // shows total in a way a user can read it

		System.out.println("============================");
		System.out.println("======= Total Bonus points =========");
		int bonousPoints[][] = {{bonusPlayerPoints},{bonusCompPoints}}; // array for distrubtion of total bonus points given out
		for(int k = 0; k < roundsPlayer.length; k++){
			for(int l = 0; l < roundsPlayer[k].length; l++){

		}
		} System.out.println("Bonus points for player"+(Arrays.deepToString(bonousPoints) + "Bonus points for comp")); // this is readable to the user


		//output - total even odds choosen by each player
		System.out.println("=========================================");
		System.out.println("======= Total Odds/Evens picked =========");
		System.out.println("-----------------------------------------");

		//total player odds and evens picks
		System.out.println("======= Player Pick=========");
		int playerOddsEvens[][] = {{playerOdd},{playerEven}}; // array for how many odds and evens are picked by user
		for(int m = 0; m < roundsPlayer.length; m++){
			for(int n = 0; n < roundsPlayer[m].length; n++){

		}
		}System.out.println("Player Odd Picks"+(Arrays.deepToString(playerOddsEvens) + "Player even pick"));

			//output - total computer odd/evens picks
			System.out.println("======= Computer Pick =========");
			int compOddsEvens[][] = {{compOdd},{compEven}};
			for(int m = 0; m < roundsPlayer.length; m++){
				for(int n = 0; n < roundsPlayer[m].length; n++){

		}
		}  System.out.println("Computer Odd Picks"+(Arrays.deepToString(compOddsEvens) + "Computer even pick"));
	}
}