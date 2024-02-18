import java.util.Scanner;
import java.util.Random;


public class Yams {

/* Permet de tester si le choix du joueur est valide ou non
 * 
 * @param relance : le choix du dé que le joueur souhaite relancer
 * @param sc : le scanner pour récupérer le choix du joueur
 */
public static int choixDeePreq (int relance, Scanner sc){
    if(relance < 1 || relance > 5){
        System.out.println("Veuillez entrer un nombre entre 1 et 5");
        relance = sc.nextInt();
    }
    return relance;
}

public static void relanceDee (int relance, int[] dee){
    dee[relance -1] = new Random().nextInt(6) + 1;
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

public static void lanceDee (int[] dee){
    for(int i = 0; i<dee.length ; i++){
        dee[i] = new Random().nextInt(6) + 1; 
    }
}

public static void afficherDee (int[] dee){
    System.out.println("Voici vos dés : ");
    System.out.println("=============================");
    for(int i = 0; i<5 ; i++){
        System.out.print("Dé " + (i+1) + " : " + dee[i]+ "  |  ");
    }
    System.out.println();
    System.out.println("=============================");
}

public static void initialiserTabScore (int[] tabScore){
    for(int i =0; i < tabScore.length ; i++){
        tabScore[i] = -1;
    }
}

public static void afficherScrore (int[] tabScore, int bonus){
    System.out.println("Voici votre score : ");
    System.out.println("=============================");
    for(int i =0; i<6 ; i++){
        System.out.println((i+1) + " : " + tabScore[i]);
    }
    System.out.println("Bonus : " + bonus);
    System.out.println("Brelan : " + tabScore[6]);
    System.out.println("Carre : " + tabScore[7]);
    System.out.println("Full : " + tabScore[8]);
    System.out.println("Petite suite : " + tabScore[9]);
    System.out.println("Grande suite : " + tabScore[10]);
    System.out.println("Yams : " + tabScore[11]);
    System.out.println("Chance : " + tabScore[12]);
    System.out.println("=============================");
}

public static int cas1A6 (int[] dee, int cas){
    int score = 0;
    for(int i =0; i < dee.length ; i++){
        if(dee[i] == cas){
            score += cas;
        }
    }
    return score;
}

public static int casBrelan (int[] dee){
    int score = 0;
    int indiceGarde = 0;
    int garde = dee[indiceGarde];
    int verif = 0;

    for(int i =0; i < dee.length ; i++){
        verif = 0;
        for(int j =0; j < dee.length ; j++){
            if(garde == dee[j]){
                verif ++;
            }
        }

        if(verif == 3){
            for(int k =0; k < dee.length ; k++){
                if(dee[k] == garde){
                    score += dee[k];
                }
            }
            return score;
            
        }

        garde = dee[i];
    }

    return score;
}

public static int casCarre (int [] dee){
    int score = 0;
    int indiceGarde = 0;
    int garde = dee[indiceGarde];
    int verif = 0;

    for(int i =0; i < dee.length ; i++){
        verif = 0;
        for(int j =0; j < dee.length ; j++){
            if(garde == dee[j]){
                verif ++;
            }
        }

        if(verif == 4){
            for(int k =0; k < dee.length ; k++){
                if(dee[k] == garde){
                    score += dee[k];
                }
            }
            return score;
            
        }

        garde = dee[i];
    }

    return score;
}

public static int verifPair (int [] dee, int triplet){
    int score = 0;
    int indiceGarde = 0;
    int garde = dee[indiceGarde];
    int verif = 0;


    for(int i =0; i < dee.length ; i++){
        if(garde != triplet){

            verif = 0;
            for(int j =0; j < dee.length ; j++){
                if(garde == dee[j]){
                    verif ++;
                }
            }

            if(verif == 2){
                for(int k =0; k < dee.length ; k++){
                    if(dee[k] == garde){
                        score += dee[k];
                    }
                }
                return score;
            }
        }

        garde = dee[i];
        
    }

    return score;
}

public static int casFull (int [] dee){
    int score = 0;
    int verifBrelan = 0;
    int verifPair = 0;

    verifBrelan = casBrelan(dee);
    int valBrelan = verifBrelan/3;

    if (verifBrelan != 0){
        verifPair = verifPair(dee, valBrelan);
        if(verifPair != 0){
            score = verifBrelan + verifPair;
            return score;
        }       
    }
    
    return score;
}

public static int casYams (int [] dee){
    int score = 0;
    int indiceGarde = 0;
    int garde = dee[indiceGarde];
    int verif = 0;

    for(int i =0; i < dee.length ; i++){
        verif = 0;
        for(int j =0; j < dee.length ; j++){
            if(garde == dee[j]){
                verif ++;
            }
        }

        if(verif == 5){
            for(int k =0; k < dee.length ; k++){
                if(dee[k] == garde){
                    score += dee[k];
                }
            }
            return score;
            
        }

        garde = dee[i];
    }

    return score;
}

public static int calcluerBonus (int[] tabScore){
    int score = 0;
    for(int i = 0; i<6 ; i++){
        score += tabScore[i];
    }
    if(score >= 63){
        return 35;
    } else {
        return 0;
    }
}

public static void calculerScore (int[] tabScore, int bonus){
    int score = 0;
    for(int i =0; i < tabScore.length ; i++){
        score += tabScore[i];
    }
    score += bonus;
    System.out.println("Votre score est de : " + score);
}



public static void main(String[] args) {

    int [] dee = new int[5];        // Tableau de 5 dés
    int nbRelanceCase = 0;          // Compteur de relance pour éviter que le joueur relance plus de 3 fois
    int score = 0;                  // Score final du joueur
    int [] tabScore = new int[13];  // Tableau de score du joueur pour chaque case
    boolean scoreNull = true;       // Booléen pour savoir si tous les scores sont placé ou non et Si oui on sort de la boucle
    boolean choixValide = false;    // Booléen pour savoir si le choix du joueur est valide ou non et Si oui on sort de la boucle pour passer au tour suivant
    int bonus = 0;                  // Bonus du joueur si il a plus de 63 points dans les 6 premières cases

    initialiserTabScore(tabScore); // On initialise le tableau de score à -1 pour savoir plus tard si le score est placé ou non 


    while(scoreNull){

        lanceDee(dee);
        afficherDee(dee);

        afficherScrore(tabScore, bonus);

        System.out.println("Où voulez vous placer votre score ? (1-6, brelan, carre, full, petite suite, grande suite, yams, chance)");
        System.out.println("Ou souhaitez vous relancer ? (relancer)");
        Scanner sc = new Scanner(System.in);
        
        

        while(choixValide == false){
            choixValide = false;
            String choix = sc.nextLine();
            switch ( choix ) {
                case "1" :
                    // Test si le score est déjà placé
                    if(tabScore[0] != -1){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[0] = cas1A6(dee, 1);
                    choixValide = true;
                    break;

                case "2" :
                    // Test si le score est déjà placé
                    if(tabScore[1] != -1){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[1] = cas1A6(dee, 2);
                    choixValide = true;
                        break;

                case "3" :
                        // Test si le score est déjà placé
                    if(tabScore[2] != -1){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[2] = cas1A6(dee, 3);
                    choixValide = true;
                        break;
                
                case "4" :
                    // Test si le score est déjà placé
                    if(tabScore[3] != -1){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[3] = cas1A6(dee, 4);
                    choixValide = true;
                        break;
                
                case "5" :
                    // Test si le score est déjà placé
                    if(tabScore[4] != -1){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[4] = cas1A6(dee, 5);     
                    choixValide = true;   
                        break;
                
                case "6" :
                    // Test si le score est déjà placé
                    if(tabScore[5] != -1){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[5] = cas1A6(dee, 6);  
                    choixValide = true;             
                        break;
                    


                case "brelan" :
                    // Test si le score est déjà placé
                    if(tabScore[6] != -1){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }

                    // Sinon on place le score
                    tabScore[6] = casBrelan(dee);
                    choixValide = true;
                        break;

                case "carre" :
                    // Test si le score est déjà placé
                    if(tabScore[7] != -1){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[7] = casCarre(dee);
                    choixValide = true;
                        break;

                case "full" :
                    // Test si le score est déjà placé
                    if(tabScore[8] != -1){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }

                    // Sinon on place le score
                    tabScore[8] = casFull(dee);
                    choixValide = true;
                        break;
                
                case "petite suite" :


                    choixValide = true;
                        break;
                
                case "grande suite" :


                    choixValide = true;
                        break;

                case "yams" :
                    // Test si le score est déjà placé
                    if(tabScore[11] != -1){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }

                    // Sinon on place le score
                    tabScore[11] = casYams(dee);
                    choixValide = true;
                        break;
                
                case "chance" :


                    choixValide = true;
                        break;
                
                case "relancer" : 

                    if (nbRelanceCase == 3){
                        System.out.println("Vous avez déjà relancé 3 fois");
                        break;
                    }
                    
                    int nbRelance = choixNbRelance(sc);
                    choixDee(nbRelance, sc, dee);

                    afficherDee(dee);
                    nbRelanceCase ++;
                    break;

                default:
                    break;
            }

        }


        int testIfNull = 0;
        for(int i : tabScore){
            if(tabScore[i] != -1){
                testIfNull ++;
            }
        }

        if(testIfNull == 13){
            scoreNull = false;
        }


    }

    bonus = calcluerBonus(tabScore);
    calculerScore(tabScore, bonus);
    

}

}