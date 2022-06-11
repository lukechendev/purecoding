interface IServer {
    startServer(): void;
    stopServer(): void;
}

abstract class BaseServer implements IServer {
    protected address: string;
    protected port: string;

    constructor(address: string, port: string) {
        console.log("construct BaseServer")
        this.address = address;
        this.port = port;
    }
    abstract startServer(): void;
    abstract stopServer(): void;
}

class DbServer extends BaseServer {
    constructor(address: string, port: string) {
        console.log("construct DbServer")
        super(address, port);
    }

    startServer(): void {
        console.log(`Started DB server at ${this.address}:${this.port}`);
    }

    stopServer(): void {
        console.log("Stopped DB server");
    }
}

const dbServer: IServer = new DbServer("127.0.0.1", "80");
dbServer.startServer();
dbServer.stopServer();
