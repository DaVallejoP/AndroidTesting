package liquidsquad.es.evilplans.domain.entity;

public class EvilVillain {
    public String name;
    public String lastName;

    public Weapon weapon;

    public SideKick sideKick;

    public EvilVillain(String name, String lastName,Weapon w,SideKick sideKick) {
        this.name = name;
        this.lastName = lastName;
        this.weapon = w;
    }

    public EvilVillain(String fullName, Weapon w) {
        this.name = fullName.split(" ")[0];
        this.lastName = fullName.split(" ")[1];
        this.weapon = w;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return name + " " + lastName;
    }

    public String attack(Henchman h, String country){
        weapon.fire();
        //this will fail
        //return h.getTargets("").get(0);
        return h.getTargets(country).get(0);
    }


}
