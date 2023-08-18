package com.hcl.stepdef;

import com.hcl.baseframework.ExcelUtils;

public class TestExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ExcelUtils  dd = new ExcelUtils ("WarningMessages.xlsx","Sheet1");
	      System.out.println("The Row count is " + dd.excel_get_rows());
	      dd.getCellDataasnumber(1, 1);
	      dd.getCellDataasnumber(1, 2);
	      dd.getCellDataasnumber(1, 3);
	      dd.getCellDataasnumber(2, 1);
	      dd.getCellDataasnumber(2, 2);
	      dd.getCellDataasnumber(2, 3);
	      dd.getCellDataasnumber(3, 1);
	      dd.getCellDataasnumber(3, 2);
	      dd.getCellDataasnumber(3, 3);
	}

}
