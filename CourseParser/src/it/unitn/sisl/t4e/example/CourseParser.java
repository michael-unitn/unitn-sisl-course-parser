package it.unitn.sisl.t4e.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

import it.unitn.sisl.t4e.handler.CourseHandler;
import it.unitn.sisl.t4e.pojos.Course;
import it.unitn.sisl.t4e.pojos.Lecture;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class CourseParser {

	public static void main(String[] args) {
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser courseParser = parserFactory.newSAXParser();
			CourseHandler courseHandler = new CourseHandler();
			courseParser.parse(new File(args[0]), courseHandler);
			List<Course> courses = courseHandler.getCourses();
			for(Course course : courses){
				System.out.println("Successfully parsed course " + course.getCourseTitle());
				for(Lecture lecture : course.getLectures()){
					System.err.println("Lecture " + lecture.getLectureTitle() + " " + lecture.getLectureDate());
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
