package lianXi.stack;

import java.util.Stack;

/**
 * 有效的括号
 */
public class KuoHao {
    Stack<Character> stack = new Stack<>();

    boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty()){
                    return false;
                }else if(s.charAt(i) == '}' && stack.peek() != '{'){
                    return false;
                }else if(s.charAt(i) == ']' && stack.peek() != '['){
                    return false;
                }else if(s.charAt(i) == ')' && stack.peek() != '('){
                    return false;
                }
                stack.pop();
            }
        }

        return true;
    }

    public static void main(String[] args) {
        KuoHao kuoHao =  new KuoHao();
        System.out.println(kuoHao.isValid("{[]}"));
    }


}


/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
