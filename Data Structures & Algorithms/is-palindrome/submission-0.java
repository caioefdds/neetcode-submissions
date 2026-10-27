class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;

        StringBuilder cleanWord = new StringBuilder();

        for (Character letter : s.toCharArray()) {
            if (Character.isLetterOrDigit(letter)) {
                cleanWord.append(Character.toLowerCase(letter));
            }
        }

        int right = cleanWord.length() - 1;
        System.out.println(cleanWord.toString());

        while (left < right) {
            if (cleanWord.charAt(left) != cleanWord.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
