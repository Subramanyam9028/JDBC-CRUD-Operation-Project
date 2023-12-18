package in.ineuron.service;

import in.ineuron.dto.Student;

public interface IStudentService {

	
	String save(Student student);//create record indatabase
	
	Student findById(Integer sid);//for read 
	
	String updateById(Integer sid);//updating record
	
	String deleteById(Integer sid);//deleteing record

}
