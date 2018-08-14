package com.ilegra.challenge;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ilegra.challenge.config.Config;
import com.ilegra.challenge.service.FileService;
import com.ilegra.challenge.util.FileUtil;
import com.ilegra.challenge.util.FilterFiles;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	FileUtil.setup();

		ExecutorService threadExecutorRecordFileAction = Executors.newFixedThreadPool(3);

		while(true){
			
			File path = new File(Config.FILE_DIR_IN);
			
			String[] files = path.list(new FilterFiles());
			
			for (String file : files) {
				System.out.println("Processando Arquivo:"+file);
				threadExecutorRecordFileAction.submit(new FileService(Paths.get(Config.FILE_DIR_IN+File.separator+file), Paths.get(Config.FILE_DIR_OUT)));
			}
		}
    }
}
