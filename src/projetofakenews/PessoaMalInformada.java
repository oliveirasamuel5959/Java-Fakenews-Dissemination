package projetofakenews;

import java.util.ArrayList;

/**
 * A classe <b>PessoaMalInformada</b> cria pessoas mal informadas no mapa.<br>
 * @author Samuel Patrício de Oliveira
 * @since maio 2023
 * @version 1.0
 */
public class PessoaMalInformada extends Pessoa {
    /**
     * Atributo <b>whatsapp</b> que contém o número de telefone de cada pessoamal.
     */
    String whatsapp;
    /**
     * Atributo <b>telList</b> do tipo ArrayList que contém a lista de contatos de todas as pessoas mal informadas no mapa.
     */
    ArrayList<String> telList = new ArrayList<>();
    
    private FakeNews fakenews; //Classe fakenews
    
    
    /**
     * construtor default <b>PessoaMalInformada</b>.
     */
    public PessoaMalInformada()
    {
        setCor(6);
        this.fakenews = new FakeNews();
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
