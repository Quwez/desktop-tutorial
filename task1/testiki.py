import unittest

from main import recursive
from main import bitmask
from main import recursivevizov


class TestCombinations(unittest.TestCase):
    def test0(self):
        opt = []
        self.assertEqual(recursive(opt), 1)
        self.assertEqual(bitmask(opt), 1)

    def test1(self):
        opt = [1]
        self.assertEqual(recursive(opt), 2)
        self.assertEqual(bitmask(opt), 2)

    def test2(self):
        for n in range(2, 10):
            opt = list(range(n))
            self.assertEqual(recursive(opt), 2 ** n)
            self.assertEqual(bitmask(opt), 2 ** n)

    def testrecursivevizov(self):
        for n in range(10):
            self.assertEqual(recursivevizov(n), 2 ** (n + 1) - 1)

if __name__ == "__main__":
    unittest.main()