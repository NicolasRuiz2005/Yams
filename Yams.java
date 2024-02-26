import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;


public class Yams {

/* Permet de tester si le choix du joueur est valide ou non
 * 
 * @param relance : le choix du dé que le joueur souhaite relancer
 * @param sc : le scanner pour récupérer le choix du joueur
 */
public static int choixDeePreq (int relance, Scanner sc){

    while(relance < 1 || relance > 5){
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
            dee[relance -1] = new Random().nextInt(6) + 1;

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
    System.out.println("============================================================================================================");
    for(int i = 0; i<5 ; i++){
        System.out.print("Dé " + (i+1) + " : " + dee[i]+ "       |       ");
    }
    System.out.println();
    System.out.println("============================================================================================================");
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

        if(tabScore[i] == -1){
            System.out.println((i+1) + " : " +(tabScore[i] + 1));
        } else {
            System.out.println((i+1) + " : " + tabScore[i]);
        }        
    }

    System.out.println("Bonus : " + bonus);

    if(tabScore[6] == -1){
        System.out.println("Brelan : " + (tabScore[6] + 1));
    } else {
        System.out.println("Brelan : " + tabScore[6]);
    }

    if(tabScore[7] == -1){
        System.out.println("Carre : " + (tabScore[7] + 1));
    } else {
        System.out.println("Carre : " + tabScore[7]);
    }

    if(tabScore[8] == -1){
        System.out.println("Full : " + (tabScore[8] + 1));
    } else {
        System.out.println("Full : " + tabScore[8]);
    }

    if(tabScore[9] == -1){
        System.out.println("Petite suite : " + (tabScore[9] + 1));
    } else {
        System.out.println("Petite suite : " + tabScore[9]);
    }

    if(tabScore[10] == -1){
        System.out.println("Grande suite : " + (tabScore[10] + 1));
    } else {
        System.out.println("Grande suite : " + tabScore[10]);
    }

    if(tabScore[11] == -1){
        System.out.println("Yams : " + (tabScore[11] + 1));
    } else {
        System.out.println("Yams : " + tabScore[11]);
    }

    if(tabScore[12] == -1){
        System.out.println("Chance : " + (tabScore[12] + 1));
    } else {
        System.out.println("Chance : " + tabScore[12]);
    }
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
            score = 25;
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
            score = 50;
            return score;
            
        }

        garde = dee[i];
    }

    return score;
}

public static int casPetiteSuite (int [] dee){
    int score = 0;
    int [] tab = new int[5];
    int cpt = 0;
    for(int i =0; i < dee.length ; i++){
        tab[i] = dee[i];
    }

    for(int i =0; i < tab.length ; i++){
        for(int j =0; j < tab.length ; j++){
            if(tab[i] < tab[j]){
                int temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
            }
        }
    }

    for(int i =0; i < tab.length -1 ; i++){
        if(tab[i] == tab[i+1] -1){
            cpt ++;
        }
    }

    if(cpt == 3){
        score = 30;
        return score;
    }

    return score;
}

public static int casGrandeSuite(int [] dee){
    int score = 0;
    int [] tab = new int[5];
    int cpt = 0;
    for(int i =0; i < dee.length ; i++){
        tab[i] = dee[i];
    }

    for(int i =0; i < tab.length ; i++){
        for(int j =0; j < tab.length ; j++){
            if(tab[i] < tab[j]){
                int temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
            }
        }
    }

    for(int i =0; i < tab.length -1 ; i++){
        if(tab[i] == tab[i+1] -1){
            cpt ++;
        }
    }

    if(cpt == 4){
        score = 40;
        return score;
    }

    return score;
}

