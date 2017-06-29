/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.dslam.impl.gpon.zhone;

import br.net.gvt.efika.customer.EfikaCustomer;
import br.net.gvt.efika.customer.InventarioRede;
import model.dslam.consulta.EstadoDaPorta;
import model.dslam.consulta.Profile;
import model.dslam.consulta.VlanBanda;
import model.dslam.consulta.VlanMulticast;
import model.dslam.consulta.VlanVod;
import model.dslam.consulta.VlanVoip;
import model.dslam.consulta.gpon.AlarmesGpon;
import model.dslam.consulta.gpon.SerialOntGpon;
import model.dslam.consulta.gpon.TabelaParametrosGpon;
import model.fulltest.operacional.CustomerMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G0042204
 */
public class ZhoneGponDslamTest {

    private EfikaCustomer cl = CustomerMock.gponZhone();

    public ZhoneGponDslamTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
        instance.desconectar();
    }

    ZhoneGponDslam instance = new ZhoneGponDslam(CustomerMock.gponZhone().getRede().getIpDslam());
    InventarioRede i = CustomerMock.gponZhone().getRede();

    /**
     * Test of getTabelaParametros method, of class ZhoneGponDslam.
     */
    @Test
    public void testGetTabelaParametros() {
        try {
            TabelaParametrosGpon result = instance.getTabelaParametros(cl.getRede());
            assertTrue(result.getPotOlt() != null);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test of getSerialOnt method, of class ZhoneGponDslam.
     */
    @Test
    public void testGetSerialOnt() {
        System.out.println("getSerialOnt");
        try {
            SerialOntGpon result = instance.getSerialOnt(i);
            assertTrue(result.getSerial() != null);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * Test of getEstadoDaPorta method, of class ZhoneGponDslam.
     */
    @Test
    public void testGetEstadoDaPorta() throws Exception {
        System.out.println("getEstadoDaPorta");
        try {
            EstadoDaPorta result = instance.getEstadoDaPorta(i);
            assertTrue(result.getAdminState() != null);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test of getVlanBanda method, of class ZhoneGponDslam.
     */
    @Test
    public void testGetVlanBanda() throws Exception {
        System.out.println("getVlanBanda");
        try {
            VlanBanda result = instance.getVlanBanda(i);
            assertTrue(!result.getSvlan().equals(0));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test of getVlanVoip method, of class ZhoneGponDslam.
     */
    @Test
    public void testGetVlanVoip() throws Exception {
        System.out.println("getVlanVoip");
        try {
            VlanVoip result = instance.getVlanVoip(i);
            assertTrue(!result.getSvlan().equals(0));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test of getVlanVod method, of class ZhoneGponDslam.
     */
    @Test
    public void testGetVlanVod() throws Exception {
        System.out.println("getVlanVod");
        try {
            VlanVod result = instance.getVlanVod(i);
            assertTrue(!result.getSvlan().equals(0));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test of getVlanMulticast method, of class ZhoneGponDslam.
     */
    @Test
    public void testGetVlanMulticast() throws Exception {
        System.out.println("getVlanMulticast");
        try {
            VlanMulticast result = instance.getVlanMulticast(i);
            assertTrue(!result.getSvlan().equals(0));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test of getAlarmes method, of class ZhoneGponDslam.
     */
    @Test
    public void testGetAlarmes() throws Exception {
        System.out.println("getAlarmes");
        try {
            AlarmesGpon result = instance.getAlarmes(i);
            assertTrue(result.getListAlarmes() != null);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test of getProfile method, of class ZhoneGponDslam.
     */
    @Test
    public void testGetProfile() throws Exception {
        System.out.println("getProfile");
        try {
            Profile result = instance.getProfile(i);
            assertTrue(result.getProfileDown() != null);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    /**
     * Test of setOntToOlt method, of class ZhoneGponDslam.
     */
    @Test
    public void testSetOntToOlt() {
        System.out.println("setOntToOlt");
        try {
            SerialOntGpon s = new SerialOntGpon();
            s.setSerial("PACED8A7ED87");
            SerialOntGpon result = instance.setOntToOlt(i, s);
            assertTrue(result.getSerial().equalsIgnoreCase("PACED8A7ED87"));
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

}
