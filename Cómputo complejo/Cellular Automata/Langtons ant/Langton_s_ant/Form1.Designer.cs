namespace Langton_s_ant
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.Windows.Forms.DataVisualization.Charting.Series series2 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.Windows.Forms.DataVisualization.Charting.Series series3 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.PBAutomataSimulator = new System.Windows.Forms.PictureBox();
            this.CHHistogram = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.BTNStart = new System.Windows.Forms.Button();
            this.TXTGeneration = new System.Windows.Forms.Label();
            this.TXTPopulation = new System.Windows.Forms.Label();
            this.BTNStep = new System.Windows.Forms.Button();
            this.TBSpeed = new System.Windows.Forms.TrackBar();
            this.TimerSimulation = new System.Windows.Forms.Timer(this.components);
            this.flowLayoutPanel1 = new System.Windows.Forms.FlowLayoutPanel();
            this.groupBox3 = new System.Windows.Forms.GroupBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.BTNZoomP = new System.Windows.Forms.Button();
            this.BTNZoomM = new System.Windows.Forms.Button();
            this.groupBox4 = new System.Windows.Forms.GroupBox();
            this.groupBox5 = new System.Windows.Forms.GroupBox();
            this.button1 = new System.Windows.Forms.Button();
            this.numericOnes = new System.Windows.Forms.NumericUpDown();
            this.Ants = new System.Windows.Forms.Label();
            this.groupBox6 = new System.Windows.Forms.GroupBox();
            this.BTNColorGrid = new System.Windows.Forms.Button();
            this.BTNColorWorker = new System.Windows.Forms.Button();
            this.BTNColorDead = new System.Windows.Forms.Button();
            this.BTNClear = new System.Windows.Forms.Button();
            this.groupBox7 = new System.Windows.Forms.GroupBox();
            this.BTNCreateMatrix = new System.Windows.Forms.Button();
            this.numericCols = new System.Windows.Forms.NumericUpDown();
            this.numericRows = new System.Windows.Forms.NumericUpDown();
            this.label11 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.label14 = new System.Windows.Forms.Label();
            this.groupBox9 = new System.Windows.Forms.GroupBox();
            this.CheckGraphEnabled = new System.Windows.Forms.CheckBox();
            this.groupBox10 = new System.Windows.Forms.GroupBox();
            this.label3 = new System.Windows.Forms.Label();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.CBToroid = new System.Windows.Forms.CheckBox();
            this.groupBox11 = new System.Windows.Forms.GroupBox();
            this.label17 = new System.Windows.Forms.Label();
            this.label16 = new System.Windows.Forms.Label();
            this.NumericTTL = new System.Windows.Forms.NumericUpDown();
            this.label15 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.Orientation = new System.Windows.Forms.Label();
            this.ComboOrientation = new System.Windows.Forms.ComboBox();
            this.ComboType = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.colorDialog = new System.Windows.Forms.ColorDialog();
            this.groupBox12 = new System.Windows.Forms.GroupBox();
            this.label9 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.NumericMale = new System.Windows.Forms.NumericUpDown();
            this.NumericQueen = new System.Windows.Forms.NumericUpDown();
            this.label18 = new System.Windows.Forms.Label();
            this.BTNColorMale = new System.Windows.Forms.Button();
            this.BTNColorQueen = new System.Windows.Forms.Button();
            this.ComboTypeGraph = new System.Windows.Forms.ComboBox();
            this.label4 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.PBAutomataSimulator)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.CHHistogram)).BeginInit();
            this.groupBox1.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.TBSpeed)).BeginInit();
            this.flowLayoutPanel1.SuspendLayout();
            this.groupBox3.SuspendLayout();
            this.groupBox4.SuspendLayout();
            this.groupBox5.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericOnes)).BeginInit();
            this.groupBox6.SuspendLayout();
            this.groupBox7.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericCols)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericRows)).BeginInit();
            this.groupBox9.SuspendLayout();
            this.groupBox10.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.groupBox11.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.NumericTTL)).BeginInit();
            this.groupBox12.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.NumericMale)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.NumericQueen)).BeginInit();
            this.SuspendLayout();
            // 
            // PBAutomataSimulator
            // 
            this.PBAutomataSimulator.BackColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.PBAutomataSimulator.Location = new System.Drawing.Point(3, 3);
            this.PBAutomataSimulator.Name = "PBAutomataSimulator";
            this.PBAutomataSimulator.Size = new System.Drawing.Size(545, 505);
            this.PBAutomataSimulator.SizeMode = System.Windows.Forms.PictureBoxSizeMode.AutoSize;
            this.PBAutomataSimulator.TabIndex = 1;
            this.PBAutomataSimulator.TabStop = false;
            this.PBAutomataSimulator.Click += new System.EventHandler(this.PBAutomataSimulator_Click);
            this.PBAutomataSimulator.Paint += new System.Windows.Forms.PaintEventHandler(this.PBAutomataSimulator_Paint);
            this.PBAutomataSimulator.MouseMove += new System.Windows.Forms.MouseEventHandler(this.PBAutomataSimulator_MouseMove);
            // 
            // CHHistogram
            // 
            chartArea1.AlignmentOrientation = ((System.Windows.Forms.DataVisualization.Charting.AreaAlignmentOrientations)((System.Windows.Forms.DataVisualization.Charting.AreaAlignmentOrientations.Vertical | System.Windows.Forms.DataVisualization.Charting.AreaAlignmentOrientations.Horizontal)));
            chartArea1.Area3DStyle.Enable3D = true;
            chartArea1.Name = "ChartArea1";
            this.CHHistogram.ChartAreas.Add(chartArea1);
            legend1.Name = "Legend1";
            this.CHHistogram.Legends.Add(legend1);
            this.CHHistogram.Location = new System.Drawing.Point(6, 19);
            this.CHHistogram.Name = "CHHistogram";
            series1.ChartArea = "ChartArea1";
            series1.Legend = "Legend1";
            series1.Name = "#Worker";
            series1.YValuesPerPoint = 2;
            series2.ChartArea = "ChartArea1";
            series2.Legend = "Legend1";
            series2.Name = "#Male";
            series2.YValuesPerPoint = 2;
            series3.ChartArea = "ChartArea1";
            series3.Legend = "Legend1";
            series3.Name = "#Queen";
            series3.YValuesPerPoint = 6;
            this.CHHistogram.Series.Add(series1);
            this.CHHistogram.Series.Add(series2);
            this.CHHistogram.Series.Add(series3);
            this.CHHistogram.Size = new System.Drawing.Size(584, 337);
            this.CHHistogram.TabIndex = 2;
            this.CHHistogram.Text = "chart1";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.CHHistogram);
            this.groupBox1.Location = new System.Drawing.Point(13, 12);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(596, 362);
            this.groupBox1.TabIndex = 3;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Histogram";
            // 
            // BTNStart
            // 
            this.BTNStart.Location = new System.Drawing.Point(6, 19);
            this.BTNStart.Name = "BTNStart";
            this.BTNStart.Size = new System.Drawing.Size(75, 23);
            this.BTNStart.TabIndex = 4;
            this.BTNStart.Text = "Start";
            this.BTNStart.UseVisualStyleBackColor = true;
            this.BTNStart.Click += new System.EventHandler(this.BTNStart_Click);
            // 
            // TXTGeneration
            // 
            this.TXTGeneration.AutoSize = true;
            this.TXTGeneration.BackColor = System.Drawing.Color.Transparent;
            this.TXTGeneration.ForeColor = System.Drawing.Color.Black;
            this.TXTGeneration.Location = new System.Drawing.Point(6, 18);
            this.TXTGeneration.Name = "TXTGeneration";
            this.TXTGeneration.Size = new System.Drawing.Size(62, 13);
            this.TXTGeneration.TabIndex = 7;
            this.TXTGeneration.Text = "Generation ";
            // 
            // TXTPopulation
            // 
            this.TXTPopulation.AutoSize = true;
            this.TXTPopulation.Location = new System.Drawing.Point(6, 40);
            this.TXTPopulation.Name = "TXTPopulation";
            this.TXTPopulation.Size = new System.Drawing.Size(57, 13);
            this.TXTPopulation.TabIndex = 8;
            this.TXTPopulation.Text = "Population";
            // 
            // BTNStep
            // 
            this.BTNStep.Location = new System.Drawing.Point(87, 19);
            this.BTNStep.Name = "BTNStep";
            this.BTNStep.Size = new System.Drawing.Size(75, 23);
            this.BTNStep.TabIndex = 9;
            this.BTNStep.Text = "One step";
            this.BTNStep.UseVisualStyleBackColor = true;
            this.BTNStep.Click += new System.EventHandler(this.BTNStep_Click);
            // 
            // TBSpeed
            // 
            this.TBSpeed.Location = new System.Drawing.Point(6, 19);
            this.TBSpeed.Maximum = 3000;
            this.TBSpeed.Minimum = 1;
            this.TBSpeed.Name = "TBSpeed";
            this.TBSpeed.Size = new System.Drawing.Size(233, 45);
            this.TBSpeed.TabIndex = 10;
            this.TBSpeed.Value = 1000;
            this.TBSpeed.ValueChanged += new System.EventHandler(this.trackBar1_ValueChanged);
            // 
            // TimerSimulation
            // 
            this.TimerSimulation.Tick += new System.EventHandler(this.TimerSimulation_Tick);
            // 
            // flowLayoutPanel1
            // 
            this.flowLayoutPanel1.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.flowLayoutPanel1.AutoScroll = true;
            this.flowLayoutPanel1.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.flowLayoutPanel1.Controls.Add(this.PBAutomataSimulator);
            this.flowLayoutPanel1.Location = new System.Drawing.Point(615, 21);
            this.flowLayoutPanel1.MinimumSize = new System.Drawing.Size(639, 600);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(639, 710);
            this.flowLayoutPanel1.TabIndex = 11;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.label6);
            this.groupBox3.Controls.Add(this.label1);
            this.groupBox3.Controls.Add(this.TBSpeed);
            this.groupBox3.Location = new System.Drawing.Point(16, 635);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(242, 69);
            this.groupBox3.TabIndex = 12;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Speed";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(217, 53);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(18, 13);
            this.label6.TabIndex = 12;
            this.label6.Text = "3s";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 51);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(26, 13);
            this.label1.TabIndex = 11;
            this.label1.Text = "1ms";
            // 
            // BTNZoomP
            // 
            this.BTNZoomP.Location = new System.Drawing.Point(525, 396);
            this.BTNZoomP.Name = "BTNZoomP";
            this.BTNZoomP.Size = new System.Drawing.Size(75, 23);
            this.BTNZoomP.TabIndex = 13;
            this.BTNZoomP.Text = "zoom +";
            this.BTNZoomP.UseVisualStyleBackColor = true;
            this.BTNZoomP.Click += new System.EventHandler(this.BTNZoomP_Click);
            // 
            // BTNZoomM
            // 
            this.BTNZoomM.Location = new System.Drawing.Point(525, 429);
            this.BTNZoomM.Name = "BTNZoomM";
            this.BTNZoomM.Size = new System.Drawing.Size(75, 23);
            this.BTNZoomM.TabIndex = 14;
            this.BTNZoomM.Text = "zoom -";
            this.BTNZoomM.UseVisualStyleBackColor = true;
            this.BTNZoomM.Click += new System.EventHandler(this.BTNZoomM_Click);
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.BTNStart);
            this.groupBox4.Controls.Add(this.BTNStep);
            this.groupBox4.Location = new System.Drawing.Point(238, 385);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(168, 53);
            this.groupBox4.TabIndex = 15;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "Controlls";
            // 
            // groupBox5
            // 
            this.groupBox5.Controls.Add(this.button1);
            this.groupBox5.Controls.Add(this.numericOnes);
            this.groupBox5.Controls.Add(this.Ants);
            this.groupBox5.Location = new System.Drawing.Point(276, 447);
            this.groupBox5.Name = "groupBox5";
            this.groupBox5.Size = new System.Drawing.Size(92, 82);
            this.groupBox5.TabIndex = 16;
            this.groupBox5.TabStop = false;
            this.groupBox5.Text = "Random";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(8, 55);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 4;
            this.button1.Text = "Generate";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // numericOnes
            // 
            this.numericOnes.DecimalPlaces = 3;
            this.numericOnes.Location = new System.Drawing.Point(7, 32);
            this.numericOnes.Maximum = new decimal(new int[] {
            10,
            0,
            0,
            0});
            this.numericOnes.Name = "numericOnes";
            this.numericOnes.Size = new System.Drawing.Size(76, 20);
            this.numericOnes.TabIndex = 2;
            // 
            // Ants
            // 
            this.Ants.AutoSize = true;
            this.Ants.Location = new System.Drawing.Point(33, 17);
            this.Ants.Name = "Ants";
            this.Ants.Size = new System.Drawing.Size(28, 13);
            this.Ants.TabIndex = 0;
            this.Ants.Text = "Ants";
            // 
            // groupBox6
            // 
            this.groupBox6.Controls.Add(this.BTNColorQueen);
            this.groupBox6.Controls.Add(this.BTNColorMale);
            this.groupBox6.Controls.Add(this.BTNColorGrid);
            this.groupBox6.Controls.Add(this.BTNColorWorker);
            this.groupBox6.Controls.Add(this.BTNColorDead);
            this.groupBox6.Location = new System.Drawing.Point(13, 385);
            this.groupBox6.Name = "groupBox6";
            this.groupBox6.Size = new System.Drawing.Size(211, 112);
            this.groupBox6.TabIndex = 17;
            this.groupBox6.TabStop = false;
            this.groupBox6.Text = "Choose colors";
            // 
            // BTNColorGrid
            // 
            this.BTNColorGrid.Location = new System.Drawing.Point(12, 64);
            this.BTNColorGrid.Name = "BTNColorGrid";
            this.BTNColorGrid.Size = new System.Drawing.Size(75, 23);
            this.BTNColorGrid.TabIndex = 10;
            this.BTNColorGrid.Text = "Grid";
            this.BTNColorGrid.UseVisualStyleBackColor = true;
            this.BTNColorGrid.Click += new System.EventHandler(this.BTNColorGrid_Click);
            // 
            // BTNColorWorker
            // 
            this.BTNColorWorker.Location = new System.Drawing.Point(121, 17);
            this.BTNColorWorker.Name = "BTNColorWorker";
            this.BTNColorWorker.Size = new System.Drawing.Size(75, 23);
            this.BTNColorWorker.TabIndex = 9;
            this.BTNColorWorker.Text = "Worker";
            this.BTNColorWorker.UseVisualStyleBackColor = true;
            this.BTNColorWorker.Click += new System.EventHandler(this.BTNColorAnt_Click);
            // 
            // BTNColorDead
            // 
            this.BTNColorDead.Location = new System.Drawing.Point(12, 35);
            this.BTNColorDead.Name = "BTNColorDead";
            this.BTNColorDead.Size = new System.Drawing.Size(75, 23);
            this.BTNColorDead.TabIndex = 8;
            this.BTNColorDead.Text = "Dead cells";
            this.BTNColorDead.UseVisualStyleBackColor = true;
            this.BTNColorDead.Click += new System.EventHandler(this.BTNColorDead_Click);
            // 
            // BTNClear
            // 
            this.BTNClear.Location = new System.Drawing.Point(525, 461);
            this.BTNClear.Name = "BTNClear";
            this.BTNClear.Size = new System.Drawing.Size(75, 23);
            this.BTNClear.TabIndex = 19;
            this.BTNClear.Text = "Clear";
            this.BTNClear.UseVisualStyleBackColor = true;
            this.BTNClear.Click += new System.EventHandler(this.BTNClear_Click);
            // 
            // groupBox7
            // 
            this.groupBox7.Controls.Add(this.BTNCreateMatrix);
            this.groupBox7.Controls.Add(this.numericCols);
            this.groupBox7.Controls.Add(this.numericRows);
            this.groupBox7.Controls.Add(this.label11);
            this.groupBox7.Controls.Add(this.label8);
            this.groupBox7.Location = new System.Drawing.Point(420, 385);
            this.groupBox7.Name = "groupBox7";
            this.groupBox7.Size = new System.Drawing.Size(95, 157);
            this.groupBox7.TabIndex = 20;
            this.groupBox7.TabStop = false;
            this.groupBox7.Text = "Size";
            // 
            // BTNCreateMatrix
            // 
            this.BTNCreateMatrix.Location = new System.Drawing.Point(9, 119);
            this.BTNCreateMatrix.Name = "BTNCreateMatrix";
            this.BTNCreateMatrix.Size = new System.Drawing.Size(81, 23);
            this.BTNCreateMatrix.TabIndex = 21;
            this.BTNCreateMatrix.Text = "Create";
            this.BTNCreateMatrix.UseVisualStyleBackColor = true;
            this.BTNCreateMatrix.Click += new System.EventHandler(this.BTNCreateMatrix_Click);
            // 
            // numericCols
            // 
            this.numericCols.Location = new System.Drawing.Point(9, 82);
            this.numericCols.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.numericCols.Minimum = new decimal(new int[] {
            10,
            0,
            0,
            0});
            this.numericCols.Name = "numericCols";
            this.numericCols.Size = new System.Drawing.Size(81, 20);
            this.numericCols.TabIndex = 3;
            this.numericCols.Value = new decimal(new int[] {
            10,
            0,
            0,
            0});
            // 
            // numericRows
            // 
            this.numericRows.Location = new System.Drawing.Point(7, 42);
            this.numericRows.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.numericRows.Minimum = new decimal(new int[] {
            10,
            0,
            0,
            0});
            this.numericRows.Name = "numericRows";
            this.numericRows.Size = new System.Drawing.Size(81, 20);
            this.numericRows.TabIndex = 2;
            this.numericRows.Value = new decimal(new int[] {
            100,
            0,
            0,
            0});
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(32, 66);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(27, 13);
            this.label11.TabIndex = 1;
            this.label11.Text = "Cols";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(25, 25);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(34, 13);
            this.label8.TabIndex = 0;
            this.label8.Text = "Rows";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(6, 62);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(83, 13);
            this.label12.TabIndex = 22;
            this.label12.Text = "Total population";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(6, 84);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(47, 13);
            this.label13.TabIndex = 23;
            this.label13.Text = "Average";
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Location = new System.Drawing.Point(6, 106);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(42, 13);
            this.label14.TabIndex = 24;
            this.label14.Text = "Density";
            // 
            // groupBox9
            // 
            this.groupBox9.Controls.Add(this.label4);
            this.groupBox9.Controls.Add(this.ComboTypeGraph);
            this.groupBox9.Controls.Add(this.CheckGraphEnabled);
            this.groupBox9.Location = new System.Drawing.Point(120, 532);
            this.groupBox9.Name = "groupBox9";
            this.groupBox9.Size = new System.Drawing.Size(104, 88);
            this.groupBox9.TabIndex = 25;
            this.groupBox9.TabStop = false;
            this.groupBox9.Text = "Graph options";
            // 
            // CheckGraphEnabled
            // 
            this.CheckGraphEnabled.AutoSize = true;
            this.CheckGraphEnabled.Checked = true;
            this.CheckGraphEnabled.CheckState = System.Windows.Forms.CheckState.Checked;
            this.CheckGraphEnabled.Location = new System.Drawing.Point(16, 21);
            this.CheckGraphEnabled.Name = "CheckGraphEnabled";
            this.CheckGraphEnabled.Size = new System.Drawing.Size(59, 17);
            this.CheckGraphEnabled.TabIndex = 0;
            this.CheckGraphEnabled.Text = "Enable";
            this.CheckGraphEnabled.UseVisualStyleBackColor = true;
            // 
            // groupBox10
            // 
            this.groupBox10.Controls.Add(this.label3);
            this.groupBox10.Controls.Add(this.TXTGeneration);
            this.groupBox10.Controls.Add(this.TXTPopulation);
            this.groupBox10.Controls.Add(this.label14);
            this.groupBox10.Controls.Add(this.label12);
            this.groupBox10.Controls.Add(this.label13);
            this.groupBox10.Location = new System.Drawing.Point(264, 545);
            this.groupBox10.Name = "groupBox10";
            this.groupBox10.Size = new System.Drawing.Size(169, 161);
            this.groupBox10.TabIndex = 26;
            this.groupBox10.TabStop = false;
            this.groupBox10.Text = "Data";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(7, 128);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(28, 13);
            this.label3.TabIndex = 25;
            this.label3.Text = "Ants";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.CBToroid);
            this.groupBox2.Location = new System.Drawing.Point(520, 493);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(89, 49);
            this.groupBox2.TabIndex = 27;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Space options";
            // 
            // CBToroid
            // 
            this.CBToroid.AutoSize = true;
            this.CBToroid.Checked = true;
            this.CBToroid.CheckState = System.Windows.Forms.CheckState.Checked;
            this.CBToroid.Location = new System.Drawing.Point(18, 22);
            this.CBToroid.Name = "CBToroid";
            this.CBToroid.Size = new System.Drawing.Size(56, 17);
            this.CBToroid.TabIndex = 0;
            this.CBToroid.Text = "Toroid";
            this.CBToroid.UseVisualStyleBackColor = true;
            // 
            // groupBox11
            // 
            this.groupBox11.Controls.Add(this.label18);
            this.groupBox11.Controls.Add(this.label17);
            this.groupBox11.Controls.Add(this.label16);
            this.groupBox11.Controls.Add(this.NumericTTL);
            this.groupBox11.Controls.Add(this.label15);
            this.groupBox11.Controls.Add(this.label10);
            this.groupBox11.Controls.Add(this.Orientation);
            this.groupBox11.Controls.Add(this.ComboOrientation);
            this.groupBox11.Controls.Add(this.ComboType);
            this.groupBox11.Controls.Add(this.label2);
            this.groupBox11.Controls.Add(this.label5);
            this.groupBox11.Location = new System.Drawing.Point(440, 548);
            this.groupBox11.Name = "groupBox11";
            this.groupBox11.Size = new System.Drawing.Size(169, 188);
            this.groupBox11.TabIndex = 28;
            this.groupBox11.TabStop = false;
            this.groupBox11.Text = "Ants options";
            // 
            // label17
            // 
            this.label17.AutoSize = true;
            this.label17.Location = new System.Drawing.Point(8, 170);
            this.label17.Name = "label17";
            this.label17.Size = new System.Drawing.Size(30, 13);
            this.label17.TabIndex = 13;
            this.label17.Text = "TTL:";
            // 
            // label16
            // 
            this.label16.AutoSize = true;
            this.label16.Location = new System.Drawing.Point(8, 154);
            this.label16.Name = "label16";
            this.label16.Size = new System.Drawing.Size(34, 13);
            this.label16.TabIndex = 12;
            this.label16.Text = "Color:";
            // 
            // NumericTTL
            // 
            this.NumericTTL.Location = new System.Drawing.Point(48, 90);
            this.NumericTTL.Maximum = new decimal(new int[] {
            1000000,
            0,
            0,
            0});
            this.NumericTTL.Minimum = new decimal(new int[] {
            40,
            0,
            0,
            0});
            this.NumericTTL.Name = "NumericTTL";
            this.NumericTTL.Size = new System.Drawing.Size(73, 20);
            this.NumericTTL.TabIndex = 0;
            this.NumericTTL.Value = new decimal(new int[] {
            50,
            0,
            0,
            0});
            // 
            // label15
            // 
            this.label15.AutoSize = true;
            this.label15.Location = new System.Drawing.Point(53, 74);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(61, 13);
            this.label15.TabIndex = 11;
            this.label15.Text = "Time to live";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(105, 26);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(31, 13);
            this.label10.TabIndex = 10;
            this.label10.Text = "Type";
            // 
            // Orientation
            // 
            this.Orientation.AutoSize = true;
            this.Orientation.Location = new System.Drawing.Point(13, 26);
            this.Orientation.Name = "Orientation";
            this.Orientation.Size = new System.Drawing.Size(58, 13);
            this.Orientation.TabIndex = 9;
            this.Orientation.Text = "Orientation";
            // 
            // ComboOrientation
            // 
            this.ComboOrientation.AutoCompleteCustomSource.AddRange(new string[] {
            "North",
            "East",
            "South",
            "West"});
            this.ComboOrientation.FormattingEnabled = true;
            this.ComboOrientation.Items.AddRange(new object[] {
            "North",
            "East",
            "South",
            "West"});
            this.ComboOrientation.Location = new System.Drawing.Point(8, 46);
            this.ComboOrientation.Name = "ComboOrientation";
            this.ComboOrientation.Size = new System.Drawing.Size(69, 21);
            this.ComboOrientation.TabIndex = 8;
            this.ComboOrientation.Text = "North";
            // 
            // ComboType
            // 
            this.ComboType.AutoCompleteCustomSource.AddRange(new string[] {
            "Worker",
            "Male",
            "Queen"});
            this.ComboType.FormattingEnabled = true;
            this.ComboType.Items.AddRange(new object[] {
            "Worker",
            "Male",
            "Queen"});
            this.ComboType.Location = new System.Drawing.Point(91, 45);
            this.ComboType.Name = "ComboType";
            this.ComboType.Size = new System.Drawing.Size(69, 21);
            this.ComboType.TabIndex = 7;
            this.ComboType.Text = "Worker";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(7, 136);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(34, 13);
            this.label2.TabIndex = 6;
            this.label2.Text = "Type:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(6, 119);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(55, 13);
            this.label5.TabIndex = 5;
            this.label5.Text = "Selected: ";
            // 
            // groupBox12
            // 
            this.groupBox12.Controls.Add(this.label9);
            this.groupBox12.Controls.Add(this.label7);
            this.groupBox12.Controls.Add(this.NumericMale);
            this.groupBox12.Controls.Add(this.NumericQueen);
            this.groupBox12.Location = new System.Drawing.Point(16, 504);
            this.groupBox12.Name = "groupBox12";
            this.groupBox12.Size = new System.Drawing.Size(84, 128);
            this.groupBox12.TabIndex = 29;
            this.groupBox12.TabStop = false;
            this.groupBox12.Text = "Probabilities";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(15, 70);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(30, 13);
            this.label9.TabIndex = 3;
            this.label9.Text = "Male";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(15, 21);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(39, 13);
            this.label7.TabIndex = 2;
            this.label7.Text = "Queen";
            // 
            // NumericMale
            // 
            this.NumericMale.Location = new System.Drawing.Point(9, 89);
            this.NumericMale.Name = "NumericMale";
            this.NumericMale.Size = new System.Drawing.Size(65, 20);
            this.NumericMale.TabIndex = 1;
            this.NumericMale.Value = new decimal(new int[] {
            2,
            0,
            0,
            0});
            // 
            // NumericQueen
            // 
            this.NumericQueen.Location = new System.Drawing.Point(9, 41);
            this.NumericQueen.Name = "NumericQueen";
            this.NumericQueen.Size = new System.Drawing.Size(65, 20);
            this.NumericQueen.TabIndex = 0;
            this.NumericQueen.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // label18
            // 
            this.label18.AutoSize = true;
            this.label18.Location = new System.Drawing.Point(44, 154);
            this.label18.Name = "label18";
            this.label18.Size = new System.Drawing.Size(31, 13);
            this.label18.TabIndex = 14;
            this.label18.Text = "--------";
            // 
            // BTNColorMale
            // 
            this.BTNColorMale.Location = new System.Drawing.Point(122, 47);
            this.BTNColorMale.Name = "BTNColorMale";
            this.BTNColorMale.Size = new System.Drawing.Size(75, 23);
            this.BTNColorMale.TabIndex = 11;
            this.BTNColorMale.Text = "Male";
            this.BTNColorMale.UseVisualStyleBackColor = true;
            this.BTNColorMale.Click += new System.EventHandler(this.BTNColorMale_Click);
            // 
            // BTNColorQueen
            // 
            this.BTNColorQueen.Location = new System.Drawing.Point(123, 76);
            this.BTNColorQueen.Name = "BTNColorQueen";
            this.BTNColorQueen.Size = new System.Drawing.Size(75, 23);
            this.BTNColorQueen.TabIndex = 12;
            this.BTNColorQueen.Text = "Queen";
            this.BTNColorQueen.UseVisualStyleBackColor = true;
            this.BTNColorQueen.Click += new System.EventHandler(this.BTNColorQueen_Click);
            // 
            // ComboTypeGraph
            // 
            this.ComboTypeGraph.AutoCompleteCustomSource.AddRange(new string[] {
            "Bars",
            "Pie",
            "Points"});
            this.ComboTypeGraph.FormattingEnabled = true;
            this.ComboTypeGraph.Items.AddRange(new object[] {
            "Column",
            "Bars",
            "Points"});
            this.ComboTypeGraph.Location = new System.Drawing.Point(6, 58);
            this.ComboTypeGraph.Name = "ComboTypeGraph";
            this.ComboTypeGraph.Size = new System.Drawing.Size(92, 21);
            this.ComboTypeGraph.TabIndex = 3;
            this.ComboTypeGraph.Text = "Column";
            this.ComboTypeGraph.SelectedIndexChanged += new System.EventHandler(this.ComboTypeGraph_SelectedIndexChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(25, 42);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(59, 13);
            this.label4.TabIndex = 4;
            this.label4.Text = "Graph type";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1266, 740);
            this.Controls.Add(this.groupBox12);
            this.Controls.Add(this.groupBox11);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox10);
            this.Controls.Add(this.groupBox9);
            this.Controls.Add(this.groupBox7);
            this.Controls.Add(this.BTNClear);
            this.Controls.Add(this.groupBox6);
            this.Controls.Add(this.groupBox5);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.BTNZoomM);
            this.Controls.Add(this.BTNZoomP);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.flowLayoutPanel1);
            this.Name = "Form1";
            this.Text = " ";
            ((System.ComponentModel.ISupportInitialize)(this.PBAutomataSimulator)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.CHHistogram)).EndInit();
            this.groupBox1.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.TBSpeed)).EndInit();
            this.flowLayoutPanel1.ResumeLayout(false);
            this.flowLayoutPanel1.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.groupBox4.ResumeLayout(false);
            this.groupBox5.ResumeLayout(false);
            this.groupBox5.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericOnes)).EndInit();
            this.groupBox6.ResumeLayout(false);
            this.groupBox7.ResumeLayout(false);
            this.groupBox7.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericCols)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericRows)).EndInit();
            this.groupBox9.ResumeLayout(false);
            this.groupBox9.PerformLayout();
            this.groupBox10.ResumeLayout(false);
            this.groupBox10.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox11.ResumeLayout(false);
            this.groupBox11.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.NumericTTL)).EndInit();
            this.groupBox12.ResumeLayout(false);
            this.groupBox12.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.NumericMale)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.NumericQueen)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.PictureBox PBAutomataSimulator;
        private System.Windows.Forms.DataVisualization.Charting.Chart CHHistogram;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button BTNStart;
        private System.Windows.Forms.Label TXTGeneration;
        private System.Windows.Forms.Label TXTPopulation;
        private System.Windows.Forms.Button BTNStep;
        private System.Windows.Forms.TrackBar TBSpeed;
        private System.Windows.Forms.Timer TimerSimulation;
        private System.Windows.Forms.GroupBox groupBox3;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button BTNZoomP;
        private System.Windows.Forms.Button BTNZoomM;
        private System.Windows.Forms.GroupBox groupBox4;
        private System.Windows.Forms.GroupBox groupBox5;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.NumericUpDown numericOnes;
        private System.Windows.Forms.Label Ants;
        private System.Windows.Forms.GroupBox groupBox6;
        private System.Windows.Forms.Button BTNClear;
        private System.Windows.Forms.GroupBox groupBox7;
        private System.Windows.Forms.NumericUpDown numericCols;
        private System.Windows.Forms.NumericUpDown numericRows;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Button BTNCreateMatrix;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.GroupBox groupBox9;
        private System.Windows.Forms.CheckBox CheckGraphEnabled;
        private System.Windows.Forms.GroupBox groupBox10;
        public System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.CheckBox CBToroid;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.GroupBox groupBox11;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.ColorDialog colorDialog;
        private System.Windows.Forms.Button BTNColorGrid;
        private System.Windows.Forms.Button BTNColorWorker;
        private System.Windows.Forms.Button BTNColorDead;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.GroupBox groupBox12;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.NumericUpDown NumericMale;
        private System.Windows.Forms.NumericUpDown NumericQueen;
        private System.Windows.Forms.NumericUpDown NumericTTL;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label Orientation;
        private System.Windows.Forms.ComboBox ComboOrientation;
        private System.Windows.Forms.ComboBox ComboType;
        private System.Windows.Forms.Label label17;
        private System.Windows.Forms.Label label16;
        private System.Windows.Forms.Label label18;
        private System.Windows.Forms.Button BTNColorQueen;
        private System.Windows.Forms.Button BTNColorMale;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.ComboBox ComboTypeGraph;
    }
}