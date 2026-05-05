import java.util.*;
public class CyclicSubstring_MaxSum {

    public static int CyclicS(String s) {

        int n = s.length();

        // Cyclic handling
        String str = s + s;

        int[] freq = new int[26];

        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < str.length(); right++) {

            char ch = str.charAt(right);

            currentSum += (ch - 'a' + 1);
            freq[ch - 'a']++;

            while (freq[ch - 'a'] > 1 || (right - left + 1) > n) {

                char leftChar = str.charAt(left);

                currentSum -= (leftChar - 'a' + 1);
                freq[leftChar - 'a']--;

                left++;
            }

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(CyclicS(s));
    }
}
