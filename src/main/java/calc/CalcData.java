package calc;

import calc.enums.EOperator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CalcData {
    private int num1;
    private int num2;
    private EOperator operator;

    public int calc() {
        return switch (operator) {
            case multiply -> getNum1() * getNum2();
            case plus -> getNum1() + getNum2();
            case minus -> getNum1() - getNum2();
            case division -> getNum1() / getNum2();
        };
    }
}
