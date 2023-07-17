package projetofakenews;

import java.util.ArrayList;
import java.util.Date;

/**
 * classe <b>Mundo</b> onde é criado o mapa no mundo com as pessoas.<br>
 * A maior parte da lógica de interação das IA's com as pessoas está implementada nesta classe.<br>
 * sendo elas: A troca de whatsapp, propagação de fakenews, lógica onde a pessoa bem informada se torna resistente a fakenews.
 * @author Samuel
 * @version 2.0
 * @since maio 2023
 */
public class Mundo {
    
    ArrayList<PessoaMalInformada> pessoamal = new ArrayList<>(); // declaração objeto do tipo arrayList da classe PessoaMalInformada
    ArrayList<PessoaBemInformada> pessoabem = new ArrayList<>(); // declaração objeto do tipo arrayList da classe PessoaBemInformada
    MeioComunicacaoConfiavel cconfiavel = new MeioComunicacaoConfiavel(); // declaração objeto do tipo arrayList da classe PessoaMalInformada
    
    Date tempo_inicio; // variavel global para o timer de 30s pessoa confiavel
    boolean start_time = false; //tempo de inicio de contagem pessoa confiavel.
    
    // variavel global para contar a quantidade de pessoas confiaveis.
    int count_cconfiavel = 0;
    
    // variavel global para armazenar o tempo que uma pessoa
    // confiavel deve permanecer confiavel e imune a fakenews.
    long timer_pconfiavel = 0;

    // tempo que as pessoas confiaveis permanecerão
    // na tela, sendo incrementado a cada 30s
    int tempo_pconfiavel = 30;
    
    
    //============================================================
    // getters e setters
    //============================================================
    
    /**
     * @return pessoamal - retorna o objeto criado para acessar
     * os atributos e metodos das pessoas mal informadas.
     */
    public ArrayList<PessoaMalInformada> getPessoamal() {
        return pessoamal;
    }

    /**
     * @return cconfiavel objeto do tipo MeioComunicacaoConfiavel.
     */
    public MeioComunicacaoConfiavel getCconfiavel() {
        return cconfiavel;
    }
    
    /**
     * @return timer_pconfiavel tempo onde a pessoa permance resistente a fakenews.
     */
    public long getTimer_pconfiavel() {
        return timer_pconfiavel;
    }
    
    /**
     * Construtor default <b>Mundo</b> onde é chamado o metodo <b>refazMundo</b><br>
     * para atualizar a movimentação das pessoas no mapa.
     */
    public Mundo()
    {
        refazMundo(); // metodo refazMundo para atualizar o terminal.
    }
    
    private int coluna = 1;
    private int[][] mapa;
    
