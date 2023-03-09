package DM14FEVRIER;

public class DistanceIntervilles 
{ 
 
    public static void main(String args[]) 
    { 
        //Déclaration des variables 
        String ville1 = "", ville2 = "", reponse = ""; 
        boolean PremiereVerification = false, DeuxiemeVerification = false; 
        int villeDeDepart = 0, villeDarrive = 0, I = 0, J = 0; 
 
        //Déclaration du vecteur des villes qui va être stockée déjà dans la mémoire 
        String Vec_Villes [] = {"Brest", "Grenoble", "Lille", "Lyon", "Marseille", "Nantes", "Paris", "Rennes", "Strasbourg", "Toulouse"}; 
 
        //Déclaration de la matrice qui va être stockée déjà dans la mémoire 
        int Mat_Distances[][] = 
                { 
                {0,996,72,890,1286,305,564,245,1026,884}, 
                {0,0,750,104,286,711,576,747,505,543}, 
                {0,0,0,668,979,593,224,515,524,905}, 
                {0,0,0,0,316,607,472,645,434,467}, 
                {0,0,0,0,0,890,769,98,750,400}, 
                {0,0,0,0,0,0,386,106,832,559}, 
                {0,0,0,0,0,0,0,348,447,681}, 
                {0,0,0,0,0,0,0,0,799,665}, 
                {0,0,0,0,0,0,0,0,0,901}, 
                {0,0,0,0,0,0,0,0,0,0,0} 
        }; 
 
        //Tant que l'utilisateur n'a pas saisit OUI, il refait encore un tour 
        while(reponse.equals("OUI") == false) 
        { 
            //L'utilisateur saisit la ville de départ 
            ville1 = Saisie.lire_String("Veuillez saisir la ville de départ : "); 
 
            //Tant que la première vérification n'est pas complète, on vérifie que l'utilisateur a bien saisit une ville existante 
            while(PremiereVerification != true) 
            { 

                //Si le nom de la ville entré par l'utilisateur 
                if(ville1.equals(Vec_Villes[I])) 
                { 
                    //On affiche que la ville a été trouvé 
                    System.out.println("La ville de départ existe belle et bien."); 
                    //v1 va prendre la position à laquelle elle a trouvé la ville (ex : si elle a trouvé à la position 4 (I = 4), elle va donc prendre comme ville Marseille) 
                    villeDeDepart = I; 
                    //On casse la boucle en assignant au booléen PremiereVerification vrai 
                    PremiereVerification = true; 
                } 
 
                else 
                { 
                    //Si on n'a pas atteint le bout du tableau, on incrémente encore pour l'analyser
                    if(I != 9) 
                    { 
                        //On incrémente I pour permettre de parcourir le tableau
                        I++;
                    } 
                    //Sinon, ça veut dire que le tableau a été jusquau bout
                    else
                    {
                        //On redemande de saisir la ville car elle n'a pas été trouvé 
                        ville1 = Saisie.lire_String("Erreur de saisie : la ville de départ n'existe pas. Veuillez recommencer : "); 
                        //On se met à la position 0 du tableau pour recommencer depuis le début 
                        I = 0;
                    }
                    
                } 
            } 
 
            //L'utilisateur saisit la ville d'arrivée 
            ville2 = Saisie.lire_String("Veuillez saisir la ville d'arrivée :"); 
 
            //Tant que la deuxième vérification n'est pas complète, on vérifie que l'utilisateur a bien saisit une ville existante (on fait pareille) 
            while(DeuxiemeVerification != true) 
            { 
                if(ville2.equals(Vec_Villes[J])) 
                { 
                    //On affiche que la ville a été trouvé 
                    System.out.println("La ville d'arrivée existe belle et bien."); 
                    //v2 va prendre la position à laquelle elle a trouvé la ville (ex : si elle a trouvé à la position 4 (J = 6), elle va donc prendre comme ville Paris) 
                    villeDarrive = J; 
                    //On casse la boucle en assignant au booléen DeuxiemeVerification vrai 
                    DeuxiemeVerification = true; 
                } 
                else 
                { 
                    //Si on n'a pas atteint le bout du tableau, on incrémente encore pour l'analyser
                    if(J != 9) 
                    { 
                        //On incrémente I pour permettre de parcourir le tableau
                        J++;
                    } 
                    //Sinon, ça veut dire que le tableau a été jusquau bout
                    else
                    {
                        //On redemande de saisir la ville car elle n'a pas été trouvé 
                        ville2 = Saisie.lire_String("Erreur de saisie : la ville d'arrivée n'existe pas. Veuillez recommencer : "); 
                        //On se met à la position 0 du tableau pour recommencer depuis le début 
                        J = 0;
                    }
                    
                } 
            } 
 
         /* 
         Ici on inverse car quand on asigne les indices aux variables villeDeDepart et villeDarrive, le tableau ne va pas renvoyé la même valeur et les indices ne sont pas les mêmes 
            Exemple, si on fait : 
            La ville 4 correspond à Marseille placée à la 4ème position dans le vecteur Vec_Villes 
            La ville 6 correspond à Paris placée à la 6ème position dans le vecteur Vec_Villes 
            System.out.println(Mat_Distances[6][4]); : cela affichera 0 
            System.out.println(Mat_Distances[4][6]); : cela affichera 769 
 
            */ 
            if(villeDeDepart > villeDarrive) 
            { 
                /* 
                On inverse les indices car les indices ne sont pas les mêmes si on prend les mêmes villes mais dans un ordre différent 
                On affiche la distance entre les deux villes entrées 
                 */ 
                System.out.println("La distance entre " + ville1 + " et " + ville2 + " est de " + Mat_Distances[villeDarrive][villeDeDepart] + "kms"); 
            } 

            /*
             Si l'indice villeDeDepart est inférieur à l'indice villeDarrive, on affiche normalement
             */
            else if(villeDeDepart < villeDarrive)
            { 
 
                /* 
                Sinon, on n'inverse pas les indices et on affiche la distance entre les deux villes entrées 
                */ 
                System.out.println("La distance entre " + ville1 + " et " + ville2 + " est de " + Mat_Distances[villeDeDepart][villeDarrive] + "kms"); 
            } 
            /*
             * Si les deux indices sont égaux, cela veut donc dire qu'il a entré la même ville
             */
            else 
            {
                System.out.println("Vous avez entrer la même ville.");
            }
 
 
            // L'utilisateur décide s'il veut arrêté en tapant OUI pour arrêter ou en tapant autre chose pour continuer 
            reponse = Saisie.lire_String("Voulez-vous arrêter? Si oui, tapez OUI en majuscule, sinon taper autre chose : "); 
 
            if(reponse.equals("OUI") == false) 
            { 
                /* 
                On réinitialise les variables car on est à l'intérieur de la boucle et le programme a déjà sauvegardé les anciennes valeurs saisies précédemment par l'utilisateur 
                On purge et on recommence tout à zéro 
                */ 
                ville1 = ""; 
                ville2 = ""; 
                villeDeDepart = 0; 
                villeDarrive = 0; 
                I = 0; 
                J = 0; 
                PremiereVerification = false; 
                DeuxiemeVerification = false; 
            } 
        } 
    } 
} 
 