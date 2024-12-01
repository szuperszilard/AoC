import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Szil\\Desktop\\Teszt\\d8.txt");
        String[] lefRightArray = new String[281];
        Map<String, String[]> directions = new HashMap<>();
        String first = "";
        String secondOne = "";
        String secondTwo = "";

        String from = "AAA";
        int stepsCount = 0;

        try{
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()){

                String line = sc.nextLine();
                if(line.length()>31){
                    lefRightArray = line.split("");
                }else{
                    secondOne = secondOne + line.charAt(7)+line.charAt(8)+line.charAt(9);
                    secondTwo = secondTwo+ line.charAt(12)+line.charAt(13)+line.charAt(14);
                    first = first + line.charAt(0)+line.charAt(1)+line.charAt(2);
                    String[] secondColumn = new String[2];
                    secondColumn[0] = secondOne;
                    secondColumn[1] = secondTwo;
                    directions.put(first, secondColumn);
                    secondOne = "";
                    secondTwo = "";
                    first = "";
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        long counter = 0;
        while(true) {

            if (lefRightArray[stepsCount].equals("L")) {
                from = directions.get(from)[0];
            } else {
                from = directions.get(from)[1];
            }
            if (stepsCount == 280) {
                stepsCount = 0;
            } else {
                stepsCount++;
            }
            counter++;
            System.out.println(counter + " " + from);
            if(Objects.equals(from, "ZZZ")){
                break;
            }
        }
    }
}