import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] buttons;
    private JLabel turnLabel;
    private int[][] board;
    private boolean xTurn;

    public static void main(String[] args) {
        new TicTacToe();
    }

    public TicTacToe() {
        setTitle("Tic Tac Toe");

        buttons = new JButton[3][3];
        board = new int[3][3];
        xTurn = true;

        setLayout(new GridLayout(4, 3));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col] = new JButton("");
                buttons[row][col].setFont(new Font("Arial", Font.PLAIN, 50));
                buttons[row][col].addActionListener(this);
                add(buttons[row][col]);
            }
        }

        turnLabel = new JLabel("Player 1's Turn");
        turnLabel.setFont(new Font("Arial", Font.BOLD, 20));
        turnLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(turnLabel);

        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(e -> resetGame());
        add(newGameButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();
        int row = -1, col = -1;

        // Find the clicked button's position
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (clickedButton == buttons[i][j]) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }

        // Check if the cell is empty and the game is not over
        if (board[row][col] == 0 && !isGameOver()) {
            // Update board and display X or O
            board[row][col] = xTurn ? 1 : 2;
            clickedButton.setText(xTurn ? "X" : "O");
            xTurn = !xTurn;

            // Update turn label
            turnLabel.setText(xTurn ? "Player 1's Turn" : "Player 2's Turn");

            // Check for winner
            if (isGameOver()) {
                String winner = xTurn ? "Player 2 (O)" : "Player 1 (X)";
                turnLabel.setText("Winner: " + winner);
                disableAllButtons();
            }
        }
    }

    private boolean isGameOver() {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][0] == board[i][2]) {
                return true; // Row win
            }
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true; // Column win
            }
        }
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[0][0] == board[2][2]) {
            return true; // Diagonal win
        }
        if (board[0][2] != 0 && board[0][2] == board[1][1] && board[0][2] == board[2][0]) {
            return true; // Diagonal win
        }

        // Check for draw
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) {
                    return false; // Game still in progress
                }
            }
        }
        return true; // Draw
    }

    private void resetGame() {
        // Clear board and reset buttons
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 0;
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }

        // Reset turn
        xTurn = true;
        turnLabel.setText("Player 1's Turn");
    }

    private void disableAllButtons() {
        // Disable all buttons after the game ends
        for (JButton[] buttonRow : buttons) {
            for (JButton button : buttonRow) {
                button.setEnabled(false);
            }
        }
    }
}
