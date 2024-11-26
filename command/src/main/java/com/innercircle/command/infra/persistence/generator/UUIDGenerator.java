package com.innercircle.command.infra.persistence.generator;

import java.util.UUID;

public class UUIDGenerator {

	private UUIDGenerator() {
		throw new UnsupportedOperationException();
	}

	public static UUID generate() {
		return UUID.randomUUID();
	}
}
