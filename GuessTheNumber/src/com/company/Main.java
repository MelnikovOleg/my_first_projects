/*
'Guess The Number' - игра, в которой пользователю предстоит угадать число от 1 до 100 включительно.
Автор: MelnikovOleg
Версия от 18.07.2018
 */

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int number = 1 + (int) (Math.random() * 99); // Генерируем число
        int user_number = 0; // Число пользователя по умолчанию
        int level;
        int attempt = 0;

        System.out.println("Угадай число");
        System.out.println("Укажите уровень сложности (введите порядковый номер):");
        System.out.println("1. Легкий (10 попыток).");
        System.out.println("2. Средний (7 попыток).");
        System.out.println("3. Трудный (5 попыток). \n");

        while (attempt == 0) try {
            Scanner input_level = new Scanner(System.in);
            level = input_level.nextInt();

            if (level < 1 || level > 3) {
                System.out.println("Ошибка! Введите корректный уровень сложности!");
                continue;
            }
            switch (level) {
                case 1:
                    attempt = 10;
                    break;
                case 2:
                    attempt = 7;
                    break;
                case 3:
                    attempt = 5;
                    break;
            }
        } catch (Exception e) {
            System.out.println("Ошибка! Необходимо ввести номер уровня");
            continue;
        }

        System.out.println("Попробуйте угадать число от 1 до 100 включительно!");

        // Запускаем цикл и выполняем программу до тех пор, пока введённое число не будет равно сгенерированному числу
        while (attempt != 0){
            System.out.println("Введите число: ");

            // Проверяем корректность ввода данных
            try {
                Scanner input = new Scanner(System.in);
                user_number = input.nextInt();
            } catch (Exception e){
                System.out.println("Ошибка! Необходмо ввести число!");
                continue; // Начинаем итерацию сначала
            }

            if (user_number > 100 || user_number < 0) {
                System.out.println("Ошибка! Необходимо ввести число в диапазоне от 1 до 100!");
                continue;
            }
            if (user_number != number){
                attempt--;
                System.out.println("Неверно! Осталось попыток: " + attempt);
            }
            if (user_number > number) System.out.println("Загаданное число меньше!");
            else if (user_number < number) System.out.println("Загаданное число больше!");
            else {
                System.out.println("Поздравляем! Вы угадали!");
                break;
            }
            if (attempt == 0) System.out.println("Вы проиграли! Загаданное число: " + number);

        }

    }
}
