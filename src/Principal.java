/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 *
 * Baseado nos slides 24 da aula do dia 22/09/2017  
 *
 * Página 156 Cormen 3a Ed
 *
 * Problema de Seleção
 * Dado um conjunto A de n números inteiro e um inteiro i, 
 * determinar o i-ésimo menor elemento de A.
 *
 * Atenção:
 * Vetor em java inicia em 0, os algoritmos consideram início em 1.
 * A subtraçào de -1 ocorre somente no local de acesso ao vetor ou matriz 
 * para manter a compatibilidade entre os algoritmos.
 *
 */

/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {

    /**
     * Recebe um vetor A[1... n] e devolve o mínimo e o máximo do vetor. 
     * Número de comparações: 
     * Se n for ímpar: 3(n/2)
     * Se n for par: 3(n/2) - 2
     * 
     * @param A Vetor com os valores
     * @param n Quantidade de elementos do vetor
     * @return Um vetor com o menor e maior elemento do vetor
     */
    public static int[] minMax(int A[], int n) {        
        int min;
        int max;
        int i = 1;
        //Verifica se n é impar
        if (n%2==1){              
            min = A[i-1];
            max = A[i-1];            
            //Avança um elemento pois temos quantidade impar de elementos
            i = i + 1;
        } else {
            //Compara os dois primeiros para saber que é o menor e maior
            if (A[i-1] > A[i+1-1]){
                min = A[i+1-1];
                max = A[i-1];
            } else {
                min = A[i-1];
                max = A[i+1-1];
            }
            //Pula dois elementos pois temos quantidade par de elementos
            i = i + 2;
        }
        
        while (i <= n){           
            if (A[i-1]> A[i+1-1]){ 
                if (A[i-1]>max){
                    max = A[i-1];                    
                }
                if (A[i+1-1]<min){
                    min = A[i+1-1];  
                };
            } else {                
                if (A[i-1]<min){
                   min = A[i-1];                   
                }             
                if (A[i+1-1]>max){
                   max = A[i+1-1];  
                }
            }
            //Avança mais dois elementos
            i = i + 2;
        }
               
        //Cria um vetor com dois elementos para retornar o menor e maior
        int[] retorno = {min, max};
        return retorno;
    }

    public static void main(String[] args) {
        //Vetor dos dados    
        int A[] = {50, 70, 60, 90, 10, 30, 20, 40};
        
        //Quantidade de elementos
        int n = A.length;

        int[] retorno = minMax(A, n);

        System.out.println("Menor:" + retorno[0]);
        System.out.println("Maior:" + retorno[1]);
    }
}
