import java.io.*;
import java.util.ArrayList;

public class Score{

    private ArrayList<String> scores = new ArrayList<>();
    private BufferedReader bufferedReader;

    public Score(){
        readScore();
        writeScore();
    }

    public void writeScore(){
        /*FileWriter fWriter = new FileWriter("resources/scores.txt");
        BufferedWriter bWriter = new BufferedWriter(fWriter);*/

        FileWriter fWriter = null;
        BufferedWriter bWriter = null;
        try{
            fWriter = new FileWriter("resources/scores.txt");
            bWriter = new BufferedWriter(fWriter);
            for(String score : scores){
                bWriter.write(score);
                bWriter.newLine(); /// add a new line after each score
            }
        }catch(IOException e){
            System.err.println("could not write on the file" + e.getMessage());
        }finally{
            try{
                if(bWriter != null){
                    bWriter.close();
                }
                if(fWriter != null){
                    fWriter.close();
                }
            }catch(IOException e){
                System.err.println("could not close the writers" + e.getMessage());
            }
        }
    }

    public void readScore() {
        try {
            bufferedReader = new BufferedReader(new FileReader("resources/scores.txt"));

            String score = bufferedReader.readLine();

            while (score != null) {
                System.out.println(score);
                scores.add(score);
                score = bufferedReader.readLine();
            }
            bufferedReader.close();
        }catch(IOException e){
            System.err.println("could not read");
        }
    }
}
