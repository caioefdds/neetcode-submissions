class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> indexes = new HashMap<>();

        for (int num : nums) {
            indexes.put(num, indexes.getOrDefault(num, 0) + 1);
        }

        // PriorityQueue<HashMap<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Integer, Integer> entry : indexes.entrySet()) {
            maxHeap.offer(entry);
        }

        int[] response = new int[k];
        for (int i = 0; i < k; i++) {
            response[i] = maxHeap.poll().getKey();
        }

        return response;
    }
}
