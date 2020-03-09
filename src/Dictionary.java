import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;



class Dictionary{
	
	public static ArrayList<Word> getWords(){
		try {
			
			Gson gson = new Gson();
			
		    Reader reader = Files.newBufferedReader(Paths.get("src/words.json"));

		    List<Word> words = Arrays.asList(gson.fromJson(reader, Word[].class));

		    ArrayList<Word> wordsAL = new ArrayList<Word>(words);
		    
		    // close reader
		    reader.close();
		    
		    return wordsAL;
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<String> getNames() {
		try {
			
			Gson gson = new Gson();
			
		    Reader reader = Files.newBufferedReader(Paths.get("src/words.json"));

		    List<Word> words = Arrays.asList(gson.fromJson(reader, Word[].class));
		    
		    ArrayList<String> names = new ArrayList<String>();
		    for(int i = 0; i < words.size(); i++) {
		    	names.add(words.get(i).getName());
		    }

		    // close reader
		    reader.close();
		    
		    return names;
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static ArrayList<Definition> getDefinitions(String name) {

	    Reader reader;
	    
		try {
			Gson gson = new Gson();
			reader = Files.newBufferedReader(Paths.get("src/words.json"));
		    List<Word> words = Arrays.asList(gson.fromJson(reader, Word[].class));
		    
		    ArrayList<Definition> defs = new ArrayList<Definition>();
		    
		    for(int i = 0; i < words.size();i++) {
		    	if(words.get(i).getName().equals(name)) {
		    		defs = (words.get(i).getDefinitions());
		    	}
		    }
		    
		   
		    
		    return defs;
		    
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	    return null;
	    
	}
	
	public static String formatDefinitions(ArrayList<Definition> defs) {
		String formattedDefinitions = "";
		String nounDefinitions = "Noun: \n";
		String verbDefinitions = "Verb: \n";
		String adjectiveDefinitions = "Adjective: \n";
		String nullDefinitions = "Uncategorized: \n";
		
		for(int i = 0; i < defs.size(); i++) {
			
			if(defs.get(i).getPartOfSpeech() != null) {
			
				if(defs.get(i).getPartOfSpeech().equals("noun")) {
					
					nounDefinitions += "\t- " + defs.get(i).getDefinition() + "\n";
					
				}else if(defs.get(i).getPartOfSpeech().equals("verb")) {
					
					verbDefinitions += "\t- " + defs.get(i).getDefinition() + "\n";
					
				}else if(defs.get(i).getPartOfSpeech().equals("adjective")) {
					
					adjectiveDefinitions += "\t- " + defs.get(i).getDefinition() + "\n";
				
				}
			}else if(defs.get(i).getPartOfSpeech() == null) {
				
				nullDefinitions += "\t- " + defs.get(i).getDefinition() + "\n";
			
			}
		}
		
		if(!(nounDefinitions.equals("Noun: \n"))) {
			
				formattedDefinitions += "\n" + nounDefinitions;
		
		}
		
		if(!(verbDefinitions.equals("Verb: \n"))) {
			
			formattedDefinitions += "\n" + verbDefinitions;
		
		}
		
		if(!(adjectiveDefinitions.equals("Adjective: \n"))) {
			
			formattedDefinitions += "\n" + adjectiveDefinitions;
			
		}
		
		if(!(nullDefinitions.equals("Uncategorized: \n"))) {

			formattedDefinitions += "\n" + nullDefinitions;
		
		}
		
		return formattedDefinitions;
	}
	
	public static String getFormattedWordDefinitions(int index) {
		
		String formattedDefinitions = formatDefinitions(getDefinitions(getNames().get(index)));
		
		return formattedDefinitions;
		
	}
	
	public static void editJson(ArrayList<Word> words) {
		try {
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();;
			
		    Reader reader = Files.newBufferedReader(Paths.get("src/words.json"));
		    
		    String wordsJson = gson.toJson(words);
		    		    
		    FileWriter fileWriter = new FileWriter("src/words.json");
		    
		    fileWriter.write(wordsJson);
		    fileWriter.close();

		    // close reader
		    reader.close();
		    
		   
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	public static ArrayList<String> getSyn(String name) {

		    Reader reader;
		    
			try {
				Gson gson = new Gson();
				reader = Files.newBufferedReader(Paths.get("src/words.json"));
			    List<Word> words = Arrays.asList(gson.fromJson(reader, Word[].class));
			    
			    ArrayList<String> synonyms = new ArrayList<String>();
			    
			    for(int i = 0; i < words.size();i++) {
			    	if(words.get(i).getName().equals(name)) {
			    		synonyms = (words.get(i).getSynonyms());
			    	}
			    }
			    
			   
			    
			    return synonyms;
			    
			    
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		    return null;
		
		
	}
	
	public static String getFormattedSyns(int index) {
		
		ArrayList<String> syns = getSyn(getWords().get(index).getName());
		String formattedSyns = "Synonyms: ";
		
		for(int i = 0; i < syns.size(); i++) {
			formattedSyns += "\n\t- " + syns.get(i);
		}
		
		return formattedSyns;
		
	}
	
	public static ArrayList<String> getAnt(String name) {

	    Reader reader;
	    
		try {
			Gson gson = new Gson();
			reader = Files.newBufferedReader(Paths.get("src/words.json"));
		    List<Word> words = Arrays.asList(gson.fromJson(reader, Word[].class));
		    
		    ArrayList<String> synonyms = new ArrayList<String>();
		    
		    for(int i = 0; i < words.size();i++) {
		    	if(words.get(i).getName().equals(name)) {
		    		synonyms = (words.get(i).getAntonyms());
		    	}
		    }
		    
		   
		    
		    return synonyms;
		    
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	    return null;
	
	
}

	public static String getFormattedAnts(int index) {
		
		ArrayList<String> ants = getAnt(getWords().get(index).getName());
		String formattedAnts = "Antonyms: ";
		
		for(int i = 0; i < ants.size(); i++) {
			formattedAnts += "\n\t- " + ants.get(i);
		}
		
		return formattedAnts;
		
	}
	
	public static ArrayList<Word> deleteWords(ArrayList<Integer> indexes){
		
	}
	
}