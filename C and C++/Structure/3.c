#include<stdio.h>
#include<stdlib.h>
typedef struct library_book
    {
        int id;
        char title[80];
        char publisher[20] ;
        int code;
        union u 
            {
                int no_of_copies;
                char month[10];
                int edition;
            }info;
        int cost;
    }libb;
libb acceptdata(libb a)
    {
        printf("Enter ID no. of Book ");
        scanf("%d",&a.id);
        printf("Enter Title of the Book ");
        scanf("%*c%[^\n]",&a.title);
        printf("Enter Publisher of the Book ");
        scanf("%*c%[^\n]",&a.publisher);
        l:
        printf("Enter Code of the Book ");
        scanf("%d",&a.code);
        switch(a.code)
            {
                case 1:
                printf("Enter number of copies of textbook ");
                scanf("%d",&a.info.no_of_copies);
                break;

                case 2:
                printf("Enter issue month of Magazine ");
                scanf("%*c%[^\n]",&a.info.month);
                break;

                case 3:
                printf("Enter the edition number of Reference book ");
                scanf("%d",&a.info.edition);
                break;

                default:
                printf("Invalid Code Entered..Please enter valid code\n1)Textbook\t2)Magazine\t3)Reference Book");
                goto l;
            }
        printf("Enter Cost of the Book ");
        scanf("%d",&a.cost);
        return a;
    }
void printdata(libb a)
    {
        printf("\nID no. of Book            %d",a.id);
        printf("\nTitle of the Book         %s",a.title);
        printf("\nPublisher of the Book     %s",a.publisher);
        printf("\nCode of the Book          %d",a.code);
        if(a.code==1)
        printf("\nCopies of textbook        %d",a.info.no_of_copies);
        else if(a.code==2)
        printf("\nIssue month of Magazine   %s",a.info.month);
        else
        printf("\nEdition of Reference book %d",a.info.edition);
        printf("\nCost of the Book          %d",a.cost);
    }
int main()
    {
        int n,i;libb *data=NULL;
        printf("Enter Number of Book Whose Data is to Entered ");
        scanf("%d",&n);
        data=(libb*)malloc(n*sizeof(libb));
        if(data==NULL)
        {
            printf("Memory Not Allocated");
            exit(1);
        }
        else
        {
            for(i=0;i<n;i++)
            {
                printf("Enter detail of %dth Book\n",i+1);
                data[i]=acceptdata(data[i]); 
            }
            printf("\nDisplaying Data of Entered Books\n\n");
            for(i=0;i<n;i++)
            {
                printdata(data[i]);
                printf("\n\n");
            }
        }
        free(data);
        data=NULL;
        return 0;
    }
