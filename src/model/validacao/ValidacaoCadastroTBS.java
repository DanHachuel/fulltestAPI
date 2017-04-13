/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.validacao;

import bean.ossturbonet.oss.gvt.com.GetInfoOut;
import com.gvt.www.ws.eai.oss.OSSTurbonetInconsistenciaTBSRadius.OSSTurbonetInconsistenciaTBSRadiusOut;

/**
 *
 * @author G0042204
 */
public class ValidacaoCadastroTBS extends Validacao {

    private GetInfoOut info;

    private OSSTurbonetInconsistenciaTBSRadiusOut i;

    public ValidacaoCadastroTBS(GetInfoOut info, OSSTurbonetInconsistenciaTBSRadiusOut i) {
        this.info = info;
        this.i = i;
        this.nome = "Cadastro TBS";
        if(!i.getEhInconsistente() && info != null && info.getInfoTBS().getStatus().equalsIgnoreCase("ATIVO")){
//            this.setDiagnostico(Boolean.TRUE);
            this.setMensagem("Cadastro TBS x Radius correto");
        }else{
//            this.setDiagnostico(Boolean.FALSE);
            this.setMensagem("Divergência no cadastro TBS x Radius");
        }
    }

    /**
     * Implementar!
     *
     * @return
     */
    @Override
    public Boolean validar() {
        return !i.getEhInconsistente() && info != null && info.getInfoTBS().getStatus().equalsIgnoreCase("ATIVO");
    }
}
