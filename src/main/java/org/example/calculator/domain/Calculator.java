package org.example.calculator.domain;

import org.example.calculator.tobe.*;

import java.util.List;

public class Calculator {

    private static final List<ArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new DivisionOperator(), new SubtractionOperator(), new MultiplicationOperator());
    // List 형태의  ArithmeticOperator 가 List 형태의 여러 매개변수(AdditionOperator, DivisionOperator...)를 받기위해(of) 참조변수(arithmeticOperators)에 참조하고있음
    /**
     * 간단한 사칙연산을 할 수 있다.
     * 양수로만 계산할 수 있다.
     * 나눗셈에서 0을 나누는 경우 IllegalArgument 예외를 발생시킨다. MVC패턴(Model-View-Controller) 기반으로 구현한다
     */
    public static int calculate(PositiveNumber positiveOperand1, String operator, PositiveNumber positiveOperand2) {
    //
        return arithmeticOperators.stream()
        // arithmeticOperators 를 흐른다.
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                // 매개변수 arithmeticOperators(arithmeticOperators의)
                .map(arithmeticOperator -> arithmeticOperator.calculate(positiveOperand1, positiveOperand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
