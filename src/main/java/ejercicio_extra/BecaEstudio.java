package ejercicio_extra;

import jdk.jshell.execution.Util;

public class BecaEstudio {
    Utils utils;

    public BecaEstudio(){
        utils = new Utils();
    }

    public BecaEstudio(Utils objMock){
        utils=objMock;
    }


    public String getResultBeca(int ci){
        String result ="";
        if(Helpers.aplicaBeca(ci)){
            int nota=utils.getNota(ci);
            if(nota>=90 && nota<=100){
                result="SI APLICA A BECA";
            }else if (nota >=0){
                result="NO APLICA A BECA POR PROMEDIO ACADEMICO";
            }
        }else{
            result="EL ESTUDIANTE NO CURSO AUN EL 60% DE LAS MATERIAS";
        }
        return result;
    }
}
