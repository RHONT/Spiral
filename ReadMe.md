Задача: Закрутить 2d массив в спираль

![img_1.png](img_1.png)  
Клиентский код:

```
Generator generator =new Generator(5, 5, AlgorithmsList.SPIRAL);
generator.printArray();
System.out.println("=".repeat(20));
generator.changeAlgorithmGeneration(AlgorithmsList.CLASSIC_FILL);
generator.printArray();
```

Способ решения:  
Чередование четырех функций: вправо - вниз - назад - вверх

Работает с любым 2d массивом. Будь то квадрат или прямоугольник.

**Особенности:**
- Применен паттерн "команда"  
Инициатор: Generator  
Получатели: все наследники базового алгоритмического класса

Тесты:  
![img_2.png](img_2.png)

При желании можно запустить подготовленный jar файл.
![img_3.png](img_3.png)
