package rs.com.db3;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
    }

    public void deleteus(View view) {

       EditText det1= findViewById(R.id.det1);


      Mydatabase md=new Mydatabase(this);
        SQLiteDatabase db=md.getReadableDatabase();

      int count =  db.delete(Mydatabase.TABLE_NAME,"ID = ?",
                new String[]{det1.getText().toString().trim()});

        if (count > 0){

            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "delete failed", Toast.LENGTH_SHORT).show();
        }


    }

    public void bacc(View view) {

        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
