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

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

// TODO: Auto-generated Javadoc
/**
 * The Class JsonConverter.
 */
public final class JsonConverter {
	
	/**
	 * Instantiates a new json converter.
	 */
	private JsonConverter() {
	}
	
	/**
	 * To CSV File.
	 *
	 * @param jsonFile the json file
	 * @param csvFileTarget the csv file target
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public static void toCSVFile(File jsonFile , File csvFileTarget) throws JsonProcessingException, IOException , Exception {
		JsonNode jsonTree = new ObjectMapper().readTree(jsonFile);
		Builder csvSchemaBuilder = CsvSchema.builder();
		
		JsonNode firstObject = jsonTree.elements().next();
		firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
		
		CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
		CsvMapper csvMapper = new CsvMapper();
		csvMapper.writerFor(JsonNode.class).with(csvSchema).writeValue(csvFileTarget, jsonTree);
	}
	
	/**
	 * To CSV file.
	 *
	 * @param jsonStr the json str
	 * @param csvFileTarget the csv file target
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public static void toCSVFile(String jsonStr , File csvFileTarget) throws JsonProcessingException, IOException , Exception {
		JsonNode jsonTree = new ObjectMapper().readTree(jsonStr);
		Builder csvSchemaBuilder = CsvSchema.builder();
		
		JsonNode firstObject = jsonTree.elements().next();
		firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
		
		CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
		CsvMapper csvMapper = new CsvMapper();
		csvMapper.writerFor(JsonNode.class).with(csvSchema).writeValue(csvFileTarget, jsonTree);
	}
	
	/**
	 * To CSV string.
	 *
	 * @param jsonStr the json str
	 * @return the string
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public static String toCSVString(String jsonStr) throws JsonProcessingException, IOException , Exception {
		JsonNode jsonTree = new ObjectMapper().readTree(jsonStr);
		Builder csvSchemaBuilder = CsvSchema.builder();
		
		JsonNode firstObject = jsonTree.elements().next();
		firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
		
		CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
		CsvMapper csvMapper = new CsvMapper();
		return csvMapper.writerFor(JsonNode.class).with(csvSchema).writeValueAsString(jsonTree);
	}
	
	/**
	 * To CSV string.
	 *
	 * @param jsonFile the json file
	 * @return the string
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public static String toCSVString(File jsonFile) throws JsonProcessingException, IOException , Exception {
		JsonNode jsonTree = new ObjectMapper().readTree(jsonFile);
		Builder csvSchemaBuilder = CsvSchema.builder();
		
		JsonNode firstObject = jsonTree.elements().next();
		firstObject.fieldNames().forEachRemaining(fieldName -> {csvSchemaBuilder.addColumn(fieldName);} );
		
		CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();
		CsvMapper csvMapper = new CsvMapper();
		return csvMapper.writerFor(JsonNode.class).with(csvSchema).writeValueAsString(jsonTree);
	}
	
	
	/**
	 * To list.
	 * @param <V>
	 * @param <K>
	 *
	 * @param jsonFile the json file
	 * @return the list
	 * @throws JsonSyntaxException the json syntax exception
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public static <V, K> List<Map<K, V>> toList(File jsonFile) throws JsonSyntaxException, JsonProcessingException, IOException, Exception {		
		return new Gson().fromJson(HelperConverter.toString(jsonFile), new TypeToken<List<Map<K, V>>>(){}.getType());
	}
	
	/**
	 * To list.
	 *
	 * @param json string
	 * @return the list
	 * @throws JsonSyntaxException the json syntax exception
	 * @throws JsonProcessingException the json processing exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws Exception the exception
	 */
	public static <V, K> List<Map<K, V>> toList(String jsonStr) throws JsonSyntaxException, JsonProcessingException, IOException, Exception {		
		return new Gson().fromJson(jsonStr, new TypeToken<List<Map<K, V>>>(){}.getType());
	}
	
}
