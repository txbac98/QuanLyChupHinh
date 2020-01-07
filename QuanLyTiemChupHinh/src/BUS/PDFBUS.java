/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 16520
 */
public class PDFBUS {
    public static void SavePDF(String path, String str) {
         Document document = new Document();
        try
        {           
           PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
           document.open();
             
             try {
                 BaseFont unicode = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                 document.add(new Paragraph(str, new com.itextpdf.text.Font(unicode, 12)));
             } catch (IOException ex) {
                 Logger.getLogger(PDFBUS.class.getName()).log(Level.SEVERE, null, ex);
                 document.add(new Paragraph(str, FontFactory.getFont(FontFactory.TIMES_ROMAN, 12)));
             }
            document.close();
           writer.close();
        } catch (DocumentException e)
        {
           e.printStackTrace();
        } catch (FileNotFoundException e)
        {
           e.printStackTrace();
        }     
    }
}
