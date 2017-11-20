package liquidsquad.es.evilplans.domain.entity

 class EvilVillainKotlin(var name:String, var lastName:String, var weapon: WeaponKotlin){

    constructor(name:String,lastName:String, weapon: WeaponKotlin, sideKickKotlin: SideKickKotlin) : this(name,lastName,weapon)

    var fullName :String
        get() = "$name $lastName"
        set(value) {
            this.name = value.split(" ")?.let { it[0] }
            this.lastName = value.split(" ").let { it[1] }
        }


     fun attack(h: Henchman, country: String): String {
         weapon.fire()
         //this will fail
         //return h.getTargets("")[0]
         return h.getTargets(country)[0]
     }

 }

