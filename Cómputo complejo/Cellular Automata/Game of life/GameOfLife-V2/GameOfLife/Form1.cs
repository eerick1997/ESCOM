using System;
using System.Drawing;
using System.Windows.Forms;
using System.IO;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Threading;

namespace GameOfLife
{

    public partial class Form1 : Form
    {

        /***************************************
         *          GLOBAL VARIABLES           *
         ***************************************/

        private uint[,] matrix;

        private int cellArea = 10;
        private long acumOnes = 0;

        private int generation = 1;
        private int total_cells = 0;

        private Brush alive = Brushes.White;
        private Brush dead = Brushes.Black;
        private Pen grid = Pens.Gray;

        private bool move;
        private uint DEAD = 0;
        private uint ALIVE = 16777215;

        private String[] colors = { "White", "Black", "Red", "Blue", "Green", "Yellow", "Violet", "Gray" };

        /*****************************************
         *          PATTERN RECOGNITION          *
         *****************************************/
        //Here we gonna store all the paterns.
        //Dictionary is an element that works as a hash table, so the first element
        //it's the key the second element it's the value, and for convinence we selected
        //a tuple as the value. 
        //A tuple it's an equivalent of pair in C++, and we can get each element using
        //Tuple.Item1 and Tuple.Item2. For our case the first item will contain 
        //the name or key of a finite automata and the second element will contain
        //the next "state" of the current automata
        private Dictionary<ulong, ulong> data = new Dictionary<ulong, ulong>();
        private Dictionary<ulong, List<ulong>> recurrences = new Dictionary<ulong, List<ulong>>();
        private Dictionary<string, Graph> clasifications = new Dictionary<string, Graph>();
        //Here are all the patterns that we can generate, from 2x2 to 4x4
        private List<Dictionary<ulong, ulong>> patterns = new List<Dictionary<ulong, ulong>>();
        //To make more efficient this application we gonna use threads
        Thread[] thread = new Thread[6];

        private List<uint[,]> figure = new List<uint[,]>();
        private int index_pattern = 0;

        /// <summary>
        /// Constructor
        /// </summary>
        public Form1()
        {
            //Creating UI elements
            InitializeComponent();
            //We init all the predefined figures
            initMosaics();
            //Init the program with a 100, 100 matrix
            createMatrix(100, 100);
            //Make a responsive GUI
            scrollBox();
            //Creating each dictionary for our patterns
            for (int i = 0; i < 6; i++) {
                patterns.Add(new Dictionary<ulong, ulong>());
            }
        }

        private Color getColor() {
            DialogResult result = colorDialog.ShowDialog();
            return colorDialog.Color;
        }
        /// <summary>
        /// This function creates a matrix of bools which size it's n x m
        /// also this function adds an extra pair of cols and rows to 
        /// simulate a toroid   
        /// </summary>  
        /// <param name="rows"></param>
        /// <param name="cols"></param>
        private void createMatrix(int rows, int cols)
        {
            matrix = new uint[cols, rows];
            scrollBox();
        }

        /// <summary>
        /// This method paints the matrix in the Paint Box
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void PBAutomataSimulator_Paint(object sender, PaintEventArgs e)
        {
            int x_size = matrix.GetLength(0);
            int y_size = matrix.GetLength(1);
            total_cells = x_size * y_size;

            Graphics graphics = e.Graphics;

            for (int row = 0; row < x_size; row++)
            {

                for (int col = 0; col < y_size; col++)
                {

                    if (matrix[row, col] != DEAD)
                    {
                        SolidBrush aliveCellColor = new SolidBrush(ColorHandler.fromIntToGradient(matrix[row, col], ALIVE));
                        graphics.FillRectangle(aliveCellColor, row * cellArea, col * cellArea, cellArea, cellArea);
                    }
                    else
                        graphics.FillRectangle(dead, row * cellArea, col * cellArea, cellArea, cellArea);
                }
            }

            for (int y = 0; y < y_size; y++)
            {
                graphics.DrawLine(grid, 0, y * cellArea, total_cells * cellArea, y * cellArea);
            }

            for (int x = 0; x < x_size; x++)
            {
                graphics.DrawLine(grid, x * cellArea, 0, x * cellArea, total_cells * cellArea);
            }
        }

