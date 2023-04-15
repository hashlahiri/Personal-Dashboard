package com.personal.dashboard.utils;

import com.github.slugify.Slugify;

/**
 * Slug Utility
 *
 */
public class Slug {

	public static String get(String simpleString) {
		Slugify slugify = Slugify.builder().build();
		return slugify.slugify(simpleString);
	}

	public static String underscoreSeperator(String simpleString) {
		Slugify slugify = Slugify.builder().underscoreSeparator(true).build();
		return slugify.slugify(simpleString);
	}

	public static String caseSensitive(String simpleString) {
		Slugify slugify = Slugify.builder().lowerCase(false).build();
		return slugify.slugify(simpleString);
	}
}