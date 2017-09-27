/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dslam.consulta;

import br.net.gvt.efika.customer.EfikaCustomer;
import model.validacao.Validavel;

/**
 *
 * @author G0041775
 */
public abstract class VlanAbstract implements Validavel {

    private Integer cvlan;

    private Integer svlan;

    private EnumEstadoVlan state;

    private String name = getNome();

    public String getName() {
        return name;
    }

    public void setName(String oi) {
        this.name = oi;
    }

    public VlanAbstract(Integer cvlan, Integer svlan, EnumEstadoVlan estado) {
        this.cvlan = cvlan;
        this.svlan = svlan;
        this.state = estado;
    }

    @Deprecated
    public VlanAbstract(Integer p100, Integer cvlan) {
        this.cvlan = p100;
        this.svlan = cvlan;
        this.state = EnumEstadoVlan.UP;
    }

    public EnumEstadoVlan getState() {
        return state;
    }

    public void setState(EnumEstadoVlan state) {
        this.state = state;
    }

    public Integer getCvlan() {
        return cvlan;
    }

    public void setCvlan(Integer cvlan) {
        this.cvlan = cvlan;
    }

    public Integer getSvlan() {
        return svlan;
    }

    public void setSvlan(Integer svlan) {
        this.svlan = svlan;
    }

    @Override
    public abstract Boolean validar(EfikaCustomer e);

}
