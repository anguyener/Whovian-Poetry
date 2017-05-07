package whovianPoetry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/*
 * This is basically going to be the same thing as Poet, but with some minor changes of how we input the info into
 * pronunciations, wordMap, wordList, etc....
 * 
 * Can we use Word or should we make our own word objects?.... hmmmmm
 * 
 * This class will also contain all the methods to write the different poems.
 * 
 */

public class Tardis {
	
	static String[] pronunciations = null;
	static Word[] wordList = null;  
	static HashMap<String, Word> wordMap = null;
	private static String vocab = null;
	static BufferedReader vocabReader = null;
	
	static String getRW(String phonemes){
		for(String w : wordMap.keySet()){
			if(wordMap.get(w).endsWith(phonemes))
				return wordMap.get(w).word;
		}
		return "Nono";
	}
	//UMMMM currently isPOS just returns true...
	//might want to fix that
	static String getPOSword(String pos){
		for(String w : wordMap.keySet()){
			if(wordMap.get(w).isPOS(pos))
				return wordMap.get(w).word;
		}
		return "Nono";
	}
	
	static String writeLineWithMeter(String meter){
		// Add words whose prefixes match what we are looking for.
		String rv = "";
		while(meter.length() > 0){
			String nextWord = findWordWithStressPrefix(meter);
			meter = meter.substring(numSyllables(nextWord));
			rv = rv + " " + nextWord; // + concatenates strings
		}
		return rv;
	}
	
	static String writeLineWithMeterAndRhymeswith(String meter, String target){
		String rhymer = "";
		String targetPhonemes = getTargetPhonemes(target);
		String[] phones = targetPhonemes.split(" ");
		String nonRhymeMeter = writeLineWithMeter(meter.substring(0, meter.length() - phones.length));
		for(String w : wordMap.keySet()){
			if(wordMap.get(w).endsWith(targetPhonemes)){
				rhymer = w;
				break;
			}
		}

		String line = nonRhymeMeter + rhymer;
		return line;

	}
	//inputs words outputs phonemes
	static String getTargetPhonemes(String target){
		String[] words = target.split(" ");
		int last = numSyllables(words[words.length - 1]);
		String targetPhonemes = wordMap.get(words[words.length - 1]).phonemes.toString();
		if(last<3)
			targetPhonemes = wordMap.get(words[words.length - 2]).phonemes.toString() + " " + targetPhonemes;
		return targetPhonemes;

	}
	
	private static String findWordWithStressPrefix(String meter) {
	
		int N = wordList.length;
		int i = (int)(N * Math.random());
		for(int j = 0; j < N; j++){
			int index = (i + j) % N;
			if(wordList[index].initialMeterMatch(meter))
				return wordList[index].word;
		}
		return "llama";
	}
	
	static int numSyllables(String w){
		Word wobj = wordMap.get(w);
		return wobj.numSyllables();
	}
	
	static void newBuildPronunciations(){
		// Open up the cmupron.txt file for reading
		try{
			FileReader g = null;
			g = new FileReader("SourceTexts/cmupron.txt");
			BufferedReader rhymingReader = new BufferedReader(g);
			String line = null;

			// Read the cmpupron file
			while((line = rhymingReader.readLine()) != null){
				String[] parts = line.trim().split(" ");
				if(!wordMap.containsKey(parts[0]))
					continue;
				Word w = wordMap.get(parts[0]);
				ArrayList<String> phonemes = new ArrayList<String>();
				ArrayList<Integer> stresses = new ArrayList<Integer>();
				for(int i = 1; i < parts.length; i++){
					String letters = parts[i].replaceAll("[0-9]", "");
					if(letters.length() != 0)
						phonemes.add(letters);
					String number  = parts[i].replaceAll("[^0-9]", "");
					if(number.length() != 0)
						stresses.add(Integer.parseInt(number));
				}
				// Copy the phonemes ArrayList into a fixed-size array
				String[] p = new String[phonemes.size()];
				for(int i = 0; i < phonemes.size(); i++)
					p[i] = phonemes.get(i);
				w.phonemes = p; // Set it in the Word object

				// Copy the stresses Array list into a fixed-size array 
				int[] s = new int[stresses.size()];
				for(int i = 0; i < stresses.size(); i++)
					s[i] = stresses.get(i);
				w.meter = s; // Set it in the Word object
			}
			rhymingReader.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
	
	static void openVocabReader(){
		try{
			FileReader f = new FileReader(vocab);
			vocabReader = new BufferedReader(f);
		} catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static void setVocab(String filename){
		vocab = filename;
		buildDataStructuresForNewFile();
	}
	
	private static void buildDataStructuresForNewFile(){
		// Read the vocab file, and build the initial wordMap
		openVocabReader();	               // Create the BufferedReader for our file
		wordMap = new HashMap<String, Word>(); // Initial, empty map

		try{
			String line = null;
			while((line = vocabReader.readLine()) != null){
				line = line.replaceAll("[^a-zA-Z ]", "");
				// words is an array of clean words (Strings) from the text
				String[] words = line.trim().toUpperCase().split(" ");
				for(String w : words){
					if(wordMap.containsKey(w))
						continue;
					Word word = new Word(w);
					wordMap.put(w, word);
				}
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		System.out.println("Found " + wordMap.size() + " words in " + vocab);


		// Build the  wordList array of Word structures
		// Note that you must create the array of the right size first,
		// then call the toArray() method, giving the array wordList as an argument
		wordList = new Word[wordMap.size()];
		wordMap.values().toArray(wordList);

		// Now add the pronunciations and meter for those words
		newBuildPronunciations();

		// And read the parts of speech
		readPOSFile();

	}
	//fixed????
	static int[] getMeter(String cmuline){
		return wordMap.get(cmuline).meter;
		//return new int[] {1, 0}; 
	}
	//HERE IS THE ANNOYING %'s IT MUST BE EXTERMINATED
	static void readPOSFile(){
		try { 
			FileReader f = new FileReader("SourceTexts/mpos.txt");
			BufferedReader reader = new BufferedReader(f);
			String line = null;
			int linesRead = 0;
			while ((line = reader.readLine()) != null) {
				linesRead++;
				if(linesRead % 10000 == 0)
					System.out.print("" + (int)(linesRead * 100 / 232123) + "% ");	
				String[] parts = line.split("\\*");
				String word = parts[0];
				String pos  = parts[1];
				if(wordMap.containsKey(word.toUpperCase()))
					wordMap.get(word.toUpperCase()).partOfSpeech = pos;
			}
			System.out.println("");
			reader.close();
		} catch (IOException x) {
			System.err.format("IOException: %s\n", x);
		}
	}
	
	static Word searchWordList(String w){
		// Binary search pronunciations array for wupper
		int lower = 0;
		int upper = wordList.length - 1;
		while(lower <= upper){
			int guess = (lower + upper) / 2;
			if(wordList[guess].word.equals(w))
				return wordList[guess];

			// check to see how wupper+" " compares to guess
			if(wordList[guess].word.compareTo(w) < 0) // guess < wupper
				lower = guess + 1;
			else
				upper = guess - 1;
		}

		// If we make it to here, then the word is not in our word list
		return null;
	}
	
	/*
	 * Getter method for the private vocab field
	 */
	public static String getVocab() {
		return vocab;
	}
	
}
