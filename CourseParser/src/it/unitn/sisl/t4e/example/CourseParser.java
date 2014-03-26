package it.unitn.sisl.t4e.example;

import java.io.File;
import java.io.IOException;
import java.util.List;

import it.unitn.sisl.t4e.handler.CourseHandler;
import it.unitn.sisl.t4e.pojos.Answer;
import it.unitn.sisl.t4e.pojos.Course;
import it.unitn.sisl.t4e.pojos.Lecture;
import it.unitn.sisl.t4e.pojos.Question;

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
				System.out.println("Course " + course.getCourseId() + " " + course.getCourseTitle());
				for(Lecture lecture : course.getLectures()){
					System.out.println("Lecture " + lecture.getLectureId() + " " + lecture.getLectureTitle() + " " + lecture.getLectureDate());
					for(Question question : lecture.getQuestions()){
						System.out.println("Question " + question.getQuestionId() + " " + question.getQuestionText());
						for(Answer answer : question.getAnswers()){
							System.out.println("Answer " + answer.getAnswerId() + " " + answer.getAnswerText() + " Votes: " + answer.getNumVotes());
						}
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
