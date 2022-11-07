package br.com.alura.comex.config.validacao;

public class ErroValidacaoDTO {

    private String campo;
    private String erro;

    public ErroValidacaoDTO(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
