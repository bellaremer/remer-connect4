import org.junit.jupiter.api.Test;
import remer.connect4.ConnectBoard;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectBoardTest
{
    @Test
    public void Insert()
    {
        ConnectBoard board = new ConnectBoard(7, 6);
        board.Insert(3, 'X');

        assertEquals('X', board.toString().split("\n")[5].charAt(3));
    }

    @Test
    public void CalculateWinner()
    {
        ConnectBoard board = new ConnectBoard(7, 6);
        board.Insert(0, 'X');
        board.Insert(1, 'X');
        board.Insert(2, 'X');
        board.Insert(3, 'X');

        assertEquals(Character.valueOf('X'), board.CalculateWinner());
    }

    @Test
    public void IsFull()
    {
        ConnectBoard board = new ConnectBoard(7, 6);
        for (int i = 0; i < 6; i++)
        {
            board.Insert(3, 'O');
        }

        assertTrue(board.IsFull(3));
        assertFalse(board.IsFull(2));
    }
}