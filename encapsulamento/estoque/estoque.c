#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    int codigo;
    char nome[50];
    int quantidade;
} Item;

void carregarEstoque(Item **estoque, int *total) {
    FILE *arquivo = fopen("estoque.txt", "r");
    if (arquivo == NULL) {
        *estoque = NULL;
        *total = 0;
        return;
    }
    
    fscanf(arquivo, "%d\n", total);
    if (*total > 0) {
        *estoque = (Item *)malloc((*total) * sizeof(Item));
        for (int i = 0; i < *total; i++) {
            fscanf(arquivo, "%d\n", &(*estoque)[i].codigo);
            fgets((*estoque)[i].nome, 50, arquivo);
            (*estoque)[i].nome[strcspn((*estoque)[i].nome, "\n")] = '\0';
            fscanf(arquivo, "%d\n", &(*estoque)[i].quantidade);
        }
    } else {
        *estoque = NULL;
    }
    
    fclose(arquivo);
}

void salvarEstoque(Item *estoque, int total) {
    FILE *arquivo = fopen("estoque.txt", "w");
    if (arquivo == NULL) return;
    
    fprintf(arquivo, "%d\n", total);
    for (int i = 0; i < total; i++) {
        fprintf(arquivo, "%d\n", estoque[i].codigo);
        fprintf(arquivo, "%s\n", estoque[i].nome);
        fprintf(arquivo, "%d\n", estoque[i].quantidade);
    }
    
    fclose(arquivo);
}

void adicionarItem(Item **estoque, int *total) {
    int codigo, quantidade;
    char nome[50];
    
    printf("Digite o código do item: ");
    scanf("%d", &codigo);
    
    for (int i = 0; i < *total; i++) {
        if ((*estoque)[i].codigo == codigo) {
            printf("Digite a quantidade a ser adicionada: ");
            scanf("%d", &quantidade);
            (*estoque)[i].quantidade += quantidade;
            salvarEstoque(*estoque, *total);
            return;
        }
    }
    
    printf("Digite o nome do item: ");
    scanf(" %[^\n]s", nome);
    printf("Digite a quantidade: ");
    scanf("%d", &quantidade);
    
    *estoque = (Item *)realloc(*estoque, (*total + 1) * sizeof(Item));
    (*estoque)[*total].codigo = codigo;
    strcpy((*estoque)[*total].nome, nome);
    (*estoque)[*total].quantidade = quantidade;
    
    (*total)++;
    salvarEstoque(*estoque, *total);
}

void removerItem(Item *estoque, int total) {
    int codigo, quantidade;
    printf("Digite o código do item: ");
    scanf("%d", &codigo);
    
    for (int i = 0; i < total; i++) {
        if (estoque[i].codigo == codigo) {
            printf("Digite a quantidade a ser removida: ");
            scanf("%d", &quantidade);
            if (estoque[i].quantidade >= quantidade) {
                estoque[i].quantidade -= quantidade;
                salvarEstoque(estoque, total);
            } else {
                printf("Quantidade insuficiente em estoque!\n");
            }
            return;
        }
    }
    printf("Item não encontrado!\n");
}

void listarEstoque(Item *estoque, int total) {
    printf("\n--- Itens em Estoque ---\n");
    for (int i = 0; i < total; i++) {
        printf("Código: %d | Nome: %s | Quantidade: %d\n", estoque[i].codigo, estoque[i].nome, estoque[i].quantidade);
    }
    printf("------------------------\n");
}

int main() {
    Item *estoque = NULL;
    int total = 0;
    int opcao;
    
    carregarEstoque(&estoque, &total);
    
    do {
        printf("\n================================\n");
        printf("Controle de Estoque\n");
        printf("================================\n");
        printf("Selecione uma opção:\n");
        printf("1. Adicionar Item\n");
        printf("2. Remover Item\n");
        printf("3. Listar Estoque\n");
        printf("4. Sair\n");
        printf("Opção: ");
        scanf("%d", &opcao);
        
        switch (opcao) {
            case 1:
                adicionarItem(&estoque, &total);
                break;
            case 2:
                removerItem(estoque, total);
                break;
            case 3:
                listarEstoque(estoque, total);
                break;
            case 4:
                break;
            default:
                printf("Opção inválida!\n");
        }
    } while (opcao != 4);
    
    if (estoque != NULL) free(estoque);
    
    return 0;
}