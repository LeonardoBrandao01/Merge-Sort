public class MergeSort {


    public static void ordenarPorIntercalacao(int[] array, int esquerda, int direita) {
        if (esquerda < direita) {
            // Encontrar o meio do array
            int meio = (esquerda + direita) / 2;

            // Ordenar a primeira e a segunda metade
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

    // Função principal para testar o código
    public static void main(String[] args) {
        int[] array = {8, 4, 3, 7, 6, 5, 2, 1,3,6,98,3,5};
        System.out.println("Array original:");
        for (int i : array) {
            System.out.print(i + " ");
        }

        ordenarPorIntercalacao(array, 0, array.length - 1);

        System.out.println("\nArray ordenado:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
