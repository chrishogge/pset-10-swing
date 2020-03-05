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
		
		for(int i = 0; i < defs.size(); i++) {
			
			System.out.println(defs.get(i).getPartOfSpeech());
			
			if(defs.get(i).getPartOfSpeech().equals("noun")) {
				System.out.println("true");
				
				nounDefinitions += "\t" + defs.get(i).getDefinition() + "\n";
				
			}else if(defs.get(i).getPartOfSpeech().equals("verb")) {
				System.out.println("true");
				
				verbDefinitions += "\t" + defs.get(i).getDefinition() + "\n";
				
			}else if(defs.get(i).getPartOfSpeech().equals("adjective")) {
				System.out.println("true");
				
				adjectiveDefinitions += "\t" + defs.get(i).getDefinition() + "\n";
			}
		}
		
		if(!(nounDefinitions.equals("Noun: \n"))) {
			if(formattedDefinitions.length() != 0) {
				formattedDefinitions += "\n" + nounDefinitions;
			}else if(formattedDefinitions.length() == 0) {
				formattedDefinitions += nounDefinitions;
			}
		}
		
		if(!(verbDefinitions.equals("Verb: \n"))) {
			if(formattedDefinitions.length() != 0) {
				formattedDefinitions += "\n" + verbDefinitions;
			}else if(formattedDefinitions.length() == 0) {
				formattedDefinitions += verbDefinitions;
			}
		}
		
		if(!(adjectiveDefinitions.equals("Adjective: \n"))) {
			if(formattedDefinitions.length() != 0) {
				formattedDefinitions += "\n" + adjectiveDefinitions;
			}else if(formattedDefinitions.length() == 0) {
				formattedDefinitions += adjectiveDefinitions;
			}
		}
		
		return formattedDefinitions;
	}
	
}