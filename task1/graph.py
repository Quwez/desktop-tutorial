import matplotlib.pyplot as plt

size = [8, 16, 32, 64, 128, 160, 176]

rectime = [
    600,
    900,
    2500,
    34900,
    9525300,
    153620100,
    611081200
]

bittime = [
    400,
    400,
    600,
    4900,
    2448900,
    39335500,
    155133400
]


plt.plot(size, rectime, marker="o", label="Рекурсия")
plt.plot(size, bittime, marker="o", label="Битовые маски")

plt.xlabel("Размер входных данных, байт")
plt.ylabel("Время, нс")
plt.title("Зависимость времени работы от размера данных")

plt.legend()
plt.grid()

plt.show()