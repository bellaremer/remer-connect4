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

        // Fill the board with empty spots represented by ' '
        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                board[i][j] = ' ';
            }
        }
    }

    // Inserts one chip of the specified color into the specified column
    public void Insert(int column, char color)
    {
        // Check if the column is valid (if the player is within the amount of columns)
        if(column < 0 || column >= width)
        {
            System.out.println("Invalid column, try again");
            return;
        }

        if(IsFull(column))
        {
            System.out.println("Column is already full, try again");
            return;
        }

        for(int row = height - 1; row >= 0; row--)
        {
            if(board[row][column] == ' ')
            {
                board[row][column] = color;
                return;
            }
        }
    }

    // Returns the color of the winning player if there is one
    // Loops through the board to find if anyone has won the game
    public Character CalculateWinner()
    {
        // Check for horizontal, vertical, or diagonal win
        for(int r = 0; r < height; r++)
        {
            for(int c = 0; c < width; c++)
            {
                char color = board[r][c];
                if(color != ' ' && (checkDirection(r, c, 1, 0) ||     // Checking horizontal
                        checkDirection(r, c, 0, 1) ||      // Checking vertical
                        checkDirection(r, c, 1, 1) ||      // Checking diagonal (bottom-right)
                        checkDirection(r, c, 1, -1)))      // Checking diagonal (bottom-left)
                {
                    return color;
                }
            }
        }
        return null;
    }

    // Method to help with checking the direction for a win
    private boolean checkDirection(int row, int col, int deltaRow, int deltaCol)
    {
        char color = board[row][col]; // Get the color at the starting position
        for(int i = 1; i < 4; i++)
        {
            int newRow = row + i * deltaRow; // Calculate new row index
            int newCol = col + i * deltaCol; // Calculate new column index
            if(newRow < 0 || newRow >= height || newCol < 0 || newCol >= width || board[newRow][newCol] != color)
            {
                return false; // Return false if any condition fails
            }
        }
        return true;
    }

    // Returns true if the specified column is completely full, false otherwise
    public boolean IsFull(int column)
    {
        if(column < 0 || column >= width)
        {
            return false;
        }
        return board[0][column] != ' ';
    }

    // Returns a string that is a visual representation of the board
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString(); // Return the final string representation of the board
    }
}