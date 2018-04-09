package asyn;

import java.util.ArrayList;
/**
 * @author zw_com
 * 这类是主要逻辑过程的体现
 */
public class MainFunction implements CallBackData{
    public ArrayList<Integer> count  = new ArrayList<>();
    public Calculate calculate;
    public MainFunction(Calculate cal) {
        this.calculate = cal;
    }
    //耗时操作的处理过程
    public void operational(){
        new Thread(new Runnable() {

            @Override
            public void run() {
                calculate.initData(MainFunction.this, count);
            }
        }).start();
    }
    //通过接口回掉计算后返回的值
    @Override
    public void backData(ArrayList<Integer> list) {
        System.out.println("计算后返回的值"+list);
    }
}