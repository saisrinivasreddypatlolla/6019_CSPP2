/**
 ******************************************************************************
 *                    HOMEWORK, 15-121
 ******************************************************************************
 *                  THE DOCUMENT DISTANCE
 ******************************************************************************
 *
 * The document distance problem is the problem of computing the distance
 * between two given text documents.
 *
 * The distance between two documents is the angle between their word
 * frequency vectors.
 *
 *
 *****************************************************************************/
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import java.net.*;

public class Distance {
	private  String REGEX = "[^a-zA-Z0-9_ ]";
	String s;
	int count = 0;
	static int wordsCount = 0;
	int wordCountOne = 0;
	File file;
	Distance(File item) {
		this.file = item;
		file();
	}
	HashMap<String, Integer> name = new HashMap<String, Integer>();
	ArrayList<String> str = new ArrayList<String>();
	ArrayList<String>str1 = new ArrayList<String>();
	public void file() {
		try {
			int size = 0;
			Scanner scan = new Scanner(file);
			scan.useDelimiter("\n");
			while (scan.hasNext()) {
				s = scan.nextLine();
				Pattern p = Pattern.compile(REGEX);

				// get a matcher object
				Matcher m = p.matcher(s);
				s = m.replaceAll(" ").toLowerCase();
				String[] words = s.split(" ");
				StringTokenizer tokens = new StringTokenizer(s);
				wordCountOne += tokens.countTokens();

				// System.out.println(Arrays.toString(s.split(" ")) + "\n" + Arrays.toString(words));
				// for (int i = 1; i < words.length; i++) {
				// 	if (!(words[i].equals(""))) {
				// 		// if (obj.size() == 0) {
				// 		// 	obj.add(new Words(words[0], wordsCount));
				// 		// 	System.out.println(obj.size());
				// 		// } else if (obj.size() > 0) {
				// 		// 	// System.out.println("hello");

				// 		// 	if (!((words[i].trim()).equals(""))) {
				// 		// 		for (int j = 0; j < obj.size(); j++) {
				// 		// 			if (!((words[i].trim()).equals(obj.get(j).getWord()))) {
				// 		// 				// System.out.println(words[i].trim() + " " + obj.get(j).getWord() + " " + obj.get(j).getCount());
				// 		// 				// System.out.println("wod");
				// 		// 				obj.add(new Words(words[i], wordsCount));
				// 		// 			} else {
				// 		// 				// System.out.println("count");;
				// 		// 				// System.out.println(words[i].trim() + " " + obj.get(j).getWord() + " " + obj.get(j).getCount());
				// 		// 				obj.get(j).setCount();
				// 		// 			}
				// 		// 		}
				// 		// 	}
				// 		// }
				// 		// System.out.println(words[i]);
				// 		str.add(words[i]);
				// 		wordsCount++;
				// 	}
				// }
				addWords(words);
				count++;
			}








			// System.out.println(name);
			// for (int i = 0; i < obj.size(); i++) {
			// 	System.out.println(obj.get(i).getWord() + " " + obj.get(i).getCount());
			// }
			// distinctWords();
			// System.out.println(count + "\n" + wordsCount + "\n" + wordCountOne + " " + str.size() + " " + str1.size());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void addWords(String[] words) {
		for (int i = 0; i < words.length; i++) {
			if (!(words[i].equals(""))) {
				if (name.containsKey(words[i])) {
					name.put(words[i], name.get(words[i]) + 1);
				} else {
					name.put(words[i], 1);
				}
			}
		}
		// return name;
	}
	public double ecludian() {
		double sum = 0;
		for (String key : name.keySet()) {
			sum += name.get(key) * name.get(key);
		}
		return sum;
	}
	// public void distinctWords() {
	// 	if (str1.size() == 0) {
	// 		str1.add(str.get(0));
	// 	} else {
	// 		for (int i = 0; i < str.size(); i++) {

	// 			for (int j = 0; j < str1.size(); j++) {
	// 				if (!((str.get(i)).equals(str1.get(j)))) {
	// 					str1.add(str.get(i));
	// 				}
	// 			}
	// 		}
	// 	}
	// }
	public int getNumOfLines() {
		return count;
	}
	public int getNumOfWords() {
		return str.size();
	}
	//requirements are defined by provided tests
	//       Test1.java, Test2.java, Test3.java, Test4.java

}
class Words {
	String word;
	int count;
	Words(String word1, int count1) {
		// System.out.println(word1 + " " + count);
		this.word = word1;
		this.count = count1;
	}
	public String getWord() {
		return this.word;
	}
	public int getCount() {
		return this.count;
	}
	public void setCount() {
		this.count += 1;
	}
}