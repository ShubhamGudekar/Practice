#include<stdio.h>
#include<string.h>
#include<ctype.h>
int main()
    {
        int i,c;
        char a[100],b[100];
        while(c!=0)
        {
        printf("\n\nEnter... \n1 to display lenght of string\n2 to copy string");
        printf("\n3 to concatenate two strings\n4 to compare two strings");
        printf("\n5 to reverse string \n6 to change to uppercase \n7 to change to lowercase");
        printf("\n8 to Check case\n0 to Exit\nYour Choice = ");
        scanf("%d",&c);
        switch(c)
            {
                case 0:break;
                
                case 1:
                printf("Enter string whose lenght is to displayed ");
                scanf("%*c%[^\n]",a);
                printf("\nLenght of string is %d",strlen(a));
                break;

                case 2:
                printf("Enter string whose copy is to created ");
                scanf("%*c%[^\n]",a);
                strcpy(b,a);
                printf("\nEntered String = %s\nCopied String = %s",a,b);
                break;

                case 3:
                printf("Enter first string to concatenate ");
                scanf("%*c%[^\n]",a);
                printf("Enter second string to concatenate ");
                scanf("%*c%[^\n]",b);
                printf("\nConcatenated String = %s",strcat(a,b));
                break;

                case 4:
                printf("Enter first string to compare ");
                scanf("%*c%[^\n]",a);
                printf("Enter second string to compare ");
                scanf("%*c%[^\n]",b);
                i=strcmp(a,b);
                if(i==0)
                printf("\nBoth Strings are same");
                else
                printf("Both Strings are not same");
                break;

                case 5:
                printf("Enter string which is to be reversed ");
                scanf("%*c%[^\n]",a);
                printf("\nLenght of string is %s",strrev(a));
                break;

                case 6:
                printf("Enter string in lowercase to change it to uppercase ");
                scanf("%*c%[^\n]",a);
                //for(i=0;i<strlen(a);i++)
                //printf("%c",toupper(a[i]));
                printf("%s",strupr(a));
                break;

                case 7:
                printf("Enter string in uppercase to change it to lowercase ");
                scanf("%*c%[^\n]",a);
                //for(i=0;i<strlen(a);i++)st
                //printf("%c",tolower(a[i]));
                printf("%s",strlwr(a));
                break;

                case 8:
                printf("Enter string to check its case ");
                scanf("%*c%[^\n]",a);
                {
                    int j=0,k=0;
                    for(i=0;i<strlen(a);i++)
                    {
                        if(isupper(a[i])/*(a[i]>64)&&(a[i]<91)*/)
                        j++;
                        if(islower(a[i])/*(a[i]>96)&&(a[i]<123)*/)
                        k++;
                    }
                if(j==strlen(a))
                printf("String in Upper Case %d",j);
                else if(k==strlen(a))
                printf("String in lowercase Case %d",k);
                else if((j+k)==strlen(a))
                printf("Mixed case");
                else
                printf("Inavlid String Entered");
                }
                break;
  
                default:
                printf("Invalid Choice");
            }
        }
        return 0;
    }
