//===========================================================================================================================
//	Program : Timer class to calculate the timings, code provided by Dr.Balaji
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================

public class Timer {
	long startTime, endTime, elapsedTime, memAvailable, memUsed;

	public Timer() {
		startTime = System.currentTimeMillis();
	}

	public void start() {
		startTime = System.currentTimeMillis();
	}

	public Timer end() {
		endTime = System.currentTimeMillis();
		elapsedTime = endTime - startTime;
		memAvailable = Runtime.getRuntime().totalMemory();
		memUsed = memAvailable - Runtime.getRuntime().freeMemory();
		return this;
	}

	public String toString() {
		return "Time: " + elapsedTime + " msec.\n" + "Memory: " + (memUsed / 1048576) + " MB / "
				+ (memAvailable / 1048576) + " MB.";
	}

}
