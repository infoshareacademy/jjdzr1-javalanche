package com.infoshareacademy;

public class HolidaysJsonData {
    private ServerInfo serverInfo;
    private ServerResponse serverResponse;

    public HolidaysJsonData(ServerInfo serverInfo, ServerResponse serverResponse) {
        this.serverInfo = serverInfo;
        this.serverResponse = serverResponse;
    }

    public void setServerInfo(ServerInfo serverInfo) {
        this.serverInfo = serverInfo;
    }

    public void setServerResponse(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    public ServerInfo getServerInfo() {
        return serverInfo;
    }

    public ServerResponse getServerResponse() {
        return serverResponse;
    }
}
