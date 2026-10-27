class Solution {
    private Set<String> operations = Set.of("+", "-", "*", "/");
    public int evalRPN(String[] tokens) {
        if (tokens.length == 0) return 0;
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);

        Stack<Integer> numbers = new Stack<>();
 
        for (String token : tokens) {
            if (!operations.contains(token)) {
                numbers.push(Integer.parseInt(token));
                continue;
            }

            Integer number2 = numbers.pop();
            Integer number1 = numbers.pop();

            switch (token) {
                case "+": 
                    numbers.push(number1 + number2);
                    break;
                case "-": 
                    numbers.push(number1 - number2);
                    break;
                case "*": 
                    numbers.push(number1 * number2);
                    break;
                case "/": 
                    numbers.push(number1 / number2);
                    break;
            }
        }

        return numbers.pop();
    }
}
