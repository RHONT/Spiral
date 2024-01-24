Задача: Закрутить 2d массив в спираль

![img_4.png](img_4.png)
Клиентский код:

```
Generator generator =Generator.createDefault(5, 5, AlgorithmsList.SPIRAL);
System.out.println(generator.TextStatement());
System.out.println("=".repeat(20));
generator.selectAlgorithmFromEnum(AlgorithmsList.CLASSIC_FILL);
System.out.println(generator.TextStatement());
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
