package remer.connect4;

public class Main
{
    // Main method to demonstrate the functionality
    public static void main(String[] args) {
        ConnectBoard board = new ConnectBoard(7, 6);
        System.out.println(board);

        // Test inserting pieces
        board.Insert(0, 'X');
        board.Insert(0, 'O');
        board.Insert(1, 'X');
        board.Insert(1, 'O');
        board.Insert(2, 'X');
        board.Insert(2, 'X');
        board.Insert(3, 'X'); // This should create a horizontal win for 'X'
        System.out.println(board);

        // Test CalculateWinner
        Character winner = board.CalculateWinner();
        System.out.println("Winner: " + (winner != null ? winner : "None"));

        // Test IsFull
        System.out.println("Is column 0 full? " + board.IsFull(0));
        System.out.println("Is column 3 full? " + board.IsFull(3));
    }
}

