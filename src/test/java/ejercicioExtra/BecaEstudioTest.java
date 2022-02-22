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
        helpersMock.when(()->Helpers.aplicaBeca(78)).thenReturn(false);
        helpersMock.when(()->Helpers.aplicaBeca(48)).thenReturn(true);
        helpersMock.when(()->Helpers.aplicaBeca(28)).thenReturn(true);
        helpersMock.when(()->Helpers.aplicaBeca(128)).thenReturn(true);
    }

    @Test
    public void verifygetNotaFalse(){
        BecaEstudio beca=new BecaEstudio();
        String expected="EL ESTUDIANTE NO CURSO AUN EL 60% DE LAS MATERIAS";
        String actual= beca.getResultBeca(78);
        Assertions.assertEquals(expected,actual);
    }

    @Test
    public void verifyBecaMayor90(){
        Mockito.when(utilsMock.getNota(48)).thenReturn(92);
        BecaEstudio beca=new BecaEstudio(utilsMock);
        String expected="SI APLICA A BECA";
        String actual= beca.getResultBeca(48);
        Assertions.assertEquals(expected,actual,"Error bad message");
        Mockito.verify(utilsMock).getNota(48);
    }

    @Test
    public void verifyBecaMenor90(){
        Mockito.when(utilsMock.getNota(28)).thenReturn(80);
        BecaEstudio beca=new BecaEstudio(utilsMock);
        String expected="NO APLICA A BECA POR PROMEDIO ACADEMICO";
        String actual= beca.getResultBeca(28);
        Assertions.assertEquals(expected,actual,"Error bad message");
        Mockito.verify(utilsMock).getNota(28);
    }
    @Test
    public void verifyBecaNotaAplazo(){
        Mockito.when(utilsMock.getNota(128)).thenReturn(40);
        BecaEstudio beca=new BecaEstudio(utilsMock);
        String expected="NO APLICA A BECA POR PROMEDIO ACADEMICO";
        String actual= beca.getResultBeca(128);
        Assertions.assertEquals(expected,actual,"Error bad message");
        Mockito.verify(utilsMock).getNota(128);
    }


}
