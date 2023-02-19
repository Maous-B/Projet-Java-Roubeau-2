public class Motus {
    public static void main(String[] args) {


        String motASaisir = "", X[], motATrouve;
        int nbEssai, taille;

        motATrouve = Saisie.lire_String("Veuillez entrer un mot avec une taille supérieur à 5 : ");

        taille = motATrouve.length();

        while(taille < 5)
        {
            motATrouve = Saisie.lire_String("Erreur de saisie. Veuillez recommencer : ");
        }


        X = new String[taille];


        for(int I = 0; I < taille; I++) {
            X[I] = motATrouve.substring(I, I+1);
        }

        nbEssai = taille - 2;

        System.out.println("La taille du mot est de " + taille + ". Vous avez donc " + nbEssai + " essais.");


        for(int A = 0; A < nbEssai; A++) {
            motASaisir = Saisie.lire_String("Veuillez saisir votre essai avec la même taille que le mot a deviné. Si vous voulez abandonné, tapez SOL. Il vous reste " + (nbEssai) + " essais. : ");

            if(motASaisir.equals("SOL"))
            {
                System.out.println("Vous avez tapé SOL. Vous avez abandonné et le mot était " + motATrouve);
                A = nbEssai;
            }
            else
            {
                while(taille != motASaisir.length()) {
                    motASaisir = Saisie.lire_String("Erreur de saisie. Veuillez resaisir votre essai avec la même taille que le mot a deviné. Si vous voulez abandonné, tapez SOL. Il vous reste " + (nbEssai) + " essais. : ");
                }

                if(motASaisir.equals(motATrouve))
                {
                    System.out.println("BRAVO ! Vous avez trouvé le bon mot qu'était " + motATrouve + ".");
                    A = nbEssai;
                }

                else
                {
                    System.out.print("Indice : ");
                    for(int I = 0; I < taille; I++)
                    {
                        if(motASaisir.length() >= 5) {
                            if(X[I].equals(motASaisir.substring(I, I+1)) == true)
                            {
                                System.out.print(X[I]);
                            }
                            else
                            {
                                System.out.print("_");
                            }
                        }

                    }
                    System.out.println(" ");
                    nbEssai--;
                }
            }
        }

        if(nbEssai == 0)
        {
            System.out.println("PERDU ! Vous n'avez pas trouvé le bon mot qu'était " + motATrouve + ".");
        }


    }

}
