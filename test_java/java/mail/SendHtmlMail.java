package mail;

/**
 * comment
 *
 * @author hupan
 * @date 2017-08-11 14:00:52
 */
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.List;

/**
 * 类描述：示例如何根据html模板发送html邮件
 * @author xiezd
 *
 */
public class SendHtmlMail {
    @Test
    public void send(){
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            //获取模板html文档
            document = reader.read(SendHtmlMail.class.getResource("./pageTemplet.html").getPath());
            Element root = document.getRootElement();
            //分别获取id为name、message、time的节点。
            Element name = getNodes(root,"id","name");
            Element url = getNodes(root,"id","url");

            //设置收件人姓名，通知信息、当前时间
            Calendar calendar = Calendar.getInstance();
            name.setText("小明");
            //随便写的
            url.setText("http://hihocoder.com/user/activate?key=f9a999491121424761850116197a847d");
            url.setAttributeValue("href", "http://hihocoder.com/user/activate?key=f9a999491121424761850116197a847d");

            //保存到临时文件
            FileWriter fwriter = new FileWriter("d:/temp.html");
            XMLWriter writer = new XMLWriter(fwriter);
            writer.write(document);
            writer.flush();
            //读取临时文件，并把ht ml数据写入到字符串str中，通过邮箱工具发送
            FileReader in = new FileReader("d:/temp.html");
            char[] buff = new char[1024*10];
            in.read(buff);
            String str = new String(buff);
            System.out.println(str.toString());

            new MailSender.Builder(str.toString(),"391505142@qq.com").send();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 方法描述：递归遍历子节点，根据属性名和属性值，找到对应属性名和属性值的那个子孙节点。
     * @param node 要进行子节点遍历的节点
     * @param attrName 属性名
     * @param attrValue 属性值
     * @return 返回对应的节点或null
     */
    public Element getNodes(Element node, String attrName, String attrValue) {

        final List<Attribute> listAttr = node.attributes();// 当前节点的所有属性
        for (final Attribute attr : listAttr) {// 遍历当前节点的所有属性
            final String name = attr.getName();// 属性名称
            final String value = attr.getValue();// 属性的值
            System.out.println("属性名称：" + name + "---->属性值：" + value);
            if(attrName.equals(name) && attrValue.equals(value)){
                return node;
            }
        }
        // 递归遍历当前节点所有的子节点
        final List<Element> listElement = node.elements();// 所有一级子节点的list
        for (Element e : listElement) {// 遍历所有一级子节点
            Element temp = getNodes(e,attrName,attrValue);
            // 递归
            if(temp != null){
                return temp;
            };
        }

        return null;
    }

}