package xdi2.connect.example.ra.connect;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import xdi2.connect.core.ConnectRequest;
import xdi2.core.impl.memory.MemoryGraphFactory;
import xdi2.core.syntax.CloudName;
import xdi2.messaging.MessageEnvelope;

public class ConnectRequests {

	public static ConnectRequest ACMENEWS_CONNECT_REQUEST = null;
	public static ConnectRequest ACMEPIZZA_CONNECT_REQUEST = null;

	public static ConnectRequest acmenewsConnectRequest(HttpServletRequest request) {

		if (ACMENEWS_CONNECT_REQUEST == null) {

			try {

				String baseUri = request.getRequestURL().toString();
				baseUri = baseUri.substring(0, baseUri.lastIndexOf('/'));

				ACMENEWS_CONNECT_REQUEST = ConnectRequest.fromMessageEnvelope(MessageEnvelope.fromGraph(MemoryGraphFactory.getInstance().loadGraph(ConnectRequests.class.getResourceAsStream("/acmenews.message.xdi"))));
				ACMENEWS_CONNECT_REQUEST.sign(CloudName.create("+acmenews"), "acmenews");
				ACMENEWS_CONNECT_REQUEST.setReturnUri(URI.create(baseUri + "/acmenews-return"));
			} catch (Exception ex) {

				throw new RuntimeException(ex.getMessage(), ex);
			}
		}

		return ACMENEWS_CONNECT_REQUEST;
	}

	public static ConnectRequest acmepizzaConnectRequest(HttpServletRequest request) {

		if (ACMEPIZZA_CONNECT_REQUEST == null) {

			try {

				String baseUri = request.getRequestURL().toString();
				baseUri = baseUri.substring(0, baseUri.lastIndexOf('/'));

				ACMEPIZZA_CONNECT_REQUEST = ConnectRequest.fromMessageEnvelope(MessageEnvelope.fromGraph(MemoryGraphFactory.getInstance().loadGraph(ConnectRequests.class.getResourceAsStream("/acmepizza.message.xdi"))));
				ACMEPIZZA_CONNECT_REQUEST.sign(CloudName.create("+acmepizza"), "acmepizza");
				ACMEPIZZA_CONNECT_REQUEST.setReturnUri(URI.create(baseUri + "/acmepizza-return"));
			} catch (Exception ex) {

				throw new RuntimeException(ex.getMessage(), ex);
			}
		}

		return ACMEPIZZA_CONNECT_REQUEST;
	}
}
