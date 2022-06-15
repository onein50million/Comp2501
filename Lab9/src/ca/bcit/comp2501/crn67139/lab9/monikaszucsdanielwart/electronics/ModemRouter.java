package ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.electronics;

import ca.bcit.comp2501.crn67139.lab9.monikaszucsdanielwart.port.DataPort;

public class ModemRouter extends Electronic {
    private boolean internet;

    //Government regulations limit ethernet ports to 10
    private static final int MAX_ETHERNET_PORTS = 10;

    /**
     * This is an Electronics Class
     *
     * @param brand              this is the brand of the electronics
     * @param model              this is the model of the electronics
     * @param priceCdn           this is the price of the electronics in Canadian Dollars
     * @param powerCableAttached this is to check to see if the cable is directly attached or not
     */
    public ModemRouter(final String brand, final String model, final double priceCdn, final boolean powerCableAttached, final int numEthernetPorts) {
        super(brand, model, priceCdn, powerCableAttached, getDataPorts(numEthernetPorts));
    }

    private static DataPort[] getDataPorts(final int numEthernetPorts){
        if (numEthernetPorts < 0 || numEthernetPorts > MAX_ETHERNET_PORTS){
            throw new IllegalArgumentException("Invalid amount of ethernet ports");
        }
        var ports = new DataPort[numEthernetPorts];
        for(int i = 0; i < numEthernetPorts; i++){
            ports[i] = new DataPort(DataPort.PortType.ETHERNET);
        }
        return ports;
    }

    public boolean hasInternet() {
        return internet && hasPower();
    }

    public void setInternet(boolean internet) {
        this.internet = internet;
    }
}
