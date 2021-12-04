# Design

+ [Implement Stack using Queues](#implement-stack-using-queues)


## Implement Stack using Queues

https://leetcode.com/problems/implement-stack-using-queues/

<details><summary>Test Cases</summary>

``` java
class TestMyStack{
    
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