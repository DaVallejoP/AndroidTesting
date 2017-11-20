package liquidsquad.es.evilplans;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import liquidsquad.es.evilplans.domain.entity.EvilVillain;
import liquidsquad.es.evilplans.domain.entity.Henchman;
import liquidsquad.es.evilplans.domain.entity.SideKickDummy;
import liquidsquad.es.evilplans.domain.entity.Weapon;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EvilVillainTest {


    private EvilVillain sut;
    private FakeWeapon weapon;
    private HenchmanSpy henchman;

    private static class FakeWeapon extends Weapon {


        public boolean fired = false;

        @Override
        public void fire() {
            //super.fire();
            fired = true;
        }
    }
    private static class HenchmanSpy extends Henchman {
        public  List<String> targets ;
        public  String country;
        @Override
        public List<String> getTargets(String country) {
            this.country = country;
            return targets;
        }
        public void verify(){
            assertEquals(TestData.COUNTRY,country);

        }
    }

    @Before
    public void setUp() throws Exception {
        henchman = new HenchmanSpy();
        henchman.targets = TestData.TARGET_LIST;
        weapon = new FakeWeapon();
        sut = new EvilVillain(TestData.nameMock, TestData.lastNameMock,weapon,new SideKickDummy());

    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Mi primer test de retorno
     */
    @Test
    public void getFullName_FirstNamePlusSpacePlusLastName() throws Exception {
        //Arrange
        //SUT = system under test

        //Act
        String fullname = sut.getFullName();

        //Assert
        //poner siempre resultado final
        assertEquals(TestData.fullNameMock,fullname);
    }

    /**
     * Mi primer test de estado
     */
    @Test
    public void InitFromFullNameSplitIntoFirstNameAndLastName() throws Exception {
        //Arrange
        sut = new EvilVillain(TestData.fullNameMock,weapon);
        //Act
        //Assert
        assertEquals(TestData.nameMock,sut.getName());
        assertEquals(TestData.lastNameMock,sut.getLastName());

    }

    /**
     * Mi primer test de Comportamiento
     */
    @Test
    public void AttacksFireWeapon() throws Exception {
        //Arrange
        //FakeWeapon weapon = new FakeWeapon();
        //EvilVillain sut = new EvilVillain("Darth Vader",weapon);
        //Act
        sut.attack(henchman, TestData.COUNTRY);
        //Assert
        assertTrue(weapon.fired);
    }


    //<editor-fold desc="Mi primer test Double con Mockito">
    /**
     * Mi primer test Double
     */
    @Test
    public void attackReturnFirstTarget() {
        //Arrange
        //Act
        sut.attack(henchman, TestData.COUNTRY);
        //Assert
        henchman.verify();
    }
    //</editor-fold>

    //<editor-fold desc="Mi primer test Double con Mockito">
    /**
     * Mi primer test Double con Mockito
     */
    @Test
    public void attackReturnFirstTargetMockito() {
        //Arrange
        Henchman henchman = Mockito.mock(Henchman.class);
        when(henchman.getTargets(any(String.class))).thenReturn(TestData.TARGET_LIST);
        //when(henchman.getTargets(anyString())).thenReturn(TestData.TARGET_LIST)
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        //Act
        sut.attack(henchman, TestData.COUNTRY);
        //Assert
        verify(henchman).getTargets(captor.capture());
        assertEquals(TestData.COUNTRY,captor.getValue());
    }
    //</editor-fold>

}