package devandroid.kaua.projetofinal.Model;

public class Pokemon {

    private String Nome;
    private String Forma;
    private int id;



    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getForma() {
        return Forma;
    }

    public void setForma(String forma) {
        Forma = forma;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "Nome='" + Nome + '\'' +
                ", Forma='" + Forma + '\'' +
                ", id=" + id +
                '}';
    }
}


