import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\Szil\\Desktop\\teszt\\d7.txt");
        String[] lineArray = new String[2];
        Map<String, Integer> handAndBid = new HashMap<>();
        ArrayList<Hand> highCardList = new ArrayList<>();
        ArrayList<Hand> onePairList = new ArrayList<>();
        ArrayList<Hand> twoPairList = new ArrayList<>();
        ArrayList<Hand> threeOKList = new ArrayList<>();
        ArrayList<Hand> fullHouseList = new ArrayList<>();
        ArrayList<Hand> fourOkList = new ArrayList<>();
        ArrayList<Hand> fiveOKList = new ArrayList<>();
        ArrayList<Hand> finalList = new ArrayList<>();


        try{
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()){

                String inputLine = sc.nextLine();
                lineArray = inputLine.split(" ");
                handAndBid.put(lineArray[0], Integer.parseInt(lineArray[1]));
                if(handType(lineArray[0])==0){
                    highCardList.add(new Hand(lineArray[0], Integer.parseInt(lineArray[1])));
                }else if(handType(lineArray[0])==1) {
                    onePairList.add(new Hand(lineArray[0], Integer.parseInt(lineArray[1])));
                }else if(handType(lineArray[0])==2) {
                    twoPairList.add(new Hand(lineArray[0], Integer.parseInt(lineArray[1])));
                }else if(handType(lineArray[0])==3) {
                    threeOKList.add(new Hand(lineArray[0], Integer.parseInt(lineArray[1])));
                }else if(handType(lineArray[0])==4) {
                    fullHouseList.add(new Hand(lineArray[0], Integer.parseInt(lineArray[1])));
                }else if(handType(lineArray[0])==5) {
                    fourOkList.add(new Hand(lineArray[0], Integer.parseInt(lineArray[1])));
                }else {
                    fiveOKList.add(new Hand(lineArray[0], Integer.parseInt(lineArray[1])));
                }
            }

        }catch (FileNotFoundException e){
            System.out.println("file not found");
        }
        int rank = 1;
        highCardList.sort(new Hand.Compare());
        for(int i =0; i < highCardList.size(); i++){
            highCardList.get(i).setRank(rank);
            rank++;
            finalList.add(highCardList.get(i));
        }
        onePairList.sort(new Hand.Compare());
        for(int i =0; i < onePairList.size(); i++){
            onePairList.get(i).setRank(rank);
            rank++;
            finalList.add(onePairList.get(i));
        }
        twoPairList.sort(new Hand.Compare());
        for(int i =0; i < twoPairList.size(); i++){
            twoPairList.get(i).setRank(rank);
            rank++;
            finalList.add(twoPairList.get(i));
        }
        threeOKList.sort(new Hand.Compare());
        for(int i =0; i < threeOKList.size(); i++){
            threeOKList.get(i).setRank(rank);
            rank++;
            finalList.add(threeOKList.get(i));
        }
        fullHouseList.sort(new Hand.Compare());
        for(int i =0; i < fullHouseList.size(); i++){
            fullHouseList.get(i).setRank(rank);
            rank++;
            finalList.add(fullHouseList.get(i));
        }
        fourOkList.sort(new Hand.Compare());
        for(int i =0; i < fourOkList.size(); i++){
            fourOkList.get(i).setRank(rank);
            rank++;
            finalList.add(fourOkList.get(i));
        }
        fiveOKList.sort(new Hand.Compare());
        for(int i =0; i < fiveOKList.size(); i++){
            fiveOKList.get(i).setRank(rank);
            rank++;
            finalList.add(fiveOKList.get(i));
        }
        long total = 0;
        for(Hand hand : finalList){
            total += (long) hand.getBid() *hand.getRank();
            System.out.println(hand.getHand() + " " + hand.getRank());
        }

        System.out.println(total);


    }
    //high card = 0; 1pair = 1; 2pair = 2; 3ofakind = 3; fullhouse = 4; 4ofakind = 5; fiveofakind = 6
    private static int handType (String hand){

        int type = 0;
        int[] counter = new int[13];
        for (int i = 0; i < hand.length(); i++){
            switch (hand.charAt(i)){
                case '2': {
                    counter[0]++;
                    break;
                }
                case '3':{
                    counter[1]++;
                    break;
                }
                case '4':{
                    counter[2]++;
                    break;
                }
                case '5':{
                    counter[3]++;
                    break;
                }
                case '6':{
                    counter[4]++;
                    break;
                }
                case '7':{
                    counter[5]++;
                    break;
                }
                case '8':{
                    counter[6]++;
                    break;
                }
                case '9':{
                    counter[7]++;
                    break;
                }
                case 'T':{
                    counter[8]++;
                    break;
                }
                case 'J':{
                    counter[9]++;
                    break;
                }
                case 'Q':{
                    counter[10]++;
                    break;
                }
                case 'K':{
                    counter[11]++;
                    break;
                }
                case 'A':{
                    counter[12]++;
                    break;
                }
            }

        }
        List<Integer> counterList = new ArrayList<>();
        for(int i = 0; i < counter.length; i++){
            counterList.add(counter[i]);
        }
        if(counterList.contains(5)){
            type = 6;
        }else if(counterList.contains(4)){
            type = 5;
        }else if(counterList.contains(3)){
            if(counterList.contains(2)){
                type = 4;
            }else{
                type = 3;
            }
        }else if(Collections.frequency(counterList, 2) == 2){
            type = 2;
        }else if(Collections.frequency(counterList, 2) == 1){
            type = 1;
        }
        return type;
    }

}
