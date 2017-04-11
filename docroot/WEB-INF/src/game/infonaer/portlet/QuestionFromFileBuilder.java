package game.infonaer.portlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

public class QuestionFromFileBuilder {
	File file;
	String fileName;

	public QuestionFromFileBuilder(File file) {
		this.file = file;
		this.fileName = file.getName();
	}
	
	public void buildQuestions() throws IOException{
		LineReader lr = new LineReader();
		try(Stream<String> stream = Files.lines(file.toPath())){
			stream.forEach(lr);
		}
	}
}
