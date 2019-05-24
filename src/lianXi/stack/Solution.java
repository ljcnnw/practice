package lianXi.stack;


import java.util.Stack;

/**
 * 每日温度
 */
public class Solution {
    int temperatures[];

    int[] check() {
        int[] last = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int count = 0;
            for (int j = i + 1; j < temperatures.length; j++) {
                Stack<Integer> stack = new Stack<>();
                stack.push(temperatures[i]);
                if (stack.peek() > temperatures[j]) {
                    stack.push(temperatures[j]);
                    count++;
                    if(j == temperatures.length -1){
                        count = 0;
                    }
                } else {
                    count++;
                    break;
                }
            }
            last[i] = count;
        }
        return last;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 77};
        for (int i : solution.check()) {
            System.out.println(i);
        }
    }


}


/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高的天数。如果之后都不会升高，请输入 0 来代替。
 * <p>
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的都是 [30, 100] 范围内的整数。
 */