// INICIO IMPORTS
import java.net.Socket;
import java.io.*;
import java.util.*;
// FIN IMPORTS
class PrimerEjercicio {
    public static void main(String[] args) {
      // INICIO DECLARACION DE VARIABLES
      ArrayList<String> hostPuerto = new ArrayList<String>();
      File file = null;
      FileReader fr = null;
      BufferedReader br = null;
      int port = 0;
      String host = "";
      String linea = "";
      // FIN DECLARACION DE VARIABLES
      try {
         file = new File ("C:/Users/eerii/Desktop/PrimerEjercicio/HostPuerto.txt");
         fr = new FileReader (file);
         br = new BufferedReader(fr);
      // MIENTRAS HAYA ALGO EN EL DOCUMENTO SEGUIRA CONSULTANDO
         while((linea=br.readLine())!=null){       
      // GUARDAMOS LOS DATOS EN UN ARRAYLIST Y SEPARAMOS USANDO SPLIT()              
         String data[] = linea.split(":");          
            for (String a: data){            
            hostPuerto.add(a);            
            }            
         }            
          for (int i = 0; i < hostPuerto.size()-2; i++){    
      // DISMINUIMOS 2 PORQUE EL ARRAYLIST AÑADIO 2 ESPACIOS VACIOS      
            if((i % 2 == 1)){
      // IMPARES
            port = Integer.parseInt(hostPuerto.get(i)); // PARSEAMOS PARA PASAR EL PUERTO COMO ENTERO EN EL SOCKET                  
            }else{
      // PARES
              host = hostPuerto.get(i);
            }
              try{
                  Socket socket = new Socket(host, port);
                     if(socket.isConnected()){
                       System.out.println("Server " +  host + 
                       " Puerto " + port + " -> OK");
                      }
                }
                catch(Exception e){
                        System.out.println("Server " +  host + 
                        " Puerto " + port + " -> PROBLEM");
                }
          }    
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
      // CERRAMOS EL FILE
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
	}   
}
