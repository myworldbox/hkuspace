#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

void SecureRecord(){
    
    int offset = 0, i =0,j =0, k=0, n = 0;
    char choice,string[1000][1000];
    FILE *fp= fopen("stock.txt","r");
    
    //initializing file
    
    printf("Press E to encrypt the file\nPress D to decrypt thefile\nPress ANY KEY to go back to meun\n\n--->");
    choice = getch();
    printf("%c\n",choice);
    printf("\nInput a number for encoding or decoding\n\n--->");
    scanf("%d",&offset);
    printf("\n");
    //ask user for his options
    
    for(i=0; feof(fp) ==0 ;i++){
        
        if(n==9){
            
            fscanf(fp,"\n");
            printf("\n");
            n=0;
            
        }//skip a line for another data display
        
        fscanf(fp," %[^\n]s",string[i]);
        printf("%s\n",string[i]);
        n++;
        
    }
    
    printf("\n");
    fp=fopen("stock.txt","w+");
    n=0;
    
    for(j=0;j<i;j++){
        if(n==9){
            fprintf(fp,"\n");
            printf("\n");
            n=0;
        }//skip a line for another data display
        if(choice == 'e' || choice == 'd')
            
            for(k = 0;string[j][k] != '\0';k++){
                
                if(choice == 'e'){
                    if((string[j][k]%2)==0)
                        string[j][k] += offset;
                    else
                        string[j][k] -= offset;
                    
                }//for encryption purpose
                
                if(choice == 'd'){
                    if((string[j][k]%2)!=0)
                        string[j][k] -= offset;
                    else
                        string[j][k] += offset;
                    
                }//for decryption purpose
                
            }
                fprintf(fp,"%s\n",string[j]);
                printf("%s\n",string[j]);
                //display the modified data
                n++;
        
    }
    
    printf("\nThe conversion is finished!!!");
    fclose(fp);
    //go back to meun

    }