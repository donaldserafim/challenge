package com.ilegra.challenge.util;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.ilegra.challenge.config.Config;

public class FileUtil {
	
	public static List<String> readFile(Path path) throws IOException{
		return Files.readAllLines(path);
	}
	
	public static void writeFile(String data,String path) throws IOException{
			Files.write(Paths.get(path),data.getBytes());
	}
	
	public static void setup() throws IOException{
		File file = new File(Config.FILE_DIR_IN);
		if(!file.exists()){
			file.mkdirs();
		}
		file = new File(Config.FILE_DIR_OUT);
		if(!file.exists()){
			file.mkdirs();
		}
	}

	public static void moveFileAndDeleteSource(Path pathIn) throws IOException {
		Files.delete(pathIn);
	}
}