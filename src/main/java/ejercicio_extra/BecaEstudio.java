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

            }else if(utils.getNota(ci)>=0){

            }else{

            }
        }else{

        }
        return result;
    }
}
