package com.ilegra.challenge.config;

import java.io.File;

public class Config {
	
	public static final String SALESMAN = "001";
	public static final String CUSTOMER = "002";
	public static final String SALES= "003";
	public static final String FILE_EXTENSION_DAT = ".dat";
	public static final String SPLIT = "ç";
	public static final String FILE_DATA_DIR = System.getenv("HOMEPATH") + File.separator + "data";
    public static final String FILE_DIR_IN = FILE_DATA_DIR + File.separator + "in";
    public static final String FILE_DIR_OUT = FILE_DATA_DIR + File.separator + "out";
	public static final String SPLIT_ITENS = ",";
	public static final String FILE_NAME_OUT = ".done.dat";

}
