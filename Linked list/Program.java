/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author ysnak
 */
public class Program {
    
    
        public void calis() {
   
          List mainlist = new List();
          List sidelist = new List();
          Scanner scanner = new Scanner(System.in);

          System.out.println("undo/redo/yaz/kapat(0)");    
        int sayac = 5;
          OUTER:
          while (true) {  
            String girdi = scanner.nextLine();
            if (sayac==0 && "redo".equals(girdi)){
                System.out.println("daha fazla ileri alınmaz");
            }
            
            else{
            switch (girdi) {

                case "0":                    
                    break OUTER;
                case "undo":
                    
                   mainlist.Undo(mainlist, sidelist);

                    break;
                case "redo": {
                    mainlist.Redo(mainlist, sidelist);
                    --sayac;
                    break;
                }
                case "yaz": {
                    mainlist.mainlist_print(mainlist);
                    break;
                }
               /* case "yaz1": {
                    sidelist.sidelist_print(sidelist);
                    break;
                }  */
                default:
                    mainlist.main_listadd(mainlist, girdi);
                    sidelist.sidelist_delete(sidelist);
                    sayac = 5;
                    break;
            }
        }}
          
    
	}
    
}
