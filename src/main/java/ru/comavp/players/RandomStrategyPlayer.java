package ru.comavp.players;

import java.util.List;
import java.util.Random;

public class RandomStrategyPlayer extends Player {

    @Override
    public Integer makeMove(List<Integer> emptyIndexes) {
        Integer item = getRandomValue(1, 10);
        while (!emptyIndexes.contains(item))  {
            item = getRandomValue(1, 10);
        }
        return item;
    }

    // max - не включительно
    private Integer getRandomValue(int min, int max) {
        return min + new Random().nextInt(max - min);
    }
}
