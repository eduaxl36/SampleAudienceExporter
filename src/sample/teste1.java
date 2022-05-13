/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Eduardo.Fernando
 */
public class teste1 {
    
    
    public static void main(String[] args) throws Exception {
        
        
      

        String contents = FileUtils.readFileToString(new File("c:/teste/teste.MET"), "UTF-8");
        
        
        String metfile[] =  contents.replaceAll("\t", "\n").replaceAll("I", "F I").split("F ");
        
       
        for(String dom:metfile){
         
        Matcher mind = Pattern.compile("Z.*\r\nD.*\r\nW.*").matcher(dom);
        StringBuilder c = new StringBuilder();
        
        while(mind.find()){
        

        c.append(mind.group()+"\n"+"_\n");
            
        }
        
//        
//       String [] loopdons = c.toString().split(("_"));
//        
//       for(String xd:loopdons){
//       
//    
//           if(!xd.contains("0.00")){
//           
//          String domIndi="";
//          String IndiNum="";
//          String PesoIndi="";
//          String DemoIndi="";
//          
//               
//               
//               
//           Matcher miintenaldom = Pattern.compile("Z.*").matcher(xd);
//           if(miintenaldom.find())
//           {
//               
//           domIndi =   miintenaldom.group().substring(1,9);
//           IndiNum =   miintenaldom.group().substring(miintenaldom.group().length()-3,miintenaldom.group().length());
//           System.out.println(domIndi);
//           System.out.println(IndiNum);
//           
//           }
//               
//
//           Matcher indpeso = Pattern.compile("W.*").matcher(xd);
//           if(indpeso.find())    
//               
//                   System.out.println(indpeso.group().replaceAll("W", "").replaceAll("\\.", ","));
//           
//
//
//           Matcher inddemo = Pattern.compile("D.*").matcher(xd);
//           if(inddemo.find())    
//               
//                   System.out.println(inddemo.group());
//
//
//           }
//           
//       
//           
//   
//  
//       }
//      
// 
//        
//        
//        
//        
//        
//        
//        
//        }
        
        
        
       





      
         Matcher mdom = Pattern.compile("I\\d{1,}.*\r\n.*\r\n.*").matcher(dom);
        
        if(mdom.find()){
        
            String domCa = mdom.group().substring(1,9);
             String peso ="";
             String demo ="";
            
           Matcher mpeso =  Pattern.compile("W\\d{1,}\\.\\d{1,}").matcher(mdom.toString());
           
           if(mpeso.find()){
               
                peso = mpeso.group();
             
               
           }
           
              Matcher mdemo =  Pattern.compile("D.*").matcher(mdom.toString());
           
           if(mdemo.find()){
               
                demo =mdemo.group().replaceAll("D,", "").replaceAll("\\,", ";") ;
        
             
               
           }       
           
           
           
        
            System.out.println(domCa+";"+peso.replaceAll("W", "").replaceAll("\\.", ",")+";"+demo);
        }
        
        
//        
//        
        
       
            
            
        
        
        }
    
    
    
    }
               
        
        
     
        
        
        
      
        
       
           
    }
    
    

