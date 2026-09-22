import unittest
from main import recursive, bitmask, countcalls

class TestCombinations(unittest.TestCase):

    def test0element(self):
        rec_count, rec_calls = recursive([])
        self.assertEqual(rec_count, 1)
        self.assertEqual(bitmask([]), 1)
        self.assertEqual(rec_calls, 1)
    def test1element(self):
        rec_count, rec_calls = recursive([1])
        self.assertEqual(rec_count, 2)
        self.assertEqual(bitmask([1]), 2)
        self.assertEqual(rec_calls, 3)
    def testmany(self):
        for n in range(2, 10):
            opt = list(range(n))
            rec_count, rec_calls = recursive(opt)
            self.assertEqual(rec_count, 2 ** n)
            self.assertEqual(bitmask(opt), 2 ** n)
            self.assertEqual(rec_calls, 2 ** (n + 1) - 1)
    def testcountcalls(self):
        for n in range(10):
            self.assertEqual(countcalls(n), 2 ** (n + 1) - 1)

if __name__ == "__main__":
    unittest.main()