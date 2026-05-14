import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        VectorHeap<Paciente> miEmergencia = new VectorHeap<>();

        System.out.println("VERSION 1: Usando VectorHeap Propio");
        try {
            Scanner scanner = new Scanner(new File("pacientes.txt"));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    miEmergencia.add(new Paciente(datos[0], datos[1], datos[2]));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo pacientes.txt");
        }

        while (!miEmergencia.isEmpty()) {
            System.out.println(miEmergencia.remove());
        }

        System.out.println("\nVERSION 2: Usando Java Collection Framework");
        PriorityQueue<Paciente> jcfEmergencia = new PriorityQueue<>(); 
        
        try {
            Scanner scanner = new Scanner(new File("pacientes.txt"));
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    jcfEmergencia.add(new Paciente(datos[0], datos[1], datos[2]));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo pacientes.txt");
        }

        while (!jcfEmergencia.isEmpty()) {
            System.out.println(jcfEmergencia.poll()); 
        }
        
    } 
} 