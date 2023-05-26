# Data Structure with Java
- - -
author: Kevin Shuey  
title: Notes for Data Structure with Java  
date: 2023-05-05  
ref: ucb_CS61B
- - -

**Coverage:**  

[1. Intruduction to Java](#1)  
[2. Lists](#2)   


## 1. <span id='1'>Intruduction to Java</span>

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
$ java HelloWorld
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

#### 1.2.1 Static and Non-Static Methods

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

**Instance Variables and Object Instantiation**

Here is an example of instantiation:
```java
public class Dog {
    public int weightInPounds;

    public void makeNoise(){
        if (weightInPounds < 10) {
            System.out.println("yipyipyip!");
        } else if(weightInPounds < 30) {
            System.out.println("bark, bark");
        } else{
            System.out.println("woof!");
        }
    }
}
public class DogLauncher {
    public static void main(String[] args) {
        Dog d;
        d = new Dog();
        d.weightInPounds = 20;
        d.makeNoise()    
    }
}
```
Some key observations and terminology:
* An `object` in Java is an instance of any class.
* Variables and methods of a class are **members** of a class.
* The `Dog` class has its own variables, known as **instance variables**, or **non-static variables**.
* The nethod inside `Dog` class has no `static` keyword, which is called **instance methods**.
* To call the `makeNoise` method, we have to first **instantaite** a `Dog` using keyword `new`, and then call `d.makeNoise` instead of `Dog.makeNoise`.  

**Constructors in Java**  

For example:  
```java
public class Dog {
    public int weightInPounds;    // Instance variable (as many as you want)

    public Dog(int w) {           // Constructor (how to instantiate the class)
        weightInPounds = w;         
    }

    public void makeNoise() {     // Non-static method (invoked by an instance of the class)
        if (weightInPounds < 10) {
            System.out.println("yipyipyip!");
        } else if (weightInPounds < 30) {
            System.out.println("bark. bark.");
        } else {
            System.out.println("woof!");
        }    
    }
}
```
A constructor could be used to construct objects in Java.  
* The constructor will be invoked anytime that we try to create a `Dog` using the new keyword and a single integer parameter. 
* The constructor is very similar to the `__init__` method in Python.  

For example:
```java
public class DogLauncher {
    public static void main(String[] args) {
        Dog d = new Dog(20);        //Declaration, instatiation and assignment
        d.makeNoise();
    }
}
```

**Array Instantiation, Arrays of Objects**  
* Create an array that can hold two `Dog` objects.
* Create each actual `Dog` for arrays of instantiated objects in Java

For example:  
```java
public class DogArrayDemo {
    public static void main(String[] args) {
        /* Create an array of two dogs. */
        Dog[] dogs = new Dog[2];
        dogs[0] = new Dog(8);
        dogs[1] = new Dog(20);

        dogs[0].makeNoise();
    }
}
```

#### 1.2.2 Class Methods and Instance Methods
Java allows two types of methods:
* **Class methods**, aka static methods: invoked using the class name  
  ```java
  public static Dog maxDog(Dog d1, Dog d2) {
      if (d1.weightInPounds > d2.weightInPounds) {
          return d1;
      }
      return d2;
   }
    
    Dog d = new Dog(15);
    Dog d2 = new Dog(100);
    Dog.maxDog(d, d2);
  ```
* **Instance methods**, aka non-static methods: invoked using a specific instance variable  
  ```java
  public Dog maxDog(Dog d2) {
      if (this.weightInPounds > d2.weightInPounds) {
          return this;
      }
      return d2;
   }

  Dog d = new Dog(15);
  Dog d2 = new Dog(100);
  d.maxDog(d2);
  ```   

**Static Variables**  
It is occasionally useful for classes to have static variables.   
* Static variables should be accessed using the name of the class, e.g. `Dog.binomen`.
* While Java technically allows you to access a static variable using an instance name, it is bad style.  

For example: 
```java
public class Dog {
    public int weightInPounds;
    public static String binomen = "Canis familiaris";
    ...
}
```

#### 1.2.3 public static void main (String[] args)  
Demystification of the declaration used for the main method:  
* `public`: Most of our methods start with this keyword.
* `static`: It is a static method, not associated with any particular instance.
* `void`: It has no return type.
* `main`: Specific name of the method.
* `String[] args`: A particular parameter that is passed to the main method.

**Command Line Arguments**  
Since `main` is called by the Java interpreter itself rather than another Java class, it is the interpreter's job to supply these arguments. They refer usually to the command line arguments. 

For example:
```java
public class ArgsDemo {
    public static void main(String[] args) {
        System.out.println(args[0]);
    }
}
```
This program prints out the 0th command line argument:  
```shell
$ java ArgsDemo these are command line arguments
>>these
```

#### 1.2.4 Using Libraries  
Knowing how to find and use existing libraries is often possible to save yourself tons of work and debugging by turning to the web for help.  



## 2. <span id='2'>Lists</span>

### 2.1 Introduction

#### 2.1.1 Mystery of the Walrus  

Case 1:
```java
Walrus a = new Walrus(1000, 8.3);
Walrus b;
b = a;
b.weight = 5;
System.out.println(a);      // 5, 8.30
System.out.println(b);      // 5, 8.30
```
Case 2:
```java
int x = 5;
int y;
y = x;
x = 2;
System.out.println("x is: " + x);   // 2
System.out.println("y is: " + y);   // 5
```

**Bits**  
* All information in the computer is stored in **memory** as a sequence of binary digits.
* When declaring a variable of a certain type, it sets aside enough bits for the variable, and creates an internal table mapping each variable name to a location.
  
**The Golden Rule of Equals (GRoE)**
* When writing `y = x`, Java interpreter is told to copy the bits from x into y. 
* This simple idea of copying the bits is true for ANY assignment using `=` in Java.   

#### 2.1.2 Reference Types  

In Java, there are 8 `primitive type`s: byte, short, int, long, float, double, boolean, char. Others are thought of as a `reference type`.
* When declaring a variable of any reference type, Java allocates a box of 64 bits **refering to the address**, no matter what type of object.
* Reference Types obey GRoE as well.

#### 2.1.3 Parameter Passing
* Passing Parameters obeys the rule of **copying the bits**, also called "pass by value".
* In Java, one **always** passes by value.  

For example, the call to `doStuff` would not change `x` but `walrus` here.  
```java
public class PassByValueFigure {
    public static void main(String[] args) {
           Walrus walrus = new Walrus(3500, 10.5);
           int x = 9;

           doStuff(walrus, x);
           System.out.println(walrus);
           System.out.println(x);
    }

    public static void doStuff(Walrus W, int x) {
           W.weight = W.weight - 100;
           x = x - 5;
    }
}
```

#### 2.1.4 Instantiation of Arrays  
Instantiating an array is very similar to instantiating an object.   
For example, 
```java
int[] x;        // x can only hold the address of an int array. 
x = new int[]{0, 1, 2 ,95, 4}
                /* The new keyword creates 5 boxes of 32 bits each and   
                   returns the address of the overall object for assignment to x. */
```

####  2.1.5 IntList   
Here is the implementation of the "Linked List":  
```java
public class IntList{
    public int first;
    public IntList rest;

    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }


    /** Return the size of the list using recursion. */
    public int size(){
        if (rest == null){
            return 1;
        }
        return 1 + this.rest.size();
    }
    
    /** Return the size using no recursion. */
    public int iterativeSize(){
        IntLIst p = this;
        int totalSize = 0;
        while (p != null){
            totalSize += 1; 
            p = p.rest;
        }
        return totalSize;
    }


    /** Return the ith item of the IntList. */
    public int get(int i){
        if (i == 0){
            return first;
        return rest.get(i - 1);
        }
    }
    public static void main(String[] args){
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5,L);

        System.out.println(L.size());
        System.out.println(L.interactiveSize());
    }
}
```

Remark:  
* Syntax like `if (this == null){return 0};` won't always work, as there would be a `NullPointer` error if object L is null.   
* It is adviced to use `p` as a reminder of the variable holding a pointer. `this` cannot be reassigned in Java.     
* The method above takes linear time with respect to list size.  


### 2.2 SLList 
Here is the implementation:   
```java
public class SLList{
    private static class IntNode{
      public int item;
      public IntNode next;

      public IntNode(int i, IntNode n){
        item = i;
        next = n;
      }
    }

/* The 1st item, if exists, is at sentinel.next */
    private IntNode sentinel;
    private int size;
}

    /** Create an empty list */
    public SLList{
        sentinel = new IntNode(??, null);
        size = 0;
    }

    public SLList(int x){
        sentinel = new IntNode(??, null);
        sentinel.next = new IntNode(x, null)；
        size = 1;  
    }

    public int item;
    public IntNode next;

    public IntNode(int i, IntNode n){
        item = i;
        next = n;
    }

    /** Add x to the front of the list. */
    public void addFirst(int x){
        size += 1
        sentinel.next = new IntNode(x, sentinel.next);
    }

    /** return the first item of the list. */
    public int getFirst(){
        return sentinel.next.item();
    }

    /** Add an item to the end of the list. */
    public void addLast(int x){
        size += 1;

        IntNode p = sentinel;
        while (p.next != null){
            p = p.next
        }
        p.next = new IntNode(x, null);
    }

    /** Return the size of the list starting at IntNode P */
    private static int size(IntNode p){
        if (p.next == null){
            return 1;
        }
        return 1 + size(p.next);
    }
    public int size{
        return size(first)
    } 

 
public static void main(String[] args){
    /* Create a list of one integer 5 */
    SLList L2 = new SLList();
    L.addFirst(10);
    L.addLast(5);
    System.out.println(L.size())
}

```
 
Remark:  

**Rebranding:**
* The `SLList` hides the detail of the `null` link from the user, compares to ` IntList L1 = new IntList(5, null)`.
* While the **Naked recursion** allows the `IntList` user to potentionally have variables pointing to the middle of the structure,
`SLList` class acts as a middle man hiding user from the raw data structure.

**Private and Public:**
* `private` keyword is applied to prevent codes from other classes from using members or constructor of a class.  
* **Restricting access** is to hide implementation details from users of the class, both easier to understand and safer for later change.  
* Nested classes are useful when one class is subordinate to another class.  

**Nested Class:**
* `IntNode` class never uses any instance members of the outer class, hence keyword `static` could be applied.  

**Methods:**  
* Two methods with the same name but different signatures are overloaded and allowed in Java.         

**Caching:**
* The practice of saving important data to speed up retrieval is known as **caching**.         

**Sentinel Nodes:**
* Based on the structure containing `first`, one solution to fix `addLast` bug for the empty list is like:  
  ```java
  if (first == null){
    first = new IntNode(x, null);
    return ;
  }
* However, to keep complexity under control wherever possible, a `sentinel node` could be created to unify all cases. That's why the data structure is improved.  

**Invariants:**  
* An invariant is a fact about a data structure that is guaranteed to be true.  


### 2.3 DLList 
Here is the implementation:   
```java
public class SLList{
    private static class IntNode{
      public int item;
      public IntNode next;

      public IntNode(int i, IntNode n){
        item = i;
        next = n;
      }
    }

/* The 1st item, if exists, is at sentinel.next */
    private IntNode sentinel;
    private IntNode last;  
    private int size;
}

    /** Create an empty list */
    public SLList{
        sentinel = new IntNode(??, null);
        size = 0;
    }

    public SLList(int x){
        sentinel = new IntNode(??, null);
        sentinel.next = new IntNode(x, null)；
        size = 1;  
    }

    public int item;
    public IntNode next;

    public IntNode(int i, IntNode n){
        item = i;
        next = n;
    }

    /** Add x to the front of the list. */
    public void addFirst(int x){
        size += 1
        sentinel.next = new IntNode(x, sentinel.next);
    }

    /** return the first item of the list. */
    public int getFirst(){
        return sentinel.next.item();
    }

    /** Add an item to the end of the list. */
    public void addLast(int x){
        size += 1;

        IntNode p = sentinel;
        while (p.next != null){
            p = p.next
        }
        p.next = new IntNode(x, null);
    }

    /** Return the size of the list starting at IntNode P */
    private static int size(IntNode p){
        if (p.next == null){
            return 1;
        }
        return 1 + size(p.next);
    }
    public int size{
        return size(first)
    } 

 
public static void main(String[] args){
    /* Create a list of one integer 5 */
    SLList L2 = new SLList();
    L.addFirst(10);
    L.addLast(5);
    System.out.println(L.size())
}

```