        /// <summary>
        /// This funcion manipulates a matrix and evaluate it 
        /// using our rules. 
        /// </summary>
        /// <param name="p_matrix"></param>
        /// <returns>A matrix with the new generation data</returns>
        private uint[,] nextGeneration(uint[,] p_matrix)
        {

            /****************************************************
             *                  CONDITIONS                      *
             * **************************************************/
            //23 33 GAME OF LIFE
            //77 22 DIFFUSION
            /******************* X values ********************/
            int Xi = Int32.Parse(string.IsNullOrEmpty(ComboBXi.Text) ? "2" : ComboBXi.Text);

            /******************* Y values ********************/
            int Yi = Int32.Parse(string.IsNullOrEmpty(ComboBYi.Text) ? "3" : ComboBYi.Text);

            /******************* X2 values *******************/
            int X2i = Int32.Parse((string.IsNullOrEmpty(ComboBX2i.Text) ? "3" : ComboBX2i.Text));

            /******************* Y2 values *******************/
            int Y2i = Int32.Parse((string.IsNullOrEmpty(ComboBY2i.Text) ? "3" : ComboBY2i.Text));

            uint[,] new_matrix = new uint[p_matrix.GetLength(0), p_matrix.GetLength(1)];
            //We check each cell from the original matrix and we substitute it
            for (int row = 0; row < p_matrix.GetLength(0); row++)
            {

                for (int col = 0; col < p_matrix.GetLength(1); col++)
                {
                    /**
                     * Here we need to evaluate using the rules given by input
                     **/
                    int neighbors = getAliveNeighbors(p_matrix, row, col);
                    //If the cell is alive
                    if (p_matrix[row, col] != DEAD)
                    {
                        uint color_cell = p_matrix[row, col] - 1;
                        new_matrix[row, col] = (neighbors >= Xi && neighbors <= Yi) ? (color_cell) : DEAD;
                    }
                    //If the central cell is dead
                    else
                    {
                        new_matrix[row, col] = (neighbors >= X2i && neighbors <= Y2i) ? ALIVE : DEAD;
                    }
                }

            }

            return new_matrix;
        }

        /// <summary>
        /// Gets information about the cells around a central cell. 
        /// Obviouslly the cells must to be alive.
        /// </summary>
        /// <param name="p_matrix">The actual matrix</param>
        /// <param name="p_row">row of the central cell</param>
        /// <param name="p_col">col of the central cell</param>
        /// <returns>Number of neighboors around the central cell (just living neighbors)</returns>
        private int getAliveNeighbors(uint[,] p_matrix, int p_row, int p_col)
        {

            int neighbors = 0;
            int max_x = p_matrix.GetLength(0);
            int max_y = p_matrix.GetLength(1);
            uint[,] sub_matrix = new uint[3, 3];

            for (int row = -1, sx = 0; row <= 1; row++, sx++)
            {

                for (int col = -1, sy = 0; col <= 1; col++, sy++)
                {

                    int x = row + p_row;
                    int y = col + p_col;

                    //We are in the center cell
                    if (x == p_row && y == p_col)
                    {
                        sub_matrix[sx, sy] = p_matrix[x, y];
                        continue;
                    }
                    // ----- Corners ----- //

                    //Up-Left
                    if (x == -1 && y == -1 && (p_matrix[max_x - 1, max_y - 1] != DEAD))
                    {
                        sub_matrix[sx, sy] = p_matrix[max_x - 1, max_y - 1];
                        neighbors++;
                    }
                    //Down-Right
                    if (x == max_x && y == max_y && (p_matrix[0, 0] != DEAD))
                    {
                        sub_matrix[sx, sy] = p_matrix[0, 0];
                        neighbors++;
                    }
                    //Up-Right
                    if (x == -1 && y == max_y && (p_matrix[max_x - 1, 0] != DEAD))
                    {
                        sub_matrix[sx, sy] = p_matrix[max_x - 1, 0];
                        neighbors++;
                    }
                    //Down-left
                    if (x == max_x && y == -1 && (p_matrix[0, max_y - 1] != DEAD))
                    {
                        sub_matrix[sx, sy] = p_matrix[0, max_y - 1];
                        neighbors++;
                    }
                    // ----- Edges ----- //

                    if (y >= 0 && y < max_y)
                    {
                        //Up
                        if (x == -1 && p_matrix[max_x - 1, y] != DEAD)
                        {
                            sub_matrix[sx, sy] = p_matrix[max_x - 1, y];
                            neighbors++;
                        }
                        //Down
                        else if (x == max_x && p_matrix[0, y] != DEAD)
                        {
                            sub_matrix[sx, sy] = p_matrix[0, y];
                            neighbors++;
                        }
                    }
                    if (x >= 0 && x < max_x)
                    {
                        //Right
                        if (y == -1 && p_matrix[x, max_y - 1] != DEAD)
                        {
                            sub_matrix[sx, sy] = p_matrix[x, max_y - 1];
                            neighbors++;
                        }
                        //Left
                        else if (y == max_y && p_matrix[x, 0] != DEAD)
                        {
                            sub_matrix[sx, sy] = p_matrix[x, 0];
                            neighbors++;
                        }
                    }

                    if (x < 0 || x >= max_x)
                    {
                        continue;
                    }

                    if (y < 0 || y >= max_y)
                    {
                        continue;
                    }

                    if (p_matrix[x, y] != DEAD)
                    {
                        sub_matrix[sx, sy] = p_matrix[x, y];
                        neighbors++;
                    }

                }
            }
            if (CBPatternRecognition.Checked) {
                patternRecognition(generateMatrixPatterns(p_matrix, p_row, p_col, 2));
                patternRecognition(sub_matrix);
                patternRecognition(generateMatrixPatterns(p_matrix, p_row, p_col, 4));
            }
            return neighbors;
        }

