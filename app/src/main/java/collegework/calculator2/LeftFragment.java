package collegework.calculator2;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.zip.Inflater;

public class LeftFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstance)
    {
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.activity_left_fragment,viewGroup,false);
        return rootView;
    }
}
