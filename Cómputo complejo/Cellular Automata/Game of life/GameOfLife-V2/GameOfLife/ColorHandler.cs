using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameOfLife
{
    /// <summary>
    /// This class has been made to manipulate colors
    /// </summary>
    public static class ColorHandler
    {
        /// <summary>
        /// Convert from a color objet to an unsigned int
        /// </summary>
        /// <param name="color">Source color</param>
        /// <returns>unsigned int value of the color</returns>
        public static uint fromColorToInt(Color color)
        {
            return (uint)((color.A << 24) | (color.R << 16) | (color.G << 8) | (color.B << 0));
        }
        /// <summary>
        /// Convert from an unsigned int to a color object
        /// </summary>
        /// <param name="argb">Unsigned int value of a color</param>
        /// <returns>A color object</returns>
        public static Color fromIntToColor(uint argb)
        {
            byte[] bytes = BitConverter.GetBytes(argb);
            return Color.FromArgb(bytes[2], bytes[1], bytes[0]);
        }

        public static Color fromIntToGradient(uint code, uint base_color) {
            try
            {
                if (code <= base_color && code > base_color - 10)
                {
                    return fromIntToColor(base_color);
                }
                else if (code <= base_color - 10 && code > base_color - 20)
                {
                    return Color.FromArgb(255, 153, 153, 255);
                }
                else if (code <= base_color - 20 && code > base_color - 30)
                {
                    return Color.FromArgb(255, 102, 102, 255);
                }
                else if (code <= base_color - 30 && code > base_color - 40)
                {
                    return Color.FromArgb(255, 51, 51, 255);
                }
                else
                {
                    return Color.FromArgb(255, 0, 0, 255);
                }
            }
            catch (Exception) {
                return fromIntToColor(base_color);
            }
            //return Color.FromArgb(255,0, 0, (int)code);
        }
        
        
    }
}
