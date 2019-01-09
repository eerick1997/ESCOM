using System;
using System.Drawing;
using System.Windows.Forms;
using System.IO;
using System.Collections;

namespace GameOfLife
{

    public partial class Form1 : Form
    {

        /***************************************
         *          GLOBAL VARIABLES           *
         ***************************************/

        private bool[,] matrix;

        private int cellArea = 10;
        private int generation = 1;

        private Brush alive = Brushes.White;
        private Brush dead = Brushes.Black;

        private String[] colors = { "White", "Black", "Red", "Blue", "Green", "Yellow", "Violet"};
        /// <summary>
        /// Constructor
        /// </summary>
        public Form1()
        {
            InitializeComponent();
            createMatrix(50, 50);
            scrollBox();
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
            matrix = new bool[cols, rows];
            scrollBox();
        }

        /// <summary>
        /// This method paints the matrix in the Paint Box
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void PBAutomataSimulator_Paint(object sender, PaintEventArgs e)
        {

            Graphics graphics = e.Graphics;

            for (int row = 0; row < matrix.GetLength(0); row++)
            {

                for (int col = 0; col < matrix.GetLength(1); col++)
                {

                    Brush b;

                    if (matrix[row, col])
                        b = alive;
                    else
                        b = dead;

                    graphics.FillRectangle(b, row * cellArea, col * cellArea, cellArea, cellArea);

                }
            }
        }

        /// <summary>
        /// This funcion manipulates a matrix and evaluate it 
        /// using our rules. 
        /// </summary>
        /// <param name="p_matrix"></param>
        /// <returns>A matrix with the new generation data</returns>
        private bool[,] nextGeneration(bool[,] p_matrix)
        {

            /****************************************************
             *                  CONDITIONS                      *
             * **************************************************/

            /******************* X values ********************/
            int Xi = Int32.Parse(string.IsNullOrEmpty(ComboBXi.Text) ? "2" : ComboBXi.Text);

            /******************* Y values ********************/
            int Yi = Int32.Parse(string.IsNullOrEmpty(ComboBYi.Text) ? "3" : ComboBYi.Text);

            /******************* X2 values *******************/
            int X2i = Int32.Parse((string.IsNullOrEmpty(ComboBX2i.Text) ? "3" : ComboBX2i.Text));

            /******************* Y2 values *******************/
            int Y2i = Int32.Parse((string.IsNullOrEmpty(ComboBY2i.Text) ? "3" : ComboBY2i.Text));

            bool[,] new_matrix = new bool[p_matrix.GetLength(0), p_matrix.GetLength(1)];
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
                    if (p_matrix[row, col])
                    {
                        new_matrix[row, col] = (neighbors >= Xi && neighbors <= Yi);
                    }
                    //If the central cell is dead
                    else
                    {
                        new_matrix[row, col] = (neighbors >= X2i && neighbors <= Y2i);
                    }

                }

            }
            updateTextGeneration();
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
        private int getAliveNeighbors(bool[,] p_matrix, int p_row, int p_col)
        {

            int neighbors = 0;
            try
            {
                int max_rows = p_matrix.GetLength(0);
                int max_cols = p_matrix.GetLength(1);

                for (int row = -1; row <= 1; row++)
                {

                    for (int col = -1; col <= 1; col++)
                    {

                        int c_row = row + p_row;
                        int c_col = col + p_col;

                        //We are in the center cell
                        if (c_row == p_row && c_col == p_col)
                        {
                            continue;
                        }
                        //Corners//
                        if (c_row == -1 && c_col == -1 & p_matrix[max_rows - 1, max_cols - 1])
                            neighbors++;
                        else if (c_row == max_rows && c_col == max_cols && p_matrix[0, 0])
                            neighbors++;
                        else if (c_row == -1 && c_col == max_cols && p_matrix[max_rows - 1, 0])
                            neighbors++;
                        else if (c_row == max_rows && c_col == -1 && p_matrix[0, max_cols -1])
                            neighbors++;
                        else
                        //Left right
                        if (c_row == -1 && p_matrix[max_rows - 1, c_col])
                            neighbors++;
                        else if (c_row == max_rows && p_matrix[0, c_col])
                            neighbors++;

                        //Up down
                        else if (c_col == -1 && p_matrix[c_row, max_cols - 1])
                            neighbors++;
                        else if (c_col == max_cols && p_matrix[c_row, 0])
                            neighbors++;


                        if (c_row < 0 || c_row >= max_rows)
                        {
                            continue;
                        }

                        if (c_col < 0 || c_col >= max_cols)
                        {
                            continue;
                        }

                        if (p_matrix[c_row, c_col])
                        {
                            neighbors++;
                        }

                    }
                }
            }
            catch (Exception e)
            {
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
                    if (matrix[x, y]) ones++;
                }
            }
            CHHistogram.Series["#Ones"].Points.AddY(ones);
            TXTPopulation.Text = "Population " + ones;
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
            matrix[x, y] = !matrix[x, y];
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
            if (cellArea < 20)
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

        private void CBAlive_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (CBAlive.Text == colors[0])
                alive = Brushes.White;
            else if (CBAlive.Text == colors[1])
                alive = Brushes.Black;
            else if (CBAlive.Text == colors[2])
                alive = Brushes.Red;
            else if (CBAlive.Text == colors[3])
                alive = Brushes.Blue;
            else if (CBAlive.Text == colors[4])
                alive = Brushes.Green;
            else if (CBAlive.Text == colors[5])
                alive = Brushes.Yellow;
            else if (CBAlive.Text == colors[6])
                alive = Brushes.Violet;
            PBAutomataSimulator.Invalidate();

        }

        private void CBDead_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (CBDead.Text == colors[0])
                dead = Brushes.White;
            else if (CBDead.Text == colors[1])
                dead = Brushes.Black;
            else if (CBDead.Text == colors[2])
                dead = Brushes.Red;
            else if (CBDead.Text == colors[3])
                dead = Brushes.Blue;
            else if (CBDead.Text == colors[4])
                dead = Brushes.Green;
            else if (CBDead.Text == colors[5])
                dead = Brushes.Yellow;
            else if (CBDead.Text == colors[6])
                dead = Brushes.Violet;
            PBAutomataSimulator.Invalidate();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Random r = new Random();
            for (int x = 0; x < matrix.GetLength(0); x++) {

                for (int y = 0; y < matrix.GetLength(1); y++) {

                    float rand = r.Next(0,100);
                    if (rand < int.Parse(numericOnes.Text))
                    {
                        matrix[x, y] = true;
                    }
                    else matrix[x, y] = false;
                }
            }
            PBAutomataSimulator.Invalidate();
        }

        private void BTNClear_Click(object sender, EventArgs e)
        {
            for (int x = 0; x < matrix.GetLength(0); x++) {

                for (int y = 0; y < matrix.GetLength(1); y++) {

                    matrix[x, y] = false;
                }
            }
            PBAutomataSimulator.Invalidate();
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
                            matrix[j++, i] = (c == '1');
                        }
                    }
                    Console.ReadLine();
                }
            }
            catch (Exception ex) {
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
                        {
                            if (matrix[j, i])
                                sw.Write("1");
                            else if (!matrix[i, j])
                                sw.Write("0");
                        }
                        sw.WriteLine();
                    }
                    sw.Close();
                }
            }
            catch (Exception ex) {
                Console.WriteLine(ex);
            }

        }
    }
}