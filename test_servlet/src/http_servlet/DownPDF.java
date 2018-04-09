package http_servlet;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class DownPDF extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Document document = new Document(PageSize.A4, 36, 36, 36, 36);
		ByteArrayOutputStream ba = new ByteArrayOutputStream();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, ba);
			document.open();
			document.add(new Paragraph("Hello World"));
		} catch (DocumentException de) {
			de.printStackTrace();
			System.err.println("A Document error:" + de.getMessage());
		}
		
		System.out.println("OK");
		
		document.close();
		response.setContentType("application/pdf");
		response.setContentLength(ba.size());
		ServletOutputStream out = response.getOutputStream();
		ba.writeTo(out);
		out.flush();
	}

}
