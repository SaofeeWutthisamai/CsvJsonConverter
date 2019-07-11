package com.osasao.csvjsonconverter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class HelperConverter {
	
	/**
	 *  file to string.
	 *
	 * @param file the json file
	 * @return the string
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String toString(File jsonFile) throws IOException , Exception {
		return new String(Files.readAllBytes(Paths.get(jsonFile.getPath())), StandardCharsets.UTF_8);
	}
	
	
	/**
	 * To file.
	 *
	 * @param Str 
	 * @param TargetFile 
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void toFile(String csvStr , File csvTargetFile) throws IOException , Exception {
		Files.write(Paths.get(csvTargetFile.getPath()), csvStr.getBytes());
	}
	
}
