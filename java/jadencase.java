class Solution {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.toLowerCase());

        boolean isFirst = true; 
        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(i);

            if (c == ' ') {
                isFirst = true;
            } else if (isFirst) {
                sb.setCharAt(i, Character.toUpperCase(c));
                isFirst = false;
            }
        }

        return sb.toString();
    }
}
