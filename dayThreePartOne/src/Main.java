import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static int sum = 0;
    public static String numWord = "";
    public static String[][] array = new String[140][140];
    public static File file = new File("C:\\Users\\Admin\\Desktop\\Szil\\AoC\\day3\\input.txt");
    public static int j = 0;
    public static int k = 0;


    public static void main(String[] args) {
        try {

            Scanner scr = new Scanner(file);
            int i = 0;

            while (scr.hasNextLine() && i < 140) {
                String line = scr.nextLine();
                for (int j = 0; j < 140; j++) {
                    array[i][j] = String.valueOf(line.charAt(j));
                }
                i++;
            }

            checker(-1, -1);
            checker(0, -1);
            checker(1, -1);
            checker(-1, 1);
            checker(0, 1);
            checker(1, 1);
            checkerr(-1);
            checkerr(1);

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        System.out.print(sum);

    }

    public static void checker(int x, int y) {
        for (int j = 0; j < 140; j++) {
            for (int k = 0; k < 140; k++) {

                if (array[j][k].equals("%") || array[j][k].equals("&") || array[j][k].equals("*") || array[j][k].equals("=") || array[j][k].equals("$") || array[j][k].equals("#") ||
                        array[j][k].equals("/") || array[j][k].equals("+") || array[j][k].equals("@") || array[j][k].equals("-")) {
                    if (Character.isDigit(array[j + y][k + x].charAt(0))) {
                        if (Character.isDigit(array[j + y][k + x - 1].charAt(0))) {
                            if (Character.isDigit(array[j + y][k + x - 2].charAt(0))) {
                                numWord = array[j + y][k + x - 2] + array[j + y][k + x - 1] + array[j + y][k + x];
                                sum += Integer.parseInt(numWord);
                                array[j + y][k + x - 2] = ".";
                                array[j + y][k + x - 1] = ".";
                                array[j + y][k + x] = ".";
                            } else if (Character.isDigit(array[j + y][k + x + 1].charAt(0))) {
                                numWord = array[j + y][k + x - 1] + array[j + y][k + x] + array[j + y][k + x + 1];
                                sum += Integer.parseInt(numWord);
                                array[j + y][k + x - 1] = ".";
                                array[j + y][k + x] = ".";
                                array[j + y][k + x + 1] = ".";
                            } else {
                                numWord = array[j + y][k + x - 1] + array[j + y][k + x];
                                sum += Integer.parseInt(numWord);
                                array[j + y][k + x - 1] = ".";
                                array[j + y][k + x] = ".";
                            }
                        } else if (Character.isDigit(array[j + y][k + x + 1].charAt(0))) {
                            if (Character.isDigit(array[j + y][k + x + 2].charAt(0))) {
                                numWord = array[j + y][k + x] + array[j + y][k + x + 1] + array[j + y][k + x + 2];
                                sum += Integer.parseInt(numWord);
                                array[j + y][k + x] = ".";
                                array[j + y][k + x + 1] = ".";
                                array[j + y][k + x + 2] = ".";
                            } else {
                                numWord = array[j + y][k + x] + array[j + y][k + x + 1];
                                sum += Integer.parseInt(numWord);
                                array[j + y][k + x] = ".";
                                array[j + y][k + x + 1] = ".";
                            }

                        } else {
                            numWord = array[j + y][k + x];
                            sum += Integer.parseInt(numWord);
                            array[j + y][k + x] = ".";
                        }
                    }
                }
            }
        }
    }

    public static void checkerr(int x) {
        int helper = 0;
        if (x > 0) {
            helper = 1;
        }
        if (x < 0) {
            helper = -1;
        }
        for (int j = 0; j < 140; j++) {
            for (int k = 0; k < 140; k++) {
                if (array[j][k].equals("%") || array[j][k].equals("&") || array[j][k].equals("*") || array[j][k].equals("=") || array[j][k].equals("$") || array[j][k].equals("#") ||
                        array[j][k].equals("/") || array[j][k].equals("+") || array[j][k].equals("@") || array[j][k].equals("-")) {
                    if (Character.isDigit(array[j][k + x].charAt(0))) {
                        if (Character.isDigit(array[j][k + x + helper].charAt(0))) {
                            if (Character.isDigit(array[j][k + x + (helper * 2)].charAt(0))) {
                                if (helper == -1) {
                                    numWord = array[j][k + x + (helper * 2)] + array[j][k + x + helper] + array[j][k + x];
                                } else {
                                    numWord = array[j][k + x] + array[j][k + x + helper] + array[j][k + x + (helper * 2)];
                                }
                                sum += Integer.parseInt(numWord);
                                array[j][k + x] = ".";
                                array[j][k + x + helper] = ".";
                                array[j][k + x + (helper * 2)] = ".";
                            } else if (helper == -1) {
                                         numWord = array[j][k + x + helper] + array[j][k + x];
                                sum += Integer.parseInt(numWord);
                                array[j][k + x] = ".";
                                array[j][k + x + helper] = ".";
                                    } else {
                                        numWord = array[j][k + x] + array[j][k + x + helper];
                                sum += Integer.parseInt(numWord);
                                array[j][k + x] = ".";
                                array[j][k + x + helper] = ".";
                                    }

                        } else {
                            numWord = array[j][k + x];
                            sum += Integer.parseInt(numWord);
                            array[j][k + x] = ".";
                        }
                    }
                }
            }
        }
    }
}
