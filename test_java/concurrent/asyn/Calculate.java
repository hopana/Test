package asyn;

import java.util.ArrayList;
/**
 * @author ZW_com
 * 主要用于计算的类
 */
public class Calculate {
    /**
     * @param data 传入的接口引用
     * @param list 传入要计算的集合
     */
    public void initData(CallBackData data, ArrayList<Integer> list){
        for(int i = 0 ; i<5 ;i++){
            list.add(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //将计算好的值通过接口中的方法返回
        data.backData(list);
    }

}