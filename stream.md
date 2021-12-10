# Stream

+ [Get Words By Length More Than 5](#get-words-by-length-more-than-5)
+ [Get Reversed Words](#get-reversed-words)


## Get Words By Length More Than 5

<details><summary>Test Cases</summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
class SolutionTest {
    private Solution sol;
    
    @BeforeEach
    void setSolution() {
        sol = new Solution();
    }
    @Test
    void testGetWordsByLength() {
        String input = "first, second, third, fourth, fifth";
        List<String> expected = List.of("second", "fourth");
        assertEquals(expected, sol.getWordsByLength(input));
    }
}
```

</details>


``` java
public List<String> getWordsByLength(String sentence) {
    return Stream.of(sentence.split(" "))
            .filter(word -> word.length() > 5)
            .collect(Collectors.toList());
}
```


## Get Reversed Words

<details><summary>Test Cases</summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
class SolutionTest {
    private Solution sol;
    
    @BeforeEach
    void setSolution() {
        sol = new Solution();
    }
    @Test
    void testGetReverseWords() {
        String input = "one two three four five";
        String expected = "eno owt eerht ruof evif";
        assertEquals(expected, sol.getReverseWords(input));
    }
}
```

</details>

``` java
public String getReverseWords(String sentence) {
    return Stream.of(sentence.split(" "))
            .map(word -> new StringBuilder(word).reverse())
            .collect(Collectors.joining(" "));
}
```