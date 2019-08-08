package com.getbase.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LabeledFloatingActionButton extends FloatingActionButton {

    private String label;

    public LabeledFloatingActionButton(Context context) {
        this(context, null);
    }

    public LabeledFloatingActionButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public LabeledFloatingActionButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(AttributeSet attributeSet) {
        TypedArray attr = getContext().obtainStyledAttributes(attributeSet, R.styleable.LabeledFloatingActionButton, 0, 0);
        label = attr.getString(R.styleable.LabeledFloatingActionButton_fab_label);

        attr.recycle();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;

        TextView labelView = getLabelView();
        if (labelView != null) {
            labelView.setText(this.label);
        }
    }

    private TextView getLabelView() {
        return (TextView) getTag(R.id.fab_label);
    }
}
