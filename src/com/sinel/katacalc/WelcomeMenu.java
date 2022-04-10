//Класс просто выводит сообщения приветствия и справки

package com.sinel.katacalc;

class WelcomeMenu {

//Приветствие
    public static void hello() {
        System.out.println("--------------------------------------------");
        System.out.println("Добро пожаловать в Ката - Калькулятор (◕‿◕)");
        System.out.println("--------------------------------------------");
        System.out.println("\nкалькулятор работает с арабскими и римскими цифрами от 1 до 10");
        System.out.println("умеет: Сложение(+), Вычитание(-), Умножение(*), Деление(/)");
        System.out.println("\n---> Чтобы закрыть программу, введите 'exit' и нажмите ENTER"+
                "\n---> Для справки введите '?' и нажмите ENTER");
        System.out.println("\nПогнали! Удачи! ٩(★‿★)۶");
    }

//Справка
    public static void info() {
        System.out.println("\nВажно! ЧИСЛА НЕ ДОЛЖНЫ БЫТЬ МЕНЬШЕ 1 или БОЛЬШЕ 10!" +
                "\nОТРИЦАТЕЛЬНЫЕ ЧИСЛА НЕ ПРИНИМАЮТСЯ" +
                "\nОБА ЧИСЛА ДОЛЖНЫ БЫТЬ ОДИНАКОВОГО ТИПА" +
                "\nТо есть не смешивайте арабские и римские числа, выберите что-то одно ¯\\_(ツ)_/¯" +
                "\nРезультат для римских чисел не может быть отрицательным" +
                "\nНапример: 10+5 или III*VI (это правильный ввод)" +
                "\nА это не правильный: II+2 или I-V");
    }
}
