package management;

import entities.Agente;
import utils.ConsoleUtils;

import java.util.ArrayList;

public class AgenteManager {
    private ArrayList<Agente> agentes;

    public AgenteManager() {
        this.agentes = new ArrayList<>();
    }
      
    public void mostrarNivel(Agente agente) {
        System.out.println("Nivel actual del agente: " + agente.getNivel());
    }

    public void registrarAgente() {
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente: ");
        ConsoleUtils.limpiarBuffer(); // Consumir cualquier salto de línea residual

        String nombre = ConsoleUtils.leerTexto("Ingrese el nombre del agente: ");
        String habilidad = ConsoleUtils.leerTexto("Ingrese la habilidad especial del agente: ");

        Agente nuevoAgente = new Agente(id, nombre, habilidad, 1);
        agentes.add(nuevoAgente);
        System.out.println("Agente registrado con éxito.");
    }

    public void mostrarAgentes() {
        if (agentes.isEmpty()) {
            System.out.println("No hay agentes registrados.");
            return;
        }
        System.out.println("=== Lista de Agentes ===");
        for (Agente agente : agentes) {
            System.out.println(agente);
            mostrarNivel(agente);
        }
    }

    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Agentes ===");
            System.out.println("1. Registrar Agente");
            System.out.println("2. Mostrar Agentes");
            System.out.println("3. Aumentar Nivel");
            System.out.println("4. Salir");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
    
            switch (opcion) {
                case 1 -> registrarAgente();
                case 2 -> mostrarAgentes();                
                case 3 -> {
                    if (agentes.isEmpty()) {
                        System.out.println("No hay agentes registrados.");
                        break;
                    }
                    System.out.println("Seleccione un agente para incrementar su nivel:");
                    for (int i = 0; i < agentes.size(); i++) {
                        System.out.println((i + 1) + ". " + agentes.get(i));
                    }
                    int indiceAgente = ConsoleUtils.leerEntero("Ingrese el número del agente: ");
                    ConsoleUtils.limpiarBuffer();
                    if (indiceAgente > 0 && indiceAgente <= agentes.size()) {
                        Agente agente = agentes.get(indiceAgente - 1);
                        agente.incrementarNivel();
                        System.out.println("Nivel del agente incrementado con éxito.");
                    } else {
                        System.out.println("Opción no válida.");
                    }
                }
                case 4 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}