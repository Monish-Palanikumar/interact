package com.hcl.service;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Timings;
import com.hcl.repos.TimingsRepository;

@Service
public class TimingsService {
	@Autowired
	TimingsRepository timingsRepo;

	public List<Timings> getAllTimings() {
		return timingsRepo.getAllTimings();
	}

	public Timings getTimings(Time slot) {
		return timingsRepo.findByTiming(slot);
	}
}
