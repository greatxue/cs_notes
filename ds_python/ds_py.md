# Data Structure with Python
- - -  
author: Tianshu Yu      
editor: Kevin Shuey       
title: Data Structure with Python     
date: 2023-06-03          
ref: CSC1002     
- - -
## Stack
**Introduction:**  
* A stack is a collection of objects that are inserted and removed according to the **last-in, first-out (LIFO)** principle.
* A user may insert into the stack and remove only the *top* of the stack.

**Implementation:**  
```python
class ListStack:
    def __init__(self):
        self.__data = list()

    def __len__(self):
        return len(self.__data)

    def is_empty(self):
        return len(self.__data) == 0

    def push(self,e):
        self.__data.append(e)

    def top(self):
        if self.is_empty():
            print('The stack is empty.')
        else:
            return self.__data[self.__len__()-1]
    
    def pop(self):
        if self.is_empty():
            print('The stack is empty.')
        else:
            return self.__data.pop()
```


