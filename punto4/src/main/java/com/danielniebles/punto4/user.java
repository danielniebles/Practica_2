package com.danielniebles.punto4;

/**
 * Created by Daniel on 25/08/2016.
 */
public class user {

        private String usuario, email, sexo, ciudad;
        StringBuilder fecha;
        StringBuilder hobbie;

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSexo() {
            return sexo;
        }

        public void setSexo(String sexo) {
            this.sexo = sexo;
        }

        public String getCiudad() {
            return ciudad;
        }

        public void setCiudad(String ciudad) {
            this.ciudad = ciudad;
        }

        public StringBuilder getFecha() {
            return fecha;
        }

        public void setFecha(StringBuilder fecha) {
            this.fecha = fecha;
        }

    public StringBuilder getHobbie() {
        return hobbie;
    }

    public void setHobbie(StringBuilder hobbie) {
        this.hobbie = hobbie;
    }
}
