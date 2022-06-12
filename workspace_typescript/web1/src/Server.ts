import { createServer, IncomingMessage, ServerResponse } from "http";

export class TSServer {
    private port: number;

    constructor(port: number) {
        this.port = port;
    }

    startServer() {
        createServer((req: IncomingMessage, resp: ServerResponse) => {
            console.log(`Request from ${req.headers['user-agent']} for ${req.url}`);

            resp.write(`Hello from TS Web Server`);
            resp.end();
        }).listen(this.port);

        console.log(`TS Web Server started at ${this.port}`);
    }
}