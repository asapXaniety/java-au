# Stream

+ [Get Words By Length More Than 5](#get-words-by-length-more-than-5)


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