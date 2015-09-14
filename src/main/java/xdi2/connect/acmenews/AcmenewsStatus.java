package xdi2.connect.acmenews;

import java.net.URI;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

import xdi2.connect.core.ConnectionResult;
import xdi2.core.syntax.CloudNumber;

public class AcmenewsStatus {

	private static Deque<Status> statuses = new ArrayDeque<Status> ();

	public static void newStatus(ConnectionResult connectionResult, URI discovery) {

		Status status = new Status();
		status.date = new Date();
		status.connectionResult = connectionResult;
		status.discovery = discovery;

		statuses.add(status);
		if (statuses.size() > 10) statuses.removeFirst();
	}

	public static String status() {

		StringBuffer buffer = new StringBuffer();

		for (Status status : statuses) {

			buffer.insert(0, status.toString() + "\n");
		}

		return buffer.toString();
	}

	private static class Status {

		private Date date;
		private ConnectionResult connectionResult;
		private URI discovery;

		private String getData() {

			CloudNumber cloudNumber = this.connectionResult.getCloudNumber();
			if (cloudNumber == null) return null;

			return cloudNumber.toString();
		}

		@Override
		public String toString() {

			String data = this.getData();

			return this.date.toString() + ": " + data + "\n";
		}
	}
}
