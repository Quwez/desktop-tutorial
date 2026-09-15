import time
import statistics
import random

from main import recursive
from main import bitmask


def makeopt(n):
    return [random.randint(0, 1000000) for i in range(n)]


def measure(func, opt):
    for i in range(3):
        func(opt)

    times = []

    for i in range(5):
        start = time.perf_counter_ns()

        result = func(opt)

        end = time.perf_counter_ns()

        times.append(end - start)

        if result != 2 ** len(opt):
            raise RuntimeError("Ошибка")

    return statistics.median(times)


sizes = [1, 2, 4, 8, 16, 20, 22]

print("n,size,recursive,bitmask")

for n in sizes:
    opt = makeopt(n)

    t1 = measure(recursive, opt)
    t2 = measure(bitmask, opt)

    size = n * 8

    print(n, size, t1, t2, sep=",")