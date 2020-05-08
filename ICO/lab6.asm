#--------------------------------
# name: Leung Cheuk Hei
# student ID: 20089762

.data
#--------------------------------
# define variables

index: .word 6
list: .word 40
string_1: .asciiz "Selection the function? "
string_2: .asciiz "value "
string_3: .asciiz "The result is "
symbol: .asciiz "? "

.text
.globl main

main:
#--------------------------------
# void main()

# prepare array index
li $t0,1
la $s1,list

# print message
li $v0, 4
la $a0, string_1
syscall

jal scanf

# move input value from $v0 to $t1
addi $t1,$v0, 0

for_1:
#--------------------------------
# void main()
# first for loop

# print message
li $v0, 4
la $a0, string_2
syscall

# print increament of integer
li $v0,1

# move $t0 value to $a0
addi $a0,$t0, 0
syscall

# print symbol
li $v0, 4
la $a0, symbol
syscall

jal scanf
sw $v0,($s1)
addi $s1,$s1,4

addi $t0,$t0,1

# loop if $t0 <= 10
bne $t0,11,for_1

if:
#--------------------------------
# void main()
# if()

bne $t1,1,else_if
li $a1,10
la $a0,list

# call fun_1
jal fun_1

# save $v0 to $t1
addi $t1,$v0, 0

j exit

else_if:
#--------------------------------
# void main()
# else if()

bne $t1,2,else
li $a1,10
la $a0,list

# jump to fun_2
jal fun_2

# save $v0 to $t1
addi $t1,$v0, 0

j exit

else:
#--------------------------------
# void main()
# else()

addi $t1, $zero, -1
exit:
#--------------------------------
# void main()
# exit

# print message_3
li $v0, 4
la $a0, string_3
syscall

li $v0,1

addi $a0,$t1, 0
syscall
# quit
li $v0, 10
syscall

scanf:
#--------------------------------
# read integer input

li $v0,5
syscall

# return
jr $ra

fun_1:
#--------------------------------
# fun_1()

li $v0,0
addi $a1,$a1,-2

li $t0,1
addi $a0,$a0,4

for_2:
#--------------------------------
# fun_1()
# second for loop

# $v0 is the sum
lw $t1,($a0)
add $v0,$v0,$t1
addi $a0,$a0,4
addi $t0,$t0,1

bge $a1, $t0,for_2

# return $v0
jr $ra

fun_2:
#--------------------------------
# fun_2()

# put return address in stack
sw $ra,-4($sp)
addi $sp,$sp,-4

# jump to fun_3
jal fun_3

# get return address from stack
lw $ra,($sp)
addi $sp,$sp,-4

# return $v0
jr $ra

fun_3:
#--------------------------------
# fun_3()

lw $s0, index
sll $s0, $s0, 2
addi $a0,$a0,-4
add $a0,$a0,$s0
lw $v0,($a0)

# return $v0
jr $ra