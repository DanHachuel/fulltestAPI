/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.validacao.realtime.gpon;

import br.net.gvt.efika.customer.EfikaCustomer;
import dao.dslam.impl.ConsultaGponDefault;
import model.validacao.ValidacaoVlanVod;
import model.validacao.realtime.ValidacaoRealtimeGpon;

/**
 *
 * @author G0042204
 */
public class ValidacaoRtVlanVod extends ValidacaoRealtimeGpon {

    private ValidacaoVlanVod valid;

    public ValidacaoRtVlanVod(ConsultaGponDefault dslam, EfikaCustomer cust) {
        super(dslam, cust, "Vlan VoD");
    }

    @Override
    public Boolean validar() {
        try {
            valid = new ValidacaoVlanVod(consultaGpon.getVlanVod(cust.getRede()), cust);
            valid.validar();
            this.merge(valid);
            return valid.getResultado();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
