package Pokemon;
import ErrorManager.*;
import Structure.GrandTerrain;
import Structure.Terrain;
import affinite.*;
import pouvoirs.Pouvoirs;

import java.util.List;


/**
 * Classe Pokemon : classe permettant de définir le fonctionement d'un pokemon:
 * Un pokemon possède un nom, une valeur d'attaque et une valeur de vie.
 * Il peut attaquer d'autres pokemons.
 *
 */

public class Pokemon
{
  boolean m_aUtilisePouvoir = false;
  private int m_attaque;
  private int m_vie;
  private int m_vieInitial;
  private String m_nom;
  private TypePokemon m_type;
  private Pouvoirs m_pouvoir;

  

  /**
   * Pokemon : Constructeur de la classe Pokemon.
   *
   * @param nom String indiquant le nom du pokemon
   * @param vie Entier représentant les points de vie du pokemon.
   * @param attaque Entier représentant les points d'attaque du pokemon.
   *
   */
  public Pokemon(String nom, int vie, int attaque, TypePokemon type , Pouvoirs pouvoir) {

    m_attaque = attaque;
    m_vie = vie;
    m_nom = nom;
    m_type = type;
    m_vieInitial = vie;
    m_pouvoir = pouvoir;
  }

  public void usePower(String reponse, GrandTerrain terrain, boolean humain)
          throws PokemonHasNoPower, PokemonIsTheSame, PokemonNotFound, InputIsNotString {
    m_pouvoir.use(this, reponse, terrain, humain);
  }

  /**
   * Méthode attaque : attaque un Pokemon adverse et lui enlève des points de vie
   *
   * @param other Pokemon adverse à attaquer.
   *
   */
  public void attaque (Pokemon other) {
    if (m_type.aUnAvantageSur(other.getType())){
      attaque_intermediaire(other, m_attaque+other.getType().getval());
    }

    else if (m_type.aUnDesavantageSur(other.getType())){
      attaque_intermediaire(other,other.getType().getval());
    }

    else{
      attaque_intermediaire(other, this.m_attaque);
    }

  }

  /**
   * Méthode get_nom
   *
   * @return String représentant le nom du Pokemon.
   */
  public String getNom() {return m_nom;}

  public int getVie() {
    return m_vie;
  }

  public int getVieInitial(){
    return m_vieInitial;
  }

  public boolean getAUtiliserPouvoir(){
    return m_aUtilisePouvoir;
  }

  public int getAttaque(){
    return m_attaque;
  }

  public TypePokemon getType(){ return m_type;}

  public void setAttaque (int nouvelleAttaque) {
    m_attaque = nouvelleAttaque;
  }

  public void setVie(int nouvelleVie) {
    m_vie = nouvelleVie;
  }

  public void setBoolPouvoir(boolean aUtilisePouvoir) {
    this.m_aUtilisePouvoir = aUtilisePouvoir;
  }

  private void attaque_intermediaire (Pokemon other, int attaque) {
    if (other.m_vie - attaque <= 0) {
      other.m_vie = 0;
    }
    else other.m_vie -= attaque;

  }

  public Pouvoirs getPouvoirs(){
    return m_pouvoir;
  }

  public void setPouvoir(Pouvoirs pouvoirs){
    m_pouvoir=pouvoirs;
  }

  public void setType(TypePokemon type){
    m_type=type;
  }

  
  /**
   * Méthode toString
   *
   * @return String des infos de l'instance.
   */
  public String toString () {
      return m_nom + ": <" + m_vie + ", " + m_attaque + ","+ m_type.getNom()+">";
  }

} 