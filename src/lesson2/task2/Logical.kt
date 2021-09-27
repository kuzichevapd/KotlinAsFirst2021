@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr
import kotlin.math.abs


/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean =
    (((number / 1000) + ((number / 100) % 10)) == (((number / 10) % 10) + (number % 10)))


/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    if ((x1 == x2) || (y1 == y2) || (abs(x1 - x2) == abs(y1 - y2))) return true
    else return false

}


/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    if ((month == 2) && (year % 4 != 0)) return 28
    if ((month == 2) && ((year % 100 == 0) && (year % 400 != 0))) return 28
    if ((year % 4 == 0) && (month == 2)) return 29
    if ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12)) return 31
    if ((month == 4) || (month == 6) || (month == 9) || (month == 11)) return 30
    else return 0

}

/**
 * Простая (2 балла)
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean =
    (kotlin.math.sqrt((sqr(x1 - x2) + sqr(y1 - y2))) + r1 <= r2)


/**
 * Средняя (3 балла)
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun maxOf(a: Int, b: Int, c: Int): Int {
    if (kotlin.math.max(a,b) == a) return kotlin.math.max(a,c) else return kotlin.math.max(b,c)

}
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean = when {
    maxOf(a,b,c) == a -> if ((kotlin.math.min(b,c) <= kotlin.math.min(r,s)) && (kotlin.math.max(b,c) <= kotlin.math.max(r,s))) true else false
    maxOf(a,b,c) == b -> if ((kotlin.math.min(a,c) <= kotlin.math.min(r,s)) && (kotlin.math.max(a,c) <= kotlin.math.max(r,s))) true else false
    maxOf(a,b,c) == c -> if ((kotlin.math.min(a,b) <= kotlin.math.min(r,s)) && (kotlin.math.max(b,a) <= kotlin.math.max(r,s))) true else false
    else -> if ((a <= r) && (a <= s)) true else false
}
