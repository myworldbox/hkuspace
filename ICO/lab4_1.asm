#--------------------------------
     # name: Leung Cheuk Hei
     # student ID: 20089762

.data
#--------------------------------
    #define variables

    array: .word -13, 82, 20, 85, -54, 25, 99, 65, -320, 121
    str1: .asciiz"Average value = "
    str2: .asciiz"\nSum of all positive elements = "
    str3: .asciiz"\nSum of all negative elements = "

.text
.globl main

main:
#--------------------------------
    #print out question 1 and store input
    
    add $t0, $zero, $zero #counter i
    add $t1, $zero, $zero #sum
    la  $t2, array

loop:    
#--------------------------------
    #for loop addition
    
    slti $t3, $t0, 10 #i<10
    beq $t3, $zero, EXIT
    lw $t4, ($t2) #$t4 = arr[i]
    addi $t2, $t2, 4    
    addi $t0, $t0, 1 #i++
    add $s1, $s1, $t4 #sum = sum + arr[i]
    bltz $t4, ifNev    
    bgtz $t4, ifPos
    j loop
    
ifPos:
#--------------------------------
    #store sum if the current array is positive
    
    add $s2, $s2, $t4 #sum = sum + arr[i]
    j loop
    
ifNev:
#--------------------------------
    #store sum if the current array is negative
    
    add $s3, $s3, $t4 #sum = sum + arr[i]
    j loop
    
EXIT:
#--------------------------------
    #divide for answer

    div $s1, $s1, 10
   
#--------------------------------
    #print answer
    
    la $a0, str1
    li $v0, 4
    syscall
    
    move $a0, $s1
    li $v0, 1
    syscall

#--------------------------------
    #print answer
    

   la $a0, str2
   li $v0, 4
   syscall
    
    move $a0, $s2
    li $v0, 1
    syscall
    
#--------------------------------
    #print answer
    
    la $a0, str3
    li $v0, 4
    syscall
   
    move $a0, $s3
    li $v0, 1
    syscall

#--------------------------------
    #exit the program
    
    li $v0, 10
    syscall
