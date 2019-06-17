package my.t.sportszillia;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String superUser = "admin";
    private static final String superPass = "admin";
    private static final int superFlag = 148;

    EditText userField, passField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        userField = findViewById(R.id.textfield_splash_user);
        passField = findViewById(R.id.textfield_splash_password);

        findViewById(R.id.button_splash).setOnClickListener(this);
    }

    private void LogIn(){
        String user = userField.getText().toString().trim();
        String pass = passField.getText().toString().trim();

        if(user.isEmpty()){
            userField.setError("Please enter a username");
            userField.requestFocus();
            return;
        }
        if(pass.isEmpty()){
            passField.setError("Please enter a password");
            passField.requestFocus();
            return;
        }
        if(user.equals(superUser) && pass.equals(superPass)){
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            intent.putExtra("ADMIN", superFlag);
            startActivity(intent);
        }else{
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            intent.putExtra("ADMIN", 1);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_splash:
                LogIn();
                break;
        }
    }
}
