package DM14FEVRIER;

public class Motus { 
 
    public static void main(String[] args) { 
 
        // Déclarations des variables 
        String motASaisir = "", X[], motATrouve = ""; 
        char lettresTrouvees[], lettresTrouveesActuelles[]; 
        int nbEssai, taille, Essais, I, J, K, L, A; 
 
        // Saisie du mot à deviner 
        motATrouve = Saisie.lire_String("Veuillez entrer un mot avec une taille supérieur à 5 : "); 
 
        // On prend la taille du mot a trouvé 
        taille = motATrouve.length(); 
 
 
        // Contrôle de saisie pour voir si la taille n'est pas strictement inférieur à 5 
        while(taille < 5) 
        { 
            //Si la taille n'est pas correcte, on reprend le mot et on reprend sa taille 
            motATrouve = Saisie.lire_String("Erreur de saisie. Veuillez recommencer : "); 
            taille = motATrouve.length(); 
        } 
 
        // Déclaration du tableau (vecteur) X avec comme taille la taille du mot a deviné 
        X = new String[taille]; 
 
        // On commence a sauvegarder le mot dans un vecteur/tableau 
        for(I = 0; I < taille; I++) { 
            X[I] = motATrouve.substring(I, I+1); 
        } 
 
 
        // On sauvegarde le nombre d'essais dans une variable 
        nbEssai = taille - 2; 
 
        // On le resauvegarde dans une autre variable pour que quand la personne joue, on pourra soustraire par 1 cette variable pour que la boucle ne soit pas bugué 
        Essais = nbEssai; 
 
        // On annonce au joueur la taille du mot et son nombre d'essais 
        System.out.println("La taille du mot est de " + taille + ". Vous avez donc " + nbEssai + " essais."); 
 
        // On initialise le tableau de lettres correctement trouvées à "_" 
        lettresTrouvees = new char[taille]; 
        // On remplit le tableau initialisé 
        for (J = 0; J < taille; J++) {
            lettresTrouvees[J] = '_';
        } 
 
        //Pour A allant de 0 à la taille du mot 
        for(A = 0; A < nbEssai; A++) { 
 
            // On lui fait deviner le mot avec une saisie et en lui donnant son nombre d'essais 
            motASaisir = Saisie.lire_String("Veuillez saisir votre essai avec la même taille que le mot a deviné. Si vous voulez abandonné, tapez SOL. Il vous reste " + (Essais) + " essais. : "); 
 
            //Si le joueur tape SOL, la partie s'arrête et affiche le mot qui était a trouvé 
            if(motASaisir.equals("SOL")) 
            { 
                System.out.println("Vous avez tapé SOL. Vous avez abandonné et le mot était " + motATrouve); 
                // On asigne A à nbEssai pour casser la boucle directement 
                A = nbEssai; 
            } 
            else 
            { 
                // On refait saisir à l'utilisateur le mot tant que la taille du mot saisit n'est pas égal à la taille du mot a trouvé 
                while(taille != motASaisir.length()) { 
                    motASaisir = Saisie.lire_String("Erreur de saisie. Veuillez resaisir votre essai avec la même taille que le mot a deviné. Si vous voulez abandonné, tapez SOL. Il vous reste " + (Essais) + " essais. : "); 
                } 
 
                // Si le joueur a trouvé le bon mot, il aura gagné et le jeu s'arrête 
                if(motASaisir.equals(motATrouve)) 
                { 
                    // On affiche qu'il a gagné 
                    System.out.println("BRAVO ! Vous avez trouvé le bon mot qu'était " + motATrouve + "."); 
                    // On asigne A à nbEssai pour casser la boucle directement 
                    A = nbEssai; 
                } 
                // Si le joueur n'a pas trouvé le bon mot, il continue de jouer et le programme lui donne un indice 
                else 
                { 
                    // On initialise le tableau de lettres correctement trouvées à "_" 
                    lettresTrouveesActuelles = new char[taille]; 
                    // On le remplit avec des caractères "_" 
                    for (K = 0; K < taille; K++) {
                        lettresTrouveesActuelles[K] = '_';
                    } 
 
                    // On parcourt chaque lettre saisie et on vérifie si elle correspond à une lettre du mot à deviner 
                    for (I = 0; I < taille; I++) { 
                        
                        // Si le caractère à la position I du mot que le joueur a saisit correspond au caractère à la position I du vecteur X 
                        if (motASaisir.charAt(I) == X[I].charAt(0)) { 
                            // On enregistre la lettre commune et bien placée dans le vecteur lettresTrouveesActuelles 
                            lettresTrouveesActuelles[I] = X[I].charAt(0); 
                            //System.out.println("LETTRE TROUVE  : " + lettresTrouveesActuelles[I]); 
                        } 
 
                        // Sinon, si les lettres ne sont pas communes et ne sont pas bien placés, on les remplit avec des caractères vides avec des tirets du bas "_" 
                        else { 
                            // On remplit le vecteur lettresTrouveesActuelles avec des caractères vides "_" 
                            lettresTrouveesActuelles[I] = lettresTrouvees[I]; 
 
                        } 
 
                    } 

                    // On met à jour le tableau lettresTrouvees
                    lettresTrouvees = lettresTrouveesActuelles; 
 
                    // On affiche le tableau de lettres correctement trouvées jusqu'à présent 
                    System.out.println("Voici les lettres qui sont communes bien placées : ");
                    for(L = 0; L < taille ; L++){
                        System.out.print(lettresTrouvees[L]);
                    } 
                    System.out.println(" ");
                    // On retire au joueur un essai car il n'a pas trouvé le bon mot 
                    Essais--; 
                } 
            } 
        } 
 
        // Si le joueur n'a plus d'essais, il a perdu 
        if(Essais == 0) 
        { 
            System.out.println("PERDU ! Vous n'avez pas trouvé le bon mot qu'était " + motATrouve + "."); 
        } 
 
 
    } 
 
} 

	



