package whovianPoetry;

import java.util.Scanner;

public class Menu {

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Who would you like your whovian poem to be about?");
		System.out.println("1. The Doctor");
		System.out.println("2. A Companion");
		System.out.println("3. Villain");
		System.out.println("4. Other");
		String choiceOne = scan.nextLine();

		switch(choiceOne){
		case "1":		
			doctorMenu();
			break;
		case "2":
			companionMenu();
			break;
		case "3":		
			villainMenu();
			break;
		case "4":
			otherMenu();
			break;
		default:
			otherMenu();
		}


	}

	private static void doctorMenu() {
		System.out.println("Which Doctor would you like your poem to be about?");
		System.out.println("9, 10, 11, or 12?");
		
		String choiceDr = scan.nextLine();

		switch(choiceDr){
		case "9":		
			fantasticPoem();
			break;
		case "10":
			allonsyPoem();
			break;
		case "11":		
			geronimoPoem();
			break;
		case "12":
			facePoem();
			break;
		default:
			fantasticPoem();
		}

	}

	private static void companionMenu() {
		System.out.println("Which companion would you like your poem to be about?");
		System.out.println("1. Rose Tyler");
		System.out.println("2. Martha Jones");
		System.out.println("3. Donna Noble");
		System.out.println("4. Amy Pond");
		System.out.println("5. Rory Williams");
		System.out.println("6. Clara Oswald");
		System.out.println("7. River Song");
		
		String choiceDr = scan.nextLine();

		switch(choiceDr){
		case "1":		
			badWolfPoem();
			break;
		case "2":
			earthWalkerPoem();
			break;
		case "3":		
			mostImportantHumanPoem();
			break;
		case "4":
			girlWhoWaitedPoem();
			break;
		case "5":
			lastCenturionPoem();
			break;
		case "6":
			souffleGirlPoem();
			break;
		case "7":
			melodyPoem();
			break;
		default:
			badWolfPoem();
		}

	}


	private static void villainMenu() {
		// TODO Auto-generated method stub

	}
	private static void otherMenu() {
		// TODO Auto-generated method stub

	}
}
