package com.hcl.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.model.Instructor;

@Repository
@Transactional
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

//	public List<Instructor> getInstructorsByAvailability(String availability);

	@Query(value = "select * from instructor where availability=?1", nativeQuery = true)
	public List<Instructor> findByAvailability(String availability);

	@Query(value = "select * from instructor where subject_preference=?1 and board_preference=?2 and grade_preference=?3 and availability='Y' order by rating desc", nativeQuery = true)
	public List<Instructor> findBySubject(String subject, String board, Integer grade);

	@Modifying
	@Query(value = "insert into instructor (name,experience,contact_number,grade_preference,board_preference, subject_preference,username,password,availability) values (?1,?2,?3,?4,?5,?6,?7,?8,?9)", nativeQuery = true)
	public void saveInstructor(String name, Integer experience, String ContactNumber, String gradePreference,
			String boardPreference, String subjectPreference, String username, String password, String availability);

	@Query(value = "select * from instructor where username=?1 and password=?2", nativeQuery = true)
	public Instructor getInstructorByUsernameAndPassword(String username, String password);
}
