class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] response = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int position = stack.pop();
                int diffPosition = i - position;
                response[position] = diffPosition;
            }

            stack.push(i);
        }

        return response;
    }
}
