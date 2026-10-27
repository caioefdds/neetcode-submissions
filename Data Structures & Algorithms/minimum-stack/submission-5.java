class MinStack {
    private List<Integer> values;
    private int pointer;
    private List<Integer> minValues;

    public MinStack() {
        this.values = new ArrayList<>();
        this.minValues = new ArrayList<>();
        this.pointer = -1;
    }
    
    public void push(int val) {
        int minValue = pointer == -1 ? val : Math.min(val, this.minValues.get(pointer));
    
        this.pointer += 1;

        if (this.values.size() >= this.pointer + 1) {
            this.values.set(pointer, val);
            this.minValues.set(pointer, minValue);
        } else {
            this.values.add(pointer, val);
            this.minValues.add(pointer, minValue);
        }
    }
    
    public void pop() {
        pointer--;
    }
    
    public int top() {
        return this.values.get(pointer);
    }
    
    public int getMin() {
        return this.minValues.get(pointer);
    }
}
