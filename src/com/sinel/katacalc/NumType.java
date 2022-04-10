/*Класс помогает определять типы чисел (арабские или римские) и их значения,
*завязан на Enum
*изначально пытался это сделать булевыми методами,
*но получислось не красиво и много кода
 */

package com.sinel.katacalc;

class NumType {
    private int value;
    private fromEnum type;

//enum для типов чисел
    public enum fromEnum{
        ARAB, ROMA
    }

//конструктор
    NumType(int value, fromEnum type) {
        this.value = value;
        this.type = type;
    }

//геттер для значения
    public int getValue() {
        return value;
    }

//геттер для типа
    public fromEnum getType() {
        return type;
    }

/*для распознания типа первого числа, парсим число
*если получисло, то тип будет арабским, а нет, то римским
*тут используется метод из класса Calculator
*/
    static NumType defineNum1(String s) throws Exception {
        int value;
        fromEnum type;

        try {
            value = Integer.parseInt(s);
            type = fromEnum.ARAB;
        } catch (Exception e) {
            value = Calculator.romaToArab(s);
            type = fromEnum.ROMA;
        }

        if (value < 1 || value > 10) {
            throw new Exception("Используйте 2 числа только от 1 до 10 включительно!");
        }
        return new NumType(value, type);
    }

//для типа второго числа и выброса исключения если типы чисел разные
    static NumType defineNum2(String s, fromEnum type) throws Exception{
        NumType num = defineNum1(s);
        if (num.getType() != type) {
            throw new Exception("Числа разных типов, используйте один тип вводных значений!");
        }
        return num;
    }
}
