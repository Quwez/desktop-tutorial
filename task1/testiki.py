import unittest

from main import recursive
from main import bitmask
from main import recursivevizov


class TestCombinations(unittest.TestCase):
    def test0(self):
        self.assertEqual(recursive(0), 1)
        self.assertEqual(bitmask(0), 1)

    def test1(self):
        self.assertEqual(recursive(1), 2)
        self.assertEqual(bitmask(1), 2)

    def test2(self):
        for n in range(2, 10):
            self.assertEqual(recursive(n), 2 ** n)
            self.assertEqual(bitmask(n), 2 ** n)

    def testrecursivevizov(self):
        for n in range(10):
            self.assertEqual(recursivevizov(n), 2 ** (n + 1) - 1)
            
if __name__ == "__main__":
    unittest.main()