        /// <summary>
        /// This method calls nextGeneration method and
        /// updates the GUI and the count of our alive cells
        /// </summary>
        private void step()
        {
            matrix = nextGeneration(matrix);
            updateTextGeneration();
            countOnes();
            PBAutomataSimulator.Invalidate();
        }

        /// <summary>
        /// Here we just change the text that show us
        /// the number of generations
        /// </summary>
        private void updateTextGeneration()
        {
            TXTGeneration.Text = "Generation: " + generation++;
        }

        /// <summary>
        /// This method make a rezise of the Paint Box and flow layout panel
        /// it makes possible make zoom and the movement into the GUI
        /// </summary>
        private void scrollBox()
        {
            PBAutomataSimulator.Size = new Size((matrix.GetLength(0)) * cellArea, (matrix.GetLength(1)) * cellArea);
            PBAutomataSimulator.SizeMode = PictureBoxSizeMode.AutoSize;
            flowLayoutPanel1.AutoScroll = true;
            flowLayoutPanel1.Controls.Add(PBAutomataSimulator);
        }

        /// <summary>
        /// As you can imagine here we just get the number of ones
        /// in our matrix (alive cells)
        /// </summary>
        private void countOnes()
        {
            int ones = 0;
            for (int x = 0; x < matrix.GetLength(0); x++)
            {

                for (int y = 0; y < matrix.GetLength(1); y++)
                {
                    if (matrix[x, y] != DEAD) ones++;
                }
            }

            if (CheckGraphEnabled.Checked)
                CHHistogram.Series["#Ones"].Points.AddY(ones);
            TXTPopulation.Text = "Population " + ones;
            acumOnes += ones;
            double val = acumOnes / generation;
            label12.Text = "Total Population: " + acumOnes;
            label13.Text = "Average: " + (val);
            label14.Text = "Density: " + (val / (matrix.GetLength(0) * matrix.GetLength(1)));
        }

        /****************************************************************************************************
         *                                      SECOND TERM CODE                                            *
         ****************************************************************************************************/

        /// <summary>
        /// This funciton generates multiple binary string one per each
        /// matrix dimension. For our case the maximum matrix will be
        /// of 7 x 7 at most
        /// </summary>
        private void generatePatterns(int size)
        {
            data.Clear();
            recurrences.Clear();
            clasifications.Clear();
            Console.WriteLine("generatePatterns(" + size + ")");
            //To generate all the possible combinations inside
            //a matrix from 2x2 to 8x8 (just square) we gonna
            //to convert from a decimal number to a binary string
            //so, size_string contains the limit of combinations
            //in each matrix n^2 where n is the size of each matrix
            try
            {
                int size_string = 0;
                ulong n_combinations = 0;
                SaveFileDialog saveFileDialog = new SaveFileDialog();
                saveFileDialog.Filter = "Archivo de texto|*.txt";
                saveFileDialog.Title = "Patterns file name";
                saveFileDialog.ShowDialog();
                StreamWriter sw = new StreamWriter(saveFileDialog.OpenFile());
                //Size of the binary string: 2^2, 3^2, 4^2, ... , 7^2
                size_string = size * size;
                //Now we get the number of combinations it is 2^size_string
                n_combinations = (ulong)Math.Pow(2.0, size_string);
                sw.Write("GraphPlot[{");
                //We iterate from 0 to 2^n and convert this number to a binary string
                for (ulong j = 1; j < n_combinations; j++)
                {
                    //We convert j to a binary string
                    string str_binary = Convert.ToString((long)j, 2);
                    while (str_binary.Length != size_string)
                    {
                        str_binary = "0" + str_binary;
                    }
                    uint[,] next_state = nextGeneration(fromBinaryToMatrix(str_binary));
                    string str_next_state = fromMatrixToString(next_state);
                    ulong nextState = Convert.ToUInt64(str_next_state, 2);
                    if (saveFileDialog != null) {
                        sw.Write(j + "->" + nextState + ((j < n_combinations - 1) ? ", " : ""));
                        data.Add(j, nextState);
                    }
                }
                sw.Write("}]");
                sw.Close();
                MessageBox.Show("I've stored something");
                //Sorting the paterns created
                sortTransitions();
                //Create some objects with the paterns
                CreateGraphObjects();
                //We create a file to send it to mathematica
                outputMathematica();
            }
            catch (Exception e) {
                Console.WriteLine("An exception has occurred on generatePatterns " + e);
            }
        }

