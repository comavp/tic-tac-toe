package ru.comavp.game;

import ru.comavp.table.TicTacToeTable;
import ru.comavp.players.Player;
import ru.comavp.players.RandomStrategyPlayer;

import java.util.Scanner;

public class GameRunner extends Game {

    private boolean gameRunning = true;
    private boolean userMove = true;
    private boolean gameFinished = false;

    private Scanner scanner = new Scanner(System.in);
    private TicTacToeTable table;
    private Player player;

    public GameRunner() {
        this.table = new TicTacToeTable();
        this.player = new RandomStrategyPlayer();
    }

    public GameRunner(TicTacToeTable table, Player player) {
        this.table = table;
        this.player = player;
    }

    @Override
    public void run() {
        while (!gameFinished) {
            while (gameRunning) {
                if (userMove) {
                    makeUserMove();
                } else {
                    makeComputerMove();
                }

                checkDraw(); // todo fix bug with draw after winning
                checkWinning();
                userMove = !userMove;
            }

            checkFinishing();
        }
    }

    private void makeUserMove() {
        table.printTable();
        System.out.println("Ваш ход, введите номер поля (от 1 до 9)");

        String number = scanner.next();
        table.addSymbol(Integer.parseInt(number), "X");
    }

    private void makeComputerMove() {
        Integer computerMove = player.makeMove(table.getEmptyIndexes());
        table.addSymbol(computerMove, "0");
    }

    private void checkDraw() {
        if (table.isDraw()) {
            table.printTable();
            System.out.println("Ничья!");
            gameRunning = false;
        }
    }

    private void checkWinning() {
        if (gameRunning && table.isGameOver()) {
            table.printTable();
            if (userMove) System.out.println("Вы выиграли!");
            else System.out.println("Вы проиграли!");
            gameRunning = false;
        }
    }

    private void checkFinishing() {
        System.out.println("Нажмите 0, чтобы продолжить игру");
        String value = scanner.next();
        if (value.equals("0")) {
            userMove = true;
            gameRunning = true;
            table.refresh();
        } else {
            gameFinished = true;
            scanner.close();
        }
    }
}
