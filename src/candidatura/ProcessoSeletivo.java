package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        String [] candidatos = {"Gabriel", "luciana", "josinete", "josiane", "benjamin"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato){
        int tentativas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando)
                tentativas++;
            else
                System.out.println("Contato realizado com sucesso");

        }while (continuarTentando && tentativas< 3);
        if (atendeu)
            System.out.println("Conseguimos contato com o candidato " + candidato + " na " + tentativas + " tentativa");
        else
            System.out.println("Não conseguimos contato com o candidato " + candidato + " numero maximo de tantativas " + tentativas);
    }

    static boolean atender(){
        return  new Random().nextInt(3) == 1;

    }
    static void imprimirSelecionados(){
        String [] candidatos = {"Gabriel", "luciana", "josinete", "josiane", "benjamin"};
        System.out.println("Imprimindo o numero de candidatos informando o indice ");
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de numero  " + (i + 1) + " é " + candidatos[i]);
        }
    }
    static void selecaoDeCandidatos() {
        String[] candidatos = {"Gabriel", "luciana", "josinete", "josiane", "benjamin", "Diogo", "douglas", "daniele", "lucas", "jean"};
        int candidatoSelecionado = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatoSelecionado < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatoSelecionado++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com contra proposta");
        } else {
            System.out.println("Aguardando demais candidatos");
        }
    }
}
