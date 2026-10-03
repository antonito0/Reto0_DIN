package modelo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ImplementacionFichero {

    // ============================
    //   RELLENAR FICHERO (fillData)
    // ============================
    public static void fillData(File fichero) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            // ADMIN
            Admin admin1 = new Admin("admin1", "1234", "Mireia", "Lopez");
            Admin admin2 = new Admin("admin2", "abcd", "Carlos", "Perez");
            // EMPLEADOS
            Empleado emp1 = new Empleado("ES9820385778983000760234", "emple1", "pass1", "Lucia", "Martinez");
            Empleado emp2 = new Empleado("ES7621000814561234567890", "emple2", "pass2", "Jon", "Garcia");
            // USUARIOS
            Usuario usu1 = new Usuario("12345678A", LocalDate.of(2000, 5, 12), "usu1", "1111", "Mikel", "Lopez");
            Usuario usu2 = new Usuario("98765432B", LocalDate.of(1998, 3, 20), "usu2", "2222", "Ane", "Santos");

            // GUARDAR EN EL FICHERO
            oos.writeObject(admin1);
            oos.writeObject(admin2);
            oos.writeObject(emp1);
            oos.writeObject(emp2);
            oos.writeObject(usu1);
            oos.writeObject(usu2);

            System.out.println("Datos creados correctamente.");
        } catch (IOException e) {
            System.out.println("Error escribiendo el fichero.");
        }
    }

    public Admin verAdmin(File fichO) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichO))) {
            boolean fin = false;
            while (!fin) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Admin) {
                        return (Admin) obj; // primer admin que encuentre
                    }
                } catch (EOFException e) {
                    fin = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error leyendo admin");
        }
        return null;
    }

    public void actualizarAdmin(File fichO, Admin adminActualizado) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichO))) {
            oos.writeObject(adminActualizado);
        } catch (Exception e) {
            System.out.println("Error actualizando admin");
        }
    }
    public List<Empleado> leerEmpleados(File fichO) {
        List<Empleado> lista = new ArrayList<>();
        boolean fin = false;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichO))) {
            while (!fin) {
                try {
                    Object obj = ois.readObject();
                    if (obj instanceof Empleado) {
                        lista.add((Empleado) obj);
                    }
                } catch (EOFException e) {
                    fin = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Error leyendo empleados");
        }

        return lista;
    }

    // Actualizar un empleado concreto (por usuario)
    public void actualizarEmpleado(File fichO, Empleado empActualizado) {

        List<Empleado> lista = leerEmpleados(fichO);

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getUsuario().equals(empActualizado.getUsuario())) {
                lista.set(i, empActualizado);
            }
        }

        // Reescribir SOLO empleados (si quieres mantener admins/usuarios, habría que leer todo y filtrar)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichO))) {
            // Aquí solo escribo empleados; si quieres mantener admins y usuarios, hay que ampliar esto
            for (Empleado e : lista) {
                oos.writeObject(e);
            }
        } catch (Exception e) {
            System.out.println("Error actualizando empleado");
        }
    }
    
    public void insertarEmpleado(File fichO, Empleado emp) {

    // Si el fichero ya existe, hacemos APPEND sin cabecera
    if (fichO.exists()) {
        try (MyObjectOutputStream moos = new MyObjectOutputStream(new FileOutputStream(fichO, true))) {
            moos.writeObject(emp);
        } catch (Exception e) {
            System.out.println("Error insertando empleado");
        }

    // Si el fichero NO existe, lo creamos con cabecera normal
    } else {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichO))) {
            oos.writeObject(emp);
        } catch (Exception e) {
            System.out.println("Error creando fichero y escribiendo empleado");
        }
    }
}

}
