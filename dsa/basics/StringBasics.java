package dsa.basics;

public class StringBasics {

    // 1. Count characters (without length())
    static int countChars(char[] s) {
        int count = 0;
        for (char c : s) count++;
        return count;
    }

    // 2. Count vowels and consonants
    static void countVowelsConsonants(char[] s) {
        int v = 0, c = 0;
        for (char ch : s) {
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
                ch = (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch;
                if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') v++;
                else c++;
            }
        }
        System.out.println("Vowels: " + v + " Consonants: " + c);
    }

    // 3. Reverse string
    static void reverseString(char[] s) {
        int i = 0, j = countChars(s) - 1;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++; j--;
        }
        System.out.println(s);
    }

    // 4. Check equality
    static boolean isEqual(char[] a, char[] b) {
        int i = 0;
        while (i < a.length && i < b.length) {
            if (a[i] != b[i]) return false;
            i++;
        }
        return i == a.length && i == b.length;
    }

    // 5. To Uppercase
    static void toUpper(char[] s) {
        for (int i = 0; i < s.length; i++)
            if (s[i] >= 'a' && s[i] <= 'z')
                s[i] = (char)(s[i] - 32);
        System.out.println(s);
    }

    // 6. To Lowercase
    static void toLower(char[] s) {
        for (int i = 0; i < s.length; i++)
            if (s[i] >= 'A' && s[i] <= 'Z')
                s[i] = (char)(s[i] + 32);
        System.out.println(s);
    }

    // 7. Remove spaces
    static void removeSpaces(char[] s) {
        int j = 0;
        for (char c : s)
            if (c != ' ') s[j++] = c;

        for (int i = 0; i < j; i++)
            System.out.print(s[i]);
        System.out.println();
    }

    // 8. Count words
    static int countWords(char[] s) {
        int count = 0;
        boolean word = false;
        for (char c : s) {
            if (c != ' ' && !word) {
                count++;
                word = true;
            } else if (c == ' ') word = false;
        }
        return count;
    }

    // 9. Character frequency
    static void charFrequency(char[] s) {
        int[] freq = new int[256];
        for (char c : s) freq[c]++;
        for (int i = 0; i < 256; i++)
            if (freq[i] > 0)
                System.out.println((char)i + " : " + freq[i]);
    }

    // 10. Check binary string
    static boolean isBinary(char[] s) {
        for (char c : s)
            if (c != '0' && c != '1') return false;
        return true;
    }

    public static void main(String[] args) {
        char[] s = {'H','e','l','l','o',' ','W','o','r','l','d'};
        char[] s2 = {'H','e','l','l','o',' ','W','o','r','l','d'};

        System.out.println("Chars: " + countChars(s));
        countVowelsConsonants(s);
        reverseString(s);
        System.out.println("Equal: " + isEqual(s, s2));
        toUpper(s2);
        toLower(s2);
        removeSpaces(s2);
        System.out.println("Words: " + countWords(s2));
        charFrequency(s2);
        System.out.println("Binary: " + isBinary(new char[]{'1','0','1','0'}));
    }
}