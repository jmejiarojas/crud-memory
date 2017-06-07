package pe.edu.cibertec.crudproveedoresmemory;

import java.io.Serializable;

/**
 * Created by mejia on 07/06/2017.
 */

public class ProveedorEntity implements Serializable {

    //private static final long serialVersionUID = 1L;

    private int codigo;
    private String razonSocial;
    private String direccion;
    private String ruc;

    public ProveedorEntity() {

    }

    public ProveedorEntity(int codigo, String razonSocial, String direccion, String ruc) {
        this.codigo = codigo;
        this.razonSocial = razonSocial;
        this.direccion = direccion;
        this.ruc = ruc;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
}
