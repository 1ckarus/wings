package ickarus.zordon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class dashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button menuButton= (Button) findViewById(R.id.menuButton);
        Button tasks = (Button) findViewById(R.id.logout_button);
        Button button3= (Button) findViewById(R.id.sButton);

        button3.setOnClickListener(new View.OnClickListener() {
                                       @Override public void onClick(View v) {
                                           startActivity(new Intent(dashBoard.this, Schedule.class));
                                       }
                                   }

        );

        tasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dashBoard.this, Tasks.class));
            }

        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(dashBoard.this, menuDrawer.class));
            }

        });
    }


}
