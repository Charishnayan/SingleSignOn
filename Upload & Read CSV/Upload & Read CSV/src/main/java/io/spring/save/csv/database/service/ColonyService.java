package io.spring.save.csv.database.service;
import io.spring.save.csv.database.entity.Colony;
import io.spring.save.csv.database.repository.ColonyRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Service
public class ColonyService {
  private final ColonyRepository colonyRepository;

  @Autowired
  public ColonyService(ColonyRepository colonyRepository) {
      this.colonyRepository = colonyRepository;
  }

  public void saveCsvDataToDatabase(String csvUrl) throws IOException {
    URL url = new URL(csvUrl);
    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
    InputStream inputStream = httpURLConnection.getInputStream();
    InputStreamReader reader = new InputStreamReader(inputStream);

    CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);

    List<Colony> tutorials = new ArrayList<Colony>();
    for (CSVRecord record : csvParser) {
      String street = record.get("street");
      String city = record.get("city");
      String state = record.get("state");
      String zipCode = record.get("zipCode");
    }
          Colony colony = new Colony();

          tutorials.add(colony);
  }
}