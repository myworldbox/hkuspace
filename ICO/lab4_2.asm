#--------------------------------
     # name: Leung Cheuk Hei
     # student ID: 20089762
     #t0 holds first input
     #t1 holds scond input

.data
#--------------------------------
    #define variables

    question1: .asciiz"upper_bound: "
    question2: .asciiz"input value? "
    str: .asciiz"value = "

.text
.globl main

main:
#--------------------------------
    #print out question 1 and store input
    
    li $v0, 4 
    la $a0, question1
    syscall

    li $v0, 5    
    syscall
    
    move $t0, $v0
    
 loop:
#--------------------------------
    #print out question 2, store input, and for loop checking
    
    li $v0, 4
    la $a0, question2
    syscall

    li $v0, 5    
    syscall
    
    move $t1, $v0
     
#--------------------------------
    #for loop checking
    
    bgt $t1, $t0, exit
    blt $t1, 52, exit
    j loop
    
exit:
#-------------------------------
    #print out answer of input value
    
    li $v0, 4
    la $a0, str
    syscall

    move $a0,$t1 
    li $v0, 1
    syscall
    
#--------------------------------
    #exit the program
    
    li $v0, 10
    syscall
