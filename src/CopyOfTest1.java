import java.util.StringTokenizer;

public class CopyOfTest1 {

	public static void main(String args[]) {
		/*
				String input = "1 22 34 1 5 6 7 8 9";
				StringTokenizer tokenizer = new StringTokenizer(input, " ", false);

				StringBuilder answer = new StringBuilder();
				String[][] ans = new String[1][tokenizer.countTokens()];
				ArrayList<ArrayList<Integer>> all = new ArrayList<>();

				String temp = "";

				int i = 0;
				int j = 0;
				int old = 0;
				int newNum = 0;

				ArrayList<Integer> al = new ArrayList<>();

				while (tokenizer.hasMoreElements()) {
					temp = tokenizer.nextElement().toString();
					newNum = Integer.parseInt(temp);

					if (newNum >= old) {
						System.out.println(newNum);
						answer.append(newNum).append(" ");
						al.add(newNum);
						// ans[j][i] = temp;
						old = newNum;
					}
					else {
						all.add(al);
					}
				}

				/*
				StringTokenizer t = new StringTokenizer(answer.toString(), " ", false);
				while (t.hasMoreElements()) {
					temp = t.nextElement().toString();
					System.out.println(temp + "<-");
					ans[j][i] = temp;
					i++;
				}
				j++;

				System.out.println(Arrays.deepToString(ans));
				
		/*
		// StringBuffer t = new StringBuffer();
		// System.out.println(answer.toString() + "<-");
		for (int j2 = 0; j2 < ans.length; j2++) {
			for (int k = 0; k < ans.length; k++) {
				// System.out.println(Arrays.toString(ans[k]));
				answer.append(Arrays.toString(ans[k]));
				// System.out.println(answer.toString() + "<-");

			}

		}

		// System.out.println(t.);
		*/

	}

	void find(StringTokenizer tokenizer) {

	}
}
