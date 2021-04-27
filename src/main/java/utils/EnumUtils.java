package utils;

import java.util.BitSet;
import java.util.EnumSet;
import java.util.stream.Collectors;

public class EnumUtils {
	public EnumUtils() {
	}

	public static <T extends Enum<T>> EnumSet<T> getEnumValuesFromFlag(Class<T> enumType, int flag) {

		T[] values = enumType.getEnumConstants();

		return BitSet.valueOf(new byte[]{(byte) flag}).stream()
				.filter(n -> n < values.length) // bounds check
				.mapToObj(n -> values[n])
				.collect(Collectors.toCollection(() -> EnumSet.noneOf(enumType)));
	}

	public static <T extends Enum<T>> T getEnumFromConstantValue(Class<T> enumType, int flag) {
		return enumType.getEnumConstants()[flag];
	}
}
