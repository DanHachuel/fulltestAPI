/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dslam.vivo2.metalico.keymile;

import dao.dslam.telnet.ComandoDslam;
import java.math.BigInteger;
import java.util.List;
import model.dslam.consulta.EstadoDaPorta;
import model.dslam.consulta.metalico.TabelaRedeMetalico;
import model.dslam.retorno.TratativaRetornoUtil;
import model.dslam.vivo2.metalico.DslamMetalico;

/**
 *
 * @author G0042204
 */
public abstract class KeymileMetalicoDslam extends DslamMetalico {

    private String srvc;

    public String getSrvc() {
        return srvc;
    }

    public void setSrvc(String srvc) {
        this.srvc = srvc;
    }

    @Override
    public EstadoDaPorta getEstadoDaPorta() throws Exception {
        List<String> admin = this.getCd().consulta(this.getComandoConsultaEstadoAdminDaPorta()).getRetorno();
        List<String> oper = this.getCd().consulta(this.getComandoConsultaEstadoOperDaPorta()).getRetorno();

        String adminState = TratativaRetornoUtil.tratKeymile(admin, "State");
        String operState = TratativaRetornoUtil.tratKeymile(oper, "State");

        EstadoDaPorta portState = new EstadoDaPorta();
        portState.setAdminState(adminState);
        portState.setOperState(operState);

        return portState;
    }

    @Override
    public TabelaRedeMetalico getTabelaRede() throws Exception {
        List<String> lTabs = this.getCd().consulta(this.getTabRede()).getRetorno();

        TabelaRedeMetalico tab = new TabelaRedeMetalico();

        tab.setPctDown(new BigInteger(TratativaRetornoUtil.tratKeymile(lTabs, "Value", 11)));
        tab.setPctUp(new BigInteger(TratativaRetornoUtil.tratKeymile(lTabs, "Value", 14)));
        tab.setCrcDown(new BigInteger(TratativaRetornoUtil.tratKeymile(lTabs, "Value", 19)));
        tab.setCrcUp(new BigInteger(TratativaRetornoUtil.tratKeymile(lTabs, "Value", 26)));
        tab.setFecDown(new BigInteger(TratativaRetornoUtil.tratKeymile(lTabs, "Value", 18)));
        tab.setFecUp(new BigInteger(TratativaRetornoUtil.tratKeymile(lTabs, "Value", 25)));
        tab.setResync(new BigInteger(TratativaRetornoUtil.tratKeymile(lTabs, "Value", 24)));

        return tab;
    }

    public ComandoDslam getTabRede() {
        return new ComandoDslam("get /unit-" + this.getSlot() + "/port-" + this.getPorta() + "/pm/usercountertable", 3000);
    }

    public ComandoDslam getComandoConsultaEstadoAdminDaPorta() {
        return new ComandoDslam("get /unit-" + this.getSlot() + "/port-" + this.getPorta() + "/main/AdministrativeStatus");
    }

    public ComandoDslam getComandoConsultaEstadoOperDaPorta() {
        return new ComandoDslam("get /unit-" + this.getSlot() + "/port-" + this.getPorta() + "/main/OperationalStatus");
    }

    public ComandoDslam getComandoConsultaVlan() {
        return new ComandoDslam("get /services/packet/" + this.getSrvc() + "/cfgm/Service");
    }

}
