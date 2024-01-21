package ru.comavp.table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicTacToeTable {

    final private String[] list;
    private Integer emptyIndexesCnt = 9;

    public TicTacToeTable() {
        list = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    }

    public TicTacToeTable(String[] list) {
        this.list = list;
    }

    public void addSymbol(int ind, String symbol) {
        list[ind - 1] = symbol;
        emptyIndexesCnt--;
    }

    public void printTable() {
        //clearScreen();
        for (int i = 0; i < list.length; i += 3) {
            System.out.println(list[i] + "|" + list[i + 1] + "|" + list[i + 2]);
        }
        System.out.println("------");
    }

    public boolean isGameOver() {
        for (int i = 0; i < list.length; i += 3) {
            if (compareThreeSymbols(list[i], list[i + 1], list[i + 2])) return true;
        }
        for (int i = 0; i < 3; i++) {
            if (compareThreeSymbols(list[i], list[i + 3], list[i + 6])) return true;
        }

        if (compareThreeSymbols(list[0], list[4], list[8]) || compareThreeSymbols(list[2], list[4], list[6]))
            return true;

        return false;
    }

    public boolean isDraw() {
        return emptyIndexesCnt <= 0;
    }

    public List<Integer> getEmptyIndexes() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (!list[i].equals("0") && !list[i].equals("X")) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public void refresh() {
        for (int i = 0; i < list.length; i++) {
            list[i] = String.valueOf(i + 1);
        }
        emptyIndexesCnt = list.length;
    }

    private boolean compareThreeSymbols(String f, String s, String t) {
        return f.equals(s) && s.equals(t);
    }

    private void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
