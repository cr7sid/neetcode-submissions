class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        Map<String, List<String>> map = new HashMap();

        for (String s : strs) {
            int[] cnt = new int[26];
            
            for (char c : s.toCharArray()) {
                cnt[c - 'a']++;
            }

            String key = Arrays.toString(cnt);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
