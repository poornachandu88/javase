package foldersandfiles;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

public class DisplayFilesAndFolders {
	
	public static void displayDirectoryContents(File directorypath) throws IOException 
	{
	
		List<File> files = (List<File>) FileUtils.listFiles(directorypath, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
		for (File file : files)
		{
							System.out.println("file name :" + file.getName());
		}
		}
	
	public static void main(String[] args) throws IOException
	
	{
		File directorypath = new File("D:/spring/");
		DisplayFilesAndFolders.displayDirectoryContents(directorypath);
	}

}
