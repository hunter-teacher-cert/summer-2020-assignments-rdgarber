import java.io.*;
import java.util.*;


public class Time{

	
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
	
	public boolean equals(Time that) {
		return this.hour == that.hour
			&& this.minute == that.minute
			&& this.second == that.second;
	}
	
	
	public Time add(Time t2) {
		Time sum = new Time();
		sum.hour = this.hour + t2.hour;
		sum.minute = this.minute + t2.minute;
		sum.second = this.second + t2.second;

		if (sum.second >= 60.0) {
			sum.second -= 60.0;
			sum.minute += 1;
		}
		if (sum.minute >= 60) {
			sum.minute -= 60;
			sum.hour += 1;
		}
		if (sum.hour >= 24)  {
			sum.hour -= 24;
		}
		return sum;
	}  // end add
	
	// updates time - adding seconds
	public Time increment(double seconds) {
		int newminutes;
		
		newminutes = Math.round((float) (this.second + seconds)/60);
		this.hour += Math.round((float) (this.minute + newminutes)/60);
		this.minute += newminutes;
		this.second += seconds;
		this.minute %= 60;
		this.hour %= 12;
		if (this.hour == 0)
			this.hour = 12;
		this.second %= 60;
		return this;
	} // end increment
} // end class Time
