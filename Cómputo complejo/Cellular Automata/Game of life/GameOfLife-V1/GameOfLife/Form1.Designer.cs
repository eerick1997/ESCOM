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
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
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
            this.groupBox5 = new System.Windows.Forms.GroupBox();
            this.button1 = new System.Windows.Forms.Button();
            this.numericOnes = new System.Windows.Forms.NumericUpDown();
            this.label7 = new System.Windows.Forms.Label();
            this.groupBox6 = new System.Windows.Forms.GroupBox();
            this.CBDead = new System.Windows.Forms.ComboBox();
            this.CBAlive = new System.Windows.Forms.ComboBox();
            this.label10 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.BTNSelectFile = new System.Windows.Forms.Button();
            this.BTNClear = new System.Windows.Forms.Button();
            this.groupBox7 = new System.Windows.Forms.GroupBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.numericRows = new System.Windows.Forms.NumericUpDown();
            this.numericCols = new System.Windows.Forms.NumericUpDown();
            this.BTNCreateMatrix = new System.Windows.Forms.Button();
            this.groupBox8 = new System.Windows.Forms.GroupBox();
            this.BTNSave = new System.Windows.Forms.Button();
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
            ((System.ComponentModel.ISupportInitialize)(this.numericRows)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericCols)).BeginInit();
            this.groupBox8.SuspendLayout();
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
            // 
            // CHHistogram
            // 
            chartArea1.Name = "ChartArea1";
            this.CHHistogram.ChartAreas.Add(chartArea1);
            legend1.Name = "Legend1";
            this.CHHistogram.Legends.Add(legend1);
            this.CHHistogram.Location = new System.Drawing.Point(6, 19);
            this.CHHistogram.Name = "CHHistogram";
            series1.ChartArea = "ChartArea1";
            series1.Legend = "Legend1";
            series1.Name = "#Ones";
            this.CHHistogram.Series.Add(series1);
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
            this.groupBox2.Location = new System.Drawing.Point(13, 383);
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
            // 
            // TXTGeneration
            // 
            this.TXTGeneration.AutoSize = true;
            this.TXTGeneration.BackColor = System.Drawing.Color.Transparent;
            this.TXTGeneration.ForeColor = System.Drawing.Color.Black;
            this.TXTGeneration.Location = new System.Drawing.Point(615, 598);
            this.TXTGeneration.Name = "TXTGeneration";
            this.TXTGeneration.Size = new System.Drawing.Size(62, 13);
            this.TXTGeneration.TabIndex = 7;
            this.TXTGeneration.Text = "Generation ";
            // 
            // TXTPopulation
            // 
            this.TXTPopulation.AutoSize = true;
            this.TXTPopulation.Location = new System.Drawing.Point(947, 598);
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
            this.TBSpeed.Size = new System.Drawing.Size(491, 45);
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
            this.flowLayoutPanel1.Controls.Add(this.PBAutomataSimulator);
            this.flowLayoutPanel1.Location = new System.Drawing.Point(615, 12);
            this.flowLayoutPanel1.Name = "flowLayoutPanel1";
            this.flowLayoutPanel1.Size = new System.Drawing.Size(639, 583);
            this.flowLayoutPanel1.TabIndex = 11;
            // 
            // groupBox3
            // 
            this.groupBox3.Controls.Add(this.label6);
            this.groupBox3.Controls.Add(this.label1);
            this.groupBox3.Controls.Add(this.TBSpeed);
            this.groupBox3.Location = new System.Drawing.Point(13, 526);
            this.groupBox3.Name = "groupBox3";
            this.groupBox3.Size = new System.Drawing.Size(497, 69);
            this.groupBox3.TabIndex = 12;
            this.groupBox3.TabStop = false;
            this.groupBox3.Text = "Speed";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(479, 53);
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
            this.BTNZoomP.Location = new System.Drawing.Point(534, 405);
            this.BTNZoomP.Name = "BTNZoomP";
            this.BTNZoomP.Size = new System.Drawing.Size(75, 23);
            this.BTNZoomP.TabIndex = 13;
            this.BTNZoomP.Text = "zoom +";
            this.BTNZoomP.UseVisualStyleBackColor = true;
            this.BTNZoomP.Click += new System.EventHandler(this.BTNZoomP_Click);
            // 
            // BTNZoomM
            // 
            this.BTNZoomM.Location = new System.Drawing.Point(534, 438);
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
            this.groupBox4.Location = new System.Drawing.Point(128, 383);
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
            this.groupBox5.Controls.Add(this.label7);
            this.groupBox5.Location = new System.Drawing.Point(166, 438);
            this.groupBox5.Name = "groupBox5";
            this.groupBox5.Size = new System.Drawing.Size(92, 82);
            this.groupBox5.TabIndex = 16;
            this.groupBox5.TabStop = false;
            this.groupBox5.Text = "Random";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(7, 55);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 4;
            this.button1.Text = "Generate";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // numericOnes
            // 
            this.numericOnes.Location = new System.Drawing.Point(6, 32);
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
            this.groupBox6.Controls.Add(this.CBDead);
            this.groupBox6.Controls.Add(this.CBAlive);
            this.groupBox6.Controls.Add(this.label10);
            this.groupBox6.Controls.Add(this.label9);
            this.groupBox6.Location = new System.Drawing.Point(306, 385);
            this.groupBox6.Name = "groupBox6";
            this.groupBox6.Size = new System.Drawing.Size(106, 135);
            this.groupBox6.TabIndex = 17;
            this.groupBox6.TabStop = false;
            this.groupBox6.Text = "Choose colors";
            // 
            // CBDead
            // 
            this.CBDead.FormattingEnabled = true;
            this.CBDead.Items.AddRange(new object[] {
            "White",
            "Black",
            "Red",
            "Blue",
            "Green",
            "Yellow",
            "Violet"});
            this.CBDead.Location = new System.Drawing.Point(11, 102);
            this.CBDead.Name = "CBDead";
            this.CBDead.Size = new System.Drawing.Size(81, 21);
            this.CBDead.TabIndex = 3;
            this.CBDead.SelectedIndexChanged += new System.EventHandler(this.CBDead_SelectedIndexChanged);
            // 
            // CBAlive
            // 
            this.CBAlive.AutoCompleteCustomSource.AddRange(new string[] {
            "White",
            "Black",
            "Red",
            "Blue",
            "Green",
            "Yellow",
            "Violet"});
            this.CBAlive.FormattingEnabled = true;
            this.CBAlive.Items.AddRange(new object[] {
            "White",
            "Black",
            "Red",
            "Blue",
            "Green",
            "Yellow",
            "Violet"});
            this.CBAlive.Location = new System.Drawing.Point(11, 45);
            this.CBAlive.Name = "CBAlive";
            this.CBAlive.Size = new System.Drawing.Size(81, 21);
            this.CBAlive.TabIndex = 2;
            this.CBAlive.SelectedIndexChanged += new System.EventHandler(this.CBAlive_SelectedIndexChanged);
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(35, 85);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(33, 13);
            this.label10.TabIndex = 1;
            this.label10.Text = "Dead";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(38, 28);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(30, 13);
            this.label9.TabIndex = 0;
            this.label9.Text = "Alive";
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
            this.BTNClear.Location = new System.Drawing.Point(534, 470);
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
            this.groupBox7.Location = new System.Drawing.Point(418, 385);
            this.groupBox7.Name = "groupBox7";
            this.groupBox7.Size = new System.Drawing.Size(104, 135);
            this.groupBox7.TabIndex = 20;
            this.groupBox7.TabStop = false;
            this.groupBox7.Text = "Size";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(31, 15);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(34, 13);
            this.label8.TabIndex = 0;
            this.label8.Text = "Rows";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(36, 55);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(27, 13);
            this.label11.TabIndex = 1;
            this.label11.Text = "Cols";
            // 
            // numericRows
            // 
            this.numericRows.Location = new System.Drawing.Point(11, 31);
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
            // numericCols
            // 
            this.numericCols.Location = new System.Drawing.Point(13, 71);
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
            // BTNCreateMatrix
            // 
            this.BTNCreateMatrix.Location = new System.Drawing.Point(13, 99);
            this.BTNCreateMatrix.Name = "BTNCreateMatrix";
            this.BTNCreateMatrix.Size = new System.Drawing.Size(81, 23);
            this.BTNCreateMatrix.TabIndex = 21;
            this.BTNCreateMatrix.Text = "Create";
            this.BTNCreateMatrix.UseVisualStyleBackColor = true;
            this.BTNCreateMatrix.Click += new System.EventHandler(this.BTNCreateMatrix_Click);
            // 
            // groupBox8
            // 
            this.groupBox8.Controls.Add(this.BTNSave);
            this.groupBox8.Controls.Add(this.BTNSelectFile);
            this.groupBox8.Location = new System.Drawing.Point(531, 515);
            this.groupBox8.Name = "groupBox8";
            this.groupBox8.Size = new System.Drawing.Size(81, 75);
            this.groupBox8.TabIndex = 21;
            this.groupBox8.TabStop = false;
            this.groupBox8.Text = "File options";
            // 
            // BTNSave
            // 
            this.BTNSave.Location = new System.Drawing.Point(3, 44);
            this.BTNSave.Name = "BTNSave";
            this.BTNSave.Size = new System.Drawing.Size(75, 23);
            this.BTNSave.TabIndex = 0;
            this.BTNSave.Text = "Save states";
            this.BTNSave.UseVisualStyleBackColor = true;
            this.BTNSave.Click += new System.EventHandler(this.BTNSave_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1266, 615);
            this.Controls.Add(this.groupBox8);
            this.Controls.Add(this.groupBox7);
            this.Controls.Add(this.BTNClear);
            this.Controls.Add(this.groupBox6);
            this.Controls.Add(this.groupBox5);
            this.Controls.Add(this.groupBox4);
            this.Controls.Add(this.BTNZoomM);
            this.Controls.Add(this.BTNZoomP);
            this.Controls.Add(this.groupBox3);
            this.Controls.Add(this.TXTPopulation);
            this.Controls.Add(this.TXTGeneration);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.flowLayoutPanel1);
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
            this.groupBox5.ResumeLayout(false);
            this.groupBox5.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericOnes)).EndInit();
            this.groupBox6.ResumeLayout(false);
            this.groupBox6.PerformLayout();
            this.groupBox7.ResumeLayout(false);
            this.groupBox7.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericRows)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericCols)).EndInit();
            this.groupBox8.ResumeLayout(false);
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
        private System.Windows.Forms.FlowLayoutPanel flowLayoutPanel1;
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
        private System.Windows.Forms.ComboBox CBDead;
        private System.Windows.Forms.ComboBox CBAlive;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label9;
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
    }
}