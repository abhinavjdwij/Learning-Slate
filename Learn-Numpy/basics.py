import numpy as np


def describe(x):
    print(x)
    print(x.ndim)  # get dimensions
    print(x.shape)  # get shape of matrix
    print(x.dtype)  # get datatype
    print(x.itemsize) # get itemsize
    print()


if __name__ == '__main__':
    print('Hello, Numpy!', end='\n\n')
    a = np.array([1, 2, 3])
    describe(a)
    b = np.array([[10, 20, 30], [1, 2, 3]], dtype='int16')
    describe(b)
