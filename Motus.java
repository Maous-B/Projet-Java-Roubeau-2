public class Motus {

    public static void main(String[] args) {

        // Déclarations des variables
        String motASaisir = "", X[], motATrouve;
        int nbEssai, taille, Essais;

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

        // On commence a sauvegarder le cara
        for(int I = 0; I < taille; I++) {
            X[I] = motATrouve.substring(I, I+1);
        }


        // On sauvegarde le nombre d'essais dans une variable
        nbEssai = taille - 2;

        // On le resauvegarde dans une autre variable pour que quand la personne joue, on pourra soustraire par 1 cette variable pour que la boucle ne soit pas bugué
        Essais = nbEssai;

        // On annonce au joueur la taille du mot et son nombre d'essais
        System.out.println("La taille du mot est de " + taille + ". Vous avez donc " + nbEssai + " essais.");

        //Pour A allant de 0 à la taille du mot
        for(int A = 0; A < nbEssai; A++) {

            //On lui fait deviner le mot avec une saisie et en lui donnant son nombre d'essais
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
                    System.out.println("BRAVO ! Vous avez trouvé le bon mot qu'était " + motATrouve + ".");
                    // On asigne A à nbEssai pour casser la boucle directement
                    A = nbEssai;
                }
                // Si le joueur n'a pas trouvé le bon mot, il continue de jouer et le programme lui donne un indice
                else
                {
                    // On lui donne un indice en affichant, dans une boucle for, le mot sauvegardé précédement
                    System.out.print("Indice : ");
                    for(int I = 0; I < taille; I++)
                    {
                        //Si le mot que le joueur a saisit est supérieur ou égal a 5, on affiche le mot
                        if(motASaisir.length() >= 5) {
                            // Si le caractère du mot saisit par le joueur correspond au caractère du vecteur X à la position I, on affiche la lettre trouvé à la position
                            // Ex : l'utilisateur entre totor et le mot a trouver était tatar, on affiche donc "t_t_r"
                            if(X[I].equals(motASaisir.substring(I, I+1)) == true)
                            {
                                System.out.print(X[I]);
                            }
                            // Si les caractères ne correspondent pas, on affiche un blanc "_" pour montrer les lettres manquantes
                            else
                            {
                                System.out.print("_");
                            }
                        }

                    }
                    // On met un espace pour le saut à la ligne
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
