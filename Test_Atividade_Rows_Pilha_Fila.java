/**
 * Codigo que avalia se o codido da impressao é valido,
 * para numero > 100 esta corrompido, numero <= 1000 esta valido
 *para a realizacao desta atividade deve-se utilizar os
 * metodos enqueue e denqueue da Classe Fila
 * @author: RA 21434418 - Alexandre Roberto
 */
class No {
    int dado;
    No proximoNo;
    //Construtor da classe, recebe int
    public No(int dado) {
        this.dado = dado;
        this.proximoNo = null;
    }
}
class Fila {
    No inicio;
    No fim;
    //Construtor da classe
    public Fila() {
        inicio = null;
        fim = null;
    }
    //Metodo para impressao
    void print() {
        if (isEmpty()) {
            System.out.println("Nao ha itens, fila vazia");
        } else {
            No auxiliar = inicio;
            while (auxiliar != null) {
                System.out.println(auxiliar.dado);
                auxiliar = auxiliar.proximoNo;
            }
        }
    }
    //Analisa se ha ou nao itens
    boolean isEmpty() {
        return (inicio == null);
    }
    //Realiza o enfileiramento
    public void enqueue(int dado) {
        No novoNo = new No(dado);
        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximoNo = novoNo;
            fim = novoNo;
        }
    }
    //Realiza o desenfileiramento
    int dequeue() {
        if(isEmpty()) {
            return -1;
        } else {
            No aux = inicio;
            inicio = inicio.proximoNo;
            if(inicio == null) {
                fim = null;
            }
            return aux.dado;
        }
    }
}
//Classe que contem o metodo principal
public class Test_Atividade_Rows_Pilha_Fila {
    public static void main(String [] args) {
        //Instancia necessaria para execucao
        Fila fila = new Fila();

        //Declaracao das codigos dos arquivos propostas pela Atividade
        int [] impressao = {2, 50, 31, 700, 1002, 540, 1010, 1050, 1031, 700};

        //Enfileirando os codigos de impressao
        for (int codigo : impressao) {
            fila.enqueue(codigo);
        }
        //execuccao da logica que e imprime
        int cod_impress = 0;
        while(!fila.isEmpty()) {
            cod_impress = fila.dequeue();
            if(cod_impress >= 1000) {
                System.out.println("o seguinte arquivo esta corrompido: " + cod_impress );
            } else {
                System.out.println("imprindo o seguinte arquivo: " + cod_impress );
            }
        }
    }
}
