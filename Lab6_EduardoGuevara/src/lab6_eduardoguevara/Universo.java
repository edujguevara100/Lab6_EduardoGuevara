/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6_eduardoguevara;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author edujg
 */
public class Universo {

    private String nombre;
    private ArrayList<SerVivo> hab = new ArrayList();
    private File archivo = null;

    public Universo() {
    }

    public Universo(String nombre) {
        this.nombre = nombre;
        archivo = new File("./" + nombre + ".txt");
        JFileChooser filec = new JFileChooser();
        filec.setSelectedFile(archivo);
        int seleccion = filec.showSaveDialog(null);
        if(seleccion == JFileChooser.APPROVE_OPTION){
            archivo = filec.getSelectedFile();
        }
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre + ".txt";
    }

    public ArrayList<SerVivo> getHab() {
        return hab;
    }

    public void setHab(ArrayList<SerVivo> hab) {
        this.hab = hab;
    }

    public void setPersona(SerVivo a) {
        hab.add(a);
    }

    @Override
    public String toString() {
        return "Universo{" + "nombre=" + nombre + ", hab=" + hab + '}';
    }

    public void guardar() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (SerVivo t : hab) {
                bw.write(t.getRaza() + "|");
                bw.write(t.getKi() + "|");
                bw.write(t.getMaxage() + "|");
                bw.write(t.getPlaneta() + "|");
                bw.newLine();
            }
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bw.close();
        fw.close();
    }

    public void cargar() {
        if (archivo.exists()) {
            Scanner sc = null;
            hab = new ArrayList();
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("[|]");
                while (sc.hasNextLine()) {
                    hab.add(new SerVivo(sc.next(), sc.nextInt(), sc.nextInt(), sc.next()));
                }

            } catch (Exception e) {
            }
            sc.close();
        }
    }
}
