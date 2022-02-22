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
            if(utils.getNota(ci)>=90 && utils.getNota(ci)<=100){
                result="SI APLICA A BECA";
            }else if(utils.getNota(ci)>=0){
                result="NO APLICA A BECA POR PROMEDIO ACADEMICO";
            }
        }else{
            result="EL ESTUDIANTE NO CURSO AUN EL 60% DE LAS MATERIAS";
        }
        return result;
    }
}
