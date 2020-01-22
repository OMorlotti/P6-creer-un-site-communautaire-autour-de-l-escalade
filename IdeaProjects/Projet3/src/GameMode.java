import java.util.Scanner;
import java.util.Random;


abstract class Abstract {

     {
          Scanner sc = new Scanner(System.in);
          System.out.println("Veuillez choisir un mode : 1- Défenseur \n2- Challenger \n3- Duel");
          int str = sc.nextInt();


          int choice = sc.nextInt();

          switch (choice) {
               case 1:
                    System.out.println("Vous avez choisi le mode Défenseur /r/n Bon jeux !");
                    break;
               case 2:
                    System.out.println("Vous avez choisi le mode Challenger /r/n Bon jeux !");
                    break;
               case 3:
                    System.out.println("Vous avez choisi le mode Duel ! /r/n Bon jeux !");
                    break;
               default:
                    System.out.println("Vous devez choisir un mode entre les 3 proposés :-) /r/n Merci de ressaisir votre choix !");
                    break;
          }

          System.out.println("Veuillez choisir un mode : ");
     }

     public class RandomNbr {
          public void main(String[] args) {
               Random random1 = new Random();
               int nb1;
               nb = random1.nextInt(10);

               Random random2 = new Random();
               int nb2;
               nb = random2.nextInt(10);

               Random random3 = new Random();
               int nb3;
               nb = random3.nextInt(10);

               Random random4 = new Random();
               int nb4;
               nb = random4.nextInt(10);





                    System.out.println("Nombre aléatoire : " + nb);
               }
          }

     public class UserNbr {
          public void main (String[] args) {
          int nbuser1 = sc.nextInt();
/**
 * Comparaisons de chaque chiffre Utilisateur avec le chiffre de la combinaison
 */
               if ( nbuser1 > nb1 )
                    System.out.println("+");
               else
               if ( nbuser1 < nb1 )
                    System.out.println("-");
               else
                    System.out.println("=");

               int nbuser2 = sc.nextInt();



               if ( nbuser2 > nb2 )
                    System.out.println("+");
               else
               if ( nbuser2 < nb2)
                    System.out.println("-");
               else
                    System.out.println("=");


               if ( nbuser3 > nb3 )
                    System.out.println("+");
               else
               if ( nbuser3 < nb3)
                    System.out.println("-");
               else
                    System.out.println("=");



               if ( nbuser4 > nb4 )
                    System.out.println("+");
               else
               if ( nbuser4 < nb4)
                    System.out.println("-");
               else
                    System.out.println("=");
          }


     }

          System.out.println("XXXXXXXXXXXXX: ")


     }
}
