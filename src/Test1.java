import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Test1 {

	static ArrayList<Integer> answer = new ArrayList<>();

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter  T is the length of the sequence := ");
		String input = in.nextLine();
		int temp = Integer.parseInt(input);
		System.out.println("Enter Integer in sequence separated by space := ");
		input = in.nextLine();
		in.close();
		StringTokenizer tokenizer = new StringTokenizer(input, " ", false);
		int token = tokenizer.countTokens();
		if (input.length() < 1 || token != temp) {
			System.out.println("Invalid Integer in sequence... ");
			System.exit(0);
		}
		ArrayList<Integer> question = new ArrayList<>();
		while (tokenizer.hasMoreElements()) {
			temp = Integer.parseInt(tokenizer.nextElement().toString());
			if (temp >= 1) {
				question.add(temp);
			}
		}
		ArrayList<ArrayList<Integer>> all = new ArrayList<>();
		while (question.size() > 0) {
			answer = find(question);
			all.add(answer);
			question.removeAll(answer);
		}
		int oldSize = 0;
		for (ArrayList<Integer> arrayList : all) {
			int newSize = arrayList.size();
			if (newSize > oldSize) {
				answer = new ArrayList<>();
				answer.addAll(arrayList);
				oldSize = newSize;
			}
		}
		for (Integer integer : answer) {
			System.out.print(integer + " ");
		}
	}

	public static ArrayList<Integer> find(ArrayList<Integer> question) {
		int old = 1;
		answer = new ArrayList<>();
		for (Integer integer : question) {
			if (integer >= old) {
				answer.add(integer);
				old = integer;
			}
			else {
				return answer;
			}
		}
		return answer;
	}
}
