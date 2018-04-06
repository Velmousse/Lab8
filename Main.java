import javax.management.ListenerNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<Livre> listeLivres = new ArrayList<>(10);
        setUp(listeLivres);

        System.out.print("\n\nTri Collections.sort par année de publication avec Comparable ");
        Collections.sort(listeLivres);
        System.out.println(listeLivres);

        System.out.print("\n\nTri Collections.sort avec un Comparator ");
        Collections.sort(listeLivres, new comparateurLivres());
        System.out.println(listeLivres);

        System.out.print("\n\nTri par année de publication avec un TreeSet ");
        TreeSet<Livre> treeSetLivres = new TreeSet<>();
        for (Livre livre: listeLivres)
            treeSetLivres.add(livre);
        System.out.println(treeSetLivres);

        System.out.print("\n\nTri avec un TreeSet utilisant le Comparator créé ");
        TreeSet<Livre> treeSetLivres2 = new TreeSet<>(new comparateurLivres());
        for (Livre livre: listeLivres)
            treeSetLivres2.add(livre);
        System.out.println(treeSetLivres2);

        System.out.print("\n\nTri par date de publication avec un Merge ajouté ");
        Livre[] listA = new Livre[listeLivres.size() / 2], listB = new Livre[listeLivres.size() / 2];
        for (int i = 0; i < listeLivres.size() / 2; i++) {
            listA[i] = listeLivres.get(i);
            listB[i] = listeLivres.get(i + (listeLivres.size() / 2));
        }
        mergeSort(listA);
        mergeSort(listB);
        Livre[] tempo = new Livre[10];

        merge(tempo, listA, listB);
        for (int i = 0; i < tempo.length; i++)
            listeLivres.set(i, tempo[i]);
        System.out.println(listeLivres);

    }

    static void setUp(List<Livre> listeLivres) {
        listeLivres.add(new Livre("000000000", "Clair de Lune", "", "Roger Fabian", "Les Éditions Soleil", "1950"));
        listeLivres.add(new Livre("111111111", "La Montée Brumeuse", "Première partie", "Monte Christo", "Jamais Revu", "na"));
        listeLivres.add(new Livre("222222222", "En Dehors de la Cage", "Une sortie infernale", "Daniel Johnson", "Les livres Renouveau", "2005"));
        listeLivres.add(new Livre("333333333", "Une belle nuit d'été", "", "Roger Fabian", "Les Éditions Soleil", "1942"));
        listeLivres.add(new Livre("444444444", "Mon histoire", "par René Angélil", "René Angélil", "Céline Dion Inc.", "2016"));
        listeLivres.add(new Livre("555555555", "Plus jamais", "Comment ne pas refaire les erreurs faites du passé", "Gorge Orewl", "Jamais Revu", "2045"));
        listeLivres.add(new Livre("666666666", "Ma Jeunesse", "", "Amely Nottombe", "Les livres Renouveau", "2003"));
        listeLivres.add(new Livre("777777777", "Les Magiciens de l'autre Monde", "Un dessous sans fond", "Stéphane Sapill", "Jamais Revu", "1987"));
        listeLivres.add(new Livre("888888888", "La Cryptographie en deux étapes complexes", "Comment ne pas résoudre les problèmes", "Marque Sékin", "Sciences Pures", "2013"));
        listeLivres.add(new Livre("999999999", "Trouver facilement des titres originaux de livres", "", "Vincent Dufour", "SIM", "2018"));
    }

    static void mergeSort(Livre[] liste) {
        if (liste.length > 1) {
            Livre[] gauche = new Livre[liste.length / 2],
                    droite = new Livre[liste.length - (liste.length / 2)];

            for (int i = 0; i < gauche.length; i++)
                gauche[i] = liste[i];
            for (int i = 0; i < droite.length; i++)
                droite[i] = liste[i + (liste.length / 2)];

            mergeSort(gauche);
            mergeSort(droite);
            merge(liste, gauche, droite);
        }
    }

    static void merge(Livre[] liste, Livre[] gauche, Livre[] droite) {
        int a = 0, b = 0;
        for (int i = 0; i < liste.length; i++) {
            if (b >= droite.length || (a < gauche.length && gauche[a].getAnneePublication().compareTo(droite[b].getAnneePublication()) < 0)) {
                liste[i] = gauche[a];
                a++;
            }
            else {
                liste[i] = droite[b];
                b++;
            }
        }
    }
}
