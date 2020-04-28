/*
 * This file is part of the Salt Edge Authenticator distribution
 * (https://github.com/saltedge/sca-identity-service-example).
 * Copyright (c) 2020 Salt Edge Inc.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 3 or later.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * For the additional permissions granted for Salt Edge Authenticator
 * under Section 7 of the GNU General Public License see THIRD_PARTY_NOTICES.md
 */
package com.saltedge.sca.sdk.tools;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class DateToolsTests {
	@Test
	public void dateIsExpiredTest() {
		Instant ldt = Instant.parse("2000-01-01T09:00:00Z");

		assertThat(DateTools.dateIsExpired(ldt)).isTrue();

		ldt = Instant.now().plusSeconds(1);

		assertThat(DateTools.dateIsExpired(ldt)).isFalse();

		assertThat(DateTools.dateIsExpired(null)).isFalse();
	}

	@Test
	public void nowUtcSecondsTest() {
		assertThat(DateTools.nowUtcSeconds()).isCloseTo(Math.toIntExact((new Date().getTime() / 1000L)), Assertions.within(1));
	}
}
