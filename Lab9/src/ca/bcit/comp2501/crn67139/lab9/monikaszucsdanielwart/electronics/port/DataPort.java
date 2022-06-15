package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.port;

import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.Electronic;

/**
 * DataPort.java COMP 2501 - CRN: 67139 Wednesday evenings, Spring/Summer 2022 Lab #9
 *
 * <p>Exploring Inheritance by developing a data class hierarchy.
 *
 * @author Monika Szucs
 * @author Daniel Wart
 *     <p>This DataPort class allows devices to be connected to eachother as long as the port types
 *     match.
 */
public class DataPort {

    /** The port type. Only like ports can connect */
    public enum PortType {
        USB_A,
        USB_B,
        AUX,
        ETHERNET,
    }

    private final PortType portType;
    private DataPort connectedPort;
    private Electronic host; // Where the port is actually located
    private boolean hostSet; // Makes sure that host can only be set once

    public DataPort(PortType portType) {
        this.portType = portType;
        this.connectedPort = null;
    }

    public PortType getPortType() {
        return portType;
    }

    public DataPort getConnectedPort() {
        return connectedPort;
    }

    public Electronic getHost() {
        return host;
    }

    public void setHost(Electronic host) {
        if (!this.hostSet) {
            this.hostSet = true;
            this.host = host;
        }
    }

    public void disconnectPort() {
        this.connectedPort.connectedPort = null;
        this.connectedPort = null;
    }

    public void connectPort(DataPort otherPort) throws FullPortsException {
        if (otherPort.connectedPort != null || this.connectedPort != null) {
            throw new FullPortsException("Ports are already in use");
        }
        otherPort.connectedPort = this;
        this.connectedPort = otherPort;
    }

    public boolean isConnected() {
        return connectedPort != null;
    }
}
