using System;
using System.Drawing;
using System.Windows.Forms;
using System.IO;
using System.Collections;
using System.Collections.Generic;

namespace Langton_s_ant
{

    /// <summary>
    /// To make this automata we need to know the behaviour of the Lanton's ant:
    /// 1. If the ant is in a white cell, the ant changes the color of the cell, rotates 90° and
    /// move it one cell
    /// 2. If the ant is int a black cell, the ant changes the color of the cell, rotates 90° and
    /// move it one cell
    /// </summary>
    public partial class Form1 : Form
    {

        /***************************************
         *          GLOBAL VARIABLES           *
         ***************************************/

        //Space
        private uint[,] matrix;

        //Area of each cell
        private int cellArea = 10;
        //Total of alive accumulated cells
        private long acumOnes = 0;
        //Generation
        private int generation = 1;
        //Alive cells
        private int total_cells = 0;

        //Ant and cell colors
        private SolidBrush alive = new SolidBrush(Color.White);
        private SolidBrush dead = new SolidBrush(Color.Black);
        private SolidBrush ant_worker = new SolidBrush(Color.Red);
        private SolidBrush ant_male = new SolidBrush(Color.Orange);
        private SolidBrush ant_queen = new SolidBrush(Color.Cyan);
        //Grid color
        private Pen grid = Pens.Gray;

        //Initial position ant
        private int put_ant = Helper.NORTH;
        private string message_orientation = "Selected ";
        private string message_type = "Type: ";
        private uint message_color;
        private string message_TTL = "TTL: ";
        //Our ants
        List<ANT> ants = new List<ANT>();
        //CELLS STATES
        private const int ALIVE = 1;
        private const int DEAD = 0;

        //Color of our cells and the grid
        ColorHandler colors = new ColorHandler();
        /// <summary>
        /// Constructor
        /// </summary>
        public Form1()
        {
            InitializeComponent();
            createMatrix(100, 100);
            scrollBox();
        }

        /// <summary>
        /// This method paints the matrix in the Paint Box
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="e"></param>
        private void PBAutomataSimulator_Paint(object sender, PaintEventArgs e)
        {
            List<ANT> aux_ant = new List<ANT>();
            int x_size = matrix.GetLength(0);
            int y_size = matrix.GetLength(1);
            total_cells = x_size * y_size;

            Graphics graphics = e.Graphics;

            for (int x = 0; x < x_size; x++)
            {

                for (int y = 0; y < y_size; y++)
                {

                    uint current_cell = matrix[x, y];
                    if (current_cell != DEAD)
                    {
                        SolidBrush aliveCellColor = new SolidBrush(colors.fromIntToColor(current_cell));
                        graphics.FillRectangle(aliveCellColor, x * cellArea, y * cellArea, cellArea, cellArea);
                    }
                    else
                    {
                        graphics.FillRectangle(dead, x * cellArea, y * cellArea, cellArea, cellArea);
                    }
                }
            }

            for (int i = 0; i < ants.Count; i++)
            {
                ANT ant_obj = ants[i];
                if (ant_obj.getType() == Helper.WORKER)
                    graphics.FillEllipse(ant_worker, ant_obj.getX() * cellArea, ant_obj.getY() * cellArea, cellArea, cellArea);
                else if (ant_obj.getType() == Helper.MALE)
                    graphics.FillEllipse(ant_male, ant_obj.getX() * cellArea, ant_obj.getY() * cellArea, cellArea, cellArea);
                else
                {
                    graphics.FillEllipse(ant_queen, ant_obj.getX() * cellArea, ant_obj.getY() * cellArea, cellArea, cellArea);

                }
                graphics.DrawEllipse(new Pen(Color.Black), ant_obj.getX() * cellArea, ant_obj.getY() * cellArea, cellArea, cellArea);
                try
                {
                    if (ant_obj.getTTL() > 0)
                        aux_ant.Add(ant_obj);
                }
                catch (Exception) { }
            }
            ants = new List<ANT>(aux_ant);
            for (int y = 0; y < y_size; y++)
                graphics.DrawLine(grid, 0, y * cellArea, total_cells * cellArea, y * cellArea);

            for (int x = 0; x < x_size; x++)
                graphics.DrawLine(grid, x * cellArea, 0, x * cellArea, total_cells * cellArea);

        }
        /// <summary>
        /// This function creates a matrix of ints which size it's n x m
        /// </summary>  
        /// <param name="rows"></param>
        /// <param name="cols"></param>
        private void createMatrix(int rows, int cols)
        {
            matrix = new uint[rows, cols];
            scrollBox();
        }

