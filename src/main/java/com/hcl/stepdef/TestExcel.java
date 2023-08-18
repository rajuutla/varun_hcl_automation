package com.hcl.stepdef;

import com.hcl.baseframework.ExcelUtils;

public class TestExcel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		ExcelUtils  dd = new ExcelUtils ("WarningMessages.xlsx","Sheet1");
	      System.out.println("The Row count is " + dd.excel_get_rows());
	      dd.getCellDataasstring(1, 0);
	      dd.getCellDataasstring(1, 1);
	      //dd.getCellDataasstring(1, 3);
	      dd.getCellDataasstring(2, 0);
	      dd.getCellDataasstring(2, 1);
	      dd.getCellDataasnumber(3, 0);
	      dd.getCellDataasnumber(3, 1);
	      dd.getCellDataasnumber(4, 0);
	      dd.getCellDataasnumber(4, 1);
	}

}
