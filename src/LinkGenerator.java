import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LinkGenerator {

    private String initialize = "https://en.wikipedia.org/wiki/";
    public File createFile(){
        File links = new File("/Users/kritikaparajuli/Documents/CSC365-AssignmentTwo/links.xml");
        writeToFile();
        return links;
    }

    private void writeToFile(){
        try{
            FileWriter writer = new FileWriter("links.xml");
            writer.write("<websites>");
            writer.write("\n");
            ArrayList<String> wordsList = pageList();
            
            for( int i = 0; i<wordsList.size(); i++){
                StringBuilder b = new StringBuilder();
                b.append(" <site url = \"").append(initialize).append(wordsList.get(i)). append("\"").append("/>");
                writer.write(b.toString());
                writer.write("\n");
            }
            writer.write("</websites>");
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private ArrayList<String> pageList() throws FileNotFoundException{
        ArrayList<String> str = new ArrayList<>();
        String x;
        File words = new File("words.txt");
        Scanner scanner = new Scanner(words);
        while(scanner.hasNextLine()){
            x = scanner.nextLine();
            str.add(x);
        }
        scanner.close();
        return str;
    }

}
