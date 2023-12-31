package com.streams.practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CourseStreams {

	public static void main(String[] args) {
		List<Course> courses = List.of(
			new Course("Spring", "Framework", 98, 20000),
			new Course("Spring Boot", "Framework", 95, 18000),
			new Course("API", "Microservices", 97, 22000),
			new Course("Microservices", "Microservices", 96, 25000),
			new Course("FullStack", "FullStack", 91, 14000),
			new Course("AWS", "Cloud", 92, 21000),
			new Course("Azure", "Cloud", 99, 21000),
			new Course("Docker", "Cloud", 92, 20000),
			new Course("Kubernetes", "Cloud", 91, 20000)
		);
		//allMatch, noneMatch, anyMatch
		Predicate<Course> scoreGreaterThan90 = course->course.getScore()>90;
		System.out.println(courses.stream().allMatch(scoreGreaterThan90));
		
		Predicate<Course> scoreLessThan90 = getPredicateForReviewScoreLessThan90();
		System.out.println(courses.stream().noneMatch(scoreLessThan90));
		
		Predicate<Course> scoreGreaterThan99 = course->course.getScore()>99;
		System.out.println(courses.stream().anyMatch(scoreGreaterThan99));
		
		Comparator<Course> comparingNumberOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents);
		System.out.println(courses.stream().sorted(comparingNumberOfStudentsIncreasing).collect(Collectors.toList()));
		
		Comparator<Course> comparingNumberOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed();
		System.out.println(courses.stream().sorted(comparingNumberOfStudentsDecreasing).collect(Collectors.toList()));
		
		/*thenComparing: AND operation*/
		Comparator<Course> comparingNumberOfStudentsAndReviewScoresDecreasing = Comparator.comparing(Course::getNoOfStudents).thenComparing(Course::getScore).reversed();
		System.out.println(courses.stream().sorted(comparingNumberOfStudentsAndReviewScoresDecreasing).collect(Collectors.toList()));
		
		/*skip*/
		System.out.println(courses.stream().sorted(Comparator.comparing(Course::getName)).skip(3).collect(Collectors.toList()));
		
		/*limit*/
		System.out.println(courses.stream().sorted(Comparator.comparing(Course::getName)).skip(3).limit(2).collect(Collectors.toList()));
		
		/*takeWhile*/
		System.out.println(courses.stream().sorted(Comparator.comparing(Course::getName)).takeWhile(course->course.getName().length()<=9).collect(Collectors.toList()));
		
		/*dropWhile*/
		System.out.println(courses.stream().sorted(Comparator.comparing(Course::getName)).dropWhile(course->course.getName().length()<=9).collect(Collectors.toList()));
		
		/*max*/
		System.out.println(courses.stream().max(Comparator.comparing(Course::getName).reversed()).orElse(new Course("AWS", "Cloud", 92, 21000)));
		
		/*min*/
		System.out.println(courses.stream().min(Comparator.comparing(Course::getName).reversed()).orElse(new Course("AWS", "Cloud", 92, 21000)));
		
		/*optional*/
		System.out.println(courses.stream().filter(c->c.getName().length()>15).min(Comparator.comparing(Course::getName)).orElse(new Course("AWS", "Cloud", 92, 21000)));
		
		/*findFirst*/
		System.out.println(courses.stream().filter(c->c.getName().length()>9).findFirst().orElse(new Course("AWS", "Cloud", 92, 21000)));
		
		/*findAny*/
		System.out.println(courses.stream().filter(c->c.getName().length()>11).sorted(Comparator.comparing(Course::getNoOfStudents).reversed()).findAny().orElse(new Course("AWS", "Cloud", 92, 21000)));
		
		/*sum*/
		System.out.println(courses.stream().filter(c->c.getScore()>95).mapToInt(Course::getNoOfStudents).sum());
		
		/*average*/
		System.out.println(courses.stream().filter(c->c.getScore()>95).mapToInt(Course::getNoOfStudents).average());
		
		/*count*/
		System.out.println(courses.stream().filter(c->c.getScore()>95).mapToInt(Course::getNoOfStudents).count());
		
		/*max & min*/
		System.out.println(courses.stream().filter(c->c.getScore()>95).mapToInt(Course::getNoOfStudents).max());
		System.out.println(courses.stream().filter(c->c.getScore()>95).mapToInt(Course::getNoOfStudents).min());
		
		/*joining*/
		System.out.println(courses.stream().map(s->s.getName()).collect(Collectors.joining(",")));
		
		/*joining-split-characters*/
		System.out.println(courses.stream().map(s->s.getName().split("")).collect(Collectors.toList()));
		System.out.println(courses.stream().map(s->s.getName().split("")).flatMap(Arrays::stream).collect(Collectors.toList()));
		System.out.println(courses.stream().map(s->s.getName().split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));
		
	}
	
	public static Predicate<Course> getPredicateForReviewScoreLessThan90(){
		return course->course.getScore()<90;
	}

}