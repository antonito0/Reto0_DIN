package modelo;

import java.util.ArrayList;

public class ImplementacionF implements LogInDAO {

    private ArrayList<Usuario> usuarios;

    public ImplementacionF() {
        usuarios = new ArrayList<>();
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        return usuarios;
    }
}