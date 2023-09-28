package io.spring.save.csv.database.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.save.csv.database.service.ColonyService;

@RestController
@RequestMapping("/import")
public class ImportController {
   private final ColonyService colonyService;

   @Autowired
   public ImportController(ColonyService colonyService) {
       this.colonyService = colonyService;
   }

   @PostMapping("/csv")
   public void importCsvData() throws IOException {
       String csvUrl = "https://raw.githubusercontent.com/rfordatascience/tidytuesday/master/data/2022/2023-01-11/colony.csv";
       colonyService.saveCsvDataToDatabase(csvUrl);
   }
}