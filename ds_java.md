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
Some key obobservations and terminology:
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