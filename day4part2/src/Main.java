import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {


        File file = new File("D:\\JavaProjects\\day4part2\\input.txt");
        try{
            Scanner scr = new Scanner(file);
            int[] count = new int[220];
            int[] cardNumber = new int[220];
            Arrays.fill(cardNumber, 1);
            int arr = 0;
            while(scr.hasNextLine()){
                String line = scr.nextLine();
                String[] parts = line.split("\\|", 0);
                String part1 = parts[0];
                String part2 = parts[1];
                int counter = 0;
                String[] numbers = part2.split(" ");
                for(int i = 0; i < numbers.length; i++){
                    if(isNumeric(numbers[i])){
                        if(part1.contains(" " + numbers[i] + " ")){
                            counter ++;
                        }
                    }
                }
                count[arr] = counter;
                arr++;

            }
            for(int i = 0; i < 220; i++){
                for(int j = 0; j < cardNumber[i]; j++){
                    for(int k = 1; k <= count[i]; k++){
                        cardNumber[k+i]++;
                    }
                }
            }
            int sum = IntStream.of(cardNumber).sum();
            System.out.println("The sum is " + sum);

        }catch(FileNotFoundException e){
            System.out.println("file not found");
        }

    }
    public static boolean isNumeric(String strNum) {

        try {
            int num = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
