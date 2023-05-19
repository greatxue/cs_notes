# Data Structure with Java
- - -
author: Kevin Shuey  
title: Notes for Data Structure with Java  
date: 2023-05-05  
ref: ucb_CS61B
- - -



## 1. Intruduction to Java

### 1.1 Essentials  

#### 1.1.1 Hello World

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
```

Here are some key syntactic features:
* It always consists of a class declaration, using the key word `public class`.
* The code to run is inside a method called `main`.
* Curly braces `{` and `}` are used to conclude the codes.
* Statements must end with semi-colons `;`.

#### 1.1.2 Running a Java Program
The most common way is to run it through a sequence:  
`Hello.java` -> Compiler `javac` -> `Hello.class` -> Interpreter `java` -> (executing)  

Example:
```shell
$ javac HelloWorld.java
$ java HelloWOrld
```


#### 1.1.3 Variables and Loops
```java
public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
        while (x < 10) {
            System.out.print(x + " ");
            x = x + 1;
        }
    }
}
```

Here are some features of the program:
* The variable `x` must be declared and given a type before being used.
* The loop definition is contained inside of **curly braces**, and the boolean expression is inside **parentheses**.
* Our print statement is just `System.out.print` instead of `System.out.println`, which means **no newline**.
* Our print statement adds a number to a **space**, which makes sure the numbers don't run into each other. 
* The prompt ends up on the same line as the numbers, **without a newline**.

#### 1.1.4 Static Typing
Every variable, parameter, and functions in Java has a so-called `static type`.   
This is in contrast to dynamically typed languages like **Python**, where users can run into **type error**.  
To summarize, static typing has the following advantages:
* easier for the programmer to debug their code
* never run into type errors
* easier to understand and reason  

```java
String h = 5 + "horse";
int h = 5 + "horse";   //compiler error
System.out.println(5 + "10");   //510
System.out.println(5 + 10);   //15
```

#### 1.1.5 Functions
Here is a comparison:  
* Python function:

  ```python
  def larger(x,y):
    if x > y: 
        return x
    return y
    print (larger(8,10))
  ```

* Java function:

  ```java
  public class LargerDemo {
    public static int larger(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }
  
    public static void main(String[] args) {
        System.out.println(larger(8, 10));
    }
  }
  ```

#### 1.1.6 Comments
Comments are always needed to describe your codes.  
* Line comments: `//` 
* Block comments: `/*` and `*/`.
* Javadoc comments: `/**` and `*/`.  
    One special note here is that almost all methods and classes should be described by **Javadoc**. 

### 1.2 Objects

### Defining and Using Classes

#### 1.2.1 Static and NOn-Static Methods

**Static Methods**  
All code in Java must be part of a class. Here's an example:  
```java
public class Dog {
    public static void makeNoise() {
        System.out.println("Bark!");
    }
}
```
To run the class, either will do:  
* to add a `main` method inside `Dog` class
* to create a "**client**" class `DogLauncher` that runs methods from the `Dog` class.
  ```java
   public class DogLauncher {
    public static void main(String[] args) {
        Dog.makeNoise();
    }
  }
  ```