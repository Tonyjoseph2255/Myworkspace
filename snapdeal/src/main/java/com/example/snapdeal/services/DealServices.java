package com.example.snapdeal.services;

import java.io.IOException;

import java.io.InputStreamReader;
import java.io.Reader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.snapdeal.entity.DealEntity;
import com.example.snapdeal.repository.DealRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
@Service
public class DealServices {
	@Autowired
	DealRepository dealRepository;

	public void toStore(MultipartFile file) throws IOException, ParseException {
		// TODO Auto-generated method stub
		Reader reader = new InputStreamReader(file.getInputStream());
		CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		try {
			SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
			List<String[]> allData = csvReader.readAll();
			List<DealEntity> dealLIst = new ArrayList<>();
			for (String[] row : allData) {
				DealEntity var = new DealEntity();
				var.setOrder_id((row[0]));
				var.setReturn_reason(row[3]);
				var.setOrder_date((Date) formatter.parse(row[4]));
				var.setShip_date((Date) formatter.parse(row[7]));
				var.setShip_mode(row[8]);
				var.setProduct_id(row[9]);
				var.setDays_to_ship(Integer.parseInt(row[10]));
				var.setCategory(row[11]);
				var.setSub_category(row[12]);
				var.setProduct_name(row[13]);

				dealLIst.add(var);

			}
			dealRepository.saveAll(dealLIst);

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public List<DealEntity> getOrders() {
		// TODO Auto-generated method stub
		return dealRepository.findAll();
	}

}
