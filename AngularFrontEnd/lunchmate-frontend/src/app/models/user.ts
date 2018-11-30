export class User{
    id : number = 22;
    firstname : String = "no name";
    lastname : String = "no name";
    username : String = "username@email.com";
    password : String = "password";
    phoneNumber : number = 1234567890;

    constructor(i : number, n : String, ln : String, u : String, p : String, pn : number)
    {
        this.id = i;
        this.firstname = n;
        this.lastname = ln;
        this.username = u;
        this.password = p;
        this.phoneNumber = pn;
    }
}