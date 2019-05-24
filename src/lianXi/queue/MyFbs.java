package lianXi.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先搜索BFS(岛屿数量)
 */
public class MyFbs {
    char data[][];
    int x;//行
    int y;//列
    int count = 0;//岛屿个数
    Queue<Integer> tail;
    int rows;//行
    int cols;//列
    int xx;//当前位置上下左右的X坐标
    int yy;//当前位置上下左右的Y坐标
    int checkLands(char data[][]) {
        rows = data.length;
        cols = data[0].length;
        //取上下左右的坐标时候调用
        int dx[]={-1,0,1,0};
        int dy[]={0,1,0,-1};
        tail = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (data[i][j] == '1') {
                    tail.offer(i);
                    tail.offer(j);
                    data[i][j] = '0';
                    while (!tail.isEmpty()) {
                        x = tail.peek();
                        tail.poll();
                        y = tail.peek();
                        tail.poll();
                        //上下左右逐次判断
                        for(int k=0;k<4;k++){
                            xx=x+dx[k];
                            yy=y+dy[k];
                            if(xx<0||xx>=rows||yy<0||yy>=cols){
                                continue;
                            }
                            if(data[xx][yy]=='1'){
                                data[xx][yy]='0';
                                tail.offer(xx);
                                tail.offer(yy);
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char data[][] = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char data2[][] = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        MyFbs myFbs = new MyFbs();
        int count = myFbs.checkLands(data2);
        System.out.println(count);
    }

}
