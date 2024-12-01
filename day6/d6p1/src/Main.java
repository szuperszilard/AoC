import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File ("C:\\Users\\Szil\\Desktop\\teszt\\d6.txt");
        String[] numbersString = new String[4];
        long[][] table = new long[2][4];
        int rowCount = 0;

        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){

                String line = sc.nextLine();
                line = line.replaceAll("\\D"," " );
                line = line.trim();
                line = line.replaceAll(" + ", " ");
                numbersString = line.split(" ");
                for(int i=0; i <table[0].length; i++){
                    table[rowCount][i] = Integer.parseInt(numbersString[i]);
                }
                rowCount++;
            }

        }catch(FileNotFoundException e){
            System.out.println("file not found");
        }

        System.out.println(findCount(62737565 , 644102312401023l));


    }

    private static long findCount (long time, long distance){

        long firstPosition =(long)Math.ceil((time - Math.sqrt((time*time)-4*distance))/2);
        long lastPosition = time - firstPosition;
        long count = lastPosition - firstPosition +1;

        return count;

    }
}
