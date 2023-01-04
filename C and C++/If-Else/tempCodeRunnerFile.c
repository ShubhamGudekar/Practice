if(a>=b)
            {
                if(a==b)
                printf("First and Second Number are Equal");
                if(a==c)
                printf("First and Third Number are Equal");
                if(a>c)
                printf("Maximum Number = %d \nMinimum Number = %d",a,c);
                else
                printf("Maximum Number = %d \nMinimum Number = %d",a,b);
            }
            else 
            {
                if(b==c)
                printf("Second and third Number are Equal");
                if(b>c)
                printf("Maximum Number = %d \nMinimum Number = %d",b,c);
                else
                printf("Maximum Number = %d \nMinimum Number = %d",c,a);
            }