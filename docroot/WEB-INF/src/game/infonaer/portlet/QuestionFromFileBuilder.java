package game.infonaer.portlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;

import de.ki.sbam.model.Category;
import de.ki.sbam.service.CategoryLocalServiceUtil;

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
			questions = new LinkedList<String>();
			List<String> lines = Files.readAllLines(file.toPath());
			for(String line : lines){
				questions.add(line);
				String[] splitLine = line.split("\\|");
				if(splitLine.length==8){
					if(isValidQuestion(splitLine))
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
	
	private boolean isValidQuestion(String[] q){
		for(int i=0;i<8;i++){
			switch(i){
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
				if(q[i].isEmpty())
					return false;
				break;
			case 5:
				String a = q[i].toLowerCase();
				if((a.equals("a")||a.equals("b")||a.equals("c")||a.equals("d")))
					break;
				return false;
			case 6:
				List<Category> cats = CategoryLocalServiceUtil.getCategories(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				List<String> catNames = new LinkedList<String>();
				for(Category c : cats){
					catNames.add(c.getCategoryName());
				}
				if(catNames.contains(q[i])){
					break;
				}
				return false;
			case 7:
				int difficulty = Integer.parseInt(q[i]);
				if(difficulty==1 || difficulty==2 || difficulty==3){
					break;
				}
				return false;
			default:
				return false;
			}
		}
		return true; // all criteria are passed
	}
}
