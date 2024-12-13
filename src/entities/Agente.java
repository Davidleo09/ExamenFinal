package entities;
public class Agente extends Entidad {
    private String habilidadEspecial;
    private String misionAsignada;
    private int nivel;

    public Agente(int id, String nombre, String habilidadEspecial, int nivel) {
        super(id, nombre);
        this.habilidadEspecial = habilidadEspecial;
        this.nivel = 1;
    }

    public void incrementarNivel() {
        this.nivel++;
        mostrarNivel();
    }

    public void mostrarNivel() {
        System.out.println("Nivel actual del agente: " + nivel);
    }

    public int getNivel() {
        return nivel;
    }

    public String getHabilidadEspecial() {
        return habilidadEspecial;
    }

    public void setHabilidadEspecial(String habilidadEspecial) {
        this.habilidadEspecial = habilidadEspecial;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }

    public void asignarMision(String mision) {
        this.misionAsignada = mision;
    }

    @Override
    public String toString() {

        return super.toString() + ", Habilidad Especial: " + habilidadEspecial + (misionAsignada != null ? ", Misión: " + misionAsignada : "");
    }
}
