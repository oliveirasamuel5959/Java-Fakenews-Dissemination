package projetofakenews;

import java.util.Random;

/**
 * A classe <b>Pessoa</b> cria pessoas no mapa em posições aleatórias.
 * @author Samuel Patrício de Oliveira.
 * @since maio 2023
 * @version 1.0
 */
public class Pessoa implements Imovable {
    /**
     * Atributo Random utilizado para gerar valores inteiros aleatórios de posição das pessoas.
     */
    public Random numAleatorio = new Random();
    /**
     * Atributos de posição (x,y) das pessoas no mapa e a velocidade de movimento.
     */
    private int x, y, cor, velocidade = 1;
    
    /**
     * Construtor default da classe <b>Pessoa</b>.<br><br>
     * <b>uso:</b><br>
     * Uso exclusivo das classes <b>PessoaBemInformada</b> e <b>PessoaMalInformada</b><br>
     * Onde essas classes irão gerar as pessoas no mapa.
     */
    public Pessoa()
    {
        setX(numAleatorio.nextInt(30));
        setY(numAleatorio.nextInt(60));
    }
    
    /**
     * 
     * @return x - posição x da pessoa no mapa.
     */
    public int getX() {
        return x;
    }
    
    /**
     * @param x da posição da pessoa no mapa.
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * @return y - da posição y da pessoa no mapa.
     */
    public int getY() {
        return y;
    }
    
    /**
     * @param y da posição da pessoa no mapa.
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * @return cor
     */
    public int getCor() {
        return cor;
    }

    /**
     * @param cor 
     */
    public void setCor(int cor) {
        this.cor = cor;
    }
    
    /**
     * @return velocidade.
     */
    public int getVelocidade() {
        return velocidade;
    }
    
    /**
     * @param velocidade 
     */
    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }
    
    /**
     * metodo <b>mover</b> utilizado para movimentar as pessoas no mapa.
     */
    @Override
    public void mover()
    {
        int move = numAleatorio.nextInt(4);
        switch(move)
        {
            case 0: // move para cima
                y -= getVelocidade();
                if (y < 0)
                {
                    y += 60;
                }
                else if (y > 59)
                {
                    y -= 60;
                }break;
                
            case 1: // move para baixo
                y += getVelocidade();
                if (y < 0)
                {
                    y += 60;
                }
                else if (y > 59)
                {
                    y -= 60;
                }break;
            
            case 2: // move para direita
                x += getVelocidade();
                if (x < 0)
                {
                    x += 30;
                }
                else if (x > 29)
                {
                    x -= 30;
                }break;
            
            case 3: // move para esquerda
                x -= getVelocidade();
                if (x < 0)
                {
                    x += 30;
                }
                else if (x > 29)
                {
                    x -= 30;
                }break;
                
            default:
                break;
        }
    }
            
           
}
