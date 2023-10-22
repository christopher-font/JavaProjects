public class ReverseAString {
    public static String reverseAString(String str) {
        String ans = "";

        for (int i = str.length() - 1; i >= 0; i--) ans += str.charAt(i);

        return ans;
    }


    public static void main(String[] args) {
        String test = "This is a test";
        System.out.println(test);
        System.out.println(reverseAString(test));

    }
}
