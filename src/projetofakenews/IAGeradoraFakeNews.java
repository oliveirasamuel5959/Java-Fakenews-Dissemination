package projetofakenews;

/**
 * A classe <b>IAGeradoraFakeNews</b> altera a cor das pessoas bem informadas no mapa.<br>
 * @author Samuel Patrício de Oliveira
 * @since maio 2023
 * @version 1.0
 */
public class IAGeradoraFakeNews 
{   
    /**
     * Atributo <b>cor</b> utilizado para alterar a cor da pessoa bem informada (azul)<br>
     * para pessoa mal informada (vermelho).
     */
    private int cor = 6;
    /**
     * construtor default da classe <b>IAGeradoraFakeNews</b>.
     */
    public IAGeradoraFakeNews() 
    {
        
    }
    /**
     * 
     * @return cor cor da pessoa após colocar uma fakenews. 
     */
    public int getCor() {
        return cor;
    }
    /**
     * 
     * @param cor cor da pessoa após colocar uma fakenews. 
     */
    public void setCor(int cor) {
        this.cor = cor;
    }
    
    
}
