/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.validacao.realtime.gpon;

import br.net.gvt.efika.customer.EfikaCustomer;
import dao.dslam.impl.ConsultaGponDefault;
import exception.MetodoNaoImplementadoException;
import model.validacao.ValidacaoVlanMulticast;
import model.validacao.realtime.ValidacaoRealtimeGpon;

/**
 *
 * @author G0042204
 */
public class ValidacaoRtVlanMulticast extends ValidacaoRealtimeGpon {

    private ValidacaoVlanMulticast valid;

    public ValidacaoRtVlanMulticast(ConsultaGponDefault dslam, EfikaCustomer cust) {
        super(dslam, cust, "Vlan Multicast");
    }

    @Override
    public Boolean validar() throws Exception {
        try {
            valid = new ValidacaoVlanMulticast(consultaGpon.getVlanMulticast(cust.getRede()), cust);
            valid.validar();
            this.merge(valid);
            return valid.getResultado();
        } catch (MetodoNaoImplementadoException ex) {
            throw ex;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
