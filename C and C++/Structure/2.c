#include<stdio.h>
#include<stdlib.h>
#include<string.h>
void search_id(int n);
void search_name(int n);
int z=0;
typedef struct empolyee
    {
        int id,sal;
        char name[40];
    }emp;
emp *s;
emp acceptdata(emp a)
    {
        printf("Enter ID no. of Empolyee ");
        scanf("%d",&a.id);
        printf("Enter Name of Empolyee ");
        scanf("%*c%[^\n]",&a.name);
        printf("Enter Salary Of Empolyee ");
        scanf("%d",&a.sal);
        return a;
    }

void printdata(emp a)
    {
        if(z==0)
        {
        printf("\n ID   Name\t\tSalary\n\n");
        z++;
        }
        printf(" %-5d%-18s%d\n",a.id,a.name,a.sal);
    }

int main()
    {
        int n,c,i;
        printf("Enter number of students details to be entered ");
        scanf("%d",&n);
        s=(emp *)malloc(n*sizeof(emp));
        if(s==NULL)
            {
                printf("Memory Not Allocated");
                exit(1);
            }
        else
            {
                for(i=0;i<n;i++)
                {
                    printf("Enter detail of %dth Empolye\n",i+1);
                    s[i]=acceptdata(s[i]); 
                }
            }
        while(c!=0)
        {
        printf("\n\nEnter...\n1 to search empolyee by name\n2 to search empolyee by ID");
        printf("\n2 to display all empolyee details");
        printf("\n4 to display details of empolyee having salary > 25000");
        printf("\n5 to display details of empolyee having highest Salary");
        printf("\n0 to Exit\nYour Choice = ");
        scanf("%d",&c);
        switch(c)
            {
                case 0:
                break;

                case 1:
                search_name(n);
                break;

                case 2:
                search_id(n);
                break;

                case 3:
                z=0;
                for(i=0;i<n;i++)
                printdata(s[i]);
                break;

                case 4:
                z=0;int op=0;
                for(i=0;i<n;i++)
                    {
                        if(s[i].sal>25000)
                            {
                                printdata(s[i]);
                                op++;
                            }
                    }
                if(op==0)
                printf("No empolyee have salary above 25000");
                else
                printf("\n%d empolyee have salary above 25000",op);
                break;

                case 5:
                z=0;int j=0;
                for(i=1;i<n;i++)
                    {
                        if(s[0].sal<s[i].sal)
                        j=i;
                    }
                printdata(s[j]);
                break;

                default:
                printf("Invalid Choice");
            }
        }
        free(s);
        s=NULL;
        return 0;
    }

void search_id(int n)
    {
        z=0;int a,matchfound=0;
        printf("Enter Id to search ");
        scanf("%d",&a);
        for(int i=0;i<n;i++)
            {
                if(s[i].id==a)
                    {
                        printdata(s[i]);
                        matchfound++;
                    }
            }
        if(matchfound==0)
        printf("Match Not Found");
        else
        printf("\n%d matches found",matchfound);
    }
void search_name(int n)
    {
        int matchfound=0;
        char c[20];
        z=0;
        printf("Enter Name to search ");
        scanf("%*c%[^\n]",&c);
        for(int i=0;i<n;i++)
            {
                if(!(strcasecmp(s[i].name,c)))
                {
                    printdata(s[i]);
                    matchfound++;
                }
            }
        if(matchfound==0)
        printf("Match Not Found");
        else
        printf("\n%d matches found",matchfound);
    }