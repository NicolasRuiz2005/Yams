import java.util.Scanner;
import java.util.Random;


public class Yams {


public static int choixDeePreq (int relance, Scanner sc){
    if(relance < 1 || relance > 5){
        System.out.println("Veuillez entrer un nombre entre 1 et 5");
        relance = sc.nextInt();
    }
    return relance;
}

public static void relanceDee (int relance, int[] dee){
    dee[relance] = new Random().nextInt(6) + 1;
}

public static int choixNbRelance ( Scanner sc){
    System.out.println("Combien de dées voulez vous relancer ? (1-5)");
    int nbRelance = sc.nextInt();
    nbRelance = choixDeePreq(nbRelance, sc);
    return nbRelance;
}

public static void choixDee (int nbRelance, Scanner sc, int[] dee){

     System.out.println("Quel dé voulez vous relancer ? (1-5)");
            int relance = sc.nextInt();
            dee[relance] = new Random().nextInt(6) + 1;

    int cpt = 0;
    while(cpt < nbRelance -1){

        System.out.println("Quel dé voulez vous relancer ? (1-5)");
        int garde = relance;     // Prend la valeur de relance pour éviter de relancer le même dé
        relance = sc.nextInt();
        relance = choixDeePreq(relance, sc);

        if (relance == garde) {
            System.out.println("Vous avez déjà relancé ce dé");
            cpt --;
        } else {
            relanceDee(relance, dee);
            
        }
        
        cpt++;
    }

    
    
}



public static void main(String[] args) {

    int [] dee = new int[5];
    int nbRelanceCase = 0;

    
    for(int i : dee){
        dee[i] = new Random().nextInt(6) + 1; 
    }

    for(int i : dee){
        System.out.println("Dé " + (i+1) + " : " + dee[i]);
    }

    System.out.println("Où voulez vous placer votre score ? (1-6, bonus, brelan, carre, full, petite suite, grande suite, yams, Chance)");
    Scanner sc = new Scanner(System.in);
    String choix = sc.nextLine();
    switch () {
        case 1 :



            break;

        case 2 :
                
                break;

        case 3 :
                
                break;
        
        case 4 :
                    
                break;
        
        case 5 :
                            
                break;
        
        case 6 :
                                    
                break;
            
        case "bonus" :

                break;

        case "brelan" :

                break;

        case "carre" :

                break;

        case "full" :

                break;
        
        case "petite suite" :
            
                break;
        
        case "grande suite" :

                break;

        case "yams" :

                break;
        
        case "Chance" :

                break;
        
        case "Relancer" : 

            if (nbRelanceCase == 3){
                System.out.println("Vous avez déjà relancé 3 fois");
                break;
            }
            
            int nbRelance = choixNbRelance(sc);
            choixDee(nbRelance, sc, dee);

            System.out.println("Voici vos dés : ");
            for(int i : dee){
                System.out.println("Dé " + (i+1) + " : " + dee[i]);
            }
            
            nbRelanceCase ++;

            break;

        
        default:
            break;
    }
    

}

}