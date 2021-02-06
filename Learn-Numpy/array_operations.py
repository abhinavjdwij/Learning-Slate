import numpy as np
from description_utils import describe

if __name__ == '__main__':
    a = np.array([[1, 2, 3], [10, 20, 30]])
    describe(a)
    # Get an element notation (uses comma)
    print(a[1, 1])
    # Get a row
    print(a[1, :])
    # Get a column
    print(a[:, 2])