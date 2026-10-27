class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        int carFleet = 0;
        double lastCarTime = 0;

        // System.out.println(Arrays.deepToString(cars));

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        // System.out.println(Arrays.deepToString(cars));

        for (double[] car : cars) {
            if (car[1] > lastCarTime) {
                lastCarTime = car[1];
                carFleet++;
            }
        }

        return carFleet;
    }
}
