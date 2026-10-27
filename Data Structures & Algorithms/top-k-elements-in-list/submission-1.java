class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        Map<Integer, Integer> indexes = new HashMap<>();

        for (int num : nums) {
            indexes.put(num, indexes.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : indexes.entrySet()) {
            heap.add(entry);
        }

        int[] response = new int[k];

        for (int i = 0; i < k; i++) {
            response[i] = heap.poll().getKey();
        }

        return response;
    }
}
