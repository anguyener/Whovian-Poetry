package whovianPoetry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.lang.Integer;

public class Wibbly {
	Stack<String> stack; //= new Stack<String>();

	String generatePoem(int length, int[] types, String meter, String rhyme){
		stack  = new Stack<String>();
		String sentence = "";
		String poem = "";
		for(int i = 0; i < length;  i++) {
			stack.push("S");
			sentence = "";
//ADD END LINE RHYME AND METER
			while(!stack.isEmpty()){
				// Pop item from stack
				String x = stack.pop();
				switch(x){
				case "0":		
					Sentence(Integer.parseInt(x));
					break;
				case "1":		
					Sentence(Integer.parseInt(x));
					break;
				case "2":		
					Sentence(Integer.parseInt(x));
					break;
				case "3":		
					Sentence(Integer.parseInt(x));
					break;
				case "4":		
					Sentence(Integer.parseInt(x));
					break;
				case "ART":
					Article();
					break;
				case "VP":
					VerbPhrase();
					break;
				case "NP":
					NounPhrase();
					break;
				case "A":
					Adjective();
					break;
				case "PP":
					PrepositionalPhrase();
					break;
				case "N":
					Noun();
					break;
				case "V":
					Verb();
					break;
				case "P":
					Preposition();
					break;
				case "Q":
					Question();
					break;
				default: // Terminal. Add to end of sentence
					sentence = sentence + " " + x;
				}
			}
			
			poem = poem + "\n" + sentence;
		}
		return poem;
	} //end of generate

	/**
	 * Grammar rules for Sentences (S)
	 */
	void Sentence(int type){
		//int x = (int)(Math.random() * 5); // random # 0, 1, 2 or 3
		switch(type){
		case 0:
			stack.push("VP");
			stack.push("NP");
			break;
		case 1:
			stack.push("S");
			stack.push("I find that");
			stack.push("V");
			stack.push("Whenever I");
			break;
		case 2:
			stack.push("N");
			stack.push("A");
			stack.push("my");
			stack.push("ate");
			stack.push("N");
			stack.push("A");
			stack.push("My");
			break;
		case 3:
			stack.push("Apples are rubbish");
			break;
		case 4:
			stack.push("Q"); // Create a question instead
			break;
		default:
			break;
		}
	}

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
	 * Grammar rules for Verb Phrases (VP)
	 * Mary and Madeleine
	 */
	void VerbPhrase(){
		int x = (int)(Math.random() * 5); // random # 0, 1, 2 or 3
		switch(x){
		case 0:
			stack.push("N");
			stack.push("ART");
			stack.push("V");
			break;
		case 1:
			stack.push("NP");
			stack.push("ART");
			stack.push("A");
			stack.push("V");
			break;
		case 2:
			stack.push("NP");
			stack.push("ART");
			stack.push("V");
			stack.push("happily");
			break;
		case 3:
			stack.push("V");
			stack.push("and");
			stack.push("V");
			break;
		case 4:
			stack.push("VP");
			stack.push("and");
			stack.push("VP");
			break;
		case 5:
			stack.push("N");
			stack.push("P");
			stack.push("V");
			stack.push("N");
			stack.push("A");
			stack.push("ART");
		case 6:
			stack.push("N");
			stack.push("ART");
			stack.push("P");
			stack.push("V");
			stack.push("N");
			stack.push("ART");
		case 7:
			stack.push("N");
			stack.push("and");
			stack.push("N");
			stack.push("ART");
			stack.push("V");
			stack.push("ART");
		case 8:
			stack.push("solemnly");
			stack.push("V");
			stack.push("and");
			stack.push("V");	
		default:
			break;
		}

	}


