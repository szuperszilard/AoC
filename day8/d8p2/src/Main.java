import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Szil\\Desktop\\Teszt\\d8.txt");
        String[] lefRightArray = new String[281];
        Map<String, String[]> directions = new HashMap<>();
        String first = "";
        String secondOne = "";
        String secondTwo = "";
        ArrayList<String> endsWith = new ArrayList<>();

        String from = "KLA";
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
                    if(line.charAt(2) == 'A'){
                        endsWith.add(first);
                    }
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

        int counter = 0;
        int[] cycleLength = new int[6];
        int index = 0;

        for (int i = 0; i < endsWith.size(); i++) {
            from = endsWith.get(i);
            while (true) {

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

                if (from.charAt(2) == 'Z') {
                    cycleLength[index] = counter;
                    counter = 0;
                    index++;
                    break;
                }
            }
        }
        BigInteger[] cycleBigInt = new BigInteger[6];
        for(int i = 0; i < cycleLength.length ; i++){
            cycleBigInt[i] = BigInteger.valueOf(cycleLength[i]);
            System.out.println(cycleLength[i]);
        }
        BigInteger answer = lcm(lcm(lcm(lcm(lcm(cycleBigInt[0], cycleBigInt[1]), cycleBigInt[2]), cycleBigInt[3]), cycleBigInt[4]), cycleBigInt[5]);
        System.out.println(answer);
    }
    public static BigInteger lcm (BigInteger num1, BigInteger num2){

        BigInteger multipli = num1.multiply(num2);
        BigInteger gcd = num1.gcd(num2);

        return multipli.divide(gcd);
    }
}

