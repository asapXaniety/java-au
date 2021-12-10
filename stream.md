# Stream

+ [Get Words By Length More Than 5](#get-words-by-length-more-than-5)
+ [Get Reversed Words](#get-reversed-words)
+ [Get Sorted Distance](#get-sorted-distance)
+ [Get Top 10](#get-top-10)


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


## Get Sorted Distance

<details><summary>Test Cases</summary>

```java
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
class SolutionTest {
    private Solution sol;
    
    @BeforeEach
    void setSolution() {
        sol = new Solution();
    }
    
    @Test
    void testGetDistanceSorted() {
        List<Integer> x = List.of(1, -2, -1, 1);
        List<Integer> y = List.of(1, 3, -1, -1);
        List<Map.Entry<Integer, Integer>> expected = List.of(Map.entry(1,-1), Map.entry(-2, 3));
        assertEquals(expected, sol.getDistanceSorted(xCoords, yCoords));
    }
}
```

</details>

```java
public List<Map.Entry<Integer, Integer>> getDistanceSorted(List<Integer> x, List<Integer> y) {
    return IntStream.range(0, Math.min(x.size(), y.size()))
            .mapToObj(i -> Map.entry(x.get(i), y.get(i)))
            .filter(pair -> pair.getKey() <= 0 && pair.getValue() >= 0 || pair.getKey() >= 0 && pair.getValue() <= 0)
            .sorted((o1, o2)-> {
                Integer dist1 = o1.getKey() * o1.getKey() + o1.getValue() * o1.getValue();
                Integer dist2 = o2.getKey() * o2.getKey() + o2.getValue() * o2.getValue();
                return dist1.compareTo(dist2);
            })
            .collect(Collectors.toList());
    }
```


## Get Top 10

<details><summary>Test Cases</summary>

```java

```

</details>

``` java
import java.util.List;
import java.util.Objects;
public class Post {
    private int id;
    private int likes;
    private String text;
    private long authorId;
    private List<Comment> comments;
    Post (int likes, List<Comment> comments) {
        this.likes = likes;
        this.comments = comments;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public List<Comment> getComments() {
        return comments;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && getLikes() == post.getLikes() && authorId == post.authorId && Objects.equals(text, post.text) && Objects.equals(getComments(), post.getComments());
    }
}
```

``` java
import java.util.Objects;
public class Comment {
    private int id;
    private String text;
    private long authorId;
    Comment() {}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return id == comment.id && authorId == comment.authorId && Objects.equals(text, comment.text);
    }
}
```

``` java
public List<Post> getTop10(List<Post> feed) {
    return feed.stream()
            .sorted((o1, o2) -> {
                Integer rank1 = o1.getLikes() + o1.getComments().size();
                Integer rank2 = o2.getLikes() + o2.getComments().size();
                return rank2.compareTo(rank1);
            })
            .limit(10)
            .collect(Collectors.toList());
}
```
