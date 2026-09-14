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


if __name__ == "__main__":
    n = 3

    print("Количество наборов:", recursive(n))