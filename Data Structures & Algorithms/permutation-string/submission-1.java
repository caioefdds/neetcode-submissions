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

            System.out.println(Arrays.toString(indexes));
            System.out.println(Arrays.toString(indexesClone));
            System.out.println("============================-----");

            if (Arrays.equals(indexes, indexesClone)) {
                return true;
            }

            while (indexesClone[letter - 'a'] > indexes[letter - 'a']) {
                indexesClone[s2.charAt(left++) - 'a']--;
            }

            // System.out.println("left="+left);
            // System.out.println("right="+right);
        }

        return false;
    }
}
