package exercise;

import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection {
    private final String ip;
    private final int port;
    public String data;
    public Connection currentState;

    TcpConnection(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.currentState = new Disconnected(this);
    }

    public String getCurrentState() {
        return this.currentState.getCurrentState();
    }

    public void connect() {
        this.currentState.connect();
    }

    public void disconnect() {
        this.currentState.disconnect();

    }

    public void write(String data) {
        this.currentState.write(data);
    }
}
// END
