package fr.iutvalence.info.dut.m2107;

public enum Color {
	red(0xff0000),
	green(0x00ff00),
	blue(0x0000ff),
	gold(0xffd400),
	black(0),
	white(0xffffff);
	
	
	int colorCode;
	
	private Color(int code)
	{
		this.colorCode=code;
	}
}