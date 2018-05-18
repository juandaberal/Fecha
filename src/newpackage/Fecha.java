/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import fecha.*;

/**
 *
 * @author Usuario
 */
public class Fecha {

   public int dia=-1;
   public int mes=-1;
   public int annio;

    public Fecha(int dia, int mes, int annio) {
        if(dia>=0 && dia<=diaSegunMesYAnnio(mes, annio)){
            this.dia = dia;
        }
        if(mes>=0 && mes<=12 && this.dia != -1){
            this.mes = mes;
        }
        if(this.dia !=0 && this.mes !=-1){
            this.annio = annio;
        }
    }
    
    public static int diaSegunMesYAnnio(int mes, int annio){
        if(mes==0 || mes==1 || mes ==3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
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
   
    public Fecha DiferenciaConLaFecha(Fecha fecha){
       int diaResultado=0, mesResultado=0, annioResultado=0;
       int mesFinal = fecha.mes;
       int annioFinal = fecha.annio;
       
       if (fecha.dia != -1 && this.dia != -1 && fecha.mes != 0 && this.mes !=0){
            if(this.annio <= fecha.annio){
                
                if(fecha.dia >= this.dia){
                        diaResultado = fecha.dia - this.dia;
                }
                if(fecha.dia < this.dia){
                        mesFinal--;
                        diaResultado = (fecha.dia + diaSegunMesYAnnio(this.mes, this.annio)) - this.dia ;	
                }
                if(mesFinal >= this.mes){
                        mesResultado = mesFinal - this.mes;
                }
                if(mesFinal < this.mes){
                        annioFinal--;
                        mesResultado = (mesFinal + 12) - this.mes;
                }
                annioResultado = annioFinal - this.annio;
            }
            
            //Diferencia de fechas negativas con valor absoluto
            else{
               if(this.dia >= fecha.dia){
                        diaResultado = this.dia - fecha.dia;
                }
                if(this.dia < fecha.dia){
                        mesFinal--;
                        diaResultado = this.dia - (fecha.dia + diaSegunMesYAnnio(this.mes, this.annio));	
                }
                if(this.mes >= mesFinal){
                        mesResultado = this.mes - mesFinal;
                }
                if(this.mes < mesFinal){
                        annioFinal--;
                        mesResultado = this.mes - (mesFinal + 12);
                }
                annioResultado = this.annio - annioFinal; 
            }
            Fecha fechaResultado = new Fecha(diaResultado, mesResultado, annioResultado);
            return fechaResultado;
	}
       return null;             
   }
   
   
    
    public void imprimirFormatoEstandarFecha(){
        if(this.dia>0 && this.mes>0){
            if(this.dia <10){
                System.out.print("0");
            }
            System.out.print(this.dia + "/");
            if(this.mes<10){
                System.out.print("0");
            }
            System.out.print(this.mes + "/");
            if(this.annio>=0){
                if(this.annio<1000){
                System.out.print("0");
                if(this.annio<100){
                    System.out.print("0");
                    if(this.annio<10){
                        System.out.print("0");
                    }
                }
                }
                System.out.print(this.annio);
            }else{
                
                if(this.annio<1000){
                System.out.print("0");
                if(this.annio<100){
                    System.out.print("0");
                    if(this.annio<10){
                        System.out.print("0");
                    }
                }
                }
                System.out.print(this.annio*-1 + " a.C");
            }
        }
        else System.out.print("ERROR");
    }
    
    public static void main(String[] args) {
        
        Fecha fecha1 = new Fecha(16, 3, 1999);
        Fecha fecha2 = new Fecha(18, 05, 2018);
        
        System.out.print("la fecha 1 es ");
        fecha1.imprimirFormatoEstandarFecha();
        System.out.print("\nla fecha 2 es ");
        fecha2.imprimirFormatoEstandarFecha();
        
        System.out.println("\nLa diferencia de edad entre la fecha 1 y 2 es es de: ");
        
        if(fecha1.DiferenciaConLaFecha(fecha1)!= null){
            System.out.println(fecha1.DiferenciaConLaFecha(fecha2).dia + " dias");
            System.out.println(fecha1.DiferenciaConLaFecha(fecha2).mes + " meses");
            System.out.println(fecha1.DiferenciaConLaFecha(fecha2).annio + " annios");
            System.out.println("que en formato estandar se expresa: ");
            fecha1.DiferenciaConLaFecha(fecha2).imprimirFormatoEstandarFecha();
            
        }
        else{
            System.out.println("error con las fechas");
        }
        System.out.println("\nLa diferencia de edad entre la fecha 2 y 1 es de:");
        if(fecha2.DiferenciaConLaFecha(fecha1)!= null){
            System.out.println(fecha2.DiferenciaConLaFecha(fecha1).dia + " dias");
            System.out.println(fecha2.DiferenciaConLaFecha(fecha1).mes + " meses");
            System.out.println(fecha2.DiferenciaConLaFecha(fecha1).annio + " annios");
            System.out.println("que en formato estandar se expresa: ");
            fecha2.DiferenciaConLaFecha(fecha1).imprimirFormatoEstandarFecha();
            
        }
        else{
            System.out.println("error con las fechas");
        }    
        System.out.println("");
    }
    
}
