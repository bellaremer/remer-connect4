package remer.connect4;

public class ConnectBoard
{
    private int width;
    private int height;
    private final char[][] board;

    // Constructor to initialize the board with specified width and height
    public ConnectBoard(int width, int height)
    {
        this.width = width;
        this.height = height;
        board = new char[width][height];

        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                board[i][j] = ' ';
            }
        }
    }

    // Inserts one chip of the specified color into the specified column
    public void insert(int column, char color)
    {
        if (column < 0 || column >= width)
        {
            System.out.println("Invalid column, try again");
            return;
        }

        if (isFull(column))
        {
            System.out.println("Column is already full, try again");
            return;
        }

        for (int row = height - 1; row >= 0; row--)
        {
            if (board[column][row] == ' ')
            {
                board[column][row] = color;
                return;
            }
        }
    }

    // Returns the color of the winning player if there is one
    // Check for horizontal, vertical, or diagonal win
    public Character calculateWinner()
    {
        for (int r = 0; r < height; r++)
        {
            for (int c = 0; c < width; c++)
            {
                char color = board[c][r];
                if (color != ' ' && (checkDirection(c, r, 1, 0)
                        || checkDirection(c, r, 0, 1)
                        || checkDirection(c, r, 1, 1)
                        || checkDirection(c, r, 1, -1)))
                {
                    return color;
                }
            }
        }
        return null;
    }

    // Method to help with checking the direction for a win
    private boolean checkDirection(int col, int row, int deltaRow, int deltaCol)
    {
        char color = board[col][row];
        for (int i = 1; i < 4; i++)
        {
            int newRow = row + i * deltaRow;
            int newCol = col + i * deltaCol;
            if (newRow < 0 || newRow >= height || newCol < 0 || newCol >= width || board[newCol][newRow] != color)
            {
                return false;
            }
        }
        return true;
    }

    // Returns true if the specified column is completely full, false otherwise
    public boolean isFull(int column)
    {
        if (column < 0 || column >= width)
        {
            return false;
        }
        return board[column][0] != ' ';
    }

    // Returns a string that is a visual representation of the board
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = height - 1; i >= 0; i--)
        {
            for (int j = 0; j < width; j++)
            {
                sb.append(board[j][i]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}