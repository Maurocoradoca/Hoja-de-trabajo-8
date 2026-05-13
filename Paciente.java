public class Paciente {
    private String nombre;
    private String sintoma;
    private String codigoEmergencia;

    public Paciente(String nombre, String sintoma, String codigoEmergencia) {
        this.nombre = nombre.trim();
        this.sintoma = sintoma.trim();
        this.codigoEmergencia = codigoEmergencia.trim();
    }

    public String getCodigoEmergencia() {
        return codigoEmergencia;
    }

    @Override
    public String toString() {
        return nombre + ", " + sintoma + ", " + codigoEmergencia;
    }
}