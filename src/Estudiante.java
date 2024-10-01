public class Estudiante extends Persona implements Evaluable {
    private float nota;

    public Estudiante(String nombre, String apellido, String cedula, String sexo, float peso, float estatura, float nota) {
        super(nombre, apellido, cedula, sexo, peso, estatura);
        this.nota = nota;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return String.format("Estudiante:\nNombre: %s\nApellido: %s\nCedula: %s\nSexo: %s\nPeso: %.2f\nEstatura: %.2f\nnota: %.2f\n", this.nombre,this.apellido, this.cedula,this.sexo,this.peso,this.estatura,this.nota);
    }

    @Override
    public boolean esAprobado() {
        return this.nota >= 10;
    }
}
