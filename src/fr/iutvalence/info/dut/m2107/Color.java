package fr.iutvalence.info.dut.m2107;

public enum Color {
	red(0xff0000),
	blue(0x0000ff),
	gold(0xffd400),
	green(0x00ff00),
	black(0),
	white(0xffffff);
	
	int colorID;
	
	private Color(int code)
	{
		this.colorID=code;
	}
}