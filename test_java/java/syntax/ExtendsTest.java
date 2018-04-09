package syntax;

public abstract class ExtendsTest {
    protected String sex = "man";

    protected abstract void fun();
}

class ExtendsTestSon extends ExtendsTest {

	/*������า�Ǹ���ķ��������ܽ��ͷ����Ŀɼ���,�˴���private����*/
    //private void fun() {

    //}

    // ������ʯ���Եĳ�Ա���������ڸ��ǵ�����
    private String sex = "man";

    protected void fun() {
        System.out.println("������า�Ǹ���ķ��������ܽ��ͷ����Ŀɼ���");
    }

}