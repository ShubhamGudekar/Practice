#include<stdio.h>
char* concat(char *a, const char *b);
int compare(char *a,char *b);
char* rev(char *a);
char* uppercase(char *a);

int main()
    {
        int i,c;
        char a[100],b[100];
        while(c!=0)
        {
        printf("\n\nEnter...");
        printf("\n1 to concatenate two strings\n2 to compare two strings");
        printf("\n3 to reverse string \n4 to change to uppercase");
        printf("\n0 to Exit\nYour Choice = ");
        scanf("%d",&c);
        switch(c)
            {
                case 0:break;
                
                case 1:
                printf("Enter first string to concatenate ");
                scanf("%*c%[^\n]",a);
                printf("Enter second string to concatenate ");
                scanf("%*c%[^\n]",b);
                printf("\nConcatenated String = %s",concat(a,b));
                break;

                case 2:
                printf("Enter first string to compare ");
                scanf("%*c%[^\n]",a);
                printf("Enter second string to compare ");
                scanf("%*c%[^\n]",b);
                i=compare(a,b);
                if(i==0)
                printf("\nBoth Strings are same");
                else
                printf("Both Strings are not same");
                break;

                case 3:
                printf("Enter string which is to be reversed ");
                scanf("%*c%[^\n]",a);
                printf("Reverse String = %s",rev(a));
                break;

                case 4:
                printf("Enter string in lowercase to change it to uppercase ");
                scanf("%*c%[^\n]",a);
                printf("%s",uppercase(a));
                break;

                default:
                printf("Invalid Choice");
            }
        }
        return 0;
    }
char* concat(char *a, const char *b)
    {
        int i=0,j=0;
        while(a[i]!='\0')
            i++;
        while(b[j]!='\0')
        {
            a[i+j] = b[j]; 
            j++; 
        }
        a[i+j]='\0'; 
        return a;
    }
int compare(char *a,char *b)
    {
        int i=0,j=0,z=0,y=1;
        while(a[i]!='\0')
            i++;
        while(b[j]!='\0') 
            j++;
        if(i==j)
            {   
                int p=0;
                while((z<=i)&&a[z]!=0)
                    {
                        if(a[z]==b[z])
                            p++;
                        z++;
                    }
                if(p==i)
                return 0;
                else
                return 1;
            }
        else
        return 1;
    }

char* rev(char *a)
    {
        int i=0,j=0;char abc[100];
        while(a[i]!='\0')
            {   
                abc[i]=a[i];
                i++;
            }
        while(i>=0)
        {
            a[j]=abc[i-1]; 
            j++;
            i--;
        } 
        a[j]='\0';
        return a;
    }
char* uppercase(char *a)
    {
        int i=0;
        while(a[i]!='\0')
        {
            if(a[i]>96&&a[i]<123)
            a[i] -= 32; 
            i++; 
        } 
        return a;
    }
