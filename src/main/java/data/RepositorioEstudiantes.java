package data;

import modelo.Estudiante;

import java.sql.*;

public class RepositorioEstudiantes {

    private Connection conexion;

    public RepositorioEstudiantes(Connection conexion){
        this.conexion = conexion;

    }

    public void agregarEstudiante(Estudiante unEstudiante) {
        try (Statement sentenciaInsert = conexion.createStatement()) {
            String insert = "insert into Estudiante (numero, nombre, genero, especie, blood_status, id_casa) values (";
            insert += unEstudiante.getNumero() + ", '";
            insert += unEstudiante.getNombre() + "', '";
            insert += unEstudiante.getGenero() + "', '";
            insert += unEstudiante.getEspecie() + "', '";
            insert += unEstudiante.getBlodStatus() + "', ";
            insert += unEstudiante.getCasa().getIdCasa()+ ")";
            sentenciaInsert.executeUpdate(insert);
        }
        catch (SQLException ex) {
            System.out.println("Error al agregar estudiante: \n" + ex.getMessage());
            ex.printStackTrace();
        }
    }
    

    }


