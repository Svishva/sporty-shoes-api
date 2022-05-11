package com.sportyshoes.utils;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

public class RandomDataGeneratorUtil {

	private RandomDataGeneratorUtil() {
		throw new IllegalStateException("Utility class");
	}

	private static String getNanoID() {
		return NanoIdUtils.randomNanoId();
	}

	public static String getUniqueId() {
		return getNanoID();
	}

}
