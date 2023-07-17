/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projetofakenews;


import java.util.Date;

/**
 * A classe <b>MeioComunicacaoConfiavel</b> utilizada para alterar a cor das pessoas bem informadas.<br><br>
 * indicando que agora essa pessoa é resistente a fakenews durante 30seg.
 * @author Samuel Patrício de Oliveira
 * @since maio 2023
 * @version 1.0
 */
public class MeioComunicacaoConfiavel {
    /**
     * Atributo cor utilizado para alterar a cor da pessoabem.
     */
    private int cor = 7;
    /**
     * Atributo pessoa_cconfiavel utilizado para contar a quantidade de pessoas confiaveis no mapa.
     */
    private int pessoa_cconfiavel;
    
    /**
     * construtor default.
     */
    public MeioComunicacaoConfiavel() {
    }
    
    /**
     *     * @return cor da pessoa resistente a fakenews.
     */
    public int getCor() {
        return cor;
    }
    
    /**
     * @param cor cor da pessoa resistente a fakenews.
     */
    public void setCor(int cor) {
        this.cor = cor;
    }
    
    /**
     * @return pessoa_cconfiavel
     */
    public int getPessoa_cconfiavel() {
        return pessoa_cconfiavel;
    }
    
    /**
     * @param pessoa_cconfiavel 
     */
    public void setPessoa_cconfiavel(int pessoa_cconfiavel) {
        this.pessoa_cconfiavel = pessoa_cconfiavel;
    }
    
    /**
     * @param initial_time parametro de tempo inicial para resetar o tempo a cada 30seg.
     * @return actual_time - tempo que se passou a partir do momento que uma pessoa<br>
     * entrou na regiao do objeto <b>MeioComunicacaoConfiavel</b>.
     */
    public long tempo_cconfiavel(Date initial_time)
    {
        Date current_time = new Date();
        long actual_time = (current_time.getTime() - initial_time.getTime() ) / 1000;
        
        return actual_time;
    }
}
