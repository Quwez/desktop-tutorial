import time
import statistics
import random
from main import recursive, bitmask

def makeoptions(n):
    return [random.randint(0, 1000000) for _ in range(n)]

def measure(func, options):
    warm = options if len(options) <= 16 else options[:16]
    for _ in range(3):
        func(warm)
    times = []
    for _ in range(5):
        start = time.perf_counter_ns()
        result = func(options)
        end = time.perf_counter_ns()
        times.append(end - start)
        if type(result) == tuple:
            result = result[0]
        expected = 2 ** len(options)
        if result != expected:
            raise RuntimeError(f"Ошибка: {result} вместо {expected}")
    return statistics.median(times)

sizes = [1, 2, 4, 8, 16, 20, 22, 24]

print("n,size_bytes,recursive_ns,bitmask_ns")

for n in sizes:
    options = makeoptions(n)
    t_rec = measure(recursive, options)
    t_bit = measure(bitmask, options)
    size_bytes = n * 8
    print(f"{n},{size_bytes},{t_rec},{t_bit}")