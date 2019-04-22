package descddl;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class Excel extends Executionstep{
    private static final String EXCEL_FILE_LOCATION ="C:/Users/sandya.nandakumar/Desktop/sassignment2/excel1.xls";
    public void write_to_excel(ArrayList exe) throws IOException {
        WritableWorkbook myFirstWbook = null;        
        try {        	
           myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));
           WritableSheet sheet = myFirstWbook.createSheet("Sheet 1", 0);        
ArrayList header=new ArrayList();
header.add("Field");
header.add("Datatype&size");
header.add("nullable?");
header.add("key");
header.add("default value");
header.add("others");
exe.add(0, header);
            ArrayList len=(ArrayList) exe.get(0);        
            for(int j=0;j<exe.size();j++)
            {
            	for(int i=0;i<len.size();i++)
            	{
            Label label = new Label(i, j, (String) ((ArrayList) exe.get(j)).get(i));
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
 

