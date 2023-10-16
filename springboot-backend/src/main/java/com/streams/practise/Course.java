package com.streams.practise;

class Course {
	private String name;
	private String category;
	private int score;
	private int noOfStudents;

	public Course(String name, String category, int score, int noOfStudents) {
		super();
		this.name = name;
		this.score = score;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int reviewScore) {
		this.score = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + score;
	}
}