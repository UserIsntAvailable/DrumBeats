package core.utils;

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

	public static <T extends Enum<T>> Enum<T> getEnumFromConstantValue(Class<T> enumType, int flag) throws Exception {
		var values = getEnumValuesFromFlag(enumType, flag);

		if (!(values.size() >= 2)) {
			var value = values.stream().findFirst();
			if (value.isPresent()) return value.get();
		}

		throw new Exception("You provided a wrong flag");
	}
}