        /// <summary>
        /// Generate a txt file with the structure of a mathematica file
        /// </summary>
        private void outputMathematica() {
            Dictionary<ulong, ulong> unique_nodes = new Dictionary<ulong, ulong>();
            try {
                SaveFileDialog saveFileDialog = new SaveFileDialog();
                saveFileDialog.Filter = "Archivo de texto|*.txt";
                saveFileDialog.Title = "Paterns filtered";
                saveFileDialog.ShowDialog();
                StreamWriter sw = new StreamWriter(saveFileDialog.OpenFile());

                sw.Write("GraphPlot[{");
                foreach (KeyValuePair<string, Graph> item_graph in clasifications) {
                    Graph current_graph = item_graph.Value;
                    Dictionary<ulong, List<ulong>> node = current_graph.getAllNodes();
                    foreach (KeyValuePair<ulong, List<ulong>> item in node) {

                        for (int i = 0; i < item.Value.Count; i++) {
                            if (!unique_nodes.ContainsKey(item.Value[i]))
                                unique_nodes.Add(item.Value[i], item.Key);
                        }
                    }
                }

                foreach (KeyValuePair<ulong, ulong> item in unique_nodes)
                    sw.Write(item.Key + "->" + item.Value + ((item.Key == unique_nodes.Last().Key) ? "" : ","));
                sw.Write("}]");
                sw.Close();
                MessageBox.Show("I've stored something  ");
            }
            catch (Exception e) {
                Console.WriteLine("An exception has occurred creating a mathematica file " + e);
            }
        }
        /// <summary>
        /// This function generate a matrix using a binary string.
        /// We are just considering a square matrix, so we can 
        /// calculate the number of rows and cols calculating 
        /// the square root of the binary_string size
        /// </summary>
        /// <param name="binary_string">This string
        /// contains a matrix but in a dimension</param>
        private uint[,] fromBinaryToMatrix(string binary_string)
        {
            //We get the size of our sub_matrix. As we know 
            //the matrix it's a square, so we need to calculate
            //the square root of the length of the binary string
            int size = Convert.ToInt16(Math.Sqrt(binary_string.Length));
            //We create a new boolean matrix
            uint[,] sub_matrix = new uint[size, size];
            //We build the sub matrix using our binary string
            for (int x = 0, position = 0; x < size; x++)
            {
                for (int y = 0; y < size; y++)
                {
                    //We add an element int the x'th row in the y'th position
                    //If this element it's equals to an one we put true in out sub matrix
                    sub_matrix[x, y] = (binary_string[position++] == '0') ? DEAD : ALIVE;

                }

            }
            return sub_matrix;
        }

        /// <summary>
        /// Convert a matrix to a binary string
        /// </summary>
        /// <param name="a_matrix">Source matrix</param>
        /// <returns>Binary string</returns>
        private string fromMatrixToString(uint[,] a_matrix)
        {
            string str = "";

            for (int i = 0; i < a_matrix.GetLength(0); i++) {
                for (int j = 0; j < a_matrix.GetLength(1); j++) {
                    str += (a_matrix[i, j] == DEAD ? "0" : "1");
                }
            }

            return str;
        }

        /// <summary>
        /// Just for testing
        /// </summary>
        /// <param name="a_matrix">Source matrix</param>
        private void printMatrix(int[,] a_matrix) {

            Console.WriteLine(" ----------------------------------------------- ");
            for (int i = 0; i < a_matrix.GetLength(0); i++) {

                for (int j = 0; j < a_matrix.GetLength(1); j++) {
                    Console.Write(" " + ((a_matrix[i, j] == DEAD) ? "1" : "0"));
                }
                Console.WriteLine();
            }
            Console.WriteLine(" ----------------------------------------------- ");
        }
        /// <summary>
        /// This function
        /// </summary>
        /// <param name="sub_matrix"></param>
        private void patternRecognition(uint[,] p_matrix)
        {
            int dimension = p_matrix.GetLength(0);
            ulong key = Convert.ToUInt64(fromMatrixToString(p_matrix), 2);

            if (!patterns[dimension].ContainsKey(key))
                patterns[dimension].Add(key, 1);
            else
                patterns[dimension][key]++;
        }

