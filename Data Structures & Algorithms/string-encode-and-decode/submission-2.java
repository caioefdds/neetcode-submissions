class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String word : strs) {
            sb.append(word.length())
              .append("#")
              .append(word);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> response = new ArrayList<>();

        int start = 0;

        while (start < str.length()) {
            int end = start;

            while (str.charAt(end) != '#') {
                end++;
            }

            int wordLength = Integer.parseInt(str.substring(start, end));

            end++;

            String word = str.substring(end, wordLength + end);
            response.add(word);
            start = end + wordLength;
        }

        return response;
    }
}
