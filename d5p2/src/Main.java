import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\Szil\\Desktop\\teszt\\d5_data.txt");

        try{
            Scanner scr = new Scanner(file);
            int maps_index = 0;
            ArrayList<ArrayList<String>> maps = new ArrayList<>();
            ArrayList<ArrayList<long[]>> mapsLong = new ArrayList<>();
            boolean add = false;
            maps.add(new ArrayList<>());
            mapsLong.add(new ArrayList<>());
            String[] seed;
            int length;
            long[] seeds = new long[20];
            long[] numbersInLineLong = new long[3];
            int lineCounter = 0;

            while(scr.hasNextLine()){

                String line = scr.nextLine();
                if ((line.matches(".*\\d.*"))&&!(line.contains("seeds"))){
                    maps.get(maps_index).add(line);
                    String[] numbersInLineString = line.split(" ");
                    for(int i=0; i<3; i++) {
                        numbersInLineLong[i] = Long.parseLong(numbersInLineString[i]);
                    }
                    mapsLong.get(maps_index).add(new long[3]);
                    System.arraycopy(numbersInLineLong, 0, mapsLong.get(maps_index).get(lineCounter), 0, 3);
                    lineCounter++;
                }

                if (line.contains("seeds")){
                    seed = line.split(" ", -1);
                    length = seed.length;
                    for(int i = 0; i < length; i++){
                        if(seed[i].matches(".*\\d.*")){
                            long szam = Long.parseLong(seed[i]);
                            seeds[i-1]= szam;
                        }
                    }
                }

                if(!line.matches(".*\\d.*") && !line.matches(".*[a-z].*")) {
                    if(add){
                        maps_index++;
                        maps.add(new ArrayList<>());
                        mapsLong.add(new ArrayList<>());
                    }
                    add = true;
                    lineCounter = 0;
                }
            }
            long minLocation = Long.MAX_VALUE;

            for(int i=0; i<seeds.length-1; i=i+2){
                int counter = 1;
                long seedMAX = seeds[i] + seeds[i+1];
                long seedMIN = seeds[i];

                for(long j=seedMIN; j<seedMAX; j++){
                    int mapNumberSize = mapsLong.size();
                    long number = j;


                    for(int k=0; k<mapNumberSize; k++){
                        int mapLineSize = mapsLong.get(k).size();

                        for(int m=0; m<mapLineSize; m++){
                            long firstNumberInLine = mapsLong.get(k).get(m)[1];
                            long lastNumberInLine = mapsLong.get(k).get(m)[2]+mapsLong.get(k).get(m)[1];

                            if(number<=lastNumberInLine && number>=firstNumberInLine){
                                long subtract = mapsLong.get(k).get(m)[0] - mapsLong.get(k).get(m)[1];
                                number = number + subtract;
                                break;
                            }
                        }
                    }

                    if(number<minLocation){
                        minLocation = number;
                    }


                    /*System.out.println("counter = " + counter + " seed = " + j + " location = " + number);
                    counter++;*/

                }
                System.out.println("minLocation = " + minLocation);
            }



            /*for(int i=0; i<mapsLong.size(); i++){
                for(int j=0; j<mapsLong.get(i).size(); j++){
                    for(int k=0; k<3; k++){
                        System.out.print(mapsLong.get(i).get(j)[k] + " ");
                        if(k==2&&(j!=mapsLong.get(i).size()-1)){
                            System.out.println();
                        }
                    }
                }
                System.out.println("\n");
            }*/


        }
        catch(FileNotFoundException e) {
            System.out.println("file not found");
        }

    }
}