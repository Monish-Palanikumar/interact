package com.hcl.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.model.Student;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Modifying
	@Query(value = "insert into student (name,grade,board,contact_number,username,password) values (?1,?2,?3,?4,?5,?6)", nativeQuery = true)
	public void saveStudent(String name, Integer grade, String board, String contactNumber, String username,
			String password);

	@Query(value = "select * from student where username=?1 and password=?2", nativeQuery = true)
	public Student getStudentByUsernameAndPassword(String username, String password);

}
