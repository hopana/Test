package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * excel工具类
 * @author mickey
 */
public class ExcelUtil {
	static final Log log = LogFactory.getLog(ExcelUtil.class);

	public static String[][] readExcel(String filePath) {
		List<String[]> result = new ArrayList<String[]>();
		FileInputStream fis = null;
		int cellNum = 0;

		try {
			File file = new File(filePath);
			fis = new FileInputStream(file);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			int sheetNum = wb.getNumberOfSheets();

			for (int i = 0; i < sheetNum; i++) {
				XSSFSheet sheet = wb.getSheetAt(i);
				int rowNum = sheet.getLastRowNum() + 1;

				for (int rowIndex = sheet.getFirstRowNum(); rowIndex < rowNum; rowIndex++) {
					XSSFRow row = sheet.getRow(rowIndex);
					if (row == null) {
						continue;
					}

					cellNum = row.getLastCellNum() + 1;

					String[] values = new String[cellNum];
					Arrays.fill(values, "");

					for (int colIndex = row.getFirstCellNum(); colIndex < cellNum; colIndex++) {
						XSSFCell cell = row.getCell(colIndex);
						if (cell == null) {
							continue;
						}

						String cellValue = null;
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								Date date = cell.getDateCellValue();
								if (date != null) {
									cellValue = new SimpleDateFormat("yyyy-MM-dd").format(date);
								} else {
									cellValue = "";
								}
							} else {
								cellValue = new DecimalFormat("0").format(cell.getNumericCellValue());
							}
							break;
						case HSSFCell.CELL_TYPE_STRING:
							cellValue = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_FORMULA:
							// 导入时如果为公式生成的数据则无值
							if (!cell.getStringCellValue().equals("")) {
								cellValue = cell.getStringCellValue();
							} else {
								cellValue = cell.getNumericCellValue() + "";
							}
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							cellValue = "";
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							cellValue = String.valueOf(cell.getBooleanCellValue());
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							cellValue = String.valueOf(cell.getErrorCellValue());
							break;
						}

						values[colIndex] = rightTrim(cellValue.trim());
					}

					result.add(values);
				}
			}
		} catch (Exception e) {
			log.error("读取excel文件异常");
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String[][] returnArray = new String[result.size()][cellNum];
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = (String[]) result.get(i);
		}

		return returnArray;
	}

	public static String[][] readExcel(String filePath, int startRow, int startCol, int sheetNum) {
		List<String[]> result = new ArrayList<String[]>();
		FileInputStream fis = null;
		int cellNum = 0;

		try {
			File file = new File(filePath);
			fis = new FileInputStream(file);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(sheetNum);

			int rowNum = sheet.getLastRowNum() + 1;

			for (int rowIndex = startRow; rowIndex < rowNum; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}

				cellNum = row.getLastCellNum() + 1;

				String[] values = new String[cellNum];
				Arrays.fill(values, "");

				for (int colIndex = startCol; colIndex < cellNum; colIndex++) {
					XSSFCell cell = row.getCell(colIndex);
					if (cell == null) {
						continue;
					}

					String cellValue = null;
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC:
						if (HSSFDateUtil.isCellDateFormatted(cell)) {
							Date date = cell.getDateCellValue();
							if (date != null) {
								cellValue = new SimpleDateFormat("yyyy-MM-dd").format(date);
							} else {
								cellValue = "";
							}
						} else {
							cellValue = new DecimalFormat("0").format(cell.getNumericCellValue());
						}
						break;
					case HSSFCell.CELL_TYPE_STRING:
						cellValue = cell.getStringCellValue();
						break;
					case HSSFCell.CELL_TYPE_FORMULA:
						// 导入时如果为公式生成的数据则无值
						if (!cell.getStringCellValue().equals("")) {
							cellValue = cell.getStringCellValue();
						} else {
							cellValue = cell.getNumericCellValue() + "";
						}
						break;
					case HSSFCell.CELL_TYPE_BLANK:
						cellValue = "";
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						cellValue = String.valueOf(cell.getBooleanCellValue());
						break;
					case HSSFCell.CELL_TYPE_ERROR:
						cellValue = String.valueOf(cell.getErrorCellValue());
						break;
					}

					values[colIndex] = rightTrim(cellValue.trim());
				}

				result.add(values);
			}

		} catch (Exception e) {
			log.error("读取excel文件异常");
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String[][] returnArray = new String[result.size()][cellNum];
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = (String[]) result.get(i);
		}

		return returnArray;
	}

	/**
	 * 读取excel文件
	 * 
	 * @param filePath 文件路径
	 * @param startRow 开始行号
	 * @param endRow   结束行号
	 * @param startCol 开始列号
	 * @param endCol   结束列号
	 * @param sheetNum sheet
	 * @return String[][]
	 * @author mickey
	 */
	public static String[][] readExcel(String filePath, int startRow, int endRow, int startCol, int endCol, int sheetNum) {
		List<String[]> result = new ArrayList<String[]>();
		FileInputStream fis = null;

		try {
			File file = new File(filePath);
			fis = new FileInputStream(file);

			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheetAt(sheetNum);

			int rowNum = sheet.getLastRowNum() + 1;
			if (endRow > rowNum) {
				endRow = rowNum;
			}

			for (int rowIndex = startRow; rowIndex < endRow; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}

				int cellNum = row.getLastCellNum() + 1;
				if (endCol > cellNum) {
					endCol = cellNum;
				}

				String[] values = new String[endCol];
				Arrays.fill(values, "");

				for (int colIndex = startCol; colIndex < endCol; colIndex++) {
					XSSFCell cell = row.getCell(colIndex);
					if (cell == null) {
						continue;
					}

					String cellValue = null;
					switch (cell.getCellType()) {
					case HSSFCell.CELL_TYPE_NUMERIC:
						if (HSSFDateUtil.isCellDateFormatted(cell)) {
							Date date = cell.getDateCellValue();
							if (date != null) {
								cellValue = new SimpleDateFormat("yyyy-MM-dd").format(date);
							} else {
								cellValue = "";
							}
						} else {
							cellValue = new DecimalFormat("0").format(cell.getNumericCellValue());
						}
						break;
					case HSSFCell.CELL_TYPE_STRING:
						cellValue = cell.getStringCellValue();
						break;
					case HSSFCell.CELL_TYPE_FORMULA:
						// 导入时如果为公式生成的数据则无值
						if (!cell.getStringCellValue().equals("")) {
							cellValue = cell.getStringCellValue();
						} else {
							cellValue = cell.getNumericCellValue() + "";
						}
						break;
					case HSSFCell.CELL_TYPE_BLANK:
						cellValue = "";
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						cellValue = String.valueOf(cell.getBooleanCellValue());
						break;
					case HSSFCell.CELL_TYPE_ERROR:
						cellValue = String.valueOf(cell.getErrorCellValue());
						break;
					}

					values[colIndex] = rightTrim(cellValue.trim());
				}

				result.add(values);
			}

		} catch (Exception e) {
			log.error("读取excel文件异常");
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String[][] returnArray = new String[result.size()][endCol];
		for (int i = 0; i < returnArray.length; i++) {
			returnArray[i] = (String[]) result.get(i);
		}

		return returnArray;
	}

	/**
	 * 去掉字符串右边的空格
	 * 
	 * @param str 要处理的字符串
	 * @return 处理后的字符串
	 * @author mickey
	 */

	public static String rightTrim(String str) {
		if (str == null) {
			return "";
		}

		int length = str.length();
		for (int i = length - 1; i >= 0; i--) {
			if (str.charAt(i) != 0x20) {
				break;
			}

			length--;
		}

		return str.substring(0, length);
	}

	public static void main(String[] args) {
		String[][] arr = readExcel("D:\\3.xlsx");
		for (String s[] : arr) {
			for (String str : s) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
}
