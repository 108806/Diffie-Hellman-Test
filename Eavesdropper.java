public class Eavesdropper  {

    public final String name;
    public static DH_Globals.Publics Pubs;
    public Person A, B;

    public Eavesdropper(String name,DH_Globals.Publics Pubs) {
        this.name = name;
        Eavesdropper.Pubs = Pubs;
        A = new Person(this.name, Eavesdropper.Pubs);
        B = new Person(this.name, Eavesdropper.Pubs);
    }
    public Eavesdropper(DH_Globals.Publics Pubs) {
        this.name = "EVE";
        Eavesdropper.Pubs = Pubs;
        A = new Person(this.name + "1", Eavesdropper.Pubs);
        B = new Person(this.name + "2", Eavesdropper.Pubs);
    }

    public void calc_stage1()
    {
        this.A.calc_stage_1();
        this.B.calc_stage_1();
    }

    public void calc_stage2()
    {
        this.A.calc_stage_2();
        this.B.calc_stage_2();
    }

    public void exchange(Person Person1, Person Person2)
    {
        this.A.exchange(Person2);
        this.B.exchange(Person1);
    }
}
