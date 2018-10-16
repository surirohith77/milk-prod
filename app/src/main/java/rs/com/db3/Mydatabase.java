package rs.com.db3;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mydatabase extends SQLiteOpenHelper {
    public static final String DBNAME = "ssroh";
    public static final int VERSION = 1;
    public static final String TABLE_NAME = "employee_details";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAMe";
    public static final String COL3 = "EMAIL";
    public static final String COL4 = "PASSWORD";


    public Mydatabase(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String qry="Create table "+TABLE_NAME+"("+COL1+" INTEGER primary key AUTOINCREMENT,"+COL2+" text," +
                ""+COL3+" text,"+COL4+" text)";
        db.execSQL(qry);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean validate(String email,String pass)
    {
        String col[] = {COL4};
        String sel = COL3+" = ?";
        String sel_args[] = {email};

        SQLiteDatabase db = getWritableDatabase();
        Cursor c = db.query(TABLE_NAME,col,sel,sel_args,null,null,null);
        boolean res = c.moveToFirst();
        if (res)
        {
            String pas = c.getString(0);
            if (pas.equals(pass))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }


}
