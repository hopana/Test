package generic;

/**
 * 泛型调用演示
 *
 * @author 杨元
 */
public class GenericDemo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        Generic generic = new Generic();
        //调用泛型方法
        Object obj = generic.getObject(Class.forName("com.cnblogs.test.User"));
        //判断obj的类型是否是指定的User类型
        System.out.println(obj instanceof User);
    }
}

/**
 * 测试实体模型
 *
 * @author 杨元
 */
class User {
    private String uid;
    private String pwd;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
