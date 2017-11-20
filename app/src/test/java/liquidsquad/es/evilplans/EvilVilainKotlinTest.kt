package liquidsquad.es.evilplans

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import liquidsquad.es.evilplans.domain.entity.*

import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.mockito.ArgumentCaptor
import org.mockito.Mockito


private val s = "ele 1 "

class EvilVilainKotlinTest {

    lateinit var sut: EvilVillainKotlin
    lateinit var weapon:FakeWeaponKotlin
    lateinit var henchmanKotlin:HenchmanSpyKotlin

    inner class FakeWeaponKotlin : WeaponKotlin(){
        var fired = false
        override fun fire() {
            //super.fire() //dont call super we want to avoid the real effect
            fired = true
        }
    }

    class HenchmanSpyKotlin : Henchman() {
        lateinit var targets: List<String>
        lateinit var country: String
        override fun getTargets(country: String): List<String> {
            this.country = country
            return targets
        }
        fun verify(){
            assertEquals(COUNTRY, country)
        }
    }

    @Before
    fun setUp() {
        weapon = FakeWeaponKotlin()
        sut = createMainEvilVillain(weapon)
        henchmanKotlin = HenchmanSpyKotlin()
        henchmanKotlin.targets = TARGET_LIST


    }

    @After
    fun tearDown() {
    }


    @Test
    fun getFullName_FirstNamePlusSpacePlusLastName() {
        //Arrange
        //SUT = system under test

        //Act
        val fullname = sut.fullName

        //Assert
        //poner siempre resultado final
        assertEquals(fullNameMock, fullname)
    }
    @Test
    fun initFromFullNameSplitIntoFirstNameAndLastName() {
        //Arrange

        //Act
        sut.fullName = fullNameMock

        //Assert
        assertEquals(nameMock, sut.name)
        assertEquals(lastNameMock, sut.lastName)
    }

    /**
     * Mi primer test de Comportamiento
     */
    @Test
    fun attacksFireWeapon() {
        //Arrange
        //Act
        sut.attack(henchmanKotlin, COUNTRY)
        //Assert
        assertTrue(weapon.fired)
    }

    //<editor-fold desc="Mi primer test Double">
    @Test
    fun attackReturnFirstTarget() {
        //Arrange

        //Act
        sut.attack(henchmanKotlin, COUNTRY)
        //Assert
        //assertEquals(COUNTRY, henchmanKotlin.country)
        henchmanKotlin.verify()
    }
    //</editor-fold>


    /**
     * Mi primer test Double con Mockito
     */
    @Test
    fun attackReturnFirstTargetMockito() {
        //Arrange
        val henchman = Mockito.mock(Henchman::class.java)
        whenever(henchman.getTargets(any())).thenReturn(TestData.TARGET_LIST)
        //Act
        sut.attack(henchman, TestData.COUNTRY)
        //Assert
        argumentCaptor<String>().apply {
            verify<Henchman>(henchman).getTargets(capture())
            assertEquals(TestData.COUNTRY, lastValue)
        }
    }


}