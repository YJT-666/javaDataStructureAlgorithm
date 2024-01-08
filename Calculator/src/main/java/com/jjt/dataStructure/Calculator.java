package com.jjt.dataStructure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Stack;

/**
 * ClassName: Calculator
 * Package: IntelliJ IDEA
 *
 * @Author jjt
 * @Create 2024/1/6 16:11
 * @Version 1.0
 * Description:
 *          利用栈来实现综合计算器
 *          计算形如
 *          7*2*2-5+1-5+3-3+6/2 的字符串表达式
 *          支持：整数、小数、() 运算
 *               + - / *
 *
 *          实现方式包括：
 *             直接对中缀表达式进行计算
 *             将中缀表达式转成后缀表达式（逆波兰表达式）进行计算
 *          中缀表达式的求值是人最熟悉，但是后缀表达式对于计算机来说最好计算。
 *
 *          扩展：
 *              前缀表达式（波兰表达式）：运算符均在操作数之前
 *              中缀表达式：运算符在操作数之间
 *              后缀表达式：运算符在操作数之后
 *
 */
public class Calculator {
    /**
     *  判断运算符是否合法，合法的话返回其优先级
     *  返回的数字越大，优先级越高
     * */
    public static int assertOp(Character op) {

        if (op == '+' || op == '-') {
            return 0;
        }else if (op == '*' || op == '/') {
            return 1;
        } else {
            throw new RuntimeException("运算符错误," + op + " 不是合法的运算符");
        }
    }
    /**
     *  判断运算符优先级
     *  返回 > 0 : op1 优先级高于 op2
     *
     * */
    public static int opComparator(Character op1, Character op2) {
        return assertOp(op1) - assertOp(op2);
    }
    /**
     *  根据传入的运算符和操作数进行运算
     *  return  num2 op num1
     * */
    public static Double simpleCalculator(Double num1, Double num2, Character op) {

        if(op.equals('+')) {
            return num2 + num1;
        }else if(op.equals('-')) {
            return num2 - num1;
        }else if(op.equals('*')) {
            return num2 * num1;
        } else if(op.equals('/')) {
            return num2 / num1;
        }

        throw new RuntimeException("运算错误, " + op + " 是非法运算符");
    }
    /**
     *  对中缀表达式进行计算的实现
     *  exp 是 中缀运算表达式
     *  TODO:
     *        创建两个栈，一个保存数字的数字栈 numStack; 一个保存计算符合的符号栈 opStack
     *        通过一个索引值遍历字符串表达式的字符
     *         1. 如果是数字，把非数字之前的所有数字字符和小数点拼接成一个整数，加入 numStack
     *         2. 如果是运算符号
     *            2.1 如果符号栈为空，直接入栈
     *            2.2 符号栈不为空，就进行操作符的优先级比较
     *                2.2.1 当前的操作符优先级小于或者等于栈中的操作符。
     *                       从数字栈中pop出两个数，从符号栈中pop一个操作符，进行运算，并将
     *                       运算的结果入数字栈，然后将当前符号入栈
     *                2.2.2 当前的操作符优先级大于符号栈中的操作符，那么就直接入栈
     *         3. 如果是左括号，扫描后续的字符串，得到()内的字串表达式，递归计算字串表达式的值放入
     *             数字栈当中
     *         4. 如果是空格，则不处理
     *         5. 表达式扫描完毕后，就顺序从数栈和符号栈当中pop出相应的数和符号，执行运算
     *         6. 最后数栈当中只有一个数字，就是表达式的结果了
     *
     * */
    Double expCalculatorMid(String exp) {
        Stack<Double> numStack = new Stack<>();   // 数字栈
        Stack<Character> opStack = new Stack<>();  // 操作符栈
        // 扫描表达式
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(Character.isDigit(c)) {
                // 是数字
                String num = c+"";
                i++;
                while (true) {
                    // 查找数字
                    if(i >= exp.length()) break; // 已经是最后一个元素了
                    char c2 = exp.charAt(i);
                    if(Character.isDigit(c2) || c2=='.') {
                        num+=c2;
                        i++;
                    }else {
                        break;
                    }
                }
                numStack.push(Double.parseDouble(num));
                num="";
                i--;
            } else if(c == '('){
                // 是括号
                // 查找 括号内部的字符串
                String subExp="";
                i++;
                int cnt=1;  // 括号层数计数
                while (true) {
                    char c3 = exp.charAt(i);
                    if(c3 == '(') {
                        cnt++;
                        subExp += c3;
                    } else if(c3 == ')'){
                        if(cnt > 1) subExp += c3;
                        cnt--;
                    } else {
                        subExp += c3;
                    }
                    if(cnt == 0) break;
                    i++;
                    if(i >= exp.length()) {
                        throw new RuntimeException("表达式错误，括号不匹配");
                    }
                }
                // 递归计数括号内的字串表达式，结果加入数字栈当中
                numStack.push(expCalculator(subExp));
            } else if(c == ' '){
                continue;  // 空格不处理
            } else {
                // 是运算符
                while (true) {
                    if(opStack.empty()) {
                        opStack.push(c);
                        break;
                    }
                    Character peekOp = opStack.peek();
                    if(opComparator(c, peekOp) > 0) {
                        // 当前 运算符的优先级高，直接入栈
                        opStack.push(c);
                        break;
                    } else {
                        // 当前 运算符的优先级小于等于栈顶的运算符的优先级，需要进行运算
                        Character op = opStack.pop();
                        Double num1 = numStack.pop();
                        Double num2 = numStack.pop();
                        numStack.push(simpleCalculator(num1, num2, op));
                    }
                }
            }
        }
        // 计算未处理的操作符
        while (!opStack.isEmpty()) {
            Character op = opStack.pop();
            Double num1 = numStack.pop();
            Double num2 = numStack.pop();
            numStack.push(simpleCalculator(num1, num2, op));
        }
        // 打印计算结果
        System.out.println(exp + "=" + numStack.peek());

