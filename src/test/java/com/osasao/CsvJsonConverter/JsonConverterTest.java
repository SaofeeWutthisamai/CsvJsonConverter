package com.osasao.CsvJsonConverter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.osasao.csvjsonconverter.CsvConverter;
import com.osasao.csvjsonconverter.JsonConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class JsonConverterTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public JsonConverterTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( JsonConverterTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws Exception 
     * @throws IOException 
     * @throws JsonProcessingException 
     */
    public void testApp() throws IOException, Exception
    {
    	// JSON to CSV
    	JsonConverter.toCSVFile(new File("C:\\Users\\tha0741p\\Desktop\\other\\MYR.20190125060528.response.json"), new File("C:\\Users\\tha0741p\\Desktop\\other\\TestCSV.csv"));
    	JsonConverter.toCSVFile("[ {\r\n" + 
    			"  \"batch_id\" : \"หกดหกดหก\",\r\n" + 
    			"  \"transaction_id\" : \"711784ac-8c4f-4e51-bb30-8921688316d4\",\r\n" + 
    			"  \"request_id\" : \"37686233_74568595\",\r\n" + 
    			"  \"transaction_type\" : \"purchase\",\r\n" + 
    			"  \"requested_amount\" : \"238.00\",\r\n" + 
    			"  \"requested_amount_currency\" : \"MYR\",\r\n" + 
    			"  \"transaction_state\" : \"success\",\r\n" + 
    			"  \"token_id\" : \"4601402213552685\",\r\n" + 
    			"  \"status_code\" : \"201.0000\",\r\n" + 
    			"  \"status_description\" : \"acquirer:The resource was successfully created.\",\r\n" + 
    			"  \"completion_time_stamp\" : \"2019-01-24T22:10:16+00:00\",\r\n" + 
    			"  \"authorization_code\" : \"007861\",\r\n" + 
    			"  \"provider_account_id\" : \"01013000101\"\r\n" + 
    			"}, {\r\n" + 
    			"  \"batch_id\" : \"CFE8E915202411E99055E74C491A9465\",\r\n" + 
    			"  \"transaction_id\" : \"59066f9d-5934-4c7e-9afc-ad28c8aa0d0b\",\r\n" + 
    			"  \"request_id\" : \"37686376_74568899\",\r\n" + 
    			"  \"transaction_type\" : \"purchase\",\r\n" + 
    			"  \"requested_amount\" : \"238.00\",\r\n" + 
    			"  \"requested_amount_currency\" : \"MYR\",\r\n" + 
    			"  \"transaction_state\" : \"success\",\r\n" + 
    			"  \"token_id\" : \"4866562126219961\",\r\n" + 
    			"  \"status_code\" : \"201.0000\",\r\n" + 
    			"  \"status_description\" : \"acquirer:The resource was successfully created.\",\r\n" + 
    			"  \"completion_time_stamp\" : \"2019-01-24T22:10:21+00:00\",\r\n" + 
    			"  \"authorization_code\" : \"031870\",\r\n" + 
    			"  \"provider_account_id\" : \"01013000101\"}]", new File("C:\\Users\\tha0741p\\Desktop\\other\\TestCSV.csv"));
    	
    }
}
