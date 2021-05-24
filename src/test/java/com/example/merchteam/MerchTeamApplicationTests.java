package com.example.merchteam;

import java.io.IOException;

// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.HashSet;
import java.util.Set;

import com.example.merchteam.report.Report;
import com.example.merchteam.report.ReportRepository;
import com.example.merchteam.report.ReportService;
import com.example.merchteam.report.event.EventType;
import com.example.merchteam.report.event.model.Event;
import com.example.merchteam.report.event.model.PriceChange;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
// @WebMvcTest(ReportController.class)
@ExtendWith(SpringExtension.class)
// @DataJpaTest
class MerchTeamApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ReportService reportService;

	@Autowired
	private ReportRepository reportRepository;

	@Test
	void testReportController() throws Exception {
		// mvc.perform(get("/api/v1/report")).andDo(print());
		// var pc = new PriceChange();
		// pc.setNewPrice(69.9);
		// pc.setOldPrice(60.0);
		// pc.setType(EventType.PriceChange);
		// Set<Event> events = new HashSet<>();
		// events.add(pc);

		// Report r = new Report(null, true, 10.0, 20.0, events);
		ObjectMapper mapper = new ObjectMapper();
		String json =
			"{\"longitude\":10.0,	\"latitude\":11.0,\"valid\":true,	\"events\":[{\"type\":\"PriceChange\",\"oldPrice\":90.0,\"newPrice\":100}]}"
				.replaceAll(" ", "");
		try {
			var parsed = mapper.readValue(json, Report.class);
			var res = reportService.create(parsed);
			System.out.println("res: " + res);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testName() throws Exception {
		var pc = new PriceChange();
		pc.setNewPrice(69.9);
		pc.setOldPrice(60.0);
		pc.setType(EventType.PriceChange);
		Set<Event> events = new HashSet<>();
		events.add(pc);
		Report r = new Report(null, true, 10.0, 20.0, events);

		var report = reportRepository.save(r);
		System.out.println("report: " + report);
	}

}
