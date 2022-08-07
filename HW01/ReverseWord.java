
public class ReverseWord {

    public static void main(String[] args) {

        System.out.println(reverseWords("a good   example"));

    }

    public static String reverseWords(String s) {
        String result = "";
        String buffer = "";
        s = s.replace("    ", " ");
        s = s.replace("   ", " ");
        s = s.replace("  ", " ");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                result = " " + buffer + result;
                buffer = "";
            } else {
                buffer += s.charAt(i);
            }
        }
        result = buffer + result;
        return result.trim();
    }

}