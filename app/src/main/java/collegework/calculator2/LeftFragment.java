package collegework.calculator2;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LeftFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstance)
    {
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.activity_left_fragment,viewGroup,false);
        View view=getActivity().findViewById(R.id.input);
        View view2=getActivity().findViewById(R.id.answer);
        return rootView;
    }
}
