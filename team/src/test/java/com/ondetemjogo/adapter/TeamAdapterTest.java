package com.ondetemjogo.adapter;

import org.junit.Assert;
import org.junit.Test;

import com.ondetemjogo.model.Team;

public class TeamAdapterTest {

	@Test
	public void shouldDoesntThrowErrorWithNullEvent() {
		Assert.assertNull(new TeamAdapter(null).build());
	}

	@Test
	public void shouldBuildEventDTO() {
		Team team = new Team();
		team.setName("Flamengo");
		Assert.assertNotNull(new TeamAdapter(team).build());
	}

}