    /**
     * metodo <b>refazMundo</b> criação do mapa utilizando uma matriz 30x60.
     */
    public void refazMundo(){
        mapa = new int[][]
        {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,3,3,3,3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,3,3,3,3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,2,2,2,2,2,2,2,2,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,3,3,3,3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,3,3,3,3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,3,3,3,3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,3,3,3,3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,3,3,3,3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
    }
    
    //=============================================================
    // metodo desenha mundo, criacao do mapa no mundo,
    // onde os primeiros elementos sao as pessoas bem informadas e 
    // os objetos estaticos (as IA's).
    //=============================================================
    /**
     * metodo <b>desenhaMundo</b> criado para desenhar os objetos coloridos no mapa.
     */
    public void desenhaMundo()
    {
        for (int i = 0; i < mapa.length; i++)
        {
            for (int j = 0; j < mapa[i].length; j++)
            {
                switch(mapa[i][j])
                {
                    case 0:
                        System.out.print(" ");
                        break;
                    case 1:
                        System.out.print("\033[47m \033[0m"); //WHITE
                        break;
                    case 2:
                        System.out.print("\033[42m \033[0m"); //GREEN
                        break;
                    case 3:
                        System.out.print("\033[45m \033[0m"); //PURPLE
                        break;
                    case 4:
                        System.out.print("\033[41m \033[0m"); //RED
                        break;
                    case 5:
                        System.out.print("\033[44m \033[0m"); //BLUE
                        break;
                    case 6:
                        System.out.print("\033[41m \033[0m"); //RED
                        break;
                    case 7:
                        System.out.print("\033[43m \033[0m"); //YELLOW
                        break;
                }
               
            }
            
            System.out.println();
        }
        System.out.println();
    }
    
    /**
     * @param pessoabem recebe uma ArrayList do tipo PessoaBemInformada para que no loop principal<br>
     * seja criado todas as pessoas bem informadas no mapa.
     */
    public void colocaMapa(ArrayList<PessoaBemInformada> pessoabem)
    {
        int xAtual, yAtual;

        IAGeradoraFakeNews IAfakenews = new IAGeradoraFakeNews(); //Criacao do objeto IAfakenews
        IADestruidoraFakeNews IAdestruidora = new IADestruidoraFakeNews(); //Criacao do objeto IAdestruidora
        
        // ====================================================================================
        // IAGeradora de fakenews. for-loop que monitora a posição das pessoas no mapa,
        // quando uma pessoa estiver com suas posições x, y dentro da região do retangulo
        // vermelho (IAGeradora de fakenews) sua cor deve mudar, indicando que agora essa
        // pessoa carrega uma fakenews.
        // ====================================================================================
        for (int i = 0; i < pessoabem.size(); i++)
        {      
            if ( (pessoabem.get(i).getX() >= 17 && pessoabem.get(i).getX() <= 23) &&
                 (pessoabem.get(i).getY() >= 22 && pessoabem.get(i).getY() <= 30)  )
            {
                if (pessoabem.get(i).getCor() == cconfiavel.getCor())
                    pessoabem.get(i).setCor(cconfiavel.getCor());
  
                else
                {
                    pessoabem.get(i).setCor(IAfakenews.getCor());
                    pessoamal.add( new PessoaMalInformada() );
                    pessoabem.remove(i);
                }
            }
        }
        
        // for-loop que adiciona as pessoas mal informadas no mapa, logo após entrar na
        // região da IAGeradora de fakenews, colocada numa posição aleatória
        // após se tornar mal informadas.
        for (int i = 0; i < pessoamal.size(); i++)
        {
            xAtual = pessoamal.get(i).getX();
            yAtual = pessoamal.get(i).getY();
            mapa[xAtual][yAtual] = pessoamal.get(i).getCor();
        }
        
        // =====================================================================================
        // IADestruidora de fakenews. for-loop que monitora a posição das pessoas no mapa,
        // quando uma pessoa estiver com suas posições x, y dentro da região do retangulo
        // de cor Rosa (IADestruidora de fakenews) sua cor deve voltar para a cor azul, 
        // indicando que agora essa pessoa voltou a pertencer a classe de pessoas bem informadas.
        // =====================================================================================
        for (int i = 0; i < pessoamal.size(); i++)
        {  
            if ( (pessoamal.get(i).getX() >= 7 && pessoamal.get(i).getX() <= 14) &&
                 (pessoamal.get(i).getY() >= 37 && pessoamal.get(i).getY() <= 46)  )
            {
                pessoamal.get(i).setCor(IAdestruidora.getCor());
                pessoabem.add( new PessoaBemInformada() );
                pessoamal.remove(i);
                
            }
        }
        
        // ====================================================================================
        // Meio de Comunicação confiavel. for-loop que monitora a posição das pessoas
        // bem informadas no mapa, quando uma pessoa bem informada entrar na região do
        // retangulo Verde (IA Meio de Comunicacao confiavel) sua cor deve mudar para amarelo,
        // indicando que agora essa pessoa está imune a fakenews durante 30 segundos
        // ====================================================================================
        for (int i = 0; i < pessoabem.size(); i++)
        {
            
            if ( (pessoabem.get(i).getX() >= 3 && pessoabem.get(i).getX() <= 9) &&
                 (pessoabem.get(i).getY() >= 4 && pessoabem.get(i).getY() <= 12)  )
            {
                
                if (!start_time)
                {
                    tempo_inicio = new Date();
                    start_time = true;
                }
                
                if (pessoabem.get(i).getCor() == IAfakenews.getCor() || pessoabem.get(i).getCor() == 5)
                {   
                    pessoabem.get(i).setCor(cconfiavel.getCor());
                    count_cconfiavel += 1;
                    cconfiavel.setPessoa_cconfiavel(count_cconfiavel);
                }
            }
        }
        
        
        // ====================================================================================
        // for-loop que monitora as pessoas que estão na condição de imune a fakenews, quando
        // o tempo de cada pessoa imune ultrapassar 30 segundos, sua cor deve mudar para azul,
        // indicando que agora essa pessoa voltou a ser apenas bem informada e não imune,
        // correndo o risco de voltar a tornar mal informada ao entrar em contato com as
        // pessoas que carregam fakenews (indicadas pela cor vermelha no mapa).
        // ====================================================================================
        for (int i = 0; i < pessoabem.size(); i++)
        {
            if (pessoabem.get(i).getCor() == cconfiavel.getCor())
            {
               // Date tempo_inicio = new Date();
                
                timer_pconfiavel = cconfiavel.tempo_cconfiavel(tempo_inicio);
                
                //boolean xlimit = pessoabem.get(i).getX() >= 3 && pessoabem.get(i).getX() <= 9;
                //boolean ylimit = pessoabem.get(i).getY() >= 4 && pessoabem.get(i).getY() <= 12;
                
                if (timer_pconfiavel >= tempo_pconfiavel)
                {
                    pessoabem.get(i).setCor(5); //muda a cor da pessoa para pessoabem informada novamente
                    count_cconfiavel -= 1; //Retira a pessoa da classificação de confiavel
                    cconfiavel.setPessoa_cconfiavel(count_cconfiavel); //atualiza a contagem de pessoas confiaveis no mapa
                    
                    tempo_inicio = new Date(); //zera o timer
                }
                else
                {
                    pessoabem.get(i).setCor(cconfiavel.getCor());
                }
            }
        }
        
        
        // for-loop que adiciona as pessoas bem informada no mapa, nas posições aleatórias
        // definida na classe Pessoa
        for (int i = 0; i < pessoabem.size(); i++)
        {
            xAtual = pessoabem.get(i).getX();
            yAtual = pessoabem.get(i).getY();
            
            mapa[xAtual][yAtual] = pessoabem.get(i).getCor();
        }
        
        
        // =======================================================================================================
        // condicao com laço de repetição que monitora pessoas bem e mal informadas para a propagação de fakenews
        // através das pessoas mal informadas.
        // Quando uma pessoa mal informada (cor vermelha) entrar em contato com uma pessoa bem informada (cor azul)
        // sua cor deve mudar para vermelho, indicando que agora também pertence a classe
        // de pessoas mal informadas
        // ========================================================================================================
        for (int i = 0; i < pessoamal.size(); i++)
        {
            for (int j = 0; j < pessoabem.size(); j++)
            {
                // posição onde as pessoas estão ocupando o mesmo espaço no mapa
                // sobrpostas.
                if (pessoamal.get(i).getX() == pessoabem.get(j).getX() &&
                    pessoamal.get(i).getY() == pessoabem.get(j).getY() )
                {
                    
                    if (pessoabem.get(j).getCor() == cconfiavel.getCor() )
                        pessoabem.get(j).setCor(cconfiavel.getCor());
                    else
                    {
                        pessoamal.add( new PessoaMalInformada() );
                        pessoamal.get(i).setTelList(pessoabem.get(j).getWhatsapp());
                        pessoabem.remove(j);
                    }
                }
                
                // posição onde as pessoas estão adjacentes acima
                else if (pessoamal.get(i).getX() == (pessoabem.get(j).getX() - 1) &&
                         pessoamal.get(i).getY() == pessoabem.get(j).getY())
                {
                    if (pessoabem.get(j).getCor() == cconfiavel.getCor() )
                        pessoabem.get(j).setCor(cconfiavel.getCor());
                    else
                    {
                        pessoamal.add( new PessoaMalInformada() );
                        pessoamal.get(i).setTelList(pessoabem.get(j).getWhatsapp());
                        pessoabem.remove(j);
                    }
                }
                
                // posição onde as pessoas estão adjacentes abaixo
                else if (pessoamal.get(i).getX() == (pessoabem.get(j).getX() + 1) &&
                         pessoamal.get(i).getY() == pessoabem.get(j).getY())
                {
                    if (pessoabem.get(j).getCor() == cconfiavel.getCor() )
                        pessoabem.get(j).setCor(cconfiavel.getCor());
                    else
                    {
                        pessoamal.add( new PessoaMalInformada() );
                        pessoamal.get(i).setTelList(pessoabem.get(j).getWhatsapp());
                        pessoabem.remove(j);
                    }
                }
                
                // posição onde as pessoas estão adjacentes lado direito
                else if (pessoamal.get(i).getX() == pessoabem.get(j).getX() &&
                         pessoamal.get(i).getY() == (pessoabem.get(j).getY() - 1))
                {
                    if (pessoabem.get(j).getCor() == cconfiavel.getCor() )
                        pessoabem.get(j).setCor(cconfiavel.getCor());
                    else
                    {
                        pessoamal.add( new PessoaMalInformada() );
                        pessoamal.get(i).setTelList(pessoabem.get(j).getWhatsapp());
                        pessoabem.remove(j);
                    }
                }
                
                // posição onde as pessoas estão adjacentes lado esquerdo
                else if (pessoamal.get(i).getX() == pessoabem.get(j).getX() &&
                         pessoamal.get(i).getY() == (pessoabem.get(j).getY() + 1))
                {
                    if (pessoabem.get(j).getCor() == cconfiavel.getCor() )
                        pessoabem.get(j).setCor(cconfiavel.getCor());
                    else
                    {
                        pessoamal.add( new PessoaMalInformada() );
                        pessoamal.get(i).setTelList(pessoabem.get(j).getWhatsapp());
                        pessoabem.remove(j);
                    }
                }
            }
        }
        
        
        // =======================================================================================================
        // condicao de loop que faz com que as pessoas bem informadas troque seus numeros de whatsapp 
        // ao se encontrarem no mapa.
        // ========================================================================================================
        for (int i = 0; i < pessoabem.size(); i++)
        {
            for (int j = i+1; j < pessoabem.size(); j++)
            {
                // posição onde as pessoas estão ocupando o mesmo espaço no mapa
                // sobrpostas.
                if (pessoabem.get(i).getX() == pessoabem.get(j).getX() &&
                    pessoabem.get(i).getY() == pessoabem.get(j).getY() )
                {
                    
                    pessoabem.get(i).setTelList(pessoabem.get(j).getWhatsapp());
                    pessoabem.get(j).setTelList(pessoabem.get(i).getWhatsapp());
                }
                
                // posição onde as pessoas estão adjacentes acima
                else if (pessoabem.get(i).getX() == (pessoabem.get(j).getX() - 1) &&
                    pessoabem.get(i).getY() == pessoabem.get(j).getY() )
                {
                    
                    pessoabem.get(i).setTelList(pessoabem.get(j).getWhatsapp());
                    pessoabem.get(j).setTelList(pessoabem.get(i).getWhatsapp());
                }
                
                // posição onde as pessoas estão adjacentes abaixo
                else if (pessoabem.get(i).getX() == (pessoabem.get(j).getX() + 1)&&
                    pessoabem.get(i).getY() == pessoabem.get(j).getY() )
                {
                    
                    pessoabem.get(i).setTelList(pessoabem.get(j).getWhatsapp());
                    pessoabem.get(j).setTelList(pessoabem.get(i).getWhatsapp());
                }
                
                // posição onde as pessoas estão adjacentes lado direito
                else if (pessoabem.get(i).getX() == pessoabem.get(j).getX() &&
                    pessoabem.get(i).getY() == (pessoabem.get(j).getY() - 1) )
                {
                    
                    pessoabem.get(i).setTelList(pessoabem.get(j).getWhatsapp());
                    pessoabem.get(j).setTelList(pessoabem.get(i).getWhatsapp());
                }
                
                // posição onde as pessoas estão adjacentes lado esquerdo
                else if (pessoabem.get(i).getX() == pessoabem.get(j).getX() &&
                    pessoabem.get(i).getY() == (pessoabem.get(j).getY() + 1) )
                {
                    
                    pessoabem.get(i).setTelList(pessoabem.get(j).getWhatsapp());
                    pessoabem.get(j).setTelList(pessoabem.get(i).getWhatsapp());
                }
            }
        } 
    }

    
}

