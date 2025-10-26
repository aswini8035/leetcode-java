class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        int sLen = s.length();

        if (sLen < totalLen) return result;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        for (int i = 0; i <= sLen - totalLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;

            while (j < words.length) {
                int start = i + j * wordLen;
                String sub = s.substring(start, start + wordLen);

                if (!wordCount.containsKey(sub)) break;

                seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                if (seen.get(sub) > wordCount.get(sub)) break;

                j++;
            }

            if (j == words.length) result.add(i);
        }

        return result;
    }
}