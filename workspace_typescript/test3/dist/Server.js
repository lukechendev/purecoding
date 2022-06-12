"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
class BaseServer {
    constructor(address, port) {
        console.log("construct BaseServer");
        this.address = address;
        this.port = port;
    }
}
class DbServer extends BaseServer {
    constructor(address, port) {
        super(address, port);
        this.isActive = false;
        this.data = "";
        this.error = "";
        console.log("construct DbServer");
    }
    startServer() {
        console.log(`Started DB server at ${this.address}:${this.port}`);
        this.isActive = true;
    }
    stopServer() {
        console.log("Stopped DB server");
        this.isActive = false;
    }
    getData() {
        return __awaiter(this, void 0, void 0, function* () {
            yield this.syncDataFromServer();
            console.log(`Data from db server: ${this.data}`);
        });
    }
    syncDataFromServer() {
        return __awaiter(this, void 0, void 0, function* () {
            console.log("Syncing data from DB server");
            try {
                this.data = yield this.getDataAsync();
            }
            catch (e) {
                this.error = String(e);
                console.log(`Error from db server: ${this.error}`);
            }
        });
    }
    getDataAsync() {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                if (this.isActive) {
                    resolve("db at " + new Date().getTime());
                }
                else {
                    reject("500 server error");
                }
            }, 1000);
        });
    }
}
const dbServer = new DbServer("127.0.0.1", "80");
dbServer.startServer();
dbServer.getData();
dbServer.stopServer();
