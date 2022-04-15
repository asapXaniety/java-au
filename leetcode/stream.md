# STREAM

+ [Top K Frequent Words](#top-k-frequent-words)

## Top K Frequent Words

https://leetcode.com/problems/top-k-frequent-words/

<details><summary>Test Cases</summary>

``` java
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution sol;
    
    @BeforeEach
    void setSolution() {
        sol = new Solution();
    }
    
    @Test
    void testTopKFrequent() {
        int k = 4;
        String[] words = new String[] {"the","day","is","sunny","the","the","the","sunny","is","is"};
        assertEquals(List.of("the","is","sunny","day"), solution.topKFrequent(words, k));
    }
    
    @Test
    void testSecondForTopKFrequent() {
        int k = 2;
        String[] words = new String[] {"i","love","leetcode","i","love","coding"};
        assertEquals(List.of("i","love"), solution.topKFrequent(words, k));
    }
}
```

</details>


``` java

import java.util.Comparator;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Topk {
    public static void main(String[] args) {
        String[] example_1 = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(Arrays.toString(example_1));
        System.out.println(topKFrequent(example_1, 2));
        String[] example_2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(Arrays.toString(example_2));
        System.out.println(topKFrequent(example_2, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        return Stream.of(words)
                .sorted()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(k)
                .map(pair -> pair.getKey())
                .collect(Collectors.toList());
    }
}
```
