# Data Structure with Java
- - -
author: Josh Hug
editor: Kevin Shuey    
title: Notes for Data Structure with Java   
date: 2023-05-05   
ref: ucb_CS61B  
- - -

**Coverage:**  

[1. Intruduction to Java](#1)  
[2. Lists](#2)     
[3. Testing](#3)    
[4. Inheritance, Implements](#4) 


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

### 1.2 Objects (Defining and Using Classes)

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
public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using recursion. */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size using no recursion. */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Return the ith item of the IntList. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());
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
public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /** Create an empty list */
    public SLList() {
        sentinel = new IntNode(66, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(66, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Add x to the front of the list. */
    public void addFirst(int x) {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    /** Return the first item of the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Add an item to the end of the list. */
    public void addLast(int x) {
        size += 1;

        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Return the size of the list. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Create a list of one integer 5 */
        SLList L = new SLList();
        L.addFirst(10);
        L.addLast(5);
        System.out.println(L.size());
    }
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
  ```
* However, to keep complexity under control wherever possible, a `sentinel node` could be created to unify all cases. That's why the data structure is improved.  

**Invariants:**  
* An invariant is a fact about a data structure that is guaranteed to be true.  



### 2.3 DLList 

#### 2.3.1 Implementation of DLList

Here is the implementation:   
```java
public class DLList {
    private static class IntNode {
        public int item;
        public IntNode prev;
        public IntNode next;
        
        public IntNode(int i, IntNode p, IntNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private IntNode sentinel;
    private IntNode rearguard;
    private int size;

    public DLList(int x) {
        sentinel = new IntNode(66, null, null);
        rearguard = new IntNode(33, null, null);
        sentinel.next = new IntNode(x, sentinel, rearguard);
        rearguard.prev = sentinel.next;
        size = 1;
    }

    /** Create an empty list. */
    public DLList() {
        sentinel = new IntNode(66, null, null);
        rearguard = new IntNode(33, null, null);
        sentinel.next = rearguard;
        rearguard.prev = sentinel;
        size = 0;
    }

    /** Add x to the front of the list. */
    public void addFirst(int x) {
        size += 1;
        IntNode newNode = new IntNode(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
    }

    /** Return the 1st item of the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Add an item to the end of the list. */
    public void addLast(int x) {
        size += 1;
        IntNode newNode = new IntNode(x, rearguard.prev, rearguard);
        rearguard.prev.next = newNode;
        rearguard.prev = newNode;
    }

    /** Return the size of the list. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Create a list of one integer 5 */
        DLList L = new DLList(10);
        L.addFirst(10);
        L.addLast(5);
        System.out.println(L.size());
    }
}
```

Another implementation with circulated version: 
```java
public class CirList {
    private static class IntNode {
        public int item;
        public IntNode prev;
        public IntNode next;
        
        public IntNode(int i, IntNode p, IntNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    
    private IntNode sentinel;
    private int size;
    
    public CirList(int x) {
        sentinel = new IntNode(66, null, null);
        sentinel.next = new IntNode(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /** Create an empty list. */
    public CirList() {
        sentinel = new IntNode(66, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Add x to the front of the list. */
    public void addFirst(int x) {
        size += 1;
        IntNode newNode = new IntNode(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
    }

    /** Return the 1st item of the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Add an item to the end of the list. */
    public void addLast(int x) {
        size += 1;
        IntNode newNode = new IntNode(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
    }
    
    /** Return the size of the list. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Create a list of one integer 5 */
        CirList L = new CirList(10);
        L.addFirst(10);
        L.addLast(5);
        System.out.println(L.size());
    }
}
```

Remark:

**addLast**
* `addLast` and `getLast` could be fast, but `removeLast` could not, as there is no easy way to get the **second-to-last node**.  
* For example, `addLast` could be advanced like:
  ```java
  public void addLast(int x) {
        last.next = new IntNode(x, null);
        last = last.next;
        size += 1;
    }
    ```
**Back Pointers**
Back pointers allow a list to support adding, getting, and removing the front and back of a list in constant time, with `prev` and `next`.

**Sentinel Upgrade**
There is a subtle issue  where the last pointer sometimes points at the sentinel node, and sometimes at a real node:
* One fix is to add a second sentinel node to the **back** of the list. 
* An alternate approach is to implement the list so that it is **circular**, with the front and back pointers sharing the same sentinel node.

#### 2.3.2 Generic DLLists

To implement a **generic list**, codes could be replaced like:  
```java
public class GenDLList<LochNess> {
    private class PubNode {
        public LochNess item;
        public PubNode prev;
        public PubNode next;
        
        public PubNode(LochNess i, PubNode p, PubNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    
    private PubNode sentinel;
    private int size;
    
    public GenDLList(LochNess x) {
        sentinel = new PubNode(null, null, null);
        sentinel.next = new PubNode(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }
}
```

A special syntax is also needed to initiate the class. Remember to use **reference types** instead of **peimitives**, that is, `Integer` instead of `int`.
```java
DLList<Integer> d1 = new DLList<>(5);
d1.insertFront(10);
```

Some rules working with generic lists:
* Always try to use `Integer`, `Double`, `Character`, `Boolean`, `Long`, `Short`, `Byte`, or `Float` instead of primitive equivalents.
* In the `.java` file implementing a data structure, specify your generic type name only once at the very top of the file after the class name.
* In other `.java` files using data structure, specify the specific desired type during declaration, and use the empty diamond operator during instantiation.
* Though redundant, the one below is also perfectly valid:  
  `DLList<Integer> d1 = new DLList<Integer>(5);`

### 2.4 Arrays

#### 2.4.1 Array Knowledge

**Array Basics**
Arrays are a special type of object that consists of a numbered sequence of memory boxes.   

Arrays consist of  
* A fixed integer length, N  
* A sequence of N memory boxes of **the same type**, and are numbered **0 through (N - 1)**.  

Unlike classes, arrays do **NOT** have methods.

**Array Creation**
There valid notations:  
* Create array containing 3 int boxes with default value:   
  `x = new int[3];` 
* `y = new int[]{1, 2, 3, 4, 5};`
* `new` could be omited  foe declaring a vlue:    
  `int[] z = {9, 10, 11, 12, 13};`


**Array Access and Modification**
Understand following codes well:  
```java
int[] z = null;
int[] x, y;

x = new int[]{1, 2, 3, 4, 5};
y = x;
x = new int[]{-1, 2, 5, 4, 99};
y = new int[3];
z = new int[0];
int xL = x.length;

String[] s = new String[6];
s[4] = "ketchup";
s[x[3] - x[1]] = "muffins";

int[] b = {9, 10, 11};
System.arraycopy(b, 0, x, 3, 2);
```

For `Arraycopy`, it is likely to be faster compared to "item by item with a loop":  
```java
System.arraycopy(b, 0,x, 3, 2)  // Java
```
which is the equivalent of  
```python
x[3:5] = b[0:2]  # Python
```

**2D Arrays**

Understand following codes well:  
```java
int[][] pascalsTriangle;
pascalsTriangle = new int[4][];
int[] rowZero = pascalsTriangle[0];

pascalsTriangle[0] = new int[]{1};
pascalsTriangle[1] = new int[]{1, 1};
pascalsTriangle[2] = new int[]{1, 2, 1};
pascalsTriangle[3] = new int[]{1, 3, 3, 1};
int[] rowTwo = pascalsTriangle[2];
rowTwo[1] = -5;

int[][] matrix;
matrix = new int[4][];
matrix = new int[4][4];

int[][] pascalAgain = new int[][]{{1}, {1, 1},
                        {1, 2, 1}, {1, 3, 3, 1}};
            
```

**Arrays vs Classes**
The key differences between memory boxes in arrays and classes:
* Array boxes are numbered and accessed using `[]` notation, and class boxes are named and accessed using dot notation.  
* Array boxes must all be the same type. Class boxes can be different types. 
 
One particularly impact is that `[]` notation allows specifying index at runtime.   
For example, consider the code below:
```java
int indexOfInterest = askUserForInteger();
int[] x = {100, 101, 102, 103};
int k = x[indexOfInterest];
System.out.println(k);
```
It is forbidden as follows:  
```java
String fieldOfInterest = "mass";
Planet p = new Planet(6e24, "earth");
double mass = p[fieldOfInterest];
```
or `double mass = p.fieldOfInterest;`

There is a way to specify desired fields at runtime called **reflection**, but it is considered very bad coding style for typical programs.  

**Arrays in Java**
Compared to arrays in other languages, Java arrays:
* Have no special syntax for "slicing" (such as in `Python`).
* Cannot be shrunk or expanded (such as in `Ruby`).
* Do not have member methods (such as in `Javascript`).
* Must contain values only of the same type (unlike `Python`).
 

#### 2.4.2 AList
Here is the implementation:
```java
public class AList<Item> {
    private Item[] items;
    private int size;

    /** Create an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }


    /** Insert an item to the end of the list. */
    public void addLast(Item x) {
        items[size] = x;
        size += 1;
    }

    /** Adjust the size of the list. */
    private void resize(int capacity) {
        int[] a = new int[capacity];
        System.arraycopy(items, 0, a, 0, size);

    }

    /** Insert an item at the end of thelist, even if out-of-range. */
    public void insertBack(Item x) {
        int RFACTOR = 2;
        if (size == items.length) {
               resize(size * RFACTOR);
        }
        items[size] = x;
        size += 1;
    }

    /** Return the last item of the list. */
    public Item getLast() {
        return items[size - 1];
    }

    /** Get the (i+1)th item of the list. */
    public Item get(int i) {
        return items[i];
    }

    /** Return the size of the list. */
    public int size() {
        return size;
    }
    
    /** Delete item from back of the list and return deleted item. */
    public Item deleteBack() {
        Item x = getLast();
        items[size - 1] = null;
        size -= 1;
        return x;
    }
}
```

**Linked List Performance**
Since there are only references to the `first` and `last` items of the list, the worst case execution time for `get` or `getBack` is linear in the size of the entire list.

**Naive Array Based List**
ALists have constant time access, with invariants as follows:
* The position of the next item to-be-inserted is always `size`.
* The number of items in the AList is always `size`.
* The position of the last item in the list is always `size - 1`.

**removeLast**
To remove the last item, decide which of `size`, `items`, and `items[i]` needs to change so that our invariants are preserved after the operation.  
As `size` has been decreased by 1, the last `int` item has logically been deleted. `items[size - 1] = null;` will not do any harm, but not necessary.  
However, for `objects` it is not the case. Recall that Java only destroys objects when the last reference has been lost. That is why reference should be nulled out to avoid "lotering".

**Resizing the array**
The naive array list shows a parabola, for following implements:
```java
public void insertBack(int x) {
    if (size == items.length) {
        resize(size + 1);
    }
    items[size] = x;
    size += 1;
}
```

The performance problems could be fixed by growing the size of our array by a **multiplicative** amount, rather than an **additive** amount, which is how `Python` works:   
```java
public void insertBack(int x) {
    if (size == items.length) {
           resize(size * RFACTOR);
    }
    items[size] = x;
    size += 1;
}
```

Also, the size of the array should be halved when ratio R falls to less than 0.25.
R = (size of the list) / (length of the items array)

**Generic ALists**
Java does not allow us to create an array of generic objects due to an obscure issue with the way generics are implemented. So we need to use technic `cast`:
```java
Item[] items = (Item []) new Object[8];
```

The other change is that any "delete" items should be nulled out.


## 3. <span id='3'>Utilities</span>

### 3.1 Testing
Programmers knows theire codes work based on tests they write.
* Unit Test: A softwre method by which individual units of source code are tested to determine whether they are fit for use.  
  For example, `JUnit`, `AssertJ`, and `Truth`.

Here is the Testing Demo with `Truth`:
```java
package Sort;

import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

public class TestSort {
    /** Test the sort method of the sort class. */
    @Test
    public void testSort() {
        String[] input = {"rawr", "a", "zaza", "newway"};
        String[] expected = {"a","newway", "rawr", "zaza"};
        Sort.sort(input);
        
        assertThat(input).isEqualTo(expected);
    }
}
```

### 3.2 Coding Philosophy

### 3.3 Debugging


## 4. <span id='4'>Inheritance, Implements</span>

Consider a method:
```java
public static String longest(SLList<String> list) {
    int maxDex = 0;
    for (int i = 0; i < list.size(); i += 1) {
        String longestString = list.get(maxDex);
        String thisString = list.get(i);
        if (thisString.length() > longestString.length()) {
            maxDex = i;
        }
    }
    return list.get(maxDex);
}
```

Actually, implemented by `ALList` is also OK, i.e. changing the parametre to ` AList<String> list`.  
If there are these two methods in the same class, it is actually allowed, which is called *overloading* in Java.  
However, overloading has several downsides:  
* Super repetitive and ugly.  
* More codes to maintain, especially for possible partial correction when debugging.  
* Inconvenient for more list types.  

**Hypernyms, Hyponyms, and Interface Inheritance**

Similar to what it is like in language, formalize this relationship in Java:     
If a SLList is a hyponym of List61B, then the SLList class is a **subclass** of the List61B class and the List61B class is a **superclass** of the SLList class.   

Here is the List61B interface and establish the relationship hierarchy.

**Step 1: Create a hypernym**
```java
public interface List61B<Item> {
    public void addFirst(Item x);
    public void add Last(Item y);
    public Item getFirst();
    public Item getLast();
    public Item removeLast();
    public Item get(int i);
    public void insert(Item x, int position);
    public int size();
}
```

**Step 2: specify hyponyms of the class**

Add to `public class AList<Item> {}` as
`public class AList<Item> implements List61B<Item>{}`.


**Overriding**
If a subclass has a  method with the same signature as in the superclass, then the subclass **overrides** the method.
* `Animal`'s subclass `Pig` overrides the `makeNoise()` method.
  ```java 
  public interface Animal {
    public void makeNoise();
  }

  public class Pig implements Animal {
    public voide makeNoide() {
        System.out.print("oink");
    }
  }
  ```

* `makeNoise` is **overloaded**, with the same name but different signatures.
  ```java
  public class Dog implements Animal {
    public void makeNoise(Dog x) {}
  }
  ```
   
For CS61B, mark every method with the `@Override` annotation in case the code won't compile unless it is actually an overriding method.    
Reason:
* Protect against typos, which would raise error.  
* Remind that the method definition came from higher heritance. 

**Interface Inheritance**

With the usage of keyword `implements`,    
* All sub-classes are said to inherit the interface from the super-class.     
* Interface consists of all the method signatures.   

With the philosophy of GRoE, `AList` is able to fit into a `List61B` box well since `AList` share an "is-a" relationship with `List61B`.

**Implementation Inheritance**

Compared to interface interitance where subclass inherits signatures but NOT implementation, use `default` keyworf to specify a method that subclasses shoulf inherit from an interface, which is called **implementation inheritance**, inheriting signatures AND implementation.

