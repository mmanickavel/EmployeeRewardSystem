package com.streams.practise;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PractiseStreams {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,7,4,23,7,9);
		printOddNumberInListFunctional(numbers);
		printCubesOfOddNumberInListFunctional(numbers);
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
		printAllCoursesInListFunctional(courses);
		printCoursesContainsSpringInListFunctional(courses);
		printCoursesHavingFourLettersInListFunctional(courses);
		printCourseLengthsInListFunctional(courses);
		printAllCoursesSortedByCourseLengthInListFunctional(courses);
		printNumbersInListSortedByDesc(numbers);
		System.out.println(subListOfEvenNumbersInListFunctional(numbers));
		System.out.println(subListOfCourseLengthsInListFunctional(courses));
		int sum = addListStructured(numbers);
		System.out.println(sum);
		Predicate<Integer> oddPredicate = n->n%2!=0;
		filterAndPrint(numbers, oddPredicate);		
		Predicate<Integer> evenPredicate = n->n%2==0;
		filterAndPrint(numbers, evenPredicate);
	}

	/*Exercise 1*/
	private static void printOddNumberInListFunctional(List<Integer> numbers) {
		numbers.stream().filter(number->number%2!=0).forEach(System.out::println);
	}
	
	/*Exercise 2*/
	private static void printAllCoursesInListFunctional(List<String> courses) {
		courses.stream().forEach(System.out::println);
	}

	/*Exercise 3*/
	private static void printCoursesContainsSpringInListFunctional(List<String> courses) {
		courses.stream().filter(course-> course.contains("Spring")).forEach(System.out::println);
	}
	
	/*Exercise 4*/
	private static void printCoursesHavingFourLettersInListFunctional(List<String> courses) {
		courses.stream().filter(course->course.length()>4).forEach(System.out::println);
	}

	/*Exercise 5*/
	private static void printCubesOfOddNumberInListFunctional(List<Integer> numbers) {
		numbers.stream().filter(number -> number%2!=0).map(number -> number*number*number).forEach(System.out::println);
	}
	
	/*Exercise 6*/
	private static void printCourseLengthsInListFunctional(List<String> courses) {
		courses.stream().map(course -> course +": "+ course.length()).forEach(System.out::println);
	}
	
	private static int addListStructured(List<Integer> numbers) {
//		return numbers.stream().reduce(0, (a,b) -> a+b);
		return numbers.stream().reduce(0, PractiseStreams::sum);
	}
	
	private static int sum(int a, int b) {
		return a+b;
	}
	
	/*Exercise 10*/
	private static List<Integer> subListOfEvenNumbersInListFunctional(List<Integer> numbers) {
		return numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
	}
	
	/*Exercise 11*/
	private static List<Integer> subListOfCourseLengthsInListFunctional(List<String> courses) {
		return courses.stream().map(c->c.length()).collect(Collectors.toList());
	}
	

	private static void printNumbersInListSortedByDesc(List<Integer> numbers) {
		numbers.stream().distinct().sorted(Comparator.reverseOrder()).forEach(System.out::println);		
	}

	private static void printAllCoursesSortedByCourseLengthInListFunctional(List<String> courses) {
		courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
	}
	
	private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
		numbers.stream().filter(predicate).forEach(System.out::println);
	}


}