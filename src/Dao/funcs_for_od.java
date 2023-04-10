package Dao;

import javax.swing.JCheckBox;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.spire.xls.Workbook;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import Model.Order_Management;

import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class funcs_for_od {
	
	public static void set_zero(JTextField amount) {
		if(Integer.parseInt((amount.getText())) < 0) {
			amount.setText("0");
		}	
	}
	
	public static void layout_to_print(JLabel acc_name, JCheckBox member_discount, JTextField paid_amount, Order_Management po){
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Order Details");
		sheet.getPrintSetup().setLandscape(true);
		sheet.getPrintSetup().setLeftMargin(1);
		sheet.getPrintSetup().setTopMargin(1);
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		sheet.addMergedRegion(new CellRangeAddress(4, 4, 1, 3));
		
		Font font_for_title = workbook.createFont();
		font_for_title.setFontName("Microsoft JhengHei");
		font_for_title.setFontHeightInPoints((short)36);
		font_for_title.setUnderline(Font.U_SINGLE);
		font_for_title.setBold(true);
		
		Font defaultFont = workbook.createFont();
		defaultFont.setFontName("Microsoft JhengHei");
		defaultFont.setFontHeightInPoints((short)18);
		
		CellStyle style_title = workbook.createCellStyle();
		style_title.setFont(font_for_title);
		style_title.setAlignment(HorizontalAlignment.CENTER);
		style_title.setVerticalAlignment(VerticalAlignment.CENTER);
		style_title.setBorderBottom(BorderStyle.NONE);
        style_title.setBorderTop(BorderStyle.NONE);
        style_title.setBorderLeft(BorderStyle.NONE);
        style_title.setBorderRight(BorderStyle.NONE);
        
        CellStyle style_od_info_t = workbook.createCellStyle();
		style_od_info_t.setFont(defaultFont);
		style_od_info_t.setAlignment(HorizontalAlignment.CENTER);
		style_od_info_t.setVerticalAlignment(VerticalAlignment.CENTER);
		style_od_info_t.setBorderBottom(BorderStyle.NONE);
        style_od_info_t.setBorderTop(BorderStyle.NONE);
        style_od_info_t.setBorderLeft(BorderStyle.NONE);
        style_od_info_t.setBorderRight(BorderStyle.NONE);
        
        CellStyle style_od_info_v = workbook.createCellStyle();
		style_od_info_v.setFont(defaultFont);
		style_od_info_v.setAlignment(HorizontalAlignment.LEFT);
		style_od_info_v.setVerticalAlignment(VerticalAlignment.CENTER);
		style_od_info_v.setBorderBottom(BorderStyle.NONE);
        style_od_info_v.setBorderTop(BorderStyle.NONE);
        style_od_info_v.setBorderLeft(BorderStyle.NONE);
        style_od_info_v.setBorderRight(BorderStyle.NONE);
		
		CellStyle style_default = workbook.createCellStyle();
		style_default.setFont(defaultFont);
		style_default.setAlignment(HorizontalAlignment.CENTER);
		style_default.setVerticalAlignment(VerticalAlignment.CENTER);
		style_default.setBorderBottom(BorderStyle.NONE);
        style_default.setBorderTop(BorderStyle.NONE);
        style_default.setBorderLeft(BorderStyle.NONE);
        style_default.setBorderRight(BorderStyle.NONE);
        
        CellStyle style_default_bt = workbook.createCellStyle();
		style_default_bt.setFont(defaultFont);
		style_default_bt.setAlignment(HorizontalAlignment.CENTER);
		style_default_bt.setVerticalAlignment(VerticalAlignment.CENTER);
		style_default_bt.setBorderBottom(BorderStyle.NONE);
        style_default_bt.setBorderTop(BorderStyle.THIN);
        style_default_bt.setBorderLeft(BorderStyle.NONE);
        style_default_bt.setBorderRight(BorderStyle.NONE);
        
        CellStyle style_default_result = workbook.createCellStyle();
		style_default_result.setFont(defaultFont);
		style_default_result.setAlignment(HorizontalAlignment.CENTER);
		style_default_result.setVerticalAlignment(VerticalAlignment.CENTER);
		style_default_result.setBorderBottom(BorderStyle.THICK);
        style_default_result.setBorderTop(BorderStyle.THIN);
        style_default_result.setBorderLeft(BorderStyle.NONE);
        style_default_result.setBorderRight(BorderStyle.NONE);
		
		Object[][] order_details = {
				{"肉燥便當", po.getBraised_p(), 65, "subtotal"},
				{"焢肉便當", po.getBelly_p(), 85, "subtotal"},
				{"雞腿便當", po.getDrumstick_c(), 75, "subtotal"},
				{"里肌便當", po.getFillet_p(), 80,"subtotal"},
				{"排骨便當", po.getRib_p(), 90, "subtotal"},
				{"腿排便當", po.getThigh_c(), 70, "subtotal"}
		};
		
		
		
		XSSFRow title = sheet.createRow(0);
		XSSFCell cell_title = title.createCell(0);
		cell_title.setCellValue("真好吃便當店");
		cell_title.setCellStyle(style_title);
		
		XSSFRow member_acc = sheet.createRow(2);
		XSSFCell ct_ma_t = member_acc.createCell(0);
		ct_ma_t.setCellValue("會員帳號：");
		ct_ma_t.setCellStyle(style_od_info_t);
		XSSFCell ct_ma = member_acc.createCell(1);
		ct_ma.setCellValue(po.getMember());
		ct_ma.setCellStyle(style_od_info_v);
		
		XSSFRow order_id = sheet.createRow(3);
		XSSFCell order_id_t = order_id.createCell(0);
		order_id_t.setCellValue("訂單編號：");
		order_id_t.setCellStyle(style_od_info_t);
		XSSFCell order_id_v = order_id.createCell(1);
		order_id_v.setCellValue(String.format("%05d", po.getOrder_id()));
		order_id_v.setCellStyle(style_od_info_v);
		
		XSSFRow create_time = sheet.createRow(4);
		XSSFCell create_time_t = create_time.createCell(0);
		create_time_t.setCellValue("建立時間：");
		create_time_t.setCellStyle(style_od_info_t);
		XSSFCell create_time_v = create_time.createCell(1);
		create_time_v.setCellValue(po.getCreate_time());
		create_time_v.setCellStyle(style_od_info_v);
		
		XSSFRow item_title = sheet.createRow(6);
		XSSFCell item_name = item_title.createCell(0);
		item_name.setCellValue("商品名稱");
		item_name.setCellStyle(style_default);
		XSSFCell item_q = item_title.createCell(1);
		item_q.setCellValue("數量");
		item_q.setCellStyle(style_default);
		XSSFCell item_p = item_title.createCell(2);
		item_p.setCellValue("價格");
		item_p.setCellStyle(style_default);
		XSSFCell item_subtotal = item_title.createCell(3);
		item_subtotal.setCellValue("小計");
		item_subtotal.setCellStyle(style_default);
		
		int rowCount = 6;
		int colCount = 0;
		
		for(Object[] item: order_details) {
			if((int)item[1] > 0) {
				XSSFRow row = sheet.createRow(++rowCount);
				
				colCount = -1;
				for(Object field: item) {
					XSSFCell cell = row.createCell(++colCount);
					if(rowCount == 7) {
						cell.setCellStyle(style_default_bt);
					} else {
						cell.setCellStyle(style_default);
					}
					if(field.equals("subtotal")) {
						cell.setCellFormula("B" + (rowCount + 1) + "*" + "C" + (rowCount + 1));
					}else if(field instanceof String) {
						cell.setCellValue((String) field);
					}else if(field instanceof Integer) {
						cell.setCellValue((Integer) field);
					}
				}
			}
		}
		XSSFRow order_sum = sheet.createRow(rowCount + 1);
		XSSFCell order_sum_t = order_sum.createCell(0);
		order_sum_t.setCellValue("總計");
		order_sum_t.setCellStyle(style_default_bt);
		for(int colNum = 1; colNum < colCount + 1; colNum++) {
			XSSFCell order_sum_line = order_sum.createCell(colNum);
			order_sum_line.setCellValue("");
			order_sum_line.setCellStyle(style_default_bt);
		}
		
		XSSFCell order_sum_v = order_sum.createCell(colCount);
		order_sum_v.setCellFormula("SUM(D5:D" + (rowCount + 1) + ")");
		order_sum_v.setCellStyle(style_default_bt);
		
		if(member_discount.isSelected()) {
			XSSFRow mem_dis = sheet.createRow(rowCount + 2);
			XSSFCell mem_dis_t = mem_dis.createCell(0);
			mem_dis_t.setCellValue("享會員8折優惠");
			mem_dis_t.setCellStyle(style_default);
			XSSFCell mem_dis_v = mem_dis.createCell(colCount);
			mem_dis_v.setCellFormula("D" + (rowCount + 2) + "*0.8");
			mem_dis_v.setCellStyle(style_default);
			
			XSSFRow money_paid = sheet.createRow(rowCount + 3);
			XSSFCell money_paid_t = money_paid.createCell(0);
			money_paid_t.setCellValue("支付");
			money_paid_t.setCellStyle(style_default);
			XSSFCell money_paid_v = money_paid.createCell(colCount);
			money_paid_v.setCellValue(Integer.parseInt(paid_amount.getText()));
			money_paid_v.setCellStyle(style_default);
			
			XSSFRow change = sheet.createRow(rowCount + 4);
			XSSFCell change_t = change.createCell(0);
			change_t.setCellValue("找回");
			change_t.setCellStyle(style_default_bt);
			for(int colNum = 1; colNum <3; colNum++) {
				XSSFCell change_b = change.createCell(colNum);
				change_b.setCellValue("");
				change_b.setCellStyle(style_default_bt);
			}	
			
			XSSFCell change_v = change.createCell(colCount);
			change_v.setCellFormula("D" + (rowCount + 4) + "-D" + (rowCount + 3));
			change_v.setCellStyle(style_default_result);
			workbook.setPrintArea(0, 0, colCount, 0, rowCount + 5);
		
		} else {
			XSSFRow money_paid = sheet.createRow(rowCount + 2);
			XSSFCell money_paid_t = money_paid.createCell(0);
			money_paid_t.setCellValue("支付");
			money_paid_t.setCellStyle(style_default);
			XSSFCell money_paid_v = money_paid.createCell(colCount);
			money_paid_v.setCellValue(Integer.parseInt(paid_amount.getText()));
			money_paid_v.setCellStyle(style_default);
			
			XSSFRow change = sheet.createRow(rowCount + 3);
			XSSFCell change_t = change.createCell(0);
			change_t.setCellValue("找回");
			change_t.setCellStyle(style_default_bt);
			for(int colNum = 1; colNum <3; colNum++) {
				XSSFCell change_b = change.createCell(colNum);
				change_b.setCellValue("");
				change_b.setCellStyle(style_default_bt);
			}	
			
			XSSFCell change_v = change.createCell(colCount);
			change_v.setCellFormula("D" + (rowCount + 3) + "-D" + (rowCount + 2));
			change_v.setCellStyle(style_default_result);
			workbook.setPrintArea(0, 0, colCount, 0, rowCount + 4);
		}
		
		sheet.autoSizeColumn(0);
		
		for(int i = 1; i < colCount + 1; i++) {
			sheet.setColumnWidth(i, 6000);
		}
		
		
		
		
		String file_path = "./Order_" + String.format("%05d", po.getOrder_id()) 
		+ "_" + po.getCreate_time().replaceAll("[^0-9]", "") + ".xlsx";
		try {
			FileOutputStream file_to_print = new FileOutputStream(file_path);
			workbook.write(file_to_print);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//		
//		File pic_f = new File(lunchbox_oms_od.class.getResource("/lunchbox.png").toString().substring(5));
//		
//		FileInputStream Logo_pic_file = null;
//		try {
//			Logo_pic_file = new FileInputStream(pic_f);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
//		String Logo_pic_name = pic_f.getName();
//		
//		try {
//			set_Logo_pic.addPicture(Logo_pic_file, XWPFDocument.PICTURE_TYPE_PNG, Logo_pic_name, Units.toEMU(200), Units.toEMU(200));
//		} catch (InvalidFormatException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		 Workbook wb = new Workbook();
	        wb.loadFromFile(file_path);

	       
	        PrinterJob pj = PrinterJob.getPrinterJob();
	       
	        //Create a PageFormat object and set it to the default size and orientation
	        PageFormat pf = pj.defaultPage();
	        pf.setOrientation(PageFormat.LANDSCAPE);
	        
	        pj.setPrintable(wb, pf);
	        
	        if(pj.printDialog()) {
	        	try {pj.print();
	        	} catch (PrinterException e) {
	        		e.printStackTrace();
	        	}
	        }
		
		
	}

}
