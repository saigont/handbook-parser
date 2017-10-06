import java.io.IOException;
import com.handbookparser.util.LinkParser;

public class Main {	
	public static void main(String[] args) throws IOException {
		
		String jsonResult = LinkParser.parseLink("https://github.com/egis/handbook/blob/master/Tech-Stack.md");
		System.out.println(jsonResult);
	}
}
