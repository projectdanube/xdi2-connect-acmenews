package xdi2.connect.example.ra.acmepizza;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

import xdi2.connect.core.ConnectResult;

public class AcmepizzaStatus {

	private static Deque<Status> statuses = new ArrayDeque<Status> ();

	public static void newStatus(ConnectResult connectResult) {

		Status status = new Status();
		status.date = new Date();
		status.connectResult = connectResult;

		statuses.add(status);
		if (statuses.size() > 10) statuses.removeFirst();
	}

	public static String status() {

		StringBuffer buffer = new StringBuffer();

		for (Status status : statuses) {

			buffer.append(status.date.toString() + ": " + status.connectResult.getCloudNumber() + "\n");
		}

		return buffer.toString();
	}

	private static class Status {

		private Date date;
		private ConnectResult connectResult;
	}
}
