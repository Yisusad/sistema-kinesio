package modelos;

import java.util.Date;

/**
 *
 * @author Jesús
 */
public class EstudioDerivacion {
    
    int IdEstudio;
    int IdDerivacion;
    String Descripcion;
    Date Fecha;
    String Resultado;
    
    public int getIdEstudio() {
        return IdEstudio;
    }

    public void setIdEstudio(int IdEstudio) {
        this.IdEstudio = IdEstudio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getIdDerivacion() {
        return IdDerivacion;
    }

    public void setIdDerivacion(int IdDerivacion) {
        this.IdDerivacion = IdDerivacion;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }

   
    
}
