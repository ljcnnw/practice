package lianXi.queue;

import java.util.*;

/**
 * 打开转盘锁
 */
public class ZhuanPanSuo {
    //四个转盘锁
    Queue<Character> zhuanpansuo1 = new LinkedList<>();
    Queue<Character> zhuanpansuo2;
    Queue<Character> zhuanpansuo3;
    Queue<Character> zhuanpansuo4;
    //解锁数字
    String target;
    //死亡数组
    String[] deadends;
    //最少需要几次
    int count;
    //记录第几次遇到死亡数字
    int deadCount;

    ZhuanPanSuo() {
        zhuanpansuo1.offer('0');
        zhuanpansuo1.offer('1');
        zhuanpansuo1.offer('2');
        zhuanpansuo1.offer('3');
        zhuanpansuo1.offer('4');
        zhuanpansuo1.offer('5');
        zhuanpansuo1.offer('6');
        zhuanpansuo1.offer('7');
        zhuanpansuo1.offer('8');
        zhuanpansuo1.offer('9');
        zhuanpansuo2 = zhuanpansuo1;
        zhuanpansuo3 = zhuanpansuo1;
        zhuanpansuo4 = zhuanpansuo1;
        count = 0;
        deadCount = 0;
    }

    int jieSuo() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 10; j++) {

                for (int k = 0; k < deadends.length; j++) {

                }
            }
        }
        return -1;
    }


    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        String init = "0000";
        if (dead.contains(init) || dead.contains(target)) {
            return -1;
        }

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        int steps = 0;
        queue1.offer(init);
        while (!queue1.isEmpty()) {
            String cur = queue1.poll();
            if (cur.equals(target)) {
                return steps;
            }

            List<String> nexts = getNexts(cur);
            for (String next : nexts) {
                if (!dead.contains(next) && !visited.contains(next)) {
                    visited.add(next);
                    queue2.offer(next);
                }
            }

            if (queue1.isEmpty()) {
                steps++;
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }

        return -1;

    }


    private List<String> getNexts(String cur) {
        List<String> nexts = new LinkedList<>();
        for (int i = 0; i < cur.length(); ++i) {
            char ch = cur.charAt(i);

            char newCh = ch == '0' ? '9' : (char) (ch - 1);
            StringBuilder builder = new StringBuilder(cur);
            builder.setCharAt(i, newCh);
            nexts.add(builder.toString());

            newCh = ch == '9' ? '0' : (char) (ch + 1);
            builder = new StringBuilder(cur);
            builder.setCharAt(i, newCh);
            nexts.add(builder.toString());
        }

        return nexts;
    }


/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 * <p>
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 */
}