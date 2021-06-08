package com.project.work.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

@Service
public class HomeService {

    private final Log log = LogFactory.getLog(this.getClass());

    public String readPdfDocument() {

        String pdfFileInText = null;

        try (PDDocument document = PDDocument.load(ResourceUtils.getFile("classpath:letter.pdf"))) {

            if (!document.isEncrypted()) {

                //load the pdf content
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();

                //get the string
                pdfFileInText = tStripper.getText(document);
                pdfFileInText = pdfFileInText.replace("\n","<br>");
            }
        } catch (InvalidPasswordException e) {
            log.error("Error with document loading...");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pdfFileInText;
    }
}
