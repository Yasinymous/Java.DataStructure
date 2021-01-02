

import java.util.Scanner;

public class AVLTreeMain
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        AVLTree avlt = new AVLTree();

        String ch;

        do {
            System.out.println("\nAVL Tree islemleri\n");
            System.out.println("1. ekle ");
            System.out.println("2. sil");
            System.out.println("3. ata");

            String choice = scan.nextLine();
            switch (choice){
                case "ekle":
                    System.out.print("ekle islemi uygulanacak kelime : ");
                    avlt.ekle(scan.nextLine());
                    break;
                case "sil" :
                    System.out.print("sil islemi uygulanacak kelime : ");
                    avlt.sil(scan.nextLine());
                    break;
                case "ata" :
                    System.out.print("ata islemi uygulanacak kelime : ");
                    avlt.ata(scan.nextLine());
                    break;
                default :
                    System.out.println("Yanlis Girdi \n ");
                    break;
            }
/*  TESTT
           System.out.print("\nTEST Post order : ");
            avlt.postorder();
            System.out.print("\nTEST Pre order : ");
            avlt.preorder();
            System.out.print("\nTEST In order : ");
            avlt.inorder();
*/
            System.out.println("\ndevam etmek icin (y/n) \n");
            ch = scan.nextLine();
        } while (ch.equals("y")|| ch.equals("Y"));
    }
}