package exercices1P;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PalindromesTest {
    @ParameterizedTest
    @CsvSource(
            {
                    "ana",
                    "radar",
                    "reconocer",
                    "Able was I saw elba",
                    "Was it a car or a cat I saw",
                    "Step on no pets",
                    "Evil is a name of a foeman as I live",
                    "Racecar",
                    "12321",


            }
    )
    public void verifyIsPalindrome(String word){
        Palindromes pal = new Palindromes();
        boolean actualResult = pal.isPalindrome(word);

        Assertions.assertTrue(actualResult, "ERROR> "+word+" si es palindromo");
    }

    @ParameterizedTest
    @CsvSource(
            {
                    "hello",
                    "world",
                    "Palindrome",
                    "hello world",
                    "12345",
                    "Are we not pure sir panic in a den of upturned era"
            }
    )
    public void verifyIsNotPalindrome(String word){
        Palindromes pal = new Palindromes();
        boolean actualResult = pal.isPalindrome(word);

        Assertions.assertFalse(actualResult, "ERROR> "+word+" no es palindromo");
    }
}
