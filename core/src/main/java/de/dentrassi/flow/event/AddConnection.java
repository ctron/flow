package de.dentrassi.flow.event;

import de.dentrassi.flow.Port;

public abstract class AddConnection {

    private final ConnectionType connectionType;
    private final String id;
    private final Port out;
    private final Port in;

    AddConnection(final ConnectionType connectionType, final String id, final Port out, final Port in) {
        this.connectionType = connectionType;
        this.id = id;
        this.out = out;
        this.in = in;
    }

    public String getId() {
        return this.id;
    }

    public Port getOut() {
        return this.out;
    }

    public Port getIn() {
        return this.in;
    }

    public ConnectionType getConnectionType() {
        return this.connectionType;
    }

    @Override
    public String toString() {
        return new StringBuilder("[ADD_CONNECTION - ")
                .append("ID: ").append(this.id).append(", ")
                .append("Type: ").append(this.connectionType).append(", ")
                .append("Out: ").append(this.out).append(", ")
                .append("In: ").append(this.in)
                .append("]")
                .toString();
    }

}