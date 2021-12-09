import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Advent7 {

    public static void main(String[] args) {
        List<Integer> deeps = Arrays.asList(100,10918,257,1507,348);
        System.out.println(calculateLeastDeep(deeps));
    }

    private static int calculateLeastDeep(List<Integer> deeps) {
        List<Integer> calculatedFuels = new ArrayList<>();
        int currentDeep = Collections.min(deeps);

        while (currentDeep <= Collections.max(deeps)) {
            int fuel = 0;
            for (Integer deep: deeps) {
                fuel += IntStream.range(0, Math.abs(deep - currentDeep)).map(i -> i + 1).sum();
            }
            calculatedFuels.add(fuel);
            currentDeep++;
        }
        return Collections.min(calculatedFuels);
    }

}