        private uint[,] generateMatrixPatterns(uint[,] p_matrix, int p_row, int p_col, int dimension) {
            int init = -1;
            int end = 0;

            if (dimension == 4)
            {
                init = -2;
                end = 1;
            }

            int max_x = p_matrix.GetLength(0);
            int max_y = p_matrix.GetLength(1);
            uint[,] sub_matrix = new uint[dimension, dimension];

            for (int row = init, sx = 0; row <= end; row++, sx++)
            {

                for (int col = init, sy = 0; col <= end; col++, sy++)
                {

                    int x = row + p_row;
                    int y = col + p_col;

                    //We are in the center cell
                    if (x == p_row && y == p_col)
                    {
                        sub_matrix[sx, sy] = p_matrix[x, y];
                        continue;
                    }
                    // ----- Corners ----- //

                    //Up-Left
                    if (x < 0 && y < 0 && (p_matrix[max_x + x, max_y + y] != DEAD))
                    {
                        sub_matrix[sx, sy] = p_matrix[max_x + x, max_y + y];
                    }
                    //Down-Right
                    if (x >= max_x && y >= max_y && (p_matrix[x - max_x, y - max_y] != DEAD))
                    {
                        sub_matrix[sx, sy] = p_matrix[x - max_x, y - max_y];
                    }
                    //Up-Right
                    if (x < 0 && y == max_y && (p_matrix[max_x + x, 0] != DEAD))
                    {
                        sub_matrix[sx, sy] = p_matrix[max_x + x, 0];
                    }
                    //Down-left
                    if (x >= max_x && y < 0 && (p_matrix[x - max_x, max_y + y] != DEAD))
                    {
                        sub_matrix[sx, sy] = p_matrix[x - max_x, max_y + y];
                    }
                    // ----- Edges ----- //

                    if (y >= 0 && y < max_y)
                    {
                        //Up
                        if (x < 0 && p_matrix[x + max_x, y] != DEAD)
                        {
                            sub_matrix[sx, sy] = p_matrix[x + max_x, y];
                        }
                        //Down
                        else if (x >= max_x && p_matrix[x - max_x, y] != DEAD)
                        {
                            sub_matrix[sx, sy] = p_matrix[x - max_x, y];
                        }
                    }
                    if (x >= 0 && x < max_x)
                    {
                        //Right
                        if (y < 0 && p_matrix[x, y + max_y] != DEAD)
                        {
                            sub_matrix[sx, sy] = p_matrix[x, y + max_y];
                        }
                        //Left
                        else if (y >= max_y && p_matrix[x, y - max_y] != DEAD)
                        {
                            sub_matrix[sx, sy] = p_matrix[x, y - max_y];
                        }
                    }

                    if (x < 0 || x >= max_x)
                    {
                        continue;
                    }

                    if (y < 0 || y >= max_y)
                    {
                        continue;
                    }

                    if (p_matrix[x, y] != DEAD)
                    {
                        sub_matrix[sx, sy] = p_matrix[x, y];
                    }

                }
            }
            return sub_matrix;
        }
        
        private void storePatterns(int dimension) {
            try {
                SaveFileDialog saveFileDialog = new SaveFileDialog();
                saveFileDialog.Filter = "Archivo de texto|*.txt";
                saveFileDialog.Title = "Patterns found " + dimension + "x" + dimension;
                saveFileDialog.ShowDialog();
                StreamWriter sw = new StreamWriter(saveFileDialog.OpenFile());
                sw.WriteLine("---------- Patterns found in a " + dimension + " x " + dimension + " matrix ----------");
                foreach (KeyValuePair<ulong, ulong> item in patterns[dimension]) {
                    sw.WriteLine(item.Key + " appears " + item.Value + " times ");
                }
                sw.Close();
            }
            catch (Exception e) {
                Console.WriteLine("An exception has occurred on storePatterns() " + e);
            }
        }
        
