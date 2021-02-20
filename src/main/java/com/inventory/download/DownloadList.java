package com.inventory.download;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.inventory.entity.Inventory;

public class DownloadList {

	private List<Inventory> inven_var;
	
	public DownloadList(List<Inventory> inven_var) {
		super();
		this.inven_var = inven_var;
	}

	private void tableData(PdfPTable table) {
		for(Inventory inventory:inven_var) {
			table.addCell(inventory.getName());
	        table.addCell(String.valueOf(inventory.getRating()));
		}
    }
	
	public void downloadList(HttpServletResponse response) throws DocumentException, IOException {
		com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4.rotate());
        PdfWriter.getInstance(document, response.getOutputStream());
        
        document.open();
        Paragraph p = new Paragraph("Product List");
        document.add(p);
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100f);
        PdfPCell cell = new PdfPCell();
        
        cell.setPhrase(new Phrase("Name"));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Rating"));
        table.addCell(cell);
        tableData(table);
        document.add(table);
        document.close();
    }
}
