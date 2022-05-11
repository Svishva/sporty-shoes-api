package com.sportyshoes.utils;

import org.springframework.lang.Nullable;

public class CollectionUtils {

	private CollectionUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static boolean isEmpty(@Nullable java.util.Collection<?> collection) {
		return org.springframework.util.CollectionUtils.isEmpty(collection);
	}

	public static boolean isEmpty(@Nullable java.util.Map<?, ?> map) {
		return org.springframework.util.CollectionUtils.isEmpty(map);
	}

	public static boolean isEmpty(@Nullable Object obj) {
		return org.springframework.util.ObjectUtils.isEmpty(obj);
	}

	public static boolean isEmpty(@Nullable Object[] array) {
		return org.springframework.util.ObjectUtils.isEmpty(array);
	}

}
