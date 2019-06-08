package foldersandfiles;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.AgeFileFilter;
import org.apache.commons.io.filefilter.DirectoryFileFilter;

public class GetFilesBeforeAndAfterDate {
	public static void displayFiles(File directorypath, FileFilter fileFilter) throws IOException {
	File[] files = directorypath.listFiles(fileFilter);
	for (File file : files) {
				if(file.isFile()) {
				Date lastMod = new Date(file.lastModified());

				SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
				System.out.println("FileName : " + file.getName() + ", \n Date: " + ft.format(lastMod) + "");

				File file1 = new File(file.getAbsolutePath());
				File destinationDir = new File("D:/output/");
				FileUtils.copyFileToDirectory(file1, destinationDir);
			}
		}
	}
	public static void main(String[] args) throws IOException {
	
		File directorys = new File("D:/spring/");
		
		File[] subdirs = directorys.listFiles((FileFilter) DirectoryFileFilter.DIRECTORY);
		File directory=null;
		for (File dir : subdirs) {
			System.out.println(" \n Directory: " + dir.getCanonicalPath());
			directory = new File(dir.getCanonicalPath());
			
		//before false no print   so before data restrict 
		GregorianCalendar cal = new GregorianCalendar();
		cal.set(2018, 05, 11, 06, 50, 0); // June 11th, 2018  //after 6 am 
		 Date cutoffDateboforerestrict=cal.getTime();
		
		displayFiles(directory, new AgeFileFilter(cutoffDateboforerestrict)); 
		//before prints after restrict 
		
		GregorianCalendar cal2 = new GregorianCalendar();
		cal2.set(2018, 05, 11, 18, 50, 0); // June 11th, 2018  //before 6 pm 
		Date cutoffDateboforerestrict2=cal2.getTime();
		displayFiles(directory, new AgeFileFilter(cutoffDateboforerestrict2));//it prints after only
		}
	}

}
