/*В этом классе принимается ввод пользователя
* введенное выражение форматируется в нужный вид
* (убираются пробелы и тубуляции)
* из выражения получаются нужные переменные
* полученные переменные будут передаваться в другие классы
* для этого используются сеттеры и геттеры
*/
package com.sinel.katacalc;
import java.util.Scanner;

class InputRead {
    Scanner scan = new Scanner(System.in);
    private char operation;
    private String userInput, expression, num1, num2;

//сеттер для приема вводимого выражения
    public void setUserInput() {
        String userInput = scan.nextLine();
        this.userInput = userInput;
    }

//геттер для получения введенного выражения
    public String getUserInput() {
        return userInput;
    }

//сеттер для форматирования выражения в нужный вид
    public void setExpression() throws Exception{
        String expression = userInput.replaceAll("\\s", "").toUpperCase();
        this.expression = expression;
        if (expression.equals("")){
            throw new Exception("Вы ничего не ввели!");
        }
    }

//геттер для отформатированного выражения
    public String getExpression() {
        return expression;
    }

//сеттер для поска знака операции, создает символьный массив
//в который помещается отформатированное выражение переведенное в символьный массив
//циклом ищем символ в массиве и передаем его в operation, checkOperation для выброса исключения
    public void setOperation() throws Exception {
        String checkOperation = "";
        char checkDouble = ' ';
        char[] charOperation = expression.toCharArray();
        try {
            for (int i = 0; i < expression.length(); i++) {
                charOperation[i] = expression.charAt(i);

                if (charOperation[i] == '+') {
                    this.operation = '+';
                    checkOperation += "+";
                }
                if (charOperation[i] == '-') {
                    this.operation = '-';
                    checkOperation += "-";
                }
                if (charOperation[i] == '*') {
                    this.operation = '*';
                    checkOperation += "*";
                }
                if (charOperation[i] == '/') {
                    this.operation = '/';
                    checkOperation += "/";
                }
                if (charOperation[i] == ',') {
                    checkDouble = ',';
                }
                if (charOperation[i] == '.') {
                    checkDouble = '.';
                }
            }
        } finally {
            if(checkDouble == '.' || checkDouble == ',') {
                throw new Exception("Используйте только целые числа!");
            }
            if (this.operation != '+' && this.operation != '-' && this.operation != '*' && this.operation != '/') {
                throw new Exception("Не правильно введен символ операции или вообще не введен," +
                        "\nиспользуйте только +, -, *, /");
            }
            if (checkOperation.length() > 1) {
                throw new Exception("Введено больше 2 чисел и(или) операторов!");
            }

        }
    }

//геттер для знака операции
    public char getOperation() {
        return operation;
    }

//сеттер для поиска первого числа
    public void setNum1() throws Exception {
        String[] splitExpession;
        try {
            splitExpession = expression.split("[+-/*]");
            this.num1 = splitExpession[0];
        } catch (Exception e) {
            throw new Exception("Строка не является математической операцией!");
        }
    }

//геттер для первого числа
    public String getNum1() {
        return num1;
    }

//сеттер для поиска второго числа

    public void setNum2() throws Exception {
        String[] splitExpession;
        try {
            splitExpession = expression.split("[+-/*]");
            this.num2 = splitExpession[1];
        } catch (Exception e) {
            throw new Exception("Строка не является математической операцией!");
        }
    }

//геттер для второго числа
    public String getNum2() {
        return num2;
    }

//это просто чтобы писать меньше кода в Main
    public void setAll() throws Exception{
        setExpression();
        setOperation();
        setNum1();
        setNum2();
    }
}
