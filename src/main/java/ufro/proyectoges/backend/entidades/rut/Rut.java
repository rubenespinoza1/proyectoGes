/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ufro.proyectoges.backend.entidades.rut;

/**
 * Clase que gestiona operaciones relacionadas con el rut
 * @author shido
 */
public class Rut {

    private String rutSinValidar;
    private String rutSinDv;
    private boolean rutValido;
    private String rutInv;

    /**
     * Constructor de la clase Rut
     * @param rutSinValidar Este parametro entrega un rut, sin validar
     */
    public Rut(String rutSinValidar) {

        this.rutValido = false;
        this.rutSinValidar = rutSinValidar.replace("-", "");
        this.rutSinValidar = rutSinValidar.replace(".", "");
        this.rutSinDv = rutSinValidar.substring(0, rutSinValidar.length() - 1);
        this.rutInv = "";

    }

    /**
     * Este metodo verifica que el rut este bien escrito
     * @param rut Este parametro entrega un rut para validar
     * @return Retorna si el rut esta bien escrito, mediante un boolean
     */
    public static boolean rutBienEscrito(String rut) {
        return rut.matches("[0-9]{7,8}[-]{0,1}[0-9]{1,1}");
    }

    /**
     * Este metodo retorna el rut sin validar
     * @return Retorna el rut sin validar, mediante un String
     */
    public String getRut() {
        return rutSinValidar;
    }

    /**
     * Este metodo invierte el orden de un rut
     * @return Retorna el rut invertido, mediante un String
     */
    private String invertirRut() {
        for (int i = 0; i < rutSinDv.length(); i++) {
            rutInv += rutSinDv.charAt(rutSinDv.length() - i - 1);
        }
        return rutInv;
    }

    /**
     * Este metodo multiplica el rut invertido por indices, y lo suma
     * @return Retorna la suma de esta operacion, mediante un entero
     */
    private int multiplicarPorIndicesYSumar() {
        String rutInv = invertirRut();
        int[] indices = {2, 3, 4, 5, 6, 7};
        int j = 0;
        int suma = 0;
        for (int i = 0; i < rutInv.length(); i++) {
            suma += Integer.parseInt(Character.toString(rutInv.charAt(i))) * indices[j];
            j++;
            if (j == indices.length) {
                j = 0;
            }
        }
        return suma;
    }

    /**
     * Este metodo verifica que el rut es valido
     * @return Retorna si el rut es valido, mediante un boolean
     */
    public boolean isRutValido() {
        return obtenerDigitoVerificado().equals(Character.toString(rutSinValidar.charAt(rutSinValidar.length() - 1)));
    }

    /**
     * Este metodo obtiene el resto de la suma hecha en el metodo multiplicarPorIndicesYSumar
     * @return Retorna el resto
     */
    private int obtenerResto() {
        int suma = multiplicarPorIndicesYSumar();
        return suma % 11;
    }

    /**
     * Este metodo Obtiene el digito verificador del rut
     * @return Retorna el digito verificador del rut
     */
    private String obtenerDigitoVerificado() {
        int DV = 11 - obtenerResto();
        if (DV == 11) {
            return "0";
        } else if (DV == 10) {
            return "k";
        } else {
            return String.valueOf(DV);
        }
    }

    /**
     * Este metodo Retorna el contenido del objeto de esta clase
     * @return retorna el contenido del objeto, mediant un String
     */
    @Override
    public String toString() {
        return "Rut{" + "rutSinValidar=" + rutSinValidar + ", rutSinDv=" + rutSinDv + ", rutValido=" + rutValido + ", rutInv=" + rutInv + '}';
    }

}
