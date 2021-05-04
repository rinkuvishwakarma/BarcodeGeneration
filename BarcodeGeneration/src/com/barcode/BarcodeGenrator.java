package com.barcode;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfWriter;

public class BarcodeGenrator {

	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		
		Document document = new Document(new Rectangle(PageSize.A4));
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("path where the file will be created /barcode2.pdf"));
		document.open();
		document.add(new Paragraph("New Barcode"));
		
		for(int i = 0 ; i <= 3; i++) {
			Barcode128 code128 = new Barcode128();
			code128.setGenerateChecksum(true);
			//code128.setCode("8880011"+i);
			code128.setCode("8880011"+i+ " SALE PRICE:499");
			document.add(code128.createImageWithBarcode(writer.getDirectContent(), null, null));
		}
		
	    document.close();
	    System.out.println("Document Generated...!!!!!!");

	}

}
