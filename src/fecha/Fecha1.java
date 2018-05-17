/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

/**
 *
 * @author Usuario
 */
public class Fecha1 {
   public int dia;
   public int mes;
   public int annio;

    public Fecha1(int dia, int mes, int annio) {
        if(dia>0 && dia<=diaSegunMesYAnnio(mes, annio)){
            this.dia = dia;
        }
        if(mes>0 && mes<=12){
            this.mes = mes;
        }
        if(this.dia !=0 || this.mes !=0){
            this.annio = annio;
        }
    }
   
   public Fecha1 DiferenciaFechas(Fecha1 fechaInicial, Fecha1 fechaFinal){
       int diaResultado=0, mesResultado=0, annioResultado=0;
       int mesFinal = fechaFinal.mes;
       int annioFinal = fechaFinal.annio;
       if (fechaFinal.dia != 0 && fechaInicial.dia != 0 && 
	fechaFinal.mes != 0 && fechaInicial.mes !=0 && fechaInicial.annio <= fechaFinal.annio){
	
            if(fechaFinal.dia >= fechaInicial.dia){
                    diaResultado = fechaFinal.dia - fechaInicial.dia;
            }
            if(fechaInicial.dia < fechaInicial.dia){
                    mesFinal--;
                    diaResultado = (fechaFinal.dia + 30) - fechaInicial.dia ;	
            }
            if(fechaFinal.mes >= fechaInicial.mes){
                    mesResultado = fechaFinal.mes - fechaInicial.mes;
            }
            if(fechaFinal.mes < fechaInicial.mes){
                    annioFinal--;
                    mesResultado = (fechaFinal.mes + 12) - fechaInicial.mes;
            }
            annioResultado = fechaFinal.annio - fechaInicial.annio;
            
            Fecha1 fechaResultado = new Fecha1(diaResultado, mesResultado, annioResultado);
            return fechaResultado;
	}
       return null;             
   }
   
   public static int diaSegunMesYAnnio(int mes, int annio){
        if(mes==1 || mes ==3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
            return 31;
        }
        if(mes==4 || mes ==6 || mes == 9 || mes == 11){
            return 30;
        }
        if(mes == 2){
            if((annio%4)== 0){
                    return 29;
            }
            else{
                    return 28;
            }
        }
       return 0;		
	}
}
