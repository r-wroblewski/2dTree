package com.project;

import java.io.FileNotFoundException;

//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.Reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ReadFile {
	public static ReadFile thisCls;
    private String filename = "C:/Users/rebec/Documents/HmcSpring2020/ProgrammingPracticum/cities/uscities.csv";

    public static ReadFile getSenderClass()
    {
        if(thisCls == null) thisCls = new ReadFile();

        return thisCls;
    }


    public KdTree readCsv(KdTree tree) throws NumberFormatException{


        try {
            CSVReader reader = new CSVReader(new FileReader(filename));
//            KdTree tree = new KdTree();
            // UTF-8
            // CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"), ",", '"', 1);
            String[] s;
            while ((s = reader.readNext()) != null) 
            {
            	double lat = Double.parseDouble(s[8]);
			 	double longi = Double.parseDouble(s[9]);
			 	String city = s[0];
			 	Point2D newPoint = new Point2D(lat, longi, city);
				tree.insert(newPoint);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return tree;
    }
}

