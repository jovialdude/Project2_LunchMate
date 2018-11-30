import { User } from "./user";

export class Posting{
    id : number = -1;
    name : String = "no name";
    meetUpTime : Date = new Date();
    description : string = "stuff";
    priceLimit : number = 50;
    preferences : string = "no gluten";
    user : User[];

    constructor(i : number, n : String, ln : Date, u : string, p : number, pn : string, ul : User[])
    {
        this.id = i;
        this.name = n;
        this.meetUpTime = ln;
        this.description = u;
        this.priceLimit = p;
        this.preferences = pn;
        this.user = ul;
    }
}