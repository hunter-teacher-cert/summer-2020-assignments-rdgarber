import java.io.*;
import java.util.*;


public class Time{

    public static void main(String[] args) {
		Time curtime = new Time(11,59, 59.9);
		printTime(curtime);
		System.out.println(curtime);
		
		
	} // end main
	
	
	// your time class code goes in here
    private int hour;
	private int minute;
	private double second;
	
	public Time()	{	// constructor
		this.hour = 0;
		this.minute = 0;
		this.second = 0;
		
	} // end Time constructor
	
	public Time(int hour, int minute, double second)	{	// constructor
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		
	} // end Time constructor
	
	public int getHour() {
		return this.hour;
	}

	public int getMinute() {
		return this.minute;
	}

	public double getSecond() {
		return this.second;
	}
			
	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	public String toString() {
		return String.format("%02d:%02d:%04.1f\n",
			this.hour, this.minute, this.second);
	}
	
	public static void printTime(Time t) {
		System.out.printf("%02d:%02d:%04.1f\n",
			t.hour, t.minute, t.second);
	}
} // end class Time
