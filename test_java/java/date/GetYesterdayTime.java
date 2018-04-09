package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class GetYesterdayTime {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar();
        Date nowDate = new Date();
        Date beforeDate = new Date();
        calendar.setTime(nowDate);
        calendar.add(Calendar.DAY_OF_MONTH, -1);  //����Ϊǰһ��
        beforeDate = calendar.getTime();   //�õ�ǰһ���ʱ��

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //����ʱ���ʽ
        String date1 = sdf.format(nowDate);    //��ʽ����ǰʱ��
        String date2 = sdf.format(beforeDate); //��ʽ������ʱ��

        System.out.println("����ĵ�ǰʱ���ǣ�" + date1);
        System.out.println("����ĵ�ǰʱ���ǣ�" + date2);


    }
}
