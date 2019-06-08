package foldersandfiles;

import java.io.File;


import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;


class FileFilterDateIntervalUtils implements FilenameFilter {
	String dateStart;
	String dateEnd;
	SimpleDateFormat sdf;
	public FileFilterDateIntervalUtils(String dateStart, String dateEnd) {
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	}
	public boolean accept(File dir, String name) {
		Date d = new Date(new File(dir, name).lastModified());
		String current = sdf.format(d);
	return ((dateStart.compareTo(current) <= 0 && (dateEnd.compareTo(current) >= 0)));
	}
}
public class DisplayProjectFilesAndFolders {
	public static void displayDirectoryContents(File dir) 
	{
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy  " + " HH:mm:ss");
			FileFilterDateIntervalUtils filter = new FileFilterDateIntervalUtils("06/11/2018 06:59:30",	"06/18/2018 18:33:43");
			File files[] = dir.listFiles(filter);
			for (File file : files) {
				if (file.isDirectory()) {
					System.out.println("\n directory name :" + file.getCanonicalPath());
					DisplayProjectFilesAndFolders.displayDirectoryContents(file);

				} 
				else {
					
					System.out.println(" \n File Name     : " + file.getName() + "\n Date and Time :" + sdf.format(new Date(file.lastModified())));
					File f = new File(file.getAbsolutePath());
					File destinationDir = new File("D:\\output\\");
					FileUtils.copyFileToDirectory(f, destinationDir);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		File currentDir = new File("D:\\spring\\");
		DisplayProjectFilesAndFolders.displayDirectoryContents(currentDir);
	}
}


