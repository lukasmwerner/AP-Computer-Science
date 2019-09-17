# AP Computer Science Notes

Lukas Werner

## Table of contents

1. Important notes
2. Hello World (9/5/19)
3. Password Program (9/6/19)
4. String Methods (9/9/19)
5. Further String Methods (9/12/19)

## Important notes

when printing use double quotes

## Hello World (9/5/19)

* Goto to working directory
* compile program with `javac`
* run program with `java` 
* get user input with `import java.util.Scanner;`

## Password program (9/6/19)

Key concepts:

1. Variables
2. String Methods

Homework:

* Get Barron's Book

To compare strings use `string.equals("otherstring")`

```java
int x = 5;
double y = 10.2;
boolean = true;
char = 'b';
string = "Apple";
y = y + z;
```

## String Methods (9/9/19)

Key concepts:

1. String sub functions

Homework:
* install Java at home

```java
length()
charAt()
toUpperCase()
contains()
substring()
indexOf()
equails()
compareTo()
```

## Further String Methods (9/12/19)

Key Concepts:

1. Substring  <- used quite a lot
2. compareTo() <- not used much
3. Escape characters
4. String concatenation

Homework:

1. Install java at home

### Notes:

#### Substring

```java
String word = "eggplant";
word.substring(3) -> "plant"
word.substring(0,3) -> "egg"
word.substring(5,6) -> "a"

word.substring(3,7) -> "plan"
word.substring(5) -> "ant"

```

#### Compare To:

``` java
String word2 = "grape";

word.compareTo(word2) -> -2
  5      -      7
word2.compareTo(word) -> 2
  7      -      5
```

#### Escape Character

Character | returnType |
--- | --- |
\n | new line
\t | tab
\\" | "

```java
System.out.println("a");
```

#### String Concatenation

Combinding a bunch of strings together

```java
String word3 = "orange";
String words = word + "," + word2 + "," + word3;
```


## Flow Control (9.16.19)

#### Flow Control

* if
* while
* for

IF Statements

```java
if (condition) {
  codeblock
} 
else if (condition) {
  codeblock
}
else {
  codeblock
}
```

While loops

```java
while (conditon) {
  codeblock 
  int z = 3; <- z only exists inside the loop
}
printf(z); <- error
```
For loops

```java
for (int i = 0; i < 5; i++) {
  codeblock
}
```
`i` loop variable, next is our conditon, and finally is the update

loops though `0, 1, 2, 3, 4`

### Loops and random stuff 

```java

Math.random()    <-returns double
0 <= r <1  <- random number between 0-1

Math.random() * 10    <- returns double
0 <= r <10 <- random integer between 0-10

(int)(Math.random()*10) <- casts to an int
```
Create a random number between two numbers

```java
(11 - 12)

(int)(Math.random()*2) + 11

(2 - 8)

(int)(Math.random()*7) + 2

(0 - 99)

(int)(Math.random()*100)

```

Random numbers first inclusive, last exclusive

```java

```