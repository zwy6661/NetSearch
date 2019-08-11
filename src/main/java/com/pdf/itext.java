package com.pdf;


import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfException;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class itext {
	
	public static void main(String[] a) throws PdfException, DocumentException, IOException {
		PdfReader pdf = new PdfReader("C:\\Users\\22682\\Desktop\\ Õ≤∑¥«÷Æ_√Ô_∫˙∆‰Œ∞.pdf");
		PdfStamper stp = new PdfStamper(pdf, new FileOutputStream("C:\\Users\\22682\\Desktop\\out.pdf"));
		PdfWriter writer = stp.getWriter();
		//Image img = Image.getInstance("image.png");
		PdfDictionary pg = pdf.getPageN(1);
		PdfDictionary res =
		    (PdfDictionary)PdfReader.getPdfObject(pg.get(PdfName.RESOURCES));
		PdfDictionary xobj =
		    (PdfDictionary)PdfReader.getPdfObject(res.get(PdfName.XOBJECT));
		if (xobj != null) {
		    for (Iterator it = xobj.getKeys().iterator(); it.hasNext(); ) {
		        PdfObject obj = xobj.get((PdfName)it.next());
		        if (obj.isIndirect()) {
		            PdfDictionary tg = (PdfDictionary)PdfReader.getPdfObject(obj);
		            PdfName type =
		                (PdfName)PdfReader.getPdfObject(tg.get(PdfName.SUBTYPE));
		            if (PdfName.IMAGE.equals(type)) {
		                PdfReader.killIndirect(obj);
		                //Image maskImage = img.getImageMask();
		                
		                System.out.println("end");
		                //if (maskImage != null)
		                //    writer.addDirectImageSimple(maskImage);
		                //writer.addDirectImageSimple(img, (PRIndirectReference)obj);
		                break;
		            }
		        }
		    }
		}
		stp.close();
	}
}
