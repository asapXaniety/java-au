# Design

+ [Implement Stack using Queues](#implement-stack-using-queues)


## Implement Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues/

<details><summary>Test Cases</summary>

``` java
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TestMyStack{
    
    @Test
    void top() {
        var lst = createRandomLst(10);
        var stack = createMyStackFromLst(lst);
        Collections.reverse(lst);
        for (var value: lst) {
            assertEquals(value, stack.top());
            stack.pop();
        }
    }
    
    @Test
    void pushPop() {
        var lst = createRandomLst(10);
        var stack = createMyStackFromLst(lst);
        Collections.reverse(lst);
        for (var value: lst) {
            assertEquals(value, stacl.pop());
        }
    }
    
    @Test
    void empty() {
        var stack = createMyStackFromLst(List.of());
        assertTrue(stack.empty());
    }
    
    @Test
    void nonEmpty() {
        var stack = createMyStackFromLst(createRandomLst(5));
        assertFalse(stack.empty());
    }
    
    private MyStack createMyStackFromLst(List<Integer> lst){
        var stack = new MyStack();
        for (var value: lst) {
            stack.push(value);
        }
        return stack;
    }
    
    private ArrayList<Integer> createRandomLst(int size){
        var lst = new ArrayList<Integer>();
        for(int i = 0; i < size; i++){
            lst.add((int)(Math.random() * 10));
        }
        return lst;
    }
}
```

</details>


```java
class MyStack{
    Deque<Integer> stack;

    public MyStack(){
        stack=new ArrayDeque<>();
    }

    public void push(int x){
        stack.push(x);
    }

    public int pop(){
        return stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public boolean empty(){
        return stack.isEmpty();
    }
}
```