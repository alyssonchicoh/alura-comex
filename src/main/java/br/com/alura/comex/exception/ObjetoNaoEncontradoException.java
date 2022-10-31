package br.com.alura.comex.exception;

public class ObjetoNaoEncontradoException extends RuntimeException{

    public ObjetoNaoEncontradoException(String nomeObjeto){
        super("Id do objeto "+nomeObjeto + " não foi encontrado no banco de dados");
    }
}
