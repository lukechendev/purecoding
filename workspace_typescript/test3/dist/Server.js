"use strict";
class BaseServer {
    constructor(address, port) {
        console.log("construct BaseServer");
        this.address = address;
        this.port = port;
    }
}
class DbServer extends BaseServer {
    constructor(address, port) {
        console.log("construct DbServer");
        super(address, port);
    }
    startServer() {
        console.log(`Started DB server at ${this.address}:${this.port}`);
    }
    stopServer() {
        console.log("Stopped DB server");
    }
}
const dbServer = new DbServer("127.0.0.1", "80");
dbServer.startServer();
dbServer.stopServer();
