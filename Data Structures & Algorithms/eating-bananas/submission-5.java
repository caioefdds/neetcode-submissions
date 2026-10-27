class Solution {
    private boolean check(int[] piles, int h, int speed) {
        int time = 0;

        for (int pile : piles) {
            time += (pile + speed - 1) / speed;

            if (time > h) return false;
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int bananas = 0;
        int maxPile = 0;
        for (int pile : piles) {
            bananas += pile;
            maxPile = Math.max(maxPile, pile);
        }

        int start = (bananas + h - 1) / h;
        int end = maxPile;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (check(piles, h, mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
