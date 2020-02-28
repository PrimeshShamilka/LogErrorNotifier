package com.company.notifier;

import com.company.catcher.Catcher;
import com.company.catcher.ErrorCatcher;

import java.util.List;

public class NotifierFactory {
    public Notifier getInstance(String notifMethod) {
        Notifier notifier = null;
        switch (notifMethod) {
            case "email":
                notifier = new EmailNotifier();
                break;
            case "sms":
                notifier = new SMSNotifier();
                break;
        }
        return notifier;
    }
}
