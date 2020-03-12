#--------------------------------
     # name: Leung Cheuk Hei
     # student ID: 20089762

.data
#--------------------------------
    # define variables
    
    array: .word 121, -13, 82, 20, 65, 85, -54, 25, 99, -320
    min: .word 0
    space: .asciiz "\n"
    str1: .asciiz"Original array:\n"
    str2: .asciiz"\nNew array: \n"
    str3: .asciiz"\nThe minimum element = "

.text
.globl main

main:
#--------------------------------
    # print str1
    
    li $v0, 4
    la $a0, str1
    syscall
        
    li $v0, 0
    la $t1, array
    
loop:
#--------------------------------
    # print original array
        
    bge $t0, 10, exit
    lw $t2, 0($t1)
    addi $t1, $t1, 4

#--------------------------------
    # syscall to print value
    
    li $v0, 1      
    move $a0, $t2
    syscall
    
#--------------------------------
    # print space
    
    li $v0, 4
    la $a0, space
    syscall

#--------------------------------
    # increment counter
    
    addi $t0, $t0, 1
    j loop

 exit:
#--------------------------------
    # print str2
    
    li $v0, 4
    la $a0, str2
    syscall

    la $t1, array
    addi $t0, $t0, 0
    addi $t1, $t1, 36
    
swap:
#--------------------------------
    # print reversed array
        
    ble $t0, 0, exit2
    lw $t2, 0($t1)
    addi $t1, $t1, -4

#--------------------------------
    # syscall to print value
    
    li $v0, 1      
    move $a0, $t2
    syscall
    
#--------------------------------
    # print space
    
    li $v0, 4
    la $a0, space
    syscall

#--------------------------------
    # decrement counter
    
    addi $t0, $t0, -1
    j swap

 exit2:
#--------------------------------
    
    la $s0, array # p = foo
    addi $s1,$s0, 40 # end = p + 10
    add $s3,$zero,$zero # total = 0

    la $s2,min # point to min
    lw $t4,0($s0) # fetch xyz[0]
    sw $t4,0($s2) # store in min

check_min:
#--------------------------------

    beq $s0,$s1, exit3 # if (p == end) goto L2

    lw $t0,0($s0) # $t0 = *p
    addi $s0,$s0,4 # p++

    add $s3,$s3,$t0 # total += $t0

    lw $t4,0($s2) # fetch min
    slt $t2,$t4,$t0 # *p < min?
    bne $t2,$zero,check_min # no, loop

    sw $t0,0($s2) # store new/better min value
    j check_min

exit3:
#--------------------------------
    # print str3
    
    li $v0,4
    la $a0, str3
    syscall

    li $v0,1
    lw $a0,0($s2) # get min value
    syscall

#--------------------------------
    # exit the program

    li $v0, 10
    syscall
