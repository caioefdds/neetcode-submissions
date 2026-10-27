class Solution {
    public int characterReplacement(String s, int k) {
        int response = 0;
        int maxRep = 0;
        int[] mapping = new int[26];

        int left = 0;
        for (int right = 0; right < s.length(); right ++) {
            int index = s.charAt(right) - 'A';

            mapping[index]++;
            maxRep = Math.max(maxRep, mapping[index]);

            while ((right - left + 1) - maxRep > k) {
                mapping[s.charAt(left) - 'A']--;
                left++;
            }

            response = Math.max(response, (right - left + 1));
        }

        return response;
    }
}
