#include <stdio.h>
int main(){
    FILE *fp;
    fp=fopen("hello.c","r");
    if(fp==NULL){
        fprintf(stderr,"Error : cannot open input file \n");
        return 1;
    }
    fclose(fp);
    
}