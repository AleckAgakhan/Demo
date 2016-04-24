package aleck.agakhan;

import java.text.DecimalFormat;

// precision = 3
// .9995 => 1
// .9994 => 0.999

public class DoubleExt
{
	private static final String format = "#.";

	public DoubleExt(int precision)
	{
		delta = 1d / Math.pow(10, precision);
		StringBuilder sb = new StringBuilder(format.length()+precision);
		sb.append(format);
		for(int i = 0; i<precision; i++) sb.append("#");
		decimalFormatter = new DecimalFormat(sb.toString());
	}

	private final double delta;
	private final DecimalFormat decimalFormatter;

	public String formatDouble(double value)
	{
		String str = decimalFormatter.format(value);
		return str.equals("-0")? "0" : str;
	}

	public boolean isZero(double value)
	{
		return Math.abs(value) - delta <= 0;
	}
}
