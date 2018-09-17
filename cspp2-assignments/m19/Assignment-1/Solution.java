import java.util.Scanner;
import java.util.*;

/**
 * Solution class for code-eval.
 */
public final class Solution {
	/**
	* Constructs the object.
	*/
	static int count = 0, size = 0, size1 = 0;
	static String[] str = new String[10];
	static Quiz[] quiz1;
	private Solution() {
		// leave this blank
		quiz1 = new Quiz[10];
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// instantiate this Quiz
		Quiz q = new Quiz();
		// code to read the test cases input file
		Scanner s = new Scanner(System.in);
		// check if there is one more line to process
		while (s.hasNext()) {
			// read the line
			String line = s.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "LOAD_QUESTIONS":
				System.out.println("|----------------|");
				System.out.println("| Load Questions |");
				System.out.println("|----------------|");
				loadQuestions(s, q, Integer.parseInt(tokens[1]));
				break;
			case "START_QUIZ":
				System.out.println("|------------|");
				System.out.println("| Start Quiz |");
				System.out.println("|------------|");
				startQuiz(s, q, Integer.parseInt(tokens[1]));
				break;
			case "SCORE_REPORT":
				System.out.println("|--------------|");
				System.out.println("| Score Report |");
				System.out.println("|--------------|");
				displayScore(q);
				break;
			default:
				break;
			}
		}
	}
	/**
	 * Loads questions.
	 *
	 * @param      s              The scanner object for user input
	 * @param      quiz           The quiz object
	 * @param      questionCount  The question count
	 */
	public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		if (questionCount == 0) {
			System.out.println("Quiz does not have questions");
			return;
		} else {
			for (int i = 0; i < questionCount; i++) {
				String questions = s.nextLine();
				String[] items = questions.split(":");
				if (items.length < 5) {
					System.out.println("Error! Malformed question");
					return;
				}
				else if (items[1].split(",").length < 4 && Integer.parseInt(items[3]) > 0 && Integer.parseInt(items[4]) < 0) {
					System.out.println("trick question  does not have enough answer choices");
					return;
				}
				else if (Integer.parseInt(items[2]) > 4) {
					System.out.println("Error! Correct answer choice number is out of range for question text 1");
					return;
				}
				else if (Integer.parseInt(items[3]) < 0) {
					System.out.println("Invalid max marks for question about sony");
					return;
				}
				else if (Integer.parseInt(items[4]) > 0) {
					System.out.println("Invalid penalty for question about sony");
					return;
				}
				else if (items[0].length() == 0) {
					System.out.println("Error! Malformed question");
					return;
				}
				quiz.add(new Quiz(items[0], items[1].split(","), items[2], Integer.parseInt(items[3]), Integer.parseInt(items[4])));
				size1++;
			}
			System.out.println(questionCount + " are added to the quiz");
		}
	}


	/**
	 * Starts a quiz.
	 *
	 * @param      s            The scanner object for user input
	 * @param      quiz         The quiz object
	 * @param      answerCount  The answer count
	 */
	public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
		// write your code here to display the quiz questions
		// read the user responses from the console
		// store the user respones in the quiz object
		if (size1 == 0) {
			return;
		}
		quiz.print(answerCount);
		for (int i = 0; i < answerCount; i++) {
			str[i] = s.nextLine();
			size++;
		}

	}

	/**
	 * Displays the score report
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report
		if (size1 == 0) {
			return;
		}
		count = 0;
		for (int i = 0; i < size; i++) {
			String ans = quiz.answers[i];
			System.out.println(quiz.questions[i]);
			if (ans.equals(str[i].substring(7))) {
				System.out.println(" Correct Answer! - Marks Awarded: " + quiz.marks[i]);
				count += quiz.marks[i];
			} else {
				System.out.println(" Wrong Answer! - Penalty: " + quiz.penalitys[i]);
				count += quiz.penalitys[i];
			}
		}
		System.out.print("Total Score: " + count);
	}
}
