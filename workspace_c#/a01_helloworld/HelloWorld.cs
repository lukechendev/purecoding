using System;

namespace a01_helloworld
{
    class HelloWorld
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World home HelloWorld!");
        }
    }

    class HelloWorld2
    {
        static void Main(string[] args)
        {
            Console.ForegroundColor = ConsoleColor.Red;
            Console.WriteLine("Hello World home HelloWorld2!");

            Console.WriteLine("Please tell me two truth and one lie: ");

            var statements = new string[3];
            for (int i = 0; i < statements.Length; ++i) {
                statements[i] = Console.ReadLine();
            }

            Console.WriteLine("The lie is: {0}", GetLie(statements));
        }
        private static string GetLie(string[] statements)
        {
            var rand = new Random();
            return statements[rand.Next(3)];
        }
    }
}
