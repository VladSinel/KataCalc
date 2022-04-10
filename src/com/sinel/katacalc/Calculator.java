//Класс производит вычисления

package com.sinel.katacalc;

class Calculator {

//считаем результат, если первое число по типу римское, то возвращаем результат для римских,
//в противном случае для арабских
    public static String calculate(NumType num1, NumType num2, String operation) throws Exception{
        int result;

        switch (operation) {
            case "+":
                result = num1.getValue() + num2.getValue();
                break;
            case "-":
                result = num1.getValue() - num2.getValue();
                break;
            case "*":
                result = num1.getValue() * num2.getValue();
                break;
            case "/":
                result = num1.getValue() / num2.getValue();
                break;
            //знаю что это исключение никогда не сработает, но без default никак))
            default:
                throw new Exception("Не правильно введен символ операции, используйте только +, -, *, /");
        }
        if (num1.getType() == NumType.fromEnum.ROMA) {
            return Calculator.arabToRoma(result);
        } else return String.valueOf(result);
    }

// переводим римские числа в арабские самым примитивным способом
    static int romaToArab(String roman) throws Exception {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
            //это исключение тоже маловероятно что сработает когда-нибудь
        } catch (Exception e) {
            throw new Exception("Неверный формат римских чисел. Используйте только числа от 1 до 10 включительно!");
        }
        return -1;
    }

//переводим арабские в римские, опять самым примитивным способом
//выброс исключения если результат для римских отрицательный
    public static String arabToRoma(int input) throws Exception {
        String s = "";

        while (input >= 100) {
            s += "C";
            input -= 100;
        }
        while (input >= 90) {
            s += "XC";
            input -= 90;
        }
        while (input >= 50) {
            s += "L";
            input -= 50;
        }
        while (input >= 40) {
            s += "XL";
            input -= 40;
        }
        while (input >= 10) {
            s += "X";
            input -= 10;
        }
        while (input >= 9) {
            s += "IX";
            input -= 9;
        }
        while (input >= 5) {
            s += "V";
            input -= 5;
        }
        while (input >= 4) {
            s += "IV";
            input -= 4;
        }
        while (input >= 1) {
            s += "I";
            input -= 1;
        }
        if (s.equalsIgnoreCase("")) {
            throw new Exception("В римской системе нет отрицательных чисел!");
        }
        return s;
    }

//Вывод сообщения при закрытии программы
    static void exitCalc() {
        System.out.println("РАБОТА ПРОГРАММЫ ЗАВЕРШЕНА. До новых встреч!");
    }
}
