import { TSServer } from "./Server";

class Launcher {
    private server: TSServer;

    constructor() {
        this.server = new TSServer(8080);
    }

    launchApp() {
        this.server.startServer();
    }
}

new Launcher().launchApp();