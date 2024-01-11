import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.Files;
import java.nio.file.Path;

public class WithoutThreading {
    public static void main(String[] args) {
        try {
            String path = "/Users/yashrathee/IdeaProjects/FileSearch/src/onboarding-h.09-01-2024.0.log";
            FileReader fr = new FileReader(path);
            BufferedReader bf = new BufferedReader(fr);
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            int line = 1;
            FileOutputStream out = new FileOutputStream("/Users/yashrathee/IdeaProjects/FileSearch/src/Output.log");
            long begin = System.currentTimeMillis();
            String line1;
            while((line1 = bf.readLine()) != null){
                if(Method.match(input, line1)){
//                    System.out.println("Found");
                    out.write(("Message: " + input +" "+ "Line: " + line + "\n").getBytes());
//                    break;
                }
                line++;
            }
            out.close();
            long end = System.currentTimeMillis();
            bf.close();
            System.out.println("Time Taken: " + (end-begin) + "\n" + "Count: " + Method.count);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}