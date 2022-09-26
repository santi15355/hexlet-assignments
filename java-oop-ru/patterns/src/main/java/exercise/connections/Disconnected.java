package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection {
    private TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        System.out.println("connecting...");
        this.tcpConnection.currentState = new Connected(this.tcpConnection);

    }

    @Override
    public void disconnect() {
        System.out.println("Error! Already disconnected");
    }

    @Override
    public void write(String data) {
        System.out.println("Error! No connection!");
    }
}
// END
