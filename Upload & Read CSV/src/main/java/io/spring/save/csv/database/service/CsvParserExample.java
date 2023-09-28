package io.spring.save.csv.database.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.FileReader;
import java.io.IOException;

public class CsvParserExample {
	   public static void main(String[] args) {
	       try (CSVReader reader = new CSVReaderBuilder(new FileReader("https://raw.githubusercontent.com/rfordatascience/tidytuesday/master/data/2022/2023-01-11/colony.csv"))
	               .withSkipLines(1) // Skip the header row if it exists
	               .build()) {

	           String[] nextLine;
	           while ((nextLine = reader.readNext()) != null) {
	               // Process each row of data
	               for (String cell : nextLine) {
	                   System.out.print(cell + "\t");
	               }
	               System.out.println(); // Move to the next line
	           }
	       } catch (IOException e) {
	           e.printStackTrace();
	       }
	   }
	}
