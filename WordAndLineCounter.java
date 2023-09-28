import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordAndLineCounter {

    public static void main(String[] args) throws IOException {
        final String path = "C:"+ File.separator + "Users" + File.separator + "mkharraz" + File.separator + "Documents" + File.separator + "test.txt";

        File file = new File(path);

        Scanner in = new Scanner(file);

        int i = 0;
        int j = 0;

        for (i = 0, j = 0; in.hasNext(); j++) {
            String str = in.nextLine();
            String [] words = str.split(" ");
            i += words.length;
        }

        in.close();

        System.out.println("Words: " + i);
        System.out.println("Lines: " + j);

    }

}
