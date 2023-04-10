package com.example.seedadvisory.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.example.seedadvisory.model.SeedDto;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PdfGenerator {

    public ByteArrayInputStream generateSeedReport(List<SeedDto> seeds) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font font = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD);
            Paragraph paragraph = new Paragraph("seed Advisory System ");
            document.add(paragraph);
            for (SeedDto seed : seeds) {
                Paragraph paragraph0 = new Paragraph(" ");
                Paragraph paragraph1 = new Paragraph("Seed name  : " + seed.getName(), font);
                Paragraph paragraph2 = new Paragraph("Seed Suitable for Locations :  " + seed.getSuitableLocations(),
                        font);
                Paragraph paragraph3 = new Paragraph("suitable for soilType : " + seed.getSuitableSoilTypes(), font);

                document.add(paragraph0);
                document.add(paragraph1);
                document.add(paragraph2);
                document.add(paragraph3);

            }

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}
