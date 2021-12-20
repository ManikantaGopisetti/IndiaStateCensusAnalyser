package com.bridelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.bridgelabz.CensusAnalyserException;
import com.bridgelabz.StateCensusAnalyser;


public class StateCensusAnalyserTest {
	
	    private static final String INDIA_CENSUS_CSV_FILE_PATH = "./src/test/resources/IndiaStateCensusData.csv";
	    private static final String WRONG_CSV_FILE_PATH = "./src/main/resources/IndiaStateCensusData.csv";

	    @Test
	    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
	        try {
	        	StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
	            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
	            Assert.assertEquals(29,numOfRecords);
	        } catch (CensusAnalyserException e) { }
	    }

	    @Test
	    public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
	        try {
	        	
	        	StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
	            ExpectedException exceptionRule = ExpectedException.none();
	            exceptionRule.expect(CensusAnalyserException.class);
	            censusAnalyser.loadIndiaCensusData(WRONG_CSV_FILE_PATH);
	        } catch (CensusAnalyserException e) {
	        	Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
	        }
	    }

}