        // 返回计算结果
        return numStack.pop();
    }
    /**
     *  对后缀表达式进行计算的实现
     *  exp 是一个后缀表达式（逆波兰表达式）
     *
     *    TODO:
     *        创建一个数字栈。
     *        从左至右扫描表达式，
     *        遇到数字时，将数字压入堆栈，
     *        遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（次顶元素 和 栈顶元素），
     *        并将结果入栈；重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果
     * */
    Double expCalculatorSuffix(String exp) {
        Stack<Double> numStack = new Stack<>();   // 数字栈

        // 扫描表达式
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if(Character.isDigit(c)) {
                // 是数字
                String num = c+"";
                i++;
                while (true) {
                    // 查找数字
                    if(i >= exp.length()) break; // 已经是最后一个元素了
                    char c2 = exp.charAt(i);
                    if(Character.isDigit(c2) || c2=='.') {
                        num+=c2;
                        i++;
                    }else {
                        break;
                    }
                }
                numStack.push(Double.parseDouble(num));
                num="";
                i--;
            } else if(c == ' ') {
                // 空格，忽略
                continue;
            } else {
                // 断言操作符是否合法
                assertOp(c);
                // 弹出栈顶两个元素，根据操作符进行相应的计算
                Double num1 = numStack.pop();
                Double num2 = numStack.pop();
                numStack.push(simpleCalculator(num1, num2, c));
            }
        }

        // 返回计算结果
        return numStack.pop();
    }
    /**
     *  将中缀表达式转换成后缀表达式
     *  TODO:
     *      1.初始化两个栈：运算符栈s1和储存中间结果的栈s2；
     *      2.从左至右扫描中缀表达式；
     *      3.遇到操作数时，将其压s2；
     *      4.遇到运算符时，比较其与s1栈顶运算符的优先级：
     *        4.1 如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     *        4.2 否则，若优先级比栈顶运算符的高，也将运算符压入s1；
     *        4.3 否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较；
     *      5.遇到括号时：
     *        (1) 如果是左括号“(”，则直接压入s1
     *        (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，
     *            此时将这一对括号丢弃
     *      6.重复步骤2至5，直到表达式的最右边
     *      7.将s1中剩余的运算符依次弹出并压入s2
     *      8.依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     * */
    String midExpConvert2SuffixExp(String midExp) {

        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        for (int i = 0; i < midExp.length(); i++) {
            char c = midExp.charAt(i);
            if(Character.isDigit(c)) {
                // 是数字
                String num = c+"";
                i++;
                while (true) {
                    // 查找数字
                    if(i >= midExp.length()) break; // 已经是最后一个元素了
                    char c2 = midExp.charAt(i);
                    if(Character.isDigit(c2) || c2=='.') {
                        num+=c2;
                        i++;
                    }else {
                        break;
                    }
                }
                s2.push(num);
                num="";
                i--;
            } else if(c == '(') {
                s1.push(c+"");
            } else if(c == ')') {
                while (true) {
                    String c2 = s1.pop();
                    if (c2.equals("(")) break;
                    s2.push(c2);
                }
            } else if(c== ' ') {
                continue;
            } else {
                // 是运算符
                assertOp(c);
                while (true) {
                    if(s1.isEmpty()) {
                        s1.push(c+"");
                        break;
                    } else {
                        String c3 = s1.peek();
                        if(c3.equals("(")) {
                            s1.push(c+"");
                            break;
                        }else {
                            if(opComparator(c, c3.charAt(0))>0) {
                                s1.push(c+"");
                                break;
                            }else {
                                s2.push(s1.pop());
                            }
                        }
                    }
                }
            }
        }
        // 将s1中剩余的运算符依次弹出并压入s2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        // 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        String res = "";
        while (!s1.isEmpty()) {
            res += s1.pop();
            res += " ";
        }
        return res;
    }
    Double expCalculator(String exp) {
        // return expCalculatorMid(exp);

        return expCalculatorSuffix(midExpConvert2SuffixExp(exp));
    }

}
