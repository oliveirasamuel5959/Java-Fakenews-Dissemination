package projetofakenews;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Main classe <b>ProjetoFakeNews</b> codigo que contém o loop-infinito.<br>
 * onde é gerado as pessoas bem informadas no mapa e coletas as informações do usuário
 * @author Samuel Patrício de Oliveira
 * @since maio 2023
 * @version 1.0
 */
public class ProjetoFakeNews {
    public static void main(String[] args) {
        
        Mundo m = new Mundo();
        ArrayList<PessoaBemInformada> pessoabem = new ArrayList<>();
        ArrayList<String> novaLista = new ArrayList<>();
        
        Scanner stdin = new Scanner(System.in);
        
        int total_pessoas = 0; //numero total de pessoas no mapa
        String telNum;
        int pessoasNum; //entrada do usuario (numero de pessoas)
        
        
        Date tempo_inicio = new Date();
        
        System.out.println("Digite o numero de pessoas no mundo: ");
        pessoasNum = stdin.nextInt();
        
        
        /// ===============================================================
        // coloca no numero da pessoa criada como index a partir do zero
        // quando uma pessoa é criado, é colocado seu index como se fosse
        // a referencia para o número de whatsapp dessa pessoa.
        /// ===============================================================
        for (int i = 0; i < pessoasNum; i++)
        {
            String s = String.valueOf(i);
            pessoabem.add( new PessoaBemInformada() );
            pessoabem.get(i).setWhatsapp(s);
        }
        
        while(true)
        {
            m.refazMundo();
            
            // move as pessoas bem informadas no mapa
            for (int i = 0; i < pessoabem.size(); i++)
            {
                pessoabem.get(i).mover();
            }
            
            // coloca pessoa bem informada no mapa
            m.colocaMapa(pessoabem);
            
            // move as pessoas mal informadas no mapa
            for (int i = 0; i < m.getPessoamal().size(); i++)
            {
                m.getPessoamal().get(i).mover();
            }
            
            Date current_time = new Date();
            
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("=============================================================================");
            System.out.println("Tempo de simulacao: " + (current_time.getTime() - tempo_inicio.getTime()) / 1000);
            System.out.println("cconfiavel timer: " + m.getTimer_pconfiavel());
            System.out.println();
            
            
            // mostra no cabeçalho a lista de telefone das pessoas bem informadas
            System.out.print("(numero telefone) bem informadas: ");
            for (PessoaBemInformada num : pessoabem)
            {
               novaLista = removeDuplicates(num.getTelList());
               System.out.print("p" + novaLista + " ");
            }
            System.out.println();
            
            
            // mostra no cabeçalho a lista de telefone das pessoas bem informadas
            System.out.print("(numero telefone) mal informadas: ");
            for (int i = 0; i < m.getPessoamal().size(); i++)
            {
               System.out.print("p" + m.getPessoamal().get(i).getTelList() + " ");
            }
            
            // ======================================
            // configuração da legenda no terminal
            // ======================================
            System.out.println();
            System.out.println("_____________________Legenda__________________________");
            System.out.println();
            System.out.print("\u001b[44m \033[0m Bem Informadas: " + ( pessoabem.size() - m.getCconfiavel().getPessoa_cconfiavel() ) );
            System.out.println("         \u001b[45m \033[0m IA DestruidoraFakeNews ");
            
            System.out.print("\u001b[41m \033[0m Mal Informadas: " + m.getPessoamal().size() + "      ");
            System.out.println("    \u001b[41m \033[0m IA GeradoraFakenews ");
            
            System.out.print("\u001b[43m \033[0m Confiaveis: " + m.getCconfiavel().getPessoa_cconfiavel() + "          ");
            System.out.println("    \u001b[42m \033[0m IA ComunicacaoConfiavel ");
            
            total_pessoas = (int)pessoabem.size() + (int)m.getPessoamal().size();
            
            System.out.println("Total de pessoas: " + total_pessoas);
            System.out.println();
            m.desenhaMundo();
            
            
            // =================================
            // atualiza o terminal a cada 500ms
            // =================================
            try{
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    
    // ======================================================================================
    // metodo removeDuplicates criado para remover numeros ja existentes na lista de contatos
    // de cada pessoa. Remove elementos repetidos no arrayList<String> telList de cada pessoa
    // ======================================================================================
    
    /**
     * Metodo <b>removeDuplicates</b> criado para remover elementos repetitivos </br>
     * da lista de contato das pessoas bem informadas. Quando uma pessoa encontrar com</br>
     * a mesma pessoa da lista, ela não deve adicionar novamente seu contato.
     * @param <String> recebe a lista dos numeros de whatsapp das pessoas.
     * @param list variavel list de controle
     * @return newList retorna a lista dos numeros de whatsapp das pessoas sem repetições
     */
    public static <String> ArrayList<String> removeDuplicates(ArrayList<String> list)
    {
  
        // Create a new ArrayList
        ArrayList<String> newList = new ArrayList<>();
  
        // Traverse through the first list
        for (String element : list) {
  
            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {
  
                newList.add(element);
            }
        }
  
        // return the new list
        return newList;
    }
    
}
