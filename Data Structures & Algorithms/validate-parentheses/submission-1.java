class Solution {
    private final Map<Character, Character> mapping = Map.of(
        ']', '[',
        ')', '(',
        '}', '{'
    );

    public boolean isValid(String s) {
        Stack<Character> parentesis = new Stack<>();

        for (Character letter : s.toCharArray()) {
            if (mapping.containsKey(letter)) {
                if (parentesis.isEmpty() || parentesis.peek() != mapping.get(letter)) return false;
                parentesis.pop();
                continue;
            }

            parentesis.add(letter);
        }

        return parentesis.isEmpty();
    }
}
