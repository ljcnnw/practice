package lianXi.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 克隆图
 * https://leetcode-cn.com/explore/learn/card/queue-stack/219/stack-and-dfs/884/
 * 给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：
 * {"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}
 * <p>
 * 解释：
 * 节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
 * 节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
 * 节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
 * 节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 节点数介于 1 到 100 之间。
 * 无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
 * 由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
 * 必须将给定节点的拷贝作为对克隆图的引用返回。
 */
public class CloneTu {
     static class Node {
        public int id;
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _id, int _val, List<Node> _neighbors) {
            id = _id;
            val = _val;
            neighbors = _neighbors;
        }
    }

    ;


    public void cloneThem(Node node) {


        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()) {
            System.out.println("节点" + node.id + "的值是" + node.val + "他有两个邻居：节点" + node.neighbors.get(0).id + "和" + node.neighbors.get(1).id);
            stack.pop();
            node = node.neighbors.get(0);
        }


    }

    public static void main(String[] args) {
        CloneTu cloneTu = new CloneTu();


        Node node = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        List<Node> nodes = new ArrayList<>();
        nodes.add(node2);
        node4 = new Node(4,4,nodes);
        nodes.add(node4);
        node = new Node(1,1,nodes);
        List<Node> nodes2 = new ArrayList<>();
        nodes2.add(node2);
        nodes2.add(node4);



    }

}
