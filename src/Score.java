import java.io.*;
import java.util.ArrayList;

public class Score{

    private final ArrayList<String> scores = new ArrayList<>();
    private BufferedReader bufferedReader;
    private FileWriter fWriter = null;
    private BufferedWriter bWriter = null;

    public Score(){
        readScore();
    }

    public void scoreAdd(String score){
        scores.add(score);
        System.out.println(scores); //debug
        writeScore(); // insere os valores no txt ter sido feito o add no arraylist
    }

    public void writeScore(){

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
