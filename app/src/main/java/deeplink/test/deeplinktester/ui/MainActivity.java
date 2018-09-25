package deeplink.test.deeplinktester.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import deeplink.test.deeplinktester.R;
import deeplink.test.deeplinktester.util.UtilCommons;

public class MainActivity extends AppCompatActivity {
    AppCompatEditText deepLinkURI;
    ImageButton searchURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deepLinkURI = findViewById(R.id.deep_link_uri);
        searchURI = findViewById(R.id.hit_uri);

        searchURI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(deepLinkURI.getText()))
                    UtilCommons.StartDeepLink(deepLinkURI.getText().toString(), MainActivity.this);
            }
        });
    }
}
