package dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.omg.CORBA.portable.OutputStream;

/*
 <bookstore>
 <book category="COOKING">
 <title lang="en">Everyday Italian</title> 
 <author>Giada De Laurentiis</author> 
 <year>2005</year> 
 <price>30.00</price> 
 </book>
 <book category="CHILDREN">
 <title lang="en">Harry Potter</title> 
 <author>J K. Rowling</author> 
 <year>2005</year> 
 <price>29.99</price> 
 </book>
 <book category="WEB">
 <title lang="en">Learning XML</title> 
 <author>Erik T. Ray</author> 
 <year>2003</year> 
 <price>39.95</price> 
 </book>
 </bookstore>
 */

public class CreateXmlDocTest {
	public static void main(String[] args) {
		Document doc = DocumentHelper.createDocument();
		Element bookstore = doc.addElement("bookstore");

		/*********** book1 ************/
		Element book1 = DocumentHelper.createElement("book");
		book1.addAttribute("category", "COOKING");

		Element title1 = DocumentHelper.createElement("title");
		title1.addAttribute("lang", "en");
		title1.addAttribute("test", "1");
		title1.addText("Everyday Italian");

		Element author1 = DocumentHelper.createElement("author");
		author1.addText("Everyday Italian");

		Element year1 = DocumentHelper.createElement("year");
		year1.addText("2005");

		Element price1 = DocumentHelper.createElement("price");
		price1.addText("30.00");

		book1.add(title1);
		book1.add(author1);
		book1.add(year1);
		book1.add(price1);

		/*********** book2 ************/
		Element book2 = DocumentHelper.createElement("book");
		book2.addAttribute("category", "CHILDREN");

		Element title2 = DocumentHelper.createElement("title");
		title2.addAttribute("lang", "en");
		title2.addAttribute("test", "test");
		title2.addText("Harry Potter");

		Element author2 = DocumentHelper.createElement("author");
		author2.addText("J K. Rowling");

		Element year2 = DocumentHelper.createElement("year");
		year2.addText("2005");

		Element price2 = DocumentHelper.createElement("price");
		price2.addText("29.99");

		book2.add(title2);
		book2.add(author2);
		book2.add(year2);
		book2.add(price2);

		/*********** book3 ************/
		Element book3 = DocumentHelper.createElement("book");
		book3.addAttribute("category", "WEB");

		Element title3 = DocumentHelper.createElement("title");
		title3.addAttribute("lang", "en");
		title3.addAttribute("test", "3");
		title3.addText("Learning XML");

		Element author3 = DocumentHelper.createElement("author");
		author3.addText("Erik T. Ray");

		Element year3 = DocumentHelper.createElement("year");
		year3.addText("2003");

		Element price3 = DocumentHelper.createElement("price");
		price3.addText("39.95");

		book3.add(title3);
		book3.add(author3);
		book3.add(year3);
		book3.add(price3);

		bookstore.add(book1);
		bookstore.add(book2);
		bookstore.add(book3);

		OutputFormat format = OutputFormat.createCompactFormat();
		format.setSuppressDeclaration(true);/**去掉xml头
		format.isPadText();
		format.setEncoding("utf-8");
		
		doc.addDocType("catalog", null, "file:/**c:/Dtds/catalog.dtd");
		try {
			FileOutputStream fos = new FileOutputStream(new File("./xml/book.xml"));
			XMLWriter output = new XMLWriter(fos,format);
			output.write(doc);
			output.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		String xml = doc.asXML();
		System.out.println(xml);
	}
}
