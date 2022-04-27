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
    private String num1;
    private String num2;
    private EOperator operator;
    private boolean primeNumber;

    public String calc() {
        if (!isPrimeNumber()) {
            return switch (operator) {
                case multiply -> String.valueOf(Integer.parseInt(getNum1()) * Integer.parseInt(getNum2()));
                case plus -> String.valueOf(Integer.parseInt(getNum1()) + Integer.parseInt(getNum2()));
                case minus -> String.valueOf(Integer.parseInt(getNum1()) - Integer.parseInt(getNum2()));
                case division -> String.valueOf(Integer.parseInt(getNum1()) / Integer.parseInt(getNum2()));
            };
        } else {
            return switch (operator){
                case multiply -> String.valueOf(Double.parseDouble(getNum1()) * Double.parseDouble(getNum2()));
                case plus -> String.valueOf(Double.parseDouble(getNum1()) + Double.parseDouble(getNum2()));
                case minus -> String.valueOf(Double.parseDouble(getNum1()) - Double.parseDouble(getNum2()));
                case division -> String.valueOf(Double.parseDouble(getNum1()) / Double.parseDouble(getNum2()));
            };
        }
    }
}
