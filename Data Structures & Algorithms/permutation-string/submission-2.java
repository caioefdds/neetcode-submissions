class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] indexes = new int[26];
        for (char letter : s1.toCharArray()) {
            indexes[letter - 'a']++;
        }

        int left = 0;
        int right = 0;
        int[] indexesClone = new int[26];

        while (right < s2.length()) {
            char letter = s2.charAt(right);
            indexesClone[letter - 'a']++;
            right++;

            while (indexesClone[letter - 'a'] > indexes[letter - 'a']) {
                indexesClone[s2.charAt(left++) - 'a']--;
            }

            if (Arrays.equals(indexes, indexesClone)) {
                return true;
            }
        }

        return false;
    }
}
