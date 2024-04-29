import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        //selecionarCandidatos();
        //listando candidatos selecionados
        String candidatos_finais = selecionarCandidatos();
        String [] candidatos_finais_selecionados = candidatos_finais.split(", "); //Para transformar uma variável em um array precisa da função split()
        System.out.println("Os candidatos selecionados foram: ");
        for(String candidato_final : candidatos_finais_selecionados){ //Para printar o array, precisa iterar sobre ele (For each, ou for normal)
            System.out.println(candidato_final);
        }
        //Entrando em contato com os candidatos
        for (String candidatos : candidatos_finais_selecionados){
            entrandoEmContato(candidatos);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando) {
                tentativasRealizadas++;
            }
            else{
                System.out.println("Contato realizado com sucesso");
            }

        }while(continuarTentando == true && tentativasRealizadas < 3);

        if(atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM O CANDIDATO " + candidato + " NA TENTATIVA "+ tentativasRealizadas);
        }
        else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM O CANDIDATO " + candidato);
        }
    }
    //método auxiliar
    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    //  Análise de candidatos
    //  static void analisarCandidato(String[] listaCandidatos,double salarioPretendido) {
    //      double salarioBase = 2000.0;

    //      if (salarioBase > salarioPretendido){
    //          System.out.println("LIGAR PARA CANDIDATO.");
    //      } 
    //      else if (salarioBase == salarioPretendido){
    //          System.out.println("LIGAR PARA CANDIDATO COM CONTRA PROPOSTA.");
    //      }
    //      else {
    //          System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS.");
    //      }
    //  }

     static String selecionarCandidatos() {
        String [] candidatos = {"Luiz","Joao","Paulo","Marcia","Maria","Felipe","Marcela","Ana","Fernando","Eduardo"};
        String candidatos_selecionados = "";
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        //Fazer um for atribuindo cada candidato a um valor randomico do metodo valorPretendido
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido(); 
            //System.out.println("O candidato "+ candidato + " pretende ter um salario de: R$ " + salarioPretendido);
            if (salarioPretendido <= salarioBase) {
                //System.out.println("O(a) candidato(a) "+ candidato + " foi selecionado(a).");
                candidatosSelecionados++;
                candidatos_selecionados += candidato + ", ";  
                
            }
            candidatoAtual++;
        }
        return candidatos_selecionados;
    }
    
}

