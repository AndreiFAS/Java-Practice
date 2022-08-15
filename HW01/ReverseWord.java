
public class ReverseWord {

    public static void main(String[] args) {

        System.out.println(reverseWords("a good   example"));

    }

    public static String reverseWords(String s) {
        // String result = "";
        // String buffer = "";
        // s = s.replace(" ", " ");
        // s = s.replace(" ", " ");
        // s = s.replace(" ", " ");
        // for (int i = 0; i < s.length(); i++) {
        // if (s.charAt(i) == ' ') {
        // result = " " + buffer + result;
        // buffer = "";
        // } else {
        // buffer += s.charAt(i);
        // }
        // }
        // result = buffer + result;
        // return result.trim();
        
        StringBuilder ans = new StringBuilder();
        int end = s.length() - 1;
        while (end >= 0) {
            if (s.charAt(end) == ' ') {
                end -= 1;
                continue;
            }
            int start = end - 1;
            while (start >= 0 && s.charAt(start) != ' ') {
                start -= 1;
            }
            ans.append(" ");
            ans.append(s.substring(start + 1, end + 1));
            end = start - 1;
        }
        if (ans.length() > 0) {
            ans.deleteCharAt(0);
        }
        return ans.toString();
    }

}