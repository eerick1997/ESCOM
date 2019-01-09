class Simbolo {
	String nombre;
	public short tipo;
	double val;
	public String metodo;
	int defn;
	Simbolo sig;

	Simbolo(String s, short t, double d)
	{
		nombre=s;
		tipo=t;
		val=d;
	}
        public Simbolo obtenSig()
        {
		return sig;
	}
        public void ponSig(Simbolo s)
	{
		sig=s;
	}
        public String obtenNombre()
	{
		return nombre;
	}
}