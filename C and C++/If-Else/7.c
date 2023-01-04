#include<stdio.h>
int main()
    {
        char a;
        printf("Enter the character = ");
        scanf("%c",&a);  
        if((a>96)&&(a<123))
        printf("\nCharacter in LowerCase\nInverted Case = %c",a-32);
        else if((a>64)&&(a<91))
        printf("\nCharacter in UpperCase\nInverted Case = %c",a+32);
        else
        printf("Invalid Character");
        return 0;
    }