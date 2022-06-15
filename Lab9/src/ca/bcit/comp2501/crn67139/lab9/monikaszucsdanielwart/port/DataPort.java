package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.port;

import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics.Electronic;

public class DataPort {


    public enum PortType {
        USB_A,
        USB_B,
        AUX,
        ETHERNET,
    }

    private final PortType portType;
    private DataPort connectedPort;
    private Electronic host;
    private boolean hostSet;

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
        if (!this.hostSet){
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
