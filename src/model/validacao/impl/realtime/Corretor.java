/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.validacao.impl.realtime;

import br.net.gvt.efika.customer.EfikaCustomer;
import dao.dslam.factory.exception.CorrecaoInterruptoraException;
import dao.dslam.factory.exception.FalhaAoCorrigirException;
import dao.dslam.factory.exception.FuncIndisponivelDslamException;
import dao.dslam.impl.AbstractDslam;
import dao.dslam.impl.AlteracaoClienteInter;
import java.util.Locale;
import model.validacao.impl.both.ValidacaoResult;

/**
 *
 * @author G0042204
 */
public abstract class Corretor extends Validador {

    protected AlteracaoClienteInter alter;

    protected Validador validador;

    public Corretor(AbstractDslam dslam, EfikaCustomer cust, Locale local) {
        super(dslam, cust, local);
    }

    @Override
    public Object getObject() {
        return validador.getObject();
    }

    @Override
    protected void iniciar() throws FuncIndisponivelDslamException {
        super.iniciar();
        if (this.getDslam() instanceof AlteracaoClienteInter) {
            this.alter = (AlteracaoClienteInter) this.getDslam();
        } else {
            throw new FuncIndisponivelDslamException();
        }
    }

    @Override
    public ValidacaoResult validar() throws Exception{
        try {
            iniciar();
            this.valid = consultar();
            processar();
            if (this.valid.getResultado()) {
                return new ValidacaoResult(valid.getNome(), valid.getMensagem(), valid.getResultado(), valid.getObject(), Boolean.FALSE);
            } else {
                try {
                    corrigir();
                    return new ValidacaoResult(valid.getNome(), fraseCorrecaoOk(), Boolean.FALSE, valid.getObject(), Boolean.TRUE);
                } catch (FalhaAoCorrigirException e) {
                    return new ValidacaoResult(valid.getNome(), fraseFalhaCorrecao(), Boolean.FALSE, valid.getObject(), Boolean.FALSE);
                }
            }
        } catch (Exception ex) {
            if(ex instanceof CorrecaoInterruptoraException){
                throw ex;
            }
            ex.printStackTrace();
            return null;
        }
    }

    protected abstract void corrigir() throws FalhaAoCorrigirException;

    protected abstract String fraseCorrecaoOk();

    protected abstract String fraseFalhaCorrecao();

}
