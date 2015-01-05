package xdi2.connect.acmenews;

import java.net.URI;

import javax.servlet.ServletContext;

import xdi2.connect.core.ConnectionRequest;
import xdi2.core.impl.memory.MemoryGraphFactory;
import xdi2.core.syntax.CloudName;
import xdi2.messaging.MessageEnvelope;

public class AcmenewsConnectionRequest {

	public static ConnectionRequest CONNECTION_REQUEST = null;

	public static ConnectionRequest connectionRequest(ServletContext servletContext) {

		if (CONNECTION_REQUEST == null) {

			try {

				String baseReturnUri = servletContext.getInitParameter("baseReturnUri");

				CONNECTION_REQUEST = ConnectionRequest.fromMessageEnvelope(MessageEnvelope.fromGraph(MemoryGraphFactory.getInstance().loadGraph(AcmenewsConnectionRequest.class.getResourceAsStream("/message.xdi"))));
				CONNECTION_REQUEST.sign(CloudName.create("+acmenews"), "acmenews");
				CONNECTION_REQUEST.setReturnUri(URI.create(baseReturnUri + "acmenews-return"));
			} catch (Exception ex) {

				CONNECTION_REQUEST = null;
				throw new RuntimeException(ex.getMessage(), ex);
			}
		}

		return CONNECTION_REQUEST;
	}
}
