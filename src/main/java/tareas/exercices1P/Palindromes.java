package tareas.exercices1P;

public class Palindromes {
    public boolean isPalindrome(String word){
        String s = word;
        s = s.replaceAll(" ", "").toLowerCase();
        return s.contentEquals(new StringBuilder(s).reverse());
    }
}
