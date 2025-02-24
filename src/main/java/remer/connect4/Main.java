package remer.connect4;

public class Main
{
    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        ConnectBoard board = new ConnectBoard(7, 6);
        System.out.println(board);

        // Test inserting pieces
        board.insert(0, 'X');
        board.insert(0, 'O');
        board.insert(1, 'X');
        board.insert(1, 'O');
        board.insert(2, 'X');
        board.insert(2, 'X');
        board.insert(3, 'X'); // This should create a horizontal win for 'X'
        System.out.println(board);

        // Test CalculateWinner
        Character winner = board.calculateWinner();
        System.out.println("Winner: " + (winner != null ? winner : "None"));

        // Test IsFull
        System.out.println("Is column 0 full? " + board.isFull(0));
        System.out.println("Is column 3 full? " + board.isFull(3));
    }
}

