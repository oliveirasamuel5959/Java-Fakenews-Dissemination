package projetofakenews;

/**
 * A classe <b>IADestruidoraFakeNews</b> remove pessoas mal informadas do mapa.<br>
 * @author Samuel Patrício de Oliveira
 * @since maio 2023
 * @version 1.0
 */
public class IADestruidoraFakeNews {
    /**
     * Atributo <b>cor</b> utilizado para alterar a cor da pessoa mal informada (red)<br>
     * para pessoa bem informada (azul).
     */
    private int cor = 5;
    
    /**
     * construtor default da classe <b>IADestruidoraFakeNews</b>.
     */
    public IADestruidoraFakeNews() {
    }
    
    /**
     * 
     * @return cor cor da pessoa após destruir a fakenews. 
     */
    public int getCor() {
        return cor;
    }
    
    /**
     * 
     * @param cor cor da pessoa após destruir a fakenews 
     */
    public void setCor(int cor) {
        this.cor = cor;
    }
    
}
