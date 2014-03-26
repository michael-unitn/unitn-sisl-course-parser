package it.unitn.sisl.t4e.pojos;

import java.util.List;

public class Course {
	private String courseId;
	private String courseTitle;
	private String language;
	private List<Lecture> lectures;

	public List<Lecture> getLectures() {
		return lectures;
	}
	public void setLectures(List<Lecture> lectures) {
		this.lectures = lectures;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public static Course copy(Course course){
		if(course == null){
			return course;
		}
		if(!(course instanceof Course)){
			return null;
		}
		Course copiedCourse = new Course();
		copiedCourse.setCourseId(course.getCourseId());
		copiedCourse.setCourseTitle(course.getCourseTitle());
		copiedCourse.setLanguage(course.getLanguage());
		copiedCourse.setLectures(course.getLectures());
		return copiedCourse;
	}
}
