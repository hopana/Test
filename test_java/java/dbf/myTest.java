package dbf;


public class myTest {

    private static void readDBF() {
        try {
            System.out.println("���ڶ�ȡ�ļ���");

            DBFReader dbfreader = new DBFReader("d:/bb.dbf");
            for (int b = 0; b < dbfreader.getFieldCount(); b++) {
                if (b > 0)
                    System.out.print(",");
                System.out.print(dbfreader.getField(b).getName().trim().toUpperCase());

                if (b == (dbfreader.getFieldCount() - 1))
                    System.out.print("\n");

            }
            for (int i = 0; dbfreader.hasNextRecord(); i++) {
                String aobj[] = dbfreader.nextRecordString();
                for (int b = 0; b < dbfreader.getFieldCount(); b++) {
                    if (b > 0)
                        System.out.print(",");
                    System.out.print(aobj[b].trim());

                    if (b == (dbfreader.getFieldCount() - 1))
                        System.out.print("\n");

                }
            }
            System.out.println("��ȡ�ļ��ɹ���");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * дDBF�ļ�
     */
    private static void writeDBF() {

        try {
            JDBField ajdbfield[] = new JDBField[4];
            ajdbfield[0] = new JDBField("�ֶ�1", 'C', 20, 0);
            ajdbfield[1] = new JDBField("�ֶ�2", 'C', 20, 0);
            ajdbfield[2] = new JDBField("filed3", 'C', 20, 0);
            ajdbfield[3] = new JDBField("filed4", 'C', 20, 0);

            System.out.println("��������DBF�ֶΣ�");

            DBFWriter dbfwriter = new DBFWriter("d:/aa.dbf", ajdbfield); /*���� DBF �ļ�*/
            Object aobj[] = new Object[4];
            aobj[0] = "1";
            aobj[1] = "1";
            aobj[2] = "1";
            aobj[3] = "1";

            System.out.println("����д�����ݣ�");

            dbfwriter.addRecord(aobj);
            dbfwriter.close();

            System.out.println("ִ�гɹ���");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        //writeDBF();
        readDBF();
    }


}