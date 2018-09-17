import java.util.Scanner;
/**
 * Class for question.
 */
class Question {
	/**
	 * { var_description }.
	 */
	private String questiontext;
	/**
	 * { var_description }.
	 */
	private String[] choices;
	/**
	 * { var_description }.
	 */
	private int correctAnswer;
	/**
	 * { var_description }.
	 */
	private int maxMarks;
	/**
	 * { var_description }.
	 */
	private int penalty;
	/**
	 * { var_description }.
	 */
	private String response;
	/**
	 * Constructs the object.
	 */
	Question() {
		choices = new String[10];
	}
	/**
	 * Constructs the object.
	 *
	 * @param      question1       The question 1
	 * @param      choices1        The choices 1
	 * @param      correctAnswer1  The correct answer 1
	 * @param      maxMarks1       The maximum marks 1
	 * @param      penalty1        The penalty 1
	 */
	Question(final String question1, final String[] choices1,
	         final int correctAnswer1, final int maxMarks1, final int penalty1) {
		this.questiontext = question1;
		this.choices = choices1;
		this.correctAnswer = correctAnswer1;
		this.maxMarks = maxMarks1;
		this.penalty = penalty1;
	}
	Question(final String response1) {
		this.response = response1;
	}
	/**
	 * { function_description }.
	 *
	 * @param      choice  The choice
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean evaluateResponse(final String choice) {
		return getCorrectAnswer().equals(choice);
	}
	/**
	 * Gets the correct answer.
	 *
	 * @return     The correct answer.
	 */
	public String getCorrectAnswer() {
		return Integer.toString(this.correctAnswer);
	}
	/**
	 * Gets the question text.
	 *
	 * @return     The question text.
	 */
	public String getQuestionText() {
		return this.questiontext;
	}
	/**
	 * Gets the choice.
	 *
	 * @return     The choice.
	 */
	public String[] getChoice() {
		return this.choices;
	}
	/**
	 * Gets the maximum marks.
	 *
	 * @return     The maximum marks.
	 */
	public int getMaxMarks() {
		return this.maxMarks;
	}
	/**
	 * Gets the penalty.
	 *
	 * @return     The penalty.
	 */
	public int getPenalty() {
		return this.penalty;
	}
	/**
	 * Sets the response.
	 *
	 * @param      answer  The answer
	 */
	public void setResponse(final String answer) {
		// this.response = answer.subString(4);
	}
	/**
	 * Gets the response.
	 *
	 * @return     The response.
	 */
	public String getResponse() {
		return this.response;
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String s = "";
		s += getQuestionText() + "(" + getMaxMarks() + ")" + "\n";
		for (int i = 0; i < getChoice().length - 1; i++) {
			s += choices[i] + "\t";
		}
		return s + choices[getChoice().length - 1] + "\n";
	}
}
/**
 * Class for quiz.
 */
