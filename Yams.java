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

public static void lanceDee (int[] dee){
    for(int i : dee){
        dee[i] = new Random().nextInt(6) + 1; 
    }
}

public static void afficherDee (int[] dee){
    System.out.println("Voici vos dés : ");
    System.out.println("=============================");
    for(int i : dee){
        System.out.print("Dé " + (i+1) + " : " + dee[i]+ "  |  ");
    }
    System.out.println("=============================");
}

public static void initialiserTabScore (int[] tabScore){
    for(int i : tabScore){
        tabScore[i] = -1;
    }
}

public static void afficherScrore (int[] tabScore){
    System.out.println("Voici votre score : ");
    System.out.println("=============================");
    for(int i =0; i<6 ; i++){
        System.out.println((i+1) + " : " + tabScore[i]);
    }
    System.out.println("Bonus : " + tabScore[6]);
    System.out.println("Brelan : " + tabScore[7]);
    System.out.println("Carre : " + tabScore[8]);
    System.out.println("Full : " + tabScore[9]);
    System.out.println("Petite suite : " + tabScore[10]);
    System.out.println("Grande suite : " + tabScore[11]);
    System.out.println("Yams : " + tabScore[12]);
    System.out.println("Chance : " + tabScore[13]);
    System.out.println("=============================");
}

public static int cas1A6 (int[] dee, int cas){
    int score = 0;
    for(int i : dee){
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

    for(int i : dee){
        verif = 0;
        for(int j : dee){
            if(garde == dee[j]){
                verif ++;
            }
        }

        if(verif == 3){
            for(int k : dee){
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
    for(int i : tabScore){
        score += tabScore[i];
    }
    score += bonus;
    System.out.println("Votre score est de : " + score);
}



public static void main(String[] args) {

    int [] dee = new int[5];
    int nbRelanceCase = 0;
    int score = 0;
    int [] tabScore = new int[13];
    boolean scoreNull = true;
    boolean choixValide = false;
    int bonus = 0;

    initialiserTabScore(tabScore); // On initialise le tableau de score à -1 pour savoir plus tard si le score est placé ou non 


    while(scoreNull){

        lanceDee(dee);
        afficherDee(dee);

        afficherScrore(tabScore);

        System.out.println("Où voulez vous placer votre score ? (1-6, brelan, carre, full, petite suite, grande suite, yams, Chance)");
        Scanner sc = new Scanner(System.in);
        String choix = sc.nextLine();
        

        while(choixValide == false){
            choixValide = false;
            switch ( choix ) {
                case "1" :
                    // Test si le score est déjà placé
                    if(tabScore[0] != 0){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[0] = cas1A6(dee, 1);
                    choixValide = true;
                    break;

                case "2" :
                    // Test si le score est déjà placé
                    if(tabScore[1] != 0){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[1] = cas1A6(dee, 2);
                    choixValide = true;
                        break;

                case "3" :
                        // Test si le score est déjà placé
                    if(tabScore[2] != 0){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[2] = cas1A6(dee, 3);
                    choixValide = true;
                        break;
                
                case "4" :
                    // Test si le score est déjà placé
                    if(tabScore[3] != 0){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[3] = cas1A6(dee, 4);
                    choixValide = true;
                        break;
                
                case "5" :
                    // Test si le score est déjà placé
                    if(tabScore[4] != 0){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[4] = cas1A6(dee, 5);     
                    choixValide = true;   
                        break;
                
                case "6" :
                    // Test si le score est déjà placé
                    if(tabScore[5] != 0){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }
                    // Sinon on place le score
                    tabScore[5] = cas1A6(dee, 6);  
                    choixValide = true;             
                        break;
                    


                case "brelan" :
                    // Test si le score est déjà placé
                    if(tabScore[6] != 0){
                        System.out.println("Vous avez déjà placé un score ici");
                        break;
                    }

                    // Sinon on place le score
                    tabScore[6] = casBrelan(dee);
                    choixValide = true;
                        break;

                case "carre" :

                    choixValide = true;
                        break;

                case "full" :


                    choixValide = true;
                        break;
                
                case "petite suite" :


                    choixValide = true;
                        break;
                
                case "grande suite" :


                    choixValide = true;
                        break;

                case "yams" :


                    choixValide = true;
                        break;
                
                case "Chance" :


                    choixValide = true;
                        break;
                
                case "Relancer" : 

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