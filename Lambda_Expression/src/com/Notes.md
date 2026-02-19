## Stream Function (Advance Java)
- Stream doesnot store any data
- Sources can be collections, Arrays, Files, generator Functions
- Stream is Functional in Nature and then it uses lambda expresions, Functional Interfaces and Method Reference.
- Stream Operations are lazy.
- Nothing happens untill you call terminal operations.
- Executions start only for the following
    - for each
    - collect
    - toList
    - count

## Stream Pipeline Model
- collections > stream > Filter > Transform > collect >  result
- 3 Stages of Stream Pipeline
- SOURCE -> INTERMIDIATE OPERATIONS -> TERMINAL OPERATIONS

### Example: Stream Pipeline Stages

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

// SOURCE -> INTERMEDIATE OPERATIONS -> TERMINAL OPERATION
numbers.stream()                     // SOURCE
    .filter(n -> n % 2 == 0)        // INTERMEDIATE
    .map(n -> n * n)               // INTERMEDIATE
    .toList();                    // COLLECT or TERMINAL
```
**Output:** `[4, 16, 36]`


## Common intermediate operations
- filter() - remove elements based on a condition
- map() - transform elements to another form
- sorted() - sort elements
- distinct() - remove duplicates
- limit() - limit the number of elements
- skip() - skip the first n elements
- peek() - perform an action on each element without modifying the stream

## Common terminal operations
- toList() - collect elements into a List
- toSet() - collect elements into a Set
- for each() - perform an action for each element
- count() - count the number of elements
- findFirst() - get the first element

## LIFE CYCLE STATES
NEW - RUNNABLE - BLOCKED - WAITING - TIMED WAITING - TERMINATED

## LIFE CYCLE FLOW
NEW - RUNNABLE - (WAITING / BLOCKED / TIMED WAITING ) - RUNNABLE - TERMINATED 