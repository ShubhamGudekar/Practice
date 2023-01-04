#include <iostream>
using namespace std;
class date
{
    int dd, mm, yy;

public:
    int get_date(void)
    {
        return this->dd;
    }
    int get_month(void)
    {
        return this->mm;
    }
    int get_year(void)
    {
        return this->yy;
    }
    int set_month(int a)
    {
        if (a < 0 || a > 12)
        {
            cout << endl
                 << "Invalid month Entered ";
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
                            cout << "Invalid date entered please enter date again";
                            dd = 0;
                            return 1;
                        }
                    else if (a == 29 && yy % 4 != 0)
                        {
                            cout << "Not a Leap Year 29 is Invalid date please enter date again";
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
                            cout << "Invalid date entered please enter date again";
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
                        cout << "Invalid date entered please enter date again";
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
    void displaydata()
    {
        cout << endl
             << "Date : " << this->dd << " / " << this->mm << " / " << this->yy << endl;
    }
    date(void)
    {
        cout << endl
             << "Parameterless constructor called (User Defined default constructor)" << endl;
        this->dd = 0;
        this->mm = 0;
        this->yy = 0;
    }
    date(int year, int month, int date)
    {
        cout << endl
             << "Parameterized constructor called" << endl;
        set_year(year);
        set_month(month);
        set_date(date);
    }
};

int main()
{
    date a;
    int d, m, y, c, flag;
    a.displaydata();
    date b(2022,10,19);
    b.displaydata();
    cout << endl
         << "setting data in a" << endl;
l:
    cout << endl
         << "Enter Year : ";
    cin >> y;
    a.set_year(y);
month:
    cout << endl
         << "Enter Month : ";
    cin >> m;
    flag = a.set_month(m);
    if (flag == 1)
    {
        flag = 0;
        goto month;
    }
date:
    cout << endl
         << "Enter date : ";
    cin >> d;
    flag = a.set_date(d);
    if (flag == 1)
    {
        flag = 0;
        goto date;
    }
    a.displaydata();
    cout << "Enter 1 to enter date again and 0 to skip ";
    cin >> c;
    if (c == 1)
        goto l;
    cout << endl;
    cout << "Getting date stored in b :: " << b.get_date() << " / " << b.get_month() << " / " << b.get_year() << endl;
    return 0;
}