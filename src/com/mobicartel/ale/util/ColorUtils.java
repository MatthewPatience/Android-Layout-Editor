package com.mobicartel.ale.util;

import java.math.BigInteger;


public class ColorUtils {
	
	public static int getHexColorFromString(String str_value) {
		str_value = str_value.replace("#", "");
		if (str_value.length() == 6) { //RRGGBB
			return new BigInteger("ff" + str_value, 16).intValue();
		} else if (str_value.length() == 8) { //AARRGGBB
			return new BigInteger(str_value, 16).intValue();
		} else {
			return 0xffffffff;
		}
	}

}
