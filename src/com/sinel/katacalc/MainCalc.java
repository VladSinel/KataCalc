//Тут программа запускается, цикл работает до первого не правльного ввода или пока не введут exit

package com.sinel.katacalc;

class MainCalc {
    public static void main(String[] args) {
        WelcomeMenu.hello();
        while (true) {
            try {
                System.out.println("\nВведите математическое выражение(Например: 3+5 или V*VI) и нажмите ENTER:");
                InputRead a = new InputRead();
                a.setUserInput();
                String s = a.getUserInput();
                if (s.equalsIgnoreCase("EXIT")) {
                    Calculator.exitCalc();
                    break;
                }else if (s.equalsIgnoreCase("?")){
                    WelcomeMenu.info();
                } else {
                    a.setAll();
                    NumType num1 = NumType.defineNum1(a.getNum1());
                    NumType num2 = NumType.defineNum2(a.getNum2(), num1.getType());
                    String result = Calculator.calculate(num1, num2, String.valueOf(a.getOperation()));
                    System.out.println("Результат: \n"+ a.getExpression() + " = " + result);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                Calculator.exitCalc();
                break;
            }
        }
    }
}
