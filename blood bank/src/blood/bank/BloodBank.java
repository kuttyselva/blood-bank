/*
 Blood group management using java and sql
 created by kuttyselva
 */
package blood.bank;
import java.lang.*;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author KUTTY SELVA
 */
public class BloodBank {

   
    public static void main(String[] args) {
       Connection c=null;
       int ch,v=5;
        Scanner in = new Scanner(System.in);
    try{
    Class.forName("org.sqlite.JDBC");
    c=DriverManager.getConnection("jdbc:sqlite:blood.db");
    
    }catch(Exception e)
    {
      System.err.println(e.getClass().getName() + ":"+e.getMessage()); 
      System.exit(0);
    }
    System.out.println ("opened successfully");
    creatingtable crtabl=new creatingtable();
    insertion ins=new insertion();
    project pro=new project();
    searchname sn=new searchname();
    searchgrp sg=new searchgrp();
    cntamt cm=new cntamt();
   
    crtabl.main();
    do{
        System.out.println("\t\t\n\n\n\t\t\t\t\t\tBLOOD BANK MANAGEMENT");
        System.out.println("\t\t\n\t\t\t\t\t\t\tCHOOSE ANY OF THE MENU");
        System.out.println("\t\t\n\t\t\t\t\t\t\t1. INSERTING DONOR DETAILS");
        System.out.println("\t\t\n\t\t\t\t\t\t\t2. DISPLAY ALL DONAR DETAILS");
        System.out.println("\t\t\n\t\t\t\t\t\t\t3. SEARCH DONOR BY NAME");
        System.out.println("\t\t\n\t\t\t\t\t\t\t4.SEARCH DONOR BY BLOOD GROUP");
        System.out.println("\t\t\n\t\t\t\t\t\t\t5.DISPLAY THE STORAGE LEVEL OF THE BLOOD BANK");
        ch=in.nextInt();
        switch(ch)
        {
            case 1:
            {
                ins.main();
                break;
            }
            case 2:
            {
                pro.main();
                break;
            }
            case 3:
            {
                sn.main();
                break;
            }
            case 4:
            {
                sg.main();
                break;
            }
            case 5:
            {
                cm.main();
                break;
            }
        }
    }while(v>0);
       
   
  
   
    }
    
    
}
