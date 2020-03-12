#--------------------------------
     # name: Leung Cheuk Hei
     # student ID: 20089762
     #t0 holds first input
     #t1 holds scond input

.data
#--------------------------------
    #define variables

    A: .space 20
    B: .space 20
    question1: .asciiz"What is the value of A? "
    question2: .asciiz"What is the value of B? "
    str1: .asciiz"A + B = "
    str2: .asciiz"\nA - B = "
    str3: .asciiz"\nA * B = "
    str4: .asciiz"\nA / B: Quotient = "
    str5: .asciiz"\nA / B: Remainder = "
    result1: .word
    result2: .word
    result3: .word
    result4: .word
    result5: .word

.text
.globl main

main:
#--------------------------------
    #print out question 1 and store input
    
    li $v0, 4 
    la $a0, question1
    syscall

    li $v0,5    
    syscall
    
    move $t0, $v0
    
#--------------------------------
    #print out question 2 and store input
    
    li $v0, 4
    la $a0, question2
    syscall

    li $v0,5    
    syscall
    
    move $t1,$v0
    
#-------------------------------
    #print out answer of A + B
    
    li $v0, 4
    la $a0, str1
    syscall

    add $a0, $t0, $t1 
    li $v0, 1
    sw $a0, result1
    syscall
    
#--------------------------------
    #print out answer of A - B
    
    li $v0, 4
    la $a0, str2
    syscall
    
    sub $a0, $t0, $t1
    li $v0, 1
    sw $a0, result2
    syscall
    
#--------------------------------
    #print out answer of A * B
    
    li $v0, 4
    la $a0, str3
    syscall
    
    mul $a0, $t0, $t1 
    li $v0, 1
    sw $a0, result3
    syscall
    
#--------------------------------
    #print out quotient
    
    li $v0, 4
    la $a0, str4
    syscall
    
    div $a0, $t0, $t1
    li $v0, 1
    sw $a0, result4
    syscall
    
#--------------------------------
    #print out remainder
    
    li $v0, 4
    la $a0, str5
    syscall

    li $v0, 1
    mfhi $a0
    sw $a0, result5
    syscall
     
#--------------------------------
    #exit the program
    
    li $v0, 10
    syscall
