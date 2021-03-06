/**
 * This class file was automatically generated by jASN1 (http://www.openmuc.org)
 */

package org.openiec61850.jmms.mms.asn1;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.LinkedList;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;

public class MmsPdu {

	public byte[] code = null;
	public ConfirmedRequestPdu confirmedRequestPdu = null;

	public ConfirmedResponsePdu confirmedResponsePdu = null;

	public UnconfirmedPDU unconfirmedPDU = null;

	public InitiateRequestPdu initiateRequestPdu = null;

	public InitiateResponsePdu initiateResponsePdu = null;

	public ServiceError initiateErrorPdu = null;

	public MmsPdu() {
	}

	public MmsPdu(byte[] code) {
		this.code = code;
	}

	public MmsPdu(ConfirmedRequestPdu confirmedRequestPdu, ConfirmedResponsePdu confirmedResponsePdu, UnconfirmedPDU unconfirmedPDU, InitiateRequestPdu initiateRequestPdu, InitiateResponsePdu initiateResponsePdu, ServiceError initiateErrorPdu) {
		this.confirmedRequestPdu = confirmedRequestPdu;
		this.confirmedResponsePdu = confirmedResponsePdu;
		this.unconfirmedPDU = unconfirmedPDU;
		this.initiateRequestPdu = initiateRequestPdu;
		this.initiateResponsePdu = initiateResponsePdu;
		this.initiateErrorPdu = initiateErrorPdu;
	}

	public int encode(BerByteArrayOutputStream berOStream, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				berOStream.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (initiateErrorPdu != null) {
			codeLength += initiateErrorPdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10)).encode(berOStream);
			return codeLength;

		}
		
		if (initiateResponsePdu != null) {
			codeLength += initiateResponsePdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 9)).encode(berOStream);
			return codeLength;

		}
		
		if (initiateRequestPdu != null) {
			codeLength += initiateRequestPdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8)).encode(berOStream);
			return codeLength;

		}
		
		if (unconfirmedPDU != null) {
			codeLength += unconfirmedPDU.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)).encode(berOStream);
			return codeLength;

		}
		
		if (confirmedResponsePdu != null) {
			codeLength += confirmedResponsePdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)).encode(berOStream);
			return codeLength;

		}
		
		if (confirmedRequestPdu != null) {
			codeLength += confirmedRequestPdu.encode(berOStream, false);
			codeLength += (new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)).encode(berOStream);
			return codeLength;

		}
		
		throw new IOException("Error encoding BerChoice: No item in choice was selected.");
	}

	public int decode(InputStream iStream, BerIdentifier berIdentifier) throws IOException {
		int codeLength = 0;
		int choiceDecodeLength = 0;
		BerIdentifier passedIdentifier = berIdentifier;
		if (berIdentifier == null) {
			berIdentifier = new BerIdentifier();
			codeLength += berIdentifier.decode(iStream);
		}
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			confirmedRequestPdu = new ConfirmedRequestPdu();
			codeLength += confirmedRequestPdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
			confirmedResponsePdu = new ConfirmedResponsePdu();
			codeLength += confirmedResponsePdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
			unconfirmedPDU = new UnconfirmedPDU();
			codeLength += unconfirmedPDU.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8)) {
			initiateRequestPdu = new InitiateRequestPdu();
			codeLength += initiateRequestPdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 9)) {
			initiateResponsePdu = new InitiateResponsePdu();
			codeLength += initiateResponsePdu.decode(iStream, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
			initiateErrorPdu = new ServiceError();
			codeLength += initiateErrorPdu.decode(iStream, false);
			return codeLength;
		}

		if (passedIdentifier != null) {
			return 0;
		}
		throw new IOException("Error decoding BerChoice: Identifier matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream berOStream = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(berOStream, false);
		code = berOStream.getArray();
	}
}

