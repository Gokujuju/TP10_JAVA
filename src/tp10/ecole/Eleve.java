package tp10.ecole;

import com.github.javafaker.Faker;

public class Eleve {
    private String name;
    private final short classeChiff;
    private final char classeLettr;
    private final Bulletin bulletin;

    public Eleve(short c, char l){
        fakeName();
        this.classeChiff = c;
        this.classeLettr = l;
        this.bulletin = new Bulletin(c);
    }

    private void fakeName(){
        Faker faker = new Faker();
        this.name = faker.name().fullName();
    }

    public String getName() {
        return this.name;
    }
    public short getClasseChiff() {
        return this.classeChiff;
    }

    public char getClasseLettr() {
        return this.classeLettr;
    }

    public Bulletin getBulletin() {
        return this.bulletin;
    }
}
