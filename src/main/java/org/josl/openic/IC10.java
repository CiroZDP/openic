package org.josl.openic;

public class IC10 {

	public static final int IC_FALSE = 0x00;
	public static final int IC_TRUE = 0x01;
	
	public static final int IC_CENTER = 0x02;
	public static final int IC_RIGHT = 0x03;
	public static final int IC_LEFT = 0x04;
	public static final int IC_TOP = 0x05;
	public static final int IC_BOTTOM = 0x06;
	
	public static final int IC_RIGHT_TOP = (IC_RIGHT << 1) + IC_TOP;
	public static final int IC_LEFT_TOP = (IC_LEFT << 1) + IC_TOP;
	public static final int IC_RIGHT_BOTTOM = (IC_RIGHT << 1) + IC_BOTTOM;
	public static final int IC_LEFT_BOTTOM = (IC_LEFT << 1) + IC_BOTTOM;
	
}
