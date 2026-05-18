class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return "";

        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < strs.size(); i++) {
            builder.append(strs.get(i).length());
            builder.append("#");
            builder.append(strs.get(i));
        }

        return builder.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }
        List<String> ans = new ArrayList<>();

        int lastInd = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '#') {
                String len = "";
                for (int j = lastInd; j < i; j++) {
                    len += str.charAt(j);
                }
                int length = Integer.valueOf(len);
                
                len = "";
                for (int j = i + 1; j < (i + 1 + length) && j < str.length(); j++) {
                    len += str.charAt(j);
                }

                ans.add(len);
                i = i + 1 + length;
                lastInd = i;
            }
        }

        return ans;
    }
}
