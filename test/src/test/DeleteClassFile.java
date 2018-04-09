package test;

import java.io.File;

public class DeleteClassFile {
	public static void deleteClassFiles(File dir) {
		if (dir.isDirectory()) {
			File[] fs = dir.listFiles();
			if (fs != null)
				for (int i = 0; i < fs.length; i++) {
					deleteClassFiles(fs[i]);// 递归删除
				}
		} else if (dir.getName().endsWith(".class")) {// 后缀为.class的文件才删除
			// if(!dir.delete())dir.deleteOnExit();
			System.out.println(dir.delete() + "\t删除文件：" + dir.getAbsolutePath());
		}
	}
	
	public static void main(String[] args) {
		File file = new File("D:\\develop\\代码");
		deleteClassFiles(file);
	}
}
