package com.ondetemjogo.event.adapter;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.ondetemjogo.event.adapter.EventAdapter;
import com.ondetemjogo.event.model.Establishment;
import com.ondetemjogo.event.model.Event;
import com.ondetemjogo.event.model.Team;

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
