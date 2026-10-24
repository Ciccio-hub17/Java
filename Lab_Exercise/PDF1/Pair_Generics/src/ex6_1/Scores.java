package ex6_1;

public class Scores {


    private Scores (){ }

    public static Couple<String, Integer> best (String[] names, int[] scores){
        if (names.length != scores.length || names == null || scores == null){
            throw new IllegalArgumentException ("Not valid arrays\n");
        }

        int max = scores[0], maxIndex = 0;

        for (int i = 1; i < scores.length; i++){
            if (scores[i] > max){
                maxIndex = i;
                max = scores[i];
            }
        }

        return new Couple<> (names[maxIndex], scores[maxIndex]);
    }

    public static Pair<Integer> minMax (int... values){
        if (values.length == 0){
            throw new IllegalArgumentException("Not enough values\n");
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < values.length; i++){
            if (values[i] > max){
                max = values[i];
            }
            if (values[i] < min){
                min = values[i];
            }
        }

        return new Pair<> (min, max);
    }
}
