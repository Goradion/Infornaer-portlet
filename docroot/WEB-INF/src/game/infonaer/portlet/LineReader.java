package game.infonaer.portlet;

import java.util.function.Consumer;

public class LineReader implements Consumer<String> {

	@Override
	public void accept(String t) {
		String[] qArray = t.split(",");
		for (String s : qArray){
			System.out.println(s);
		}
	}

}
