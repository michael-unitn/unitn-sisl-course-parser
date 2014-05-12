package it.unitn.sisl.t4e.handler;

import it.unitn.sisl.t4e.pojos.Answer;
import it.unitn.sisl.t4e.pojos.Course;
import it.unitn.sisl.t4e.pojos.Lecture;
import it.unitn.sisl.t4e.pojos.Question;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CourseHandler extends DefaultHandler {
	private final String COURSE = "course";
	private final String ID = "id";
	private final String TITLE = "title";
	private final String LANGUAGE = "lang";
	private final String LECTURE = "lecture";
	private final String DATE = "date";
	private final String QUESTION = "question";
	private final String QUESTION_TEXT = "question_text";
	private final String ANSWER = "answer";
	private final String ANSWER_TEXT = "answer_text";
	private final String NUM_VOTES = "num_votes";
	private final String Q_TOKEN = "q_token";
	private final String Q_SENTENCE = "q_sentence";
	private final String A_TOKEN = "a_token";
	private final String A_SENTENCE = "a_sentence";
	
	private boolean questionText = false;
	private boolean answerText = false;
	private boolean numVotes = false;
	private boolean qToken = false;
	private boolean qSentence = false;
	private boolean aToken = false;
	private boolean aSentence = false;
	
	private Course course = new Course();
	private Lecture lecture = new Lecture();
	private Question question = new Question();
	private Answer answer = new Answer();
	
	private List<Course> courses = new ArrayList<Course>();
	private List<Lecture> lectures = new ArrayList<Lecture>();
	private List<Question> questions = new ArrayList<Question>();
	private List<Answer> answers = new ArrayList<Answer>();
	
	private String questionTextChars = "";
	private String answerTextChars = "";
	private String numVotesChars = "";
	private String qTokenChars = "";
	private String qSentenceChars = "";
	private String aTokenChars = "";
	private String aSentenceChars = "";
	
	public List<Course> getCourses() {
		return courses;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if(qName.equalsIgnoreCase(COURSE)){
			course.setCourseId(attributes.getValue(ID));
			course.setCourseTitle(attributes.getValue(TITLE));
			course.setLanguage(attributes.getValue(LANGUAGE));
		}
		else if(qName.equalsIgnoreCase(LECTURE)){
			lecture.setLectureId(attributes.getValue(ID));
			lecture.setLectureTitle(attributes.getValue(TITLE));
			lecture.setLectureDate(attributes.getValue(DATE));
		}
		else if(qName.equalsIgnoreCase(QUESTION)){
			question.setQuestionId(attributes.getValue(ID));
		}
		else if(qName.equalsIgnoreCase(ANSWER)){
			answer.setAnswerId(attributes.getValue(ID));
		}
		else if(qName.equalsIgnoreCase(QUESTION_TEXT)){
			questionText = true;
		}
		else if(qName.equalsIgnoreCase(ANSWER_TEXT)){
			answerText = true;
		}
		else if(qName.equalsIgnoreCase(NUM_VOTES)){
			numVotes = true;
		}
		else if(qName.equalsIgnoreCase(Q_TOKEN)){
			qToken = true;
		}
		else if(qName.equalsIgnoreCase(Q_SENTENCE)){
			qSentence = true;
		}
		else if(qName.equalsIgnoreCase(A_TOKEN)){
			aToken = true;
		}
		else if(qName.equalsIgnoreCase(A_SENTENCE)){
			aSentence = true;
		}
	}
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(qName.equalsIgnoreCase(COURSE)){
			List<Lecture> completeLectures = new ArrayList<Lecture>(lectures);
			course.setLectures(completeLectures);
			for(Lecture lecture : completeLectures){
				lecture.setCourse(Course.copy(course));
				for(Question question : lecture.getQuestions()){
					question.setLecture(Lecture.copy(lecture));
					for(Answer answer : question.getAnswers()){
						answer.setQuestion(Question.copy(question));
					}
				}
			}
			lectures = new ArrayList<Lecture>();
			courses.add(Course.copy(course));
		}
		else if(qName.equalsIgnoreCase(LECTURE)){
			List<Question> completeQuestions = new ArrayList<Question>(questions);
			lecture.setQuestions(completeQuestions);
			questions = new ArrayList<Question>();
			lectures.add(Lecture.copy(lecture));
		}
		else if(qName.equalsIgnoreCase(QUESTION)){
			List<Answer> completeAnswers = new ArrayList<Answer>(answers);
			question.setAnswers(completeAnswers);
			answers = new ArrayList<Answer>();
			questions.add(Question.copy(question));
			question = new Question();
		}
		else if(qName.equalsIgnoreCase(ANSWER)){
			answers.add(Answer.copy(answer));
			answer = new Answer();
		}
		else if(qName.equalsIgnoreCase(QUESTION_TEXT)){
			question.setQuestionText(questionTextChars);
			questionTextChars = "";
			questionText = false;
		}
		else if(qName.equalsIgnoreCase(ANSWER_TEXT)){
			answer.setAnswerText(answerTextChars);
			answerTextChars = "";
			answerText = false;
		}
		else if(qName.equalsIgnoreCase(NUM_VOTES)){
			answer.setNumVotes(Integer.valueOf(numVotesChars));
			numVotesChars = "";
			numVotes = false;
		}
		else if(qName.equalsIgnoreCase(Q_TOKEN)){
			question.getTokens().add(qTokenChars);
			qTokenChars = "";
			qToken = false;
		}
		else if(qName.equalsIgnoreCase(Q_SENTENCE)){
			question.getSentences().add(qSentenceChars);
			qSentenceChars = "";
			qSentence = false;
		}
		else if(qName.equalsIgnoreCase(A_TOKEN)){
			answer.getTokens().add(aTokenChars);
			aTokenChars = "";
			aToken = false;
		}
		else if(qName.equalsIgnoreCase(A_SENTENCE)){
			answer.getSentences().add(aSentenceChars);
			aSentenceChars = "";
			aSentence = false;
		}
	}
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if((questionText & !qToken) & (questionText & !qSentence)){
			questionTextChars+= new String(ch, start, length);
		}
		else if((answerText & !aToken) & (answerText & !aSentence)){
			answerTextChars+= new String(ch, start, length);
		}
		else if(numVotes){
			numVotesChars+= new String(ch, start, length);
		}
		else if(qToken){
			qTokenChars+= new String(ch, start, length);
		}
		else if(qSentence){
			qSentenceChars+= new String(ch, start, length);
		}
		else if(aToken){
			aTokenChars+= new String(ch, start, length);
		}
		else if(aSentence){
			aSentenceChars+= new String(ch, start, length);
		}
	}
}
