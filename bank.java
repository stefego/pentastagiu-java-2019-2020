import java.util.*;

class Bank
{
    private String accno;
    private String name;
    private String prenume;
    private long balance;

    Scanner KB=new Scanner(System.in);

    void openAccount()
    {
        /*System.out.print("Enter Account No: ");
        accno=KB.next();*/
        System.out.print("Enter Name: ");
        name=KB.next();
        System.out.print("Enter Prenume: ");
        prenume=KB.next();
        System.out.print("Enter Balance: ");
        balance=KB.nextLong();
        int min=999;
        int max=9999;
        Random rand=new Random();
        int random_int = (int )(Math.random() * max + min);
        System.out.println("Numarul de cont este:"+random_int);
        accno=Integer.toString(random_int);
    }

    void showAccount()
    {
        System.out.println(accno+" "+name.toUpperCase()+" "+prenume.toUpperCase()+" "+balance);
    }


    void deposit()
    {
        long amt;
        System.out.println("Introduceti suma pentru depunere : ");
        amt=KB.nextLong();
        balance=balance+amt;
    }


    void withdrawal()
    {
        long amt;
        System.out.println("Introduceti suma pentru retragere : ");
        amt=KB.nextLong();
        if(balance>=amt)
        {
            balance=balance-amt;
        }
        else
        {
            System.out.println("Fonduri insuficiente. Verificati suma. Tranzactie esuata");
        }
    }


    boolean search(String acn)
    {
        if(accno.equals(acn))
        {
            showAccount();
            return(true);
        }
        return(false);
    }
}

class ExBank
{
    public static void main(String arg[])
    {
        Scanner KB=new Scanner(System.in);

        //create initial accounts
        System.out.print("Cate conturi doriti sa creati:  ");
        int n=KB.nextInt();
        Bank  C[]=new Bank[n];
        for(int i=0;i<C.length;i++)
        {
            C[i]=new Bank();
            C[i].openAccount();
        }

        int ch;
        do
        {
            System.out.println(" Meniul Principal\n\t"+
                    "1.Afisati toate conturile\n\t"+
                    "2.Cautare dupa nr de cont\n\t"+
                    "3.Depunere\n\t"+
                    "4.Retragere\n\t"+
                    "5.Renuntare\n\t");
            System.out.println("Alegeti numarul din meniu :");
            ch=KB.nextInt();
            switch(ch)
            {
                case 1:
                    for(int i=0;i<C.length;i++)
                    {
                        C[i].showAccount();
                    }
                    break;

                case 2:
                    System.out.print("Introduceti nr de cont ...: ");
                    String acn=KB.next();
                    boolean found=false;
                    for(int i=0;i<C.length;i++)
                    {
                        found=C[i].search(acn);
                        if(found)
                        {
                            break;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Greseala!!! Numarul de cont nu exista.");
                    }
                    break;

                case 3:
                    System.out.print("Introduceti numarul de cont : ");
                    acn=KB.next();
                    found=false;
                    for(int i=0;i<C.length;i++)
                    {
                        found=C[i].search(acn);
                        if(found)
                        {
                            C[i].deposit();
                            break;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Greseala!!! Numarul de cont nu exista.");
                    }
                    break;

                case 4:
                    System.out.print("Introduceti numarul de cont : ");
                    acn=KB.next();
                    found=false;
                    for(int i=0;i<C.length;i++)
                    {
                        found=C[i].search(acn);
                        if(found)
                        {
                            C[i].withdrawal();
                            break;
                        }
                    }
                    if(!found)
                    {
                        System.out.println("Greseala!!! Numarul de cont nu exista.");
                    }
                    break;

                case 5:
                    System.out.println("O zi buna.");
                    break;
            }
        }
        while(ch!=5);
    }
}