public class Main {
    public static void main(String[] args) {
        //Correct procedure:
        DH_Globals.Publics Pubs = new DH_Globals.Publics();
        Person Person1 = new Person("Alice", Pubs);
        Person Person2 = new Person("Bob", Pubs);
        Person1.calc_stage_1();
        Person2.calc_stage_1();
        Person1.exchange(Person2);
        Person1.calc_stage_2();
        Person2.calc_stage_2();
        System.out.println("Correct procedure TEST : \nP1:" + Person1.final_result
                + " VS " + "P2:" + Person2.final_result);
        assert(Person1.final_result == Person2.final_result);

        //MITM Attack:
        DH_Globals.Publics Pubs2 = new DH_Globals.Publics();
        Person PersonA = new Person("Victim_Alice", Pubs2);
        Person PersonB = new Person("Victim_Bob", Pubs2);
        Eavesdropper EVE = new Eavesdropper(Pubs2);
        PersonA.calc_stage_1();
        PersonB.calc_stage_1();
        EVE.calc_stage1();

        EVE.exchange(PersonA, PersonB);

        PersonA.calc_stage_2();
        PersonB.calc_stage_2();
        EVE.calc_stage2();

        PersonA.tell_all();
        EVE.B.tell_all();
        PersonB.tell_all();
        EVE.A.tell_all();
    }
}
