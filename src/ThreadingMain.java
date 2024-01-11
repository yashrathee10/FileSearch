import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class ThreadingMain {
    public static void main(String[] args) {
        try{
            String path = "/Users/yashrathee/IdeaProjects/FileSearch/src/onboarding-h.09-01-2024.0.log";
            FileReader fr = new FileReader(path);
            RandomAccessFile file = new RandomAccessFile(path,"rws");
            Stream<String> filestream = Files.lines(Paths.get(path));
            long noOfLines = (int) filestream.count();
            System.out.println(noOfLines);
            System.out.println(file.length());
            Scanner in = new Scanner(System.in);
            String input = in.nextLine();
            int count =0;
            int threadNum= 5;
            ArrayList<Integer> countList = new ArrayList<>();
            int increment = (int)(file.length()/threadNum);
            FileWriter write = new FileWriter("/Users/yashrathee/IdeaProjects/FileSearch/src/Output.log");
            BufferedWriter bw = new BufferedWriter(write);
            ArrayList<Threading> threadlist = new ArrayList<>();
            ArrayList<Thread> othreadlist = new ArrayList<>();
            int start = 0;
            long begin = System.currentTimeMillis();
            for(int i=0; i<threadNum; i++){
                Threading threatCount = new Threading(start, start+increment, input, bw, file);
                start+=increment;
                Thread thread = new Thread(threatCount);
                thread.start();
                threadlist.add(threatCount);
                othreadlist.add(thread);
            }
            for(Thread thread : othreadlist){
                thread.join();
            }
            for(Threading thread : threadlist){
                count+= thread.count;
            }
            long end = System.currentTimeMillis();
            bw.close();
            System.out.println("Time Taken: " + (end-begin) + "\n" + "Count: " + count);
        }
        catch(IOException ex){
            ex.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
