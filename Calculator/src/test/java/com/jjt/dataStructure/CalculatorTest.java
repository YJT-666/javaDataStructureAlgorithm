package com.jjt.dataStructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * ClassName: CalculatorTest
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/6 17:03
 * @Version 1.0
 * Description:
 */
public class CalculatorTest {


    @Test
    public void testCalcultor01() {

        Calculator calculator = new Calculator();

        Assertions.assertEquals(6, calculator.expCalculator("5+2-1"));
        Assertions.assertEquals(13, calculator.expCalculator("3+2*6-2"));
        Assertions.assertEquals(9, calculator.expCalculator("3/3+4-2+6*1"));
        Assertions.assertEquals(45, calculator.expCalculator("30/30+40-2+6*1"));
        Assertions.assertEquals(130, calculator.expCalculator("70*2-20+10"));
        Assertions.assertEquals(1300, calculator.expCalculator("700*2-200+100"));

        Assertions.assertEquals(10, calculator.expCalculator("5*(4-3)*2"));

        Assertions.assertEquals(72, calculator.expCalculator("5*(4*(4-1)/10+2*3)*2"));

        Assertions.assertEquals(8.8, calculator.expCalculator("1.1*5+3.3"));
    }

    @Test
    public void testCalcultor02() {
        Calculator calculator = new Calculator();
        Assertions.assertEquals(29, calculator.expCalculatorSuffix("3 4 + 5 * 6 -"));
        Assertions.assertEquals(164, calculator.expCalculatorSuffix("30 4 + 5 * 6 -"));
        Assertions.assertEquals(76, calculator.expCalculatorSuffix("4 5 * 8 - 60 + 8 2 / +"));

        Assertions.assertEquals("1 2 3 + 4 * + 5 - ", calculator.midExpConvert2SuffixExp("1+((2+3)*4)-5"));
    }
}
