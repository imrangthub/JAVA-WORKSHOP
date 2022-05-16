package com.imranmadbar.collectionFramework.list.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListStreamMainCls {
	

	public static void main(String args[]) {

		Pattern tkPrattern = Pattern.compile("(\\d*?)(?=tk)");
		Pattern mbPattern = Pattern.compile("(\\d*?)(?=mb)");
		Pattern dayPattern = Pattern.compile("(\\d*?)(?=d)");

		List<StudentInfo> customInfoStList = new ArrayList<>();
		List<Student> rowStList = Arrays.asList(new Student("9tk-870mb-8d"), new Student("103tk-320mb-11d"));

		System.out.println("Row List:" + rowStList);

		customInfoStList = rowStList.stream().map(obj -> {
			StudentInfo stInfoObj = new StudentInfo();
			Matcher tkMatcher = tkPrattern.matcher(obj.getInfo());
			if (tkMatcher.find()) {
				stInfoObj.setId(tkMatcher.group(1));
			}
			Matcher mbMatcher = mbPattern.matcher(obj.getInfo());
			if (mbMatcher.find()) {
				stInfoObj.setName(mbMatcher.group(1));
			}
			Matcher dayMatcher = dayPattern.matcher(obj.getInfo());
			if (dayMatcher.find()) {
				stInfoObj.setGender(dayMatcher.group(1));
			}

			return stInfoObj;
		}).collect(Collectors.toList());

		System.out.println("Custom List:" + customInfoStList);

	}
}
