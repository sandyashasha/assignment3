package trailing;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
 

public class excel extends ddlparserjunk{

    private static final String EXCEL_FILE_LOCATION = "C:/Users/sandya.nandakumar/Desktop/sassignment2/excel1.xls";

    public void write_to_excel(ArrayList exe) throws IOException {

        //1. Create an Excel file
        WritableWorkbook myFirstWbook = null;
        
        try {
        	
            myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));
           WritableSheet sheet = myFirstWbook.createSheet("Sheet 1", 0);
         
ArrayList header=new ArrayList();
/*WritableCellFormat cFormat = new WritableCellFormat();
WritableFont font = new WritableFont(WritableFont.ARIAL, 16, WritableFont.BOLD);
cFormat.setFont(font);
Label label1 = new Label(1, 0, "Field", cFormat);
excelSheet.addCell(label1);*/

header.add("Field");

header.add("Dtatype");
header.add("size");
header.add("nullable?");
exe.add(0, header);


            ArrayList len=(ArrayList) exe.get(0);
            
        
            
            for(int j=0;j<exe.size();j++)
            {
            	for(int i=0;i<len.size();i++)
            	{
            	//System.out.println(j);
            Label label = new Label(i, j, ((ArrayList) exe.get(j)).get(i).toString());
            sheet.addCell(label);
            	}
  
            }

            myFirstWbook.write();
            

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } finally {

            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }


        }
        }
 
    }

