package game.infonaer.portlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class QuestionFromFileBuilder {
	File file;
	String fileName;
	LinkedList<String> questions;
	LinkedList<String[]> questionsSplitted;
	public QuestionFromFileBuilder(File file) {
		this.file = file;
		this.fileName = file.getName();
	}
	
	public void buildQuestions() throws IOException{
		questionsSplitted = new LinkedList<String[]>();
		try{
			List<String> lines = Files.readAllLines(file.toPath());
			for(String line : lines){
				questions.add(line);
				String[] splitLine = line.split(",");
				if(splitLine.length==8){
					questionsSplitted.add(splitLine);
				}
					
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public LinkedList<String[]> getLoadedQuestions(){
		return questionsSplitted;
	}
}
