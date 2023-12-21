import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int sum = 0;
        try {
            File input = new File("C:\\Users\\Admin\\Desktop\\input.txt");
            Scanner myReader = new Scanner(input);
            String data = "";
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                int counter = 0;
                String firstDigit = "";
                String lastDigit = "";
                String number = "";

                for(int i=0; i<data.length();  i++){

                    boolean flag = Character.isDigit(data.charAt(i));
                    if(flag){

                        lastDigit = String.valueOf(data.charAt(i));

                        if(counter == 0){
                            firstDigit = String.valueOf(data.charAt(i));
                        }
                        counter++;
                    }
                }
                number = firstDigit + lastDigit;
                sum += Integer.parseInt(number);

            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        System.out.print(sum);

    }
}