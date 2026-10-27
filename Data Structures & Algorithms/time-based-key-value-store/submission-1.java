
class TimeMap {
    private Map<String, List<Entry>> indexes = new HashMap<>();

    record Entry(int timestamp, String value) {}

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        indexes.computeIfAbsent(key, k -> new ArrayList<>())
               .add(new Entry(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Entry> entries = indexes.get(key);

        if (entries == null) return "";

        int left = 0;
        int right = entries.size() - 1;
        String response = "";

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (entries.get(mid).timestamp() <= timestamp) {
                response = entries.get(mid).value();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return response;
    }
}
