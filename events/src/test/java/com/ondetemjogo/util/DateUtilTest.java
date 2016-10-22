package com.ondetemjogo.util;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

	@Test
	public void shouldResetHour() {
		Date date = new Date();
		date = DateUtil.resetHour(date);
		Assert.assertEquals(date.getHours(), 0);
	}

	@Test
	public void shouldResetMinute() {
		Date date = new Date();
		date = DateUtil.resetHour(date);
		Assert.assertEquals(date.getMinutes(), 0);
	}

	@Test
	public void shouldResetSecond() {
		Date date = new Date();
		date = DateUtil.resetHour(date);
		Assert.assertEquals(date.getSeconds(), 0);
	}

	@Test
	public void shouldResetMillisecond() {
		Date date = new Date();
		date = DateUtil.resetHour(date);
		Assert.assertEquals(date.getSeconds() * 1000, 0);
	}

}
