#include<iostream>
using namespace std;
class employee
    {
        static double med,pt;
        int id;
        string name;
        double bs,hra,pf,ns,gs;

        public:
        employee(void)
        {
            id=0;name="",bs=0;hra=0,pf=0,ns=0,gs=0;
        }
        void acceptdata()
        {
            cout<<"Enter name         : ";
            cin>>name;
            cout<<"Enter Id           : ";
            cin>>id;
            cout<<"Enter Basic Salary : ";
            cin>>bs;
            hra=bs/2;
            pf=bs*0.12;
            gs=bs+hra+med;
            ns=gs-pf-pt;
        }
        void displaydata()
        {
            cout<<endl;
            cout<<"Id           : "<<id<<endl;
            cout<<"Name         : "<<name<<endl;
            cout<<"Basic Salary : "<<bs<<"/- Rs"<<endl;
            cout<<"HRA          : "<<hra<<"/- Rs"<<endl;
            cout<<"PF           : "<<pf<<"/- Rs"<<endl;
            cout<<"Medical      : "<<med<<"/- Rs"<<endl;
            cout<<"PT           : "<<pt<<"/- Rs"<<endl;
            cout<<"Gross Salray : "<<gs<<"/- Rs"<<endl;
            cout<<"Net Salary   : "<<ns<<"/- Rs"<<endl;
        }
    };
double employee::med=1000;
double employee::pt=200;
int main()
    {
        employee a;
        a.acceptdata();
        a.displaydata();
        return 0;
    }