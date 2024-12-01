import java.util.Comparator;
import java.util.Map;

import static java.util.Map.entry;

public class Hand {
    public String hand;
    public int valueOfFirstChar;
    public int valueOfSecondChar;
    public int valueOfThirdChar;
    public int valueOfFourthChar;
    public int valueOfFifthChar;
    public int bid;
    public int rank;

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    Map<String, Integer> valuesOfChars = Map.ofEntries(
            entry("2", 2),
            entry("3", 3),
            entry("4", 4),
            entry("5", 5),
            entry("6", 6),
            entry("7", 7),
            entry("8", 8),
            entry("9", 9),
            entry("T", 10),
            entry("J", 1),
            entry("Q", 12),
            entry("K", 13),
            entry("A", 14)
    );

    public Hand(String hand, int bid) {
        this.hand = hand;
        this.bid = bid;
        valueOfFirstChar = valuesOfChars.get(String.valueOf(hand.charAt(0)));
        valueOfSecondChar = valuesOfChars.get(String.valueOf(hand.charAt(1)));
        valueOfThirdChar = valuesOfChars.get(String.valueOf(hand.charAt(2)));
        valueOfFourthChar = valuesOfChars.get(String.valueOf(hand.charAt(3)));
        valueOfFifthChar = valuesOfChars.get(String.valueOf(hand.charAt(4)));
    }

    public int getValueOfFirstChar() {
        return valueOfFirstChar;
    }

    public int getValueOfSecondChar() {
        return valueOfSecondChar;
    }

    public int getValueOfThirdChar() {
        return valueOfThirdChar;
    }

    public int getValueOfFourthChar() {
        return valueOfFourthChar;
    }

    public int getValueOfFifthChar() {
        return valueOfFifthChar;
    }

    public int getBid() {
        return bid;
    }

    public String getHand() {
        return hand;
    }

    public static class Compare implements Comparator<Hand>{

        @Override
        public int compare(Hand h1, Hand h2){
            int relation = 0;
            if(h1.valueOfFirstChar - h2.valueOfFirstChar>0){
                relation = 1;
            }else if(h1.valueOfFirstChar - h2.valueOfFirstChar<0){
                relation = -1;
            }else {
                if(h1.valueOfSecondChar - h2.valueOfSecondChar>0){
                    relation = 1;
                } else if (h1.valueOfSecondChar - h2.valueOfSecondChar<0) {
                    relation = -1;
                }else {
                    if (h1.valueOfThirdChar - h2.valueOfThirdChar > 0) {
                        relation = 1;
                    } else if (h1.valueOfThirdChar - h2.valueOfThirdChar < 0) {
                        relation = -1;
                    }else{
                        if(h1.valueOfFourthChar - h2.valueOfFourthChar>0){
                            relation = 1;
                        } else if (h1.valueOfFourthChar - h2.valueOfFourthChar<0) {
                            relation = -1;
                        }else{
                            if(h1.valueOfFifthChar - h2.valueOfFifthChar>0){
                                relation = 1;
                            } else if (h1.valueOfFifthChar - h2.valueOfFifthChar<0) {
                                relation = -1;
                            }
                        }
                    }
                }
            }
            return relation;
        }
    }

    @Override
    public String toString() {
        return "Hand{" +
                "hand='" + hand + '\'' +
                ", bid=" + bid +
                '}';
    }
}
