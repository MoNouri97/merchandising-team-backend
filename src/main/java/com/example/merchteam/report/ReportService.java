package com.example.merchteam.report;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.example.merchteam.report.event.EventRepository;
import com.example.merchteam.report.event.model.Event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
	@Autowired
	private EventRepository<Event> eventRepository;
	@Autowired
	private ReportRepository reportRepository;

	public List<Report> getAll() {
		return reportRepository.findAll();
	}

	public Report getOne(Long id) {
		return reportRepository.findById(id)
			.orElseThrow(() -> new IllegalStateException("report with id" + id + "does not exist"));
	}

	@Transactional
	public Report create(Report report) {
		Report savedReport = reportRepository.save(report);
		// update event.report_id
		var idList = report.getEvents().stream().map(e -> e.getId()).collect(Collectors.toList());
		// FIXME : this in tasks
		// eventRepository.saveAll(report.getEvents());
		eventRepository.updateEvents(idList, savedReport.getId());

		return savedReport;
	}
}
