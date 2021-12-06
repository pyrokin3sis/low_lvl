import String;
import java.util.*;

public class Store
{
    public Store(final String _seller, final String _name, final int _amount, final float _price, final int _year)
    {
        this.seller = _seller;
        this.name = _name;
        this.amount = _amount;
        this.price = _price;
        this.year = _year;
    }
    public final int get_amount()
    {
        return amount;
    }
    public final float get_price()
    {
        return price;
    }
    public final int get_year()
    {
        return year;
    }
    public std::istream rightShift(std::istream str, Store obj)
{
    System.out.print("Продавец: ");
    getline(str, obj.seller);
    System.out.print("Наименование: ");
    getline(str, obj.name);
    System.out.print("Количество: ");
    str >> obj.amount;
    System.out.print("Цена: ");
    str >> obj.price;
    System.out.print("Год продажи: ");
    str >> obj.year;
    return str;
}
    public std::ostream leftShift(std::ostream str, final Store obj)
{
    str << "Продавец: " << obj.seller << "\n";
    str << "Наименование: " << obj.name << "\n";
    str << "Количество: " << obj.amount << "\n";
    str << "Цена: " << obj.price << "\n";
    str << "Год продажи: " << obj.year << "\n";
    return str;
}
    private String seller = "";
    private String name = "";
    private int amount = 0;
    private float price = 0;
    private int year = 0;
}

package <missing>;

public class GlobalMembers
{
    public static void total_info(ArrayList<Store> mas, final int _year)
    {
        float total_price = 0;
        int total_amount = 0;
        for (int i = 0; i < mas.size(); i++)
        {
            Store obj = new Store(mas.get(i));
            if (obj.get_year() == _year)
            {
                System.out.print("\n");
                System.out.print(obj);
                System.out.print("\n");
                for (int j = 1; j <= obj.get_amount(); j++)
                {
                    total_price += obj.get_price();
                }
                total_amount += obj.get_amount();
            }
        }
        if (total_price != 0)
        {
            System.out.print("Общее количество проданного товара: ");
            System.out.print(total_amount);
            System.out.print("\n");
            System.out.print("Общая сумма с продаж: ");
            System.out.print(total_price);
            System.out.print("\n");
        }
        else
        {
            System.out.print("За данный год ничего не продано.");
            System.out.print("\n");
        }
    }

    public static void main(String[] args)
    {
        setlocale(LC_ALL, "rus");
        Store o1 = new Store("Apple", "X", 2, 352.45F, 2017);
        Store o2 = new Store("Samsung", "S9", 1, 297.49F, 2017);
        ArrayList<Store> mas = new ArrayList<Store>();
        mas.ensureCapacity(2);
        mas.add(o1);
        mas.add(o2);
        System.out.print("Год продажи: ");
        int year;
        year = Integer.parseInt(ConsoleInput.readToWhiteSpace(true));
        total_info(mas, year);
    }
}
public final class ConsoleInput
{
    private static boolean goodLastRead = false;
    public static boolean lastReadWasGood()
    {
        return goodLastRead;
    }

    public static String readToWhiteSpace(boolean skipLeadingWhiteSpace)
    {
        String input = "";
        char nextChar;
        while (Character.isWhitespace(nextChar = (char)System.in.read()))
        {
            if (!skipLeadingWhiteSpace)
            {
                input += nextChar;
            }
        }

        input += nextChar;
        while (!Character.isWhitespace(nextChar = (char)System.in.read()))
        {
            input += nextChar;
        }

        goodLastRead = input.length() > 0;
        return input;
    }

    public static String scanfRead()
    {
        return scanfRead(null, -1);
    }

    public static String scanfRead(String unwantedSequence)
    {
        return scanfRead(unwantedSequence, -1);
    }

    public static String scanfRead(String unwantedSequence, int maxFieldLength)
    {
        String input = "";

        char nextChar;
        if (unwantedSequence != null)
        {
            nextChar = '\0';
            for (int charIndex = 0; charIndex < unwantedSequence.length(); charIndex++)
            {
                if (Character.isWhitespace(unwantedSequence.charAt(charIndex)))
                {

                    while (Character.isWhitespace(nextChar = (char)System.in.read()))
                    {
                    }
                }
                else
                {

                    nextChar = (char)System.in.read();
                    if (nextChar != unwantedSequence.charAt(charIndex))
                        return null;
                }
            }

            input = (new Character(nextChar)).toString();
            if (maxFieldLength == 1)
                return input;
        }

        while (!Character.isWhitespace(nextChar = (char)System.in.read()))
        {
            input += nextChar;
            if (maxFieldLength == input.length())
                return input;
        }

        return input;
    }
}
