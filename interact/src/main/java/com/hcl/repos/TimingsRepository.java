package com.hcl.repos;

import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.model.Timings;

@Repository
public interface TimingsRepository extends JpaRepository<Timings, Integer> {
	@Query(value = "select * from timings", nativeQuery = true)
	public List<Timings> getAllTimings();

	@Query(value = "select * from timings where slot=?1", nativeQuery = true)
	public Timings findByTiming(Time slot);
}
