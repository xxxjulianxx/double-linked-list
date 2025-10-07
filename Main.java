import java.util.*;

// ----------------- Node of the doubly linked list -----------------
class PlayerNode {
    String name;
    int score;
    PlayerNode prev;
    PlayerNode next;

    public PlayerNode(String name, int score) {
        this.name = name;
        this.score = score;
        this.prev = null;
        this.next = null;
    }
}

// ----------------- Doubly Linked List -----------------
class DoublyLinkedList {
    private PlayerNode head;
    private PlayerNode tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertOrdered(String name, int score) {
        PlayerNode newNode = new PlayerNode(name, score);

        if (head == null) {
            head = tail = newNode;
        } else {
            PlayerNode current = head;
            while (current != null && current.score >= score) {
                current = current.next;
            }
            if (current == head) {
                // Insert at the beginning
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else if (current == null) {
                // Insert at the end
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                // Insert in the middle
                PlayerNode previous = current.prev;
                previous.next = newNode;
                newNode.prev = previous;
                newNode.next = current;
                current.prev = newNode;
            }
        }
        size++;

        // Keep only top 5 players
        if (size > 5) {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public void showRanking() {
        System.out.println("\n===== TOP 5 PLAYERS =====");
        PlayerNode current = head;
        int pos = 1;
        while (current != null && pos <= 5) {
            System.out.println(pos + ". " + current.name + " -> " + current.score + " points");
            current = current.next;
            pos++;
        }
        System.out.println("===========================");
    }
}

// ----------------- Fast Sums Game -----------------
class FastSumsGame {
    private DoublyLinkedList ranking;
    private Scanner input;
    private Random random;

    public FastSumsGame() {
        ranking = new DoublyLinkedList();
        input = new Scanner(System.in);
        random = new Random();
    }

    public void play() {
        while (true) {
            System.out.print("Enter your username: ");
            String playerName = input.nextLine();
            int score = 0;
            int timeLimit = 10;
            int level = 1;

            boolean playing = true;

            while (playing) {
                int correctAnswers = 0;

                for (int i = 0; i < 5; i++) {
                    int num1 = random.nextInt(50) + 1;
                    int num2 = random.nextInt(50) + 1;
                    int correctAnswer = num1 + num2;

                    System.out.println("\nLevel " + level + " | Time: " + timeLimit + "s");
                    System.out.print("What is " + num1 + " + " + num2 + "? ");

                    long start = System.currentTimeMillis();
                    String userInput = input.nextLine();
                    long end = System.currentTimeMillis();

                    long responseTime = (end - start) / 1000;

                    // Check time
                    if (responseTime > timeLimit) {
                        System.out.println("⏱ Time is up!");
                        playing = false;
                        break;
                    }

                    // Check if valid number
                    int playerAnswer;
                    try {
                        playerAnswer = Integer.parseInt(userInput);
                    } catch (Exception e) {
                        System.out.println("⚠ Invalid input!");
                        playing = false;
                        break;
                    }

                    // Check if correct
                    if (playerAnswer != correctAnswer) {
                        System.out.println("❌ Wrong! The correct answer was: " + correctAnswer);
                        playing = false;
                        break;
                    }

                    System.out.println("✅ Correct!");
                    score += 100;
                    correctAnswers++;
                }

                // If completed level
                if (correctAnswers == 5) {
                    level++;
                    timeLimit = Math.max(2, timeLimit - 2);
                    System.out.println("\n🎉 You advance to level " + level + "! New time: " + timeLimit + "s");
                }
            }

            // End of game
            System.out.println("\nGame over, " + playerName + "! Your final score is: " + score);
            ranking.insertOrdered(playerName, score);
            ranking.showRanking();

            System.out.print("\nDo you want to play again? (y/n): ");
            String option = input.nextLine();
            if (!option.equalsIgnoreCase("y")) {
                System.out.println("👋 Thanks for playing. Goodbye!");
                break;
            }
        }
    }
}

// ----------------- Main Class -----------------
public class Main {
    public static void main(String[] args) {
        FastSumsGame game = new FastSumsGame();
        game.play();
    }
}
