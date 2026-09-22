import matplotlib.pyplot as plt

sizes = [8, 16, 32, 64, 128, 160, 176, 192]
rectimes = [600, 900, 2500, 34900, 9525300, 153620100, 611081200, 2503171100]
bittimes = [400, 400, 600, 4900, 2448900, 39335500, 155133400, 618338900]
recms = [t / 1_000_000 for t in rectimes]
bitms = [t / 1_000_000 for t in bittimes]
plt.plot(sizes, recms, marker='o', label='Рекурсия')
plt.plot(sizes, bitms, marker='s', label='Биты')
plt.yscale('log')
plt.xlabel('Размер (байты)')
plt.ylabel('Время (мс)')
plt.title('Время работы алгоритмов')
plt.legend()
plt.grid(True)
plt.show()