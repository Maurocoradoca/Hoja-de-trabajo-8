public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private String codigoEmergencia;

    @Override
    public int compareTo(Paciente otro) {
        // Retorna un valor negativo si este paciente tiene mayor prioridad 
        return this.codigoEmergencia.compareTo(otro.getCodigoEmergencia());
    }

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