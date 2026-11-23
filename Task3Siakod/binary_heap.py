class BinaryHeap:
    def __init__(self, items=None, key=None, is_max=False):
        self.key = key if key is not None else (lambda x: x)
        self.is_max = is_max
        self.data = list(items) if items is not None else []
        if self.data:
            self.heapify()

    def size(self):
        return len(self.data)

    def peek(self):
        if not self.data:
            raise IndexError("Куча пуста")
        return self.data[0]

    def push(self, item):
        self.data.append(item)
        self._sift_up(len(self.data) - 1)

    def pop(self):
        if not self.data:
            raise IndexError("Куча пуста")
        top = self.data[0]
        last = self.data.pop()
        if self.data:
            self.data[0] = last
            self._sift_down(0)
        return top

    def replace_top(self, item):
        if not self.data:
            raise IndexError("Куча пуста")
        top = self.data[0]
        self.data[0] = item
        self._sift_down(0)
        return top

    def heapify(self):
        for i in range(len(self.data) // 2 - 1, -1, -1):
            self._sift_down(i)

    def _compare(self, a, b):
        val_a = self.key(a)
        val_b = self.key(b)
        if self.is_max:
            return val_a > val_b
        return val_a < val_b

    def _sift_up(self, idx):
        while idx > 0:
            parent = (idx - 1) // 2
            if self._compare(self.data[idx], self.data[parent]):
                self.data[idx], self.data[parent] = self.data[parent], self.data[idx]
                idx = parent
            else:
                break

    def _sift_down(self, idx):
        n = len(self.data)
        while True:
            best = idx
            left = 2 * idx + 1
            right = 2 * idx + 2

            if left < n and self._compare(self.data[left], self.data[best]):
                best = left
            if right < n and self._compare(self.data[right], self.data[best]):
                best = right

            if best != idx:
                self.data[idx], self.data[best] = self.data[best], self.data[idx]
                idx = best
            else:
                break