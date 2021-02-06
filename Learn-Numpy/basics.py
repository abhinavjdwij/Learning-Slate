import numpy as np
from description_utils import describe


if __name__ == '__main__':
    print('Hello, Numpy!', end='\n\n')
    a = np.array([1, 2, 3])
    describe(a)
    b = np.array([[10, 20, 30], [1, 2, 3]], dtype='int16')
    describe(b)
