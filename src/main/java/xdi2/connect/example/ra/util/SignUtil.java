package xdi2.connect.example.ra.util;

import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;

import xdi2.client.exceptions.Xdi2ClientException;
import xdi2.client.util.XDIClientUtil;
import xdi2.core.features.signatures.KeyPairSignature;
import xdi2.core.syntax.CloudName;
import xdi2.core.syntax.CloudNumber;
import xdi2.discovery.XDIDiscoveryClient;
import xdi2.discovery.XDIDiscoveryResult;
import xdi2.messaging.Message;
import xdi2.messaging.MessageEnvelope;

public class SignUtil {

	public static void signMessages(MessageEnvelope messageEnvelope, CloudName cloudName, String secretToken) throws Xdi2ClientException, GeneralSecurityException {

		XDIDiscoveryResult xdiDiscoveryResult = XDIDiscoveryClient.NEUSTAR_PROD_DISCOVERY_CLIENT.discoverFromRegistry(cloudName.getXDIAddress(), null);
		if (xdiDiscoveryResult == null || xdiDiscoveryResult.getCloudNumber() == null || xdiDiscoveryResult.getXdiEndpointUrl() == null) throw new Xdi2ClientException("Discovery failed on " + cloudName);

		CloudNumber cloudNumber = xdiDiscoveryResult.getCloudNumber();
		URL xdiEndpointUrl = xdiDiscoveryResult.getXdiEndpointUrl();

		PrivateKey privateKey = XDIClientUtil.retrieveSignaturePrivateKey(cloudNumber, xdiEndpointUrl, secretToken);

		for (Message message : messageEnvelope.getMessages()) {

			KeyPairSignature signature = (KeyPairSignature) message.createSignature(KeyPairSignature.DIGEST_ALGORITHM_SHA, 256, KeyPairSignature.KEY_ALGORITHM_RSA, 2048, true);
			signature.sign(privateKey);
		}
	}
}
