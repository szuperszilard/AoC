import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int power;
        int sum = 0;
        String num;
        int number;
        File input = new File("C:\\Users\\Admin\\Desktop\\Szil\\AoC\\input2.txt");
        try {
            Scanner scr = new Scanner(input);
            while(scr.hasNextLine()) {

               String str = scr.nextLine();
                int minB = 0;
                int minR = 0;
                int minG = 0;
                String[] arr = new String[str.length()];
                for (int i = 0; i < str.length(); i++) {
                    arr[i] = String.valueOf(str.charAt(i));
                }
                for(int i = 0; i<str.length(); i++){
                    if(arr[i].equals("b")){
                        if(arr[i-3].equals(" "))
                            num = arr[i-2];
                        else num = arr[i-3].concat(arr[i-2]);
                        number = Integer.parseInt(num);
                        if(number>minB){
                            minB = number;
                        }
                    }
                    if(arr[i].equals("g")){
                        if(arr[i-3].equals(" "))
                            num = arr[i-2];
                        else num = arr[i-3].concat(arr[i-2]);
                        number = Integer.parseInt(num);
                        if(number>minG){
                            minG = number;
                        }
                    }
                    if(arr[i].equals("r") && arr[i-1].equals(" ")){
                        if(arr[i-3].equals(" "))
                            num = arr[i-2];
                        else num = arr[i-3].concat(arr[i-2]);
                        number = Integer.parseInt(num);
                        if(number>minR){
                            minR = number;
                        }
                    }
                }

                power = minR*minG*minB;
                sum+=power;


            }
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        System.out.println(sum);

    }
}