        /// <summary>
        /// This method calls nextGeneration method and
        /// updates the GUI and the count of our alive cells
        /// </summary>
        private void step()
        {
            List<ANT> aux = new List<ANT>(ants);
            for (int i = 0; i < ants.Count; i++)
            {
                ANT ant_obj = ants[i];
                if (ant_obj.getType() == Helper.QUEEN)
                {
                    aux = QueenActions(i);
                }
                matrix = ant_obj.nextGeneration(matrix, CBToroid.Checked);
                PBAutomataSimulator.Invalidate();
            }
            ants = new List<ANT>(aux);
            updateTextGeneration();
            countOnes();
            if (ants.Count == 0)
                PBAutomataSimulator.Invalidate();
        }

        private List<ANT> QueenActions(int queen_index)
        {
            List<ANT> new_ants = new List<ANT>();
            ANT first_queen = ants[queen_index];
            int queen_fx = first_queen.getX();
            int queen_fy = first_queen.getY();
            bool flag = true;
            for (int i = 0; i < ants.Count; i++)
            {
                flag = true;
                ANT current_ant = ants[i];
                if ((i != queen_index) && (queen_fx == current_ant.getX() && queen_fy == current_ant.getY()))
                {
                    switch (current_ant.getType())
                    {
                        case Helper.QUEEN:
                            if (new Random().Next(0, 100) <= 50)
                                new_ants.Add(current_ant);
                            else
                                new_ants.Add(ants[queen_index]);
                            flag = false;
                            break;

                        case Helper.MALE:
                            new_ants.Add(new ANT(queen_fx, queen_fy, Helper.generateOrientation(),
                                Helper.generateType((int)NumericQueen.Value,
                                (int)NumericMale.Value),
                                (int)NumericTTL.Value));
                            flag = false;
                            break;
                    }

                }
                if (flag)
                    new_ants.Add(current_ant);
            }
            return new_ants;
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
            int work = 0, male = 0, queen = 0;
            for (int x = 0; x < matrix.GetLength(0); x++)
            {

                for (int y = 0; y < matrix.GetLength(1); y++)
                {
                    if (matrix[x, y] != DEAD)
                        ones++;
                }
            }

            foreach (ANT ant_obj in ants) {
                if (ant_obj.getType() == Helper.WORKER)
                    work++;
                else if (ant_obj.getType() == Helper.MALE)
                    male++;
                else
                    queen++;
            }
            if (CheckGraphEnabled.Checked)
            {
                CHHistogram.Series["#Worker"].Points.AddY(work);
                CHHistogram.Series["#Male"].Points.AddY(male);
                CHHistogram.Series["#Queen"].Points.AddY(queen);
            }

            TXTPopulation.Text = "Population " + ones;
            acumOnes += ones;
            double val = acumOnes / generation;
            label12.Text = "Total Population: " + acumOnes;
            label13.Text = "Average: " + (val);
            label14.Text = "Density: " + (val / (matrix.GetLength(0) * matrix.GetLength(1)));
            label3.Text = "Ants: " + ants.Count;
        }

        /*****************************************************
         *                      Events                       *
         *****************************************************/

        private void BTNStep_Click(object sender, EventArgs e)
        {
            PBAutomataSimulator.Invalidate();
            step();
        }

        private Color getColor()
        {
            DialogResult result = colorDialog.ShowDialog();
            return colorDialog.Color;
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
            int pos = 0;
            Random ra = new Random();
            for (int x = 0; x < matrix.GetLength(0); x++)
            {

                for (int y = 0; y < matrix.GetLength(1); y++)
                {
                    //Probability of put an ant
                    int integer_rand = ra.Next(0, 99);
                    double rand = (ra.NextDouble()) + integer_rand;
                    if (rand < float.Parse(numericOnes.Text))
                    {
                        ANT ant_obj = new ANT(x, y, Helper.generateOrientation(),
                            Helper.generateType((int)NumericQueen.Value,
                            (int)NumericMale.Value),
                            (int)NumericTTL.Value);
                        ant_obj.setColor(colors.randomColor());
                        ants.Add(ant_obj);
                    }
                    else matrix[x, y] = DEAD;
                }
            }
            PBAutomataSimulator.Invalidate();
        }

