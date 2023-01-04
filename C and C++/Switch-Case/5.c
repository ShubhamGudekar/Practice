#include<stdio.h>
int main()
    {
        int n1,n2,d1,d2;
        char op;
        printf("Enter Numerator of First fraction ");
        scanf("%d",&n1);
        printf("Enter Denominator of First fraction ");
        scanf("%d",&d1);
        printf("Enter Numerator of Second fraction ");
        scanf("%d",&n2);
        printf("Enter denominator of second fraction ");
        scanf("%d",&d2);
        printf("Enter Operator (+,-,*) ");
        scanf("%*c%c",&op);
        switch(op)
        {
            case '+':
            printf("\nAddition ((n1/d1)+(n2/d2)) = %0.2f ",(((float)n1/d1)+((float)n2/d2)));
            break;

            case '-':
            printf("\nSubstraction ((n1/d1)-(n2/d2)) = %0.2f ",(((float)n1/d1)-((float)n2/d2)));
            break;
            
            case '*':
            printf("\nMultiplication ((n1/d1)*(n2/d2)) = %0.2f ",(((float)n1/d1)*((float)n2/d2)));
            break;

            default: 
            printf("\nInvalid Operator Entered");
        }
        return 0; 
    }