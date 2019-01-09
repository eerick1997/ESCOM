using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Langton_s_ant
{
    public class ColorHandler
    {
        private int g_color_index = 1000;
        private readonly int g_offset_increment;

        public ColorHandler() {
            g_offset_increment = 20000;
        }

        public ColorHandler(uint offset_increment) {
            g_offset_increment = (int)offset_increment;
        }
        public uint fromColorToInt(Color color)
        {
            return (uint)((color.A << 24) | (color.R << 16) | (color.G << 8) | (color.B << 0));
        }

        public Color fromIntToColor(uint argb)
        {
            byte[] bytes = BitConverter.GetBytes(argb);
            return Color.FromArgb(bytes[2], bytes[1], bytes[0]);
        }
        
        public Color randomColor() {
            return fromIntToColor( (uint)(g_color_index += g_offset_increment));
        }
    }
}
