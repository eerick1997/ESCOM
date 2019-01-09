namespace GameOfLife
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
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea3 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend3 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series3 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.PBAutomataSimulator = new System.Windows.Forms.PictureBox();
            this.CHHistogram = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.BTNStart = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.ComboBY2i = new System.Windows.Forms.ComboBox();
            this.ComboBX2i = new System.Windows.Forms.ComboBox();
            this.ComboBYi = new System.Windows.Forms.ComboBox();
            this.ComboBXi = new System.Windows.Forms.ComboBox();
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
            this.CBPatternRecognition = new System.Windows.Forms.CheckBox();
            this.groupBox5 = new System.Windows.Forms.GroupBox();
            this.button1 = new System.Windows.Forms.Button();
            this.numericOnes = new System.Windows.Forms.NumericUpDown();
            this.label7 = new System.Windows.Forms.Label();
            this.groupBox6 = new System.Windows.Forms.GroupBox();
            this.BTNGrid = new System.Windows.Forms.Button();
            this.BTNDeadCells = new System.Windows.Forms.Button();
            this.BTNAliveCells = new System.Windows.Forms.Button();
            this.BTNSelectFile = new System.Windows.Forms.Button();
            this.BTNClear = new System.Windows.Forms.Button();
            this.groupBox7 = new System.Windows.Forms.GroupBox();
            this.BTNCreateMatrix = new System.Windows.Forms.Button();
            this.numericCols = new System.Windows.Forms.NumericUpDown();
            this.numericRows = new System.Windows.Forms.NumericUpDown();
            this.label11 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.groupBox8 = new System.Windows.Forms.GroupBox();
            this.BTNSavePatterns = new System.Windows.Forms.Button();
            this.BTNSave = new System.Windows.Forms.Button();
            this.label12 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.label14 = new System.Windows.Forms.Label();
            this.groupBox9 = new System.Windows.Forms.GroupBox();
            this.CBPoints = new System.Windows.Forms.CheckBox();
            this.CheckGraphEnabled = new System.Windows.Forms.CheckBox();
            this.groupBox10 = new System.Windows.Forms.GroupBox();
            this.pictureBox10 = new System.Windows.Forms.PictureBox();
            this.pictureBox9 = new System.Windows.Forms.PictureBox();
            this.pictureBox8 = new System.Windows.Forms.PictureBox();
            this.pictureBox7 = new System.Windows.Forms.PictureBox();
            this.pictureBox6 = new System.Windows.Forms.PictureBox();
            this.pictureBox5 = new System.Windows.Forms.PictureBox();
            this.pictureBox4 = new System.Windows.Forms.PictureBox();
            this.pictureBox3 = new System.Windows.Forms.PictureBox();
            this.pictureBox2 = new System.Windows.Forms.PictureBox();
            this.pictureBox1 = new System.Windows.Forms.PictureBox();
            this.groupBox11 = new System.Windows.Forms.GroupBox();
            this.colorDialog = new System.Windows.Forms.ColorDialog();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.generarPatronesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.generatePatternsToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.groupBox12 = new System.Windows.Forms.GroupBox();
            this.label10 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.comboRuleMem = new System.Windows.Forms.ComboBox();
            this.NumericGenMem = new System.Windows.Forms.NumericUpDown();
            this.backgroundWorker1 = new System.ComponentModel.BackgroundWorker();
            this.comboSpace = new System.Windows.Forms.ComboBox();
            ((System.ComponentModel.ISupportInitialize)(this.PBAutomataSimulator)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.CHHistogram)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
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
            this.groupBox8.SuspendLayout();
            this.groupBox9.SuspendLayout();
            this.groupBox10.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox9)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox8)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox7)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox5)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).BeginInit();
            this.groupBox11.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            this.groupBox12.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.NumericGenMem)).BeginInit();
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
            this.PBAutomataSimulator.Paint += new System.Windows.Forms.PaintEventHandler(this.PBAutomataSimulator_Paint);
            this.PBAutomataSimulator.MouseDown += new System.Windows.Forms.MouseEventHandler(this.PBAutomataSimulator_MouseDown);
            this.PBAutomataSimulator.MouseMove += new System.Windows.Forms.MouseEventHandler(this.PBAutomataSimulator_MouseMove);
            // 
            // CHHistogram
            // 
            chartArea3.Name = "ChartArea1";
            this.CHHistogram.ChartAreas.Add(chartArea3);
            legend3.Name = "Legend1";
            this.CHHistogram.Legends.Add(legend3);
            this.CHHistogram.Location = new System.Drawing.Point(6, 19);
            this.CHHistogram.Name = "CHHistogram";
            series3.ChartArea = "ChartArea1";
            series3.Legend = "Legend1";
            series3.Name = "#Ones";
            this.CHHistogram.Series.Add(series3);
            this.CHHistogram.Size = new System.Drawing.Size(584, 337);
            this.CHHistogram.TabIndex = 2;
            this.CHHistogram.Text = "chart1";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.CHHistogram);
            this.groupBox1.Location = new System.Drawing.Point(13, 31);
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
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.label5);
            this.groupBox2.Controls.Add(this.label4);
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Controls.Add(this.label2);
            this.groupBox2.Controls.Add(this.ComboBY2i);
            this.groupBox2.Controls.Add(this.ComboBX2i);
            this.groupBox2.Controls.Add(this.ComboBYi);
            this.groupBox2.Controls.Add(this.ComboBXi);
            this.groupBox2.Location = new System.Drawing.Point(13, 402);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(107, 137);
            this.groupBox2.TabIndex = 6;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Rules";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(11, 111);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(26, 13);
            this.label5.TabIndex = 7;
            this.label5.Text = "Y_2";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(11, 83);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(26, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "X_2";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(10, 55);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(14, 13);
            this.label3.TabIndex = 5;
            this.label3.Text = "Y";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(8, 27);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(14, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "X";
            // 
            // ComboBY2i
            // 
            this.ComboBY2i.FormattingEnabled = true;
            this.ComboBY2i.Items.AddRange(new object[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8"});
            this.ComboBY2i.Location = new System.Drawing.Point(47, 104);
            this.ComboBY2i.Name = "ComboBY2i";
            this.ComboBY2i.Size = new System.Drawing.Size(43, 21);
            this.ComboBY2i.TabIndex = 3;
            this.ComboBY2i.Text = "3";
            // 
            // ComboBX2i
            // 
            this.ComboBX2i.FormattingEnabled = true;
            this.ComboBX2i.Items.AddRange(new object[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8"});
            this.ComboBX2i.Location = new System.Drawing.Point(47, 76);
            this.ComboBX2i.Name = "ComboBX2i";
            this.ComboBX2i.Size = new System.Drawing.Size(43, 21);
            this.ComboBX2i.TabIndex = 2;
            this.ComboBX2i.Text = "3";
            // 
            // ComboBYi
            // 
            this.ComboBYi.FormattingEnabled = true;
            this.ComboBYi.Items.AddRange(new object[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8"});
            this.ComboBYi.Location = new System.Drawing.Point(48, 48);
            this.ComboBYi.Name = "ComboBYi";
            this.ComboBYi.Size = new System.Drawing.Size(43, 21);
            this.ComboBYi.TabIndex = 1;
            this.ComboBYi.Text = "3";
            // 
            // ComboBXi
            // 
            this.ComboBXi.FormattingEnabled = true;
            this.ComboBXi.Items.AddRange(new object[] {
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8"});
            this.ComboBXi.Location = new System.Drawing.Point(48, 20);
            this.ComboBXi.Name = "ComboBXi";
            this.ComboBXi.Size = new System.Drawing.Size(43, 21);
            this.ComboBXi.TabIndex = 0;
            this.ComboBXi.Text = "2";
            // 
            // TXTGeneration
            // 
            this.TXTGeneration.AutoSize = true;
            this.TXTGeneration.BackColor = System.Drawing.Color.Transparent;
            this.TXTGeneration.ForeColor = System.Drawing.Color.Black;
            this.TXTGeneration.Location = new System.Drawing.Point(6, 22);
            this.TXTGeneration.Name = "TXTGeneration";
            this.TXTGeneration.Size = new System.Drawing.Size(62, 13);
            this.TXTGeneration.TabIndex = 7;
            this.TXTGeneration.Text = "Generation ";
            // 
            // TXTPopulation
            // 
            this.TXTPopulation.AutoSize = true;
            this.TXTPopulation.Location = new System.Drawing.Point(6, 44);
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
            this.TBSpeed.Minimum = 10;
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
            this.flowLayoutPanel1.Location = new System.Drawing.Point(618, 100);
            this.flowLayoutPanel1.MinimumSize = new System.Drawing.Size(639, 600);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(639, 600);
            this.flowLayoutPanel1.TabIndex = 11;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.label6);
            this.groupBox3.Controls.Add(this.label1);
            this.groupBox3.Controls.Add(this.TBSpeed);
            this.groupBox3.Location = new System.Drawing.Point(16, 631);
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
            this.label1.Size = new System.Drawing.Size(32, 13);
            this.label1.TabIndex = 11;
            this.label1.Text = "10ms";
            // 
            // BTNZoomP
            // 
            this.BTNZoomP.Location = new System.Drawing.Point(534, 424);
            this.BTNZoomP.Name = "BTNZoomP";
            this.BTNZoomP.Size = new System.Drawing.Size(75, 23);
            this.BTNZoomP.TabIndex = 13;
            this.BTNZoomP.Text = "zoom +";
            this.BTNZoomP.UseVisualStyleBackColor = true;
            this.BTNZoomP.Click += new System.EventHandler(this.BTNZoomP_Click);
            // 
            // BTNZoomM
            // 
            this.BTNZoomM.Location = new System.Drawing.Point(534, 457);
            this.BTNZoomM.Name = "BTNZoomM";
            this.BTNZoomM.Size = new System.Drawing.Size(75, 23);
            this.BTNZoomM.TabIndex = 14;
            this.BTNZoomM.Text = "zoom -";
            this.BTNZoomM.UseVisualStyleBackColor = true;
            this.BTNZoomM.Click += new System.EventHandler(this.BTNZoomM_Click);
            // 
            // groupBox4
            // 
            this.groupBox4.Controls.Add(this.CBPatternRecognition);
            this.groupBox4.Controls.Add(this.BTNStart);
            this.groupBox4.Controls.Add(this.BTNStep);
            this.groupBox4.Location = new System.Drawing.Point(128, 402);
            this.groupBox4.Name = "groupBox4";
            this.groupBox4.Size = new System.Drawing.Size(168, 69);
            this.groupBox4.TabIndex = 15;
            this.groupBox4.TabStop = false;
            this.groupBox4.Text = "Controlls";
            // 
            // CBPatternRecognition
            // 
            this.CBPatternRecognition.AutoSize = true;
            this.CBPatternRecognition.Location = new System.Drawing.Point(24, 48);
            this.CBPatternRecognition.Name = "CBPatternRecognition";
            this.CBPatternRecognition.Size = new System.Drawing.Size(115, 17);
            this.CBPatternRecognition.TabIndex = 29;
            this.CBPatternRecognition.Text = "Pattern recognition";
            this.CBPatternRecognition.UseVisualStyleBackColor = true;
            // 
            // groupBox5
            // 
            this.groupBox5.Controls.Add(this.button1);
            this.groupBox5.Controls.Add(this.numericOnes);
            this.groupBox5.Controls.Add(this.label7);
            this.groupBox5.Location = new System.Drawing.Point(166, 471);
            this.groupBox5.Name = "groupBox5";
            this.groupBox5.Size = new System.Drawing.Size(92, 82);
            this.groupBox5.TabIndex = 16;
            this.groupBox5.TabStop = false;
            this.groupBox5.Text = "Random";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(9, 55);
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
            this.numericOnes.Location = new System.Drawing.Point(9, 32);
            this.numericOnes.Name = "numericOnes";
            this.numericOnes.Size = new System.Drawing.Size(76, 20);
            this.numericOnes.TabIndex = 2;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(33, 17);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(18, 13);
            this.label7.TabIndex = 0;
            this.label7.Text = "1s";
            // 
            // groupBox6
            // 
            this.groupBox6.Controls.Add(this.BTNGrid);
            this.groupBox6.Controls.Add(this.BTNDeadCells);
            this.groupBox6.Controls.Add(this.BTNAliveCells);
            this.groupBox6.Location = new System.Drawing.Point(306, 404);
            this.groupBox6.Name = "groupBox6";
            this.groupBox6.Size = new System.Drawing.Size(106, 157);
            this.groupBox6.TabIndex = 17;
            this.groupBox6.TabStop = false;
            this.groupBox6.Text = "Choose colors";
            // 
            // BTNGrid
            // 
            this.BTNGrid.Location = new System.Drawing.Point(15, 119);
            this.BTNGrid.Name = "BTNGrid";
            this.BTNGrid.Size = new System.Drawing.Size(75, 23);
            this.BTNGrid.TabIndex = 7;
            this.BTNGrid.Text = "Grid";
            this.BTNGrid.UseVisualStyleBackColor = true;
            this.BTNGrid.Click += new System.EventHandler(this.BTNGrid_Click);
            // 
            // BTNDeadCells
            // 
            this.BTNDeadCells.Location = new System.Drawing.Point(15, 74);
            this.BTNDeadCells.Name = "BTNDeadCells";
            this.BTNDeadCells.Size = new System.Drawing.Size(75, 23);
            this.BTNDeadCells.TabIndex = 6;
            this.BTNDeadCells.Text = "Dead cells";
            this.BTNDeadCells.UseVisualStyleBackColor = true;
            this.BTNDeadCells.Click += new System.EventHandler(this.BTNDeadCells_Click);
            // 
            // BTNAliveCells
            // 
            this.BTNAliveCells.Location = new System.Drawing.Point(15, 28);
            this.BTNAliveCells.Name = "BTNAliveCells";
            this.BTNAliveCells.Size = new System.Drawing.Size(75, 23);
            this.BTNAliveCells.TabIndex = 5;
            this.BTNAliveCells.Text = "Alive cells";
            this.BTNAliveCells.UseVisualStyleBackColor = true;
            this.BTNAliveCells.Click += new System.EventHandler(this.button2_Click_1);
            // 
            // BTNSelectFile
            // 
            this.BTNSelectFile.Location = new System.Drawing.Point(3, 17);
            this.BTNSelectFile.Name = "BTNSelectFile";
            this.BTNSelectFile.Size = new System.Drawing.Size(75, 23);
            this.BTNSelectFile.TabIndex = 18;
            this.BTNSelectFile.Text = "Choose file";
            this.BTNSelectFile.UseVisualStyleBackColor = true;
            this.BTNSelectFile.Click += new System.EventHandler(this.button2_Click);
            // 
            // BTNClear
            // 
            this.BTNClear.Location = new System.Drawing.Point(534, 489);
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
            this.groupBox7.Location = new System.Drawing.Point(418, 404);
            this.groupBox7.Name = "groupBox7";
            this.groupBox7.Size = new System.Drawing.Size(104, 157);
            this.groupBox7.TabIndex = 20;
            this.groupBox7.TabStop = false;
            this.groupBox7.Text = "Size";
            // 
            // BTNCreateMatrix
            // 
            this.BTNCreateMatrix.Location = new System.Drawing.Point(13, 119);
            this.BTNCreateMatrix.Name = "BTNCreateMatrix";
            this.BTNCreateMatrix.Size = new System.Drawing.Size(81, 23);
            this.BTNCreateMatrix.TabIndex = 21;
            this.BTNCreateMatrix.Text = "Create";
            this.BTNCreateMatrix.UseVisualStyleBackColor = true;
            this.BTNCreateMatrix.Click += new System.EventHandler(this.BTNCreateMatrix_Click);
            // 
            // numericCols
            // 
            this.numericCols.Location = new System.Drawing.Point(13, 82);
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
            this.numericRows.Location = new System.Drawing.Point(11, 42);
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
            10,
            0,
            0,
            0});
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(36, 66);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(27, 13);
            this.label11.TabIndex = 1;
            this.label11.Text = "Cols";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(29, 25);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(34, 13);
            this.label8.TabIndex = 0;
            this.label8.Text = "Rows";
            // 
            // groupBox8
            // 
            this.groupBox8.Controls.Add(this.BTNSavePatterns);
            this.groupBox8.Controls.Add(this.BTNSave);
            this.groupBox8.Controls.Add(this.BTNSelectFile);
            this.groupBox8.Location = new System.Drawing.Point(125, 557);
            this.groupBox8.Name = "groupBox8";
            this.groupBox8.Size = new System.Drawing.Size(171, 75);
            this.groupBox8.TabIndex = 21;
            this.groupBox8.TabStop = false;
            this.groupBox8.Text = "File options";
            // 
            // BTNSavePatterns
            // 
            this.BTNSavePatterns.Location = new System.Drawing.Point(36, 46);
            this.BTNSavePatterns.Name = "BTNSavePatterns";
            this.BTNSavePatterns.Size = new System.Drawing.Size(96, 23);
            this.BTNSavePatterns.TabIndex = 19;
            this.BTNSavePatterns.Text = "Save patterns";
            this.BTNSavePatterns.UseVisualStyleBackColor = true;
            this.BTNSavePatterns.Click += new System.EventHandler(this.BTNSavePatterns_Click);
            // 
            // BTNSave
            // 
            this.BTNSave.Location = new System.Drawing.Point(90, 17);
            this.BTNSave.Name = "BTNSave";
            this.BTNSave.Size = new System.Drawing.Size(75, 23);
            this.BTNSave.TabIndex = 0;
            this.BTNSave.Text = "Save states";
            this.BTNSave.UseVisualStyleBackColor = true;
            this.BTNSave.Click += new System.EventHandler(this.BTNSave_Click);
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(6, 66);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(83, 13);
            this.label12.TabIndex = 22;
            this.label12.Text = "Total population";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(6, 88);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(47, 13);
            this.label13.TabIndex = 23;
            this.label13.Text = "Average";
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Location = new System.Drawing.Point(6, 110);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(42, 13);
            this.label14.TabIndex = 24;
            this.label14.Text = "Density";
            // 
            // groupBox9
            // 
            this.groupBox9.Controls.Add(this.CBPoints);
            this.groupBox9.Controls.Add(this.CheckGraphEnabled);
            this.groupBox9.Location = new System.Drawing.Point(15, 545);
            this.groupBox9.Name = "groupBox9";
            this.groupBox9.Size = new System.Drawing.Size(104, 72);
            this.groupBox9.TabIndex = 25;
            this.groupBox9.TabStop = false;
            this.groupBox9.Text = "Graph options";
            // 
            // CBPoints
            // 
            this.CBPoints.AutoSize = true;
            this.CBPoints.Location = new System.Drawing.Point(16, 41);
            this.CBPoints.Name = "CBPoints";
            this.CBPoints.Size = new System.Drawing.Size(55, 17);
            this.CBPoints.TabIndex = 1;
            this.CBPoints.Text = "Points";
            this.CBPoints.UseVisualStyleBackColor = true;
            this.CBPoints.CheckedChanged += new System.EventHandler(this.CBPoints_CheckedChanged);
            // 
            // CheckGraphEnabled
            // 
            this.CheckGraphEnabled.AutoSize = true;
            this.CheckGraphEnabled.Checked = true;
            this.CheckGraphEnabled.CheckState = System.Windows.Forms.CheckState.Checked;
            this.CheckGraphEnabled.Location = new System.Drawing.Point(16, 23);
            this.CheckGraphEnabled.Name = "CheckGraphEnabled";
            this.CheckGraphEnabled.Size = new System.Drawing.Size(59, 17);
            this.CheckGraphEnabled.TabIndex = 0;
            this.CheckGraphEnabled.Text = "Enable";
            this.CheckGraphEnabled.UseVisualStyleBackColor = true;
            // 
            // groupBox10
            // 
            this.groupBox10.Controls.Add(this.TXTGeneration);
            this.groupBox10.Controls.Add(this.TXTPopulation);
            this.groupBox10.Controls.Add(this.label14);
            this.groupBox10.Controls.Add(this.label12);
            this.groupBox10.Controls.Add(this.label13);
            this.groupBox10.Location = new System.Drawing.Point(418, 567);
            this.groupBox10.Name = "groupBox10";
            this.groupBox10.Size = new System.Drawing.Size(191, 133);
            this.groupBox10.TabIndex = 26;
            this.groupBox10.TabStop = false;
            this.groupBox10.Text = "Data";
            // 
            // pictureBox10
            // 
            this.pictureBox10.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pictureBox10.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox10.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox10.Image")));
            this.pictureBox10.Location = new System.Drawing.Point(581, 16);
            this.pictureBox10.Name = "pictureBox10";
            this.pictureBox10.Size = new System.Drawing.Size(38, 50);
            this.pictureBox10.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox10.TabIndex = 9;
            this.pictureBox10.TabStop = false;
            this.pictureBox10.MouseUp += new System.Windows.Forms.MouseEventHandler(this.pictureBox10_MouseUp);
            // 
            // pictureBox9
            // 
            this.pictureBox9.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pictureBox9.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox9.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox9.Image")));
            this.pictureBox9.Location = new System.Drawing.Point(512, 31);
            this.pictureBox9.Name = "pictureBox9";
            this.pictureBox9.Size = new System.Drawing.Size(63, 26);
            this.pictureBox9.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox9.TabIndex = 8;
            this.pictureBox9.TabStop = false;
            this.pictureBox9.MouseUp += new System.Windows.Forms.MouseEventHandler(this.pictureBox9_MouseUp);
            // 
            // pictureBox8
            // 
            this.pictureBox8.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pictureBox8.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox8.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox8.Image")));
            this.pictureBox8.Location = new System.Drawing.Point(456, 16);
            this.pictureBox8.Name = "pictureBox8";
            this.pictureBox8.Size = new System.Drawing.Size(50, 50);
            this.pictureBox8.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox8.TabIndex = 7;
            this.pictureBox8.TabStop = false;
            this.pictureBox8.MouseUp += new System.Windows.Forms.MouseEventHandler(this.pictureBox8_MouseUp);
            // 
            // pictureBox7
            // 
            this.pictureBox7.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pictureBox7.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox7.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox7.Image")));
            this.pictureBox7.Location = new System.Drawing.Point(412, 16);
            this.pictureBox7.Name = "pictureBox7";
            this.pictureBox7.Size = new System.Drawing.Size(38, 50);
            this.pictureBox7.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox7.TabIndex = 6;
            this.pictureBox7.TabStop = false;
            this.pictureBox7.MouseUp += new System.Windows.Forms.MouseEventHandler(this.pictureBox7_MouseUp);
            // 
            // pictureBox6
            // 
            this.pictureBox6.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pictureBox6.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox6.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox6.Image")));
            this.pictureBox6.Location = new System.Drawing.Point(329, 16);
            this.pictureBox6.Name = "pictureBox6";
            this.pictureBox6.Size = new System.Drawing.Size(77, 50);
            this.pictureBox6.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox6.TabIndex = 5;
            this.pictureBox6.TabStop = false;
            this.pictureBox6.MouseUp += new System.Windows.Forms.MouseEventHandler(this.pictureBox6_MouseUp);
            // 
            // pictureBox5
            // 
            this.pictureBox5.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pictureBox5.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox5.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox5.Image")));
            this.pictureBox5.Location = new System.Drawing.Point(273, 16);
            this.pictureBox5.Name = "pictureBox5";
            this.pictureBox5.Size = new System.Drawing.Size(50, 50);
            this.pictureBox5.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox5.TabIndex = 4;
            this.pictureBox5.TabStop = false;
            this.pictureBox5.MouseUp += new System.Windows.Forms.MouseEventHandler(this.pictureBox5_MouseUp);
            // 
            // pictureBox4
            // 
            this.pictureBox4.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pictureBox4.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox4.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox4.Image")));
            this.pictureBox4.Location = new System.Drawing.Point(217, 16);
            this.pictureBox4.Name = "pictureBox4";
            this.pictureBox4.Size = new System.Drawing.Size(50, 50);
            this.pictureBox4.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox4.TabIndex = 3;
            this.pictureBox4.TabStop = false;
            this.pictureBox4.MouseUp += new System.Windows.Forms.MouseEventHandler(this.pictureBox4_MouseUp);
            // 
            // pictureBox3
            // 
            this.pictureBox3.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pictureBox3.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox3.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox3.Image")));
            this.pictureBox3.Location = new System.Drawing.Point(161, 16);
            this.pictureBox3.Name = "pictureBox3";
            this.pictureBox3.Size = new System.Drawing.Size(50, 50);
            this.pictureBox3.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox3.TabIndex = 2;
            this.pictureBox3.TabStop = false;
            this.pictureBox3.MouseUp += new System.Windows.Forms.MouseEventHandler(this.pictureBox3_MouseUp);
            // 
            // pictureBox2
            // 
            this.pictureBox2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pictureBox2.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox2.ErrorImage = ((System.Drawing.Image)(resources.GetObject("pictureBox2.ErrorImage")));
            this.pictureBox2.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox2.Image")));
            this.pictureBox2.Location = new System.Drawing.Point(70, 16);
            this.pictureBox2.Name = "pictureBox2";
            this.pictureBox2.Size = new System.Drawing.Size(85, 50);
            this.pictureBox2.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox2.TabIndex = 1;
            this.pictureBox2.TabStop = false;
            this.pictureBox2.MouseUp += new System.Windows.Forms.MouseEventHandler(this.pictureBox2_MouseUp);
            // 
            // pictureBox1
            // 
            this.pictureBox1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pictureBox1.Cursor = System.Windows.Forms.Cursors.Hand;
            this.pictureBox1.Image = ((System.Drawing.Image)(resources.GetObject("pictureBox1.Image")));
            this.pictureBox1.Location = new System.Drawing.Point(14, 16);
            this.pictureBox1.Name = "pictureBox1";
            this.pictureBox1.Size = new System.Drawing.Size(50, 50);
            this.pictureBox1.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pictureBox1.TabIndex = 0;
            this.pictureBox1.TabStop = false;
            this.pictureBox1.MouseUp += new System.Windows.Forms.MouseEventHandler(this.pictureBox1_MouseUp);
            // 
            // groupBox11
            // 
            this.groupBox11.Controls.Add(this.pictureBox1);
            this.groupBox11.Controls.Add(this.pictureBox2);
            this.groupBox11.Controls.Add(this.pictureBox10);
            this.groupBox11.Controls.Add(this.pictureBox3);
            this.groupBox11.Controls.Add(this.pictureBox5);
            this.groupBox11.Controls.Add(this.pictureBox4);
            this.groupBox11.Controls.Add(this.pictureBox9);
            this.groupBox11.Controls.Add(this.pictureBox6);
            this.groupBox11.Controls.Add(this.pictureBox7);
            this.groupBox11.Controls.Add(this.pictureBox8);
            this.groupBox11.Location = new System.Drawing.Point(621, 23);
            this.groupBox11.Name = "groupBox11";
            this.groupBox11.Size = new System.Drawing.Size(633, 74);
            this.groupBox11.TabIndex = 27;
            this.groupBox11.TabStop = false;
            this.groupBox11.Text = "Patterns";
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.generarPatronesToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(1266, 24);
            this.menuStrip1.TabIndex = 28;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // generarPatronesToolStripMenuItem
            // 
            this.generarPatronesToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.generatePatternsToolStripMenuItem});
            this.generarPatronesToolStripMenuItem.Name = "generarPatronesToolStripMenuItem";
            this.generarPatronesToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.generarPatronesToolStripMenuItem.Text = "File";
            // 
            // generatePatternsToolStripMenuItem
            // 
            this.generatePatternsToolStripMenuItem.Name = "generatePatternsToolStripMenuItem";
            this.generatePatternsToolStripMenuItem.Size = new System.Drawing.Size(167, 22);
            this.generatePatternsToolStripMenuItem.Text = "Generate patterns";
            this.generatePatternsToolStripMenuItem.Click += new System.EventHandler(this.generatePatternsToolStripMenuItem_Click);
            // 
            // groupBox12
            // 
            this.groupBox12.Controls.Add(this.label10);
            this.groupBox12.Controls.Add(this.label9);
            this.groupBox12.Controls.Add(this.comboRuleMem);
            this.groupBox12.Controls.Add(this.NumericGenMem);
            this.groupBox12.Location = new System.Drawing.Point(306, 574);
            this.groupBox12.Name = "groupBox12";
            this.groupBox12.Size = new System.Drawing.Size(106, 123);
            this.groupBox12.TabIndex = 29;
            this.groupBox12.TabStop = false;
            this.groupBox12.Text = "Memory";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(18, 67);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(29, 13);
            this.label10.TabIndex = 3;
            this.label10.Text = "Rule";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(13, 21);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(79, 13);
            this.label9.TabIndex = 2;
            this.label9.Text = "Generations (τ)";
            // 
            // comboRuleMem
            // 
            this.comboRuleMem.FormattingEnabled = true;
            this.comboRuleMem.Items.AddRange(new object[] {
            "Majority",
            "Minority",
            "Parity"});
            this.comboRuleMem.Location = new System.Drawing.Point(15, 88);
            this.comboRuleMem.Name = "comboRuleMem";
            this.comboRuleMem.Size = new System.Drawing.Size(75, 21);
            this.comboRuleMem.TabIndex = 1;
            this.comboRuleMem.Text = "Majority";
            // 
            // NumericGenMem
            // 
            this.NumericGenMem.Location = new System.Drawing.Point(13, 39);
            this.NumericGenMem.Minimum = new decimal(new int[] {
            3,
            0,
            0,
            0});
            this.NumericGenMem.Name = "NumericGenMem";
            this.NumericGenMem.Size = new System.Drawing.Size(77, 20);
            this.NumericGenMem.TabIndex = 0;
            this.NumericGenMem.Value = new decimal(new int[] {
            3,
            0,
            0,
            0});
            this.NumericGenMem.ValueChanged += new System.EventHandler(this.NumericGenMem_ValueChanged);
            // 
            // comboSpace
            // 
            this.comboSpace.FormattingEnabled = true;
            this.comboSpace.Items.AddRange(new object[] {
            "Normal",
            "Memory"});
            this.comboSpace.Location = new System.Drawing.Point(534, 523);
            this.comboSpace.Name = "comboSpace";
            this.comboSpace.Size = new System.Drawing.Size(75, 21);
            this.comboSpace.TabIndex = 30;
            this.comboSpace.Text = "Normal";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1266, 710);
            this.Controls.Add(this.comboSpace);
            this.Controls.Add(this.groupBox12);
            this.Controls.Add(this.groupBox11);
            this.Controls.Add(this.groupBox10);
            this.Controls.Add(this.groupBox9);
            this.Controls.Add(this.groupBox8);
            this.Controls.Add(this.groupBox7);
            this.Controls.Add(this.BTNClear);
            this.Controls.Add(this.groupBox6);
            this.Controls.Add(this.groupBox5);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.BTNZoomM);
            this.Controls.Add(this.BTNZoomP);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.flowLayoutPanel1);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = " ";
            ((System.ComponentModel.ISupportInitialize)(this.PBAutomataSimulator)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.CHHistogram)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.TBSpeed)).EndInit();
            this.flowLayoutPanel1.ResumeLayout(false);
            this.flowLayoutPanel1.PerformLayout();
            this.groupBox3.ResumeLayout(false);
            this.groupBox3.PerformLayout();
            this.groupBox4.ResumeLayout(false);
            this.groupBox4.PerformLayout();
            this.groupBox5.ResumeLayout(false);
            this.groupBox5.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericOnes)).EndInit();
            this.groupBox6.ResumeLayout(false);
            this.groupBox7.ResumeLayout(false);
            this.groupBox7.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericCols)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericRows)).EndInit();
            this.groupBox8.ResumeLayout(false);
            this.groupBox9.ResumeLayout(false);
            this.groupBox9.PerformLayout();
            this.groupBox10.ResumeLayout(false);
            this.groupBox10.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox10)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox9)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox8)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox7)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox6)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox5)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox1)).EndInit();
            this.groupBox11.ResumeLayout(false);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.groupBox12.ResumeLayout(false);
            this.groupBox12.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.NumericGenMem)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox PBAutomataSimulator;
        private System.Windows.Forms.DataVisualization.Charting.Chart CHHistogram;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Button BTNStart;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label TXTGeneration;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox ComboBY2i;
        private System.Windows.Forms.ComboBox ComboBX2i;
        private System.Windows.Forms.ComboBox ComboBYi;
        private System.Windows.Forms.ComboBox ComboBXi;
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
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.GroupBox groupBox6;
        private System.Windows.Forms.Button BTNSelectFile;
        private System.Windows.Forms.Button BTNClear;
        private System.Windows.Forms.GroupBox groupBox7;
        private System.Windows.Forms.NumericUpDown numericCols;
        private System.Windows.Forms.NumericUpDown numericRows;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Button BTNCreateMatrix;
        private System.Windows.Forms.GroupBox groupBox8;
        private System.Windows.Forms.Button BTNSave;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.GroupBox groupBox9;
        private System.Windows.Forms.CheckBox CheckGraphEnabled;
        private System.Windows.Forms.GroupBox groupBox10;
        public System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
        private System.Windows.Forms.PictureBox pictureBox1;
        private System.Windows.Forms.PictureBox pictureBox10;
        private System.Windows.Forms.PictureBox pictureBox9;
        private System.Windows.Forms.PictureBox pictureBox8;
        private System.Windows.Forms.PictureBox pictureBox7;
        private System.Windows.Forms.PictureBox pictureBox6;
        private System.Windows.Forms.PictureBox pictureBox5;
        private System.Windows.Forms.PictureBox pictureBox4;
        private System.Windows.Forms.PictureBox pictureBox3;
        private System.Windows.Forms.PictureBox pictureBox2;
        private System.Windows.Forms.GroupBox groupBox11;
        private System.Windows.Forms.ColorDialog colorDialog;
        private System.Windows.Forms.Button BTNGrid;
        private System.Windows.Forms.Button BTNDeadCells;
        private System.Windows.Forms.Button BTNAliveCells;
        private System.Windows.Forms.CheckBox CBPoints;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem generarPatronesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem generatePatternsToolStripMenuItem;
        private System.Windows.Forms.Button BTNSavePatterns;
        private System.Windows.Forms.CheckBox CBPatternRecognition;
        private System.Windows.Forms.GroupBox groupBox12;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.ComboBox comboRuleMem;
        private System.Windows.Forms.NumericUpDown NumericGenMem;
        private System.ComponentModel.BackgroundWorker backgroundWorker1;
        private System.Windows.Forms.ComboBox comboSpace;
    }
}