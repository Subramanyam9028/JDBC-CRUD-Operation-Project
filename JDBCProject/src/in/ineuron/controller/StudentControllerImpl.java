package in.ineuron.controller;

import in.ineuron.dto.Student;
import in.ineuron.factory.StudentServiceFactory;
import in.ineuron.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	
	IStudentService studentService = StudentServiceFactory.getStudentService();
	
	
	@Override
	public String save(Student student) {
		// TODO Auto-generated method stub
		
		return studentService.save(student);
		
	}

	@Override
	public Student findById(Integer sid) {
		// TODO Auto-generated method stub
		return studentService.findById(sid);
	}

	@Override
	public String updateById(Integer sid) {
		// TODO Auto-generated method stub
		return studentService.updateById(sid);
	}

	@Override
	public String deleteById(Integer sid) {
		// TODO Auto-generated method stub

		return studentService.deleteById(sid);
	}

}
