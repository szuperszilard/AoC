import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static String array[][] = new String[140][140];
    public static String numWord = "";
    public static int sum = 0;
    public static int counter = 0;
    public static int arr[] = {0, 0, 0, 0, 0, 0, 0, 0};
    public static int count = 0;
    public static int helper = 0;
    public static int total = 0;
    public static int e = 1;

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Admin\\Desktop\\Szil\\AoC\\day3\\input.txt");

        try{
            Scanner scr = new Scanner(file);

            int i = 0;
            while (scr.hasNextLine() && i < 140) {
                String line = scr.nextLine();
                for (int j = 0; j < 140; j++) {
                    array[i][j] = String.valueOf(line.charAt(j));
                }
                i++;
            }



        }catch(FileNotFoundException e){

        }







        for (int j = 0; j < 140; j++) {
            for (int k = 0; k < 140; k++) {
                counter = 0;
                if (array[j][k].equals("*")){

                    for(int y = -1; y < 2; y = y + 2){
                        for(int x = -1; x < 2; x++){
                                    if (Character.isDigit(array[j + y][k + x].charAt(0))) {
                                        if (Character.isDigit(array[j + y][k + x - 1].charAt(0))) {
                                            if (Character.isDigit(array[j + y][k + x - 2].charAt(0))) {
                                                numWord = array[j + y][k + x - 2] + array[j + y][k + x - 1] + array[j + y][k + x];
                                                sum = Integer.parseInt(numWord);
                                                array[j + y][k + x - 2] = ".";
                                                array[j + y][k + x - 1] = ".";
                                                array[j + y][k + x] = ".";
                                            } else if (Character.isDigit(array[j + y][k + x + 1].charAt(0))) {
                                                numWord = array[j + y][k + x - 1] + array[j + y][k + x] + array[j + y][k + x + 1];
                                                sum = Integer.parseInt(numWord);
                                                array[j + y][k + x - 1] = ".";
                                                array[j + y][k + x] = ".";
                                                array[j + y][k + x + 1] = ".";
                                            } else {
                                                numWord = array[j + y][k + x - 1] + array[j + y][k + x];
                                                sum = Integer.parseInt(numWord);
                                                array[j + y][k + x - 1] = ".";
                                                array[j + y][k + x] = ".";
                                            }
                                        } else if (Character.isDigit(array[j + y][k + x + 1].charAt(0))) {
                                            if (Character.isDigit(array[j + y][k + x + 2].charAt(0))) {
                                                numWord = array[j + y][k + x] + array[j + y][k + x + 1] + array[j + y][k + x + 2];
                                                sum = Integer.parseInt(numWord);
                                                array[j + y][k + x] = ".";
                                                array[j + y][k + x + 1] = ".";
                                                array[j + y][k + x + 2] = ".";
                                            } else {
                                                numWord = array[j + y][k + x] + array[j + y][k + x + 1];
                                                sum = Integer.parseInt(numWord);
                                                array[j + y][k + x] = ".";
                                                array[j + y][k + x + 1] = ".";
                                                }

                                            } else {
                                                numWord = array[j + y][k + x];
                                                sum = Integer.parseInt(numWord);
                                                array[j + y][k + x] = ".";
                                                }
                                            arr[counter] = sum;
                                            counter ++;

                                    }

                        }
                    }

                    for(int x = -1; x < 2; x = x + 2){
                        if (x > 0) {
                            helper = 1;

                        }if (x < 0) {
                            helper = -1;
                        }

                        if (Character.isDigit(array[j][k + x].charAt(0))) {
                            if (Character.isDigit(array[j][k + x + helper].charAt(0))) {
                                if (Character.isDigit(array[j][k + x + (helper * 2)].charAt(0))) {
                                    if (helper == -1) {
                                        numWord = array[j][k + x + (helper * 2)] + array[j][k + x + helper] + array[j][k + x];
                                    } else {
                                        numWord = array[j][k + x] + array[j][k + x + helper] + array[j][k + x + (helper * 2)];
                                    }
                                    sum = Integer.parseInt(numWord);
                                    array[j][k + x] = ".";
                                    array[j][k + x + helper] = ".";
                                    array[j][k + x + (helper * 2)] = ".";
                                } else if (helper == -1) {
                                    numWord = array[j][k + x + helper] + array[j][k + x];
                                    sum = Integer.parseInt(numWord);
                                    array[j][k + x] = ".";
                                    array[j][k + x + helper] = ".";
                                } else {
                                    numWord = array[j][k + x] + array[j][k + x + helper];
                                    sum = Integer.parseInt(numWord);
                                    array[j][k + x] = ".";
                                    array[j][k + x + helper] = ".";
                                }

                            } else {
                                numWord = array[j][k + x];
                                sum = Integer.parseInt(numWord);
                                array[j][k + x] = ".";
                            }
                            arr[counter] = sum;
                            counter ++;

                        }
                    }
                }
                if(counter == 2){
                    e = 1;
                    for(int h = 0; h < 8; h++){
                        if(arr[h]!=0){
                            e = e*arr[h];
                        }
                    }
                    total = total + e;
                }
            }
        }


        System.out.print(total);
    }
}

