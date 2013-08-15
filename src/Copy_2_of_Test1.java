import java.util.ArrayList;
import java.util.StringTokenizer;

public class Copy_2_of_Test1 {

	public static void main(String args[]) {

		String input = "1 22 34 1 5 6 7 8 9 43 2 2 2";
		StringTokenizer tokenizer = new StringTokenizer(input, " ", false);

		ArrayList<Integer> question = new ArrayList<>();

		while (tokenizer.hasMoreElements()) {
			question.add(Integer.parseInt(tokenizer.nextElement().toString()));
		}

		ArrayList<ArrayList<Integer>> all = new ArrayList<>();
		ArrayList<Integer> answer = new ArrayList<>();

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
			System.out.println(integer);
		}

		/*
				for (ArrayList<Integer> arrayList : all) {
					System.out.println(arrayList.size());
					System.out.println();
					for (Integer integer : arrayList) {
						System.out.println(integer);
					}
				}
				*/
	}

	public static ArrayList<Integer> find(ArrayList<Integer> question) {
		int old = 0;
		ArrayList<Integer> answer = new ArrayList<>();

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
