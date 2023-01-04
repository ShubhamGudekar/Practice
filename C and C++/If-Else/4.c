#include<stdio.h>
int main()
    {
        char a;
        printf("Enter the character in lower case = ");
        scanf("%c",&a);  
        if((a>96)&&(a<123))
            {
                if((a=='a')||(a=='e')||(a=='i')||(a=='o')||(a=='u'))
                printf("Entered Character is Vowel");
                else
                printf("Entered Character is Consonant");
            }
        else
        printf("Entered Character is Invalid ");
        return 0;
    }