package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {

    private TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public void connect() {
        System.out.println("Error! Already connected");
    }

    @Override
    public void disconnect() {
        System.out.println("disconnecting...");
        this.tcpConnection.currentState = new Disconnected(this.tcpConnection);

    }

    @Override
    public void write(String data) {
        this.tcpConnection.data = data;

    }
}
// END
