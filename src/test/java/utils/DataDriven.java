package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataDriven {

    public static ArrayList<String> getData(String nombreCasoPrueba)  {

        ArrayList <String> a = new ArrayList<>();
        //Referenciar ruta del excel
        FileInputStream file = null;
        try {
            file = new FileInputStream(
                    PropertiesDriven.getProperty("rutaExcel"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        XSSFWorkbook excel = null;
        try {
            excel = new XSSFWorkbook(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int sheets = excel.getNumberOfSheets();

        for(int i=0; i < sheets;i++){
            if(excel.getSheetName(i).equalsIgnoreCase(PropertiesDriven.getProperty("hojaExcel"))){
                //encontre la Hoja
                XSSFSheet hojaExcel = excel.getSheetAt(i);

                Iterator<Row> filas = hojaExcel.iterator();

                Row fila = filas.next();

                Iterator<Cell> celdas = fila.cellIterator();

                int k = 0;
                int columna = 0;

                while(celdas.hasNext()){
                    Cell celdaSeleccionada = celdas.next();
                    //System.out.println(celda.getStringCellValue());
                    if(celdaSeleccionada.getStringCellValue().equalsIgnoreCase(PropertiesDriven.getProperty("tituloCPs"))){
                        columna = k;
                    }
                    k++;
                }

                while(filas.hasNext()){

                    Row r = filas.next();

                    if(r.getCell(columna).getStringCellValue().equalsIgnoreCase(nombreCasoPrueba)){

                        Iterator<Cell> cv = r.cellIterator();

                        while(cv.hasNext()){

                            Cell celda = cv.next();

                            if(celda.getCellType() == CellType.STRING){
                                //System.out.println(celda.getStringCellValue());
                                a.add(celda.getStringCellValue());
                            }else if(celda.getCellType() == CellType.NUMERIC){
                                //System.out.println(celda.getNumericCellValue());
                                a.add(NumberToTextConverter.toText(celda.getNumericCellValue()));
                            }

                        }

                    }
                }

            }
        }
        return a;
    }
}
