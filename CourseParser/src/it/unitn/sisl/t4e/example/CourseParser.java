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
//			for(Course course : courses){
//				System.out.println("Course " + course.getCourseId() + " " + course.getCourseTitle());
//				for(Lecture lecture : course.getLectures()){
//					System.out.println("Lecture " + lecture.getLectureId() + " " + lecture.getLectureTitle() + " " + lecture.getLectureDate());
//					//A loop on the entire corpus will take a while. We will therefore limit this example to just a few runs.
//					int sampleCount = 0;
//					for(Question question : lecture.getQuestions()){
//						if(sampleCount == 5){ //fiddle with at will
//							break;
//						}
//						if(question.getTokens().isEmpty()){
//							System.out.println("Question " + question.getQuestionId() + " " + question.getQuestionText());
//							for(Answer answer : question.getAnswers()){
//								System.out.println("Answer " + answer.getAnswerId() + " " + answer.getAnswerText() + " Votes: " + answer.getNumVotes());
//							}
//						}
//						else{
//							for(String token : question.getTokens()){
//								System.err.println("question token: " + token);
//							}
//							for(String sentence : question.getSentences()){
//								System.err.println("question sentence: " + sentence);
//							}
//							for(Answer answer : question.getAnswers()){
//								for(String token : answer.getTokens()){
//									System.err.println("answer token: " + token);
//								}
//								for(String sentence : answer.getSentences()){
//									System.err.println("answer sentence: " + sentence);
//								}
//							}
//						}
//						sampleCount++;
//					}
//				}
//			}
			for(Course course : courses){
				System.out.println(course.getCourseTitle());
				for(Lecture lecture : course.getLectures()){
					System.out.println(lecture.getCourse().getCourseTitle());
					for(Question question : lecture.getQuestions()){
						System.out.println(question.getLecture().getLectureTitle());
						for(Answer answer : question.getAnswers()){
							System.out.println(answer.getQuestion().getQuestionId());
						}
					}
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

}
