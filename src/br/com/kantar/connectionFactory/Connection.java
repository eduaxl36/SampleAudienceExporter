/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.kantar.connectionFactory;

import java.sql.DriverManager;





/**
 *
 * @author Eduardo.Fernando
 */
public class Connection {
 
 private java.sql.Connection Connection;
    
 private java.sql.Connection getConnection() throws Exception{
     
 Class.forName("org.postgresql.Driver");
 String url ="jdbc:postgresql://10.2.0.40:5475/DeliveryLatam";
 String usuario="postgres";
 String senha = "kimpad";
 
 return Connection = (java.sql.Connection) DriverManager.getConnection(url, usuario, senha);
 
 
 }    
    
    
}