        private void BTNClear_Click(object sender, EventArgs e)
        {
            CHHistogram.Series["#Worker"].Points.Clear();
            CHHistogram.Series["#Male"].Points.Clear();
            CHHistogram.Series["#Queen"].Points.Clear();
            for (int x = 0; x < matrix.GetLength(0); x++)
            {

                for (int y = 0; y < matrix.GetLength(1); y++)
                {

                    matrix[x, y] = DEAD;
                }
            }
            ants.Clear();
            PBAutomataSimulator.Invalidate();
            acumOnes = generation = 0;

        }

        private void BTNCreateMatrix_Click(object sender, EventArgs e)
        {
            int rows = (numericRows.Value == 0) ? 100 : (int)numericRows.Value;
            int cols = (numericCols.Value == 0) ? 100 : (int)numericCols.Value;
            createMatrix(rows, cols);
        }
        

        private void PBAutomataSimulator_MouseMove(object sender, MouseEventArgs e)
        {
            int x = e.X / cellArea;
            int y = e.Y / cellArea;


            foreach (ANT ant_obj in ants)
            {

                if (ant_obj.getX() == x && ant_obj.getY() == y)
                {
                    message_orientation = Helper.textOrientation(ant_obj.getOrientation());
                    message_type = Helper.textType(ant_obj.getType());
                    message_TTL = "TTL: " + ant_obj.getTTL() + "";
                    message_color = colors.fromColorToInt(ant_obj.getColor());
                }
            }
            label5.Text = message_orientation;
            label2.Text = message_type;
            label17.Text = message_TTL;
            label18.BackColor = colors.fromIntToColor(message_color);
        }

        private void BTNColorDead_Click(object sender, EventArgs e)
        {
            dead = new SolidBrush(getColor());
            PBAutomataSimulator.Invalidate();
        }

        private void BTNColorAnt_Click(object sender, EventArgs e)
        {
            ant_worker = new SolidBrush(getColor());
            PBAutomataSimulator.Invalidate();
        }

        private void BTNColorMale_Click(object sender, EventArgs e)
        {
            ant_male = new SolidBrush(getColor());
            PBAutomataSimulator.Invalidate();
        }

        private void BTNColorQueen_Click(object sender, EventArgs e)
        {
            ant_queen = new SolidBrush(getColor());
            PBAutomataSimulator.Invalidate();
        }

        private void BTNColorGrid_Click(object sender, EventArgs e)
        {
            grid = new Pen(getColor());
            PBAutomataSimulator.Invalidate();
        }


        private void PBAutomataSimulator_Click(object sender, EventArgs e)
        {
            MouseEventArgs me = (MouseEventArgs)e;
            int x = (me.X / cellArea);
            int y = (me.Y / cellArea);
            if (me.Button == System.Windows.Forms.MouseButtons.Right)
            {
                foreach (ANT ant_obj in ants)
                {
                    if (ant_obj.getX() == x && ant_obj.getY() == y)
                    {
                        ant_obj.setColor(getColor());
                        break;
                    }
                }
            }
            else
            {
                bool can_put_ant = true;
                int i = 0, j = 0;
                Random rnd = new Random();
                for (i = 0; i < ants.Count; i++)
                {
                    ANT ant_obj = ants[i];
                    if (ant_obj.getX() == x && ant_obj.getY() == y)
                    {
                        can_put_ant = false;
                        j = i;
                        break;
                    }
                }

                //Add a new ant
                if (can_put_ant)
                    ants.Add(new ANT(x, y, Helper.getOrientationValue(ComboOrientation.Text),
                        Helper.getTypeValue(ComboType.Text), (int)NumericTTL.Value));
                else
                {
                    ants.RemoveAt(j);
                }
            }
            PBAutomataSimulator.Invalidate();
        }

        private void ComboTypeGraph_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (ComboTypeGraph.Text == "Column")
            {
                CHHistogram.Series[0].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Column;
                CHHistogram.Series[1].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Column;
                CHHistogram.Series[2].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Column;
            }
            else if (ComboTypeGraph.Text == "Bar")
            { 
                CHHistogram.Series[0].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
                CHHistogram.Series[1].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
                CHHistogram.Series[2].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Line;
            }
            else
            {
                CHHistogram.Series[0].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Point;
                CHHistogram.Series[1].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Point;
                CHHistogram.Series[2].ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Point;
            }
        }
    }
}