        /// <summary>
        /// This function intialize our predefined patterns. This patterns
        /// allow us to draw and drop patterns into the automata space.
        /// </summary>
        private void initMosaics()
        {

            figure.Add(null);

            figure.Add(new uint[,] { { ALIVE, ALIVE},
                                     { ALIVE, ALIVE } });

            figure.Add(new uint[,] { { ALIVE, ALIVE, DEAD, ALIVE, ALIVE},
                                     { ALIVE, DEAD, DEAD, DEAD, ALIVE },
                                     { DEAD, ALIVE, ALIVE, ALIVE, DEAD } });

            figure.Add(new uint[,] { { ALIVE, ALIVE, DEAD },
                                     { ALIVE, DEAD, ALIVE },
                                     { DEAD, ALIVE, ALIVE } });

            figure.Add(new uint[,] { { DEAD, ALIVE, DEAD },
                                     { DEAD, DEAD, ALIVE },
                                     { ALIVE, ALIVE, ALIVE } });

            figure.Add(new uint[,] { { DEAD, ALIVE, DEAD },
                                     { ALIVE, DEAD, ALIVE},
                                     { DEAD, ALIVE, DEAD} });

            figure.Add(new uint[,] { { DEAD, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE, ALIVE },
                                     { ALIVE, DEAD, DEAD, DEAD, DEAD, DEAD, ALIVE },
                                     { DEAD, DEAD, DEAD, DEAD, DEAD, DEAD, ALIVE},
                                     { ALIVE, DEAD, DEAD, DEAD, DEAD, ALIVE, DEAD },
                                     { DEAD, DEAD, ALIVE, ALIVE, DEAD, DEAD, DEAD } });

            figure.Add(new uint[,] { { ALIVE, DEAD, DEAD },
                                     { DEAD, DEAD, ALIVE },
                                     { DEAD, DEAD, ALIVE },
                                     { ALIVE, DEAD, DEAD } });

            figure.Add(new uint[,] { { DEAD, ALIVE, ALIVE, DEAD },
                                     { ALIVE, DEAD, DEAD, DEAD },
                                     { ALIVE, DEAD, DEAD, DEAD },
                                     { DEAD, ALIVE, ALIVE, DEAD } });

            figure.Add(new uint[,] { { ALIVE, ALIVE, ALIVE } });

            figure.Add(new uint[,] { { DEAD, DEAD, ALIVE },
                                     { ALIVE, DEAD, DEAD },
                                     { ALIVE, DEAD, DEAD },
                                     { DEAD, ALIVE, DEAD } });

        }

        /// <summary>
        /// Sort the elements of out Dictionary called data.
        /// The elements are sorted using the Value
        /// </summary>
        private void sortTransitions()
        {

            foreach (var item in data.OrderByDescending(key => key.Value))
            {
                if (!recurrences.ContainsKey(item.Value))
                {
                    List<ulong> aux = new List<ulong>();
                    aux.Add(item.Key);
                    recurrences.Add(item.Value, aux);
                }
                else
                    recurrences[item.Value].Add(item.Key);
            }

        }

        private void CreateGraphObjects()
        {
            //Itering into each element of the Dictionary
            foreach (KeyValuePair<ulong, List<ulong>> item in recurrences)
            {
                Dictionary<ulong, List<ulong>> aux = new Dictionary<ulong, List<ulong>>();
                aux.Add(item.Key, item.Value);
                //Itering through each element of the list
                for (int i = 0; i < item.Value.Count; i++)
                {
                    ulong element_list = item.Value[i];
                    if (recurrences.ContainsKey(element_list))
                    {
                        if (!aux.ContainsKey(element_list))
                            aux.Add(element_list, recurrences[element_list]);
                    }

                }
                Graph graph_element = new Graph(aux);
                //List<ulong> key = graph_element.getKey();
                string key = graph_element.getKey();
                if (aux.Count > 0 && !clasifications.ContainsKey(key))
                    clasifications.Add(key, graph_element);
            }
        }

        /// <summary>
        /// Comer if two list are equal
        /// </summary>
        /// <param name="first_list">First list</param>
        /// <param name="second_list">Second list</param>
        /// <returns>true if the lists are equals</returns>
        private bool compareTwoList(List<ulong> first_list, List<ulong> second_list)
        {
            if (first_list.Count != second_list.Count)
                return false;

            for (int i = 0; i < first_list.Count; i++)
            {
                if (first_list[i] != second_list[i])
                    return false;
            }
            return true;
        }
        
        /// <summary>
        /// Just for testing
        /// </summary>
        private void printRecurrences()
        {
            foreach (KeyValuePair<ulong, List<ulong>> item in recurrences)
            {
                Console.WriteLine("Element " + item.Key);
                for (int i = 0; i < item.Value.Count; i++)
                {
                    Console.Write(item.Value[i] + " ");
                }
                Console.WriteLine();
            }
        }


