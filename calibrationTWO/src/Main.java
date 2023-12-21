import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        int sum = 0;

        String firstDigit = "";
        String lastDigit = "";
        int counter = 0;
        String first = "";
        String last = "";

        try {
            File input = new File("C:\\Users\\Admin\\Desktop\\input.txt");
            Scanner reader = new Scanner(input);

            while(reader.hasNextLine()) {
                    String data = reader.nextLine();


                    counter = 0;
                    int posFN = -1;
                    int posLN = -1;
                    int firstWord = 0;
                    int lastWord = 0;
                    int posFW = 200;
                    int posLW = -2;



                    for(int i=0; i<data.length();  i++) {

                        boolean flag = Character.isDigit(data.charAt(i));
                        if (flag) {

                            lastDigit = String.valueOf(data.charAt(i));
                            posLN = i;
                            if (counter == 0) {
                                firstDigit = String.valueOf(data.charAt(i));
                                posFN = i;
                            }
                            counter++;
                        }
                    }

                    int fOne = data.indexOf("one");
                    int lOne = data.lastIndexOf("one");
                    int fTwo = data.indexOf("two");
                    int lTwo = data.lastIndexOf("two");
                    int fThree = data.indexOf("three");
                    int lThree = data.lastIndexOf("three");
                    int fFour = data.indexOf("four");
                    int lFour = data.lastIndexOf("four");
                    int fFive = data.indexOf("five");
                    int lFive = data.lastIndexOf("five");
                    int fSix = data.indexOf("six");
                    int lSix = data.lastIndexOf("six");
                    int fSeven = data.indexOf("seven");
                    int lSeven = data.lastIndexOf("seven");
                    int fEight = data.indexOf("eight");
                    int lEight = data.lastIndexOf("eight");
                    int fNine = data.indexOf("nine");
                    int lNine = data.lastIndexOf("nine");


                    int[][] array = {{fOne, fTwo, fThree, fFour, fFive, fSix, fSeven, fEight, fNine}, {lOne, lTwo, lThree, lFour, lFive, lSix, lSeven, lEight, lNine}};

                    for(int i = 0; i<9; i++){
                        if(array[0][i]!=-1){
                            if(array[0][i]<posFW){
                                firstWord = i+1;
                                posFW = array[0][i];
                            }
                        }
                    }
                    for(int j = 0; j<9; j++){
                        if(array[1][j]!=-1){
                            if(array[1][j]>posLW){
                                lastWord = j+1;
                                posLW = array[1][j];
                            }
                        }
                    }

                    if(posFN!=-1){
                        if(posFW > posFN){
                            first = firstDigit;
                        }else{
                            first = Integer.toString(firstWord);
                        }
                    }else{
                        first = Integer.toString(firstWord);
                    }
                    if(posLN!=-1) {
                        if (posLW < posLN) {
                            last = lastDigit;
                        } else {
                            last = Integer.toString((lastWord));
                        }
                    }else{
                        last = Integer.toString(lastWord);
                        }
                    
                    int number = Integer.parseInt((first+last));
                    sum += number;
            }
            reader.close();
            } catch(FileNotFoundException e){
            System.out.println("file not found");
            e.printStackTrace();
             }
        
        System.out.println(sum);
    }
}


