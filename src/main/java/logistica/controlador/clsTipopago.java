/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica.controlador;



/**
 *
 * @author carlos
 */

/*
    private int perid;
    private String pernombre;
    private String perestatus; 
*/
public class clsTipopago {
    int tipcodigo;
    String tipnombre;
    String tipestatus;

    public clsTipopago() {
    }

    public clsTipopago(int codigo) {
        this.tipcodigo= codigo;
    }

    public clsTipopago(String nombre, String estado) {
        this.tipnombre = nombre;
   
    }

    public int getTipcodigo() {
        return tipcodigo;
    }

    public void setTipcodigo(int codigo) {
        this.tipcodigo = codigo;
    }

    public String getTipnombre() {
        return tipnombre;
    }

    public void setTipnombre(String nombre) {
        this.tipnombre = nombre;
    }

   
    @Override
    public String toString() {
        return "tbl_tipegas{" + "tipcodigo=" + tipcodigo + ", tipnombre=" + tipnombre + '}';
    }
    
}
