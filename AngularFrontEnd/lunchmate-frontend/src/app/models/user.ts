export class User{
    id : number = -1;
    name : String = "no name";
    username : String = "username";
    password : String = "password";
    phoneNumber : String = "123-456-7890";
    email : String = "dummy@email.com";

    constructor(i : number, n : String, u : String, p : String, pn : String, e : String)
    {
        this.id = i;
        this.name = n;
        this.username = u;
        this.password = p;
        this.phoneNumber = pn;
        this.email = e;
    }
}