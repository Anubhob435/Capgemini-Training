package src.Main;

import java.util.*;

public class Practice2 {

    static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }

    public static List<Integer> solve(List<String> strings, List<String> queries) {

        ArrayList<Integer> arr = new ArrayList<>();

        // Step 1: Create 0/1 list
        for (String s : strings) {
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);

            if (isVowel(first) && isVowel(last)) {
                arr.add(1);
            } else {
                arr.add(0);
            }
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Process queries
        for (String q : queries) {

            String[] parts = q.split("-");
            int l = Integer.parseInt(parts[0]);
            int r = Integer.parseInt(parts[1]);

            int count = 0;

            for (int i = l - 1; i < r; i++) {
                if (arr.get(i) == 1) {
                    count++;
                }
            }

            result.add(count);
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("aba", "bcb", "ece", "aa", "e");
        List<String> queries = Arrays.asList("1-3", "2-5", "2-2");

        List<Integer> ans = solve(strings, queries);

        System.out.println(ans);
    }
}