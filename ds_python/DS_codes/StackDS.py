class ListStack:
    """ A simple implementation of a stack using a list."""

    def __init__(self):
        """ Initialize an empty stack."""
        self.__data = list()

    def __len__(self):
        """ Return the number of elements in the stack."""
        return len(self.__data)

    def is_empty(self):
        """ Check if the stack is empty."""
        return len(self.__data) == 0

    def push(self, e):
        """ Push an element onto the top of the stack. """
        self.__data.append(e)

    def top(self):
        """ Return the element at the top of the stack."""
        if self.is_empty():
            print('The stack is empty.')
            return None
        else:
            return self.__data[-1]

    def pop(self):
        """ Remove and return the element at the top of the stack."""
        if self.is_empty():
            print('The stack is empty.')
            return None
        else:
            return self.__data.pop()


def main():
    """ Test the ListStack DS."""
    s = ListStack()
    print("The stack is empty:", s.is_empty())

    s.push(100)
    s.push(223)
    s.push(300)
    print("Check current top item:", s.top())
    print("------------------------------------")

    print(f"The top item '{s.pop()}' has been removed")
    print("Check current top item:", s.top())


if __name__ == "__main__":  # execute only when operated by "main"
    main()
