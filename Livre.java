import java.util.Comparator;

public class Livre implements Comparable<Livre>{
    private String ISBN, titre, sousTitre, auteur, maisonEdition, anneePublication;

    public Livre(String ISBN, String titre, String sousTitre, String auteur, String maisonEdition, String anneePublication) {
        this.ISBN = ISBN;
        this.titre = titre;
        this.sousTitre = sousTitre;
        this.auteur = auteur;
        this.maisonEdition = maisonEdition;
        this.anneePublication = anneePublication;
    }

    public int compareTo(Livre o) {
        return anneePublication.compareTo(o.anneePublication);
    }

    public String toString() {
        return "\n\u001B[31mISBN: " + "\u001B[0m" + ISBN + ", " +
                "\u001B[31mtitre: " + "\u001B[0m" + titre + ", " +
                "\u001B[31msous-titre: " + "\u001B[0m" + sousTitre + ", " +
                "\u001B[31mauteur: " + "\u001B[0m" + auteur + ", " +
                "\u001B[31mmaison d'édition: " + "\u001B[0m" + maisonEdition + ", " +
                "\u001B[31mannée de publication: " + "\u001B[0m" + anneePublication;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getSousTitre() {
        return sousTitre;
    }

    public void setSousTitre(String sousTitre) {
        this.sousTitre = sousTitre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getMaisonEdition() {
        return maisonEdition;
    }

    public void setMaisonEdition(String maisonEdition) {
        this.maisonEdition = maisonEdition;
    }

    public String getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(String anneePublication) {
        this.anneePublication = anneePublication;
    }
}
