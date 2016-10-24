package com.ondetemjogo.adapter;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.ondetemjogo.model.Establishment;
import com.ondetemjogo.model.Event;
import com.ondetemjogo.model.Team;

public class EventAdapterTest {

	@Test
	public void shouldDoesntThrowErrorWithNullEvent() {
		Assert.assertNull(new EventAdapter(null).build());
	}
	
	@Test
	public void shouldBuildEventDTO() {
		Event event = new Event();
		event.setDate(new Date());
		event.setEstablishment(new Establishment());
		event.setHouseTeam(new Team());
		event.setVisitTeam(new Team());
		Assert.assertNotNull(new EventAdapter(event).build());
	}
}
