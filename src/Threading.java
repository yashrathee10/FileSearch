import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Threading implements Runnable{
    private int start;
    private int end;
    private String input;
    private BufferedWriter bf;
    private RandomAccessFile file;
    public Threading(int start, int end,String input, BufferedWriter bf,RandomAccessFile file){
        this.start = start;
        this.end = end;
        this.input=input;
        this.bf= bf;
        this.file= file;
    }
    public int count=0;
    @Override
    public void run(){
        try {
            Pattern pattern = Pattern.compile("\"message\":\"(.*?" + input + ".*?)\"");
            file.seek(start);
            for(int i=start; i<end; i++){
                String str = file.readLine();
                Matcher matcher = pattern.matcher(str);
                if (matcher.find()) {
                    count++;
                    
                    bf.write("Line is : " + file.readLine());
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
