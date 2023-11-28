package activeRecord;

public class Film {
    private String titre;
    private int id , id_real ;

    public Film (String t , Personne p){
        this.titre = t;
        this.id_real = p.getId();
        this.id = -1 ;
    }

    private Film(int id_real , int id , String t){
        this.titre = t ;
        this.id = id ;
        this.id_real = id_real;
    }
}
