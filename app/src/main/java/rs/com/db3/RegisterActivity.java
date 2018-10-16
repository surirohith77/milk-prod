package rs.com.db3;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    int edittext[]={R.id.Ret1,R.id.Ret2,R.id.Ret3,R.id.Ret4};
    String Values[] = new String[edittext.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void Register(View view) {

        int i;
        for(i=0;i<edittext.length;i++)
        {
            EditText et = findViewById(edittext[i]);
            String s1 = et.getText().toString().trim();
            if (s1.isEmpty())
            {
                et.setError("Empty");
                et.requestFocus();
                break;
            }
            else
            {
                Values[i]=s1;
                Log.e(""+i,Values[i]);
            }
        }

        if (i == edittext.length){


            ContentValues cv=new ContentValues();

           cv.put(Mydatabase.COL1,Values[0]);
            cv.put(Mydatabase.COL2,Values[1]);
            cv.put(Mydatabase.COL3,Values[2]);
            cv.put(Mydatabase.COL4,Values[3]);



            Mydatabase md=new Mydatabase(this);
            SQLiteDatabase db=md.getWritableDatabase();

          long result =  db.insert(Mydatabase.TABLE_NAME,null,cv);
        if (result != -1){

            Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
            for (int j=0;j<edittext.length;j++){

               EditText et= findViewById(edittext[j]);
               et.setText("");
            }

        }else {

            Toast.makeText(this, "failed to insert", Toast.LENGTH_SHORT).show();
        }




        }
    }

    public void bac(View view) {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
