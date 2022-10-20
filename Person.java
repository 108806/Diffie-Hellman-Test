import java.math.BigInteger;

public class Person{
    public String name;
    private int secret_number;
    private BigInteger internal_secret_result;
    private BigInteger internal_secret_result_mod;
    public BigInteger external_secret_result_mod;
    public BigInteger final_result;
    public static DH_Globals.Publics Pubs;

    public Person(String name, DH_Globals.Publics Pubs) {
        this.name = name;
        this.secret_number = DH_Globals.getRandomPrime();
        Person.Pubs = Pubs;
    }
    public Person(DH_Globals.Publics Pubs) {
        this.name = "Anonymous";
        this.secret_number = DH_Globals.getRandomPrime();
        Person.Pubs = Pubs;
    }

    public void calc_stage_1()
    {
        this.internal_secret_result =
                       Person.Pubs.VAL_N.pow(this.secret_number);

        this.internal_secret_result_mod =
                this.internal_secret_result.mod(Person.Pubs.VAL_G);
    }

    public void exchange(Person Person1)
    {
        Person1.external_secret_result_mod = this.internal_secret_result_mod;
        this.external_secret_result_mod = Person1.internal_secret_result_mod;
    }

    public void calc_stage_2(){
        this.final_result =
                this.external_secret_result_mod.pow(this.secret_number)
                        .mod(Person.Pubs.VAL_G);
    }

    public int get_secret_num()
    {
        return this.secret_number;
    }

    public BigInteger get_internal_secret()
    {
        return this.internal_secret_result;
    }

    public BigInteger get_internal_secret_res_mod()
    {
        return this.internal_secret_result_mod;
    }

    public void tell_all()
    {
        System.out.println(
                this.final_result + ":" +
                this.external_secret_result_mod + ":" +
                this.get_secret_num() + ":" +
                this.internal_secret_result + ":" +
                this.internal_secret_result_mod + ":" +
                this.name);
    }


}