        /*****************************************************
         *                      Events                       *
         *****************************************************/

        private void BTNStep_Click(object sender, EventArgs e)
        {
            step();
        }

        private void PBAutomataSimulator_MouseDown(object sender, MouseEventArgs e)
        {
            int x = e.X / cellArea;
            int y = e.Y / cellArea;
            matrix[x, y] = (matrix[x, y] == ALIVE) ? DEAD : ALIVE;
            PBAutomataSimulator.Invalidate();
        }

        private void BTNStart_Click(object sender, EventArgs e)
        {
            if (BTNStart.Text == "Start")
            {
                TimerSimulation.Start();
                BTNStart.Text = "Stop";
            }
            else
            {
                TimerSimulation.Stop();
                BTNStart.Text = "Start";
            }
        }

        private void trackBar1_ValueChanged(object sender, EventArgs e)
        {
            TimerSimulation.Interval = TBSpeed.Value;
        }

        private void TimerSimulation_Tick(object sender, EventArgs e)
        {
            step();
        }

        private void BTNZoomP_Click(object sender, EventArgs e)
        {
            if (cellArea < 50)
            {
                cellArea++;
                PBAutomataSimulator.Invalidate();
                scrollBox();
            }
        }

        private void BTNZoomM_Click(object sender, EventArgs e)
        {
            if (cellArea > 1)
            {
                cellArea--;
                PBAutomataSimulator.Invalidate();
                scrollBox();
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Random r = new Random();
            for (int x = 0; x < matrix.GetLength(0); x++)
            {

                for (int y = 0; y < matrix.GetLength(1); y++)
                {

                    float rand = r.Next(0, 100);
                    if (rand < double.Parse(numericOnes.Text))
                    {
                        matrix[x, y] = ALIVE;
                    }
                    else matrix[x, y] = DEAD;
                }
            }
            PBAutomataSimulator.Invalidate();
        }

        private void BTNClear_Click(object sender, EventArgs e)
        {
            CHHistogram.Series["#Ones"].Points.Clear();
            for (int x = 0; x < matrix.GetLength(0); x++)
            {

                for (int y = 0; y < matrix.GetLength(1); y++)
                {
                    matrix[x, y] = DEAD;
                }
            }
            PBAutomataSimulator.Invalidate();
            acumOnes = generation = 0;
            for (int i = 0; i < patterns.Count; i++) {
                patterns[i].Clear();
            }
        }

        private void BTNCreateMatrix_Click(object sender, EventArgs e)
        {
            int rows = (numericRows.Value == 0) ? 100 : (int)numericRows.Value;
            int cols = (numericCols.Value == 0) ? 100 : (int)numericCols.Value;
            createMatrix(rows, cols);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            int min_lines = 0;
            int min_chara = 0;
            String fileName = null;

            try
            {
                using (OpenFileDialog openFileDialog = new OpenFileDialog())
                {
                    openFileDialog.InitialDirectory = "c\\";
                    openFileDialog.Filter = "txt files (*.txt)|*.txt";
                    openFileDialog.FilterIndex = 2;
                    if (openFileDialog.ShowDialog() == DialogResult.OK)
                    {
                        fileName = openFileDialog.FileName;
                    }
                }

                if (fileName != null)
                {
                    Console.WriteLine(fileName);
                    StreamReader objectReader = new StreamReader(fileName);
                    //Reading the file, line per line
                    String line = "";
                    ArrayList arrayText = new ArrayList();
                    while (line != null)
                    {
                        line = objectReader.ReadLine();
                        if (line != null)
                            arrayText.Add(line);
                    }
                    objectReader.Close();
                    //Iterate into the ArrayList and send the information to the GUI
                    min_lines = arrayText.Count;
                    min_chara = arrayText[0].ToString().Length;

                    Console.WriteLine(min_chara);
                    Console.WriteLine(min_lines);
                    if (min_chara > matrix.GetLength(1) && min_lines > matrix.GetLength(0))
                    {
                        createMatrix(min_chara, min_lines);
                    }
                    for (int i = 0; i < min_lines; i++)
                    {
                        string strlne = arrayText[i].ToString().Trim();
                        int j = 0;

                        foreach (char c in strlne)
                        {
                            matrix[j++, i] = (c == '1')?ALIVE:DEAD;
                        }
                    }
                    Console.ReadLine();
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }
            PBAutomataSimulator.Invalidate();
        }

        private void BTNSave_Click(object sender, EventArgs e)
        {

            try
            {
                SaveFileDialog saveFileDialog = new SaveFileDialog();
                saveFileDialog.Filter = "Archivo de texto|*.txt";
                saveFileDialog.Title = "Actual state cellular automata";
                saveFileDialog.ShowDialog();
                if (saveFileDialog != null)
                {
                    StreamWriter sw = new StreamWriter(saveFileDialog.OpenFile());
                    for (int i = 0; i < matrix.GetLength(0); i++)
                    {

                        for (int j = 0; j < matrix.GetLength(1); j++)
                            sw.Write(((matrix[j, i] == DEAD) ? "1" : "0"));
                        sw.WriteLine();
                    }
                    sw.Close();
                    MessageBox.Show("I've stored something");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex);
            }

        }

        private void PBAutomataSimulator_MouseMove(object sender, MouseEventArgs e)
        {
            try
            {
                if (move && index_pattern != 0)
                {
                    int x = e.X / cellArea;
                    int y = e.Y / cellArea;

                    uint[,] draw_figure = figure[index_pattern];
                    int x_size = (draw_figure).GetLength(1);
                    int y_size = (draw_figure).GetLength(0);
                    initMosaics();
                    for (int x_c = 0; x_c < x_size; x_c++)
                    {

                        for (int y_c = 0; y_c < y_size; y_c++)
                        {
                            matrix[x_c + x, y_c + y] = draw_figure[y_c, x_c];
                        }
                    }
                    PBAutomataSimulator.Invalidate();
                    move = false;
                    index_pattern = 0;
                }
            }
            catch (Exception) {
               
            }
        }

        private void pictureBox1_MouseUp(object sender, MouseEventArgs e)
        {
            move = true;
            index_pattern = 1;
        }

        private void pictureBox2_MouseUp(object sender, MouseEventArgs e)
        {
            move = true;
            index_pattern = 2;
        }

        private void pictureBox3_MouseUp(object sender, MouseEventArgs e)
        {
            move = true;
            index_pattern = 3;
        }

        private void pictureBox4_MouseUp(object sender, MouseEventArgs e)
        {
            move = true;
            index_pattern = 4;
        }

        private void pictureBox5_MouseUp(object sender, MouseEventArgs e)
        {
            move = true;
            index_pattern = 5;
        }

        private void pictureBox6_MouseUp(object sender, MouseEventArgs e)
        {
            move = true;
            index_pattern = 6;
        }

        private void pictureBox7_MouseUp(object sender, MouseEventArgs e)
        {
            move = true;
            index_pattern = 7;
        }

        private void pictureBox8_MouseUp(object sender, MouseEventArgs e)
        {
            move = true;
            index_pattern = 8;
        }

        private void pictureBox9_MouseUp(object sender, MouseEventArgs e)
        {
            move = true;
            index_pattern = 9;
        }

        private void pictureBox10_MouseUp(object sender, MouseEventArgs e)
        {
            move = true;
            index_pattern = 10;
        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            Color color = getColor();
            alive = new SolidBrush(color);
            ALIVE = ColorHandler.fromColorToInt(color);
            initMosaics();
            PBAutomataSimulator.Invalidate();
        }

        private void BTNDeadCells_Click(object sender, EventArgs e)
        {
            dead = new SolidBrush(getColor());
            initMosaics();
            PBAutomataSimulator.Invalidate();
        }

        private void BTNGrid_Click(object sender, EventArgs e)
        {
            grid = new Pen(getColor());
            PBAutomataSimulator.Invalidate();
        }

        private void CBPoints_CheckedChanged(object sender, EventArgs e)
        {
            if (CBPoints.Checked)
                CHHistogram.Series[0].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Point;
            else
                CHHistogram.Series[0].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Column;
        }
        
        private void generatePatternsToolStripMenuItem_Click(object sender, EventArgs e)
        {
            try
            {
                string value = Microsoft.VisualBasic.Interaction.InputBox("Write the dimension of the matrix", "Generate patterns", "", 0, 0);
                //Generating patterns
                if (Convert.ToInt16(value) <= 4)
                    generatePatterns(Convert.ToInt16(value));
                else
                    MessageBox.Show("I'm sorry but the maximum size it's 4 :c");
            }
            catch (Exception ex) {
                Console.WriteLine("An exception has occured capturing text to generate patterns " + ex);
            }
        }

        private void BTNSavePatterns_Click(object sender, EventArgs e)
        {
            if (CBPatternRecognition.Checked)
            {
                for (int i = 2; i <= 4; i++)
                {
                    storePatterns(i);
                }
            }
            else
                MessageBox.Show("No se han guardado datos hasta ahora");
        }
    }
}