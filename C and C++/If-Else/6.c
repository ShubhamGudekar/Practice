#include<stdio.h>
int main()
    {
        char a;
        printf("Enter the character to check its case = ");
        scanf("%c",&a);  
        if((a>96)&&(a<123))
        printf("Character in LowerCase");
        else if((a>64)&&(a<91))
        printf("Character in UpperCase");
        else
        printf("Invalid Character");
        return 0;
    }