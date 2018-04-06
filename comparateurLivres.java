import java.util.Comparator;

public class comparateurLivres implements Comparator<Livre> {

    public int compare(Livre o1, Livre o2) {
        int compMaisonEdition = o1.getMaisonEdition().compareTo(o2.getMaisonEdition());
        if (compMaisonEdition == 0) {
            int compAuteur = o1.getAuteur().compareTo(o2.getAuteur());
            if (compAuteur == 0) {
                int compTitre = o1.getTitre().compareTo(o2.getTitre());
                if (compTitre == 0)
                    return o1.getAnneePublication().compareTo(o2.getAnneePublication());
                else return compTitre;
            }
            else return compAuteur;
        }
        else return compMaisonEdition;
    }
}