	/**
	 * Grammar rules for Noun Phrases (NP)
	 * Peter and Kathryn
	 * 
	 * XXX Reverse is corrected
	 */
	void NounPhrase(){
		int x = (int) (Math.random() * 7); //Put in the number of cases we come up with
		switch(x){
		case 0: // "Article" "Noun" like "the dog"
			stack.push("ART");
			stack.push("N");
			break;

		case 1: // "Article" "Adj" Noun" like "the big dog"
			stack.push("ART");
			stack.push("A");
			stack.push("N");
			break;

		case 2: // "Article" "Adj" "Adj" Noun" like "the great big dog"
			stack.push("ART");
			stack.push("A");
			stack.push("A");
			stack.push("N");
			break;

		case 3: // "article" "noun" and "article" "noun" like the cat and the dog
			stack.push("ART");
			stack.push("N");
			stack.push("and");
			stack.push("ART");
			stack.push("N");
			break;	

		case 4: // "article" "adjective" "noun" and "article" "noun" like the big cat and the dog
			stack.push("ART");
			stack.push("A");
			stack.push("N");
			stack.push("and");
			stack.push("ART");
			stack.push("N");
			break;

		case 5: // "article" "noun" and "article" "adjective" "noun" like the cat and the red dog
			stack.push("ART");
			stack.push("N");
			stack.push("and");
			stack.push("ART");
			stack.push("A");
			stack.push("N");
			break;

		case 6: // "article" "adjective" "noun" and "article" "adjective""noun" like the big cat and the red dog
			stack.push("ART");
			stack.push("A");
			stack.push("N");
			stack.push("and");
			stack.push("ART");
			stack.push("A");
			stack.push("ART");
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
	void Adjective(){
		Collection<Word> words = Tardis.wordMap.values();
		int numWords = words.size();
		int rand = (int)(Math.random() * numWords);
		int counter = 0;
		String adj = "";
		for( Word w : words ) {
			if( w.partOfSpeech.contains("A") ) {
				adj = w.word;
			}
			if( counter == rand ){
				break;
			}
			counter++;
		}
		stack.push(adj.toLowerCase());
	}

	
	/**
	 * Grammar rules for Adjectives (A)
	 * Paul and David
	 * 
	 */
	void Adjective(int num){
		Collection<Word> words = Tardis.wordMap.values();
		int counter = 0;
		int minToFind = Math.max(num, 100);
		ArrayList<String> adjs = new ArrayList<String>();
		for( Word w : words ) {
			if( w.partOfSpeech.contains("A") ) {
				counter++;
				adjs.add(w.word);
			}
			if( counter == minToFind ){
				break;
			}
		}
		String rv = "";
		if( adjs.size() < num ){
			for( String s : adjs ){
				rv += ", " + s;
			}
		}else{
			int found = 0;
			while( found < num ){
				int rand = (int)(Math.random() * adjs.size());
				if( !rv.contains(adjs.get(rand)) ){
					rv += ", " + adjs.get(rand);
					found++;
				}
			}
		}
		stack.push(rv.substring(2, rv.length()).toLowerCase());
	}





	/**
	 * Grammar rules for Prepositional Phrases (PP)
	 * Kyle and Julian
	 * 
	 * XXX Reverse. And also add some specific phrases.
	 */
	void PrepositionalPhrase(){
		int x = (int) (Math.random() * 6);
		switch(x){
		case 0:
			stack.push("N");
			stack.push("with");
			break;
		case 1:
			stack.push("NP");
			stack.push("and");
			stack.push("NP");
			stack.push("P");
			break;
		case 2:
			stack.push("N");
			stack.push("the");
			stack.push("P");
			break;
		case 3:
			stack.push("NP");
			stack.push("P");
			break;
		case 4:
			stack.push("NP");
			stack.push("or");
			stack.push("NP");
			stack.push("P");
			break;
		case 5:
			stack.push("N");
			stack.push("for");
			break;			
		}


	}

	/**
	 * Grammar rules for Nouns (N)
	 * Regina and Anna
	 */
	void Noun(){
		try{

			FileReader f = new FileReader("SourceTexts/mpos.txt");
			BufferedReader reader = new BufferedReader(f);
			String l = "";
			ArrayList<String> nouns = new ArrayList<String>();
			String[] line = null;

			for(int i = 0; i<232123; i++) {
				l = reader.readLine();
				line = l.trim().split("[*]");
				if(line[1].contains("N"))
					nouns.add(line[0]);
			}
			int n  = (int)(Math.random() * nouns.size());
			stack.push(nouns.get(n)); 
		}
		catch (IOException x) {
			System.err.format("Noun IOException\n", x);
		}


	}
	/* Regina and Anna
     * If plural is positive, noun is plural
     */
    void Noun(boolean plural){
        try{

            FileReader f = new FileReader("mpos.txt");
            BufferedReader reader = new BufferedReader(f);
            String l = "";
            ArrayList<String> nouns = new ArrayList<String>();
            ArrayList<String> pluralNouns = new ArrayList<String>();
            String[] line = null;

            for(int i = 0; i<232123; i++) {
                l = reader.readLine();
                line = l.trim().split("[*]");
                if(line[i+1].contains("N"))
                    nouns.add(line[i]);
            }

            for(int i = 0; i<232123; i++) {
                l = reader.readLine();
                line = l.trim().split("[*]");
                if(line[i+1].contains("p"))
                    pluralNouns.add(line[i]);
            }
            if(plural){
                int n  = (int)(Math.random() * pluralNouns.size());
                stack.push(pluralNouns.get(n));
            }
            else{
                int n  = (int)(Math.random() * nouns.size());
                stack.push(nouns.get(n));
            }
        }
        catch (IOException x) {
            System.err.format("IOException", x);
        }


    }
	
	
	/**
	 * Verb method that takes no parameters, for backward-compatibility
	 * 
	 * Selects either transitive or intransitive at random
	 */
	void Verb(){
		double r = Math.random();
		if(r < 0.5)
			Verb("i");
		else
			Verb("t");
	}



	/**
	 * Grammar rules for Verbs (V)
	 * Amena and Joanie
	 */
	void Verb(String choice){
		try{
			FileReader f = new FileReader("SourceTexts/mpos.txt");
			BufferedReader reader = new BufferedReader(f);
			String line = "";
			ArrayList<String> trans = new ArrayList<String>();
			ArrayList<String> intrans = new ArrayList<String>();
			String [] verbs = null;
			int t = (int)(Math.random() * trans.size());
			int i = (int)(Math.random() * intrans.size());

			for (int j = 0; j <232123; j++){
				line = reader.readLine();
				verbs = line.trim().split("[*]");
				if (verbs[1].contains("i")){
					intrans.add(verbs[0]);
				}
				if (verbs[1].contains("Vt")){
					trans.add(verbs[0]);
				}
			}
			int x = 0;
			if(choice.equals("t")){
				stack.push(trans.get(t));
			}
			if(choice.equals("i")){
				stack.push(intrans.get(i));
			}
			if(choice.equals("")){
				switch(x){
				case 0:
					stack.push(trans.get(t));
					break;
				case 1:
					stack.push(intrans.get(i));
					break;
				}
			}
		}
		catch (IOException x) {
			System.err.format("Verb IOException\n", x);
		}
	}



	/**
	 * Grammar rules for Prepositions (P)
	 * Minh and Yeabkal
	 */
	void Preposition(){

		try{
			String[] mposWords = new String[232123];
			String line = "";
			FileReader f = new FileReader("SourceTexts/mpos.txt");
			BufferedReader reader = new BufferedReader(f);
			int i = 0;
			while( !line.equals("zZt*N") ){
				line = reader.readLine();
				mposWords[i] = line;
				i++;		
			}
			reader.close();
			int j = 0;
			for( String x : mposWords ){
				if( x.contains("*P") && exists(Tardis.getVocab(),x))
					j++;

			}
			String[] prepArray = new String[j];
			int k=0;
			for(String x : mposWords){
				if(x.contains("*P") && exists(Tardis.getVocab(),x))
				{
					prepArray[k] = x;	   
					k++;
				}
			}
			int val=0;
			int p = (int)(Math.random() * prepArray.length);
			String prep = prepArray[p];
			for(int m=0;m<=prep.length();m++)
			{
				if(prep.charAt(m)=='*')
				{
					val= m;
					break;
				}
			}
			stack.push(prepArray[p].substring(0,val));

		}
		catch (IOException x) {
			System.err.format("Preposition IOException\n", x);
		}
	}

      // for prepositions
	// checks if a word is found in the vocab file
	// helper function for the Prepostions() function
      static boolean exists(String filename, String x)
      {
    	  boolean ret = false;
    	  try
    	  {
    	  FileReader f = new FileReader(filename);
		  BufferedReader reader = new BufferedReader(f);
		  
		  String line = "";
		  while((line = reader.readLine()) != null)
		  {
			  if(line.contains(x))
				  return true;
		  }
    	  }
    	  catch (IOException ix) {
  			System.err.format("Preposition IOException\n", ix);
  		}
			return ret;
      }



	/**
	 * Grammar rules for Questions (Q)
	 * Diego and Mary Kate
	 */
	void Question(){
		int x = (int)(Math.random() * 3); // random # 0, 1, or 2
		switch(x){

		/** CASE 0
		 * Declarative sentence with a question mark
		 * Ex: It is snowing in Florida?
		 */
		case 0:
			stack.push("?");
			stack.push("VP");
			stack.push("NP");
			break;


			/** CASE 1
			 * "Wh" interrogative sentences
			 * Ex: What are you doing?
			 * Ex: Why did you go to the park?
			 */
		case 1:
			stack.push("?");
			stack.push("VP");
			stack.push("NP");
			int y = (int)(Math.random() * 2); // random # 0 or 1
			switch(y){ // switch btwn "do"/"does"
			case 0:
				stack.push("do");
				break;
			case 1:
				stack.push("does");
				break;		
			}
			int z = (int)(Math.random() * 4); // random # 0, 1, 2, or 3
			switch(z){ //switch btwn interrogative openers
			case 0:
				stack.push("When");
				break;
			case 1:
				stack.push("Why");
				break;
			case 2:
				stack.push("What");
				break;
			case 3:
				stack.push("Which");
				break;
			}	   
			break;


			/** CASE 2
			 * yes/no interrogative sentences
			 * Ex: Did you walk the dog?
			 * Ex: Are you hungry?
			 */
		case 2:
			stack.push("?");
			stack.push("PP");
			stack.push("VP");
			stack.push("NP");
			int y1 = (int)(Math.random() * 4); // random # 0, 1, 2, or 3
			switch(y1){ //switch btwn different verbal forms of do, be, be able
			case 0:
				stack.push("Did");
				break;
			case 1:
				stack.push("Do");
				break;
			case 2:
				stack.push("Can");
				break;
			case 3:
				stack.push("Are");
				break;
			}
			break;

		}
	}



}
