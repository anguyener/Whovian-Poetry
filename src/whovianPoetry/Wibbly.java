package whovianPoetry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.lang.Integer;

public class Wibbly {
	static Stack<String> stack; //= new Stack<String>();
	//length of poem, blueprint-poem in part of speech form, meter in "1010" form and rhyme of end
	String generatePoem(int length, String[] blueprint, String meter, String rhyme){
		stack  = new Stack<String>();
		String sentence = "";
		String poem = "";
		while(!rhymes(sentence, rhyme)){
			for(int i = 0; i < length;  i++) {
				loadStack(blueprint[i]);
				//stack.push("S");
				sentence = "";
				//ADD END LINE RHYME
				while(!stack.isEmpty()){
					// Pop item from stack
					String x = stack.pop();
					switch(x){
					case "ART":
						Article();
						break;
					case "ADJ":
						Adjective(meter);
						break;
					case "N":
						Noun(meter);
						break;
					case "V":
						Verb(meter);
						break;
					case "P":
						Preposition(meter);
						break;
					case "ADV":
						Adverb(meter);
					case "EX":
						Exclaimation(meter);
						break;
					case "Q":
						Question();
						break;
					default: // Terminal. Add to end of sentence
						sentence = sentence + " " + x;
					}
				}
			}
			poem = poem + "\n" + sentence;
		}
		return poem;
	} //end of generate


	/**
	 * Grammar rules for Articles (ART)
	 */
	void Article(){
		int x = (int)(Math.random() * 3); // random # 0, 1 or 2
		switch(x){
		case 0:
			stack.push("a");
			break;
		case 1:
			stack.push("an");
			break;
		case 2:
			stack.push("the");
			break;
		default:
			break;
		}	
	}

	/**
	 * Grammar rules for Adjectives (A)
	 * Paul and David
	 * 
	 */
	void Adjective(String meter){
		Collection<Word> words = Tardis.wordMap.values();
		int numWords = words.size();
		int rand = (int)(Math.random() * numWords);
		int counter = 0;
		String adj = "";
		for( Word w : words ) {
			if( w.partOfSpeech.contains("ADJ") && w.matchStartOfMeter(meter)) {
				adj = w.word;
			}
			if( counter == rand ){
				break;
			}
			counter++;
		}
		stack.push(adj.toLowerCase());
	}

	void Noun(String meter){
		Collection<Word> words = Tardis.wordMap.values();
		int numWords = words.size();
		int rand = (int)(Math.random() * numWords);
		int counter = 0;
		String noun = "";
		for( Word w : words ) {
			if( w.partOfSpeech.contains("N") && w.matchStartOfMeter(meter)) {
				noun = w.word;
			}
			if( counter == rand ){
				break;
			}
			counter++;
		}
		stack.push(noun.toLowerCase());
	}

	void Verb(String meter){
		Collection<Word> words = Tardis.wordMap.values();
		int numWords = words.size();
		int rand = (int)(Math.random() * numWords);
		int counter = 0;
		String verb = "";
		for( Word w : words ) {
			if( w.partOfSpeech.contains("V") && w.matchStartOfMeter(meter)) {
				verb = w.word;
			}
			if( counter == rand ){
				break;
			}
			counter++;
		}
		stack.push(verb.toLowerCase());
	}

	void Preposition(String meter){
		Collection<Word> words = Tardis.wordMap.values();
		int numWords = words.size();
		int rand = (int)(Math.random() * numWords);
		int counter = 0;
		String prep = "";
		for( Word w : words ) {
			if( w.partOfSpeech.contains("P") && w.matchStartOfMeter(meter)) {
				prep = w.word;
			}
			if( counter == rand ){
				break;
			}
			counter++;
		}
		stack.push(prep.toLowerCase());
	}
	void Adverb(String meter){
		Collection<Word> words = Tardis.wordMap.values();
		int numWords = words.size();
		int rand = (int)(Math.random() * numWords);
		int counter = 0;
		String adv = "";
		for( Word w : words ) {
			if( w.partOfSpeech.contains("ADV") && w.matchStartOfMeter(meter)) {
				adv = w.word;
			}
			if( counter == rand ){
				break;
			}
			counter++;
		}
		stack.push(adv.toLowerCase());
	}
	void Exclaimation(String meter){
		Collection<Word> words = Tardis.wordMap.values();
		int numWords = words.size();
		int rand = (int)(Math.random() * numWords);
		int counter = 0;
		String ex = "";
		for( Word w : words ) {
			if( w.partOfSpeech.contains("EX") && w.matchStartOfMeter(meter)) {
				ex = w.word;
			}
			if( counter == rand ){
				break;
			}
			counter++;
		}
		stack.push(ex.toLowerCase());
	}

	void Question(){
		stack.push("Doctor who?");
	}

	static void loadStack(String blueprint) {
		String[] plan = blueprint.split(" ");
		for (int i = plan.length-1; i >=0; i--) {
			stack.push(plan[i]);
		}
	}

	static boolean rhymes(String sent, String rhyme) {
		String[] target = rhyme.split(" ");
		String[] words = sent.split(" ");
		if(!stack.isEmpty())
			return false;
		else {
			String last = words[words.length-1]; 
			int numWords = 1;
			while(Tardis.getTargetPhonemes(last).length() < target.length){
				numWords++;
				last = words[words.length - numWords]+ last;
			}
			String[] phones = Tardis.getTargetPhonemes(last).split(" ");
			if(phones.length == target.length) {
				for(int i = 0; i < target.length; i++){
					if(phones[i].compareTo(target[i]) != 0)
						return false;
				}
				return true;
			}
			else{
				int start = phones.length - target.length;
				for(int j = start; j < target.length; j++){
					if(phones[j].compareTo(target[j]) != 0)
						return false;
				}
				return true;
			}
		}
	}

}
