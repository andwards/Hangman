# Hangman Game

This is a simple Hangman game implemented in Java. The game randomly selects a word from a predefined list and allows the player to guess letters to uncover the word. The player has a limited number of guesses to correctly guess the word before losing the game.

## How to Play

1. Run the program.
2. The game will randomly select a word for you to guess.
3. You will be shown the number of guesses remaining and the available letters to choose from.
4. Enter a letter as your guess. The game will validate your input to ensure it is a single letter that you haven't guessed before.
5. If your guess is correct and appears in the word, the game will display the word with the guessed letters filled in.
6. If your guess is incorrect and doesn't appear in the word, the game will decrement the number of guesses remaining.
7. Repeat steps 4-6 until you guess the word correctly or run out of guesses.
8. If you guess the word correctly within the allowed number of guesses, you win the game. Otherwise, you lose.

## Game Mechanics

- The game uses a predefined list of words from which it randomly selects one as the word to guess.
- The player has 6 guesses to uncover the word. The hangman drawing is displayed to represent the number of remaining guesses.
- The game keeps track of the guessed letters to prevent duplicate guesses.
- The word to guess is displayed with blank spaces for the unguessed letters and the correctly guessed letters filled in.
- The game checks if the word has been completely guessed to determine if the player has won.

## Contributors

- [Andrew Edwards](https://github.com/andwards)
