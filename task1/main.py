def recursive(opt):
    n = len(opt)
    count = 0
    calls = 0
    def generate(i, mask):
        nonlocal count, calls
        calls += 1
        if i == n:
            count += 1
            return

        generate(i + 1, mask)
        generate(i + 1, mask | (1 << i))

    generate(0, 0)
    return count, calls

def bitmask(opt):
    n = len(opt)
    count = 0
    checksum = 0
    for mask in range(2 ** n):
        count += 1
        checksum ^= mask
    return count

def countcalls(n):
    if n == 0:
        return 1
    return 2 * countcalls(n - 1) + 1


if __name__ == "__main__":
    opt = [1, 2, 3]
    cnt, calls = recursive(opt)
    print("Рекурсия (наборов):", cnt)
    print("Биты (наборов):", bitmask(opt))
    print("Реальных вызовов:", calls)
    print("Теоретических вызовов:", countcalls(len(opt)))