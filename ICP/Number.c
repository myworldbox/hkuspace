#include <stdio.h>
 
int secs(int,int,int);
int secsRef(int,int,int,int);
void main() {
    
    int = a,b,c;
 
 
    printf("\nEnter a number of hours:");
    gets(a);
    printf("\nEnter a number of minutes:");
    gets(b);
     printf("\nEnter a number of secords:");
    gets(c);
    
    secs(a,b,c);
    secsRef(a,b,c,&totalsec);
}
int secs(int a, int b, int c){
	int totalsec=a*60*60+b*60+c;
	return totalsec;
}

int secsRef(int a, int b, int c, int *totsec){
	int totalsec= &totalsec;
	
}
