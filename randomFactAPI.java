import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class randomFactAPI {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://uselessfacts.jsph.pl/api/v2/facts/random?language=en");

            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String htmlLine = in.readLine();

            in.close();

            String[] htmlSplit = htmlLine.split("\"");

            System.out.println(htmlSplit[7]);

        }  catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
