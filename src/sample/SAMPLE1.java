/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import br.com.kantar.model.DomicilioCadastro;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SAMPLE1 {

    /**
     * @param args the command line arguments
     */
    


    public static void main(String[] args) throws Exception {

//        new SAMPLE1().teste(new File("c:/teste/20220505.txt"));

//               BufferedReader bf = new BufferedReader(new FileReader(new File("c:/teste/20220505.txt")));
//        
//        String linha = bf.readLine();
//        StringBuilder sb = new StringBuilder(); 
//        
//        
//        while(linha!=null){
//        
//        
//        if(linha.matches("\\d{5,6}.*")){
//        
//            sb.append("@"+linha+"\n");
//        
//        }
//        else{
//        
//        
//             sb.append(linha+"\n");
//        
//        }
//            
//            
//        
//        linha = bf.readLine();
//        }
//        
//        
    
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        String dom="";
//        String nse="";
//        String cable="";
//        String qtdTv="";
//        String qtdind="";
//        String idadeChefe="";
//        
//        String C4_11="";
//        String C12_17="";
//        String CaboOperador="";
//        
//        
//        
//        
//        
//        
//        
//        String[]vals = sb.toString().split("@");
//        
//   
//        
//        
//        
//        for(int u=1;u<vals.length;u++){
//            
//        boolean presencaCrianca=false;
//
//       ////______________________dm
//        String []lines= vals[u].split("\n");
//         
//        String []domfln = lines[0].split(",");
//        
//         dom = domfln[0];
//         nse = domfln[4];
//         cable = domfln[7];
//         qtdTv = domfln[33];
//         qtdind = domfln[32];
//         
//    
//         
//         if(domfln[13].equals("1")){
//         
//          C4_11 = "true";
//          presencaCrianca=true;
//          
//         }
//         else
//         {
//         
//         C4_11 = "false";
//         
//         
//         }
//         
//         if(domfln[13].equals("2")){
//         
//          C12_17="true";
//          presencaCrianca=true;
//          
//         }
//         else{
//             
//         C12_17="false";    
//         
//         }
//         
//         CaboOperador = domfln[31];
//
//         
//         ////______________________ind
//
//
//        
//        for(int i=1;i<lines.length;i++){
//        
//                String []domfsln = lines[i].split(",");
//                
//                
//
//               
//                
//                if(domfsln[36].equals("1")){
//                
//                 idadeChefe = domfsln[38];
//                 break;
//                
//                }     
//               
//               
//               
//         
//
////                System.out.println(Arrays.toString(domfsln));
//               
//
//        
//        }
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//     System.out.println(
//    dom+";"+nse+";"+cable+";"
//    +qtdTv+";"+qtdind+";"+idadeChefe+";"+presencaCrianca+";"+C4_11+";"+C12_17+";"+CaboOperador );   
//        
//            System.out.println("_______________");
//        
//        }
    }

}
