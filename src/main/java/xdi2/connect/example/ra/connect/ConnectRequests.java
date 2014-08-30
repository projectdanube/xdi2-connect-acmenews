package xdi2.connect.example.ra.connect;

import xdi2.connect.example.ra.util.FileUtil;
import xdi2.connect.example.ra.util.SignUtil;
import xdi2.core.syntax.CloudName;
import xdi2.messaging.MessageEnvelope;

public class ConnectRequests {

	public static final String ACMENEWS_CONNECT_REQUEST;
	public static final String ACMEPIZZA_CONNECT_REQUEST;

	static {

		try {

			MessageEnvelope messageEnvelope;

			messageEnvelope = FileUtil.loadMessageEnvelope("acmenews.message.xdi");
			SignUtil.signMessages(messageEnvelope, CloudName.create("+acmenews"), "acmenews");
			ACMENEWS_CONNECT_REQUEST = messageEnvelope.getGraph().toString("XDI/JSON", null);

			messageEnvelope = FileUtil.loadMessageEnvelope("acmepizza.message.xdi");
			SignUtil.signMessages(messageEnvelope, CloudName.create("+acmepizza"), "acmepizza");
			ACMEPIZZA_CONNECT_REQUEST = messageEnvelope.getGraph().toString("XDI/JSON", null);
		} catch (Exception ex) {

			throw new RuntimeException(ex.getMessage(), ex);
		}
	}
}
