import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Registro {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        List <Funcionario> list = new ArrayList<>();               
              
        for(int cont = 0; cont < 4; cont ++){                
            int verificacaoDeId ; 
            int id;                
            do{
                System.out.println("Funcionario #" + (cont + 1));
                System.out.println("Digite o id do funcionario");            
                id = sc.nextInt();
                verificacaoDeId = posicao(list, id);
                if(verificacaoDeId != -1){
                    System.out.println("ID já existente, Digite outro id diferente de " + id);
                    System.out.println("--------------------------------------------");
                }
            }while(verificacaoDeId != -1);               

            System.out.println("Digite o nome do funcionario:"); 
            sc.nextLine();            
            String name = sc.nextLine();

            System.out.println("Digite o salario do funcionario");
            double salario = sc.nextDouble();

            System.out.println("---------------------------------");

            Funcionario func = new Funcionario(name, id, salario);
            list.add(func);                          
        }    
        
        System.out.println("Digite o id do funcionario para receber o aumento");
        int id = sc.nextInt();
        
        /*Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);  Obs: Versão para pegar a posicão de um funcionario ou
        * retonar um valor "null" caso o id não exita para receber o aumento usando o metodo lambida
        */      
        int posicaoFuncNaLista = posicao(list, id); 

        if(posicaoFuncNaLista != -1){
            System.out.println("Digite a porcentagem a ser aumentada no salario do funcionario: " + list.get(posicaoFuncNaLista).getName());
            double porcentagem = sc.nextDouble();
            list.get(posicaoFuncNaLista).aumentarSalario(porcentagem);
        }else{
            System.out.println("Não existe o ID na lista de funcionarios");
        }
        
        System.out.println();
        System.out.println("Dados");
        for (Funcionario x : list){
            System.out.printf("------------------------- \n");
            System.out.println(x);                    
        }

        sc.close();
    } 

    // A função vai ser utilizada para verificar se um id já exixte e também retornará a posição de um funcionario na lista
    public static int posicao(List<Funcionario> list,int id){
        for(int cont = 0; cont < list.size(); cont ++){
            if(list.get(cont).getId() == id){
                return cont;
            }
        }
        return -1;
    }
    public static Funcionario verificadorDeId (List<Funcionario> list, int id){
      Funcionario func = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
      if (func != null){
          return func;
      }
      return null;
    }
}
