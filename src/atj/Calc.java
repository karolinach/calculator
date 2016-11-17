package atj;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

public class Calc {
    private String value;
    private String previous;
    private String sign;
    private String previousNumber;
    private String currentNumber;


    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setPreviousNumber(String previousNumber) {
        this.previousNumber = previousNumber;
    }

    public void setCurrentNumber(String currentNumber) {
        this.currentNumber = currentNumber;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void handleButton(String btn) {
        boolean isBtnNumber = NumberUtils.isParsable(btn);

        //there is no previous
        if(StringUtils.isBlank(previous)) {
            //btn is sign
            if(!isBtnNumber){
                //btn is not sqrt, +/-, or =
                if(!(btn.equals("sqrt") || btn.equals("+/-") || btn.equals("="))) {
                    //btn is .
                    if(btn.equals(".")){
                        value = "0.";
                        currentNumber = value;
                        previous = "0";
                    }
                    //btn is other sign
                    else {
                        previous = btn;
                        currentNumber = "0";
                        value = "0";
                        sign = btn;
                    }
                }
            }
            //btn is number
            else {
                previous = btn;
                currentNumber = btn;
                value = btn;
            }
        }
        //there is previous
        else {
            //btn is sign
            if(!isBtnNumber){
                //=
                if(btn.equals("=")){
                    if(!StringUtils.isBlank(previousNumber)) {
                        calculate();
                        currentNumber = value;
                        sign = null;
                        previousNumber = null;
                        previous = currentNumber;
                    }
                }
                //.
                else if(btn.equals(".")){
                    currentNumber = currentNumber + btn;
                    value = currentNumber;
                }
                //+-
                else if(btn.equals("+/-")){
                    value = String.valueOf(Double.parseDouble(value) * (-1));
                    currentNumber = value;
                    previous = currentNumber;
                }
                //sqrt
                else if(btn.equals("sqrt")){
                    value = String.valueOf(Math.sqrt(Double.parseDouble(currentNumber)));
                    currentNumber = value;
                    previous = currentNumber;
                }
                //previous is number and there is previousNumber
                else if(NumberUtils.isParsable(previous) && !StringUtils.isBlank(previousNumber)) {
                    calculate();
                    previousNumber = currentNumber;
                    currentNumber = value;
                    sign = btn;
                    previous = btn;
                }
                //previous is sign or previous is number but there is no previousNumber
                else{
                    previous = btn;
                    sign = btn;
                }
            }
            //btn is number
            else {
                //previous is sign
                if(!NumberUtils.isParsable(previous)) {
                    //there is currentNumber
                    if(!StringUtils.isBlank(currentNumber)) {
                        value = btn;
                        previousNumber = currentNumber;
                        currentNumber = btn;
                        previous = btn;
                    }
                    else{
                    //there is no currentNumber
                    value = btn;
                    currentNumber = btn;
                    previous = btn;}
                }
                //previous is number
                else{
                    currentNumber = currentNumber + btn;
                    previous = currentNumber;
                    value = currentNumber;
                }
            }
        }

    }

    private void calculate(){
        double doublePrev = Double.parseDouble(previousNumber);
        double doubleCurrent = Double.parseDouble(currentNumber);
        switch (sign) {
            case "+":
                value = String.valueOf(doubleCurrent + doublePrev);
                break;
            case "-":
                value = String.valueOf(doublePrev - doubleCurrent);
                break;
            case "*":
                value = String.valueOf(doublePrev * doubleCurrent);
                break;
            case "/": {
                if(doubleCurrent == 0){
                    throw new IllegalArgumentException();
                }
                value = String.valueOf(doublePrev / doubleCurrent);
                break;}
            case "%":
                value = String.valueOf(doubleCurrent * doublePrev / 100);
                break;

            case "+/-":
                value = String.valueOf(doublePrev - doubleCurrent);
                break;
        }
    }



}