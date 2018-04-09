package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperate {

	public static void main(String[] args) throws Exception {
		File file = new File("D:\\3.xlsx");
		String[][] result = getExceltData(file, 2, 60, 0, 2);
		int rowLength = result.length;
		
		String message = "以下数据导入失败，请核查：\n\n原代理商号		变更后代理商号	SN号  编码\n";
		
		for (int i = 0; i < rowLength; i++) {
			boolean flag = false;
			for (int j = 0; j < result[i].length; j++) {
				if (result[i][0] == null || "a".equals(result[i][0])) {
					message += result[i][j] + "		";
					flag = true;
				}
			}
			
			if (flag) {
				message += "\n";
			}
		}
	
		System.out.println(message);
	}

	/**
	 * 读取excel
	 * 
	 * @param file
	 * @param startRow 开始行，从0开始
	 * @param endRow 结束行，从0开始
	 * @param startCol 开始列，从0开始
	 * @param endCol 结束列，从0开始
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String[][] getExceltData(File file, int startRow, int endRow, int startCol, int endCol) throws FileNotFoundException, IOException {
		List<String[]> result = new ArrayList<String[]>();
		Workbook wb = null;
		InputStream in = null;
		try {
			in = new FileInputStream(file);
			wb = WorkbookFactory.create(in);

			if (wb instanceof XSSFWorkbook) {
				result = getXSSFResult(wb, startRow, endRow, startCol, endCol);
			} else if (wb instanceof HSSFWorkbook) {
				result = getHSSFResult(wb, startRow, endRow, startCol, endCol);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			in.close();
		}

		String[][] returnArray = new String[0][0];
		if (result != null && result.size() > 0) {
			returnArray = new String[result.size()][result.get(0).length];
			for (int i = 0; i < returnArray.length; i++) {
				returnArray[i] = (String[]) result.get(i);
			}
		}

		return returnArray;
	}
	
	/**
	 * 获取表格内容
	 * 
	 * @param wb
	 * @param startRow 开始行，从0开始
	 * @param endRow 结束行，从0开始
	 * @param startCol 开始列，从0开始
	 * @param endCol 结束列，从0开始
	 * @return
	 */
	private static List<String[]> getXSSFResult(Workbook wb, int startRow, int endRow, int startCol, int endCol) {
		List<String[]> result = new ArrayList<String[]>();

		for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
			XSSFSheet sheet = (XSSFSheet) wb.getSheetAt(sheetIndex);
			int firstRowNum = sheet.getFirstRowNum();
			int lastRowNum = sheet.getLastRowNum();
			
			if (startRow < firstRowNum) {
				startRow = firstRowNum;
			}
			
			if (endRow > lastRowNum) {
				endRow = lastRowNum;
			}
			
			for (int rowIndex = startRow; rowIndex <= endRow; rowIndex++) {
				XSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				
				int firstCellNum = row.getFirstCellNum();
				int lastCellNum = row.getLastCellNum();
				
				if (startCol < firstCellNum) {
					startCol = firstCellNum;
				}
				
				if (endCol > lastCellNum) {
					endCol = lastCellNum;
				}
				
				String[] values = new String[endCol - startCol + 1];
				Arrays.fill(values, "");

				int blankCellCount = 0;
				for (int colIndex = startCol; colIndex <= endCol; colIndex++) {
					String value = "";
					XSSFCell cell = row.getCell(colIndex);
					
					if (cell != null) {
						// 注意：一定要设成这个，否则可能会出现乱码
						// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								Date date = cell.getDateCellValue();
								if (date != null) {
									value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
								} else {
									value = "";
								}
							} else {
								value = new DecimalFormat("0").format(cell.getNumericCellValue());
							}
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_FORMULA:
							// 导入时如果为公式生成的数据则无值
							if (!cell.getStringCellValue().equals("")) {
								value = cell.getStringCellValue();
							} else {
								value = cell.getNumericCellValue() + "";
							}
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							blankCellCount ++;
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						default:
							value = "";
						}
					}

					values[colIndex] = rightTrim(value.trim());
				}

				if (blankCellCount < endCol - startCol + 1) {
					result.add(values);
				}
			}
		}

		return result;
	}

	/**
	 * 获取表格内容
	 * 
	 * @param wb
	 * @param startRow 开始行，从0开始
	 * @param endRow 结束行，从0开始
	 * @param startCol 开始列，从0开始
	 * @param endCol 结束列，从0开始
	 * @return
	 */
	private static List<String[]> getHSSFResult(Workbook wb, int startRow, int endRow, int startCol, int endCol) {
		List<String[]> result = new ArrayList<String[]>();

		for (int sheetIndex = 0; sheetIndex < wb.getNumberOfSheets(); sheetIndex++) {
			HSSFSheet sheet = (HSSFSheet) wb.getSheetAt(sheetIndex);
			int firstRowNum = sheet.getFirstRowNum();
			int lastRowNum = sheet.getLastRowNum();
			
			if (startRow < firstRowNum) {
				startRow = firstRowNum;
			}
			
			if (endRow > lastRowNum) {
				endRow = lastRowNum;
			}
			
			for (int rowIndex = startRow; rowIndex <= endRow; rowIndex++) {
				HSSFRow row = sheet.getRow(rowIndex);
				if (row == null) {
					continue;
				}
				
				int firstCellNum = row.getFirstCellNum();
				int lastCellNum = row.getLastCellNum();
				
				if (startCol < firstCellNum) {
					startCol = firstCellNum;
				}
				
				if (endCol > lastCellNum) {
					endCol = lastCellNum;
				}

				String[] values = new String[endCol - startCol + 1];
				Arrays.fill(values, "");

				int blankCellCount = 0;
				for (int colIndex = startCol; colIndex <= endCol; colIndex++) {
					String value = "";
					HSSFCell cell = row.getCell(colIndex);
					if (cell != null) {
						// 注意：一定要设成这个，否则可能会出现乱码
						// cell.setEncoding(HSSFCell.ENCODING_UTF_16);
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC:
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								Date date = cell.getDateCellValue();
								if (date != null) {
									value = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
								} else {
									value = "";
								}
							} else {
								value = new DecimalFormat("0").format(cell.getNumericCellValue());
							}
							break;
						case HSSFCell.CELL_TYPE_STRING:
							value = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_FORMULA:
							// 导入时如果为公式生成的数据则无值
							if (!cell.getStringCellValue().equals("")) {
								value = cell.getStringCellValue();
							} else {
								value = cell.getNumericCellValue() + "";
							}
							break;
						case HSSFCell.CELL_TYPE_BLANK:
							blankCellCount++;
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN:
							value = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_ERROR:
							value = cell.getErrorCellValue() + "";
							break;
						default:
							value = "";
						}
					}

					values[colIndex] = rightTrim(value.trim());
				}

				if (blankCellCount < endCol - startCol + 1) {
					result.add(values);
				}
			}
		}

		return result;
	}

	private static final String TEMP_FILE_NAME = "temp";

	private String output2File(InputStream streamIn) throws IOException {
		String dir = getServletPath() + TEMP_FILE_NAME;
		// 上传的路径+文件名
		File uploadFile = new File(dir);
		if (!uploadFile.exists() || uploadFile == null) { // 判断指定路径dir是否存在，不存在则创建路径
			uploadFile.mkdirs();
		}
		// OutputStream用于向某个目标写入字节的抽象类，这个地方写入目标是path，通过输出流FileOutputStream去写
		String path = dir + "\\temp.xls";
		OutputStream streamOut = new FileOutputStream(path);
		int bytesRead = 0;
		byte[] buffer = new byte[8192];
		// 将数据读入byte数组的一部分，其中读入字节数的最大值是8192，读入的字节将存储到，buffer[0]到buffer[0+8190-1]的部分中
		// streamIn.read方法返回的是实际读取字节数目.如果读到末尾则返回-1.如果bytesRead返回为0则表示没有读取任何字节。
		while ((bytesRead = streamIn.read(buffer, 0, 8192)) != -1) {
			// 写入buffer数组的一部分，从buf[0]开始写入并写入bytesRead个字节，这个write方法将发生阻塞直至字节写入完成。
			streamOut.write(buffer, 0, bytesRead);
		}
		// 关闭输出输入流,销毁File流。
		streamOut.close();
		streamIn.close();
		return path;
	}

	private String getServletPath() {
		String url = this.getClass().getResource("/").getPath();
		return url;
	}

	/**
	 * 去掉字符串右边的空格
	 *
	 * @param str 要处理的字符串
	 * @return 处理后的字符串
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

}
