#include <iostream>
using namespace std;
class date
{
    int dd, mm, yy;
public:
    int set_month(int a)
        {
        if (a < 0 || a > 12)
            {
            cout <<"Invalid month Entered"<<endl;
            this->mm = 0;
            return 1;
            }
        else
            {
            this->mm = a;
            return 0;
            }
        }
    void set_year(int a)
        {
        this->yy = a;
        }
    int set_date(int a)
        {
        if (mm==2)
            {
            if (a<0||a>29)
                    {
                            cout << "Invalid date entered please enter date again"<<endl;
                            dd = 0;
                            return 1;
                        }
                    else if (a == 29 && yy % 4 != 0)
                        {
                            cout << "Not a Leap Year 29 is Invalid date please enter date again"<<endl;
                            dd = 0;
                            return 1;
                        }
                    else
                        {
                            dd = a;
                            return 0;
                        }
                }
            else if (mm==1||mm==3||mm==5||mm==7||mm==8||mm==10||mm==11)
                {
                    if (a<0||a>=31)
                        {
                            cout << "Invalid date entered please enter date again"<<endl;
                            dd = 0;
                            return 1;
                        }   
                    else
                        {
                            dd = a;
                            return 0;
                        }
                }
            else if (mm==4||mm==6||mm==9||mm==11)
                {
                    if (a<0||a>=30)
                    {
                        cout<<"Invalid date entered please enter date again"<<endl;
                        dd = 0;
                        return 1;
                    }
                    else
                    {
                        dd = a;
                        return 0;
                    }
                }
            else
            return 1;
        }
    void displaydate()
    {
        cout<< "DOJ   : "<< this->dd<<"/"<<this->mm <<"/"<<this->yy<<endl;
    }
    void acceptdate()
    {
        int d,m,y,flag=0;
        cout<<"(DOJ)Enter Year  : ";
        cin >> y;
        set_year(y);
        month:
        cout<<"(DOJ)Enter Month : ";
        cin >> m;
        flag=set_month(m);
        if (flag == 1)
            {
                flag = 0;
                goto month;
            }
        date:
        cout<<"(DOJ)Enter date  : ";
        cin >> d;
        flag=set_date(d);
        if (flag == 1)
            {
                flag = 0;
                goto date;
            }
    }
    date(void)
    {
        this->dd = 0;        this->mm = 0;        this->yy = 0;
    }
    date(int year, int month, int date)
    {
        set_year(year);
        set_month(month);
        set_date(date);
    }
};
class empolyee
    {
        int id;string name;date doj;
        public:
        empolyee(void)
        {
            id=0;name="NULL";
        }

        empolyee(string z,int y,date x):name(z),id(y),doj(x){}

        empolyee(string name,int id,int year,int month,int date):name(name),id(id),doj(year,month,date){}

        void acceptdata()
        {
            cout<<endl;
            cout<<"Enter Name       : ";
            cin>>name;
            cout<<"Enter ID         : ";
            cin>>id;
            doj.acceptdate();
        }

        void displaydata()
        {
            cout<<endl<<"Id    : "<<id<<endl;
            cout      <<"Name  : "<<name<<endl;
            doj.displaydate();
        }
    };
int main()
{
    date l(2022,11,12);
    empolyee a("Shubh",24,l);
    a.displaydata();
    cout<<endl;
    empolyee b("Qwert",145,2021,11,14);
    b.displaydata();
    empolyee c;
    c.acceptdata();
    c.displaydata();
    return 0;
}