package com.personal.dashboard.utils;

import java.util.UUID;

/**
 * UniqueId Generator Utility
 *
 */
public final class UniqueIdGenerator {

	private UniqueIdGenerator() {
	}

	public static String generate() {
		return UUID.randomUUID().toString();
	}
}
