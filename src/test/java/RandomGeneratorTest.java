import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomGeneratorTest {

    @Test
    public void testGetRandomValue() {
        Map<Integer, Integer> map = new HashMap<>();

        int number = 1_000;
        for (int i = 0; i < number; i++) {
            int item = getRandomValue(0, 2);
            if (map.containsKey(item)) {
                int value = map.get(item);
                value++;
                map.replace(item, value);
            } else {
                map.put(item, 1);
            }
        }

        System.out.println(map);
    }

    private Integer getRandomValue(int min, int max) {
        final Random random = new Random();
        return min + random.nextInt(max - min);
    }
}
