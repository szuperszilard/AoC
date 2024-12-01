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
            boolean add = false;
            maps.add(new ArrayList<>());
            String[] seed;
            int length;
            String[] num_array_str = new String[3];
            long[] seeds = new long[20];

            while(scr.hasNextLine()){

                String line = scr.nextLine();
                if ((line.matches(".*\\d.*"))&&!(line.contains("seeds"))){
                    maps.get(maps_index).add(line);
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
                        maps.add(new ArrayList<>());}
                    add = true;
                }
            }

            for(int i = 0; i < seeds.length; i++){
            long number = seeds[i];

                for(int j = 0; j < maps.size(); j++){

                    for(int k = 0; k < maps.get(j).size(); k++){
                        String sor = maps.get(j).get(k);
                        num_array_str = sor.split(" ");
                        long[] nums = new long[3];
                        for(int l = 0; l<num_array_str.length; l++){
                            nums[l] = Long.parseLong(num_array_str[l]);
                        }
                        if(number <= nums[2]+nums[1] && number>=nums[1]) {

                            long subtract = nums[0] - nums[1];
                            number = number + subtract;
                            break;
                        }
                    }
                }
            System.out.println(number);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("file not found");
        }
    }
}
