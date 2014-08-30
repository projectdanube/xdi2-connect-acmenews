package xdi2.connect.example.ra.util;

import java.io.IOException;
import java.io.InputStream;

import xdi2.core.exceptions.Xdi2ParseException;
import xdi2.core.impl.memory.MemoryGraphFactory;
import xdi2.messaging.MessageEnvelope;

public class FileUtil {

	public static MessageEnvelope loadMessageEnvelope(String filename) throws Xdi2ParseException, IOException {

		InputStream inputStream = FileUtil.class.getResourceAsStream("/" + filename);

		return MessageEnvelope.fromGraph(MemoryGraphFactory.getInstance().loadGraph(inputStream));
	}
}
