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
	
	public static void getDefinitions(String name) {

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
		    
		   
		    
		    for(int j = 0; j < defs.size(); j++) {
		    	System.out.println(defs.get(j).getDefinition());
		    }
		    
		    
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	    
	    
	}
	
}