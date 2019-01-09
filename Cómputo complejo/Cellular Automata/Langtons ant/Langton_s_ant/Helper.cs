using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Langton_s_ant
{
    public static class Helper
    {
        //Ants types
        public const int QUEEN = 1; 
        public const int MALE = 2;  
        public const int WORKER = 3;
        //Ants orientation
        public const int NORTH = 0;
        public const int WEST = 1;
        public const int SOUTH = 2;
        public const int EAST = 3;

        /// <summary>
        /// Generate a random type of ant
        /// The probability of get a Queen it's 1%
        /// The probability of get a Male it's 2%
        /// The probability of get a Worker it's 97%
        /// </summary>
        /// <returns></returns>
        public static int generateType(int queen_prob, int male_prob) {
            Random random = new Random();
            int rand_val = random.Next(0,100);
            if ((queen_prob + male_prob) >= 100) {
                queen_prob = 1;
                male_prob = 2;
            }
            male_prob += queen_prob;
            if (rand_val >= 0 && rand_val <= queen_prob)
                return QUEEN;
            else if (rand_val > queen_prob && rand_val <= (male_prob))
                return MALE;
            else
                return WORKER;
        }

        /// <summary>
        /// Generate a random orientation of an ant
        /// </summary>
        /// <returns></returns>
        public static int generateOrientation() {
            Random random = new Random();
            int rand_val = random.Next(0, 100);

            if (rand_val >= 0 && rand_val <= 25)
                return NORTH;
            else if (rand_val > 25 && rand_val <= 50)
                return WEST;
            else if (rand_val > 50 && rand_val <= 75)
                return SOUTH;
            else
                return EAST; 
        }

        public static int getOrientationValue(string str) {
            if (str == "North")
                return NORTH;
            else if (str == "West")
                return WEST;
            else if (str == "South")
                return SOUTH;
            else
                return EAST;
        }

        public static int getTypeValue(string str) {
            if (str == "Worker")
                return WORKER;
            else if (str == "Male")
                return MALE;
            else
                return QUEEN;
        }

        /// <summary>
        /// Evaluates the orientation of an ant and returns
        /// a string with the orientation
        /// </summary>
        /// <param name="orientation">Orientation code</param>
        /// <returns>Text of the orientation</returns>
        public static string textOrientation(int orientation) {
            if (orientation == NORTH)
                return "Selected: NORTH";
            else if (orientation == WEST)
                return "Selected: WEST";
            else if (orientation == SOUTH)
                return "Selected: SOUTH";
            else
                return "Selected: EAST";
        }
        /// <summary>
        /// Evaluates the type of an ant and returns
        /// a string with the type
        /// </summary>
        /// <param name="type">Type code</param>
        /// <returns>Text of the type</returns>
        public static string textType(int type) {
            if (type == QUEEN)
                return "Type: QUEEN";
            else if (type == MALE)
                return "Type: MALE";
            else
                return "Type: WORKER";  
        }
    }
}
