package liquidsquad.es.evilplans.domain.entity

import liquidsquad.es.evilplans.lastNameMock
import liquidsquad.es.evilplans.nameMock

fun EvilVillainKotlin.createMainEvilVillain(weapon:WeaponKotlin ): EvilVillainKotlin
        = EvilVillainKotlin(nameMock,lastNameMock,weapon,SideKickKotlin())
fun createMainEvilVillain(weapon:WeaponKotlin ): EvilVillainKotlin
        = EvilVillainKotlin(nameMock,lastNameMock,weapon,SideKickKotlin())


