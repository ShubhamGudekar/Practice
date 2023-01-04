#include<stdio.h>
#include<stdlib.h>
#include<string.h>
void search(int n);
void modify(int n);
int z=0;
typedef struct student
    {
        int rn,m1,m2,m3;
        float perc;
        char name[40];
    }student;
student *s;
student acceptdata(student a)
    {
        printf("Enter Roll Number of Student ");
        scanf("%d",&a.rn);
        printf("Enter Name of Student ");
        scanf("%*c%[^\n]",&a.name);
        m1:
        printf("Enter Marks of Subject 1 (out of 100) ");
        scanf("%d",&a.m1);
        if(a.m1>100||a.m1<0)
            {
                printf("Please Enter Correct Marks in range of 0 to 100\n");
                goto m1;
            }
        m2:
        printf("Enter Marks of Subject 2 (out of 100) ");
        scanf("%d",&a.m2);
        if(a.m2>100||a.m2<0)
            {
                printf("Please Enter Correct Marks in range of 0 to 100\n");
                goto m2;
            }
        m3:
        printf("Enter marks of Subject 3 (out of 100) ");
        scanf("%d",&a.m3);
        if(a.m3>100||a.m3<0)
            {
                printf("Please Enter Correct Marks in range of 0 to 100\n");
                goto m3;
            }    
        a.perc=((float)(a.m1+a.m2+a.m3))/3;
        return a;
    }

void printdata(student a)
    {
        if(z==0)
        {
        printf("\nRoll  Name\t\tMarks in\tMarks in\tMarks in\tPercenatge\n");
        printf(" No     \t\tSubject1\tSubject2\tSubject3\n\n");
        z++;
        }
        printf(" %-5d%-18s%d\t\t%d\t\t%d\t\t%.2f\n",a.rn,a.name,a.m1,a.m2,a.m3,a.perc);
    }

int main()
    {
        int n,c,i;
        printf("Enter number of students details to be entered ");
        scanf("%d",&n);
        s=(student *)malloc(n*sizeof(student));
        if(s==NULL)
            {
                printf("Memory Not Allocated");
                exit(1);
            }
        else
            {
                for(i=0;i<n;i++)
                {
                    printf("Enter detail of %dth Student\n",i+1);
                    s[i]=acceptdata(s[i]); 
                }
            }
        while(c!=0)
        {
        printf("\n\nEnter...\n1 to search student details");
        printf("\n2 to modify\n3 to display all students details");
        printf("\n4 to display details of students having more than 80%%");
        printf("\n5 to display student details having highest percentage");
        printf("\n0 to Exit\nYour Choice = ");
        scanf("%d",&c);
        switch(c)
            {
                case 0:
                break;

                case 1:
                search(n);
                break;

                case 2:
                modify(n);
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
                        if(s[i].perc>80)
                            {
                                printdata(s[i]);
                                op++;
                            }
                    }
                if(op==0)
                printf("No Students have percaentage above 80%%");
                break;

                case 5:
                z=0;int j=0;
                for(i=1;i<n;i++)
                    {
                        if(s[0].perc<s[i].perc)
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

void match(int a)
    {
        if(a==0)
        printf("Match Not Found");
        else
        printf("\n%d matches found",a);
    }

void search(int n)
    {
        int ab,matchfound=0;
        int a;float b;char c[20];
        printf("\nSelect paramter to search for....\nEnter\n1 for Roll Number");
        printf("\n2 for name\n3 for marks in subject 1");
        printf("\n4 for marks in subject 2 \n5 for marks in subject 3");
        printf("\nYour Choice ");
        scanf("%d",&ab);
        switch(ab)
            {
                case 1:
                z=0;
                printf("Enter Roll Number to search ");
                scanf("%d",&a);
                for(int i=0;i<n;i++)
                    {
                        if(s[i].rn==a)
                            {
                                printdata(s[i]);
                                matchfound++;
                            }
                    }
                match(matchfound);
                break;

                case 2:
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
                match(matchfound);
                break;

                case 3:
                z=0;
                printf("Enter marks to search in Subject 1 ");
                scanf("%d",&a);
                for(int i=0;i<n;i++)
                    {
                        if(s[i].m1==a)
                        {
                            printdata(s[i]);
                            matchfound++;
                        }
                    }
                match(matchfound);
                break;

                case 4:
                z=0;
                printf("Enter marks to search in Subject 2 ");
                scanf("%d",&a);
                for(int i=0;i<n;i++)
                    {
                        if(s[i].m2==a)
                        {
                            printdata(s[i]);
                            matchfound++;
                        }
                    }
                match(matchfound);
                break;

                case 5:
                z=0;
                printf("Enter marks to search in Subject 3 ");
                scanf("%d",&a);
                for(int i=0;i<n;i++)
                    {
                        if(s[i].m3==a)
                        {
                            printdata(s[i]);
                            matchfound++;
                        }
                    }
                match(matchfound);
                break;

                // case 6:
                // z=0;
                // printf("Enter value to search in Percentage ");
                // scanf("%f",&b);
                // for(int i=0;i<n;i++)
                //     {
                //         if((s[i].perc==b)
                //         {
                //             printdata(s[i]);
                //             matchfound++;
                //         }
                //     }
                // match(matchfound);
                // break;

                default:
                printf("Invalid choice entered");
            }
    }

void modify(int n)
    {
        int abc,i,j=100,qw=0;
        z=0;
        printf("Enter Roll Number of Student whose data is to be modified ");
        scanf("%d",&abc);
        for(i=0;i<n;i++)
            {
                if(s[i].rn==abc)
                j=i;
            }
        if(j==100)
        printf("Student not found");
        else
        {   
            printf("Student found");
            printdata(s[j]);
            printf("\nSelect paramter to modify....\nEnter\n1 for Roll Number");
            printf("\n2 for name\n3 for marks in subject 1");
            printf("\n4 for marks in subject 2 \n5 for marks in subject 3");
            printf("\nYour Choice ");
            scanf("%d",&abc);
            switch(abc)
            {
                case 1:
                l1:
                printf("Enter New Roll Number ");
                scanf("%d",&s[j].rn);
                for(i=0;i<n;i++)
                    {
                        if(s[i].rn==s[j].rn)
                        qw++;
                    }
                if(qw>1)
                    {
                        printf("Roll Number already Assigned to another student\n");
                        goto l1;
                    }
                else
                    {
                        z=0;
                        printf("Roll No. Modified\n");
                        printdata(s[j]);
                    }
                break;

                case 2:
                z=0;
                printf("Enter new Name ");
                scanf("%*c%[^\n]",&s[j].name);
                printf("Name Modified\n");
                printdata(s[j]);
                break;

                case 3:
                z=0;
                printf("Enter new marks in Subject 1 ");
                scanf("%d",&s[j].m1);
                printf("Marks Modified\n");
                s[j].perc=((float)(s[j].m1+s[j].m2+s[j].m3))/3;
                printdata(s[j]);
                break;

                case 4:
                z=0;
                printf("Enter new marks in Subject 2 ");
                scanf("%d",&s[j].m2);
                printf("Marks Modified\n");
                s[j].perc=((float)(s[j].m1+s[j].m2+s[j].m3))/3;
                printdata(s[j]);
                break;

                case 5:
                z=0;
                printf("Enter new marks in Subject 3 ");
                scanf("%d",&s[j].m3);
                printf("Roll No. Modified\n");
                s[j].perc=((float)(s[j].m1+s[j].m2+s[j].m3))/3;
                printdata(s[j]);
                break;

                default:
                printf("Invalid choice");
            }
        }

    }