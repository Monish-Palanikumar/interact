package com.hcl.repos;

import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.model.Booking;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query(value = "select * from booking where iid=?1", nativeQuery = true)
	public List<Booking> findByInstructor(Integer id);

	@Modifying
	@Query(value = "insert into booking (iid,sid,start,end) values (?1,?2,?3,?4)", nativeQuery = true)
	public void saveBooking(Integer iid, Integer sid, Time start, Time end);

	@Query(value = "select * from booking where sid=?1", nativeQuery = true)
	public List<Booking> getSchedule(Integer id);
}
