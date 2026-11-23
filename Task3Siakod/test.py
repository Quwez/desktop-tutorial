import unittest
from binary_heap import BinaryHeap
from solver import Task, read_tasks, solve


def check_heap_invariant(test, heap):
    arr = heap.data
    for i in range(len(arr)):
        left = 2 * i + 1
        right = 2 * i + 2
        if left < len(arr):
            test.assertFalse(heap._compare(arr[left], arr[i]))
        if right < len(arr):
            test.assertFalse(heap._compare(arr[right], arr[i]))


class TestHeapAndSolver(unittest.TestCase):
    def test_min_heap_and_invariant(self):
        h = BinaryHeap([5, 3, 8, 1, 2])
        check_heap_invariant(self, h)
        self.assertEqual(h.size(), 5)
        self.assertEqual(h.peek(), 1)

        h.push(0)
        check_heap_invariant(self, h)
        self.assertEqual(h.peek(), 0)

        old = h.replace_top(4)
        self.assertEqual(old, 0)
        check_heap_invariant(self, h)
        self.assertEqual(h.peek(), 1)

        res = [h.pop() for _ in range(h.size())]
        self.assertEqual(res, [1, 2, 3, 4, 5, 8])

    def test_max_heap_custom_key(self):
        h = BinaryHeap([("a", 10), ("b", 25), ("c", 15)], key=lambda x: x[1], is_max=True)
        check_heap_invariant(self, h)
        self.assertEqual(h.pop(), ("b", 25))
        check_heap_invariant(self, h)

    def test_empty(self):
        self.assertEqual(solve([]), [])

    def test_exact_deadline(self):
        tasks = [
            Task("t1", 4, 4, 0),
            Task("t2", 6, 10, 1),
        ]
        self.assertEqual(solve(tasks), ["t1", "t2"])

    def test_zero_and_impossible_deadlines(self):
        tasks = [
            Task("zero", 1, 0, 0),
            Task("impossible", 10, 5, 1),
            Task("ok", 3, 5, 2),
        ]
        self.assertEqual(solve(tasks), ["ok"])

    def test_evict_previous_long_task(self):
        tasks = [
            Task("long", 8, 8, 0),
            Task("short1", 3, 9, 1),
            Task("short2", 4, 9, 2),
        ]
        self.assertEqual(solve(tasks), ["short1", "short2"])

    def test_equal_duration_and_deadline_evicts_later(self):
        tasks = [
            Task("first", 5, 5, 0),
            Task("second", 5, 5, 1),
        ]
        self.assertEqual(solve(tasks), ["first"])

    def test_jsonl_parsing_and_deadlines(self):
        lines = [
            '{"id": "export-0", "duration": 5, "deadline": 10}',
            '{"id": "export-1", "duration": 7, "deadline": 8}',
            '{"id": "export-2", "duration": 2, "deadline": 8}',
            '{"id": "export-3", "duration": 3, "deadline": 11}',
        ]
        tasks = read_tasks(lines)
        ans = solve(tasks)
        self.assertEqual(ans, ["export-2", "export-0", "export-3"])

        by_id = {t.id: t for t in tasks}
        time_spent = 0
        for tid in ans:
            time_spent += by_id[tid].duration
            self.assertLessEqual(time_spent, by_id[tid].deadline)


if __name__ == "__main__":
    unittest.main()