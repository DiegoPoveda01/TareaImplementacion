package data;

import model.DispositivoTecnologico;
import model.Notebook;
import model.Tablet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Data {
    private String csvFilePath = "dispositivos.csv";

    public List<DispositivoTecnologico> leerCSV() {
        List<DispositivoTecnologico> dispositivos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String linea;
            reader.readLine();

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 11) {
                    String tipo = partes[0];
                    String modelo = partes[1];
                    String marca = partes[2];
                    String procesador = partes[3];
                    String ram = partes[4];
                    String resolucionPantalla = partes[5];
                    String almacenamiento = partes[6];
                    String precio = partes[7];
                    int añoFabricacion = Integer.parseInt(partes[8]);
                    int stock = Integer.parseInt(partes[9]);

                    DispositivoTecnologico dispositivo;

                    if (tipo.equals("Tablet")) {
                        dispositivo = new Tablet(marca, ram, almacenamiento, procesador, modelo, añoFabricacion, precio, resolucionPantalla, new ArrayList<>());
                    } else if (tipo.equals("Notebook")) {
                        dispositivo = new Notebook(marca, ram, almacenamiento, procesador, modelo, añoFabricacion, precio, resolucionPantalla, "", "");
                    } else {
                        dispositivo = new DispositivoTecnologico(marca, ram, almacenamiento, procesador, modelo, añoFabricacion, precio) {
                            @Override
                            public String getTipo() {
                                return "Tipo Desconocido";
                            }
                        };
                    }

                    dispositivo.setStock(stock);
                    dispositivos.add(dispositivo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dispositivos;
    }

    public void escribirCSV(List<DispositivoTecnologico> dispositivos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath))) {
            writer.println("Tipo,Modelo,Marca,Procesador,RAM,ResolucionPantalla,Almacenamiento,Precio,AñoFabricacion,Stock");

            for (DispositivoTecnologico dispositivo : dispositivos) {
                String tipo = dispositivo.getTipo();
                String modelo = dispositivo.getModelo();
                String marca = dispositivo.getMarca();
                String procesador = dispositivo.getProcesador();
                String ram = dispositivo.getMemoriaRam();
                String resolucionPantalla = (dispositivo instanceof Tablet) ? ((Tablet) dispositivo).getResolucionDePantalla() : "";
                String almacenamiento = dispositivo.getMemoriaAlmacenamiento();
                String precio = dispositivo.getPrecio();
                int añoFabricacion = dispositivo.getAñoDeFabricacion();
                int stock = dispositivo.getStock();

                writer.println(tipo + "," + modelo + "," + marca + "," + procesador + "," + ram + "," +
                        resolucionPantalla + "," + almacenamiento + "," + precio + "," + añoFabricacion + "," + stock);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al escribir en el archivo CSV.");
        }
    }
}
