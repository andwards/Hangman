import java.util.*;

public class Hangman {

    public static void main(String[] args) {

        String wordToGuess = PickAWord();
        ArrayList<String> guessedLetters = new ArrayList<String>();
        int guessesRemaining = 6;

        while (guessesRemaining > 0) {
            System.out.println("You have " + guessesRemaining + " guesses remaining!");
            System.out.println("Available letters: " + GetAvailableLetters(guessedLetters));

            DrawHangman(guessesRemaining);
            DisplayWord(wordToGuess, guessedLetters);
            if (IsWordGuessed(wordToGuess, guessedLetters)) {
                System.out.println("Congratulations, you won!");
                break;
            }

            System.out.println("Please guess a letter: ");
            String guess = null;

            while (true) {
                Scanner kbd = new Scanner(System.in);
                guess = kbd.next().toLowerCase();

                if (guess.length() != 1) {
                    System.out.println("Please enter a single letter.");
                    continue;
                }

                if (guessedLetters.contains(guess)) {
                    System.out.println("You have already guessed that letter.");
                    continue;
                }

                if (!IsLetter(guess)) {
                    System.out.println("Please enter a letter.");
                    continue;
                }

                guessedLetters.add(guess);
                break;
            }

            if (wordToGuess.contains(guess)) {
                System.out.println("Good Guess!");

            }
            else {
                guessesRemaining--;
                System.out.println("Oops! That letter is not in the word!");
                continue;
            }



        }
    }

    private static boolean IsLetter(String guess) {
        return guess.length() == 1 && Character.isLetter(guess.charAt(0));
    }

    private static void DisplayWord(String wordToGuess, ArrayList<String> guessedLetters) {
        Queue<String> aQueue = new LinkedList<>();
        ArrayList<String> wordToDisplay = new ArrayList<String>();

        for (int i = 0; i < wordToGuess.length(); i++) {
            aQueue.add(wordToGuess.substring(i, i+1));
        }

        int index = 0;
        while (!aQueue.isEmpty()) {
            String guessed = aQueue.remove();
            if (guessedLetters.contains(guessed)) {
                wordToDisplay.add(guessed);
            } else {
                wordToDisplay.add("_");
            }
            index++;
        }

        System.out.print("The word is : ");

        for (String letter : wordToDisplay) {
            System.out.print(letter);
        }
        System.out.println();
    }

    private static boolean IsWordGuessed(String wordToGuess, ArrayList<String> guessedLetters) {
        Queue<String> aQueue = new LinkedList<>();
        for (int i = 0; i < wordToGuess.length(); i++) {
            aQueue.add(wordToGuess.substring(i, i+1));
        }
        while (!aQueue.isEmpty()) {
            String guessed = aQueue.remove();
            if (guessedLetters.contains(guessed)) {
                continue;
            } else {
                return false;
            }

        }
        return true;
    }

    private static String GetAvailableLetters(ArrayList<String> guessedLetters) {

        String availableLetters = "abcdefghijklmnopqrstuvwxyz";

        for (String letter : guessedLetters) {
            availableLetters = availableLetters.replace(letter, "");
        }
        return availableLetters;
    }

    private static void DrawHangman(int guessesRemaining) {
        switch (guessesRemaining) {
            case 6:
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 5:
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      o");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 4:
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      o");
                System.out.println("  |      |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 3:
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      o");
                System.out.println("  |     /|");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 2:
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      o");
                System.out.println("  |     /|\\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 1:
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      o");
                System.out.println("  |     /|\\");
                System.out.println("  |     / ");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
            case 0:
                System.out.println("  ________");
                System.out.println("  |      |");
                System.out.println("  |      o");
                System.out.println("  |     /|\\");
                System.out.println("  |     / \\");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("  |");
                System.out.println("__|__");
                break;
        }

    }

    private static String PickAWord() {
        String[] possibleWords = new String[]{
                "rainbow",
                "xenon",
                "pikachu",
                "marshmallow",
                "candy",
                "chocolate",
                "icecream",
                "sugar",
                "cotton candy",
                "cotton",
                "candy cane",
                "horse",
                "unicorn",
                "zebra",
                "rhinoceros",
                "giraffe",
                "elephant",
                "lion",
                "house",
                "apartment",
                "palace",
                "hotel",
                "motel",
                "cabin",
                "inn",
                "orange",
                "red",
                "white",
                "green",
                "blue",
                "purple",
                "black",
                "brown"
        };

        Random random = new Random();
        int randomIndex = random.nextInt(possibleWords.length);
        return possibleWords[randomIndex];

    }
}
