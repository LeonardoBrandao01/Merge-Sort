import java.util.Random;

public class SortComparison {


    static long comparacoesMergeSort = 0;
    static long comparacoesInsertionSort = 0;

    // Função para realizar o Merge Sort
    public static void ordenarPorIntercalacao(int[] array, int esquerda, int direita) {
        if (esquerda < direita) {

            int meio = (esquerda + direita) / 2;


            ordenarPorIntercalacao(array, esquerda, meio);
            ordenarPorIntercalacao(array, meio + 1, direita);

            // Combinar as duas metades ordenadas
            intercalar(array, esquerda, meio, direita);
        }
    }

    // Função para combinar (intercalar) duas metades
    public static void intercalar(int[] array, int esquerda, int meio, int direita) {
        int tamanhoEsquerda = meio - esquerda + 1;
        int tamanhoDireita = direita - meio;

        // Arrays temporários
        int[] arrayEsquerda = new int[tamanhoEsquerda];
        int[] arrayDireita = new int[tamanhoDireita];

        // Copiar dados para os arrays temporários
        for (int i = 0; i < tamanhoEsquerda; i++) {
            arrayEsquerda[i] = array[esquerda + i];
        }
        for (int j = 0; j < tamanhoDireita; j++) {
            arrayDireita[j] = array[meio + 1 + j];
        }

        // Índices iniciais das duas metades e do array combinado
        int i = 0, j = 0;
        int k = esquerda;

        // Combinar os arrays temporários de volta no array original
        while (i < tamanhoEsquerda && j < tamanhoDireita) {
            comparacoesMergeSort++;
            if (arrayEsquerda[i] <= arrayDireita[j]) {
                array[k] = arrayEsquerda[i];
                i++;
            } else {
                array[k] = arrayDireita[j];
                j++;
            }
            k++;
        }

        // Copiar os elementos restantes da metade esquerda
        while (i < tamanhoEsquerda) {
            array[k] = arrayEsquerda[i];
            i++;
            k++;
        }

        // Copiar os elementos restantes da metade direita
        while (j < tamanhoDireita) {
            array[k] = arrayDireita[j];
            j++;
            k++;
        }
    }

    // Função para realizar o Insertion Sort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int chave = array[i];
            int j = i - 1;

            // Move elementos que são maiores que a chave para a posição à frente
            while (j >= 0 && array[j] > chave) {
                comparacoesInsertionSort++; // Conta comparações
                array[j + 1] = array[j];
                j = j - 1;
            }
            comparacoesInsertionSort++; // Conta a última comparação onde a condição falha
            array[j + 1] = chave;
        }
    }

    // Função principal para testar o código
    public static void main(String[] args) {
        // Gerar um array aleatório
        Random random = new Random();
        int tamanhoArray = 100000; // Defina o tamanho do array aleatório
        int[] array1 = new int[tamanhoArray];
        int[] array2 = new int[tamanhoArray];

        for (int i = 0; i < tamanhoArray; i++) {
            int valorAleatorio = random.nextInt(100000);
            array1[i] = valorAleatorio; // Preencher o array com números aleatórios
            array2[i] = valorAleatorio; // Copiar os mesmos números para o segundo array
        }

        // Merge Sort
        System.out.println("Executando MergeSort...");
        long inicioMerge = System.currentTimeMillis();

        ordenarPorIntercalacao(array1, 0, array1.length - 1);

        long fimMerge = System.currentTimeMillis();
        long tempoExecucaoMerge = fimMerge - inicioMerge;

        System.out.println("Tempo de execução do MergeSort: " + tempoExecucaoMerge + " milissegundos");
        System.out.println("Número de comparações do MergeSort: " + comparacoesMergeSort);

        // Insertion Sort
        System.out.println("Executando InsertionSort...");
        long inicioInsertion = System.currentTimeMillis();

        insertionSort(array2);

        long fimInsertion = System.currentTimeMillis();
        long tempoExecucaoInsertion = fimInsertion - inicioInsertion;

        System.out.println("Tempo de execução do InsertionSort: " + tempoExecucaoInsertion + " milissegundos");
        System.out.println("Número de comparações do InsertionSort: " + comparacoesInsertionSort);
    }
}
