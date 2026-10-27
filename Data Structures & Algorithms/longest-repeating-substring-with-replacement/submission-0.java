class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int response = 0;
        int windowSize = 0;
        int maxFrequency = 0;

        int[] freq = new int[26];

        for (int right = 0; right < s.length(); right++) {
            Character letter = s.charAt(right);

            freq[letter - 'A']++;
            maxFrequency = Math.max(maxFrequency, freq[letter - 'A']);
            windowSize++;

            while (windowSize - maxFrequency > k) {
                Character leftLetter = s.charAt(left);
                freq[leftLetter - 'A']--;
                left++;
                windowSize--;
            }

            response = Math.max(windowSize, response);
        }

        return response;
    }
}
