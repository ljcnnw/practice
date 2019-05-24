package lianXi.stack;


import java.util.Stack;

/**
 * 逆波兰表达式
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: (4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * 输出: 22
 * 解释:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 */
public class NiBolan {
    String data[];//数据
    int end;//最后结果

    int theEnd() {
        int x = 0;//存储中间数据
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < data.length; i++) {
            if (!"+".equals(data[i]) && !"/".equals(data[i]) && !"-".equals(data[i]) && !"*".equals(data[i])) {
                stack.push(data[i]);
            } else {
                int top = Integer.parseInt(stack.peek() + "");//栈顶数据
                stack.pop();
                int before = Integer.parseInt(stack.peek() + "");//栈顶数据
                stack.pop();
                if ("+".equals(data[i])) {
                    x = before + top;
                } else if ("-".equals(data[i])) {
                    x = before - top;
                } else if ("*".equals(data[i])) {
                    x = before * top;
                } else if ("/".equals(data[i])) {
                    x = before / top;
                }
                System.out.println("x的值:" + x);
                stack.push(x + "");
            }
        }
        return x;
    }

    public static void main(String[] args) {
        NiBolan niBolan = new NiBolan();
        niBolan.data = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(niBolan.theEnd());
    }


}
