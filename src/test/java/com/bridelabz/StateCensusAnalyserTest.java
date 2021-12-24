package com.bridelabz;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.bridgelabz.CensusAnalyserException;
import com.bridgelabz.StateCensusAnalyser;


public class StateCensusAnalyserTest {
	
	    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
	    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";
	    private static final String WRONG_DELIMITER_CSV_FILE_PATH ="./src/test/resources/IndiaStateCensusDataWrongDelimiter.csv";
	    private static final String WRONG_DATA_CSV_FILE_PATH ="./src/test/resources/IndiaStateCensusDataWrongType.csv";
	    private static final String WRONG_HEADER_CSV_FILE_PATH ="./src/test/resources/IndiaStateCensusDataWrongHeader.csv";
	    StateCensusAnalyser censusAnalyser;
	    
	    @Before
	    public void instance() {
	    	if(censusAnalyser==null) {
	    	censusAnalyser= new StateCensusAnalyser();
	    	}
	    }
	    
	    
	    @Test
	    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
	        try {
	            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
	            Assert.assertEquals(29,numOfRecords);
	        } catch (CensusAnalyserException e) { }
	    }
	    

	    @Test
	    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
	        try {
	        	
	            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
	        } catch (CensusAnalyserException e) {
	        	Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_NOT_FOUND,e.type);
	        }
	    }
	    
	    @Test
	    public void givenIndiaCensusData_WithWrongDelimiter_ShouldThrowException() {
	        try {
	        	
	            censusAnalyser.loadIndiaCensusData(WRONG_DELIMITER_CSV_FILE_PATH);
	        } catch (CensusAnalyserException e) {
	        	Assert.assertEquals(CensusAnalyserException.ExceptionType.INVALID_DELIMITER,e.type);
	        }
	    }
	    
	    @Test
	    public void givenIndiaCensusData_WithWrongDataType_ShouldThrowException() {
	        try {
	        	
	            censusAnalyser.loadIndiaCensusData(WRONG_DATA_CSV_FILE_PATH);
	        } catch (CensusAnalyserException e) {
	        	Assert.assertEquals(CensusAnalyserException.ExceptionType.INVALID_TYPE,e.type);
	        }
	    }
	    
	    @Test
	    public void givenIndiaCensusData_WithWrongHeader_ShouldThrowException() {
	        try {
	        	
	            censusAnalyser.loadIndiaCensusData(WRONG_HEADER_CSV_FILE_PATH);
	        } catch (CensusAnalyserException e) {
	        	Assert.assertEquals(CensusAnalyserException.ExceptionType.INVALID_HEADER,e.type);
	        }
	    }

}
