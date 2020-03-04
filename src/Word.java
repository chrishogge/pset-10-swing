import java.util.ArrayList;

public class Word {
	
	public String word;
	public ArrayList<Definition> definitions; 
	public ArrayList<String> synonyms;
	public ArrayList<String> antonyms;
	
	public Word() {
		
	}
	
	public Word(String name, ArrayList<Definition> definitions, ArrayList<String> synonyms, ArrayList<String> antonyms) {
		this.word = name;
		this.definitions = definitions;
		this.synonyms = synonyms;
		this.antonyms = antonyms;
	}
	
	public String getName() {
		return word;
	}
	
	public ArrayList<Definition> getDefinitions() {
		return definitions;
	}
	
	public ArrayList<String> getSynonyms() {
		return synonyms;
	}
	
	public ArrayList<String> getAntonyms() {
		return antonyms;
	}
	
}