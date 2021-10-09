package test;

import com.company.controller.comprador.CompradorController;
import com.company.controller.comprador.IComprador;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author JUS
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//testear en orden deacuerdo al nombre
public class Pruebas {

    IComprador service;

    public Pruebas() {
        service = new CompradorController();
    }

//    @Test
//    public void t1_0_pruebaAdd() {
//        String data[] = {"5034343", "Pedro", "salas", "pedro@", "43423343"};
//        String response = service.addC(data);
//        assertEquals("Comprador guardado exitosamente", response);
//    }
    @Test
    public void t1_0_pruebaBuscar() {
        String[] data = {"504320198", "Justin", "Salazar", "justin@", "62890177"};
        String[] response = service.find("504320198");
        Assert.assertArrayEquals(data, response);
    }

//    @Test
//    public void t1_3_pruebaDelete() {
//        String id = "5034343";
//        String resp = service.deleteC(id);
//        assertEquals("Comprador eliminado exitosamente", resp);
//    }
    @Test
    public void t1_3_pruebaGetAll() {

        String[][] dataC = service.getAll();
        System.out.println("\n\n-------------------------");

        for (int i = 0; i < dataC.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(dataC[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("\n\n-------------------------");
    }
}
