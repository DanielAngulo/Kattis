using System;

namespace Kattis_CS
{
    class aliennumbers
    {
        static void Main(string[] args)
        {
            int cases = Int32.Parse(Console.ReadLine()) + 1;
            for(int i = 1; i < cases; i++)
            {
                String[] input = Console.ReadLine().Split(' ');
                Console.WriteLine("Case #" + i + ": " + get(evaluate(input[0], input[1]), input[2]));
            }
        }

        static String get(int value, string dictionary)
        {
            String result = "";
            int numBase = dictionary.Length;
            if (value < numBase)
                return dictionary[value] + "";
            while (true)
            {
                if (value == 0)
                {
                    break;
                }
                int remainder = value % numBase;
                value = value / numBase;
                result = dictionary[remainder % numBase] + result;
            }
            return result;
        }

        static int evaluate(string find, string dictionary)
        {
            int length = find.Length;
            int dictionaryLength = dictionary.Length;
            if (length == 1)
                return dictionary.IndexOf(find);
            int current = 0;
            char[] temp = find.ToCharArray();
            Array.Reverse(temp);
            find = new string(temp);
            for(int i = 0; i < length; i++)
            {
                int value = dictionary.IndexOf(find[i]);
                current += ((int)Math.Pow(dictionaryLength, i) * value);
            }
            return current;
        }
    }
}
