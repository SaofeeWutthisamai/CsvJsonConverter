/*
 * Copyright (c) 2019, Saofee Wutthisamai
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * 
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.osasao.csvjsonconverter;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

// TODO: Auto-generated Javadoc
/**
 * CsvConverter.
 */
public final class CsvConverter {
	

	/**
	 * private on constructor use to staic only.
	 */
	private CsvConverter() {
	}
	
	
	/**
	 * File to json string.
	 *
	 * @param csvFile the csv file
	 * @return JsonString
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public static String toJsonString(File csvFile) throws JsonProcessingException, IOException , Exception {
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();
        FileInputStream fileInputStream = new FileInputStream(csvFile) ;
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8) ;
        // Read data from CSV file
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(inputStreamReader).readAll();
        
        fileInputStream.close();
        inputStreamReader.close();
        
		return  new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(readAll) ; 
	}
	
	
	/**
	 * String to json string.
	 *
	 * @param csvStr the csv str
	 * @return JsonString
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public static String toJsonString(String csvStr) throws JsonProcessingException, IOException , Exception {
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();
        // Read data from CSV file
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvStr).readAll();
        
		return  new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(readAll) ; 
	}

	/**
	 * File to json file.
	 *
	 * @param csvFile the csv file
	 * @param jsonFileTarget the json file target
	 * @throws JsonGenerationException the json generation exception
	 * @throws JsonMappingException the json mapping exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public static void toJsonFile(File csvFile , File jsonFileTarget) throws JsonGenerationException, JsonMappingException, IOException , Exception{
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();
        FileInputStream fileInputStream = new FileInputStream(csvFile) ;
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8) ;
        // Read data from CSV file
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(inputStreamReader).readAll();
        
        fileInputStream.close();
        inputStreamReader.close();
        
        // Write JSON formated data to output.json file
        new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(jsonFileTarget, readAll);
	}
	

	/**
	 * Csv string to json file.
	 *
	 * @param csvString the csv string
	 * @param jsonFileTarget the json file target
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void toJsonFile(String csvString , File jsonFileTarget) throws JsonProcessingException, IOException {
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();
        // Read data from CSV file
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvString).readAll();
        // Write JSON formated data to jsonFileTarget file
        new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(jsonFileTarget, readAll);
	}
	
	/**
	 * Csv file to List.
	 *
	 * @param csvFile the csv file
	 * @return List
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public static List<Object> toList(File csvFile) throws JsonProcessingException, IOException , Exception {
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        CsvMapper csvMapper = new CsvMapper();
        FileInputStream fileInputStream = new FileInputStream(csvFile) ;
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8) ;
        // Read data from CSV file
        List<Object> result = csvMapper.readerFor(Map.class).with(csvSchema).readValues(inputStreamReader).readAll() ;
        fileInputStream.close();
        inputStreamReader.close();
		
		return result;
	}
	
	/**
	 * Csv string to List.
	 *
	 * @param csvString the csv string
	 * @return List
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException , Exception
	 * @throws Exception the exception
	 */
	public static List<Object> toList(String csvString) throws JsonProcessingException, IOException , Exception {
		CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
		CsvMapper csvMapper = new CsvMapper();
		// Read data from CSV file
		return csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvString).readAll();
	}
	

	
}
