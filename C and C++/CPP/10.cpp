#include<iostream>
#include<iomanip>
int flag=0;
using namespace std;
class employee
{
    protected:
    int id,deptid,netsalary;
    string name;
    double basicsalary;

    public:
    employee(int id,string name,int deptid,double basicsalary):id(id),name(name),deptid(deptid),basicsalary(basicsalary)
    {}

    employee(void)
    {
        id=0;
        name="";
        deptid=0;
        basicsalary=0;
        netsalary=0;
    }
    virtual double computeNetSalary()=0;

    virtual void acceptdata()
    {
        cout<<"Enter Name of Employee : ";
        cin>>name;
        cout<<"Enter Id : ";
        cin>>id;
        cout<<"Enter Dept Id : ";
        cin>>deptid;
        cout<<"Enter Basic Salary : ";
        cin>>basicsalary;
    }
    
    void displaydata()
    {
        if(flag==0)
            {
                cout<<endl;
                cout<<"ID  "<<setw(0)<<"   Title               Dept Id"<<setw(13)<<"Net Salary"<<endl;
                flag=1;
            }
        cout<<setw(5)<<left<<id<<"  "<<setw(20)<<left<<name<<setw(10)<<left<<deptid<<setw(5)<<left<<netsalary<<endl;
    }
};
class manager : public employee
{
    int perfbonus;

    public:
    manager(int id,string name,int deptid,double basicsalary,int perfbonus):employee(id,name,deptid,basicsalary),perfbonus(perfbonus)
    {
        netsalary=computeNetSalary();
    }

    manager(void)
    {
        perfbonus=0;
    }
    double computeNetSalary()
    {
        netsalary=basicsalary+perfbonus;
        return netsalary;
    }
    
    void acceptdata()
    {
        employee::acceptdata();
        cout<<"Enter Performace Bonus : ";
        cin>>perfbonus;
        netsalary=computeNetSalary();
    }
};
class worker : public employee
{
    int hoursWorked,hourlyRate;

    public:
    worker(int id,string name,int deptid,double basicsalary,int hoursWorked,int hourlyRate):employee(id,name,deptid,basicsalary),hoursWorked(hoursWorked),hourlyRate(hourlyRate)
    {
        netsalary=computeNetSalary();
    }

    worker(void)
    {
        hoursWorked=0;
        hourlyRate=0;
    }

    double computeNetSalary()
    {
        netsalary=basicsalary+(hourlyRate*hoursWorked);
        return netsalary;
    }

    int get_hourlyrate()
    {
        return hourlyRate;
    }

    void acceptdata()
    {
        employee::acceptdata();
        cout<<"Enter Hourly Rate : ";
        cin>>hourlyRate;
        cout<<"Enter Hours Worked ";
        cin>>hoursWorked;
        netsalary=computeNetSalary();
    }
};

int main()
    {
        employee *org[10];
        manager m(1,"shubh",45,4700,1000);
        worker w(78,"saddasd",46,300,10,400);
        m.displaydata();
        w.displaydata();
        org[0]=&m;
        org[1]=&w;
        int j,i=1,c;
        do
        {
            cout<<endl<<"Enter..."<<endl<<"1 to Add manager Details"<<endl;
            cout<<"2 to Add Worker Details"<<endl;
            cout<<"3 to Display data of all Empolyee"<<endl;
            cout<<"4 to Exit"<<endl<<"Your Choice ";
            cin>>c;
            switch(c)
                {
                    case 1:
                    i++;
                    org[i]=new manager;
                    org[i]->acceptdata();
                    break;

                    case 2:
                    i++;
                    org[i]=new worker;
                    org[i]->acceptdata();
                    break;

                    case 3:
                    j=0;flag=0;
                    while(j<=i)
                        {
                            org[j]->displaydata();
                            j++;
                        }
                    break;

                    case 4:
                    cout<<"Exiting...";
                    break;
                    
                    default:
                    cout<<"Invalid Choice";

                }
        }while(c!=0);
        return 0;
    }
