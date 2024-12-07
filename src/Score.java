import java.io.*;
import java.util.ArrayList;

public class Score{

    private final ArrayList<String> scores = new ArrayList<>();
    private BufferedReader bufferedReader;
    private FileWriter fWriter = null;
    private BufferedWriter bWriter = null;
    /*private Board board = new Board();*/

    public Score(){
        readScore();
        writeScore();
    }

    public void scoreGetter(String score){
        scores.add(score);
    }

    public void writeScore(){
        /*FileWriter fWriter = new FileWriter("resources/scores.txt");
        BufferedWriter bWriter = new BufferedWriter(fWriter);*/

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
                    /*bWriter.flush();*/
                    bWriter.close();
                }
                if(fWriter != null){
                    /*fWriter.flush();*/
                    fWriter.close();
                }
            }catch(IOException e){
                System.err.println(e.getMessage());
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
