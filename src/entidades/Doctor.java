package entidades;
import java.io.Serializable;

public class Doctor implements Serializable {
        private String id, cita, nombre, apellidoPat, apellidoMat, especializacion, edad;

        public Doctor(String id, String nombre, String apellidoPat, String apellidoMat, String edad, String especializacion)
        {

        }

        public Doctor(String n)
        {

            this.nombre = n;
        }

    public Doctor() {
        System.out.println("");
    }


    public void setEspecializacion(String especializacion)
        {
            this.especializacion = especializacion;
        }
    public String getEspecializacion()
    {

        return especializacion;
    }

    public void setID(String id)
    {
        this.id = id;
    }
    public String getID()
    {

        return id;
    }
    public void setCita(String cita)
    {
        this.cita = cita;
    }
        public String getCita()
        {
            return cita;
        }

        public String getNombre()
        {
            return nombre;
        }

        public void setNombre(String nombre)
        {
            this.nombre = nombre;
        }

        public String getApellidoPat()
        {
            return apellidoPat;
        }

        public void setApellidoPat(String apellidoPat)
        {
            this.apellidoPat = apellidoPat;
        }

        public String getApellidoMat()
        {
            return apellidoMat;
        }

        public void setApellidoMat(String apellidoMat)
        {
            this.apellidoMat = apellidoMat;
        }

        public String getEdad()
        {
            return edad;
        }

        public void setEdad(String edad) {
            this.edad = edad;
        }


}
