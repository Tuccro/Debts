package com.tuccro.debts.ui.dialogs;

import android.app.AlertDialog;
import android.content.Context;

import com.tuccro.debts.core.Human;
import com.tuccro.debts.utils.timeUtils;

public class HumanInfoDialog extends AlertDialog {

    public HumanInfoDialog(Context context, Human human) {
        super(context);

        long time = human.getDateAdd();
        this.setMessage(timeUtils.getDateFromMillis(time) + " " +
                timeUtils.getTimeFromMillis(time));
    }
}

