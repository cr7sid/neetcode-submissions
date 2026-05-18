class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        Map<String, List<String>> map = new HashMap();

        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);

            String sort = new String(chs);

            map.putIfAbsent(sort, new ArrayList<>());
            map.get(sort).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
