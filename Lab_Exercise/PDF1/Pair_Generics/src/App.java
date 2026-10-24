import ex6_1.*;

public class App {
    public static void main(String[] args) throws Exception {
        Pair<String> match = Pair.of("Juventus", "Torino"); // home team, away team
        Pair<Integer> result = new Pair<>(2, 1); // home goals, away goals
        String away = match.second(); // no cast
        int homeGoals = result.first(); // auto-unboxing
        IO.println(match + " " + away + " " + homeGoals + " " + match.swapped() + " "
        + match.contains("Juventus") + " " + result.contains(3));
        result.set1st(3); // the referee's report: 3-1
        IO.println(result + " " + (result.first() + result.second()));
        Couple<String, Integer> entry = new Couple<>("Juventus", 42);
        Couple<Integer, String> byPoints = entry.swap();
        Couple<String, Double> average = entry.withSecond(2.5);
        IO.println(entry + " " + byPoints + " " + average + " "
        + entry.equals(new Couple<>("Juventus", 42)));
        IO.println(Scores.best(new String[]{"Milan", "Inter", "Roma"}, new int[]{7, 9, 9}) + " "
        + Scores.minMax(5, -2, 8, 3));
    }
}
