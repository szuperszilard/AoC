import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Admin\\Desktop\\Szil\\AoC\\input2.txt");
        int gameNumber = 1;
        int sum = 0;

        try{
            Scanner scr = new Scanner(file);
            while(scr.hasNextLine()) {
                String newLine = "";
                String line = scr.nextLine();

                newLine = line.replace("Game " + gameNumber + ":", "");
                int useless = 0;
                for (int i = 0; i < newLine.length(); i++) {
                    if (newLine.contains(13 + i + " r") || newLine.contains(14 + i + " g") || newLine.contains(15 + i + " b")) {
                        useless++;
                    }
                }
                if(useless == 0){
                    sum+=gameNumber;
                }
                gameNumber++;
            }
        }catch(FileNotFoundException e){
            System.out.println("file not found");
        }
    System.out.println(sum);



    }
}