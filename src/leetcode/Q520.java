package leetcode;

/**
 * 检查大写字母
 */
public class Q520 {

   public static boolean detectCapitalUse(String word) {
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

       for (int i = 2; i < word.length(); i++) {
           if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
               return false;
           }
       }
       return true;
   }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("F"));
    }
}
