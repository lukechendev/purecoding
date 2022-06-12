interface IServer {
    startServer(): void;
    stopServer(): void;
    getData(): any;
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
    abstract getData(): any;
}

class DbServer extends BaseServer {
    private isActive: boolean = false;
    private data: string = "";
    private error: string = "";

    constructor(address: string, port: string) {
        super(address, port);
        console.log("construct DbServer")
    }

    startServer(): void {
        console.log(`Started DB server at ${this.address}:${this.port}`);
        this.isActive = true;
    }

    stopServer(): void {
        console.log("Stopped DB server");
        this.isActive = false;
    }

    async getData() {
        await this.syncDataFromServer();
        console.log(`Data from db server: ${this.data}`);
    }

    async syncDataFromServer() {
        console.log("Syncing data from DB server");

        try {
            this.data = await this.getDataAsync();
        } catch (e) {
            this.error = String(e);
            console.log(`Error from db server: ${this.error}`);
        }
    }

    private getDataAsync(): Promise<string> {
        return new Promise<string>((resolve, reject) => {
            setTimeout(() => {
                if (this.isActive) {
                    resolve("db at " + new Date().getTime());
                } else {
                    reject("500 server error");
                }
            }, 1000);
        });
    }
}

const dbServer: IServer = new DbServer("127.0.0.1", "80");
dbServer.startServer();
dbServer.getData();
dbServer.stopServer();
