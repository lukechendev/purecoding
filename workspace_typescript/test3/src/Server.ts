import * as model from './model/DbData'

interface IServer {
    startServer(): void;
    stopServer(): void;
    getData(): void;
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
    abstract getData(): void;
}

class DbServer extends BaseServer {
    private isActive: boolean = false;
    private data: model.DbData;

    constructor(address: string, port: string) {
        super(address, port);
        console.log("construct DbServer")
        this.data = new model.DbData();
    }

    startServer(): void {
        console.log(`Started DB server at ${this.address}:${this.port}`);
        this.isActive = true;
    }

    async stopServer() {
        await new Promise(resolve =>
            setTimeout(() => {
                this.isActive = false; 
                console.log("Stopped DB server");
            }, 2000)
        );
    }

    async getData() {
        await this.syncDataFromServer();
        console.log(`Data from db server: ${this.data.value}`);
    }

    async syncDataFromServer() {
        console.log("Syncing data from DB server");

        try {
            this.data.value = await this.getDataAsync();
        } catch (e) {
            this.data.error = String(e);
            console.log(`Error from db server: ${this.data.error}`);
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
