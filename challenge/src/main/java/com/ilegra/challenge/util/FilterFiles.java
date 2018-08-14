package com.ilegra.challenge.util;

import java.io.File;
import java.io.FilenameFilter;

public class FilterFiles implements FilenameFilter {


	public boolean accept(File dir, String name) {
		if(name.toLowerCase().endsWith(".dat")){
			return true;
		}
		return false;
	}
}
