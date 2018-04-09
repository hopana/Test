package dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ParseXmlDocTest {
	public static void main(String[] args) {
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(new File("./xml/book.xml"));

			/******************** 操作节点的属性(attribute)值 ********************/
			List list = document.selectNodes("//book/@category");
			Iterator iter = list.iterator();
			while (iter.hasNext()) {
				Attribute attribute = (Attribute) iter.next();
				if (attribute.getValue().equals("WEB"))
					attribute.setValue("XML");
			}

			list = document.selectNodes("//title/@lang");
			iter = list.iterator();
			while (iter.hasNext()) {
				Attribute attribute = (Attribute) iter.next();
				if (attribute.getValue().equals("en"))
					attribute.setValue("chinese");
			}

			/******************** 操作节点的value值 ********************/
			list = document.selectNodes("//book");
			iter = list.iterator();
			while (iter.hasNext()) {
				Element element = (Element) iter.next();
				Iterator iterator = element.elementIterator("title");
				while (iterator.hasNext()) {
					Element titleElement = (Element) iterator.next();
					if (titleElement.getText().equals("Everyday Italian"))
						titleElement.setText("Everyday Chinese");
				}
			}

			list = document.selectNodes("//book");
			iter = list.iterator();
			while (iter.hasNext()) {
				Element element = (Element) iter.next();
				Iterator iterator = element.elementIterator("year");
				while (iterator.hasNext()) {
					Element titleElement = (Element) iterator.next();
					if (titleElement.getText().equals("2003"))
						titleElement.setText("2013");
				}
			}

			/******************** 准确选择位置 *********************/

			// 注意：如果有多个book或者title节点，它只会读取第一个
			Node singleNode = document.selectSingleNode("//book/title");
			if (singleNode != null && singleNode.hasContent()) {
				singleNode.setText("title");
			}

			// 选取bookstore下面的第2个book节点下的price节点
			Node node = document.selectSingleNode("/bookstore/book[3]/title[@test='test']");
			System.out.println(node.getText());

			XMLWriter output = new XMLWriter(new FileWriter(new File("./xml/book-modified.xml")));
			output.write(document);
			output.close();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
