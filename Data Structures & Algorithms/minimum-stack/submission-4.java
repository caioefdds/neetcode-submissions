class MinStack {
    private int[] values;
    private int pointer;
    private int[] minValues;

    public MinStack() {
        this.values = new int[100000];
        this.minValues = new int[100000];
        this.pointer = -1;
    }
    
    public void push(int val) {
        int minValue = pointer == -1 ? val : Math.min(val, this.minValues[pointer]);
    
        this.pointer += 1;
        this.values[pointer] = val;
        this.minValues[pointer] = minValue;
    }
    
    public void pop() {
        this.values[pointer] = 0;
        this.minValues[pointer] = Integer.MAX_VALUE;
        pointer--;
    }
    
    public int top() {
        return this.values[pointer];
    }
    
    public int getMin() {
        return this.minValues[pointer];
    }
}
