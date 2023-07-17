package projetofakenews;

import java.util.ArrayList;

/**
 * A classe <b>PessoaBemInformada</b> cria pessoas bem informadas no mapa.<br>
 * @author Samuel Patrício de Oliveira
 * @since maio 2023
 * @version 1.0
 */
public class PessoaBemInformada extends Pessoa{
    /**
     * Atributo <b>whatsapp</b> que contém o número de telefone de cada pessoabem.
     */
    String whatsapp;
    /**
     * Atributo <b>telList</b> do tipo ArrayList que contém a lista de contatos de todas as pessoas bem informadas no mapa.
     */
    ArrayList<String> telList = new ArrayList<>();
   
    /**
     * construtor default <b>PessoaBemInformada</b>.
     */
    public PessoaBemInformada()
    {
        setCor(5);
    }
    
    /**
     * @return whatsapp 
     */
    public String getWhatsapp() {
        return whatsapp;
    }
    
    /**
     * @param whatsapp 
     */
    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }
    
    /**
     * @return telList 
     */
    public ArrayList<String> getTelList() {
        return telList;
    }
    
    /**
     * @param telNumero 
     */
    public void setTelList(String telNumero) {
        telList.add(telNumero);
    }
    
}
