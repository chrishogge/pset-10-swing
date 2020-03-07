public class Definition{
	private String definition;
	private String partOfSpeech;
	
	public Definition(String definition, String partOfSpeech) {
		this.definition = definition;
		this.partOfSpeech = partOfSpeech;
	}
	
	public String getDefinition() {
		return definition;
	}
	
	public String getPartOfSpeech() {
		return partOfSpeech;
	}
}