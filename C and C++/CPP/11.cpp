#include<iostream>
using namespace std;
class bankacc
    {
        int accno;
        string name;
        double balance;

        public:
        void withdraw()
        {  
            int a,b;
            cout<<"Enter account number ";
            cin>>b;
            if(b==accno)
                {
                    cout<<"Enter amount to withdraw ";
                    cin>>a;
                    if(a>balance)
                        cout<<"Amount more than balance amount ";
                    else
                    {
                        cout<<"Amount withdraw Successfull"<<endl;
                        balance-=a;
                        displaydetails();   
                     } 
                }
            else
            cout<<"Account number does not Exist ";
        }
        void deposit()
        {
            int d,b;
            cout<<"Enter account number ";
            cin>>b;
            if(b==accno)
                {
                    cout<<"Enter amount to deposit ";
                    cin>>d;
                    balance+=d;
                    displaydetails();
                }
            else
            cout<<"Account number does not Exist ";
        }
        void acceptdetails()
        {
            cout<<endl;
            cout<<"Enter Name           : ";
            cin>>name;
            cout<<"Enter Account Number : ";
            cin>>accno;
            cout<<"Enter Balance        : ";
            cin>>balance;
        }
        void displaydetails()
        {
            cout<<endl;
            cout<<"Name           : "<<name<<endl;
            cout<<"Account Number : "<<accno<<endl;
            cout<<"Balance        : "<<balance<<"/- Rs"<<endl;
        }
        bankacc(void)
        {
            accno=0;name="";balance=0;
        }
        bankacc(int accno,string name,double balance):accno(accno),name(name),balance(balance){}
    };

int main()
    {
        bankacc a;
        a.displaydetails();
        bankacc b(123,"abcdefg",10000);
        b.displaydetails();
        //a.acceptdetails();
        b.deposit();
        b.withdraw();
        return 0;
    }