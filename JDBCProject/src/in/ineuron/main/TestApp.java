package in.ineuron.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import in.ineuron.controller.IStudentController;
import in.ineuron.dto.Student;
import in.ineuron.factory.StudentControllerFactory;

public class TestApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		IStudentController studentController =StudentControllerFactory.getStudentController();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String status = null;
		int id;
		try {
			while(true) {
				
				System.out.println("1. CREATE");
				System.out.println("2. READ");
				System.out.println("3. UPDATE");
				System.out.println("4. DELETE");
				System.out.println("5. EXIT");
				System.out.println("ENETR ANY OPTION TO PERFORM OPERATION[1,2,3,4,5]");
				
				Integer option = Integer.parseInt(br.readLine());
				
				switch(option) {
					
					case 1:
						
						System.out.println("Enter name: ");
						String name = br.readLine();
						System.out.println("Enter email: ");
						String email = br.readLine();
						System.out.println("Enter city: ");
						String city = br.readLine();
						System.out.println("Enter country: ");
						String country = br.readLine();
						
						Student student = new Student();
						student.setName(name);
						student.setEmail(email);
						student.setCity(city);
						student.setCountry(country);
						
						status = studentController.save(student);
						
						if(status.equalsIgnoreCase("success")) {
							System.out.println("Student saved successfully");
						}
						else if(status.equalsIgnoreCase("failure")){
							System.out.println("failure");
						}
						else {
						System.out.println("some probelm occured");
						}
						
						break;
						
						
					case 2:
						
						System.out.println("enter id of student: ");
						id = Integer.parseInt(br.readLine());
						
						
						Student st = studentController.findById(id);
						
						if(st!=null)
						System.out.println(st);
						
						else {
							
							System.out.println("some error occured");
						}
						
						break;
					
					case 3:
						
						System.out.println("enter id: ");
						id = Integer.parseInt(br.readLine());
						status = studentController.updateById(id);
						
						if(status.equalsIgnoreCase("success")) {
							System.out.println("updated successfully");
						}
						
						else if(status.equalsIgnoreCase("failure")) {
							
							System.out.println("not updated");
						}
						
						
						
						break;
					case 4:
						System.out.println("enter id of the Student to delete");
						id = Integer.parseInt(br.readLine());
						status = studentController.deleteById(id);
						
						if(status.equalsIgnoreCase("success")) {
							System.out.println("Student deleted successfully");
						}
						
						else if(status.equalsIgnoreCase("failure")){
							
							System.out.println("Student not deleted");
						}
						
						else {
							
							System.out.println("Some other problem occured");
						}
						
						break;
						
					case 5:
						System.out.println("Thanks for using application.");
						System.exit(0);
						break;
						
					default:
						System.out.println("Please enter correct choice");
						
					
						
				
				
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
