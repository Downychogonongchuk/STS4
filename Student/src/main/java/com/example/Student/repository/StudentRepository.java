package com.example.Student.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Student.DTO.StudentDTO;

@Repository
public class StudentRepository {
	@Autowired
	private SqlSessionTemplate sql;
	

	public void save(StudentDTO studentDTO) {
		sql.insert("Student.save",studentDTO);
		// 1번 매개변수 = Student =  <mapper namespace="Student">
		// 1번 매개변수 = save = <insert id="save"
		// 2번 매개변수 = 넘기는 데이터의 타입  parameterType="com.example.Student.dto.StudentDTO">
		// 풀 패키지 경로
		
	}


	public List<StudentDTO> findAll() {
		return sql.selectList("Student.findAll"); 
	}


	public StudentDTO findById(Long id) {
		
		return sql.selectOne("Student.findById",id); 
		//값을 하나만 받아올 때 selectOne 사용
	}
}
