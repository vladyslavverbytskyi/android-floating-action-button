package com.getbase.floatingactionbutton.sample;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;


public class FloatingActionButtonMenuFragment extends DialogFragment {

    private static final String ARG_POS_X = "arg_x";
    private static final String ARG_POS_Y = "arg_y";

    private FloatingActionsMenu actionsMenu;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fab_menu_dialog, container, false);

        actionsMenu = view.findViewById(R.id.buttonMenu);
        //getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        actionsMenu.setOnFloatingActionsMenuUpdateListener(new FloatingActionsMenu.OnFloatingActionsMenuUpdateListener() {
            @Override
            public void onMenuExpanded() {

            }

            @Override
            public void onMenuCollapsed() {
                //dismissAllowingStateLoss();
            }
        });

        actionsMenu.postDelayed(new Runnable() {
            @Override
            public void run() {
                actionsMenu.toggle();
            }
        }, 125);
    }

    static FloatingActionButtonMenuFragment newInstance(View anchor) {

        int[] location = new int[2];

        anchor.getLocationOnScreen(location);

        int x = location[0];
        int y = location[1];

        Bundle arguments = new Bundle();
        arguments.putInt(ARG_POS_X, x);
        arguments.putInt(ARG_POS_Y, y);

        FloatingActionButtonMenuFragment dialog = new FloatingActionButtonMenuFragment();
        dialog.setArguments(arguments);

        return dialog;
    }
}