class Quiz {
	/**
	 * { var_description }.
	 */
	private final int onehundred = 100;
	/**
	 * { var_description }.
	 */
	private Question[] questions;
	/**
	 * { var_description }.
	 */
	private int size;
	/**
	 * Constructs the object.
	 */
	Quiz() {
		questions = new Question[10];
		size = 0;
	}
	/**
	 * Adds a question.
	 *
	 * @param      q     The question
	 */
	public void addQuestion(final Question q) {
		questions[size++] = q;
	}
	/**
	 * Gets the question.
	 *
	 * @param      index  The index
	 *
	 * @return     The question.
	 */
	public Question getQuestion(final int index) {
		return questions[index];
	}
	/**
	 * Shows the report.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public String showReport() {
		String s = "";
		// int count = 0;
		// for (int i = 0; i < size; i++) {
		// 	Question q = getQuestion(i);
		// 	// String ans = q.getCorrectAnswer();
		// 	s += q.getQuestionText()+"\n";
		// 	// System.out.println(quiz.questions[i]);

		// 	String sub = str[i].substring(7);
		// 	if (sub.equals("a")) {
		// 		sub = "1";
		// 	} else if (sub.equals("b")) {
		// 		sub = "2";
		// 	} else if (sub.equals("c")) {
		// 		sub = "3";
		// 	} else if (sub.equals("d")) {
		// 		sub = "4";
		// 	}
		// 	if (ans.equals(sub)) {
		// 		System.out.println(" Correct Answer! - Marks Awarded: " + quiz.marks[i]);
		// 		count += quiz.marks[i];
		// 	} else {
		// 		System.out.println(" Wrong Answer! - Penalty: " + quiz.penalitys[i]);
		// 		count += quiz.penalitys[i];
		// 	}
		// }
		// System.out.print("Total Score: " + count);
		return s;
	}
	public void print(int ques) {
		for (int i = 0; i < ques; i++) {
			System.out.println(questions[i].toString());
		}
	}

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
	static int size1 = 0,responeCount =0;
	static String[] str = new String[10];
	/**
	* Constructs the object.
	*/
	private Solution() {
		// leave this blank
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
			try {
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
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	/**
	 * Loads questions.
	 *
	 * @param      scan       The scan
	 * @param      quiz       The quiz
	 * @param      q          The question count
	 *
	 */
	public static void loadQuestions(final Scanner scan,
	                                 final Quiz quiz, final int q)throws Exception {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		if (q == 0) {
			// System.out.println("Quiz does not have questions");
			throw new Exception("Quiz does not have questions");
			// return;
		} else {
			for (int i = 0; i < q; i++) {
				String questions = scan.nextLine();
				String[] items = questions.split(":");
				if (items.length < 5 || items[0].length() == 0) {
					throw new Exception("Error! Malformed question");
				} else if (items[1].split(",").length < 4 && Integer.parseInt(items[3]) > 0 && Integer.parseInt(items[4]) < 0) {
					throw new Exception("trick question  does not have enough answer choices");
				} else if (Integer.parseInt(items[2]) > 4) {
					throw new Exception("Error! Correct answer choice number is out of range for question text 1");
				} else if (Integer.parseInt(items[3]) < 0) {
					throw new Exception("Invalid max marks for question about sony");
				} else if (Integer.parseInt(items[4]) > 0) {
					throw new Exception("Invalid penalty for question about sony");
				}
				quiz.addQuestion(new Question(items[0], items[1].split(","), Integer.parseInt(items[2]), Integer.parseInt(items[3]), Integer.parseInt(items[4])));
				size1++;
			}
			System.out.println(q + " are added to the quiz");
		}
	}
	/**
	 * Starts a quiz.
	 *
	 * @param      scan  The scan
	 * @param      quiz  The quiz
	 * @param      q     The answer count
	 */
	public static void startQuiz(final Scanner scan,
	                             final Quiz quiz, final int q) {
		// write your code here to display the quiz questions on the console.
		// read the user responses from the console using scanner object.
		// store the user respone in the question object
		if (size1 == 0) {
			return;
		}
		// Question que = new Question();
		// quiz.print(q);
		// que.
		for (int i = 0; i < q; i++) {
			str[i] = scan.nextLine();
			responeCount++;
		}
		// for (int i = 0; i < answerCount; i++) {
		// 	str[i] = s.nextLine();
		// 	size++;
		// }
	}
	/**
	 * Displays the score report.
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report using quiz object.

		if (size1 == 0) {
			return;
		}
		int count = 0;
		for (int i = 0; i < responeCount; i++) {
			String ans = quiz.getQuestion(i).getCorrectAnswer();
			System.out.println(quiz.getQuestion(i).getQuestionText());
			String sub = str[i].substring(7);
			if (sub.equals("a")) {
				sub = "1";
			} else if (sub.equals("b")) {
				sub = "2";
			} else if (sub.equals("c")) {
				sub = "3";
			} else if (sub.equals("d")) {
				sub = "4";
			}
			if (ans.equals(sub)) {
				System.out.println(" Correct Answer! - Marks Awarded: " + quiz.getQuestion(i).getMaxMarks());
				count += quiz.getQuestion(i).getMaxMarks();
			} else {
				System.out.println(" Wrong Answer! - Penalty: " + quiz.getQuestion(i).getPenalty());
				count += quiz.getQuestion(i).getPenalty();
			}
		}
		System.out.print("Total Score: " + count);

	}
}
