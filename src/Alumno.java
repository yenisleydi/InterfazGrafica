public class Alumno {
    private String nombre;
    private String apellidos;
    private String telefono;
    private String ine;
    private String semestre;
    private String genero;
    private String carrera;
    private String matricular;

    public String getNombre() {
        return nombre;
    }

    public Alumno(String nombre, String apellidos, String telefono, String ine, String semestre, String genero, String carrera, String matricular) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.ine = ine;
        this.semestre = semestre;
        this.genero = genero;
        this.carrera = carrera;
        this.matricular = matricular;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getGenero() {
        return genero;
    }

    public String getIne() {
        return ine;
    }

    public String getMatricular() {
        return matricular;
    }

    public String getTelefono() {
        return telefono;
    }
}
