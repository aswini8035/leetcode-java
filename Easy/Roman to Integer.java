class Solution {
    public int romanToInt(String s) {
     Map<Character, Integer> romanMap = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        int total = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current = romanMap.get(s.charAt(i));

            if (current < prevValue) {
                total -= current;
            } else {
                total += current;
            }

            prevValue = current;
        }

        return total;
    }
}