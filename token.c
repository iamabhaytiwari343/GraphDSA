#include <stdio.h>
#include <ctype.h>

int main() {
    FILE *fp;
    char filename[100];
    char c;
    int tokens = 0;
    
    printf("Enter the name of the file: ");
    scanf("%s", filename);
    
    fp = fopen(filename, "r");
    
    if (fp == NULL) {
        printf("Error opening file\n");
        return 1;
    }
    
    while ((c = fgetc(fp)) != EOF) {
        if (isspace(c) || c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}' || c == ';' || c == ',' || c == '"' || c == '\'') {
            tokens++;
        }
    }
    
    fclose(fp);
    
    printf("Number of tokens in the file: %d\n", tokens);
    
    return 0;
}
