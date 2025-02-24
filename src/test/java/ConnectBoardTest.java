package remer.connect4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectBoardTest
{
    @Test
    public void insert()
    {
        ConnectBoard board = new ConnectBoard(7, 6);
        board.insert(3, 'X');

        assertEquals('X', board.toString().split("\n")[5].charAt(3));
    }

    @Test
    public void calculateWinner()
    {
        ConnectBoard board = new ConnectBoard(7, 6);
        board.insert(0, 'X');
        board.insert(1, 'X');
        board.insert(2, 'X');
        board.insert(3, 'X');

        assertEquals(Character.valueOf('X'), board.calculateWinner());
    }

    @Test
    public void isFull()
    {
        ConnectBoard board = new ConnectBoard(7, 6);
        for (int i = 0; i < 6; i++)
        {
            board.insert(3, 'O');
        }

        assertTrue(board.isFull(3));
        assertFalse(board.isFull(2));
    }
}