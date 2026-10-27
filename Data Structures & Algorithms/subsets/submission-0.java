class Solution {
    public void addSubset(
        int[] nums,
        int index,
        List<Integer> current,
        List<List<Integer>> list
    ) {
        if (index >= nums.length) {
            list.add(new ArrayList<>(current));
            return;
        }

        // Inclui o elemento
        current.add(nums[index]);
        addSubset(nums, index + 1, current, list);

        // Desfaz a escolha
        current.remove(current.size() - 1);

        // Ignora o elemento
        addSubset(nums, index + 1, current, list);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        addSubset(nums, 0, current, list);

        return list;
    }
}