package it.unitn.sisl.t4e.pojos;

import java.util.List;

public class Lecture {
	private String lectureId;
	private String lectureTitle;
	private String lectureDate;
	private List<Question> questions;
	private Course course;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public String getLectureId() {
		return lectureId;
	}
	public void setLectureId(String lectureId) {
		this.lectureId = lectureId;
	}
	public String getLectureTitle() {
		return lectureTitle;
	}
	public void setLectureTitle(String lectureTitle) {
		this.lectureTitle = lectureTitle;
	}
	public String getLectureDate() {
		return lectureDate;
	}
	public void setLectureDate(String lectureDate) {
		this.lectureDate = lectureDate;
	}
	
	public static Lecture copy(Lecture lecture){
		if(lecture == null){
			return lecture;
		}
		if(!(lecture instanceof Lecture)){
			return null;
		}
		Lecture copiedLecture = new Lecture();
		copiedLecture.setLectureId(lecture.getLectureId());
		copiedLecture.setLectureTitle(lecture.getLectureTitle());
		copiedLecture.setLectureDate(lecture.getLectureDate());
		copiedLecture.setQuestions(lecture.getQuestions());
		copiedLecture.setCourse(lecture.getCourse());
		return copiedLecture;
	}
}
