Graphical User Interface (GUI):

The game utilizes a graphical interface using Java's Swing framework, providing a windowed environment for playing Tic Tac Toe.
The game window consists of a 3x3 grid of buttons representing the Tic Tac Toe board, a label indicating whose turn it is, and a "New Game" button to start a new game.
Game Logic:

The game maintains an internal representation of the Tic Tac Toe board using a 2D array (board) where each cell can be empty (0), occupied by player X (1), or occupied by player O (2).
The xTurn boolean variable keeps track of whose turn it is (true for player X, false for player O).
Players take turns clicking on the buttons to make their moves. When a button is clicked, the corresponding cell on the board is updated with the player's symbol (X or O).
The game checks for a winner or a draw after each move to determine if the game is over.
If a player wins or the game ends in a draw, the appropriate message is displayed, and all buttons are disabled to prevent further moves.
Event Handling:

The game utilizes action listeners to handle button clicks. When a button is clicked, the actionPerformed method is invoked, updating the game state accordingly.
The "New Game" button allows players to start a new game by resetting the board and enabling all buttons.
Game State Management:

The isGameOver method checks the current state of the board to determine if the game has ended due to a win or a draw.
The resetGame method resets the game state, clearing the board and enabling all buttons for a new game.
Improvements:

The code has been modernized by using Swing components (JFrame, JButton, JLabel) instead of AWT components (Frame, Button, Label).
The label indicating whose turn it is has been centered horizontally for better appearance.
Buttons are disabled after the game ends to prevent further moves.
Overall, this code provides a functional implementation of Tic Tac Toe with a user-friendly graphical interface. Players can enjoy the classic game while the program handles game logic and interface interaction.
