package com.nidhani.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.nidhani.model.Student;
import com.nidhani.repository.StudentRepository;
import com.nidhani.service.StudentServiceImpl;

public class ServiceTest {
	  @Mock 
	   private StudentRepository studentRepository;
	   
	   @InjectMocks
	   private StudentServiceImpl studentService;
	   
	   
	   @Before
	   public void setUp() throws Exception {
		   MockitoAnnotations.initMocks(this);
	   }
	   
	   @Test
	   public void getItemNumber() {
		   Student mockedStudent=new Student();
		   mockedStudent.setUserName("vijay");
		   mockedStudent.setPassword("dhiman");
		   when(studentRepository.findByUserName("vijay")).thenReturn(mockedStudent);
		   boolean result=studentService.findByLogin("vijay", "dhiman");
		   verify(studentRepository,times(1)).findByUserName("vijay");
		   assertTrue(result);
		     
	   }   
}
