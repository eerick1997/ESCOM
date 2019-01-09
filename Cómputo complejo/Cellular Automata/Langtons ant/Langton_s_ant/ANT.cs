using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Langton_s_ant
{
    public class ANT
    {
        //ANT STATES
        

        //Time to live
        private int TTL = 50;

        //CELLS STATES
        private const uint DEAD = 0;

        //Ant data
        private int x, y;
        private int orientation;
        private int type;
        private Color color = Color.White;
        /// <summary>
        /// Constructor
        /// </summary>
        /// <param name="x_i">X position</param>
        /// <param name="y_i">Y position</param>
        /// <param name="orientation_i">Orientation</param>
        public ANT(int x_i, int y_i, int orientation_i, int type_i, int TTL_i)
        {
            x = x_i;
            y = y_i;
            orientation = orientation_i;
            type = type_i;
            TTL = (TTL_i == 0)?50:TTL_i;
        }

        public int getType() {
            return type;
        }

        
        public int getTTL() {
            return TTL;
        }

        public void setTTL() {
            Random rand = new Random();
            TTL = rand.Next(45, 60);
        }
        /// <summary>
        /// Rotates the ant to left
        /// </summary>
        public void rotateLeft()
        {
            orientation = (++orientation > Helper.EAST) ? Helper.NORTH : orientation;
        }

        /// <summary>
        /// Rotates the ant to right
        /// </summary>
        public void rotateRight()
        {
            orientation = (--orientation < Helper.NORTH) ? Helper.EAST : orientation;
        }

        public int getX()
        {
            return x;
        }

        public int getY()
        {
            return y;
        }

        public int getOrientation()
        {
            return orientation;
        }

        public void setPosition(int n_position)
        {
            orientation = n_position;
        }
        public void setCoords(int n_x, int n_y)
        {
            x = n_x;
            y = n_y;
        }

        public void setColor(Color n_color)
        {
            color = n_color;
        }

        public Color getColor()
        {
            return color;
        }

        /// <summary>
        /// Calculates the next generation state of the ant
        /// </summary>
        /// <param name="p_matrix">The space</param>
        /// <param name="is_toroid">Enable a closed space</param>
        /// <returns></returns>
        public uint[,] nextGeneration(uint[,] p_matrix, bool is_toroid)
        {
            //Getting the max X and Y size of the space
            int max_x = p_matrix.GetLength(0);
            int max_y = p_matrix.GetLength(1);
            uint current_cell = p_matrix[x, y];
            TTL--;
            //We need to know the value of the actual cell
            switch (current_cell)
            {
                //The cell is dead
                case DEAD:
                    //Set an integer value (uint equivalent of a colour object)
                    p_matrix[x, y] = new ColorHandler().fromColorToInt(getColor());
                    //The ant rotates to the right
                    rotateRight();
                    break;
                //Other case
                default:
                    //Change the state of our current cell to dead
                    p_matrix[x, y] = DEAD;
                    //The ant rotates to the left
                    rotateLeft();
                    break;

            }
            move(max_x - 1, max_y - 1, is_toroid);
            return p_matrix;
        }

        /// <summary>
        /// Changes the X and Y position of our ant.
        /// </summary>
        /// <param name="max_x">Max X size of the space</param>
        /// <param name="max_y">Max Y size of the space</param>
        /// <param name="is_toroid">Enable a closed space</param>
        public void move(int max_x, int max_y, bool is_toroid)
        {
            switch (orientation)
            {

                case Helper.NORTH:
                    //We suppose that the space is a toroid
                    y = ((y) > 0) ? y-1 : max_y;
                    //The space is a toroid?
                    y = (is_toroid) ? y : 0;
                    break;

                case Helper.WEST:
                    //We suppose that the space is a toroid
                    x = ((x) > 0) ? x-1 : max_x;
                    //The space is a toroid?
                    x = (is_toroid) ? x : 0;
                    break;

                case Helper.SOUTH:
                    //We suppouse that space is a toroid
                    y = ((y) < max_y) ? y+1 : 0;
                    //The space is a toroid?
                    y = (is_toroid) ? y : max_y;
                    break;

                case Helper.EAST:
                    //We suppouse that space is a toroid
                    x = ((x) < max_x) ? x+1 : 0;
                    //The space is a toroid?
                    x = (is_toroid) ? x : max_x;
                    break;
            }
        }
    }

}
