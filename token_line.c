#include <stdio.h>
#include <ctype.h>

int main() {
    FILE *fp;
    char filename[100];
    char c, prev;
    int tokens = 0, line = 1;
    enum {NONE, IDENTIFIER, KEYWORD, OPERATOR, STRING, CHAR, NUMBER} type = NONE;
    
    printf("Enter the name of the file: ");
    scanf("%s", filename);
    
    fp = fopen(filename, "r");
    
    if (fp == NULL) {
        printf("Error opening file\n");
        return 1;
    }
    
    while ((c = fgetc(fp)) != EOF) {
        if (c == '\n') {
            line++;
        }
        
        if (isspace(c) || c == '(' || c == ')' || c == '[' || c == ']' || c == '{' || c == '}' || c == ';' || c == ',' || c == '"' || c == '\'') {
            if (type != NONE) {
                printf("Token type: %d\tLine number: %d\n", type, line);
                tokens++;
                type = NONE;
            }
            if (c == '"' && prev != '\\') {
                type = STRING;
            }
            else if (c == '\'' && prev != '\\') {
                type = CHAR;
            }
        }
        else {
            if (type == NONE) {
                if (isdigit(c)) {
                    type = NUMBER;
                }
                else if (isalpha(c) || c == '_') {
                    type = IDENTIFIER;
                }
            }
            else if (type == IDENTIFIER && !isalnum(c) && c != '_') {
                type = KEYWORD;
            }
            else if (type == NUMBER && !isdigit(c) && c != '.') {
                type = OPERATOR;
            }
        }
        
        prev = c;
    }
    
    fclose(fp);
    
    printf("Number of tokens in the file: %d\n", tokens);
    
    return 0;
}
