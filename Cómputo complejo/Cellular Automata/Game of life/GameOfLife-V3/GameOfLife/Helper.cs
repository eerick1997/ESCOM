using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfLife
{
    static class Helper
    {
        public const int MAJORITY = 0;
        public const int MINORITY = 1;
        public const int PARITY = 2;

        public const int NORMAL = 3;
        public const int MEMORY = 4;

        public static int getRule(string str) {
            if (str == "Majority")
                return MAJORITY;
            else if (str == "Minority")
                return MINORITY;
            else
                return PARITY;
        }

        public static int getSpaceType(string str) {
            return (str == "Normal") ? NORMAL : MEMORY;
        }

        public static uint getMajority(uint n_ones, int T) {
            return (uint)((n_ones > (T - n_ones)) ? 1 : 0);
        }

        public static uint getMinority(uint n_ones, int T) {
            return (uint)((n_ones < (T - n_ones))? 1: 0);
        }

        public static uint getParity(uint n_ones, int T) {
            return (uint)((((T - n_ones) == n_ones)) ? 1 : 0 );
        }
    }
}
