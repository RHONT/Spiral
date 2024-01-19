Задача: Закрутить 2d массив в спираль

![img_1.png](img_1.png)

Способ решения:  
Чередование четырех функций: вправо - вниз - назад - вверх

Работает с любым 2d массивом. Будь то квадрат или прямоугольник.

**Особенности:**
- расширяемость алгоритмов генерации массива за счет паттерна Bridge
- Основной класс Generator содержит фабричные метод.   
Дает возможность применять различные способы генерации массивов. Унифицированное решение.

Тесты:  
![img.png](img.png)

