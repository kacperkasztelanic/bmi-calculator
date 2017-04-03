package pwr.kasztelanic.app1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

<<<<<<< HEAD
import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends Activity
{
    @BindView(R.id.about_version)
=======
import butterknife.ButterKnife;
import butterknife.InjectView;

public class AboutActivity extends Activity
{
    @InjectView(R.id.about_version)
>>>>>>> 1155a45db0432ac5b6b6dca40e2451fa29383c37
    TextView versionTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        //noinspection ConstantConditions
        getActionBar().setDisplayHomeAsUpEnabled(true);
<<<<<<< HEAD
        ButterKnife.bind(this);
=======
        ButterKnife.inject(this);
>>>>>>> 1155a45db0432ac5b6b6dca40e2451fa29383c37
        versionTV.setText(getString(R.string.about_version, BuildConfig.VERSION_NAME));
    }
}
