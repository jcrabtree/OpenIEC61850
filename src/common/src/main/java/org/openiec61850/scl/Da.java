/*
 * Copyright Fraunhofer ISE, energy & meteo Systems GmbH, and other contributors 2011
 *
 * This file is part of openIEC61850.
 * For more information visit http://www.openmuc.org 
 *
 * openIEC61850 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * openIEC61850 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with openIEC61850.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openiec61850.scl;

import org.openiec61850.FunctionalConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

class Da extends AbstractDataAttribute {
	private FunctionalConstraint fc = null;
	private boolean dchg = false;
	private boolean qchg = false;
	private boolean dupd = false;

	private static Logger logger = LoggerFactory.getLogger(Da.class);

	public Da(Node xmlNode) throws SclParseException {

		super(xmlNode);

		NamedNodeMap attributes = xmlNode.getAttributes();
		Node node;

		if (attributes != null) {
			String nodeName;

			for (int i = 0; i < attributes.getLength(); i++) {
				node = attributes.item(i);
				nodeName = node.getNodeName();

				if (nodeName.equals("fc")) {
					this.fc = FunctionalConstraint.fromString(node.getNodeValue());
					if (this.fc == null) {
						throw new SclParseException("Invalid Functional Constraint");
					}
				}
				else if (nodeName.equals("dchg")) {
					this.dchg = Util.parseBooleanValue(node.getNodeValue());
				}
				else if (nodeName.equals("qchg")) {
					this.qchg = Util.parseBooleanValue(node.getNodeValue());
				}
				else if (nodeName.equals("dupd")) {
					this.dupd = Util.parseBooleanValue(node.getNodeValue());
				}
			}
		}
		else {
			logger.error("SDO(): attributes = NULL!");
		}

		if (this.fc == null) {
			throw new SclParseException("Required attribute \"fc\" not found!");
		}

	}

	public FunctionalConstraint getFc() {
		return fc;
	}

	public boolean isDchg() {
		return dchg;
	}

	public boolean isQchg() {
		return qchg;
	}

	public boolean isDupd() {
		return dupd;
	}

}
