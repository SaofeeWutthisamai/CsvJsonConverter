package com.osasao.CsvJsonConverter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.osasao.csvjsonconverter.CsvConverter;
import com.osasao.csvjsonconverter.HelperConverter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CsvConverterTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CsvConverterTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CsvConverterTest.class );
    }

    /**
     * Rigourous Test :-)
     * @throws Exception 
     * @throws IOException 
     * @throws JsonProcessingException 
     */
    public void testApp() throws IOException, Exception
    {
       // Csv to Json String
       System.out.println( CsvConverter.toJsonString(new File("C:\\Users\\tha0741p\\Desktop\\other\\MYR.20190125060528.response.csv")) );
       System.out.println( CsvConverter.toJsonString("\"batch_id\",\"transaction_id\",\"request_id\",\"transaction_type\",\"requested_amount\",\"requested_amount_currency\",\"transaction_state\",\"token_id\",\"status_code\",\"status_description\",\"completion_time_stamp\",\"authorization_code\",\"provider_account_id\"\r\n" + 
       		"\"หกดหกดหก\",\"711784ac-8c4f-4e51-bb30-8921688316d4\",\"37686233_74568595\",\"purchase\",\"238.00\",\"MYR\",\"success\",\"4601402213552685\",\"201.0000\",\"acquirer:The resource was successfully created.\",\"2019-01-24T22:10:16+00:00\",\"007861\",\"01013000101\"") );
       
       // Csv to Json File
       CsvConverter.toJsonFile(new File("C:\\Users\\tha0741p\\Desktop\\other\\MYR.20190125060528.response.csv"), new File("C:\\Users\\tha0741p\\Desktop\\other\\MYR.20190125060528.response.json"));
       CsvConverter.toJsonFile("\"batch_id\",\"transaction_id\",\"request_id\",\"transaction_type\",\"requested_amount\",\"requested_amount_currency\",\"transaction_state\",\"token_id\",\"status_code\",\"status_description\",\"completion_time_stamp\",\"authorization_code\",\"provider_account_id\"\r\n" + 
          		"\"หกดหกดหก\",\"711784ac-8c4f-4e51-bb30-8921688316d4\",\"37686233_74568595\",\"purchase\",\"238.00\",\"MYR\",\"success\",\"4601402213552685\",\"201.0000\",\"acquirer:The resource was successfully created.\",\"2019-01-24T22:10:16+00:00\",\"007861\",\"01013000101\"", new File("C:\\Users\\tha0741p\\Desktop\\other\\MYR.20190125060528.response2.json"));
       
       // Csv to List
       List listFile = CsvConverter.toList(new File("C:\\Users\\tha0741p\\Desktop\\other\\MYR.20190125060528.response.csv")) ;
       List listStr = CsvConverter.toList("\"batch_id\",\"transaction_id\",\"request_id\",\"transaction_type\",\"requested_amount\",\"requested_amount_currency\",\"transaction_state\",\"token_id\",\"status_code\",\"status_description\",\"completion_time_stamp\",\"authorization_code\",\"provider_account_id\"\r\n" + 
         		"\"หกดหกดหก\",\"711784ac-8c4f-4e51-bb30-8921688316d4\",\"37686233_74568595\",\"purchase\",\"238.00\",\"MYR\",\"success\",\"4601402213552685\",\"201.0000\",\"acquirer:The resource was successfully created.\",\"2019-01-24T22:10:16+00:00\",\"007861\",\"01013000101\"") ;
       System.out.println(listFile.size());
       System.out.println(listStr.size());
       Map<String, Object> mapFile = (Map<String, Object>)listFile.get(0) ;
       System.out.println(mapFile.get("batch_id"));
       
       //Csv To String
       System.out.println(HelperConverter.toString(new File("C:\\Users\\tha0741p\\Desktop\\other\\MYR.20190125060528.response.csv")));
       
       //Csv To File
       HelperConverter.toFile("\"batch_id\",\"transaction_id\",\"request_id\",\"transaction_type\",\"requested_amount\",\"requested_amount_currency\",\"transaction_state\",\"token_id\",\"status_code\",\"status_description\",\"completion_time_stamp\",\"authorization_code\",\"provider_account_id\"\r\n" + 
         		"\"หกดหกดหก\",\"711784ac-8c4f-4e51-bb30-8921688316d4\",\"37686233_74568595\",\"purchase\",\"238.00\",\"MYR\",\"success\",\"4601402213552685\",\"201.0000\",\"acquirer:The resource was successfully created.\",\"2019-01-24T22:10:16+00:00\",\"007861\",\"01013000101\"", new File("C:\\Users\\tha0741p\\Desktop\\other\\MYR.20190125060528.response222.csv"));
       
    }
}