public static int casChance (int [] dee){
    int score = 0;
    for(int i =0; i < dee.length ; i++){
        score += dee[i];
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

public static int calculerScore (int[] tabScore, int bonus){
    int score = 0;
    for(int i =0; i < tabScore.length ; i++){
        score += tabScore[i];
    }
    score += bonus;
    return score;
}

public static boolean caseEssaie(String choix, int[] dee, int[] tabScore, HashMap <String, Integer> scoreMap, boolean choixValide){
    // Test si le score est déjà placé
    if(tabScore[scoreMap.get(choix)] != -1){
        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("Vous avez déjà placé un score ici");
        System.out.println("==========================================");
        System.out.println("\n");

    } else {
        // Sinon on place le score
        switch ( choix ) {

            default :
                int choixInt = Integer.parseInt(choix);
                tabScore[scoreMap.get(choix)] = cas1A6(dee, choixInt);
                choixValide = true;
                break;
        
            case "brelan":
                tabScore[scoreMap.get(choix)] = casBrelan(dee);
                choixValide = true;
                break;
            
            case "carre":
                tabScore[scoreMap.get(choix)] = casCarre(dee);
                choixValide = true;
                break;
            
            case "full":
                tabScore[scoreMap.get(choix)] = casFull(dee);
                choixValide = true;
                break;
            
            case "petite suite":
                tabScore[scoreMap.get(choix)] = casPetiteSuite(dee);
                choixValide = true;
                break;
            
            case "grande suite":
                tabScore[scoreMap.get(choix)] = casGrandeSuite(dee);
                choixValide = true;
                break;
            
            case "yams":
                tabScore[scoreMap.get(choix)] = casYams(dee);
                choixValide = true;
                break;
            
            case "chance":
                tabScore[scoreMap.get(choix)] = casChance(dee);
                choixValide = true;
                break;



        }

        choixValide = true;
    }
    
    return choixValide;
}

public static boolean testBonChoix (String choix){

    if(choix.equals("1") || choix.equals("2") || choix.equals("3") || choix.equals("4") || choix.equals("5") || choix.equals("6") || choix.equals("brelan") || choix.equals("carre") || choix.equals("full") || choix.equals("petite suite") || choix.equals("grande suite") || choix.equals("yams") || choix.equals("chance") || choix.equals("r") || choix.equals("R")){
       return true;
    } else {
        return false;
    }

}


public static void main(String[] args) {

    int [] dee = new int[5];        // Tableau de 5 dés
    int nbRelanceCase = 0;          // Compteur de relance pour éviter que le joueur relance plus de 3 fois
    int score = 0;                  // Score final du joueur
    int [] tabScore = new int[13];  // Tableau de score du joueur pour chaque case
    boolean scoreNull = true;       // Booléen pour savoir si tous les scores sont placé ou non et Si oui on sort de la boucle
    boolean choixValide = false;    // Booléen pour savoir si le choix du joueur est valide ou non et Si oui on sort de la boucle pour passer au tour suivant
    int bonus = 0;                  // Bonus du joueur si il a plus de 63 points dans les 6 premières cases

    HashMap <String, Integer> scoreMap = new HashMap<String, Integer>(); // Permet de faire correspondre le choix du joueur avec la case du tableau de score
    scoreMap.put("1", 0);
    scoreMap.put("2", 1);
    scoreMap.put("3", 2);
    scoreMap.put("4", 3);
    scoreMap.put("5", 4);
    scoreMap.put("6", 5);
    scoreMap.put("brelan", 6);
    scoreMap.put("carre", 7);
    scoreMap.put("full", 8);
    scoreMap.put("petite suite", 9);
    scoreMap.put("grande suite", 10);
    scoreMap.put("yams", 11);
    scoreMap.put("chance", 12);


    initialiserTabScore(tabScore); // On initialise le tableau de score à -1 pour savoir plus tard si le score est placé ou non 


    while(scoreNull){

        lanceDee(dee);
        afficherDee(dee);
        System.out.println("\n");
        afficherScrore(tabScore, bonus);

        System.out.println("Où voulez vous placer votre score ? (1-6, brelan, carre, full, petite suite, grande suite, yams, chance)");
        System.out.println("Ou souhaitez vous relancer ? (r)");
        Scanner sc = new Scanner(System.in);
        choixValide = false;
        nbRelanceCase = 0;

        while(!choixValide){
            sc = new Scanner(System.in);
            String choix = sc.nextLine();

            // On test si le joueur rentre autre chose que les choix possible
            boolean test = testBonChoix(choix);
            if(test == false){
                System.out.println("\n");
                System.out.println("==========================================");
                System.out.println("!!!    Votre choix n'est pas valide    !!!");
                System.out.println("==========================================");
                System.out.println("\n");
            } else {
                switch ( choix ) {

                    case "r":
                    case "R":
                        if(nbRelanceCase >= 2){
                            System.out.println("\n");
                            System.out.println("==========================================");
                            System.out.println("!!!    Vous avez déjà relancé 3 fois   !!!");
                            System.out.println("==========================================");
                            System.out.println("\n");
                        } else {
                            nbRelanceCase ++;
                            int nbRelance = choixNbRelance(sc);
                            choixDee(nbRelance, sc, dee);
                            System.out.println("\n");
                        }
                        break;
                    
                    default :
                        System.out.println("\n");
                        choixValide = caseEssaie(choix, dee, tabScore, scoreMap, choixValide);
                            
                        
                        break;
                }
        }


            if(choixValide == true){
                break;
            }

            bonus = calcluerBonus(tabScore);
            afficherDee(dee);
            afficherScrore(tabScore, bonus);
            System.out.println("Où voulez vous placer votre score ? (1-6, brelan, carre, full, petite suite, grande suite, yams, chance)");
            System.out.println("Ou souhaitez vous relancer ? (r)");

        }

        

        int testIfNull = 0;
        for(int i=0; i < tabScore.length ; i++){
            if(tabScore[i] != -1){
                testIfNull ++;
            }
        }

        if(testIfNull == 13){
            scoreNull = false;
        }


    }

    
    score = calculerScore(tabScore, bonus);
    System.out.println("==========================================");
    System.out.println("La partie est terminée !");
    System.out.println("Votre score est de : " + score);
    System.out.println("Merci d'avoir joué !");

}


}