package com.personal.dashboard.utils;

import java.time.*;
import java.util.Date;


public class DateUtil {

	public static Date now() {
		return new Date();
	}

	@SuppressWarnings("static-access")
	public static LocalDateTime getLoalDateTime(Date date) {

		LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

		// return localDateTime;
		// if(localDateTime.isAfter(LocalDateTime.now())) {
		// return LocalDateTime.now().of(LocalDate.now(ZoneId.systemDefault()),
		// LocalTime.MIDNIGHT);
		// }

		return localDateTime.of(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalTime.MIDNIGHT);

	}

	@SuppressWarnings("static-access")
	public static LocalDateTime getLocalDateTimeMidnight(LocalDateTime inputLocalDateTimeDate) {
		LocalTime midnight = inputLocalDateTimeDate.toLocalTime().MIDNIGHT;
		LocalDate today = inputLocalDateTimeDate.toLocalDate();// LocalDate.now(ZoneId.systemDefault());

		return LocalDateTime.of(today, midnight);

	}

	public static Date convertToDateViaInstant(LocalDate dateToConvert) {
		return Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDateTime getLocalDateTimeFromRaw(Long rawTimeStamp) {
		return LocalDateTime.ofInstant(Instant.ofEpochMilli(rawTimeStamp), ZoneId.systemDefault());
	}

	public static Long getCurrentEpochInMilliSeconds() {
		return (System.currentTimeMillis() / 1000L);
	}

	public static Long getCurrentEpochInSeconds() {
		return (System.currentTimeMillis() / 1000L);
	}

	public static Long getIncrementedEpochInSeconds(Long timeInEpochSeconds, Long minutesToAdd) {
		return timeInEpochSeconds + (minutesToAdd * 60);
	}

	/**
	 * Create Expire Date time
	 * 
	 * @param EXPIRY_TIME
	 * @return
	 */
	public static Date createExpiryDateTime(Integer EXPIRY_TIME) {

		// Get current Epoch Time
		Long expTimeMillis = Instant.now().toEpochMilli();

		// Add Expire Time
		expTimeMillis += EXPIRY_TIME;

		// Create Expiration Date with Time
		Date expirationDate = new Date();
		expirationDate.setTime(expTimeMillis);

		return expirationDate;
	}

	public static Date convertToDate(LocalDateTime localDateTime) {
		if (localDateTime != null)
			return Date.from(localDateTime.toInstant(ZoneOffset.UTC));
		return null;
	}
}