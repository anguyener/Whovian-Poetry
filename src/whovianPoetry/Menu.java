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
		default:
			doctorMenu();
		}
	}

	private static void doctorMenu() {
		Doctor who = new Doctor();

		System.out.println("Which Doctor would you like your poem to be about?");
		System.out.println("9, 10, 11, or 12?");

		String choiceDr = scan.nextLine();

		switch(choiceDr){
		case "9":		
			who.nine();
			break;
		case "10":
			who.ten();
			break;
		case "11":		
			who.eleven();
			break;
		case "12":
			who.twelve();
			break;
		default:
			who.nine();
		}

	}

	private static void companionMenu() {
		Companion run = new Companion();

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
			run.badWolf();
			break;
		case "2":
			run.earthWalker();
			break;
		case "3":		
			run.mostImportantHuman();
			break;
		case "4":
			run.girlWhoWaited();
			break;
		case "5":
			run.lastCenturion();
			break;
		case "6":
			run.souffleGirl();
			break;
		case "7":
			run.melody();
			break;
		default:
			run.badWolf();
		}

	}


	private static void villainMenu() {
		Villain vil = new Villain();

		System.out.println("What villain would you like your poem to be about?");
		System.out.println("1. Daleks");
		System.out.println("2. Cybermen");
		System.out.println("3. The Master");
		System.out.println("4. Weeping Angels");
		System.out.println("5. The Silence");

		String choiceVil = scan.nextLine();

		switch(choiceVil){
		case "1":		
			vil.daleks();
			break;
		case "2":
			vil.cybermen();
			break;
		case "3":		
			vil.master();
			break;
		case "4":
			vil.angels();
			break;
		case "5":
			vil.silence();
			break;
		default:
			vil.daleks();
		}

	}
}
