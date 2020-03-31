//
//  main.c
//  lab10_1.c
//
//  Created by Nicholas Leung on 27/11/2018.
//  Copyright © 2018 Nicholas Leung. All rights reserved.
//

#include <stdio.h>

int secs(int a, int b, int c){
    
    int totalsec=a*60*60+b*60+c;
    printf("\nThe total number of seconds from function [secs] is %d",totalsec);
    return totalsec;
    
}

void secsRef(int *totalsec){
    
    printf("\n\nThe total number of seconds from function [secs] is %d",*totalsec);
    
}

void main() {
    
    int a,b,c;
    printf("Enter a number of hours: ");
    scanf("%d",&a);
    printf("Enter a number of minutes: ");
    scanf("%d",&b);
    printf("Enter a number of secords: ");
    scanf("%d",&c);
    int totalsec = secs(a,b,c);
    secsRef(&totalsec);
    
}