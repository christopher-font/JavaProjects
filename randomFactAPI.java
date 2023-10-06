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

            String[] htmlSplit = htmlLine.split(":");

            String[] htmlLine2 = htmlSplit[2].split("\"");

            htmlLine = "";

            for (int i = 1; i < htmlLine2.length - 2; i++) {
                htmlLine += htmlLine2[i];
            }

            System.out.println(htmlLine);

        }  catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
}
