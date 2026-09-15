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

if __name__ == "__main__":
    n = 5

    print("Рекурсивный способ:", recursive(n))
    print("Битовые маски:", bitmask(n))