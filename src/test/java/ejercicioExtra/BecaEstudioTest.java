package ejercicioExtra;

import ejercicio_extra.Helpers;
import ejercicio_extra.Utils;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class BecaEstudioTest {

    Utils utilsMock= Mockito.mock(Utils.class);

    @Test
    public void verifyBeca(){
        MockedStatic<Helpers> helpersMock= Mockito.mockStatic(Helpers.class);
        Mockito.when(utilsMock.getNota(78)).thenReturn(92);

    }
}
