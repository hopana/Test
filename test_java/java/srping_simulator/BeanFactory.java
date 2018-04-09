package srping_simulator;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * bean������.
 */
public class BeanFactory {
    private Map<String, Object> beanMap = new HashMap<String, Object>();

    /**
     * bean�����ĳ�ʼ��.
     *
     * @param xml xml�����ļ�
     */
    public void init(String xml) {
        try {
            // ��ȡָ���������ļ�
            SAXReader reader = new SAXReader();
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            // ��classĿ¼�»�ȡָ����xml�ļ�
            InputStream ins = classLoader.getResourceAsStream(xml);
            Document doc = reader.read(ins);
            Element root = doc.getRootElement();
            Element foo;

            // ����bean
            for (Iterator i = root.elementIterator("bean"); i.hasNext(); ) {
                foo = (Element) i.next();
                // ��ȡbean������id��class
                Attribute id = foo.attribute("id");
                Attribute cls = foo.attribute("class");

                // ����Java������ƣ�ͨ��class�����ƻ�ȡClass����
                Class bean = Class.forName(cls.getText());

                // ��ȡ��Ӧclass����Ϣ
                java.beans.BeanInfo info = java.beans.Introspector.getBeanInfo(bean);
                // ��ȡ����������
                java.beans.PropertyDescriptor pd[] = info.getPropertyDescriptors();
                // ����ֵ�ķ���
                Method mSet = null;
                // ����һ������
                Object obj = bean.newInstance();

                // ������bean��property����
                for (Iterator ite = foo.elementIterator("property"); ite.hasNext(); ) {
                    Element foo2 = (Element) ite.next();
                    // ��ȡ��property��name����
                    Attribute name = foo2.attribute("name");
                    String value = null;

                    // ��ȡ��property����Ԫ��value��ֵ
                    for (Iterator ite1 = foo2.elementIterator("value"); ite1.hasNext(); ) {
                        Element node = (Element) ite1.next();
                        value = node.getText();
                        break;
                    }

                    for (int k = 0; k < pd.length; k++) {
                        if (pd[k].getName().equalsIgnoreCase(name.getText())) {
                            mSet = pd[k].getWriteMethod();
                            // ����Java�ķ��伫�µ��ö����ĳ��set����������ֵ���ý�ȥ
                            mSet.invoke(obj, value);
                        }
                    }
                }

                // ���������beanMap�У�����keyΪidֵ��valueΪ����
                beanMap.put(id.getText(), obj);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * ͨ��bean��id��ȡbean�Ķ���.
     *
     * @param beanName bean��id
     * @return ���ض�Ӧ����
     */
    public Object getBean(String beanName) {
        Object obj = beanMap.get(beanName);
        return obj;
    }

    /**
     * ���Է���.
     *
     * @param args
     */
    public static void main(String[] args) {
        BeanFactory factory = new BeanFactory();
        factory.init("srping_simulator/config.xml");
        JavaBean javaBean = (JavaBean) factory.getBean("javaBean");
        System.out.println("userName=" + javaBean.getUserName());
        System.out.println("password=" + javaBean.getPassword());
    }
}
