unitn-sisl-course-parser
========================

A SAX parser for the Q&amp;A corpus provided as part of the assignment for course 'Language Understanding Systems'

Usage Example (import course-parser-0.1.jar into your project)
=============

SAXParserFactory parserFactory = SAXParserFactory.newInstance();
final String CORPUS_PATH = "/home/michael/ig1.corpus.xml";
try {
	SAXParser courseParser = parserFactory.newSAXParser();
	CourseHandler courseHandler = new CourseHandler();
	courseParser.parse(new File(CORPUS_PATH), courseHandler);
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

