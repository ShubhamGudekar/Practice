#include<stdio.h>
int main()
    {
        int a,b;
        char op;
        printf("Enter First Number ");
        scanf("%d",&a);
        printf("Enter Second Number ");
        scanf("%d",&b);
        printf("Enter Operator (+,-,/,*) ");
        scanf("%*c%c",&op);
        switch(op)
        {
            case '+':printf("Addition (Number1+Number2) = %d ",a+b);break;
            case '-':printf("Substraction (Number1-Number2)= %d ",a-b);break;
            case '*':printf("Multiplication (Number1*Number2) = %d ",a*b);break;
            case '/':printf("Divison (Number1/Number2) = %d ",a/b);break;
            default: printf("Invalid Operator Entered");
        }
        return 0; 
    }