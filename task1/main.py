def recursive(n):
    count = 0

    def generate(i):
        nonlocal count

        if i == n:
            count += 1
            return

        generate(i + 1)
        generate(i + 1)

    generate(0)

    return count

def bitmask(n):
    count = 0

    for mask in range(2 ** n):
        count += 1

    return count
def recursivevizov(n):
    if n == 0:
        return 1

    return 2 * recursivevizov(n - 1) + 1


if __name__ == "__main__":
    n = 3

    print("Рекурсивный способ:", recursive(n))
    print("Битовые маски:", bitmask(n))
    print("Рекурсивные вызовы:", recursivevizov(n))