/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author jo
 */
import java.util.*;
import java.text.*;

/**
 * Représente une date du calendrier grégorien exprimée en français.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Date
{
    private static final SimpleDateFormat JOURSEUL = new SimpleDateFormat("EEEE",Locale.FRENCH);    
    private static final SimpleDateFormat MOISSEUL = new SimpleDateFormat("MMMM",Locale.FRENCH);    

    /**
     * Format de date complet avec le jour de la semaine. Par exemple, "mardi 29 janvier 1963"
     */
    public static final SimpleDateFormat COMPLET = new SimpleDateFormat("EEEE d MMMM yyyy",Locale.FRENCH);

    /**
     * Format de date complet sans le jour de la semaine. Par exemple, "29 janvier 1963"
     */
    public static final SimpleDateFormat LONGSANSJOURSEMAINE = new SimpleDateFormat("d MMMM yyyy",Locale.FRENCH);

    /**
     * Format de date abrégé. Par exemple, "29 janv. 1963"
     */
    public static final SimpleDateFormat COURTSANSJOURSEMAINE = new SimpleDateFormat("d MMM yyyy",Locale.FRENCH);

    /**
     * Format de date abrégé avec jour de semaine. Par exemple, "mar. 29 janv. 1963" 
     */
    public static final SimpleDateFormat COURT = new SimpleDateFormat("EEE d MMM yyyy",Locale.FRENCH);

    /**
     * Format de date numérique. Par exemple "29/01/1963"
     */
    public static final SimpleDateFormat COURTNUM = new SimpleDateFormat("dd/MM/yyyy",Locale.FRENCH);

    private SimpleDateFormat formatAffichage = COURTNUM;

    /**
     * Spécifie le format de date utilisé dans le toString. Par défaut, c'est le format Date.CORTNUM
     * @param formatAffichage
     */
    public void setFormat(SimpleDateFormat formatAffichage){this.formatAffichage=formatAffichage;}

    private GregorianCalendar date;

    /**
     * restitue le numéro du jour dans le mois. Par exemple 29 pour 29/01/1963
     * @return
     */
    public int getNumJour(){return this.date.get(Calendar.DAY_OF_MONTH);}

    /**
     * restitue le nom du jour de la semaine. Par exemple, "mardi"
     * @return
     */
    public String geNomJour(){return JOURSEUL.format(date.getTime());}

    /**
     * restitue le nom du mois. Par exemple, "janvier"
     * @return
     */
    public String getMois(){return MOISSEUL.format(date.getTime());}

    /**
     * restitue le numéro du mois dans l'année. Par exemple, 1 pour janvier
     * @return
     */
    public int getNumMois(){return this.date.get(Calendar.MONTH)+1;}

    /**
     * restitue l'année en chiffres. Par exemple, 1963
     * @return
     */
    public int getNumAnnee(){return this.date.get(Calendar.YEAR);}
    
    public int getHeure(){return this.date.get(Calendar.HOUR);}
    public int getMinutes(){return this.date.get(Calendar.MINUTE);}
    
    /**
     * ajoute un certain nombre de jours à la date courante en respectant le calendrier
     * @param nbJours nombre de jours ajoutés
     */
    public void ajouteJours(int nbJours)
    {
        date.add(Calendar.DAY_OF_MONTH, nbJours);
    }

     /**
     * ajoute un certain nombre de mois à la date courante en respectant le calendrier
     * @param nbMois nombre de mois ajoutés
     */
    public void ajouteMois(int nbMois)
    {
        date.add(Calendar.MONTH, nbMois);
    }

     /**
     * ajoute un certain nombre d'années à la date courante
     * @param nbAnnees nombre d'années ajoutées
     */
    public void ajouteAnnees(int nbAnnees)
    {
        date.add(Calendar.YEAR, nbAnnees);
    }
    
    /**
     * constructeur d'une date à la date du jour
     */
    public Date()
    {
        this.date=new GregorianCalendar();
    }

    /**
     * constructeur d'une Date à partir de sa description numérique
     * @param nJour numéro du jour dans le mois. Par exemple, 29
     * @param nMois numéro du mois dans l'année. Par exemple, 1 ou 01
     * @param nAnnee numéro de l'année. Par exemple, 1963
     */
    public Date(int nJour,int nMois, int nAnnee)
    {
        this.date=new GregorianCalendar(nAnnee,nMois-1,nJour);
    }
    
    /**
     * constructeur d'une Date avec le nom du mois en lettres
     * @param nJour numéro du jour dans le mois. Par exemple, 29
     * @param nMois nom du mois, par exemple "janvier"
     * @param Annee numéro de l'année. Par exemple, 1963
     */
    public Date(int nJour,String nMois, int Annee)
    {
        this(""+nJour+" "+nMois+" "+Annee);
    }

    /**
     * constructeur d'une Date à partir d'une chaîne
     * (tous les formats de date listés en variables de classes sont compris)
     * @param dateTextuelle par exmple, "29/01/1963" ou "29 janvier 1963" ou "29 janv. 1963"…
     */
    public Date(String dateTextuelle)
    {
        this.date=new GregorianCalendar();
        java.util.Date dateIntermediaire=new java.util.Date();
        try
        {
            dateIntermediaire=COURTNUM.parse(dateTextuelle);
        }
        catch (ParseException e)
        {
            try
            {
                dateIntermediaire=LONGSANSJOURSEMAINE.parse(dateTextuelle);
            }
            catch (ParseException e1)
            {
                try
                {
                    dateIntermediaire=COURTSANSJOURSEMAINE.parse(dateTextuelle);
                }
                catch (ParseException e2)
                {
                    try
                    {
                        dateIntermediaire=COURT.parse(dateTextuelle);
                    }
                    catch (ParseException e3)
                    {
                        try
                        {
                            dateIntermediaire=COMPLET.parse(dateTextuelle);
                        }
                        catch (ParseException e4)
                        {
                            System.out.println("Format de date erroné");
                        }
                    }
                }
            }

        }
        this.date.setTime(dateIntermediaire);
    }

    /**
     * comparaison temporelle de dates
     *
     * @param autre référence la date à comparer à la date qui exécute la méthode
     * @return vrai si la date précède temporellement la date référencée en paramètre ou quel les deux sont identiques
     */
    public boolean isAvant(Date autre)
    {
        int dif=autre.getNumAnnee()-this.getNumAnnee();
        if(dif>0) return true;
        else
            if(dif<0) return false;
            else
            {
                dif=autre.getNumMois()-this.getNumMois();
                if(dif>0) return true;
                else
                    if(dif<0) return false;
                    else
                        return autre.getNumJour() >= this.getNumJour();                    
            }
    }
    
    /**
     * comparaison temporelle de dates
     * 
     * @param autre référence la date à comparer à la date qui exécute la méthode
     * @return vrai si la date suit temporellement la date référencée en paramètre ou que les deux sont identiques
     */
    public boolean isApres(Date autre){return !this.isAvant(autre)||this.equals(autre);}
    
    /**
     * équivalence entre deux dates
     * 
     * @param autre référence la date à comparer à la date qui exécute la méthode
     * @return true si les jour, mois et année des deux dates sont identiques
     */
    public boolean equals(Date autre)
    {
        return
           (this.getNumAnnee() == autre.getNumAnnee()) &&
           (this.getNumMois() == autre.getNumMois()) &&
           (this.getNumJour() == autre.getNumJour());
    }
    
    @Override
    public String toString()
    {
        return formatAffichage.format(date.getTime());
    }

    /**
     * restitue une chaîne qui représente la date
     * @return  chaîne qui décrit la date au format "mardi 29 janvier 1963"
     */
    public String toStringComplet()
    {
        return COMPLET.format(date.getTime());
    }

    /**
     * restitue une chaîne qui représente la date
     * @return  chaîne qui décrit la date au format "29 janvier 1963" (pas de jour de semaine)
     */
    public String toStringlongSansJourDeSemaine()
    {
        return LONGSANSJOURSEMAINE.format(date.getTime());
    }

    /**
     * restitue une chaîne qui représente la date
     * @return  chaîne qui décrit la date au format "29 janv. 1963" (abréviation du mois)
     */
    public String toStringCourtSansJourDeSemaine()
    {
        return COURTSANSJOURSEMAINE.format(date.getTime());
    }

    /**
     * restitue une chaîne qui représente la date
     * @return  chaîne qui décrit la date au format "mar. 29 janv. 1963" (pas de jour de semaine)
     */
    public String toStringCourt()
    {
        return COURT.format(date.getTime());
    }

    /**
     * restitue une chaîne qui représente la date
     * @return  chaîne qui décrit la date au format "29/01/1963"
     */
    public String toStringCourtNum()
    {
        return COURTNUM.format(date.getTime());
    }

}

