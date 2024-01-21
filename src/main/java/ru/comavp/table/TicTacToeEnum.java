package ru.comavp.table;

public class TicTacToeEnum {

    TicTacToeEnum NOUGHT = new TicTacToeEnum("0");
    TicTacToeEnum CROSS = new TicTacToeEnum("X");

    private String value;

    public TicTacToeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

//    public static TicTacToeEnum findByValue(String value) {
//
//    }
}
