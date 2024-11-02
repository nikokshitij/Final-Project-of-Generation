package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student extends Person implements Evaluation
{
    private double average;

    private final List<Course> courses = new ArrayList<>();
    
    private  Map<Course,Integer> courseGrades = new HashMap<Course, Integer>();
    
    private final Map<String, Course> approvedCourses = new HashMap<>();


	public void setAverage(double average) {
		this.average = average;
	}
	
	public int getCourseGrade(Course course) {
		
		return courseGrades.get(course);
		
	}
	
	public void calculateAverage() {
		double totalgrade= 0 ;
		int courseCount = 0 ;
		
		for (Map.Entry<Course, Integer> entry : courseGrades.entrySet()) {
			
			Integer val = entry.getValue();
			totalgrade+=val;
			courseCount++;
			
		}
	        setAverage(totalgrade/courseCount);
		
	}

	

    public Student( String id, String name, String email, Date birthDate )
    {
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course )
    {
        //TODO implement this method
    	
    	if(!approvedCourses.containsKey(course.getCode())) {
    		
    		
    		//approvedCourses.
    		System.out.println("Perticullary couse is not available in the has map so i am makin new id whith"+course.getCode());
    		approvedCourses.put(course.getCode(),course);
    		
    	}
    	else System.out.println("All ready course is enrolled");
	
    	
    }

    public void registerApprovedCourse( Course course )
    {
        approvedCourses.put( course.getCode(), course );
    }

    public boolean isCourseApproved( String courseCode )
    {
        //TODO implement this method
    	if(approvedCourses.containsKey(courseCode)) {
    		return true;
    	}
        return false;
    }

    // CHALLENGE IMPLEMENTATION: Read README.md to find instructions on how to solve. 
    public List<Course> findPassedCourses()
    {
        //TODO implement this method
    	
    		    	
    	if(!approvedCourses.isEmpty()) {
    		List<Course> passedcourse = new ArrayList<Course>();
        	
        	Set<Course> keys=courseGrades.keySet();
        	
        	for(Course key : keys) {
        		
        		if(courseGrades.get(key)>50) {
        			//courses.add(approvedCourses.get(key));     // Method 1 
        			courses.add(key);                          // For this purpose we set the key of course grade as object of course it will save time of searching 
        		}    		
        	}
        	
        	// Another method for Iterate
//        	for(Map.Entry<Course,Integer> e : courseGrades.entrySet()) {       		
//        		courses.add(e.getKey());
//        		
//        	}
        	return courses;
    	}  	
        return null;
    }
    
    
    public void setGrade(Course course,int grade) {
    	
    	if(approvedCourses.containsKey(course)) {
    		
    		int res = courseGrades.put(course, grade);
    		
    		if(res==1) System.out.println("Grade updated");
    		else System.err.println("Grade is not updated");
    		
    	}
    	else System.out.println("Course is not approved ...");
    }

    public boolean isAttendingCourse( String courseCode )
    {
        //TODO implement this method
    	
    	if(approvedCourses.containsKey(courseCode)) {
    		return true;
    	}
    	
        return false;
    }

    @Override
    public double getAverage()
    {
        return average;
    }

    @Override
    public List<Course> getApprovedCourses()
    {
        //TODO implement this method
    	
    	if(!approvedCourses.isEmpty()) {
    		//Set<String> key = approvedCourses.keySet();
    		
    		for (Map.Entry<String, Course> entry : approvedCourses.entrySet()) {
				String key = entry.getKey();
				Course val = entry.getValue();
				courses.add(val);
				
			}
    		return courses;
    		
    	}
    	
        return null;
    }
   

	

	public List<Course> getCourses() {
		return courses;
	}

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }
}