Задача: Закрутить 2d массив в спираль

![img_1.png](img_1.png)  
Клиентский код:

```
Generator generator =new Generator(10,5, AlgorithmsList.SPIRAL);
generator.printArray();
System.out.println("=".repeat(20));
generator.changeAlgorithmGeneration(AlgorithmsList.CLASSIC_FILL);
generator.printArray();
```

Способ решения:  
Чередование четырех функций: вправо - вниз - назад - вверх

Работает с любым 2d массивом. Будь то квадрат или прямоугольник.

**Особенности:**

- расширяемость алгоритмов генерации массива за счет паттерна Bridge
- Основной класс Generator содержит фабричные метод.   
  Дает возможность применять различные способы генерации массивов. Унифицированное решение.

Тесты:  
![img_2.png](img_2.png)

