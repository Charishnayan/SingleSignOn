package io.spring.save.csv.database.service;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import io.spring.save.csv.database.entity.Colony;
import io.spring.save.csv.database.repository.ColonyRepository;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;


@Service
public class ColonyService {
   private final ColonyRepository colonyRepository;

   @Autowired
   public ColonyService(ColonyRepository colonyRepository) {
       this.colonyRepository = colonyRepository;
   }

   public void saveCsvDataToDatabase(String csvUrl) throws IOException {
       // Fetch CSV data from the URL
       URL url = new URL(csvUrl);
       try (InputStreamReader reader = new InputStreamReader(url.openStream())) {
           List<Colony> colonies = CsvParser.parse(reader); // Implement CSV parsing

           // Save the data into the database
           colonyRepository.saveAll(colonies);
       }
   }
}