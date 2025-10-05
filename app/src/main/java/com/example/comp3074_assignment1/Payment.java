package com.example.comp3074_assignment1;

import java.text.NumberFormat;
import java.util.Locale;
public class Payment {
    public final double hours;
    public final double rate;
    public final double pay;
    public final double overtime;
    public final double total;
    public final double tax;

    public Payment(double hours, double rate, double pay, double overtime, double total, double tax) {
        this.hours = hours;
        this.rate = rate;
        this.pay = pay;
        this.overtime = overtime;
        this.total = total;
        this.tax = tax;
    }

    @Override
    public String toString() {
        NumberFormat c = NumberFormat.getCurrencyInstance(Locale.CANADA);
        return "Hours: " + hours +
                "  |  Rate: " + c.format(rate) +
                "\nBase: " + c.format(pay) +
                "  OT: " + c.format(overtime) +
                "  Total: " + c.format(total) +
                "  Tax: " + c.format(tax);
    }

}
