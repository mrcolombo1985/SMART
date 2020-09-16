package application.documentstypes;


//TODO


import application.entities.data.SensorEntity;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import java.io.IOException;
import java.util.List;

@SuppressWarnings("ALL")
public class PdfDocumentFormat {
    public static void createSensorsReport(List<SensorEntity> sensorEntityList) {
        try (PDDocument doc = new PDDocument()) {
            // a valid PDF document requires at least one page
            PDPage blankPage = new PDPage();

            doc.addPage(blankPage);
            PDPageContentStream contentStream =
                    new PDPageContentStream(doc, blankPage);
            drawTableSensor(blankPage, contentStream, 750, 20, sensorEntityList);
            contentStream.close();
            doc.save("F:\\Sensors.pdf");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void drawTableSensor(PDPage page, PDPageContentStream contentStream,
                                       float y, float margin,
                                       List<SensorEntity> sensorEntityList) throws IOException {
        final int rows = sensorEntityList.size() + 1;
        final int cols = 4;
        final float rowHeight = 20f;
        final float tableWidth = page.getMediaBox().getWidth() - (2 * margin);
        final float tableHeight = rowHeight * rows;
        final float colWidth = tableWidth / (float) cols;
        final float cellMargin = 5f;

        //draw the rows
        float nexty = y;
        for (int i = 0; i <= rows; i++) {
            contentStream.drawLine(margin, nexty, margin + tableWidth, nexty);
            nexty -= rowHeight;
        }

        //draw the columns
        float nextx = margin;
        for (int i = 0; i <= cols; i++) {
            contentStream.drawLine(nextx, y, nextx, y - tableHeight);
            nextx += colWidth;
        }

        //now add the text
        contentStream.setFont(PDType1Font.TIMES_ROMAN, 6);

        float textx = margin + cellMargin;
        float texty = y - 15;

        // Headers of Table

        String text = "Sensor Name";
        contentStream.beginText();
        contentStream.moveTextPositionByAmount(textx, texty);
        contentStream.drawString(text);
        contentStream.endText();
        textx += colWidth;

        text = "Description";
        contentStream.beginText();
        contentStream.moveTextPositionByAmount(textx, texty);
        contentStream.drawString(text);
        contentStream.endText();
        textx += colWidth;

        text = "Token";
        contentStream.beginText();
        contentStream.moveTextPositionByAmount(textx, texty);
        contentStream.drawString(text);
        contentStream.endText();
        textx += colWidth;

        text = "Arduino Name";
        contentStream.beginText();
        contentStream.moveTextPositionByAmount(textx, texty);
        contentStream.drawString(text);
        contentStream.endText();
        textx += colWidth;

        texty -= rowHeight;
        textx = margin + cellMargin;
        // Headers of Table

        for (int i = 0; i < sensorEntityList.size(); i++) {

            text = sensorEntityList.get(i).getNameSensor();
            contentStream.beginText();
            contentStream.moveTextPositionByAmount(textx, texty);
            contentStream.drawString(text);
            contentStream.endText();
            textx += colWidth;

            text = sensorEntityList.get(i).getDescription();
            contentStream.beginText();
            contentStream.moveTextPositionByAmount(textx, texty);
            contentStream.drawString(text);
            contentStream.endText();
            textx += colWidth;

            text = sensorEntityList.get(i).getArduino().getToken();
            contentStream.beginText();
            contentStream.moveTextPositionByAmount(textx, texty);
            contentStream.drawString(text);
            contentStream.endText();
            textx += colWidth;

            text = sensorEntityList.get(i).getArduino().getName();
            contentStream.beginText();
            contentStream.moveTextPositionByAmount(textx, texty);
            contentStream.drawString(text);
            contentStream.endText();
            textx += colWidth;


            texty -= rowHeight;
            textx = margin + cellMargin;
        }
    }
}
