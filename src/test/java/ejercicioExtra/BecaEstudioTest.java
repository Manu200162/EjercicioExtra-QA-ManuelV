package ejercicioExtra;

import ejercicio_extra.BecaEstudio;
import ejercicio_extra.Helpers;
import ejercicio_extra.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class BecaEstudioTest {

    Utils utilsMock= Mockito.mock(Utils.class);

    @BeforeAll
    public static void before(){
        MockedStatic<Helpers> helpersMock= Mockito.mockStatic(Helpers.class);
        helpersMock.when(()->Helpers.aplicaBeca(90)).thenReturn(false);
    }

    @Test
    public void verifygetNotaFalse(){
        MockedStatic<Helpers> helpersMock= Mockito.mockStatic(Helpers.class);
        helpersMock.when(()->Helpers.aplicaBeca(78)).thenReturn(false);
        BecaEstudio beca=new BecaEstudio();
        String expected="EL ESTUDIANTE NO CURSO AUN EL 60% DE LAS MATERIAS";
        String actual= beca.getResultBeca(78);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void verifyBeca(){
        Mockito.when(utilsMock.getNota(78)).thenReturn(92);
        BecaEstudio beca=new BecaEstudio();


    }
}
