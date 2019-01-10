package DataBases.SQLite;

public class Utilities {

    /**
     * ------------- HERE WE HAVE KEYS TO MANIPULATE OUR DATABASE -------------
     * **/
    //Name of our database
    public static final String DB_NAME = "SubgueyDB.db";

    //Keys table stations;
    public static final String TBL_ST = "stations";
    //Attributes
    public static final String S_ID = "SID";
    public static final String S_OBJE = "object";
    //Queries
    public static final String S_CREA = "CREATE TABLE " + TBL_ST
            + " (" + S_ID + " TEXT, " + S_OBJE + " BLOB)";
    public static final String S_TRUN = "DELETE FROM " + TBL_ST;
    public static final String S_DROP = "DROP TABLE IF EXISTS " + TBL_ST;
    public static final String S_GETA = "SELECT " + S_ID + ", " + S_OBJE
            + " FROM " + TBL_ST;
    public static final String S_GETO = "SELECT " + S_OBJE + " FROM " + TBL_ST
            + " WHERE " + S_ID + "LIKE ";


    //Keys table events;
    public static final String TBL_EV = "events";
    //Attributes;
    public static final String E_ID = "EID";
    public static final String E_OBJE = "object";
    //Queries
    public static final String E_CREA = "CREATE TABLE " + TBL_EV
            + "(" + E_ID + " TEXT, " + S_OBJE + " BLOB)";
    public static final String E_TRUN = "DELETE FROM " + TBL_EV;
    public static final String E_DROP = "DROP TABLE IF EXISTS " + TBL_EV;
    public static final String E_GETA = "SELECT " + E_ID + ", " + E_OBJE
            + " FROM " + TBL_EV;
    public static final String E_GETO = "SELECT " + E_OBJE + " FROM "
            + TBL_EV + " WHERE " + E_ID + " LIKE ";

}
