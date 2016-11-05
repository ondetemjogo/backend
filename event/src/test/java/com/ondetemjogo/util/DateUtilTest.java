package com.ondetemjogo.util;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

	@Test
	public void shouldResetHour() {
		Date date = new Date();
		Date newDate = DateUtil.resetHour(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(newDate);
		Assert.assertEquals(calendar.get(Calendar.HOUR_OF_DAY), 0);
	}

	@Test
	public void shouldResetMinute() {
		Date date = new Date();
		Date newDate = DateUtil.resetHour(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(newDate);
		Assert.assertEquals(calendar.get(Calendar.MINUTE), 0);
	}

	@Test
	public void shouldResetSecond() {
		Date date = new Date();
		Date newDate = DateUtil.resetHour(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(newDate);
		Assert.assertEquals(calendar.get(Calendar.SECOND), 0);
	}

	@Test
	public void shouldResetMillisecond() {
		Date date = new Date();
		Date newDate = DateUtil.resetHour(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(newDate);
		Assert.assertEquals(calendar.get(Calendar.MILLISECOND), 0);
	}

}
